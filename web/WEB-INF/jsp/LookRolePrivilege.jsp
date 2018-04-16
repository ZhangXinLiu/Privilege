<%--
  Created by IntelliJ IDEA.
  User: ozc
  Date: 2017/3/13
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示用户的权利</title>
</head>
<body>

<table border="1px">
    <tr>
        <td>角色名称</td>
        <td>${role.name}</td>
    </tr>

    <tr>
        <td>当前角色拥有的权利</td>
        <td>
            <c:forEach items="${rolePrivilege}" var="privi">
                ${privi.name}
            </c:forEach>
        </td>
    </tr>


    <tr>
        <td>系统拥有的所有权利</td>
        <td>
            <form action="${pageContext.request.contextPath}/AddRolePrivilegeController" method="post">
                <%--让服务器知道要修改哪一个用户，就要把用户的id传递过去--%>
                <input type="hidden" name="role_id" value="${role.id}">

                <c:forEach items="${allPrivilege}" var="privileges">
                    <input type="checkbox" name="privilege_id" value="${privileges.id}">${privileges.name}
                </c:forEach>
                <input type="submit" value="添加权利">
            </form>
        </td>
    </tr>
</table>

</body>
</html>
