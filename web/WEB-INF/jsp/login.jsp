<%--
  Created by IntelliJ IDEA.
  User: DORSEy
  Date: 6/29/16
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user login</title>
</head>
<body>
<%
    String ctx = request.getContextPath();
%>
<div>
    <form action="<%=ctx%>/user/doLogin" method="post">
        <table>
            <thead>
            <tr>
                <th colspan="2">
                    Login
                </th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th align="left">
                    username
                </th>
                <td>
                    <input type="text" size="20" name="username"/>
                </td>
            </tr>
            <tr>
                <th align="left">
                    password
                </th>
                <td>
                    <input type="password" size="20" name="password"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit"/>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
