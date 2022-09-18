package com.lsaac.controller;

import com.lsaac.domin.entity.Article;
import com.lsaac.domin.entity.ResponseResult;
import com.lsaac.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/hotArticleList")
    public ResponseResult hotArticleList(){

       ResponseResult result =   articleService.hotArticleList();
       return result;
    }
}
