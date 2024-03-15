package com.zsw.netshop.manager.service.impl;

import com.zsw.netshop.manager.mapper.ProductUnitMapper;
import com.zsw.netshop.manager.service.ProductUnitService;
import com.zsw.netshop.model.entity.base.ProductUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductUnitServiceImpl implements ProductUnitService {

    @Autowired
    private ProductUnitMapper productUnitMapper;

    @Override
    public List<ProductUnit> findAll() {
        return productUnitMapper.findAll();
    }
}
