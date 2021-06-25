<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Offer</title>
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
            <li class="active"><a href="#">My Offers</a></li>
            <li><a href="${pageContext.request.contextPath}/">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/specialist/profile">Profile</a></li>>
        </ul>
    </div>
</nav>
<form:form method="get" action="/customer/showOffers">
    <table class="table table-striped table-success table-hover">
        <tr>
            <td>id</td>
            <td>duration Of Work</td>
            <td>offer price</td>
            <td>start time</td>
            <td colspan="2">specialist</td>
            <td colspan="2">order</td>
            <td>select offer</td>
        </tr>
        <c:forEach items="${offersList}" var="list">
            <tr>
                <td rowspan="3" >${list.id}</td>
                <td rowspan="3" >${list.durationOfWork}</td>
                <td rowspan="3" >${list.offerPrice}</td>
                <td rowspan="3" >${list.startTime}</td>
                <td>name</td>
                <td >${list.specialistDto.name}</td>
                <td>id</td>
                <td >${list.orders.id}</td>
                <td>
                    <a onclick="selectOffer(${list.id});" href="#" id="link">accept</a>
                </td>

            </tr>
            <tr>
                <td>last name</td>
                <td>${list.specialistDto.lastName}</td>
                <td>description</td>
                <td>${list.orders.description}</td>
            </tr>
            <tr>
                <td>email</td>
                <td>${list.specialistDto.email}</td>
                <td>date of work</td>
                <td>${list.orders.dateOfWork}</td>
            </tr>
        </c:forEach>

    </table>
</form:form>
<script>
    function selectOffer(id) {
        window.location.href = "http://localhost:8080/offer/selectOffer/" + id;
    }
</script>
</body>
</html>
