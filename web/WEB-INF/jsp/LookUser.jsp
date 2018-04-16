<%--
  Created by IntelliJ IDEA.
  User: ozc
  Date: 2017/3/12
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查看用户</title>
</head>
<body>

<c:if test="${empty(list)}">
    对不起，暂时没有任何客户
</c:if>

<c:if test="${!empty(list)}">
    <table border="1px">
        <tr>
            <td>用户名</td>
            <td>密码</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${list}" var="user">
            <tr>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/LookUserRole?user_id=${user.id}">
                        为用户授权角色
                    </a>
                    <a href="#">修改用户</a>
                    <a href="#">删除用户</a>

                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
