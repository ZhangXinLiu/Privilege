<%--
  Created by IntelliJ IDEA.
  User: ozc
  Date: 2017/3/13
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查看所有的角色</title>
</head>
<body>
<c:if test="${empty(list)}">
    您还没有任何角色，请添加！
</c:if>

<c:if test="${!empty(list)}">
    <table border="1px">
        <tr>
            <td>角色名称</td>
            <td>描述</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${list}" var="role">
            <tr>
                <td>${role.name}</td>
                <td>${role.description}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/LookRolePrivilege?role_id=${role.id}">
                        为角色授权
                    </a>
                    <a href="#">删除角色</a>
                    <a href="#">修改角色</a>
                </td>
            </tr>
        </c:forEach>
    </table>


</c:if>


</body>
</html>
