package com.lsaac.handler.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.lsaac.utils.SecurityUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/*
当要进行插入时，自动对部分值进行更新赋值
当进行更新时，更新时间
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Long userId = null;
        try {
            userId = SecurityUtils.getUserId();
        } catch (Exception e) {
            e.printStackTrace();
            userId = -1L;//表示是自己创建
        }
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("createBy",userId , metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("updateBy", userId, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName(" ", SecurityUtils.getUserId(), metaObject);
    }
}