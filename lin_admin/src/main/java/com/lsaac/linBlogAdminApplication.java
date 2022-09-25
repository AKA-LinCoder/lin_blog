package com.lsaac;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/*
    前台启动类
 */
@SpringBootApplication
@MapperScan("com.lsaac.mapper")
@EnableSwagger2
public class linBlogAdminApplication {

    //消除控制台的警告
    public static void disableWarning() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            Unsafe u = (Unsafe) theUnsafe.get(null);

            Class cls = Class.forName("jdk.internal.module.IllegalAccessLogger");
            Field logger = cls.getDeclaredField("logger");
            u.putObjectVolatile(cls, u.staticFieldOffset(logger), null);
        } catch (Exception e) {
            // ignore
        }
    }


    public static void main(String[] args){
//        disableWarning();
        SpringApplication.run(linBlogAdminApplication.class,args);
    }
}
