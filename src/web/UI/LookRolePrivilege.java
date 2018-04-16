package web.UI;

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
import java.util.List;

/**
 * Created by ozc on 2017/3/13.
 */
@WebServlet(name = "LookRolePrivilege",urlPatterns = "/LookRolePrivilege")
public class LookRolePrivilege extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //得到浏览器想要查看的角色id
        String role_id = request.getParameter("role_id");
        RoleService roleService = new RoleService();

        //根据id获取得到Role对象
        Role role = roleService.findRole(role_id);

        //得到当前角色所有的权利
        List<Privilege> rolePrivilege = roleService.getRolePrivilege(role_id);

        //得到系统所有的权利
        PrivilegeService privilegeService = new PrivilegeService();
        List<Privilege> allPrivilege = privilegeService.getAllPrivileges();

        request.setAttribute("role", role);
        request.setAttribute("rolePrivilege", rolePrivilege);
        request.setAttribute("allPrivilege", allPrivilege);

        //跳转到显示页面
        request.getRequestDispatcher("/WEB-INF/jsp/LookRolePrivilege.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
