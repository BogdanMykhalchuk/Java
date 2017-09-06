<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Dreawalker
  Date: 25.07.2017
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<html>
    <head>
        <title>Рецепты</title>
        <link href="${pageContext.request.contextPath}/css/recipes.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <%@include file="/jsp/public/header.jsp" %>
        <c:forEach var="incision" items="${incisions}">
            <br />
            <br />
            <div class="incisions">
                <h2>
                    <c:out value="${incision.name}" /><br />
                </h2>
                <p>
                    Артикул: <c:out value="${incision.id}" /><br />
                </p>
                <c:out value="${incision.description}" /><br />
                <img src="<c:out value="${incision.pathToImg}" />" /><br />
                <h3>
                    Вартість: <c:out value="${incision.price}" /><br />
                </h3>
            </div>
            <br />
            <br />
        </c:forEach>
    </body>
</html>
