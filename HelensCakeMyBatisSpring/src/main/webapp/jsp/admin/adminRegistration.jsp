<%--
  Created by IntelliJ IDEA.
  User: Dreawalker
  Date: 06.09.2017
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Реєстрація користувача</title>
        <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css">
    </head>
    <body>

        <br />
        <br />
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

        <c:set var = "checkUserRole" value = "${checkUserRole}"/>
        <c:if test = "${checkUserRole == false}">
            <br />
            <br />
            <div id = "exception">
                <p>Неприпустимий формат рівня повновважень.</p>
            </div>
            <br />
            <br />
            <c:set var = "checkUserRole" value = "true"/>
        </c:if>

        <div>
            <form id="registrationForm" action="/adminController/saveUser" method="POST" accept-charset="UTF-8">
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
                Оберіть рівень повноважень:
                <br />
                <select name="userRole" title="Оберіть тип торту..." class="your-name" id="userRoleSelector">
                    <option value="ROLE_CLIENT">Клієнт</option>
                    <option value="ROLE_ADMIN">Адміністратор</option>
                </select>
                <br />
                <input type="submit" name="submit" value="Зареєєструвати" class="send-message">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </div>
    </body>
</html>
