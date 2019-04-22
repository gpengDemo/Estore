package cn.nsu.edu.estore.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.nsu.edu.estore.domain.Product;

/**
 * Servlet implementation class ChangeCountServlet
 */
@WebServlet("/ChangeCountServlet")
public class ChangeCountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.得到请求参数
        int id=Integer.parseInt(request.getParameter("id"));
        int count=Integer.parseInt(request.getParameter("count"));

        //2.修稿购物车的指定数量
        //2.1得到购物车
        Map<Product,Integer> cart=(Map<Product, Integer>) request.getSession().getAttribute("cart");
        //2.2修改购物车中的商品
        Product p=new Product();
        p.setId(id);
        if (count == 0) {
            // 删除商品
            cart.remove(p);
        } else {
            cart.put(p, count);
        }
        response.sendRedirect(request.getContextPath() + "/showcart.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
