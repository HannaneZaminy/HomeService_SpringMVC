<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Customer Profile</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="jumbotron text-center">
    <h1> Maktab Home Service</h1>
    <h2>
        <c:if test="${customer ne null}">
            welcome ${customer.email}
        </c:if></h2>
    <c:if test="${loginCustomer ne null}">
        welcome ${loginCustomer.email}
    </c:if>

</div>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"> Maktab Home Service</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/">Home</a></li>
            <li class="active"><a href="${pageContext.request.contextPath}/">Profile</a></li>
            <li><a href="${pageContext.request.contextPath}/order/createOrder">New Order</a></li>
            <li><a href="${pageContext.request.contextPath}/customer/changePassword">Change Password</a></li>
            <li><a href="${pageContext.request.contextPath}/customer/showOffers">My Offers</a></li>
            <li><a href="${pageContext.request.contextPath}/customer/showOrders">My Orders</a></li>
            <li><a href="${pageContext.request.contextPath}/customer/showMyWallet">My Wallet</a></li>
        </ul>
    </div>
</nav>
<div class="container">

    <div class="col-sm-4">
        <img src="https://customerthink.com/wp-content/uploads/Blog_Image-100.png"
             sizes="100px" alt="Cinque Terre">
    </div>

</div>

</body>
</html>
