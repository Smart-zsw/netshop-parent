package com.zsw.netshop.manager.service;

import com.github.pagehelper.PageInfo;
import com.zsw.netshop.model.entity.product.ProductSpec;

import java.util.List;

public interface ProductSpecService {

    //列表
    PageInfo<ProductSpec> findByPage(Integer page, Integer limit);

    //添加
    void save(ProductSpec productSpec);

    //修改
    void updateById(ProductSpec productSpec);

    //删除
    void deleteById(Long id);

    List<ProductSpec> findAll();
}
