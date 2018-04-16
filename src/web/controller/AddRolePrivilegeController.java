package web.controller;

import domain.Privilege;
import domain.Role;
import service.PrivilegeService;
import service.RoleService;

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
@WebServlet(name = "AddRolePrivilegeController",urlPatterns = "/AddRolePrivilegeController")
public class AddRolePrivilegeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //得到浏览器想要添加权利的id
        String[] ids = request.getParameterValues("privilege_id");

        //获取角色id
        String role_id = request.getParameter("role_id");


        try {
            //得到想要添加权利的角色
            RoleService roleService = new RoleService();
            Role role = roleService.findRole(role_id);

            //得到权利对象，用List对象装载起来
            PrivilegeService privilegeService = new PrivilegeService();
            List<Privilege> privileges_list = new ArrayList<>();
            for (String id : ids) {
                Privilege privilege = privilegeService.findPrivilege(id);
                privileges_list.add(privilege);
            }

            roleService.updateRolePrivilege(role, privileges_list);

            request.setAttribute("message","为角色添加权利成功！");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message","为角色添加权利失败！");
        }

        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
