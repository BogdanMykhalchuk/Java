<%--
  Created by IntelliJ IDEA.
  User: Bogdan
  Date: 07.09.2017
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Замовлення їстівної картинки</title>
    </head>
    <body>
        <br />
        <br />
        <%@include file="/jsp/public/header.jsp" %>
        <br />
        <br />

        <c:set var = "checkLinkToImg" value = "${checkLinkToImg}"/>
        <c:if test = "${checkLinkToImg == false}">
            <br />
            <br />
            <div id = "exception">
                Помилка в посиланні на малюнок. Перевірте текст посилання.
            </div>
            <br />
            <br />
            <c:set var = "checkLinkToImg" value = "true"/>
        </c:if>
        <br />
        <br />

        <c:set var = "checkUploadedFileFormat" value = "${checkUploadedFileFormat}"/>
        <c:if test = "${checkUploadedFileFormat == false}">
            <br />
            <br />
            <div id = "exception">
                Невірний формат або превищено допустимий розмір файлу.
                До завантаження приймаються файли "jpg" або "png", розміром не більше 5 МБ
            </div>
            <br />
            <br />
            <c:set var = "checkUploadedFileFormat" value = "true"/>
        </c:if>
        <br />
        <br />

        <c:set var = "checkPaperType" value = "${checkPaperType}"/>
        <c:if test = "${checkPaperType == false}">
            <br />
            <br />
            <div id = "exception">
                Недопустиме значення. Оберіть тип паперу із списку запропонованих.
            </div>
            <br />
            <br />
            <c:set var = "checkPaperType" value = "true"/>
        </c:if>
        <br />
        <br />

        <c:set var = "checkSheetsQuantity" value = "${checkSheetsQuantity}"/>
        <c:if test = "${checkSheetsQuantity == false}">
            <br />
            <br />
            <div id = "exception">
                Помилка в кількості листків. Вкажіть додатнє ціле число.
            </div>
            <br />
            <br />
            <c:set var = "checkSheetsQuantity" value = "true"/>
        </c:if>
        <br />
        <br />


        <form id="creatingPrintOrderForm" action="/userPrintOrderController/createPrintOrder" method="POST" accept-charset="UTF-8">
            Скопіюйте та вставте в поле посилання на малюнок для друку:
            <br />
            <input name="linkToImg" size="40" maxlength="100"/>
            <br />


            <input type="file" id="upload" name="upload" style="visibility: hidden; width: 1px; height: 1px" multiple />
            <a href="" onclick="document.getElementById('upload').click(); return false">Завантажити файл</a>



            Оберіть тип паперу:
            <br />
            <select name="isTight" title="Оберіть тип паперу..." class="your-name" id="paperTypeSelector">
                <option value="false">Тонкий</option>
                <option value="true">Товстий</option>
            </select>
            <br />
            Введіть потрібну кількість листків:
            <br />
            <input name="quantity" size="45" maxlength="45"/>
            <br />
            <input type="submit" name="submit" value="Зареєєструватись" class="send-message">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </body>
</html>
