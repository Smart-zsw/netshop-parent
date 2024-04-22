package com.zsw.netshop.product.service.impl;

import com.zsw.netshop.model.entity.product.ProductSku;
import com.zsw.netshop.product.mapper.ProductSkuMapper;
import com.zsw.netshop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductSkuMapper productSkuMapperer;

    //2 根据销量排序，获取前10条记录
    @Override
    public List<ProductSku> selectProductSkuBySale() {
        return productSkuMapperer.selectProductSkuBySale();
    }
}
