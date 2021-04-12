package Demo6;

import Demo6.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Example2 {
    public static void main(String[] args) throws Exception {
        Connection conn = JDBCUtils.getConnection();
        Statement statement = conn.createStatement();
        String sql = "select * from student";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String number = resultSet.getString("number");
            System.out.println(id + " " + name + " " + number);
        }
        JDBCUtils.close(statement, conn);
    }
}
