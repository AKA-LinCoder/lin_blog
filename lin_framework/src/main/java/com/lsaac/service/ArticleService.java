package com.lsaac.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lsaac.domain.entity.Article;
import com.lsaac.domain.ResponseResult;

public interface ArticleService extends IService<Article> {
    ResponseResult hotArticleList();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getArticleDetail(Long id);
}
