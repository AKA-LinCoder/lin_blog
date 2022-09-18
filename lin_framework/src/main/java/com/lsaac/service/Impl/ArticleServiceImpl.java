package com.lsaac.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsaac.domin.entity.Article;
import com.lsaac.domin.entity.ResponseResult;
import com.lsaac.mapper.ArticleMapper;
import com.lsaac.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Override
    public ResponseResult hotArticleList() {
        //查询热门文章,封装
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //必须是正式文章
        queryWrapper.eq(Article::getStatus,0);
        //按照浏览量进行排序
        queryWrapper.orderByDesc(Article::getViewCount);
        //最多查10条数据
        Page<Article> page = new Page(1,10);
        page(page,queryWrapper);
        List<Article> articles = page.getRecords();
        return ResponseResult.okResult(articles);
    }
}
