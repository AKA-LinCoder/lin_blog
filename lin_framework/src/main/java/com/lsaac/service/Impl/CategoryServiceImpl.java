package com.lsaac.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsaac.domain.entity.Category;
import com.lsaac.mapper.CategoryMapper;
import com.lsaac.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * 分类表(Category)表服务实现类
 *
 * @author makejava
 * @since 2022-09-18 17:07:24
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
