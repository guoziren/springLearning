package com.ustc.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println(" save running ");
    }
}
