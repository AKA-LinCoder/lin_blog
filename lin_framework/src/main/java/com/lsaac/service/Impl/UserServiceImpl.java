package com.lsaac.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsaac.domain.entity.User;
import com.lsaac.mapper.UserMapper;
import com.lsaac.service.UserService;
import org.springframework.stereotype.Service;


/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2022-09-24 10:45:22
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
