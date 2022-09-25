package com.lsaac.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsaac.mapper.TagMapper;
import com.lsaac.service.TagService;
import org.springframework.stereotype.Service;
import com.lsaac.domain.entity.Tag;

/**
 * 标签(Tag)表服务实现类
 *
 * @author makejava
 * @since 2022-09-25 13:50:43
 */
@Service("tagService")
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}
