package com.lsaac.controller;

import com.lsaac.domain.ResponseResult;
import com.lsaac.domain.entity.Comment;
import com.lsaac.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")

public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/commentList")
    public ResponseResult commentList(Long articleId,Integer pageNum,Integer pageSize){

        return  commentService.commentList(articleId,pageNum,pageSize);

    }


//    @RequestHeader((value = "token"),required = true)String token
    @PostMapping
    public ResponseResult comment(@RequestHeader(value = "token",required = true) String token, @RequestBody Comment comment){
        return commentService.addComment(comment);
    }
}
