package com.zsw.netshop.manager.service.impl;

import com.alibaba.fastjson.JSON;
import com.zsw.netshop.manager.mapper.SysUserMapper;
import com.zsw.netshop.manager.service.SysUserService;
import com.zsw.netshop.model.dto.system.LoginDto;
import com.zsw.netshop.model.entity.system.SysUser;
import com.zsw.netshop.model.vo.system.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    //用户登录
    @Override
    public LoginVo login(LoginDto loginDto) {

        //1 获取提交用户名，loginDto获取到
        String userName = loginDto.getUserName();

        //2 根据用户名查询数据库表 sys_user表
        SysUser sysUser = sysUserMapper.selectUserInfoByUserName(userName);

        //3 如果根据用户名查不到对应信息，用户不存在，返回错误信息
        if (sysUser == null) {
            throw new RuntimeException("用户名不存在");
        }

        //4 如果根据用户名查询到用户信息，用户存在
        //5 获取输入密码，比较输入的密码和数据库密码是否一致
        String database_password = sysUser.getPassword();
        String input_password = loginDto.getPassword();
        //把我们输入的密码进行加密，在比较数据库密码，md5
        input_password = DigestUtils.md5DigestAsHex(input_password.getBytes());

        //比较
        if (!input_password.equals(database_password)) {
            throw new RuntimeException("密码不正确");
        }

        //6 如果密码一致，登陆成功，如果密码不一致登陆失败
        //7 登陆成功，生成用户唯一标识token
        String token = UUID.randomUUID().toString().replaceAll("-","");

        //8 把登陆成功用户信息放到redis里面
        //key : token      value : 用户信息
        redisTemplate.opsForValue()
                .set("user:login"+token,
                        JSON.toJSONString(sysUser),
                        7,
                        TimeUnit.DAYS);

        //9 返回loginvo对象
        LoginVo loginVo = new LoginVo();
        loginVo.setToken(token);
        return loginVo;
    }
}
