<%--
  Created by IntelliJ IDEA.
  User: itak
  Date: 6/19/2021
  Time: 7:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <title>Select Service</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Maktab Home Services</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">select service</a></li>
            <li><a href="${pageContext.request.contextPath}/">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/profile">Profile</a></li>
            >
        </ul>
    </div>
</nav>
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ19twW9AcFDpuTcpgBRGYp-2_gv80Z3hU23Q&usqp=CAU"
     class="img-circle" alt="Cinque Terre">
<div class="dropdown">
    <form action="${pageContext.request.contextPath}/subService/getSubServiceAdmin" method="get"
          id="serviceForm">
        Service:
        <select name="service" onchange="submitForm()">
            <option value="NONE" label="${selectedService}">${selectedService}</option>
            <c:forEach items="${serviceList}" var="list">
                <c:if test="${list.name ne selectedService}">
                    <option value="${list.name}">${list.name}</option>
                </c:if>

            </c:forEach>
        </select>

    </form>
</div>
<form:form cssClass="p-3 m-3" modelAttribute="newService" action="/specialist/selectService" method="post">
    <p class="text-danger">${error}</p>
    <table class="table table-bordered table-striped text-info">
        <tr>
            <td>
                <form:label path="name">Sub Service:</form:label>
            </td>
            <td>
                <form:select path="name"> <c:forEach items="${subServiceList}" var="list">
                    <option value="${list.name}">${list.name}</option>
                </c:forEach></form:select>
            </td>
            <td>
        <tr>
            <td>
                <form:label path="specialistDtos">specialist:</form:label>
            </td>
            <td>
                <form:select path="specialistDtos"> <c:forEach items="${specialistList}" var="list">
                    <option value="${list.name}">${list.name}</option>
                </c:forEach></form:select>
            </td>

        </tr>
        <tr>
            <td></td>
            <td>
                <form:button name="Order">Select</form:button>
            </td>
        </tr>
    </table>
</form:form>
<script>
    function submitForm() {
        document.getElementById("serviceForm").submit();
    }
</script>
</body>
</html>

