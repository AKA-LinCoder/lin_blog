package com.lsaac.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsaac.constants.SystemConstants;
import com.lsaac.domain.ResponseResult;
import com.lsaac.domain.vo.LinkVo;
import com.lsaac.mapper.LinkMapper;
import com.lsaac.service.LinkService;
import com.lsaac.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;
import com.lsaac.domain.entity.Link;

import java.util.List;

/**
 * 友链(Link)表服务实现类
 *
 * @author makejava
 * @since 2022-09-19 14:57:35
 */
@Service("linkService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

    @Override
    public ResponseResult getAllLink() {
        LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Link::getStatus, SystemConstants.LINK_STATUS_NORMAL);
        List<Link> links = list(queryWrapper);
        //转化vo
        List<LinkVo> linkVos = BeanCopyUtils.copyBeanList(links, LinkVo.class);
        return ResponseResult.okResult(linkVos);
    }
}
