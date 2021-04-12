package Demo7.druid;

import Demo7.Utils.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Druid_Test {
    private static Connection conn = null;
    private static PreparedStatement preparedStatement = null;
    public static void main(String[] args) throws Exception {
        // 获取连接
        conn = DruidUtil.getConnection();
        // 定义SQL
        String sql = "insert into student (name, number) values (?, ?)";
        // 获取PreparedStatement对象
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, "赵六");
        preparedStatement.setString(2, "1245789");
        // 执行SQL
        int count = preparedStatement.executeUpdate();
        System.out.println(count);
        // 释放资源
        DruidUtil.close(preparedStatement, conn);
    }
}
