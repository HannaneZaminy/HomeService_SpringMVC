<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Specialist Profile</title>
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
        <c:if test="${specialist ne null}">
        <p>welcome ${specialist.email}
            </c:if>
    </h2>
    <h2>
        <c:if test="${loginSpecialist ne null}">
        <p>welcome ${loginSpecialist.email}
            </c:if>
    </h2>
</div>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"> Maktab Home Service</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/">Home</a></li>
            <li class="active"><a href="${pageContext.request.contextPath}/">Profile</a></li>
            <li><a href="${pageContext.request.contextPath}/specialist/showOrdersToSendOffer">Send Offer</a></li>
            <li><a href="${pageContext.request.contextPath}/specialist/changePassword">Change Password</a></li>
            <li><a href="${pageContext.request.contextPath}/specialist/showRate">show rate</a></li>
            <li><a href="${pageContext.request.contextPath}/specialist/taskManagement">Task management </a></li>
            <li><a href="${pageContext.request.contextPath}/specialist/selectService">select service </a></li>
        </ul>
    </div>
</nav>
<div class="container">

    <div class="col-sm-4">
        <img src="https://c8.alamy.com/comp/2BKW8X8/industrial-workers-working-with-face-mask-vector-illustration-design-2BKW8X8.jpg"
             sizes="100px" alt="Cinque Terre">
    </div>

</div>

</body>
</html>
        <%--<nav class="navbar navbar-expand-lg navbar-light bg-light">--%>
        <%--    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"--%>
        <%--            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">--%>
        <%--        <span class="navbar-toggler-icon"></span>--%>
        <%--    </button>--%>
        <%--    <div class="collapse navbar-collapse" id="navbarNav">--%>
        <%--        <ul class="navbar-nav">--%>
        <%--            <li class="nav-item active">--%>
        <%--                <a class="nav-link" href="${pageContext.request.contextPath}/">Home <span class="sr-only"></span></a>--%>
        <%--            </li>--%>
        <%--            <br>--%>
        <%--            <li class="nav-item">--%>
        <%--                <a class="nav-link" href="${pageContext.request.contextPath}/specialist/showOrdersToSendOffer">send--%>
        <%--                    offer</a>--%>
        <%--            </li>--%>
        <%--            <br>--%>
        <%--            <li class="nav-item">--%>
        <%--                <a class="nav-link" href="${pageContext.request.contextPath}/specialist/changePassword">change--%>
        <%--                    password </a>--%>
        <%--            </li>--%>
        <%--            <br>--%>
        <%--            <li class="nav-item">--%>
        <%--                <a class="nav-link" href="${pageContext.request.contextPath}/specialist/showRate">show rate</a>--%>
        <%--            </li>--%>
        <%--            <li class="nav-item">--%>
        <%--                <a class="nav-link" href=${pageContext.request.contextPath}/taskManagement">Task management </a>--%>
        <%--            </li>--%>
        <%--            <br>--%>
        <%--        </ul>--%>
        <%--    </div>--%>
        <%--</nav>--%>
        <%--</body>--%>
        <%--</html>--%>
