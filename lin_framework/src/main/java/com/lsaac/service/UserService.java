package com.lsaac.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lsaac.domain.ResponseResult;
import com.lsaac.domain.entity.User;


/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2022-09-24 10:45:22
 */
public interface UserService extends IService<User> {

    ResponseResult userInfo();

    ResponseResult updateUserInfo(User user);

    ResponseResult register(User user);
}

