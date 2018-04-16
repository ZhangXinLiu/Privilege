package web.controller;

import domain.Role;
import service.RoleService;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ozc on 2017/3/13.
 */
@WebServlet(name = "AddRoleController",urlPatterns = "/AddRoleController")
public class AddRoleController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //得到客户端带过来的数据
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        try {
            //创建对象并封装数据
            Role role = new Role();
            role.setId(WebUtils.makeId());
            role.setName(name);
            role.setDescription(description);

            //调用Service方法，完成功能
            RoleService roleService = new RoleService();
            roleService.addRole(role);

            request.setAttribute("message","添加角色成功！");
        } catch (Exception e) {
            request.setAttribute("message","添加角色失败！");
            e.printStackTrace();
        }

        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
