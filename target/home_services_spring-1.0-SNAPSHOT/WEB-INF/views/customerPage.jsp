
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="td" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fom" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<img src="https://y26uq11r8xr1zyp0d3inciqv-wpengine.netdna-ssl.com/wp-content/uploads/2019/10/52-1-1024x600.jpg" class="img-circle" alt="Cinque Terre">
<div class="btn-group mt-5 ms-5">
    <a href="<c:url value="/"/>" class="btn btn-outline-primary ">Home</a>
    <a href="<c:url value="/customer/register"/>" class="btn btn-outline-primary">Register</a>
    <a href="<c:url value="/customer/login"/>" class="btn btn-outline-primary active">Login</a>

</div>
<form:form cssClass="p-3 m-3" modelAttribute="loginCustomer" action="login" method="post">
    <p class="text-danger">${error}</p>
    <table class="table table-bordered table-striped text-info">
        <tr>
            <td>
                <form:label path="email">Email:</form:label>
            </td>
            <td>
                <form:input path="email" name="email"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:errors path="email" cssClass="text-danger"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="password">Password :</form:label>
            </td>
            <td>
                <form:password path="password" name="password"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:errors path="password" cssClass="text-danger"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:button name="login">Login</form:button>
            </td>
        </tr>
        <a href="#">Forgot password?</a>
    </table>
</form:form>
</body>
</html>
