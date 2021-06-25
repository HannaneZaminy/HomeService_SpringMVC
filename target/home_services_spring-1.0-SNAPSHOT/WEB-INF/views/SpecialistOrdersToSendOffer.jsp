<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task management</title>
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
<form action="${pageContext.request.contextPath}/offer/sendOffer/" method="post" id="serviceForm">
    <table class="table table-striped table-success table-hover">
        <tr>
            <td>id</td>
            <td>date of work</td>
            <td>situation</td>
            <td colspan="2">subservice</td>
            <td colspan="2">customer</td>
            <td colspan="2">address</td>
            <td colspan="2">send offer</td>

        </tr>


        <c:forEach items="${ordersList}" var="list">
            <tr>
                <td rowspan="4">${list.id}</td>
                <td rowspan="4">${list.dateOfWork}</td>
                <td rowspan="4">${list.situation}</td>
                <td rowspan="2">name</td>
                <td rowspan="2">${list.subService.name}</td>
                <td rowspan="2">name</td>
                <td rowspan="2">${list.customer.name}</td>
                <td>city</td>
                <td>${list.address.city}</td>
                    <td rowspan="4">
                        <a onclick="sendOffer(${list.id});" href="#" id="link">click</a>
                    </td>
            </tr>
            <tr>
                <td>street</td>
                <td>${list.address.street}</td>

            </tr>
            <tr>
                <td rowspan="2">base price</td>
                <td rowspan="2">${list.subService.basePrice}</td>
                <td rowspan="2">last name</td>
                <td rowspan="2">${list.customer.lastName}</td>
                <td>zipCod</td>
                <td>${list.address.zipCod}</td>
            </tr>

        </c:forEach>

    </table>
</form>
<script>
    function sendOffer(id) {
        window.location.href = "http://localhost:8080/offer/sendOffer/" + id;
    }

    function endOfWork(id) {

        window.location.href = "http://localhost:8080/order/endOfWork/" + id;
    }
</script>
</body>
</html>
