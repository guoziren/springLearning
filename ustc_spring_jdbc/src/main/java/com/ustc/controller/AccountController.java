package com.ustc.controller;

import com.ustc.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountController {

    public static void main(String[] args) {
//        ApplicationContext app = new AnnotationConfigApplicationContext(Configure.class);
//        AccountService accountService = app.getBean(AccountService.class);
//        accountService.transfer("tom","lucy",500);
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = app.getBean(AccountService.class);
        accountService.transfer("tom", "lucy", 500);
    }
}
