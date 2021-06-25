<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome admin</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="jumbotron text-center">
    <h1> Maktab Home Service</h1>
    <h2>
<c:if test="${manager ne null}">
   welcome ${manager.userName}<
</c:if>
</div>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"> Maktab Home Service</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/">Home</a></li>
            <li class="active"><a href="${pageContext.request.contextPath}/">Profile</a></li>
            <li><a href="${pageContext.request.contextPath}/user/searchUser">Search Users</a></li>
            <li><a href="${pageContext.request.contextPath}/service/addNewService">Add Service</a></li>
            <li><a href="${pageContext.request.contextPath}/subService/addNewSubService">Add Sub Service</a></li>
            <li><a href="${pageContext.request.contextPath}/order/searchOrder">Search Orders</a></li>
            <li><a href="${pageContext.request.contextPath}/subService/selectService">Select a specialist for the service</a></li>
        </ul>
    </div>
</nav>
<div class="container">

    <div class="col-sm-4">
        <img src="https://darvideo.tv/wp-content/uploads/2019/08/Project-Manager.jpg"
             sizes="100px" alt="Cinque Terre">
    </div>

</div>

</body>
</html>

