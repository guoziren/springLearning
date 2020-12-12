import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.util.ResourceBundle;

public class DataSource {
    //test c3p0数据源
    @Test
    public void test() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/ustc");
        dataSource.setUser("root");
        dataSource.setPassword("yyyyyyyy");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    //test c3p0数据源
    @Test
    public void test2() throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/ustc");
        dataSource.setUsername("root");
        dataSource.setPassword("yyyyyyyy");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void test3() {
        //从类加载路径读取，且不需要后缀，所以只用文件名
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        String url = resourceBundle.getString("url");
        String name = resourceBundle.getString("username");
        String pwd = resourceBundle.getString("password");
        String driver = resourceBundle.getString("driver");
    }


}
