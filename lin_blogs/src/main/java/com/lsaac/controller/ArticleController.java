package com.lsaac.controller;

import com.lsaac.annotation.SystemLog;
import com.lsaac.domain.ResponseResult;
import com.lsaac.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/hotArticleList")
    @SystemLog(businessName = "获取热门文章列表")
    public ResponseResult hotArticleList(){

       ResponseResult result =   articleService.hotArticleList();
       return result;
    }

    @GetMapping("/articleList")
    @SystemLog(businessName = "获取文章列表")
    public ResponseResult articleList(Integer pageNum,Integer pageSize,Long categoryId){
        ResponseResult result = articleService.articleList(pageNum,pageSize,categoryId);
        return result;
    }

    @GetMapping("/{id}")
    @SystemLog(businessName = "根据文章id获取文章内容")
    public ResponseResult  getArticleDetail(@PathVariable("id") Long id){
        ResponseResult result = articleService.getArticleDetail(id);
        return result;
    }

    @PutMapping("/updateViewCount/{id}")
    public ResponseResult updateViewCount(@PathVariable Long id){
        return articleService.updateViewCount(id);
    }

}
