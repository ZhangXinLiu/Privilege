package web.UI;

import domain.Role;
import domain.User;
import service.RoleService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by ozc on 2017/3/13.
 */
@WebServlet(name = "LookUserRole",urlPatterns = "/LookUserRole")
public class LookUserRole extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //得到客户端传递过来的user_id
        String user_id = request.getParameter("user_id");

        //获取该用户所有的角色
        UserService userService = new UserService();
        List<Role> userRoles = userService.getUserRole(user_id);

        //得到全部的角色
        RoleService roleService = new RoleService();
        List<Role> allRoles = roleService.getAllRole();

        //为用户授权的JSP页面也应该显示用户的信息，所以把User对象也传递过去给JSP页面
        User user = userService.findUser(user_id);

        request.setAttribute("user", user);
        request.setAttribute("userRoles", userRoles);
        request.setAttribute("allRoles", allRoles);

        //跳转到显示页面
        request.getRequestDispatcher("/WEB-INF/jsp/LookUserRole.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
