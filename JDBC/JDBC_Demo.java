package Demo6;
import javax.xml.transform.Result;
import java.sql.*;
/*
概念：Java database connective
定义了操作所有关系型数据库的规则（一套接口）
操作：
1、导入jar包
2、注册驱动
3、获取数据库连接对象 Connection
4、定义sql
5、获取执行sql语句的对象 Statement
6、执行sql，接收返回结果
7、处理结果
8、释放资源
各个对象：
1、DriverManager：驱动管理对象
    注册驱动，获取数据库连接
2、Connection：数据库连接对象
    static connection getConnection(String url, String user, String password);
    url: "jdbc:mysql://localhost:3306/database_name"
    获取Statement对象
    管理事务：开始事务，提交事务，回滚事务
            setAutoCommit(boolean autocommit) 开启事务
            commit()                          提交事务
            rollback()                        回滚事务
3、Statement：执行sql对象
    用于执行静态sql语句
    boolean execute(String sql);
    Resultset executeQuery(String sql); 执行DQL语句，如select
    int executeUpdate(String sql);  执行DML语句，如update,insert,delete。 还有DDL语句，如create,alter,drop。
4、ResultSet：结果集对象
    next()  游标，指向下一个
    getInt(参数), getString(参数) 获取某一列的数据
    参数可为int类型，表示第i列
       可为String类型，表示列名
5、PreparedStatement：解决SQL注入的问题
    预编译SQL，参数使用 '?' 作为占位符
    步骤：
        1、导包
        2、注册驱动
        3、连接对象
        4、定义SQL，使用问号作为占位符
        5、获取对象 PreparedStatement    Connection.prepareStatement(String sql)
        6、给问号赋值 setXXX(参数1，参数2) 参数1为？的位置，参数2为值
        7、执行SQL

6、SQL注入，再拼接sql时，有一些SQL的关键字参与字符串的拼接，会造成安全性问题
    输入任意用户名
    输入密码：a' or 'a' = 'a
    即 select * from user where name = shsfhsk and password = 'a' or 'a' = 'a'
 */
public class JDBC_Demo {
    public static void main(String[] args) throws Exception {
        // 注册驱动（MySQL5之后的jar包可以自动注册）
        //Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取数据库的连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_data?serverTimezone=GMT%2B8", "root", "root");
        // 定义SQL语句
        String sql = "select * from student";
        // 获取执行SQL的对象
        Statement statement = conn.createStatement();
        // 执行SQL语句
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String number = resultSet.getString(3);
            System.out.println(id + " " + name + " " + number);
        }

        sql = "update student set number = '789546' where id = 1";
        int flag = statement.executeUpdate(sql);
        System.out.println(flag);

        sql = "insert into student (name, number) values ('王五', '15975378')";
        flag = statement.executeUpdate(sql);
        System.out.println(flag);

        statement.close();
        conn.close();
    }
}
