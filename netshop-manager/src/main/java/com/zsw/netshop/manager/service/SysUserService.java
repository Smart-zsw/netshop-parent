package com.zsw.netshop.manager.service;

import com.github.pagehelper.PageInfo;
import com.zsw.netshop.model.dto.system.LoginDto;
import com.zsw.netshop.model.dto.system.SysUserDto;
import com.zsw.netshop.model.entity.system.SysUser;
import com.zsw.netshop.model.vo.system.LoginVo;

public interface SysUserService {

    //用户登录
    LoginVo login(LoginDto loginDto);

    //获取当前登陆用户信息
    SysUser getUserInfo(String token);

    //用户退出
    void logout(String token);

    //用户条件分页查询接口
    PageInfo<SysUser> findByPage(Integer pageNum, Integer pageSize, SysUserDto sysUserDto);

    //用户添加
    void saveSysUser(SysUser sysUser);

    //用户修改
    void updateSysUser(SysUser sysUser);

    //用户删除
    void deleteById(Long userId);
}
