<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <link href="css/index.css" rel="stylesheet" type="text/css">
        <title>Helen's models.Incision</title>
    </head>
    <body>

        <%@include file="/html/header.html" %>

    <h2>Сайт знаходиться на стадії розробки</h2>

    <h2>Вибачте за тимчасові незручності</h2>

    <br>

        <a href="${pageContext.request.contextPath}/adminPageServlet?forward=true">
            <button>Адміністрування</button>
        </a>

    <br>
    <br>
    <br>

        <div id="body">

            <%
                out.println("Your IP address is " + request.getRemoteAddr());
            %>

            <p>Дата і час: <%= (new SimpleDateFormat().format(new Date()))%></p>

            <p>
                <a href="/jsp/authorList.jsp">Choose Author</a>
            </p>

            <p>
            <form action="/secondServlet" method="get"/>
            </p>

            <p>
                <jsp:include page="/secondServlet" flush="true" />
            </p>
        </div>


        <jsp:useBean id="bean" class="test.TestBean"/>
        <jsp:setProperty name="bean" property="message" value="Hello JSP..." />
        <br />
        Got massage...
        <jsp:getProperty name="bean" property="message"/>


    </body>
</html>