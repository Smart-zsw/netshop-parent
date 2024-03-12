package com.zsw.netshop.manager.mapper;

import com.zsw.netshop.model.dto.product.ProductDto;
import com.zsw.netshop.model.entity.product.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    //列表（条件分页查询）
    List<Product> findByPage(ProductDto productDto);
}
