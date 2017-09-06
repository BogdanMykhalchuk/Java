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
        <%--
        <c:set var = "isUserValid" value = "${isUserValid}"/>
        <c:if test = "${isUserValid == false}">
            <br />
            <br />
            <div id = "exception">
                <p>Такого користувача не існує</p>
                <p>Перевірте правильність введення логіну та пароля</p>
                <p>Якщо Ви не зареєстровані - зареєструйтесь - це значно спростить для Вас процедуру формування замовлення</p>
            </div>
            <br />
            <br />
            <c:set var = "isUserValid" value = "true"/>
        </c:if>
        --%>

        <br />

        <a href="${pageContext.request.contextPath}/adminController?forward=true" id="adminButton">
            <button>Адміністрування</button>
        </a>

    </body>
</html>