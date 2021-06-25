<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<img src="https://banner2.cleanpng.com/20190430/ekz/kisspng-executive-manager-organization-illustration-manage-5cc8200f1b01c0.8307143615566192791106.jpg" class="img-circle" alt="Cinque Terre">
<div class="btn-group mt-5 ms-5">
    <a href="<c:url value="/"/>" class="btn btn-outline-primary ">Home</a>
    <a href="<c:url value="/admin/login"/>" class="btn btn-outline-primary active">Login</a>

</div>
<p class="text-danger">${error}</p>
<%--@elvariable id="manager" type="ir.maktab.data.domain.Manager"--%>
<form:form cssClass="p-3 m-3" modelAttribute="manager" method="post" action="login">

    <p class="text-danger">${error}</p>
    <table class="table table-bordered table-striped text-info">
        <tr>
            <td>

                <form:label path="userName">userName:</form:label>
            </td>
            <td>
            <form:input path="userName" name="userName"/>
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
