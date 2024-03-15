package com.zsw.netshop.manager.service;

import com.github.pagehelper.PageInfo;
import com.zsw.netshop.model.dto.product.CategoryBrandDto;
import com.zsw.netshop.model.entity.product.Brand;
import com.zsw.netshop.model.entity.product.CategoryBrand;

import java.util.List;

public interface CategoryBrandService {

    //分类品牌条件分页查询
    PageInfo<CategoryBrand> findByPage(Integer page, Integer limit, CategoryBrandDto categoryBrandDto);

    //添加
    void save(CategoryBrand categoryBrand);

    //修改
    void updateById(CategoryBrand categoryBrand);

    //删除
    void deleteById(Long id);

    //根据分类id查询对应的品牌数据
    List<Brand> findBrandByCategoryId(Long categoryId);
}
