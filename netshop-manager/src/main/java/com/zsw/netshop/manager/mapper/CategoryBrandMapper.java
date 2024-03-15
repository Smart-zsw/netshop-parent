package com.zsw.netshop.manager.mapper;

import com.zsw.netshop.model.dto.product.CategoryBrandDto;
import com.zsw.netshop.model.entity.product.Brand;
import com.zsw.netshop.model.entity.product.CategoryBrand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryBrandMapper {

    //分类品牌条件分页查询
    List<CategoryBrand> findByPage(CategoryBrandDto categoryBrandDto);

    //添加
    void save(CategoryBrand categoryBrand);

    //修改
    void updateById(CategoryBrand categoryBrand);

    //删除
    void deleteById(Long id);

    //根据分类id查询对应的品牌数据
    List<Brand> findBrandByCategoryId(Long categoryId);
}
