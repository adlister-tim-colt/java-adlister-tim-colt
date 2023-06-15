<%--
  Created by IntelliJ IDEA.
  User: coltonwyatt
  Date: 6/14/23
  Time: 11:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Pizza-order" />
    </jsp:include>

</head>

<body>
<div>
    <jsp:include page="partials/navbar.jsp"></jsp:include>
</div>
<form method="post" action="/pizza-order">
<div>
    <div>
        <h4>What size</h4>
    </div>

        <select class="form-select" aria-label="Disabled select example" name="size">
            <option selected>Open this select menu</option>
            <option value="Small">Small</option>
            <option value="Medium">Medium</option>
            <option value="Large">Large</option>
        </select>

</div>
<div>
    <div>
        <h4>What sauce</h4>
    </div>

        <select class="form-select" aria-label="Disabled select example" name="sauce">
            <option selected>Open this select menu</option>
            <option value="Marinara">Marinara</option>
            <option value="Alfredo">Alfredo</option>
            <option value="Pesto">Pesto</option>
        </select>

</div>
<div>
    <div>
        <h4>What Style Crust</h4>
    </div>

        <select class="form-select" aria-label="Disabled select example" name="crust">
            <option selected>Open this select menu</option>
            <option value="Deep Dish">Deep Dish</option>
            <option value="Thin Crust">Thin Crust</option>
            <option value="Pan Style">Pan Style</option>
        </select>

</div>

<div class="form-check">
    <input class="form-check-input" type="checkbox" value="Extra Cheese" id="extraCheese" name="toppings">
    <label class="form-check-label" for="extraCheese">
        Extra Cheese
    </label>
</div>
<div class="form-check">
    <input class="form-check-input" type="checkbox" value="Pepperoni" id="peperoni" name="toppings">
    <label class="form-check-label" for="peperoni">
        Peperoni
    </label>
</div>
<div class="form-check">
    <input class="form-check-input" type="checkbox" value="Sausage" id="sausage" name="toppings">
    <label class="form-check-label" for="sausage">
        Sausage
    </label>
</div>
<div class="form-check">
    <input class="form-check-input" type="checkbox" value="Pineapple" id="pineapple" name="toppings">
    <label class="form-check-label" for="pineapple">
        Pineapple
    </label>
</div>
<div class="form-check">
    <input class="form-check-input" type="checkbox" value="Ham" id="ham">
    <label class="form-check-label" for="ham">
        Ham
    </label>
</div>
<div class="form-check">
    <input class="form-check-input" type="checkbox" value="Chicken" id="chicken">
    <label class="form-check-label" for="chicken">
        Chicken
    </label>
</div>
    <div class="col-md-6">
        <label for="inputEmail4" class="form-label">First Name</label>
        <input type="text" class="form-control" id="inputEmail4" name="firstName" value="${firstName}">
    </div>
    <div class="col-md-6">
        <label for="inputPassword4" class="form-label">Last Name</label>
        <input type="text" class="form-control" id="inputPassword4" name="lastName" value="${lastName}">
    </div>
    <div class="col-12">
        <label for="inputAddress" class="form-label">Address</label>
        <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St" name="address1" value="${address1}">
    </div>
    <div class="col-12">
        <label for="inputAddress2" class="form-label">Address 2</label>
        <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor" name="address2" value="${address2}">
    </div>
    <div class="col-md-6">
        <label for="inputCity" class="form-label">City</label>
        <input type="text" class="form-control" id="inputCity" name="city" value="${city}">
    </div>
    <div class="col-md-2">
        <label for="inputState" class="form-label">State</label>
        <input type="text" class="form-control" id="inputState" name="state" value="${state}">
    </div>
    <div class="col-md-2">
        <label for="inputZip" class="form-label">Zip</label>
        <input type="text" class="form-control" id="inputZip" name="zip" value="${zip}">
    </div>
    <div class="col-12">
        <button type="submit" class="btn btn-primary">Submit Order</button>
    </div>
</form>


</body>
</html>
