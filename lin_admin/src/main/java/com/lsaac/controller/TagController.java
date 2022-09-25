package com.lsaac.controller;

import com.lsaac.domain.ResponseResult;
import com.lsaac.domain.entity.Tag;
import com.lsaac.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/content/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/list")
    public ResponseResult list(){
        List<Tag> tagList = tagService.list();
        return ResponseResult.okResult(tagList);
    }
}
