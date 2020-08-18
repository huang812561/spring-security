package com.hgq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName com.hgq.controller.LoginController
 * @Description: TODO
 * @Author: hgq
 * @Date: 2020-08-15 15:59
 * @Version: 1.0
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/login-success",produces = {"text/plain;charset=UTF-8"})
    public String success(){
        return "登录成功";
    }

}
