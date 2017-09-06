<%--
  Created by IntelliJ IDEA.
  User: Dreawalker
  Date: 26.07.2017
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <title>Наші роботи</title>
        <link href="${pageContext.request.contextPath}/css/gallery.css" rel="stylesheet" type="text/css">
    </head>
    <body>

        <%@include file="/jsp/public/header.jsp" %>

        <div>
            <br />
            <h3><strong>Весільні торти</strong></h3>
            <a href = "/cakeController/getCakesByType?cakeType=WEDDING_CAKE"><img src="${pageContext.request.contextPath}/img/types/01.jpg" width="200" height="287" alt=""/></a>
            <br />
        </div>
        <div>
            <br />
            <h3><strong>Тортики для діток</strong></h3>
            <a href = "/cakeController/getCakesByType?cakeType=CHILD_CAKE"><img src="${pageContext.request.contextPath}/img/types/02.jpg" width="200" height="267" alt=""/></a>
            <br />
        </div>
        <div>
            <br />
            <h3><strong>Тортики для жінок</strong></h3>
            <a href = "/cakeController/getCakesByType?cakeType=WOMAN_CAKE"><img src="${pageContext.request.contextPath}/img/types/03.jpg" width="200" height="300" alt=""/></a>
            <br />
        </div>
        <div>
            <br />
            <h3><strong>Торти для чоловіків</strong></h3>
            <a href = "/cakeController/getCakesByType?cakeType=MAN_CAKE"><img src="${pageContext.request.contextPath}/img/types/04.jpg" width="200" height="300" alt=""/></a>
            <br />
        </div>
        <div>
            <br />
            <h3><strong>Торти на дівичвечір</strong></h3>
            <a href = "/cakeController/getCakesByType?cakeType=HEN_PARTY"><img src="${pageContext.request.contextPath}/img/types/05.jpg" width="200" height="300" alt=""/></a>
            <br />
        </div>

    </body>
</html>
