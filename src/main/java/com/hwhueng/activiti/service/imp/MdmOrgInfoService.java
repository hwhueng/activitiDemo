package com.hwhueng.activiti.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hwhueng.activiti.constrant.CacheNames;
import com.hwhueng.activiti.domain.MdmOrgInfo;
import com.hwhueng.activiti.mapper.MdmOrgInfoMapper;
import com.hwhueng.activiti.service.IMdmOrgInfoService;
import com.hwhueng.activiti.vo.OrgTreeVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MdmOrgInfoService extends ServiceImpl<MdmOrgInfoMapper, MdmOrgInfo> implements IMdmOrgInfoService {

    // @Cacheable(value = CacheNames.)
    public List<MdmOrgInfo> getAllOrgInfo(){
        return list();
    }


    @Cacheable(value = CacheNames.orgTree, key = "methodName")
    public List<OrgTreeVo> getOrgTreeVo(){
        Map<String, List<OrgTreeVo>> orgTreeMap = Maps.newHashMap();
        List<MdmOrgInfo> allOrg = getAllOrgInfo();
        // Map<String, MdmOrgInfo> orgInfoMap = allOrg.stream().collect(Collectors.toMap(MdmOrgInfo::getOBJID, o->o, (k1, k2)->k1));
        Map<String, List<MdmOrgInfo>> orgInfoMap = allOrg.stream().filter(o-> StringUtils.isNotEmpty(o.getPARENT()))
                .collect(Collectors.groupingBy(MdmOrgInfo::getPARENT));
        // 获取所有BG
        List<MdmOrgInfo> bgList = allOrg.stream().filter(o->"20200000".equals(o.getPARENT())).collect(Collectors.toList());
        List<OrgTreeVo> res = Lists.newArrayList();
        OrgTreeVo root = new OrgTreeVo();
        String parent = "20200000";
        root.setDeptId(parent);
        root.setDeptName("集团");
        root.setParentId(null);
        root.setChildrenList(Lists.newArrayList());
        List<OrgTreeVo> voList = root.getChildrenList();
        for(MdmOrgInfo info: bgList){
            OrgTreeVo treeVo = new OrgTreeVo();
            treeVo.setParentId(parent);
            treeVo.setDeptId(info.getOBJID());
            treeVo.setDeptName(info.getSTEXT());
            treeVo.setChildrenList(Lists.newArrayList());
            voList.add(treeVo);
            getChild(info.getOBJID(), orgInfoMap, treeVo.getChildrenList());
        }
        res.add(root);
        return res;
    }

    private void getChild(String parent, Map<String, List<MdmOrgInfo>> orgInfoMap, List<OrgTreeVo> voList){
        List<MdmOrgInfo> childList = orgInfoMap.get(parent);
        if(CollectionUtils.isEmpty(childList)){
            return;
        }

        for(MdmOrgInfo info: childList){
            OrgTreeVo treeVo = new OrgTreeVo();
            treeVo.setParentId(parent);
            treeVo.setDeptId(info.getOBJID());
            treeVo.setDeptName(info.getSTEXT());
            treeVo.setChildrenList(Lists.newArrayList());
            voList.add(treeVo);
            getChild(info.getOBJID(), orgInfoMap, treeVo.getChildrenList());
        }
    }
}
