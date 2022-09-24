package com.lsaac.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lsaac.domain.ResponseResult;
import com.lsaac.domain.entity.Comment;


/**
 * 评论表(Comment)表服务接口
 *
 * @author makejava
 * @since 2022-09-24 10:22:34
 */
public interface CommentService extends IService<Comment> {

    ResponseResult commentList(String CommentType, Long articleId, Integer pageNum, Integer pageSize);

    ResponseResult addComment(Comment comment);
}

