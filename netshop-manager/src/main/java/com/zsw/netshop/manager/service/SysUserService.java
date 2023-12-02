package com.zsw.netshop.manager.service;

import com.zsw.netshop.model.dto.system.LoginDto;
import com.zsw.netshop.model.entity.system.SysUser;
import com.zsw.netshop.model.vo.system.LoginVo;

public interface SysUserService {

    //用户登录
    LoginVo login(LoginDto loginDto);

    //获取当前登陆用户信息
    SysUser getUserInfo(String token);

    //用户退出
    void logout(String token);
}
