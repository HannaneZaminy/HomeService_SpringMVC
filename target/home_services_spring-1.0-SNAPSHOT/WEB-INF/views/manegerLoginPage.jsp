<%--
  Created by IntelliJ IDEA.
  User: itak
  Date: 6/9/2021
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>manager</title>
</head>
<body>

<p class="text-danger">${error}</p>
<form:form cssClass="p-3 m-3" modelAttribute="manager" method="post" action="login">
    <p class="text-danger">${error}</p>
    <table class="table table-bordered table-striped text-info">
        <tr>
            <td>
                <form:label path="userName">UserName:</form:label>
            </td>
            <td>
                <form:input path="userName" name="email"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:errors path="userName" cssClass="text-danger"/>
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
    </table>
</form:form>
</body>
</html>

