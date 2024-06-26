package com.zsw.netshop.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsw.netshop.manager.mapper.ProductSpecMapper;
import com.zsw.netshop.manager.service.ProductSpecService;
import com.zsw.netshop.model.entity.product.ProductSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSpecServiceImpl implements ProductSpecService {

    @Autowired
    private ProductSpecMapper productSpecMapper;

    //列表
    @Override
    public PageInfo<ProductSpec> findByPage(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<ProductSpec> list = productSpecMapper.findByPage();
        return new PageInfo<>(list);
    }

    //添加
    @Override
    public void save(ProductSpec productSpec) {
        productSpecMapper.save(productSpec);
    }

    //修改
    @Override
    public void updateById(ProductSpec productSpec) {
        productSpecMapper.update(productSpec);
    }

    //删除
    @Override
    public void deleteById(Long id) {
        productSpecMapper.delete(id);
    }

    @Override
    public List<ProductSpec> findAll() {
        return productSpecMapper.findAll();
    }
}
