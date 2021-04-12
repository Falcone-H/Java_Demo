package Demo6;

import Demo6.Utils.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

public class PreStatement { // 避免sql注入
    public static void main(String[] args) throws SQLException {
        String user = null;
        String passwd = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入用户名");
        user = scan.next();
        System.out.println("请输入密码");
        passwd = scan.next();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from student where name = ? and number = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, user);
        preparedStatement.setString(2, passwd);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String number = resultSet.getString("number");
            System.out.println(id + " " + name + " " + number);
        }
        JDBCUtils.close(resultSet, preparedStatement, conn);
    }
}
