<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: itak
  Date: 6/17/2021
  Time: 6:16 PM
  To change this template use File | Settings | File Templates.
--%>
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
            <li><a href="${pageContext.request.contextPath}/specialist/profile">Profile</a></li>
            >
        </ul>
    </div>
</nav>
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ19twW9AcFDpuTcpgBRGYp-2_gv80Z3hU23Q&usqp=CAU" class="img-circle" alt="Cinque Terre">
<div class="dropdown">
    <form action="${pageContext.request.contextPath}/subService/getSubServiceForSpecialist" method="get" id="serviceForm">
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
    <table class="table table-striped table-success table-hover">
        <tr>
            <td>Name</td>
            <td>Base Price</td>
            <td>Select </td>
        </tr>
        <c:forEach items="${subServiceList}" var="list">
            <tr>
                <td>${list.name}</td>
                <td>${list.basePrice}</td>
                <td>
                    <a onclick="select(${list.id});" href="#" id="link">select</a>
                </td>
            </tr>
        </c:forEach>
    </table>
<script>
    function submitForm() {
        document.getElementById("serviceForm").submit();
    }
    function select(id) {
        window.location.href = "http://localhost:8080/specialist/selectService/" + id;
    }
</script>
</body>
</html>
