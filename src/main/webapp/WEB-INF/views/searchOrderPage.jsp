<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: itak
  Date: 6/17/2021
  Time: 9:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Order</title>
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
            <li class="active"><a href="#">Search User</a></li>
            <li><a href="${pageContext.request.contextPath}/">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/profile">Profile</a></li>>
        </ul>
    </div>
</nav>
<form:form modelAttribute="orders" action="/user/searchOrder" method="post">
    <table class="table table-striped table-success table-hover">
        <tr>
            <td>
                Service:
                <form:select path="serviceName" > <c:forEach items="${service}" var="list">
                    <option value="${list.name}">${list.name}</option>
                </c:forEach></form:select>
            </td>
            <td>
               subService:
                <form:select path="subServiceName" > <c:forEach items="${subService}" var="list">
                    <option value="${list.name}">${list.name}</option>
                </c:forEach></form:select>
            </td>
        </tr>
        <tr>
        <td>
            start Date:
            <form:input type="date" path="minDate"/>
        </td>
            <td>
                End Date:
                <form:input type="date" path="maxDate"/>
            </td>
        </tr>
        <tr>
<%--stuse--%>

        </tr>
        <tr>
            <td>Register Time</td>
            <td>Price</td>
            <td>customer name</td>
            <td>customer lastname</td>
            <td>situation</td>
            <td>subService.name</td>
            <td>service.name</td>
            <td>specialist Name</td>
            <td>specialist lastName</td>
        </tr>
        <c:forEach items="${ordersList}" var="list">
            <tr>
                <td>${list.dateOfOrderRegistration}</td>
                <td>${list.proposedPrice}</td>
                <td>${list.customer.name}</td>
                <td>${list.customer.lastName}</td>
                <td>${list.situation}</td>
                <td>${list.subService.name}</td>
                <td>${list.subService.service.name}</td>
                <td>${list.specialistDto.name}</td>
                <td>${list.specialistDto.lastName}</td>

                    <%--                <c:if test="${list.role eq 'Customer'}">--%>
                    <%--                <c:if test="${list.n eq 'Customer'}">--%>
                    <%--                    <td> </td>--%>
                    <%--                </c:if>--%>
                    <%--                <td>${list.s}</td>--%>
            </tr>
        </c:forEach>
    </table>
</form:form>
</body>
</html>
