package com.hgq.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @ClassName com.hgq.config.SpringApplicationInitializer
 * @Description: TODO
 * @Author: hgq
 * @Date: 2020-08-15 14:45
 * @Version: 1.0
 */
@Component
public class SpringApplicationInitializer implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("spring-security启动成功……");
    }
}
