<%--
  Created by IntelliJ IDEA.
  User: coltonwyatt
  Date: 6/14/23
  Time: 5:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Color-Choice" />
    </jsp:include>
</head>
<body>

<div>
    <h1>Tell Me Your Favorite Color</h1>
</div>
<form method="post" action="/favorite-color">
    <div class="input-group mb-3">
        <span class="input-group-text" id="inputGroup-sizing-default">Enter your favorite color here</span>
        <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="colorChoice">
        <br>
        <button type="submit">Submit Color</button>
    </div>
</form>
</body>
</html>
