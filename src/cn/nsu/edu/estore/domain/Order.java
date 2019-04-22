package cn.nsu.edu.estore.domain;

import java.sql.Timestamp;

public class Order {


    private int id; // 订单号
    private double money; // 金额
    private String receiverinfo; // 收货人信息
    private int paystate; // 支付状态
    private Timestamp ordertime; // 下单时间
    private int user_id; // 下单用户

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getMoney() {
        return money;
    }
    public void setMoney(double money) {
        this.money = money;
    }
    public String getReceiverinfo() {
        return receiverinfo;
    }
    public void setReceiverinfo(String receiverinfo) {
        this.receiverinfo = receiverinfo;
    }
    public int getPaystate() {
        return paystate;
    }
    public void setPaystate(int paystate) {
        this.paystate = paystate;
    }
    public Timestamp getOrdertime() {
        return ordertime;
    }
    public void setOrdertime(Timestamp ordertime) {
        this.ordertime = ordertime;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public Order() {
    }

}
