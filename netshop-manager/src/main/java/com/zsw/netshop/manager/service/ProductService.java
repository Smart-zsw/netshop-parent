package com.zsw.netshop.manager.service;

import com.github.pagehelper.PageInfo;
import com.zsw.netshop.model.dto.product.ProductDto;
import com.zsw.netshop.model.entity.product.Product;

public interface ProductService {

    //列表（条件分页查询）
    PageInfo<Product> findByPage(Integer page, Integer limit, ProductDto productDto);
}
