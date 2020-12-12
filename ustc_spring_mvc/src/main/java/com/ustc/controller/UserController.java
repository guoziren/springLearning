package com.ustc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/user")
    public String save() {
        System.out.println("save running");
        return "success.jsp";
    }
}
