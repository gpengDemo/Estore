package cn.nsu.edu.estore.service;

import java.sql.SQLException;

import cn.nsu.edu.estore.dao.OrderDao;
import cn.nsu.edu.estore.domain.Order;
import cn.nsu.edu.estore.exception.addOrderException;

public class OrderService {
    public int addOrder(Order order) throws addOrderException {
        OrderDao dao=new OrderDao();
        int i = 0;

        try {
            i = dao.addOrder(order);
        } catch (SQLException e) {
            throw new addOrderException("订单提交失败");
        }
        return i;
    }


}
