package com.zsw.netshop.manager.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysRoleUserMapper {

    //1 根据userId删除用户之前分配角色数据
    void deleteByUserId(Long userId);

    //2 重新分配新数据
    void doAssign(Long userId, Long roleId);
}
