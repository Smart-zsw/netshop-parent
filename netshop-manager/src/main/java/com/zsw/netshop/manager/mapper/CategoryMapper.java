package com.zsw.netshop.manager.mapper;

import com.zsw.netshop.model.entity.product.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    //根据id条件值进行查询，返回list集合
    List<Category> selectCategoryByParentId(Long id);

    //判断每个分类是否有下层分类
    int selectCountByParentId(Long id);

    //调用mapper 方法查询所有分类，返回list集合
    List<Category> findAll();
}
