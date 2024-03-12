package com.zsw.netshop.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsw.netshop.manager.mapper.ProductMapper;
import com.zsw.netshop.manager.service.ProductService;
import com.zsw.netshop.model.dto.product.ProductDto;
import com.zsw.netshop.model.entity.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    //列表（条件分页查询）
    @Override
    public PageInfo<Product> findByPage(Integer page,
                                        Integer limit,
                                        ProductDto productDto) {
        PageHelper.startPage(page,limit);
        List<Product> list = productMapper.findByPage(productDto);
        return new PageInfo<>(list);
    }
}
