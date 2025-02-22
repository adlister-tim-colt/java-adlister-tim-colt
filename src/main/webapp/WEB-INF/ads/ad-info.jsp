<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="View ${selectedAd.title} Details"/>
  </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container">
  <div class="m-auto">
    <div class="card m-auto h-50" style="width: 30rem;">
      <div class="card-body">
          <c:forEach var="ad" items="${ads}">
        <h2 class="card-title"><c:out value="${ad.title}"/></h2>
        <h4 class="card-subtitle mb-2 text-muted"><strong>Category:</strong> ${ad.category}</h4>
        <p class="card-text"><c:out value="${ad.description}"/></p>
          </c:forEach>
      </div>
    </div>
  </div>
</div>
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
