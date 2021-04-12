package Demo7.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/*
1、导入jar包
2、定义配置文件，properties形式
3、加载配置文件
4、获取数据库连接池对象，通过工厂类获取    DruidDataSourceFactory

 */
public class Druid_Demo {
    public static void main(String[] args) throws Exception {
        // 加载配置文件
        Properties properties = new Properties();
        InputStream inputStream = Druid_Demo.class.getClassLoader().getResourceAsStream("Demo7/Utils/druid.properties");
        properties.load(inputStream);
        // 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        // 获取连接
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
    }
}
