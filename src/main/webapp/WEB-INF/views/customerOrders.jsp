<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Order</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Maktab Home Services</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">My order</a></li>
            <li><a href="${pageContext.request.contextPath}/">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/specialist/profile">Profile</a></li>>
        </ul>
    </div>
</nav>
<form:form action="/customer/showSuggestions" method="get">
    <table class="table table-striped table-success table-hover">
        <tr>
            <td>id</td>
            <td>My description</td>
            <td>proposed price</td>
            <td>situation</td>
            <td>date of work</td>
            <td>date of create order</td>
            <td colspan="2">address</td>
            <td colspan="2">specialist</td>
            <td colspan="2">customer</td>
            <td colspan="2">add comment</td>
            <td colspan="2">pay</td>
        </tr>
        <c:forEach items="${ordersList}" var="list">
            <tr>
                <td rowspan="4">${list.id}</td>
                <td rowspan="4">${list.description}</td>
                <td rowspan="4">${list.proposedPrice}</td>
                <td rowspan="4">${list.situation}</td>
                <td rowspan="4">${list.dateOfWork}</td>
                <td rowspan="4">${list.dateOfOrderRegistration}</td>
                <td>city</td>
                <td>${list.address.city}</td>
                <td>id</td>
                <td>${list.specialistDto.id}</td>
                <td>id</td>
                <td>${list.customer.id}</td>
                <td rowspan="4">
                    <c:if test="${list.situation eq 'done'}">
                        <a onclick="sendOffer(${list.id});" href="#" id="link">Add a comment To order</a>
                    </c:if>
                </td>
                <td rowspan="4">
                    <c:if test="${list.situation eq 'done'}">
                        <a onclick="paymentFromWallet(${list.id});" href="#" id="paymentLink">pay from wallet</a>
                        <a onclick="onlinePayment(${list.id});" href="#" id="onlinePayment">online payment</a>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>street</td>
                <td>${list.address.street}</td>
                <td>name</td>
                <td>${list.specialistDto.name}</td>
                <td>name</td>
                <td>${list.customer.name}</td>
            </tr>
            <tr>
                <td>zipCod</td>
                <td>${list.address.zipCod}</td>
                <td>last Name</td>
                <td>${list.specialistDto.lastName}</td>
                <td>last Name</td>
                <td>${list.customer.lastName}</td>
            </tr>
            <tr>

                <td>email</td>
                <td>${list.specialistDto.email}</td>
                <td>email</td>
                <td>${list.customer.email}</td>
            </tr>

        </c:forEach>

    </table>
</form:form>
<script>
    function sendOffer(id) {
        window.location.href = "http://localhost:8080/comment/addComment/" + id;
    }
    function onlinePayment(id) {
        window.location.href = "http://localhost:8080/customer/onlinePayment/" + id;
    }
    function paymentFromWallet(id) {
        window.location.href = "http://localhost:8080/customer/paymentFromWallet/" + id;
    }


</script>
</body>
</html>
