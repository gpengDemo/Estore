package cn.nsu.edu.estore.domain;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户表
 */
public class User {
    private int id; // 用户编号
    private String username; // 用户名
    private String password; // 密码
    private String email; // 邮箱
    private String role; // 角色   默认是user
    private int state; // 是否激活  0 未激活
    private String activecode; // 激活码  UUID获取
    private Timestamp updatetime; // 更新时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getActivecode() {
        return activecode;
    }

    public void setActivecode(String activecode) {
        this.activecode = activecode;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }
    /**
     * 对用户密码进行非空验证
     * @return 	如果用户名、密码为空，抛出用户名，密码为空即可
     */
    public Map<String, String> validation() {
        Map<String, String> map = new HashMap<String, String>();
        if (username == null || username.trim().length() == 0) {
            map.put("regist.username.error", "用户名不能为空");
        }
        if (password == null || password.trim().length() == 0) {
            map.put("regist.password.error", "密码不能为空");
        }
        return map;
    }

}
