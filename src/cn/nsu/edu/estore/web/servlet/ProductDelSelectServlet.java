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
 * Servlet implementation class ProductDelSelectServlet
 */
@WebServlet("/ProductDelSelectServlet")
public class ProductDelSelectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到删除所有商品id
        String[] idstring = (request.getParameterValues("ck"));

        //将String类型数组转化成int类型数组
        int[] id = new int[idstring.length];
        for (int i = 0; i < id.length; i++) {
            id[i] = Integer.parseInt(idstring[i]);
        }

        //调用service中删除所选数据
        ProductService service = new ProductService();

        try {
            service.delSelect(id);

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
