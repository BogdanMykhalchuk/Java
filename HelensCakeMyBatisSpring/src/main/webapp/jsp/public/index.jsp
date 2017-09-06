<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css">
        <title>Helen's Cake</title>
    </head>
    <body>

        <%@include file="/jsp/public/header.jsp" %>

        <br />
        <br />

        <a href="/adminPageController" id="adminButton">
            <button>Адміністрування</button>
        </a>

    </body>
</html>