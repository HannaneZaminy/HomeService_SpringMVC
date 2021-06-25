<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home Service</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div  class="jumbotron text-center">
    <h1 >  Maktab Home Service</h1>

</div>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"> Maktab Home Service</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="customer">I am Customer</a></li>
            <li><a href="specialist">I am Specialist</a></li>
            <li><a href="admin">I am Manager</a></li>
        </ul>
    </div>
</nav>
<div class="container">

        <div class="col-sm-4">
            <img src="https://i.pinimg.com/736x/5c/f8/fe/5cf8fe451505647ca48ec76ef1f2cb96.jpg"
                  sizes="100px" alt="Cinque Terre">
        </div>

</div>

</body>
</html>
<%--
<html>
<head>
    <title>wel come Home Service</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<img src="https://www.serviq.net/app_file/images/blog/postlarge/6d95f346-82e3-e911-a94d-00163e5973c9.jpg"
     style="solid-color: coral" sizes="50" class="img-circle" alt="Cinque Terre">
<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">

            <li class="nav-item">
                <a class="nav-link" href="customer">I am Customer</a>
            </li>
            <br>
            <br>
            <li class="nav-item">
                <a class="nav-link" href="specialist">I am Specialist </a>
            </li>
            <br>
            <br>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin">I am Manager </a>
            </li>

        </ul>
    </div>
</nav>

</body>
</html>
--%>
