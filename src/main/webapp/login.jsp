<%--
  Created by IntelliJ IDEA.
  User: coltonwyatt
  Date: 6/13/23
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>Title</title>
</head>

<%
    if(request.getMethod().equalsIgnoreCase("post")) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("admin") && password.equals("password")) {
            response.sendRedirect("profile.jsp");
        }
    }
%>
<body>


<form action="/login.jsp" method=post>
    Enter Username <input type="text" name="username"> <br>
    Enter Password <input type="password" name="password"> <br>
    <input type="submit" value="submit">
</form>



</body>
</html>
