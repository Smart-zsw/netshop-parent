package com.zsw.netshop.product.service;

import com.zsw.netshop.model.entity.product.ProductSku;

import java.util.List;

public interface ProductService {

    //2 根据销量排序，获取前10条记录
    List<ProductSku> selectProductSkuBySale();
}
