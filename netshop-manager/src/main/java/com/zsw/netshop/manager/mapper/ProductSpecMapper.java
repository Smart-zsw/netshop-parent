package com.zsw.netshop.manager.mapper;

import com.zsw.netshop.model.entity.product.ProductSpec;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductSpecMapper {

    //列表
    List<ProductSpec> findByPage();

    //添加
    void save(ProductSpec productSpec);

    //修改
    void update(ProductSpec productSpec);

    //修改
    void delete(Long id);

    List<ProductSpec> findAll();
}
