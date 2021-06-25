<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <title>online Payment</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
</head>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Maktab Home Services</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">online Payment</a></li>
            <li><a href="${pageContext.request.contextPath}/">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/specialist/profile">Profile</a></li>>
        </ul>
    </div>
</nav>
<body>
<form:form modelAttribute="onlinePayment" method="post" action="/customer/onlinePayment">
    <form:input path="creditNumber" placeHolder="account number"/>
    <form:errors path="creditNumber"/>
    <br>
    <br>
    <form:input path="password" placeHolder="password"/>
    <form:errors path="password"/>
    <br>
    <br>
    <form:input path="cvv2" placeHolder="cvv2"/>
    <form:errors path="cvv2"/>
    <br>
    <br>
    <form:input path="expireDate" placeHolder="expire date"/>
    <form:errors path="expireDate"/>
    <br>
    <br>
    <img src="${pageContext.request.contextPath }/captcha">
    <br>
    <br>
    <form:input type="text" name="captcha"  style="margin-top: 5px;" path="captcha" />
    <form:errors path="captcha"/>
    ${error}
    <br>
    <br>
    <a href="${pageContext.request.contextPath}/customer/onlinePayment">Ray loaded captcha</a>
    <form:button name="pay" value="pay">pay</form:button>
</form:form>
</body>
<div style="direction:rtl;" id="countdownMoisrexTimer"><a href="${pageContext.request.contextPath}//moisrex.rozblog.com/">CountDown JavaScript Codea>div>
    <script>
        var endDate=new Date().getTime()+600400;
        // year, month-1, day, hours, minutes, seconds, milliseconds
        var year,month,days,hours,minutes,seconds;
        var timer=document.getElementById('countdownMoisrexTimer');
        setInterval(function(){
            var nowMir=new Date().getTime(),
                pased=(endDate-nowMir)/1000;
            year=parseInt(pased/(60*60*24*30*12));
            pased=pased%(60*60*24*30*12);
            month=parseInt(pased/(60*60*24*30));
            pased=pased%(60*60*24*30);
            days=parseInt(pased/(60*60*24));
            pased=pased%(60*60*24);
            hours=parseInt(pased/(60*60));
            pased=pased%(60*60);
            minutes=parseInt(pased/60);
            seconds=parseInt(pased%60);
            if(nowMir<endDate)timer.innerHTML=minutes+' دقیقه و '+seconds+' ثانیه';
            else{

             timer.innerHTML= 'زمان به پایان رسیده است.';
                window.location.href = "http://localhost:8080/customer/cancelPay"
            }
        },1000);
    </script>
</html>
