package com.zsw.netshop.manager.mapper;

import com.zsw.netshop.model.entity.system.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysMenuMapper {

    //1 查询所有菜单，返回list集合
    List<SysMenu> findAll();
}
