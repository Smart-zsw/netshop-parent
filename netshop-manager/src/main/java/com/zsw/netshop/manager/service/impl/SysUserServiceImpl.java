package com.zsw.netshop.manager.service.impl;

import com.zsw.netshop.manager.mapper.SysUserMapper;
import com.zsw.netshop.manager.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
}
