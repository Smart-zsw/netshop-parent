package com.zsw.netshop.product.mapper;

import com.zsw.netshop.model.entity.product.ProductSku;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductSkuMapper {

    //2 根据销量排序，获取前10条记录
    List<ProductSku> selectProductSkuBySale();
}
