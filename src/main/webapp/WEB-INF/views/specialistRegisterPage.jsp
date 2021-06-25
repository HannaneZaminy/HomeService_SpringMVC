<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>specialist register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<img src="https://en.pimg.jp/055/278/054/1/55278054.jpg" class="img-circle" alt="Cinque Terre">
<div class="btn-group mt-5 ms-5">
    <a href="<c:url value="/"/>" class="btn btn-outline-primary ">Home</a>
    <a href="<c:url value="/specialist/register"/>" class="btn btn-outline-primary active">Register</a>
    <a href="<c:url value="/specialist/login"/>" class="btn btn-outline-primary active">Login</a>

</div>
<form:form cssClass="p-3 m-3" cssStyle="" modelAttribute="specialist" action="register" method="post">
    <p class="text-danger">${error}</p>
    <table class="table table-bordered table-striped text-info">
        <tr>
            <td>
                <form:label path="name">Name :</form:label>
            </td>
            <td>
                <form:input path="name" name="name"></form:input>
                <form:errors path="name"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="lastName">Last Name :</form:label>
            </td>
            <td>
                <form:input path="lastName" name="lastName"></form:input>
                <form:errors path="lastName"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="email">Email :</form:label>
            </td>
            <td>
                <form:input path="email" name="email"></form:input>
                <form:errors path="email"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="password">Password :</form:label>
            </td>
            <td>
                <form:input path="password" name="password"></form:input>
                <form:errors path="password"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="image">Password :</form:label>
            </td>
            <td>
                <form:input path="image" name="image" type="file" id="image"></form:input>
                <form:errors path="image"/>
            </td>
        </tr>

        <tr>
            <td></td>
            <td>
                <form:button name="register">Register</form:button>
            </td>
        </tr>
    </table>
</form:form>
<script>
    const imageFile = document.getElementById('image');

    imageFile.onchange = function () {
        const maxAllowedSize = 300 * 1024;

        if (this.files[0].size > maxAllowedSize) {
            alert("Image File is too big!");
            this.value = "";
        }
    }
</script>
</body>
</html>
