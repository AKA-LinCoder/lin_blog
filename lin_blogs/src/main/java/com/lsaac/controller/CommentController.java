package com.lsaac.controller;

import com.lsaac.annotation.SystemLog;
import com.lsaac.constants.SystemConstants;
import com.lsaac.domain.ResponseResult;
import com.lsaac.domain.dto.AddCommentDto;
import com.lsaac.domain.entity.Comment;
import com.lsaac.service.CommentService;
import com.lsaac.utils.BeanCopyUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@Api(tags = "评论",description = "评论相关接口")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/commentList")
    @SystemLog(businessName = "获取文章评论")
    public ResponseResult commentList(Long articleId,Integer pageNum,Integer pageSize){

        return  commentService.commentList(SystemConstants.ARTICLE_COMMENT, articleId,pageNum,pageSize);

    }


//    @RequestHeader((value = "token"),required = true)String token
    @PostMapping
    @SystemLog(businessName = "添加评论")
    public ResponseResult comment(@RequestHeader(value = "token",required = true) String token, @RequestBody AddCommentDto addCommentDto){
        Comment comment = BeanCopyUtils.copyBean(addCommentDto, Comment.class);
        return commentService.addComment(comment);
    }


    @GetMapping("/linkCommentList")
    @ApiOperation(value = "友链评论列表",notes = "获取一页友链评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "页号"),
            @ApiImplicitParam(name = "pageSize",value = "每页大小")
    }
    )
    @SystemLog(businessName = "友链评论列表")
    public ResponseResult linkCommentList(Integer pageNum,Integer pageSize){
        return commentService.commentList(SystemConstants.LINK_COMMENT,null,pageNum,pageSize);
    }
}
