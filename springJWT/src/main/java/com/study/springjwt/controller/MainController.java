package com.study.springjwt.controller;

import com.study.springjwt.dto.EnrollUser;
import com.study.springjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MainController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String mainRoot() {
        return "Main Controller";
    }

    @PostMapping("/enroll")
    public String userEnroll(EnrollUser enrollUser) {
        System.out.println(enrollUser.getUsername());
        userService.userEnroll(enrollUser);
        return "ok";
    }
}
