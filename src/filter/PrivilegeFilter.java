package filter;

import domain.Privilege;
import domain.Role;
import domain.User;
import service.RoleService;
import service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by ozc on 2017/3/13.
 */
@WebFilter(filterName = "PrivilegeFilter",urlPatterns = "/*")
public class PrivilegeFilter implements Filter {

    private Map<String, Privilege> map = new HashMap<>();
    public void init(FilterConfig config) throws ServletException {

        map.put("/addServlet", new Privilege("增加"));
        map.put("/deleteServlet", new Privilege("删除"));
        map.put("/updateServlet", new Privilege("修改"));
        map.put("/findServlet", new Privilege("查账单"));

    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //得到用户请求的资源地址
        String uri = request.getRequestURI();
        System.out.println(uri);

        //通过key获取值，看看能不能获取得到值【为空，就是不需要权限了】
        if (map.get(uri) == null) {
            chain.doFilter(request, response);
            System.out.println("放行了");
            return ;
        }
        //如果不为空，就是需要权限。需要权限的话，就判断请求者是否登陆了！
        if (request.getSession().getAttribute("user") == null) {
            request.setAttribute("message", "您登陆了再来操作把！");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }

        //如果登陆了，就查一下用户的权限是否和访问资源的权限匹配
        User user = (User) request.getSession().getAttribute("user");
        UserService userService = new UserService();
        RoleService roleService = new RoleService();

        //得到用户所有的角色
        List<Role> roles = userService.getUserRole(user.getId());

        //通过角色，得到所有的权限【一个角色有多个权限，如果用户角色很多，那么权限也就很多了】
        //此时，我们又要用集合来装载每一个角色的权限了！
        Set privileges = new HashSet();
        for (Role role : roles) {
            List<Privilege> list = roleService.getRolePrivilege(role.getId());
            privileges.addAll(list);
        }

        //得到的Set集合就是用户所有的权限了！！！！！
        //集合的contains方法比较的是默认对象，而我们想要比较的是字符串名称，所以我们要在Privilege对象中重写equals和hashCode方法！
        if (!privileges.contains(map.get(uri))) {
            request.setAttribute("message", "你没有权限哟");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return ;
        }

        //到这里，就是有权限了
        chain.doFilter(request, response);
    }


    public void destroy() {
    }


}
