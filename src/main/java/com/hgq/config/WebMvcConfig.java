package com.hgq.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @ClassName com.hgq.config.WebMvcConfig
 * @Description: TODO
 * @Author: hgq
 * @Date: 2020-08-15 14:33
 * @Version: 1.0
 */
@Component
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/login");
    }

}
