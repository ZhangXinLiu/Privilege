package web.UI;

import domain.Role;
import domain.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ozc on 2017/3/12.
 */
@WebServlet(name = "LookUserUI",urlPatterns = "/LookUserUI")
public class LookUserUI extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userService = new UserService();

        //获取得到所有用户
        List<User> list = userService.getAllUser();
        request.setAttribute("list", list);

        //跳转到显示页面
        request.getRequestDispatcher("/WEB-INF/jsp/LookUser.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);

    }
}
