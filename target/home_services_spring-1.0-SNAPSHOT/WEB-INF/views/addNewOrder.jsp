<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <title>New Order</title>
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
            <li class="active"><a href="#">New order</a></li>
            <li><a href="${pageContext.request.contextPath}/">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/customer/profile">Profile</a></li>
            >
        </ul>
    </div>
</nav>
<img src="https://thumbs.dreamstime.com/z/concept-de-processus-d-ordre-comment-passer-commande-illustration-moderne-et-simplifi%C3%A9e-vecteur-112496849.jpg" class="img-circle" alt="Cinque Terre">
<div class="dropdown">

    <form action="${pageContext.request.contextPath}/subService/getSubService" method="get" id="serviceForm">
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
<form:form cssClass="p-3 m-3" modelAttribute="newOrder" action="/order/createOrder" method="post">
    <p class="text-danger">${error}</p>
    <table class="table table-bordered table-striped text-info">
        <tr>
            <td>
                <form:label path="address.city">City:</form:label>
            </td>
            <td>
                <form:input path="address.city" name="city"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:errors path="address.city" cssClass="text-danger"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="address.street">Street:</form:label>
            </td>
            <td>
                <form:input path="address.street" name="street"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:errors path="address.street" cssClass="text-danger"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="address.zipCod">ZipCod:</form:label>
            </td>
            <td>
                <form:input path="address.zipCod" name="zipCod"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:errors path="address.zipCod" cssClass="text-danger"/>
            </td>
        </tr>
        <tr>

        <tr>
            <td>
                <form:label path="dateOfWork">Date :</form:label>
            </td>
            <td>
                <form:input type="date" path="dateOfWork" name="dateOfWork"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:errors path="dateOfWork" cssClass="text-danger"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="description">Description:</form:label>
            </td>
            <td>
                <form:input path="description" name="description"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:errors path="description" cssClass="text-danger"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="subService">Sub Service:</form:label>
            </td>
            <td>
                <form:select path="subService.name"> <c:forEach items="${subServiceList}" var="list">
                    <option value="${list.name}">${list.name}</option>
                </c:forEach></form:select>
            </td>

        </tr>
        <tr>
            <td></td>
            <td>
                <form:errors path="subService" cssClass="text-danger"/>
            </td>
        </tr>
<tr>
    <td>
        <c:forEach items="${subServiceList}" var="list">
           base Price ${list.name}: ${list.basePrice}
            <br>
        </c:forEach>
    </td>
</tr>

        <tr>
            <td></td>
            <td>
                <form:button name="Order">Order</form:button>
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
