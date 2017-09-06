<%@ page contentType="text/html; charset=UTF-8" %>
<h1>Helen's cake</h1>
<div id="wrapper">
    <table border = "1">
        <tr>
            <td>
                <a href="/incisionController/getToIncisionsPage">Начинки</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/jsp/public/gallery.jsp">Наші роботи</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/jsp/user/order.jsp">Замовлення</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/jsp/public/contacts.jsp">Контакти</a>
            </td>
            <td>
                <a href="/userController/getToRegistrationPage">Реєстрація</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/jsp/public/login.jsp">Вхід</a>
            </td>
        </tr>
    </table>
</div>

<br />
<br />

<div class="container">
    <form class="form-inline" action="/jsp/public/login.jsp?logout=true" method="POST">
        <input type="submit" value="Log out" />
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>
