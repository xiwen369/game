package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

//启动Hystrix断路器的功能
@RestController
@SpringBootApplication
@ComponentScan(basePackages = {
        "app",
        "com.qiqiji.backstage.game",
        "com.qiqiji.backstage.game.service",
        "com.qiqiji.backstage.game.service.impl"})
//扫描jpa资源接口
@EnableJpaRepositories("com.qiqiji.backstage.game.repository")
//扫描实体类
@EntityScan(basePackages={"com.qiqiji.backstage.game.entity"})
public class GameApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameApplication.class, args);
    }

    private CorsConfiguration buildConfig(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");
        return corsConfiguration;
    }
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",buildConfig());
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
