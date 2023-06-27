
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Search Results"/>
  </jsp:include>
</head>
<body>

<h2>Search</h2>
<form action="ads" method="GET">
  <input type="text" name="search" placeholder="Enter your search query">
  <button type="submit">Search</button>
</form>

<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
  <h1>Results for: <c:out value="${keywords}"/></h1>
  <c:forEach var="ad" items="${foundAds}">
    <div class="col-md-6">
      <a href="/ad-info/show?id=${ad.id}"><h2><c:out value="${ad.title}"/></h2></a>
      <p><c:out value="${ad.description}"/></p>
    </div>
  </c:forEach>
</div>
</body>
</html>


