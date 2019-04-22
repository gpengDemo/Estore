package cn.nsu.edu.estore.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.nsu.edu.estore.domain.User;
import cn.nsu.edu.estore.exception.RegistException;
import cn.nsu.edu.estore.service.UserService;
import cn.nsu.edu.estore.utils.ActiveCodeUtils;


@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*1.进行验证码判断	START	*/
        //验证服务器端生成的验证码与客户端验证码进行校验，验证用户请求是否合法。
	/*	String checkCode = request.getParameter("checkcode");

		String _checkCode = (String) request.getSession().getAttribute(
				"checkcode_session");
		request.getSession().removeAttribute("checkcode_session");//从session中删除。

		if (!checkCode.equals(_checkCode)) {
			request.setAttribute("regist.message", "验证码不正确");
			request.getRequestDispatcher("/regist.jsp").forward(request,
					response);
			return;
		}*/  //***********验证码确认BUG******************
        /*1.进行验证码判断	END	*/
//	request.setCharacterEncoding("utf-8");

        /* 2.得到所有请求参数，封装到User对象中.	START*/
        User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        /* 2.得到所有请求参数，封装到User对象中.	END*/

        // 手动封装激活码
        user.setActivecode(ActiveCodeUtils.getActiveCode());

        /* 3.调用service完成注册操作.		START*/
        UserService service = new UserService();
        try {
            service.regist(user);

            // 3.1注册成功
            response.sendRedirect(request.getContextPath()
                    + "/regist_success.jsp");
            return;
        } catch (RegistException e) {
            // 3.2注册失败
            request.setAttribute("regist.message", e.getMessage());
            request.getRequestDispatcher("/error/registuser_error.jsp").forward(request,
                    response);
            return;
        }
        /* 3.调用service完成注册操作.		END*/
    }
}
