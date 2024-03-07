package com.zsw.netshop.manager.controller;

import com.github.pagehelper.PageInfo;
import com.zsw.netshop.manager.service.CategoryBrandService;
import com.zsw.netshop.model.dto.product.CategoryBrandDto;
import com.zsw.netshop.model.entity.product.CategoryBrand;
import com.zsw.netshop.model.vo.common.Result;
import com.zsw.netshop.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin/product/categoryBrand")
public class CategoryBrandController {

    @Autowired
    private CategoryBrandService categoryBrandService;

    //分类品牌条件分页查询
    @GetMapping("/{page}/{limit}")
    public Result findByPage(@PathVariable Integer page,
                             @PathVariable Integer limit,
                             CategoryBrandDto categoryBrandDto) {
        PageInfo<CategoryBrand> pageInfo = categoryBrandService.findByPage(page, limit, categoryBrandDto);
        return Result.build(pageInfo, ResultCodeEnum.SUCCESS);
    }
}
