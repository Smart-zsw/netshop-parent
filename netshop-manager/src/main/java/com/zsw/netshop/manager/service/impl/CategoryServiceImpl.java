package com.zsw.netshop.manager.service.impl;

import com.alibaba.excel.EasyExcel;
import com.zsw.netshop.common.exception.ShopException;
import com.zsw.netshop.manager.listener.ExcelListener;
import com.zsw.netshop.manager.mapper.CategoryMapper;
import com.zsw.netshop.manager.service.CategoryService;
import com.zsw.netshop.model.entity.product.Category;
import com.zsw.netshop.model.vo.common.ResultCodeEnum;
import com.zsw.netshop.model.vo.product.CategoryExcelVo;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
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

    //导出
    @Override
    public void exportData(HttpServletResponse response) {
        try {
            //1 设置响应头信息和其他信息
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");

            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("分类数据", "UTF-8");

            //设置响应头信息   Content-disposition
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

            //2 调用mapper 方法查询所有分类，返回list集合
            List<Category> categoryList = categoryMapper.findAll();

            //最终数据list集合
            List<CategoryExcelVo> categoryExcelVoList = new ArrayList<>();
            //List<Category> -- List<CategoryExcelVo>
            for (Category category : categoryList) {
                CategoryExcelVo categoryExcelVo = new CategoryExcelVo();
                //把category值获取出来，设置到categoryExcelVo里面
                //Long id = category.getId();
                //categoryExcelVo.setId(id);
                BeanUtils.copyProperties(category,categoryExcelVo);
                categoryExcelVoList.add(categoryExcelVo);
            }

            //3 调用EasyExcel的write方法完成写操作
            EasyExcel.write(response.getOutputStream(), CategoryExcelVo.class)
                    .sheet("分类数据").doWrite(categoryExcelVoList);

        }catch (Exception e) {
            e.printStackTrace();
            throw new ShopException(ResultCodeEnum.DATA_ERROR);
        }

    }

    //导入
    @Override
    public void importData(MultipartFile file) {
        //监听器
        ExcelListener<CategoryExcelVo> excelListener = new ExcelListener(categoryMapper);
        try {
            EasyExcel.read(file.getInputStream(), CategoryExcelVo.class,excelListener)
                    .sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ShopException(ResultCodeEnum.DATA_ERROR);
        }
    }
}
