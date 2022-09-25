package com.lsaac.controller;

import com.lsaac.annotation.SystemLog;
import com.lsaac.domain.ResponseResult;
import com.lsaac.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @GetMapping("/getAllLink")
    @SystemLog(businessName = "获取友链")
    public ResponseResult getAllLink(){
        return linkService.getAllLink();
    }
}
