package cn.nsu.edu.estore.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.nsu.edu.estore.service.NodeDateService;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class LinkageServlet
 */
@WebServlet("/LinkageServlet")
public class LinkageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String code = request.getParameter("levelcode");
        NodeDateService service = new NodeDateService();
        if (code != null && !code.equals("")) {// 有变量就要进行空判断
            try {
                List<HashMap<String, Object>>  name = service.getNextName(code);
                request.getSession().setAttribute("c3name", name);
                // 将集合对象转换成json格式---List---JsonArr字符串[{},{},{}]
                String aString = JSONArray.fromObject(name).toString();
                out.print(aString);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            out.print("fail");
            // 查询失败
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
