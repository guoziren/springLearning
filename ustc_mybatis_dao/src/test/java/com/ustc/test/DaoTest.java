package com.ustc.test;

import com.github.pagehelper.PageHelper;
import com.ustc.dao.UserDao;
import com.ustc.dao.UserMapper;
import com.ustc.dao.impl.UserDaoImpl;
import com.ustc.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DaoTest {

    @Test
    public void testTraditionDao() throws IOException {
        UserDao userDao = new UserDaoImpl();
        List<User> all = userDao.findAll();
        System.out.println(all);
    }

    @Test
    public void testProxyDao() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMappperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获得MyBatis框架生成的UserMapper接口的实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMappperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获得MyBatis框架生成的UserMapper接口的实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User("laoyangsssss","qwertyui");
        user.setBirthday(new Date());
        userMapper.add2(user);
//        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * PageHelper 分页
     * @throws IOException
     */
    @Test
    public void selectAll() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMappperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        PageHelper.startPage(1,3);
        //获得MyBatis框架生成的UserMapper接口的实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        ArrayList<User> arrayList = (ArrayList<User>) userMapper.findAll();
        System.out.println(arrayList.toString());
        System.out.println("------------");
        for (User user : arrayList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
