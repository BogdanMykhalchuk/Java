<%--
  Created by IntelliJ IDEA.
  User: Dreawalker
  Date: 15.07.2017
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Echoing HTML Request Parameters</title>
</head>
<body>
<h2>Choose authors:</h2>
<form method="get">
    <input type="checkbox" name="author" value="Tan Ah Teck">Tan
    <input type="checkbox" name="author" value="Mohd Ali">Ali
    <input type="checkbox" name="author" value="Kumar">Kumar
    <input type="checkbox" name="author" value="Peter Johnson">Peter
    <input type="submit" value="Query">
</form>

<%
    String[] authors = request.getParameterValues("author");
    if (authors != null) {
%>
<h3>You have selected author(s):</h3>
<ul>
    <%
        for (String author : authors) {
    %>
    <li><%= author %></li>
    <%
        }
    %>
</ul>
<%
    }
%>
<br /><a href="<%= request.getRequestURI() %>">BACK</a>
</body>
</html>
