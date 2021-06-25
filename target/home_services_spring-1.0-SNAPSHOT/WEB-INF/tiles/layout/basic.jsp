<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: itak
  Date: 6/17/2021
  Time: 5:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
</head>
<body>
<div>
    <tiles:insertAttribute name="header"/>
</div>
<div id="container">
    <tiles:insertAttribute name="bady"/>
</div>
<footer>
    <tiles:insertAttribute name="footer"/>
</footer>
</body>
</html>
