package com.lsaac.controller;

import com.lsaac.annotation.SystemLog;
import com.lsaac.domain.ResponseResult;
import com.lsaac.domain.entity.User;
import com.lsaac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/userInfo")
    @SystemLog(businessName = "查询用户信息")
    public ResponseResult userInfo(){

        return userService.userInfo();
    }

    @PutMapping("/updateUserInfo")
    @SystemLog(businessName = "更新用户信息")
    public ResponseResult updateUserInfo(@RequestBody User user){
        return userService.updateUserInfo(user);
    }
//    @PutMapping("/userInfo")
//    @SystemLog(businessName = "更新用户信息")
//    public ResponseResult updateUserInfo(@RequestBody User user){
//        return userService.updateUserInfo(user);
//    }
//
    @PostMapping("/register")
    public ResponseResult register(@RequestBody User user){
        return userService.register(user);
    }
}
