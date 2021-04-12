package Demo6;

import java.sql.*;
public class Example {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = null;
        Statement statement = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_data?serverTimezone=GMT%2B8", "root", "root");
        statement = conn.createStatement();
        String sql = "select * from student";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String number = resultSet.getString("number");
        }
        statement.close();
        conn.close();
    }
}
