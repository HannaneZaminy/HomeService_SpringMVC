<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: itak
  Date: 6/08/2021
  Time: 12:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="jumbotron text-center">
    <h1>Login page</h1>
</div>

<div class="container">
    <div class="row">
        <div class="col-sm-4">
            <h3>Customer Login</h3>
            <form:form cssClass="p-3 m-3" modelAttribute="loginCustomer" action="customer/login" method="post">
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
                </table>
            </form:form>
        </div>
        <div class="col-sm-4">
            <h3>Column 2</h3>
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
        </div>
        <div class="col-sm-4">
            <h3>Column 3</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
            <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
        </div>
    </div>
</div>

</body>
</html>
