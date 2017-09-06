<%--
  Created by IntelliJ IDEA.
  User: Dreawalker
  Date: 19.08.2017
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Реєстрація</title>
        <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css">
    </head>
    <body>

        <%@include file="/jsp/public/header.jsp" %>

        <br />
        <br />

        <c:set var = "checkUserLogin" value = "${checkUserLogin}"/>
        <c:if test = "${checkUserLogin == false}">
            <br />
            <br />
            <div id = "exception">
                <p>Неприпустимий формат логіну.</p>
                <p>Логін не повинен містити знаків: [, ], +, (, ), $, %, #, !, ?, |, ^, *. =, <, >, " або .</p>
            </div>
            <br />
            <br />
            <c:set var = "checkUserLogin" value = "true"/>
        </c:if>

        <c:set var = "checkUserPassWord" value = "${checkUserPassWord}"/>
        <c:if test = "${checkUserPassWord == false}">
            <br />
            <br />
            <div id = "exception">
                <p>Неприпустимий формат пароля.</p>
                <p>Пароль не повинен містити знаків: [, ], +, (, ), $, %, #, !, ?, |, ^, *. =, <, >, " або .</p>
            </div>
            <br />
            <br />
            <c:set var = "checkUserPassWord" value = "true"/>
        </c:if>

        <c:set var = "checkUserName" value = "${checkUserName}"/>
        <c:if test = "${checkUserName == false}">
            <br />
            <br />
            <div id = "exception">
                <p>Неприпустимий формат імені.</p>
                <p>Ім'я не повинно містити знаків: [, ], +, (, ), $, %, #, !, ?, |, ^, *. =, <, >, " або .</p>
            </div>
            <br />
            <br />
            <c:set var = "checkUserName" value = "true"/>
        </c:if>

        <c:set var = "checkUserPhoneNumber" value = "${checkUserPhoneNumber}"/>
        <c:if test = "${checkUserPhoneNumber == false}">
            <br />
            <br />
            <div id = "exception">
                <p>Неприпустимий формат номеру телефону.</p>
                <p>Номер телефону повинен містити тільки цифри.</p>
            </div>
            <br />
            <br />
            <c:set var = "checkUserPhoneNumber" value = "true"/>
        </c:if>

        <c:set var = "isUserSaved" value = "${isUserSaved}"/>
        <c:if test = "${isUserSaved == true}">
            <br />
            <br />
            <div id = "fineExecution">
                <p>Реєстрація пройшла успішно...</p>
            </div>
            <br />
            <br />
            <c:set var = "isUserSaved" value = "false"/>
        </c:if>

        <form id="registrationForm" action="/userController/saveUser" method="POST" accept-charset="UTF-8">
            Введіть логін:
            <br />
            <input name="userLogin" size="25" maxlength="25"/>
            <br />
            Введіть пароль:
            <br />
            <input type="password" name="userPassword" size="25" maxlength="25"/>
            <br />
            Введіть ім'я:
            <br />
            <input name="userName" size="45" maxlength="45"/>
            <br />
            Введіть номер мобільного телефону
            <br />
            у десятизначному форматі:
            <br />
            <input name="userPhoneNumber" size="45" maxlength="45"/>
            <br />
            <input type="submit" name="submit" value="Зареєєструватись" class="send-message">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </body>
</html>
