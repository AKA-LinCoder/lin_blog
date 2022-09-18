package com.lsaac.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsaac.domin.entity.Article;
import com.lsaac.mapper.ArticleMapper;
import com.lsaac.service.ArticleService;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
}
