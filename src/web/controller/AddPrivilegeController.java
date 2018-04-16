package web.controller;

import domain.Privilege;
import service.PrivilegeService;
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
@WebServlet(name = "AddPrivilegeController",urlPatterns = "/AddPrivilegeController")
public class AddPrivilegeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //得到浏览器带过来的数据
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        //封装数据到Privilege对象
        Privilege privilege = new Privilege();
        privilege.setId(WebUtils.makeId().substring(3,10));
        privilege.setName(name);
        privilege.setDescription(name);


        try {
            PrivilegeService privilegeService = new PrivilegeService();
            privilegeService.addPrivilege(privilege);

            request.setAttribute("message","添加权限成功！");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "添加权限失败！");
        }

        request.getRequestDispatcher("/message.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
