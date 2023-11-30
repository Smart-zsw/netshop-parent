package com.zsw.netshop.manager.service;

import com.zsw.netshop.model.dto.system.LoginDto;
import com.zsw.netshop.model.vo.system.LoginVo;

public interface SysUserService {

    //用户登录
    LoginVo login(LoginDto loginDto);
}
