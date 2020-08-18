package com.hgq.controller;

import com.hgq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName com.hgq.controller.FunctionController
 * @Description: TODO
 * @Author: hgq
 * @Date: 2020-08-17 13:34
 * @Version: 1.0
 */
@RestController
@RequestMapping("/r")
public class FunctionController {
    @Autowired
    private UserService userService;

    @RequestMapping("/r1")
    public String r1() {
        return userService.getUserName() + ",r1资源访问成功";
    }

    @RequestMapping("/r2")
    public String r2() {
        return userService.getUserName() + ",r2资源访问成功";
    }

    @RequestMapping("/r3")
    public String r3() {
        return userService.getUserName() + ",r3资源访问成功";
    }

    @RequestMapping("/r4")
    @PreAuthorize(value = "hasAuthority('r1')")
    public String r4() {
        return userService.getUserName() + ",r4资源访问成功";
    }
}
