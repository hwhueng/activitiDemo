package com.hwhueng.activiti.service.imp;

import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwhueng.activiti.constrant.CacheNames;
import com.hwhueng.activiti.domain.AuthUser;
import com.hwhueng.activiti.mapper.AuthUserMapper;
import com.hwhueng.activiti.service.IAuthUserService;
import com.hwhueng.activiti.vo.EmpInfoVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthUserService extends ServiceImpl<AuthUserMapper, AuthUser> implements IAuthUserService {

    @Cached(name = CacheNames.empInfo, key="#empId", expire = 3600)
    public AuthUser getByEmpId(String empId){
        LambdaQueryWrapper<AuthUser> qwr = new LambdaQueryWrapper<>();
        AuthUser user = getOne(qwr.eq(AuthUser::getEmpid, empId));
        return user == null ? new AuthUser(): user;
    }

    /**
     * 根据名称模糊搜索员工信息
     * @param name 名字
     * @return List<EmpInfoVo>
     */
    public List<EmpInfoVo> getByName(String name){
        LambdaQueryWrapper<AuthUser> qwr = new LambdaQueryWrapper<>();
        qwr.like(AuthUser::getEname, name);
        return list(qwr).stream().map(o->{
            EmpInfoVo vo = new EmpInfoVo();
            vo.setEmpName(o.getEname());
            vo.setEmpId(o.getEmpid());
            vo.setDeptId(o.getOrgeh());
            vo.setDeptName(o.getOrgtx());
            vo.setDeptPath(o.getDeptpath());
            return vo;
        }).collect(Collectors.toList());
    }

}
