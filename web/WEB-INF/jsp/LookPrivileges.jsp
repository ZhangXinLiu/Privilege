<%--
  Created by IntelliJ IDEA.
  User: ozc
  Date: 2017/3/13
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示所有的权限</title>
</head>
<body>
<c:if test="${empty(list)}">
    您还没添加任何的权限
</c:if>

<c:if test="${!empty(list)}">
    <table border="1px">
        <tr>
            <td>权限名称</td>
            <td>描述</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${list}" var="privilege">
            <tr>
                <td>${privilege.name}</td>
                <td>${privilege.description}</td>
                <td>
                    <a href="#">删除权限</a>
                    <a href="#">修改权限</a>
                </td>

            </tr>

        </c:forEach>
    </table>

</c:if>


</body>
</html>
