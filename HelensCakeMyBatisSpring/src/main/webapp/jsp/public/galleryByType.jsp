<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css">
        <title>Наші роботи</title>
    </head>
    <body>

        <%@include file="/jsp/public/header.jsp" %>

        <c:forEach var="cakes" items="${cakes}">
            <br />
            <br />
            <div class="cakes">
                <p>
                    Артикул: <c:out value="${cakes.id}" /><br />
                </p>
                <img src="<c:out value="${cakes.pathToImg}" />"  alt=""/><br />
            </div>
            <br />
            <br />
        </c:forEach>

    </body>
</html>
