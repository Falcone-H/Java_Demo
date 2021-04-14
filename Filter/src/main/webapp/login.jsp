<%--
  Created by IntelliJ IDEA.
  User: Devour
  Date: 2021/4/14
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <h2>Login Page</h2>
    <form action="/loginServlet" method="GET">
        username: <input  type="text" name="username"/>
        <input type="submit" value="submit" />
    </form>
    <a href="/LogoutServlet">Logout</a>
</head>
<body>

</body>
</html>
