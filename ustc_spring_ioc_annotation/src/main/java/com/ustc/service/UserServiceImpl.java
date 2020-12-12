package com.ustc.service;

import com.ustc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao mUserDao;

    public void setUserDao(UserDao userDao) {
        mUserDao = userDao;
    }

    public void save() {
        mUserDao.save();
    }
}
