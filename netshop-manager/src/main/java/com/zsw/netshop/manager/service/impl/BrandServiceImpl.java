package com.zsw.netshop.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsw.netshop.manager.mapper.BrandMapper;
import com.zsw.netshop.manager.service.BrandService;
import com.zsw.netshop.model.entity.product.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    //列表
    @Override
    public PageInfo<Brand> findByPage(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Brand> list = brandMapper.findByPage();
        return new PageInfo<>(list);
    }

    //添加
    @Override
    public void save(Brand brand) {
        brandMapper.save(brand);
    }

    //修改
    @Override
    public void updateById(Brand brand) {
        brandMapper.updateById(brand);
    }

    //删除
    @Override
    public void deleteById(Long id) {
        brandMapper.deleteById(id) ;
    }
}
