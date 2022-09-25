package com.lsaac.controller;

import com.lsaac.annotation.SystemLog;
import com.lsaac.domain.ResponseResult;
import com.lsaac.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UploadController {


    @Autowired
    private UploadService uploadService;

    @PostMapping("/upload")
    @SystemLog(businessName = "上传图片")
    public ResponseResult uploadImg(MultipartFile img) throws IOException {
        return uploadService.uploadImg(img);
    }
}
