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
        <link href="/css/recipes.css" rel="stylesheet" type="text/css">
    </head>
    <body>
    <%@include file="/html/header.html" %>
        <c:forEach var="incision" items="${incisions}">
            <h2>
                <c:out value="${incision.name}" /><br />
            </h2>
            <c:out value="${incision.description}" /><br />
            <img src="<c:out value="${incision.pathToImg}" />" /><br />
            <h3>
                Вартість: <c:out value="${incision.price}" /><br />
            </h3>
        </c:forEach>
    </body>
</html>
