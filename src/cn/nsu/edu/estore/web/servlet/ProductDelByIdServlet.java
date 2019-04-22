package cn.nsu.edu.estore.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.nsu.edu.estore.service.ProductService;

/**
 * Servlet implementation class ProductDelByIdServlet
 */
@WebServlet("/ProductDelByIdServlet")
public class ProductDelByIdServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所传id值
        int id = Integer.parseInt(request.getParameter("id"));

        //调用service中删除操作
        ProductService service = new ProductService();

        try {
            service.delete(id);

            request.getRequestDispatcher("/ProductFindAllServlet").forward(request, response);
            return;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
