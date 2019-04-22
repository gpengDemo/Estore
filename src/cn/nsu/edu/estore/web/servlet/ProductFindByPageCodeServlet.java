package cn.nsu.edu.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.nsu.edu.estore.domain.PageBean;
import cn.nsu.edu.estore.service.ProductService;

/**
 * Servlet implementation class ProductFindByPageCodeServlet
 */
@WebServlet("/ProductFindByPageCodeServlet")
public class ProductFindByPageCodeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNum = 1;
//		String code = (String) request.getSession().getAttribute("code111");
        String code = request.getParameter("code");
        String _pageNum = request.getParameter("pageNum");
        if (code != null) {
            request.getSession().setAttribute("code", code);
            if (_pageNum != null) {
                pageNum = Integer.parseInt(_pageNum);
            }

            //规定每页显示条数
            int currentPage = 12;
            String _currentPage = request.getParameter("currentPage");
            if (_currentPage != null) {
                currentPage = Integer.parseInt(_currentPage);
            }

            //调用service中查询操作
            ProductService service = new ProductService();

            PageBean pb = service.findByPageByCode(pageNum, currentPage, code);

            request.setAttribute("pb1", pb);

            request.getRequestDispatcher("/product.jsp").forward(
                    request, response);
            return;
        }
        if (_pageNum != null) {
            pageNum = Integer.parseInt(_pageNum);
        }

        //规定每页显示条数
        int currentPage = 12;
        String _currentPage = request.getParameter("currentPage");
        if (_currentPage != null) {
            currentPage = Integer.parseInt(_currentPage);
        }

        //调用service中查询操作
        ProductService service = new ProductService();
        PageBean pb = service.findByPageByCode(pageNum, currentPage, (String)request.getSession().getAttribute("code"));
        request.removeAttribute("pb1");
        request.setAttribute("pb1", pb);
        request.getRequestDispatcher("/product.jsp").forward(request, response);
        return;


    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
