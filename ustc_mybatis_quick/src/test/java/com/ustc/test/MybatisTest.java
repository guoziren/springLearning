package com.ustc.test;

import com.ustc.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void qucik() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMappperConfig.xml");
        //获得sqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行sql语句
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        //打印结果
        System.out.println(userList);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void insert() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMappperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User("liuyi","asdfasdf");
        int insert = sqlSession.insert("userMapper.add", user);
        System.out.println(insert);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void update() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMappperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User("laoliu","asdfasdf");
        user.setId(3);
        int update = sqlSession.update("userMapper.update", user);
        System.out.println(update);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void delete() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMappperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int delete = sqlSession.delete("userMapper.delete",3);
        System.out.println(delete);
        sqlSession.commit();
        sqlSession.close();
    }
}
