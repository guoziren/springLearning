package com.ustc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController {

    @RequestMapping("/e1")
    @ResponseBody
    public void exception1(){
        throw new RuntimeException("exception1");
    }

    @RequestMapping("/e2")
    @ResponseBody
    public void exception2(){
        throw new NullPointerException("NullPointerException");
    }

    @RequestMapping("/e3")
    @ResponseBody
    public void exception3(){
        throw new NumberFormatException("NumberFormatException");
    }
}
