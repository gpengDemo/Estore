package cn.nsu.edu.estore.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {
    private static DataSource dataSource = new ComboPooledDataSource();

    private static final ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    public static DataSource getDataSource() {
        return dataSource;
    }

    // 获取绑定到ThreadLocal中的Connection。
    public static Connection getConnectionByTransaction() throws SQLException {
        Connection con = tl.get();
        if (con == null) {
            con = dataSource.getConnection();
            tl.set(con);
        }

        return con;
    }

    // 开启事务
    public static void startTransaction(Connection con) throws SQLException {
        if (con != null)
            con.setAutoCommit(false);
    }

    // 事务回滚
    public static void rollback(Connection con) throws SQLException {
        if (con != null)
            con.rollback();
    }

    public static void closeConnection(Connection con) throws SQLException {
        if (con != null) {
            con.commit();// 事务提交
            con.close();
            tl.remove();

        }
    }

    /**
     * 当DBUtils需要手动控制事务时，调用该方法获得一个连接
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
