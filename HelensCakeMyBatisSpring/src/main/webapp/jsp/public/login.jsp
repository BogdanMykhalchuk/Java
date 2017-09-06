<%--
  Created by IntelliJ IDEA.
  User: Dreawalker
  Date: 19.08.2017
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html xmlns:th="http://www.thymeleaf.org">
    <head th:include="layout :: head(title=~{::title},links=~{})">
        <title>Вхід в профіль</title>
        <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css">
    </head>
    <body th:include="layout :: body" th:with="content=~{::content}">

        <%@include file="/jsp/public/header.jsp" %>

        <div th:fragment="content">
            <form name="f" action="/login" method="POST">
                <fieldset>
                    <legend>Будь ласка введіть логін та пароль</legend>

                    <c:if test = "${param.error == true}">
                        <br />
                        <br />
                        <div id = "exception">
                            Невірний логін або пароль
                        </div>
                        <br />
                        <br />
                    </c:if>

                    <c:if test = "${param.logout == true}">
                        <br />
                        <br />
                        <div id = "exception">
                            Ви здійснили вихід із свого облікового запису
                        </div>
                        <br />
                        <br />
                    </c:if>

                    <label for="username">Логін</label>
                    <input type="text" id="username" name="username"/>
                    <label for="password">Пароль</label>
                    <input type="password" id="password" name="password"/>
                    <div class="form-actions">
                        <button type="submit" class="btn">Вхід</button>
                    </div>
                </fieldset>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </div>
    </body>
</html>
