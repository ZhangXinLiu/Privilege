<%--
  Created by IntelliJ IDEA.
  User: ozc
  Date: 2017/3/13
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>为用户授权角色</title>
</head>
<body>
<table border="1px">
    <tr>
        <td>当前用户名称</td>
        <td>${user.username}</td>
    </tr>

    <tr>
        <td>当前用户所拥有的角色</td>
        <td>
            <c:forEach items="${userRoles}" var="userRole">
                ${userRole.name}
            </c:forEach>
        </td>
    </tr>

    <tr>
        <td>当前系统所拥有的角色</td>
        <td>
            <form method="post" action="${pageContext.request.contextPath}/AddUserRoles">

                <%--要为用户添加角色，需要知道是哪一个用户，通过hidden传递过去用户的id--%>
                <input type="hidden" name="user_id" value="${user.id}">

                <c:forEach items="${allRoles}" var="roles">
                    <input type="checkbox" name="role_id" value="${roles.id}">${roles.name}
                </c:forEach>

                <input type="submit" value="添加角色！">
            </form>
        </td>
    </tr>

</table>


</body>
</html>
