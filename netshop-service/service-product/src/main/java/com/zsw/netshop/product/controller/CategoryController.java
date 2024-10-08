package com.zsw.netshop.product.controller;

import com.zsw.netshop.model.entity.product.Category;
import com.zsw.netshop.model.vo.common.Result;
import com.zsw.netshop.model.vo.common.ResultCodeEnum;
import com.zsw.netshop.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/product/category")
@CrossOrigin    //解决跨域问题
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //查询所有分类，树形封装
    @GetMapping("/findCategoryTree")
    public Result findCategoryTree() {
        List<Category> list = categoryService.findCategoryTree();
        return Result.build(list, ResultCodeEnum.SUCCESS);
    }
}
