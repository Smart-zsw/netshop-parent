package com.zsw.netshop.manager.mapper;

import com.zsw.netshop.model.dto.product.CategoryBrandDto;
import com.zsw.netshop.model.entity.product.CategoryBrand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryBrandMapper {

    //分类品牌条件分页查询
    List<CategoryBrand> findByPage(CategoryBrandDto categoryBrandDto);
}
