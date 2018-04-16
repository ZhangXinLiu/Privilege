package web.controller;

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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ozc on 2017/3/13.
 */
@WebServlet(name = "AddUserRoles",urlPatterns = "/AddUserRoles")
public class AddUserRoles extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //得到传递进来的role_id
        String[] ids = request.getParameterValues("role_id");

        try {
            //得到想要修改哪个用户的id
            String user_id = request.getParameter("user_id");

            //通过id获取得到User对象
            UserService userService = new UserService();
            User user = userService.findUser(user_id);

            //通过id获取得到Role对象，再把对象用List集合装载起来
            RoleService roleService = new RoleService();
            List<Role> list = new ArrayList<>();
            for (String id : ids) {
                Role role = roleService.findRole(id);
                list.add(role);
            }

            //更新用户所拥有的角色
            userService.updateUserRole(user, list);

            request.setAttribute("message","添加角色成功！");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message","添加角色失败！");
        }
        request.getRequestDispatcher("/message.jsp").forward(request,response);


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        this.doPost(request,response);
    }
}
