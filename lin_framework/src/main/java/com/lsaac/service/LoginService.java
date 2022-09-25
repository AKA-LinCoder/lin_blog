package com.lsaac.service;

import com.lsaac.domain.ResponseResult;
import com.lsaac.domain.entity.User;

public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();

}
