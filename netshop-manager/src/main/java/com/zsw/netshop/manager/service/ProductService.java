package com.zsw.netshop.manager.service;

import com.github.pagehelper.PageInfo;
import com.zsw.netshop.model.dto.product.ProductDto;
import com.zsw.netshop.model.entity.product.Product;

public interface ProductService {

    //列表（条件分页查询）
    PageInfo<Product> findByPage(Integer page, Integer limit, ProductDto productDto);

    //添加
    void save(Product product);

    //根据商品id查询商品信息
    Product getById(Long id);

    //保存修改数据
    void update(Product product);

    //删除商品
    void deleteById(Long id);

    //商品审核
    void updateAuditStatus(Long id, Integer auditStatus);

    //商品上下架
    void updateStatus(Long id, Integer status);
}
