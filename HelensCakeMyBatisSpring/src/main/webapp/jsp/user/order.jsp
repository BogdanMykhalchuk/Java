<%--
  Created by IntelliJ IDEA.
  User: Bogdan
  Date: 28.08.2017
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Замовлення</title>
        <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <br />
        <br />
        <%@include file="/jsp/public/header.jsp" %>
        <br />
        <br />
        <a href="/userController/getToProfilePage" id="adminButton">
            <button>Вхід в особистий кабінет</button>
        </a>
        <br />
        <br />
        <a href="/userPrintOrderController/getToCreatePrintOrderPage" id="adminButton">
            <button>Замовити їстівну картинку</button>
        </a>
        <br />
        <br />
        <a href="/userController/getToProfilePage" id="adminButton">
            <button>Замовити щось солоденьке</button>
        </a>
    </body>
</html>
