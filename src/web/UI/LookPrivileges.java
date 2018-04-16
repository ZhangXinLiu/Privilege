package web.UI;

import domain.Privilege;
import service.PrivilegeService;

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
@WebServlet(name = "LookPrivileges",urlPatterns = "/LookPrivileges")
public class LookPrivileges extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //得到所有的权限
        PrivilegeService privilegeService = new PrivilegeService();
        List<Privilege> list = privilegeService.getAllPrivileges();

        request.setAttribute("list", list);
        request.getRequestDispatcher("/WEB-INF/jsp/LookPrivileges.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
