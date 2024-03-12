package com.zsw.netshop.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsw.netshop.manager.mapper.CategoryBrandMapper;
import com.zsw.netshop.manager.service.CategoryBrandService;
import com.zsw.netshop.model.dto.product.CategoryBrandDto;
import com.zsw.netshop.model.entity.product.CategoryBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryBrandServiceImpl implements CategoryBrandService {

    @Autowired
    private CategoryBrandMapper categoryBrandMapper;

    //分类品牌条件分页查询
    @Override
    public PageInfo<CategoryBrand> findByPage(Integer page,
                                              Integer limit,
                                              CategoryBrandDto categoryBrandDto) {
        PageHelper.startPage(page,limit);
        List<CategoryBrand> list = categoryBrandMapper.findByPage(categoryBrandDto);
        PageInfo<CategoryBrand> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    //添加
    @Override
    public void save(CategoryBrand categoryBrand) {
        categoryBrandMapper.save(categoryBrand);
    }

    //修改
    @Override
    public void updateById(CategoryBrand categoryBrand) {
        categoryBrandMapper.updateById(categoryBrand);
    }

    //删除
    @Override
    public void deleteById(Long id) {
        categoryBrandMapper.deleteById(id);
    }


}
