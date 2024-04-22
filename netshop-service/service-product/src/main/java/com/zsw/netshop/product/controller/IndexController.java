package com.zsw.netshop.product.controller;

import com.zsw.netshop.model.entity.product.Category;
import com.zsw.netshop.model.entity.product.ProductSku;
import com.zsw.netshop.model.vo.common.Result;
import com.zsw.netshop.model.vo.common.ResultCodeEnum;
import com.zsw.netshop.model.vo.h5.IndexVo;
import com.zsw.netshop.product.service.CategoryService;
import com.zsw.netshop.product.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "首页接口管理")
@RestController
@RequestMapping(value="/api/product/index")
@CrossOrigin    //解决跨域问题
public class IndexController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping
    public Result index() {
        //1 所有的一级分类
        List<Category> categoryList = categoryService.selectOneCategory();

        //2 根据销量排序，获取前10条记录
        List<ProductSku> productSkuList = productService.selectProductSkuBySale();

        //3 封装数据到Vo对象里面
        IndexVo indexVo = new IndexVo();
        indexVo.setCategoryList(categoryList);
        indexVo.setProductSkuList(productSkuList);
        return Result.build(indexVo, ResultCodeEnum.SUCCESS);
    }
}
