package com.zsw.netshop.manager.controller;

import com.github.pagehelper.PageInfo;
import com.zsw.netshop.manager.service.SysUserService;
import com.zsw.netshop.model.dto.system.SysUserDto;
import com.zsw.netshop.model.entity.system.SysUser;
import com.zsw.netshop.model.vo.common.Result;
import com.zsw.netshop.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin/system/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    //1.用户条件分页查询接口
    @GetMapping(value = "/findByPage/{pageNum}/{pageSize}")
    public Result findByPage(@PathVariable("pageNum") Integer pageNum,
                             @PathVariable("pageSize") Integer pageSize,
                             SysUserDto sysUserDto) {
        PageInfo<SysUser> pageInfo = sysUserService.findByPage(pageNum,pageSize,sysUserDto);
        return Result.build(pageInfo, ResultCodeEnum.SUCCESS);
    }
    //2.用户添加

    //3.用户修改

    //4.用户删除
}
