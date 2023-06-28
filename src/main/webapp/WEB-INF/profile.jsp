<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <div>
            <h1>Here Are all your ads!</h1>

            <c:forEach var="ad" items="${userAds}">
                <div class="col-md-6">
                    <h2>${ad.title}</h2>
                    <p>${ad.description}</p>
                    <form action="/ads/details" method="get">
                        <label for="ad_id"></label>
                        <input style="display: none;" name="ad_id" id="ad_id" value=${ad.id} type="text"/>
                        <input type="submit" class="btn btn-block btn-primary" value= "See Details">
                    </form>
                </div>
            </c:forEach>
        </div>

    </div>
<%--    <script>--%>
<%--        function updateAd() {--%>
<%--            console.log("this is the update button")--%>
<%--        }--%>
<%--        function deleteAd() {--%>
<%--            console.log("this is the delete button")--%>
<%--            alert("are you sure you want to delete this?")--%>
<%--        }--%>
<%--    </script>--%>


</body>
</html>
