package com.zsw.netshop.product.service.impl;

import com.zsw.netshop.model.entity.product.Category;
import com.zsw.netshop.product.mapper.CategoryMapper;
import com.zsw.netshop.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    //查询所有的一级分类
    @Override
    public List<Category> selectOneCategory() {
        return categoryMapper.selectOneCategory();
    }
}
