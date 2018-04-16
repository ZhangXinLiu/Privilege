package web.UI;

import domain.Role;
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
@WebServlet(name = "LookRolesUI",urlPatterns = "/LookRolesUI")
public class LookRolesUI extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //得到所有的角色
        RoleService roleService = new RoleService();
        List<Role> list = roleService.getAllRole();

        request.setAttribute("list", list);
        request.getRequestDispatcher("/WEB-INF/jsp/LookRoles.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
