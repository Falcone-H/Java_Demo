package Demo7.c3p0;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/*
1、先导入jar包
2、定义配置文件 c3p0.properties 或者 c3p0-config.xml
   路径：默认在src目录下
3、获取连接：getConnection


// 已炸，建议用druid
 */
public class c3p0_Demo {
    public static void main(String[] args) throws SQLException {
        // 创建数据库连接池对象，使用默认配置
        //DataSource dataSource = new ComboPooledDataSource();
        // 使用制定名称的配置
        // DataSource dataSource1 = new ComboPooledDataSource("test");
        // 获取连接对象
//        for(int i = 1; i <= 8; i++) {
//            Connection conn = dataSource.getConnection();
//            System.out.println(i + "-->" + conn);
//            conn.close();
//        }
    }
}
