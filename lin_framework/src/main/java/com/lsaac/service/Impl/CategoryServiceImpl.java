package com.lsaac.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsaac.constants.SystemConstants;
import com.lsaac.domain.ResponseResult;
import com.lsaac.domain.entity.Article;
import com.lsaac.domain.entity.Category;
import com.lsaac.domain.vo.CategoryVo;
import com.lsaac.mapper.CategoryMapper;
import com.lsaac.service.ArticleService;
import com.lsaac.service.CategoryService;
import com.lsaac.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 分类表(Category)表服务实现类
 *
 * @author makejava
 * @since 2022-09-18 17:07:24
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private ArticleService articleService;
    
    @Override
    public ResponseResult getCategoryList() {
        //查询文章表，状态为已发布的文章
        LambdaQueryWrapper<Article> articleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        articleLambdaQueryWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        List<Article> articleList =  articleService.list(articleLambdaQueryWrapper);
        //获取文章分类id，并且去重

        Set<Long> categoryIds = articleList.stream().map(new Function<Article, Long>() {
            @Override
            public Long apply(Article article) {
                Long categoryId = article.getCategoryId();
                return categoryId;
            }
        }).collect(Collectors.toSet());
        //查询分类表
        List<Category> categories = listByIds(categoryIds);
        categories.stream().filter(category -> SystemConstants.STATUS_NORMAL.equals(category.getStatus())).collect(Collectors.toList());
        //封装vo
        List<CategoryVo> categoryVos = BeanCopyUtils.copyBeanList(categories, CategoryVo.class);
        return ResponseResult.okResult(categoryVos);
    }
}
