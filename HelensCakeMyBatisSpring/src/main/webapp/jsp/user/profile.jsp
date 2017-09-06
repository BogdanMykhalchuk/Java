<%--
  Created by IntelliJ IDEA.
  User: Dreawalker
  Date: 06.09.2017
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Мій кабінет</title>
        <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <br />
        <br />
        <%@include file="/jsp/public/header.jsp" %>
        <br />
        <br />
        <a href="/userOrderController/getToUserOrdersPage" id="adminButton">
            <button>Переглянути список моїх замовлень</button>
        </a>
    </body>
</html>