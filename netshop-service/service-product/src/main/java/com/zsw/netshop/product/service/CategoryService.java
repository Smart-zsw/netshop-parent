package com.zsw.netshop.product.service;

import com.zsw.netshop.model.entity.product.Category;

import java.util.List;

public interface CategoryService {

    //1 所有的一级分类
    List<Category> selectOneCategory();

    //查询所有分类，树形封装
    List<Category> findCategoryTree();
}
