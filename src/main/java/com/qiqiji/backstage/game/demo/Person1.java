package com.qiqiji.backstage.game.demo;

import lombok.Data;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * 将配置文件中配置的每一个属性的值,映射到这个组件中
 * @ConfigurationProperties: 告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定
 *      perfix = "person": 配置文件中哪个下面的所有属性进行一一映射 备注：默认从全局配置文件中获取
 * @PropertySource:从指定的配置文件目录获取
 *只有这个组件是容器中的组件,才能提供@ConfigurationProperties功能,所有要加@Component注解
 * */
@Component
//@ConfigurationProperties(prefix = "person")
@PropertySource(value={"classpath:person.yml"})
@Data
public class Person1 {
    private String lastName;
    private String age;
    private Boolean boss;
    private Date birth;
    private Map<String,Object> maps;
    private Dog dog;
}
