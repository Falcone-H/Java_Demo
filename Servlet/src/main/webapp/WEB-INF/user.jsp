<%--
  Created by IntelliJ IDEA.
  User: Devour
  Date: 2021/4/11
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.MVC.Bean.*"%>
<%
    User user = (User) request.getAttribute("user");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>hello <%= user.name %> !</h1>
    <p>School Name:
        <span style="color: red;">
            <%= user.school.name %>
        </span>
    </p>
    <p>School Address:
        <span style="color: red">
            <%= user.school.address %>
        </span>
    </p>
</body>
</html>
