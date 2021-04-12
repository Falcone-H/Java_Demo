package Demo6;

import Demo6.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
管理事务：
    开启事务：setAutoCommit(boolean autoCommit)  调用该方法设置参数为false，即开启事务
        在执行sql之前
    提交事务：commit()
        在所有sql都执行完之后
    回滚事务：rollback()
        在catch中回滚事务

使用Connection对象管理事务
 */
public class Transaction {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        // 开启事务
        conn.setAutoCommit(false);
        try{
            conn = JDBCUtils.getConnection();
            String sql = "update student set number = ? where id = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, "789789");
            preparedStatement.setInt(2, 1);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            // 一旦发生异常，回滚事务
            if(conn != null)
                conn.rollback();
        }
        // 提交事务
        conn.commit();
        JDBCUtils.close(preparedStatement, conn);
    }
}
