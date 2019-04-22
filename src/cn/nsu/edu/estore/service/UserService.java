package cn.nsu.edu.estore.service;

import java.security.GeneralSecurityException;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.security.auth.login.LoginException;

import cn.nsu.edu.estore.dao.UserDao;
import cn.nsu.edu.estore.domain.User;
import cn.nsu.edu.estore.exception.ActiveCodeException;
import cn.nsu.edu.estore.exception.RegistException;
import cn.nsu.edu.estore.utils.MailUtils;

public class UserService {
    /* 1.注册操作		START*/
    public void regist(User user) throws RegistException {

        UserDao dao = new UserDao();
        try {
            //1.添加注册用户信息
            dao.addUser(user);
            //2.向注册用户发送激活邮件
            String emailMsg = "注册成功，请点击下列连接已完成激活操作:(ps:由于邮箱原因，请复制链接打开！)"+"<br>"+
                    "http://localhost:8080/Estore/UserActiveServlet?activeCode="+user.getActivecode();
            MailUtils.sendMail(user.getEmail(), emailMsg);
        } catch (SQLException e) {
            throw new RegistException("注册失败");
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /*1. 注册操作		END*/

    /*2. 激活用户操作	START*/
    public void activeUser(String activeCode) throws ActiveCodeException {
        UserDao dao = new UserDao();
        // 1.根据激活码查询用户，要判断激活码是否过期.

        try {
            User user = dao.findUserByActiveCode(activeCode);

            if (user != null) {
                // 2.进行激活操作

                long time = System.currentTimeMillis()
                        - user.getUpdatetime().getTime();

                if (time <= 24 * 60 * 1000 * 60) {
                    // 激活
                    try {
                        dao.activeUser(activeCode);
                    } catch (SQLException e) {
                        throw new ActiveCodeException("激活用户失败");
                    }

                } else {
                    throw new ActiveCodeException("激活码过期");
                }
            } else {
                throw new ActiveCodeException("用户不存在");
            }
        } catch (SQLException e) {
            throw new ActiveCodeException("查找激活用户失败");
        }
    }
    /*2. 激活用户操作	START*/

    /*3.登录操作		START*/
    public User login(String username, String password) throws LoginException, ActiveCodeException {
        // 需要注意用户是否激活
        UserDao dao = new UserDao();
        try {
            User user = dao.findUserByLogin(username, password);
            if (user != null) {
                // 判断用户是否激活
                if (user.getState() == 1) {
                    return user;
                } else {
                    throw new ActiveCodeException("用户未激活");
                }
            } else {
                throw new LoginException("用户名或密码错误");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("用户名或密码错误");
        }

    }

    /*3.登录操作		END*/
}


