package com.lsaac.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.lsaac.domain.entity.LoginUser;
import com.lsaac.domain.entity.LoginUser;
import com.lsaac.domain.entity.User;
import com.lsaac.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    //实际校验用户是否存在
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName,username);
        User user = userMapper.selectOne(queryWrapper);
        //判断是否存在用户
        if(Objects.isNull(user)){
            throw  new RuntimeException("用户不存在");
        }
        //返回用户信息
        //TODO 查询权限信息封装
        return new LoginUser(user);
    }
}
