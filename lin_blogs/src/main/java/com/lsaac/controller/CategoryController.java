package com.lsaac.controller;

import com.lsaac.annotation.SystemLog;
import com.lsaac.domain.ResponseResult;
import com.lsaac.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @GetMapping("/getCategoryList")
    @SystemLog(businessName = "获取分类列表")
    public ResponseResult getCategoryList(){
        return categoryService.getCategoryList();
    }
}
