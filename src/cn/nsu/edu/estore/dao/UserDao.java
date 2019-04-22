package cn.nsu.edu.estore.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.nsu.edu.estore.domain.User;
import cn.nsu.edu.estore.utils.DataSourceUtils;

public class UserDao {
    //1. 注册操作
    public void addUser(User user) throws SQLException {

        String sql = "insert into users values(null,?,?,?,?,?,?,null)";

        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        runner.update(sql, user.getUsername(),
                user.getPassword(),user.getEmail(), "user", 0, user.getActivecode());
    }//注：用户注册密码为了安全起见，要对密码进行加密，该项目中有Md5加密工具，防止书记泄露，，本次为了节约时间，此部分略过。。。。

    //2. 查找用户，根据激活码
    public User findUserByActiveCode(String activeCode) throws SQLException {

        String sql = "select * from users where activecode=?";

        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        return runner.query(sql, new BeanHandler<User>(User.class), activeCode);
    }

    //3. 激活用户
    public void activeUser(String activeCode) throws SQLException {

        String sql = "update users set state=1 where activecode=?";

        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        runner.update(sql, activeCode);
    }

    //4. 登录操作
    public User findUserByLogin(String username, String password) throws SQLException {
        if (username.contains("@")) {

            String sql = "select * from users where email=? and password=?";
            QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
            return runner.query(sql, new BeanHandler<User>(User.class), username,
                    password);

        }else {
            String sql = "select * from users where username=? and password=?";
            QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
            return runner.query(sql, new BeanHandler<User>(User.class), username,
                    password);
        }
    }


}
