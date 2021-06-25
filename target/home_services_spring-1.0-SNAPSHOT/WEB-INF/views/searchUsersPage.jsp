<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search User</title>
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
<form:form modelAttribute="users" action="/user/searchUser" method="post">
    <table class="table table-striped table-success table-hover">
        <tr>
            <td>
                <form:input path="name" name="name" placeHolder="Name"></form:input>
            </td>
        </tr>


        <tr>
            <td>
                <form:input path="lastName" name="lastName" placeHolder="Last Name"></form:input>
            </td>
        </tr>


        <tr>
            <td>
                Specialist<form:checkbox path="role" value="Specialist"></form:checkbox>
                Customer<form:checkbox path="role" value="Customer"></form:checkbox>

            </td>
        </tr>
        <tr>
            <td>
                <form:button value="search">Search</form:button>
            </td>
        </tr>

        <tr>
            <td>name</td>
            <td>last Name</td>
            <td>userRole</td>
            <td>Registration time</td>
        </tr>
        <c:forEach items="${usersList}" var="list">
            <tr>
                <td>${list.name}</td>
                <td>${list.lastName}</td>
                <td>${list.role}</td>
                <td>${list.registrationDay}</td>

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
