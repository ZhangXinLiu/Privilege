package web.controller;

import domain.User;
import service.UserService;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ozc on 2017/3/12.
 */
@WebServlet(name = "AddUserController",urlPatterns = "/AddUserController")
public class AddUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //得到客户端传递进来的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setId(WebUtils.makeId());
        user.setUsername(username);
        user.setPassword(password);

        try {
            UserService userService = new UserService();
            userService.addUser(user);

            request.setAttribute("message","添加用户成功！");

        } catch (Exception e) {
            request.setAttribute("message", "添加用户失败！");
            throw new RuntimeException("在Controller添加客户失败");
        }
        request.getRequestDispatcher("/message.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        this.doPost(request, response);
    }
}
