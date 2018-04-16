package web.UI;

import java.io.IOException;

/**
 * Created by ozc on 2017/3/12.
 */
@javax.servlet.annotation.WebServlet(name = "AddUserServlet",urlPatterns = "/AddUserServlet")
public class AddUserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        //直接跳转到显示添加用户的界面
        request.getRequestDispatcher("/WEB-INF/jsp/addUser.jsp").forward(request, response);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {


        this.doPost(request, response);

    }
}
