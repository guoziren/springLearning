package com.ustc.service;

import com.ustc.dao.UserDao;

public class UserServiceImpl implements UserService {
    private UserDao mUserDao;

    public void setUserDao(UserDao userDao) {
        mUserDao = userDao;
    }

    public void save() {
        mUserDao.save();
    }
}
