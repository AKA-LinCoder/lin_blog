package com.lsaac.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lsaac.domain.ResponseResult;
import com.lsaac.domain.entity.Link;


/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2022-09-19 14:57:33
 */
public interface LinkService extends IService<Link> {

    ResponseResult getAllLink();
}

