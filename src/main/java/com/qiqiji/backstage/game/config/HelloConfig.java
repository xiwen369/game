package com.qiqiji.backstage.game.config;

import com.qiqiji.backstage.game.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  @Configuration：指明当前类是一个配置类，就是来代替之前的Spring配置文件
 *
 *  相当于在配置文件中<bean><bean/>标签添加注解
 */
@Configuration
public class HelloConfig {
    @Bean //此注解就是将方法的返回值添加到容器中，容器中这个组件的默认ID就是方法名
    public HelloService helloService(){
        return new HelloService();
    }
}
