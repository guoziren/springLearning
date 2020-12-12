package com.ustc.service.impl;

import com.ustc.dao.AccountDao;
import com.ustc.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private AccountDao mAccountDao;

    public void setAccountDao(AccountDao accountDao) {
        mAccountDao = accountDao;
    }

    public void transfer(String outMan, String inMan, double money) {
        mAccountDao.out(outMan, money);
        int i = 1 / 0;
        mAccountDao.in(inMan, money);
    }
}
