package com.zsw.netshop.manager.service;

import com.zsw.netshop.model.entity.product.Category;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public interface CategoryService {

    //分类列表，每次查询一层
    List<Category> findCategoryList(Long id);

    //导出
    void exportData(HttpServletResponse response);
}
