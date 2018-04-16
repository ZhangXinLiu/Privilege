package web.controller;

import domain.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ozc on 2017/3/13.
 */
@WebServlet(name = "LoginController",urlPatterns = "/LoginController")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取表单数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserService userService = new UserService();
        User user = userService.login(username, password);

        if (user != null) {
            request.setAttribute("message", "恭喜你，登陆成功了！");
            request.getSession().setAttribute("user", user);
        } else {
            request.setAttribute("message","用户名或密码出错了！！");
        }

        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
