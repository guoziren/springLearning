package com.ustc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDaoImpl implements AccountDao {
    private JdbcTemplate mJdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        mJdbcTemplate = jdbcTemplate;
    }

    public void out(String outMan, double money) {
        mJdbcTemplate.update("update account set money = money - ? where name = ?", money, outMan);
    }

    public void in(String inMan, double money) {
        mJdbcTemplate.update("update account set money = money + ? where name = ?", money, inMan);
    }

}
