package com.lsaac.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lsaac.domin.entity.Article;
import com.lsaac.domin.ResponseResult;

public interface ArticleService extends IService<Article> {
    ResponseResult hotArticleList();
}
