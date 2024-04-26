package com.zsw.netshop.product.mapper;

import com.zsw.netshop.model.entity.product.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    //查询所有的一级分类
    List<Category> selectOneCategory();

    //1 查询所有分类 返回list集合
    List<Category> findAll();
}
