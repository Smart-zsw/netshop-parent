package com.zsw.netshop.manager.service.impl;

import com.zsw.netshop.manager.mapper.CategoryMapper;
import com.zsw.netshop.manager.service.CategoryService;
import com.zsw.netshop.model.entity.product.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    //分类列表，每次查询一层
    @Override
    public List<Category> findCategoryList(Long id) {
        //1 根据id条件值进行查询，返回list集合
        // SELECT * FROM category WHERE parent_id=id
        List<Category> categoryList = categoryMapper.selectCategoryByParentId(id);

        //2 遍历返回的list集合，判断每个分类是否有下层分类，如果有设置hasChildren = true
        if (!CollectionUtils.isEmpty(categoryList)) {
            categoryList.forEach(category -> {
                //判断每个分类是否有下层分类
                // SELECT count(*) FROM category WHERE parent_id=id
                int count = categoryMapper.selectCountByParentId(category.getId());
                if (count > 0) {//下层分类
                    category.setHasChildren(true);
                } else {
                    category.setHasChildren(false);
                }
            });
        }
        return categoryList;
    }
}
