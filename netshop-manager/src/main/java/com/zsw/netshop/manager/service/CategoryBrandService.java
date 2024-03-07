package com.zsw.netshop.manager.service;

import com.github.pagehelper.PageInfo;
import com.zsw.netshop.model.dto.product.CategoryBrandDto;
import com.zsw.netshop.model.entity.product.CategoryBrand;

public interface CategoryBrandService {

    //分类品牌条件分页查询
    PageInfo<CategoryBrand> findByPage(Integer page, Integer limit, CategoryBrandDto categoryBrandDto);
}
