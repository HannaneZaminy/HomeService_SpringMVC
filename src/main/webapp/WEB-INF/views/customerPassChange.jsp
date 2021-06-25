<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <title>change Password</title>
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
            <li class="active"><a href="#">change Password</a></li>
            <li><a href="${pageContext.request.contextPath}/">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/customer/profile">Profile</a></li>
            >
        </ul>
    </div>
</nav>
<img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAATUAAACjCAMAAADciXncAAABUFBMVEV8x///////UAQVKTT/PgD/QwB3yv//wLGmqsCGwd/+RgD/o44dNko2TVtpo859x/8qRFh0tuZysd8RJTEWKjV4wPGD0/8lP1JAZoEPISqC0P8/XnUAAAAAIDoRL0QdN0moqKht0v/u8PEAACYAES7O0dRwwv6cqrRipdUAKD8AGzX0+v+jqbC8vLz+NADm6OmvtLlq1P9hbHeNlJsAAB8AABeboacADSx2fofBkZrwWTP+3dX+1MgAACReaXQAABvHy85HVGH+TRXSjHzejHrUPgCzsa8AGymYtMqspbbVfXPvWj/hcWG7l6TcdWizn631VCbJiov+b039moT+taP+fl/maFbNg37/h2798ez9xriDxemCiY/3Th7+dVv+trD+YDivoJ7HnZCCxebYOADBcV7KZEv+r57RTCnbRwDlZ1elzOUpTmhglrc/ZYE7RU7nPdSUAAAKuUlEQVR4nO2d63/ayBWGTSwRBwtDnAQcYkmWEN1IAXMzgjg1ATcbk4vjxM7NsdNm27TbbdP6///WMxcBQgNOqWQgPc+HDTu8GWZenZk5I41+WVpCEARBEARBEARBEARBEARBEARBEARBEARBEARBkMUiNesGTM9Mmw4/Hl9MZuMd+cG4YeTOeiuLSO9GzjDiV+5ZKm5knj1/IUnyYiJJn18e3jDiVxpu8WrvlSQnri00CenF0dUFXGrJ6L2QZt3nUJD3D6/It1Q88/LH8Iwgv+4ZVzBMU8ZKYjA0EzBDLCDyUBekN0b0plUfeoGWkBLHJ2+vLySr7z5ve8bJ7yMfpdUP3DRZ+vj72CLzaHWfdyWxm4nUs1T1jcx+afvkdNbd/t+5zgdqYjfSaDMO2eWRvzyadY/D4eM2s+19hHNbvMdM2/44696GxidmmxzhkmB8ZqatzrqvIfKIBYLUi0e0LzU+0GlA+pFMA9tYtL2OKNjiZ/SyJN7Nup8hwwapfJiLJNaM5zTU9mfdy9D5yPqVi8K0pTOadGyLszSzVqvVBeXFWq1dFpS3Q5FXQF4QlI9pzDg5dU0+iiL7yD0klSeOBb8KmJZm1wTldVXbE9mQ1+y2WJ7/L+Suo+VFNthieXGM/DqdenbDn9lSqeouDbVgokZ7aaqKxlwzvXL6wbX1ptlXDT44Y+VWWSC3dKG8CLWL5Jq49oqqWwVfMYcto2fhL6N8LXgdMM3cqfGGtkirFe8i13dK1AaFulbf9DrWoAJbsc+JPOvJ3QaXU9fcTS8m8m3y1+GaiORFVWkWfHKHynXmWjnZ5cXFRoW6plDXipsjEbdKh9Fh+EM0fkRqloNZR8227U7sgU37Vc8r+Q676HtKs0b6pedN6K2qZLlcs50OcY3I3bzWrDB5nsltxSnHymlV05m8ZWtWx3PN3dMsLrd47QoM6PIFRC6Tn4Mc7MxS16B2q8iubFOx2jTWSGO6fbkHyz4i2CCwZC04QAubmq7kW6ai2HUwR1fsTVreteCjWiipMEKh+bry2OVyhXRY43Ld3uFyRdEskCuOCebo+g6dzstcDqFZN9MOyBt0dLWbRN7pgGsxd0dTRuRJCHwz6Si6xhpTa+pU7ijNWDEPmr1zfy9o+v459DttqeoxndYCoQaXzlJ0O5tVlK6l6Vq+xcvdJlhlJaF3SVXRVaUTkDswqsFvVl7M2wqVKyBXVLs0LFd0r/aaJ7fsfu26rqqenNhpK7x2fSB3qBxqAC/halZGOvGODqQ7IZu2lDJeENe+BF2DwLehw4AODesOVkCz1tQUht10B/ISyEEKepAXhuR5KtdJFA3lDR1NJWUEZ0geaw3k+WE5XCCOc+GXs9/UfXIOndiks7BdWzL2yYT5R5FrZDqhzdT0kq+4kGS22S3zu+RdLq/55XXug14Ry9tiuTZGXhOkNn+S+V40ZDKJSbupOm2RPZoMlWmQaIFErm7rIrk5Ru5Sl+2OWB7IzJhcDcjTVN4VtZ9mbPKz0F07m+BagawCJPqb/iipN1mM2LbvshfSPBpG5XkeJCPypCf3B5Xb5HLHL+/25b6gci1NJB92rRi6a+wukWiEkglJJy3SNN8EVrGh+aTc9k1gQ3JdG5KXbLCeyhWfnMxfvHatOZiRYLrry520Tz6ofUiueI0BeTawQfBGaLiLaIqvBsEkFy456WYLUqRzcpVVPlkV2OLXgr6Sq9xfLEEOJtbSIG/DcqYqTM7WSpvIi2SxbHpyuvjVoPYWlWuenKQeRO5UWO0srmCthMbUIPOo1YicRy1ZWnUqV2FXBZnS6NzGV4Own8Wnqu/FmUfhMVw/yBPgvy7JNuAi0/KaSppP0vE85OiQae3QDpQ3mVyjcuKPQuUtRyeJKOShjknSUGWP5qflHZDDkKJJMbVT43KovW1Cepencj3fl5MRmCYblSKx06Lyc4vKIV/Lx0wqd/29oGmVHP5dD+MNvRzBOx6uY8H0ZEIeCpkaZPXe7lsj5pC9AdlRQYTxOb5I5TEuT6rNgid3qJzuqFzL232DnMxmKt2AgT+eXCde0mvCaufySpPK2d4A5HtcnqUpGshJYyDX6450Iqobk/FnZOgnTgKuxbpk0JgatQEuqzeXdOjc7e1Dy1lvJu/SmLO5vN6Xdz05cb184ZfzfWisfu6TwwaM2jiovU3lWb4Qu17KXaDyiurJRwYo21G9iuB2Lru9Nu6e5OCehx/PtVEcfZzcEt0paoprL/Lt+CiaWF4ZI4+d0AQhihtsVbocSJ9Evwqu7amW6JbWeV5tiGzYUa2uoLgOclG/GmK5C/LRtIzgOMLGuHvqY5E8RgNCDn9r4N30EO+pgEqlImpQAcpFsQbFJUHxBLkgyyLyouiaTKhdJF+VI7rlscR3B9ek64KfXWxO6Z1DeSWKO+Ap78HeD3BUwc9xIspHe2w9GDtG55KtracF0aAc4lcaalL4m1CGcchmzUV6IOpuEYQLJ4efWXgf2eE/tqu6Ji2KbaZZLpW2Jvt2fTuyRy2cOB+j8pjHe3OF2SFukU+Fp/BBtKYCq9y0owjPmcZX2FmSxLi0bW4weYyx/ysPPvo4/cJPlj2P8nBuyjji5wul47k+KVkgNpU6BaBM87+SwLbTE37KNPEy2qO5A9uuSa/fzu3RPxicFWoZw2RFvkF6+umddzJXflmN1DTAWOkfm5cl6fhkdc44eUQirfLLkz8wnjwhn05ptP25L3qXkCTvNLP0oRr9K1Xxv7weeqklMWfI+3QW++Xrz4R9Xrr/c4ykbltfPdlQB6RnkUfaEnlLo/pwe25fBiLLFAxP6tlvg+LELjGz8tffAvr3Z1fycgsEs5F5Pq++Jej4/BsxzVcu/RqLPYUQ9Iul3d5VBJqHkXm4L82hcYmPzJxR08A2Gmx/HwRbQt5+3qte6euOqaV49cbhq2vbs363Z4TttzETQu3r16+Cb2LkG/4Kk/yPN73qlb8iukReQzaq1cyN+eIBDNCna0Dgm3/GYpWt3to6+XxmVI3cDCxjpObt3fffPSCJ2f21tTsBT1IkZ/vp/n36RWqR39oPHXCttFUE1wRfkXXip/trMwux+cVzbT3ojeda6MetFh/PtZuCr9C1caBr04CuTQO6Ng3o2jSga1OQizPX1u9kcqPE0TUhubONbya45n67J4LsDerfNtA1P2d6UieubWWTArLUNfgqmjcaF5XcRpK41nkqdi1NHvG52eTFv6J5fXZByd0Da1qtWrstMi2Z9L7auIlb0QHEtUmk0+zPjfuCXer/LZn0ZNc8/r2+hveJ+mSyt7/HtFvgGq6jfTLZWwEajYPRorsb6NoQ4Nry8u1hbh1slS4OfEW3l9E1H5ns8gj0HPXFLX8huuYj4NqtC3Kgwz1A1yYQjLVl4to5ujaJoGsH57AfaCyjaxMQxNqmGWsdoGuTELj2GF27DHRtGgSuNdC1yxC4ttzYPLiNrk1C5NryqGfo2ghC14Kgaz7QtWlA16YBXZsGdG0a0LVpQNemAV2bBnRtGuhzg+9wDZ9RDZP7dvf7Yg3PFQ0RX9+8G3y2F3iwd5e8jTDrts4RufV72fQlZO+RF1/QtSHimfXLIa5d7b8UN/fcWfseMNRGiN+8nFm3EUEQBEEQBEEQBEEQBEEQBEEQBEEQBEEQBEEQBEEQZK75D676DNkQbKFsAAAAAElFTkSuQmCC" class="img-circle" alt="Cinque Terre">
<form:form modelAttribute="changePassword" action="/customer/changePassword" method="post">
    <form:input path="password" placeHolder="New Password"/>
    <form:button value="changePassword">change password</form:button>
</form:form>
</body>
</html>
