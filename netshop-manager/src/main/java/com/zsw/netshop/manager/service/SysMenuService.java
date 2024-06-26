package com.zsw.netshop.manager.service;

import com.zsw.netshop.model.entity.system.SysMenu;
import com.zsw.netshop.model.vo.system.SysMenuVo;

import java.util.List;

public interface SysMenuService {

    //菜单列表
    List<SysMenu> findNodes();

    //菜单添加
    void save(SysMenu sysMenu);

    //菜单修改
    void update(SysMenu sysMenu);

    //菜单删除
    void removeById(Long id);

    //查询用户可操作的菜单
    List<SysMenuVo> findMenusByUserId();
}
