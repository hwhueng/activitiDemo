package com.hwhueng.activiti.service.imp;


import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.hwhueng.activiti.constant.CacheNames;
import com.hwhueng.activiti.constant.DefaultValue;
import com.hwhueng.activiti.domain.DeptInfo;
import com.hwhueng.activiti.mapper.DeptInfoMapper;
import com.hwhueng.activiti.service.IDeptInfoService;
import com.hwhueng.activiti.vo.OrgTreeVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DeptInfoServiceImpl extends ServiceImpl<DeptInfoMapper, DeptInfo> implements IDeptInfoService {

    public List<DeptInfo> getAllOrgInfo(){
        return list();
    }

    @Cached(name = CacheNames.orgMap, key = "method.name")
    public Map<String, DeptInfo> allDeptMap(){
        List<DeptInfo> allDept = list();
        return allDept.stream().collect(Collectors.toMap(DeptInfo::getDeptId, o->o, (k1, k2)->k1));
    }


    @Cached(name = CacheNames.orgTree, key = "method.name")
    public List<OrgTreeVo> getOrgTreeVo(){
        // Map<String, List<OrgTreeVo>> orgTreeMap = Maps.newHashMap();
        List<DeptInfo> allDept = getAllOrgInfo();
        // Map<String, MdmOrgInfo> orgInfoMap = allOrg.stream().collect(Collectors.toMap(MdmOrgInfo::getOBJID, o->o, (k1, k2)->k1));
        Map<String, List<DeptInfo>> deptInfoMap = allDept.stream().filter(o-> StringUtils.isNotEmpty(o.getParentId()))
                .collect(Collectors.groupingBy(DeptInfo::getParentId));
        // 获取所有BG
        String parent = DefaultValue.baseDeptId;
        List<DeptInfo> bgList = allDept.stream().filter(o-> parent.equals(o.getParentId())).collect(Collectors.toList());
        List<OrgTreeVo> res = Lists.newArrayList();
        OrgTreeVo root = new OrgTreeVo();
        root.setDeptId(parent);
        root.setDeptName("Corp");
        root.setParentId(null);
        root.setChildrenList(Lists.newArrayList());
        List<OrgTreeVo> voList = root.getChildrenList();
        for(DeptInfo info: bgList){
            OrgTreeVo treeVo = new OrgTreeVo();
            treeVo.setParentId(parent);
            treeVo.setDeptId(info.getDeptId());
            treeVo.setDeptName(info.getDeptName());
            treeVo.setChildrenList(Lists.newArrayList());
            voList.add(treeVo);
            getChild(info.getDeptId(), deptInfoMap, treeVo.getChildrenList());
        }
        res.add(root);
        return res;
    }

    private void getChild(String parent, Map<String, List<DeptInfo>> orgInfoMap, List<OrgTreeVo> voList){
        List<DeptInfo> childList = orgInfoMap.get(parent);
        if(CollectionUtils.isEmpty(childList)){
            return;
        }

        for(DeptInfo info: childList){
            OrgTreeVo treeVo = new OrgTreeVo();
            treeVo.setParentId(parent);
            treeVo.setDeptId(info.getDeptId());
            treeVo.setDeptName(info.getDeptName());
            treeVo.setChildrenList(Lists.newArrayList());
            voList.add(treeVo);
            getChild(info.getDeptId(), orgInfoMap, treeVo.getChildrenList());
        }
    }
}
