<%--
  Created by IntelliJ IDEA.
  User: coltonwyatt
  Date: 6/14/23
  Time: 8:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <jsp:include page="/partials/head.jsp">
        <jsp:param name="title" value="Guess a color" />
    </jsp:include>
</head>

<body>

<div>
    <h1>Do You Want To Play A Game?</h1>
</div>
<form method="post" action="/outcome.jsp">
    <div class="input-group input-group-sm mb-3">
        <span class="input-group-text" id="inputGroup-sizing-sm">Choose a number between 1 - 3</span>
        <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
        <br>
        <button type="submit">Submit</button>
    </div>
</form>

</body>
</html>
