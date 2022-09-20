package com.lsaac.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lsaac.domain.ResponseResult;
import com.lsaac.domain.entity.User;

public interface BlogLoginService {
    ResponseResult login(User user);
}
