package com.zsw.netshop.manager.mapper;

import com.zsw.netshop.model.dto.product.ProductDto;
import com.zsw.netshop.model.entity.product.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    //列表（条件分页查询）
    List<Product> findByPage(ProductDto productDto);

    //1 保存商品基本信息 product表
    void save(Product product);

    //1 根据id查询商品基本信息 product
    Product findProductById(Long id);

    //修改 prduct
    void updateById(Product product);

    //1 根据商品id删除product表
    void deleteById(Long id);
}
