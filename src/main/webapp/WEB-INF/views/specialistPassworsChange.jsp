<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="changePassword" action="changePassword" method="post">
    <form:input path="password" placeHolder="New Password"/>
    <form:button value="changePassword">change password</form:button>
</form:form>
</body>
</html>
