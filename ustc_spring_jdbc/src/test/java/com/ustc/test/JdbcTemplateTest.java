package com.ustc.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.ustc.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.beans.PropertyVetoException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate mJdbcTemplate;

    @Test
    public void test() throws PropertyVetoException {
        // 创建数据源
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/ustc");
        dataSource.setUser("root");
        dataSource.setPassword("yyyyyyyy");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        int row = jdbcTemplate.update("insert into account values(?,?)", "xiaoli", "50000");
        System.out.println(row);
    }

    //delete
    @Test
    public void testAdd() {
        int res = mJdbcTemplate.update("delete from account where name = ?", "xiaoli");
        System.out.println(res);
    }

    //update
    @Test
    public void testModify() {
        int res = mJdbcTemplate.update("update  account set money = ? where name = ?", 3000, "xiaoli");
        System.out.println(res);
    }

    //query all
    @Test
    public void testQueryAll() {
        List<Account> accountList = mJdbcTemplate.query("select * from  account ", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accountList);
    }

    //query one
    @Test
    public void testQueryOne() {
        Account xiaoli = mJdbcTemplate.queryForObject("select * from  account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), "xiaoli");
        System.out.println(xiaoli);
    }

    //聚合查询
    //query 总数
    @Test
    public void testQueryCount() {
        int xiaoli = mJdbcTemplate.queryForObject("select count(*) from  account", Integer.class);
        System.out.println(xiaoli);
    }
}
