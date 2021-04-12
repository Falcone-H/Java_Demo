package Demo6.Utils;

import javax.swing.plaf.nimbus.State;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/*
JDBC工具类：JDBCUtils
    1、注册驱动
    2、抽取一个方法获取连接对象
        不传递参数，但保证工具类的通用性，用一个配置文件完成,只需要读取一次即可
        使用静态代码块，读取资源文件
        jdbc.properties
            url=
            user=
            password=
    3、抽取一个方法释放资源
 */
public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {
        // 读取资源文件
        try {
            // 1、创建Properties集合类
            Properties pro = new Properties();
            // 2、加载文件
            // 获取src路径下的文件 -> ClassLoader 类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            // classLoader.getResource() 获取当前类所在包的路径
            URL rescourse = classLoader.getResource("Demo6/utils/jdbc.properties");
            String path = rescourse.getPath();
            System.out.println(path);
            pro.load(new FileReader(path));
            // 获取数据
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver =  pro.getProperty("driver");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }


    // 释放资源
    public static void close(Statement statement, Connection connection) {
        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if(resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
