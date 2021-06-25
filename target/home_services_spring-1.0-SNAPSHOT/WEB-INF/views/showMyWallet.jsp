<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: itak
  Date: 6/17/2021
  Time: 12:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html>
<head>
    <title>My Wallet</title>
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
    <c:if test="${customerWallet ne null}">
        Your wallet account balance: ${customerWallet.wallet}
    </c:if>

</div>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Maktab Home Services</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">My Wallet</a></li>
            <li><a href="${pageContext.request.contextPath}/">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/customer/profile">Profile</a></li>>
            <li><a href="${pageContext.request.contextPath}/customer/onlinePayment/">Account increase</a></li>>
        </ul>
    </div>
</nav>
<div class="container">

    <div class="col-sm-4">
        <img src="data:image/png;base64,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"
             sizes="100px" alt="Cinque Terre">
    </div>

</div>
</body>
</html>