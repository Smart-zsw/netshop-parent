package com.zsw.netshop.manager.mapper;

import com.zsw.netshop.model.dto.system.SysUserDto;
import com.zsw.netshop.model.entity.system.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper {

    //根据用户名查询数据库表 sys_user表
    SysUser selectUserInfoByUserName(String userName);

    //用户条件分页查询接口
    List<SysUser> findByPage(SysUserDto sysUserDto);
}
