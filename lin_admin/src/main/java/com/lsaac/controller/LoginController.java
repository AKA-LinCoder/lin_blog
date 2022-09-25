package com.lsaac.controller;

import com.lsaac.domain.ResponseResult;
import com.lsaac.domain.entity.LoginUser;
//import com.lsaac.domain.entity.Menu;
import com.lsaac.domain.entity.User;
//import com.lsaac.domain.vo.AdminUserInfoVo;
//import com.lsaac.domain.vo.RoutersVo;
import com.lsaac.domain.vo.UserInfoVo;
import com.lsaac.enums.AppHttpCodeEnum;
import com.lsaac.exception.SystemException;
import com.lsaac.service.BlogLoginService;
import com.lsaac.service.LoginService;
//import com.lsaac.service.MenuService;
//import com.lsaac.service.RoleService;
import com.lsaac.utils.BeanCopyUtils;
import com.lsaac.utils.RedisCache;
import com.lsaac.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

//    @Autowired
//    private MenuService menuService;
//
//    @Autowired
//    private RoleService roleService;


    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){
        if(!StringUtils.hasText(user.getUserName())){
            //提示 必须要传用户名
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return loginService.login(user);
    }

    @PostMapping("/user/logout")
    public ResponseResult logout(){
        return loginService.logout();
    }



//    @GetMapping("getInfo")
//    public ResponseResult<AdminUserInfoVo> getInfo(){
//        //获取当前登录的用户
//        LoginUser loginUser = SecurityUtils.getLoginUser();
//        //根据用户id查询权限信息
//        List<String> perms = menuService.selectPermsByUserId(loginUser.getUser().getId());
//        //根据用户id查询角色信息
//        List<String> roleKeyList = roleService.selectRoleKeyByUserId(loginUser.getUser().getId());
//
//        //获取用户信息
//        User user = loginUser.getUser();
//        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(user, UserInfoVo.class);
//        //封装数据返回
//
//        AdminUserInfoVo adminUserInfoVo = new AdminUserInfoVo(perms,roleKeyList,userInfoVo);
//        return ResponseResult.okResult(adminUserInfoVo);
//    }
//
//
//    @GetMapping("getRouters")
//    public ResponseResult<RoutersVo> getRouters(){
//        Long userId = SecurityUtils.getUserId();
//        //查询menu 结果是tree的形式
//        List<Menu> menus = menuService.selectRouterMenuTreeByUserId(userId);
//        //封装数据返回
//        return ResponseResult.okResult(new RoutersVo(menus));
//    }

}
