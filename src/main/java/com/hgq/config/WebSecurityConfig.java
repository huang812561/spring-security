package com.hgq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @ClassName com.hgq.config.WebSecurityFilter
 * @Description: TODO
 * @Author: hgq
 * @Date: 2020-08-15 15:28
 * @Version: 1.0
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 内存登录
     * @return
     */
//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("hgq").password("123").authorities("p1").build());
//        manager.createUser(User.withUsername("admin").password("admin123").authorities("p2").build());
//        return manager;
//    }

    /**
     * 密码验证方式
     *
     * @return
     */
    @Bean
    protected DelegatingPasswordEncoder passwordEncoder(){
        DelegatingPasswordEncoder passwordEncoder = (DelegatingPasswordEncoder) PasswordEncoderFactories.createDelegatingPasswordEncoder();
        //不加密方式验证
        passwordEncoder.setDefaultPasswordEncoderForMatches(NoOpPasswordEncoder.getInstance());
        passwordEncoder.setDefaultPasswordEncoderForMatches(new BCryptPasswordEncoder());
        return passwordEncoder;
    }

    /**
     * 授权配置
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                /**基于资源授权*/
                .antMatchers("/r/r1").hasAuthority("r1")
                .antMatchers("/r/r2").hasAuthority("r2")
                .antMatchers("/r/r3").hasAnyAuthority("r1","r2","r3")
                /**基于角色授权：单个角色 或 多个角色授权*/
/*                .antMatchers("/r/r5").hasRole("role_r2")
                .antMatchers("/r/r5").hasAnyRole("role_r1","role_r2")*/
                /** 所有的/r/下面请求的路径都需要权限验证    **/
                .antMatchers("/r/**").authenticated()
                /**任意请求都放行，大范围规则放下面，小规则放上面*/
                .anyRequest().permitAll()
                .and()
                .formLogin()//允许表单登录
                /** 自定义登录成功页面   **/
                .successForwardUrl("/login-success")
                ;
    }
}
