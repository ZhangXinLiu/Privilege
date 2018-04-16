<%--
  Created by IntelliJ IDEA.
  User: ozc
  Date: 2017/3/13
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加角色页面</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/AddRoleController" method="post">
    <table border="1px">
        <tr>
            <td>角色名称</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>详细描述</td>
            <td><textarea name="description"  cols="30" rows="10"></textarea></td>
        </tr>

        <tr>
            <td>
                <input type="submit" value="添加角色">
            </td>
        </tr>
    </table>

</form>

</body>
</html>
