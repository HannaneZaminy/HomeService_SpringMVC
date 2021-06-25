<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <title>New Sub Service</title>
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
            <li class="active"><a href="#">New Sub Service</a></li>
            <li><a href="${pageContext.request.contextPath}/">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/profile">Profile</a></li>
            >
        </ul>
    </div>
</nav>
<img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAARgAAAC0CAMAAAB4+cOfAAAA51BMVEX///8AQob//v8AQ4b///0AQoj///z9//8AQ4QAQokAP4YAQor9//0ARIQAQ4kARIYAO4UAJnUAJ3MAM38AOYIAJXYAMHQAK3QARIEALnkAOID4//8APoEANH8ALHIAPIIANHbO3OPp8PIAOXfe6O+0x9PD0NoaRn+qu80AIHMAO3VEZJIAIm8AK27k7PEAJ3oAHXQpUIGwvc1Vc5gAFWSQprdac55sh6g8WY2aq8FJaJV9la3D0te9ytZkfptJZox7k69rhaovU4xwiqTO2ucSRXMAG3ikscfi8vqZqbgAM4WMobkAImi+EgdjAAAT3UlEQVR4nO1dCVvbSBJVq7t1H7Z8CtkYC+MDHBNgCYHEGTaTXTZh/v/v2apu+cSAbAyRid58k3xDMpZUrnr1qrq6pSg5cuTIkSNHjhw5cuTIkSNHjhw5ngdj7HffQjah67tmGLbw26tdofOaV9gSmOLo4Njg3KrCHEdXHR1+V1/pYrquOUp08a+uCCc16+bRoyjudOIoEv+lgm1e6Y4Z03Sl3SjbAVhGZdor2X8riL9efjo7GAZBbRg0Tq7u2vAznemvci1wGEW5rlgGIcWviqZnmoKjz6cNYhjE8zi3Wq1SeHDV1V+JAsAQ8UnIfZNScwCWyXYo6SdNatq+wTmlFP7lhaB3HUFAKUzV9W05uw6fBebu7rUoNwgnhAdfFfV1HHM7APe+aboGN12SwOS0GYBpkBEUbVvXAVZXlC8Da3IV4oLPZDmWdIj1kz1qU39yxz7nLi8dj5Fr1K3RI3jH6KRpEjq1TOOfKMN2wSSkRTd7dHbDlHuGSazgW8Qwd28HuqOc1xom9afXoafnW/rsVwKKmOik7Jpk8m0alENc+Xv1tqJvwzDCL6KrIgUa8/nEMM2/FYyujCM6afoYRGQe1v4Y4gyC4IXxxEAWdc6as2BFr2x8j5Ts24Ux/WbPoLaxYBhuV/pY1ryIgMFdwK79wKqb5vSTwUSVjqZnWuAJMBUZ2IZcPW8Yg/pBH3zmZYYBy0TfipRwf2Z23w7vFF17JR25RagqZG3ITYuhRKjNB13lxTKsfdx0QdX55uzjyxdAx9m3Czw7FHTAMyBnfDr1eEp8ymsdpm1oGQhC9JfLgAOrg4AUHmPir9ZxhH/iZDpdTwE+g0qPLxKN1dM3dBmVQa2uxH+Fi27oQcDWfqCA2hlokLWpOZ880G2aV8pmHKlhLdo9aJkLAUo94oX3+IdbvvvXAyo94JlFoqHUG3Y3+zzUQF+GIKMXLO1y3jhRnGzXj0twkGfKxkzpidRErLPNvN5R4rMS55QsgBK3GkMJthXp+HZABnbNufoAHoTu94Em1w8n1v3QWkpzwi6V8Svc+GuDgWX26tw0ZqbhnBwAIWzwBZ+UPbpsGCgFbrd+128AmbW9eZfhnP86VzbQHKN9vkTkCOtMYTuSpucBhhHRxKcxwOXDbJCZ7vfIYuZH6uL7I5a1hITS/tlbYmCB6HNrFgPCQsX2moZhjqL3OKTmBbhc9Bqy1p5iULSlCQjG4uPGwgPx1v36l+suCTuASZvf1v+gV4eDpknx91RN6QaLIWD11msRYK/4qvDAMJT0ogwW1Jddlk48aPBU5Xkt49u10VqXgi8g2n9gF8IHnSx2Gj5V2sgxz9MMOFY8JHOZyaPNo/WupSr90gNlR8Kfm977a0HHvkLP+tBWHF1L5TUXZT7r59G1ScZRPjeWSguKvYas9eywORkPPb7fRgpJY5nz5pyW93nrYq3rqWw0sJabO9ZhpEVbW47ZDlDQ/wh9YtXaKaVavM+NOY+xPq91PU25bS3Ri8crXSDldP76ZsC5gnGJerxRS9v5P7PmGjMeaURrXfBnzTSXOKZ0j2VF5mpHppyXCD5qiD6jPd/4v7HmRB73g/SGAXbvV0jSvaDUo4Zrmo3SiTRKxsQd3FK/JO4TeQZ0/7Nf3L9bcwmb02Fqw4Cu7Z/OfI1TbvNW2LiPM9ninRiGeAavCcs8/fcZGmbGm5ym9xhduSvOJSNOC82DC+w0OFkrBRA65hn86g0g0lqbPV8bfGrNtfI4WSOU7gJ/mtF4o3V69jOGn2psa8u924SusHFJZgcQFIGwzNP3eWbNshKxyV46w4BPgL/wRBxSHh7edsRPdaZmstngJEWduGFKQOkpj68D4jheVOXzzV/je5qrMCiq+9M4ol7jcLxeMnt7wKOOipN2PRcMDLlp9Veoon9BGTmzi2dYN2muojvgLzP1Y1VHaORNl6XeBNiZO+BceowHv2HWfsRjGD7gbYHMpC83C7eprqL0g1kusw46OC6UyQiagsE/N41JKAHRkFr7sb8L/qJHAafmTOC55XS1EsSRN7PLCMe1NmmjvzG+NCcdWI5yH3xG1Vd1aFBv3DfJHMXYPi/28edPPSOI/X5x4pS+iXaR9J5pj0Eg+84IgADPMHXl4KqmjMLF0th1zUpfUZ5iUqDyOd41kV92BVF1/mGBUFHprZoB15WTxRKQ2rzOP/afnLJ05nUdsQ53xy6K8q08u3Oh9MKVSo8pfzcXC8A6RB6lGE1PfHq/6E7rRqva2WTB5XehW5wXs6D0zA8/5nr2070ytyFdNIxNDU59f9AXzLzik3XBu3KZzicc4yhrLakngD28hecFfq31MWs7kDw0poocokQXVbJqBZEb9rCvrFoUYmAFqKcT+B7m6V2Cyu5Ki101n9SDC9wig40SzKvw0EfHZUpX2IUSu44zeSs6Tfq8XSDlVTuZT0SLYPrekhOAhmsFVz+mzxqdn4WW59GlFUQBlwCFPMIz/drM4kLXveFTvRzAhv3FRTDUtpSUw963y/PxuH9/s18iOLvNyUOX4cTlLqfFVVPLoF+mQkDw7ps/24uAszqfC9yfDWeLti7YgReapdKvUrOB5Mx9wh9MbySRB3J4cISDNLMkr4m6cUHX7ZhdUIOxztDg3sqnTgXqGmblfH5+bkHXAe9Wd4t3J9CVy5CS1f6QCjap88H8UAjWATNGQn/ZPai6Bjr3orwq56REHefQSGWeZ/oVY1qGI+/ukK6bwlGZo+lnhc09xiZgBW5UpNLDkh11HZW6jghdt4N2QQAvxo2WwZcXfdYBp/ZQRhP2vacftXO6bhHwjY6OW8R9+tmfglB6RbQM2OZogOUC/tiiO8q7CRzVUeLvZeMFBIxKjw4Sy3SDZGxK9DF/99NtDiY22UQ34eahlCi903PchQyWGYhY2rF6+gHEIin8clmzUOfRB/PJqUDxf/x4pKi4htYN8ENEX2qHDSMgd5yFFscdxRvGFK+bWB1grf11SBo7zbtTqCzCBsph1YIv/uEkbhr4nBg28gwoAKU73N9pfpkCtzlqGtOve2HL34xsqG+7lILSU9Fnxu0daHmnABMbQKEO1LvfgrBsielvnLnjtEFWDHOvgF3HIKSVI0UOCLDsL5KsAwioqHt/4ga1UrPZLP0K9r8bBZqaj3ndw1o7a4PeWwBTHGzN6vGP8Tlg3ImV0UEjdXBxUyi9nU9GD+EwXCuc/8YdpXNoPW8SCZcD0UDWfn8eg8NfaBmAogolCxVD58AiKzp4KxyGupDTjNM1R4B3BGLJRC6cyH8Z+oyZrpbiBJOa4Jnf/Bhvg85hetnHed0e/jmWOUjNM0LpVTba6LVzgLhKbxnftw1DRNMfAPj2O1Vr1RrKilCqc+xCVI4eW719bwCfSb2aAOnJ/teR3EL3/tE5bKTumiMD/yE8I7N2WpdxuUn58M/gGV0ycDqnMcRRGZX3bxlQwg5WBwfWysGHh6GEPE2pWL197wQMOVtnEE2pS21q1+k7rbUngLSr4dgi+kw1Nc9QG5RecLS9EwWzB6FHHA0KSm0NpQeJidaxQ/5+IZqVxzFzVJWtUWu7xLc5Kr1n5oF3F2iXoNCL8XAKZy2lR6iBFaX6LnkGu7fjwOKFsxg33+qoZ9aqtd9nT0+ko25QMHze6sWaOKquc/DwMIJHHAaVHim+y54ebrcNTINyzsu9mDG2lgamhpfomfcGTcUlV2Bbz/DAMIrm4DFbmLVT6Rmh9Awuau0s7oDcFLjWNJYTdZS2zvCUUBVEDSq9R+YVV3kNKD3I2pnbYP0C4CBEt2KLx/ML32Owyk/cFKyu07nC7Tw+L47fU8pmyC82EUuRBfAXTbkeAM84ur6OZVDpvauens6QXyzfx21emKyZcn2KuUlKPrBMurrJFEpP5Kb3EU0QSF250xPtEgENXxddYoBl5ANirZ02nLCn906UntB1ckeAgXEExrg+dSlkX9TAAp3j9SxTGe8+A4u6EXWdeCiMI0e5Bjlj18FUZWkZqA5qaXnGcG3qEmDgXa+10TDjIOEQ5F2Io8CilBsUZYk8A3KdWpv6mN93v9bGPF3EBVePijwN/nKKWzA4HmU3gNQLpQGerIKrKmlGjYTqMUV/Rt2B/cWPAXUd6l38pinyLvDLoO5C4oXKgAhJ0ok1hqczrLN6S2md/vco2+/xeBLIu92iLffVFL7LOCKG7XNSqPunSBTxIdbawmfWWL21TXc3j2JNIPTLoq6rWCBm6sSvYxwxJT5oACFDrY1Kr5TaMnWKnatdtYwuR3Wp1HXfUdfdnZoo86jr8dMj4JsRVteQm1SmO1LppRppxPdWeD4foNLbQZ5hE36hlKBboK7zwUwuMK8F/uJAHKGP8NZZLOsfyNrp9QwkbmTgrJ+W8gB4GGu3JupG5N1Y6jpMRwQ0TA3jaJR08PzSf5LCcI2eHvqdPRjvWk9PZ2KbRKLrsCyCOCqaFModfD3UfwXvHk84pZacXQtKL0yt9Ax8PcbOKT3JL8k52C2h6+5A1xEPmJjikqvOII6oaFJZ+x08txWgOusoPQOHz3dI6eFKI45tSH7xoD76HmtC15kuRXLFNpwm+AVPkvGsanu+JuxUC6mG7aXSEz6zWxVlousM9BfQdXendVyfd7lIJlrCu0A/aJeFaOgcpO/pudw1d4hnmNQvia4DfgG7hELX+bZBA2z1T/iF82pbzr5O/+d1lB6xoeYa7ExPb1HXxXhQWwDZxq9zWvc/Al0ytIuwW6MqTrSajwWoKPfTWsatg/kxmrIOfD7cZNGtSV2H/MJQ1+H2JZO6HIeaRRxBDYmnvgHvYn9zniPEelPKOT3bp3XPJ0IUZbqrhw+Y1NMEXy9VwKU1yNMGpCeXE9MaCrvIE9Wpb+0/cgIaKL1V56msBnftf8AymTaMnAfvyv6LQWW/7m7gEhu3DtcJSlXwl2R/ttztuOJ52FoMzEHSYIBmmWh0wS+1gqAXs9ETcYT9OpfiybYgOjQ2mvAL+oum6qsmpRylnZpnqG9TlwbdTJ9EhN9+t2ZJHdLqRah3A8sAMYYTY5CndeQXOWSGeRqfZYVyxa0Zz00W8XKz1MStYjbGKTHXPK3+rSHXYQn1ZH0kDuA18WW0xCSnszxtUmGXRwUIpu921eIPj+GRm3NNK+zd9sf927OwBVIJCjCoRPHFO1lVeg4byZOIJ3XjHdSNOOMNGWgg7DLRdXgm5zNVTucDMR8Yhvg2cb3qyddkr2T7JrR9tHQ9vHu914y/GKr+vSH33SS67pSDrjO57ZIgsQuX3zueO8meGYVvr1J6kPjt2qWo3kEYgAC6rlmm4XrEPBQDoRnFZUkOSeE6Ceo6Q+g6IhbjpX4R0YEnrzvq03OY8OftFasqpuvVruV7txiUYI6j9APbdbnphudZfdOqrkT/UCF4LRlHFdNDXQdST8bRQcNMdB3G0TPjHJjHgYGX5Ay2i7/JGkIVJA11+d9lH0iLFk6y6TDg18rPJhd9hdL/ME8X6/BU4C/cSuojqeuoeIdBOjaArL04p4dVZ7z4d1gkicscxpkcuGKgsE4asmXQutGVfgXYwBe6rpLk6UTXibOQU+lUzE2LHkN5+Xbp8VXlXrwNhYbZrJkcTY0DmhzpsHfR3/ep5xo+N5I+w3FL8gv6yyO67iHYA6Xnht0l8Q9qMBBfR/M6k/0HYNLuPnelV9iNX/jOeIqvbPko+nXHBVOcB/OErlv5qUuW4WY1XuImMPEQr8r3brNpGEU5ak4KHE7FKXjYyzw9x/UAoeuAd0UcrUOSUulNe3qcHC5FEvKwiDfeutryI20JmtJvLigOF1KIOZjrS+G7YjEfrSnDfnyYqyh5dfmPwYHEF4KGyaLHwAOflxaZEmrHAJvVid4FF5K8u97YpT6v9HwexovCH8+aHojlq/KXLBoGx3bHC4bBpffBebJOIniX1iS/rDmPqik/5ngm7C7GEnBbWx70WfqZxXSNJ5p0Ak5nh3dxm/6SerdlS10n+t4bbImVPCObFbxxJU7DFR+Cq1egduUrl/iyybIBjJDIIHMFMfWNwid9yi9Jnt7w1tv7DS95fVCIqlqmbJyh1lh8IIvNYZRBuwjDKFctz5taBsfsyhej4+R9uqKe3nR0DvWMOGWFUr9wAZpJ1tEMVKWjfGsIw1h/Zbfv2y3SuZdK4alKrT3LEKJe1AFyKW4TAM+IzpVnmDS8V5LjolU8Z/LnqS2+DCgiWSaLJbxXqAlmVZ84YSiZk+IfRD29OQk4Ewa2XTO4VSYco+hfoIQX2boHRs9iLAm0A1yeXhoao5Q0hK576YeHFher4bx5NpZBo4/PSsmkycoTpLMCR/kS+sQ0Fhef4VnAX7bwapt2jZoTQVT/9+XPy6vevqxMPdI62cL9vxogSVyUDGP5+NqEX17qMzpmbRmjNqetZqlZ4MmbqKh1GD//Ab8PQIb6p9BwF4+CbuFb78BoL51kAUYRPEOpAYQuFmEo9wS1N4IthOprAvXv/ccGERvZuMl90+Slz/h2G2cLL6NmonPl4lo+Jb5BfU5d8BjqWrVu2tbX7wNIjpNiwfKF2LMb1YNr/OnW7np09gvPG/Q9TEUu2J5Qs9nrZH6JVqJ7dVj8VSr9Cv856Udb9nH9trgHtZdUBS4lRiO4xWNuM+8x8vRavdPt98ftKPnP7QEef3RVLZUt7C0Tq9UMr0ZIbmIgNtPAMe9pYwEXB7Gfv7V+AHPws+Pzb73BsFIZ9K7OMRvhi7R3at7sVRGPZIbODbIAluaV7H8kcsPkWA/sPW3Yz5EjR44cOXLkyJEjR44cOXLkyJEjx5r4P7rLWKuFMAslAAAAAElFTkSuQmCC" class="img-circle" alt="Cinque Terre">
<form:form modelAttribute="newSubService" method="post" action="addNewSubService">
    <form:input path="basePrice" name="basePrice" placeHolder="basePrice"></form:input>
    <br>
    <br>
    <form:input path="name" name="name" placeHolder="name"></form:input>
    <form:errors path="name"/>
    <br>
    <br>
    <form:input path="description" name="description" placeHolder="description"></form:input>
    <form:errors path="description"/>
    <br>
    <br>
    <form:select path="service.name">
        <form:option value="None">Select</form:option>
        <c:forEach items="${serviceList}" var="list">
            <form:option value="${list.name}" label="name">${list.name}</form:option>
        </c:forEach>
    </form:select>
    <br>
    <br>
    <form:button value="add">Add</form:button>
</form:form>
</body>
</html>
