package com.hwhueng.activiti.service.imp;

import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwhueng.activiti.constant.CacheNames;
import com.hwhueng.activiti.domain.DeptInfo;
import com.hwhueng.activiti.domain.EmpInfo;
import com.hwhueng.activiti.mapper.EmpInfoMapper;
import com.hwhueng.activiti.service.IDeptInfoService;
import com.hwhueng.activiti.service.IEmpInfoService;
import com.hwhueng.activiti.vo.EmpInfoVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmpInfoServiceImpl extends ServiceImpl<EmpInfoMapper, EmpInfo> implements IEmpInfoService {

    @Resource
    IDeptInfoService deptInfoService;

    @Cached(name = CacheNames.empInfo, key="#empId", expire = 3600)
    public EmpInfo getByEmpId(String empId){
        LambdaQueryWrapper<EmpInfo> qwr = new LambdaQueryWrapper<>();
        EmpInfo user = getOne(qwr.eq(EmpInfo::getEmpId, empId));
        return user == null ? new EmpInfo(): user;
    }

    /**
     * search name
     * @param name empName
     * @return List<EmpInfoVo>
     */
    public List<EmpInfoVo> getByName(String name){
        LambdaQueryWrapper<EmpInfo> qwr = new LambdaQueryWrapper<>();
        qwr.like(EmpInfo::getEmpName, name);
        Map<String, DeptInfo> allOrgMap = deptInfoService.allDeptMap();
        return list(qwr).stream().map(o->{
            EmpInfoVo vo = new EmpInfoVo();
            vo.setEmpName(o.getEmpName());
            vo.setEmpId(o.getEmpId());
            vo.setDeptId(o.getDeptId());
            DeptInfo orgInfo = allOrgMap.getOrDefault(o.getDeptId(), new DeptInfo());
            vo.setDeptName(orgInfo.getDeptName());
            vo.setDeptPath(orgInfo.getDeptPath());
            return vo;
        }).collect(Collectors.toList());
    }
}
