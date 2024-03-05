package com.zsw.netshop.manager.service.impl;

import com.zsw.netshop.common.exception.ShopException;
import com.zsw.netshop.manager.mapper.SysMenuMapper;
import com.zsw.netshop.manager.service.SysMenuService;
import com.zsw.netshop.manager.utils.MenuHelper;
import com.zsw.netshop.model.entity.system.SysMenu;
import com.zsw.netshop.model.entity.system.SysUser;
import com.zsw.netshop.model.vo.common.ResultCodeEnum;
import com.zsw.netshop.model.vo.system.SysMenuVo;
import com.zsw.netshop.utils.AuthContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    //菜单列表
    @Override
    public List<SysMenu> findNodes() {
        //1 查询所有菜单，返回list集合
        List<SysMenu> sysMenuList = sysMenuMapper.findAll();
        if (CollectionUtils.isEmpty(sysMenuList)) {
            return null;
        }

        //2 调用工具类的方法，把返回list集合封装要求数据格式
        return MenuHelper.buildTree(sysMenuList);
    }

    //菜单添加
    @Override
    public void save(SysMenu sysMenu) {
        sysMenuMapper.save(sysMenu);
    }

    //菜单修改
    @Override
    public void update(SysMenu sysMenu) {
        sysMenuMapper.update(sysMenu);
    }

    //菜单删除
    @Override
    public void removeById(Long id) {
        //根据当前菜单id，查询是否包含子菜单
        int count = sysMenuMapper.selectCountById(id);

        //判断，count大于0，包含子菜单
        if (count > 0) {
            throw new ShopException(ResultCodeEnum.NODE_ERROR);
        }

        //count等于0，直接删除
        sysMenuMapper.delete(id);
    }

    //查询用户可操作的菜单
    @Override
    public List<SysMenuVo> findMenusByUserId() {
        //获取当前用户id
        SysUser sysUser = AuthContextUtil.get();
        Long userId = sysUser.getId();

        //根据userId查询可以操作的菜单
        List<SysMenu> syMenuList = sysMenuMapper.findMenusByUserId(userId);

        //封装要求数据格式，返回
        List<SysMenu> sysMenuList = MenuHelper.buildTree(syMenuList);
        return this.buildMenus(syMenuList);
    }

    // 将List<SysMenu>对象转换成List<SysMenuVo>对象
    private List<SysMenuVo> buildMenus(List<SysMenu> menus) {

        List<SysMenuVo> sysMenuVoList = new LinkedList<SysMenuVo>();
        for (SysMenu sysMenu : menus) {
            SysMenuVo sysMenuVo = new SysMenuVo();
            sysMenuVo.setTitle(sysMenu.getTitle());
            sysMenuVo.setName(sysMenu.getComponent());
            List<SysMenu> children = sysMenu.getChildren();
            if (!CollectionUtils.isEmpty(children)) {
                sysMenuVo.setChildren(buildMenus(children));
            }
            sysMenuVoList.add(sysMenuVo);
        }
        return sysMenuVoList;
    }
}
