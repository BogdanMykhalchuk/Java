<%--
  Created by IntelliJ IDEA.
  User: Dreawalker
  Date: 28.07.2017
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Адміністрування</title>
    <link href="${pageContext.request.contextPath}/css/admin.css" rel="stylesheet" type="text/css">
</head>
<body>

<%@include file="/jsp/public/header.jsp" %>


<br />
<br />
<br />

<c:set var = "checkIncisionName" value = "${checkIncisionName}"/>
<c:if test = "${checkIncisionName == false}">
    <br />
    <br />
    <div id = "exception">
        <p>Неприпустиме ім'я торта.</p>
        <p>Назва не повинна містити знаків: [, ], +, (, ), $, %, #, !, ?, |, ^, *. =, <, >, " або .</p>
    </div>
    <br />
    <br />
    <c:set var = "checkIncisionName" value = "true"/>
</c:if>

<c:set var = "checkIncisionDescription" value = "${checkIncisionDescription}"/>
<c:if test = "${checkIncisionDescription == false}">
    <br />
    <br />
    <div id = "exception">
        <p>Неприпустимий опис торта.</p>
        <p>Опис не повинен містити знаків: [, ], +, (, ), $, %, #, !, ?, |, ^, *. =, <, >, " або .</p>
    </div>
    <br />
    <br />
    <c:set var = "checkIncisionDescription" value = "true"/>
</c:if>

<c:set var = "checkIncisionPath" value = "${checkIncisionPath}"/>
<c:if test = "${checkIncisionPath == false}">
    <br />
    <br />
    <div id = "exception">
        <p>Помилка в посиланні на зображення розрізу</p>
        <p>Такого файла не існує фбо таке посилання вже існує в Базі Даних</p>
    </div>
    <br />
    <br />
    <c:set var = "checkIncisionPath" value = "true"/>
</c:if>

<c:set var = "checkIncisionPrice" value = "${checkIncisionPrice}"/>
<c:if test = "${checkIncisionPrice == false}">
    <br />
    <br />
    <div id = "exception">
        <p>Помилка в полі "вартість"</p>
        <p>Можна використовувати тільки цифри</p>
        <p>Позначати дробну частину необхідно крапкою</p>
    </div>
    <br />
    <br />
    <c:set var = "checkIncisionPrice" value = "true"/>
</c:if>

<c:set var = "isIncisionSaved" value = "${isIncisionSaved}"/>
<c:if test = "${isIncisionSaved == true}">
    <br />
    <br />
    <div id = "fineExecution">
        <p>Розріз додано успішно...</p>
    </div>
    <br />
    <br />
    <c:set var = "isIncisionSaved" value = "false"/>
</c:if>

<c:set var = "isIncisionDeleted" value = "${isIncisionDeleted}"/>
<c:if test = "${isIncisionDeleted == true}">
    <br />
    <br />
    <div id = "fineExecution">
        <p>Розріз видалено успішно...</p>
    </div>
    <br />
    <br />
    <c:set var = "isIncisionDeleted" value = "false"/>
</c:if>


<div>
    <a class="show-btn" href="javascript:void(0)" onclick = "document.getElementById('insertIncision').style.display='block';document.getElementById('fade').style.display='block'">
        <button style="float: left;">Додати новий розріз</button>
    </a>
    <div id="insertIncision" class="envelope">
        <a class="close-btn" href="javascript:void(0)" onclick = "document.getElementById('insertIncision').style.display='none';document.getElementById('fade').style.display='none'">Закрити</a>
        <h1 class="title">Додати новий розріз</h1>
        <form action="/cakeController/saveCake" method="POST" accept-charset="UTF-8">
            <input type="text" name="incisionName" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'Назва торта':this.value;" value="Назва торта" class="your-name"/>
            <input type="text" name="incisionPathToImg" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'Посилання на малюнок':this.value;" value="Посилання на малюнок" class="email-address"/>
            <input type="text" name="incisionPrice" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'Вартість в долларах за кілограм':this.value;" value="Вартість в $ за кг" class="price"/>
            <textarea name="incisionDescription" class="your-message">Інгредієнти ..</textarea>
            <input type="submit" name="submit" value="Додати" class="send-message">
        </form>
    </div>
    <div id="fade" class="black-overlay"></div>


    <br />
    <br />


    <a class="show-btn" href="javascript:void(0)" onclick = "document.getElementById('deleteIncision').style.display='block';document.getElementById('fade').style.display='block'">
        <button style="float: left;">Видалити розріз</button>
    </a>
    <div id="deleteIncision" class="envelope">
        <a class="close-btn" href="javascript:void(0)" onclick = "document.getElementById('deleteIncision').style.display='none';document.getElementById('fade').style.display='none'">Закрити</a>
        <h1 class="title">Видалити розріз</h1>
        <form action="/incisionController/deleteIncision" method="POST" accept-charset="UTF-8">
            <input type="text" name="incisionId" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'Номер артикула':this.value;" value="Номер артикула" class="your-name"/>
            <input type="submit" name="submit" value="Видалити" class="send-message">
        </form>
    </div>
</div>


<c:set var = "checkCakeType" value = "${checkCakeType}"/>
<c:if test = "${checkCakeType == false}">
    <br />
    <br />
    <div id = "exception">
        <p>Помилка у виборі типу торта</p>
        <p>Оберіть один із запропонованих варіантів</p>
    </div>
    <br />
    <br />
    <c:set var = "checkCakeType" value = "true"/>
</c:if>

<c:set var = "checkCakeCoverType" value = "${checkCakeCoverType}"/>
<c:if test = "${checkCakeCoverType == false}">
    <br />
    <br />
    <div id = "exception">
        <p>Помилка у виборі покриття торта</p>
        <p>Оберіть один із запропонованих варіантів</p>
    </div>
    <br />
    <br />
    <c:set var = "checkCakeCoverType" value = "true"/>
</c:if>

<c:set var = "checkCakePathToImg" value = "${checkCakePathToImg}"/>
<c:if test = "${checkCakePathToImg == false}">
    <br />
    <br />
    <div id = "exception">
        <p>Помилка в посиланні на зображення розрізу</p>
        <p>Такого файла не існує фбо таке посилання вже існує в Базі Даних</p>
    </div>
    <br />
    <br />
    <c:set var = "checkCakePathToImg" value = "true"/>
</c:if>

<c:set var = "checkCakeDecorComplexity" value = "${checkCakeDecorComplexity}"/>
<c:if test = "${checkCakeDecorComplexity == false}">
    <br />
    <br />
    <div id = "exception">
        <p>Помилка у виборі рівня складності виготовлення торта</p>
        <p>Оберіть один із запропонованих варіантів</p>
    </div>
    <br />
    <br />
    <c:set var = "checkCakeDecorComplexity" value = "true"/>
</c:if>

<c:set var = "isCakeSaved" value = "${isCakeSaved}"/>
<c:if test = "${isCakeSaved == true}">
    <br />
    <br />
    <div id = "fineExecution">
        <p>Торт додано успішно...</p>
    </div>
    <br />
    <br />
    <c:set var = "isCakeSaved" value = "false"/>
</c:if>

<c:set var = "isCakeDeleted" value = "${isCakeDeleted}"/>
<c:if test = "${isCakeDeleted == true}">
    <br />
    <br />
    <div id = "fineExecution">
        <p>Торт видалено успішно...</p>
    </div>
    <br />
    <br />
    <c:set var = "isCakeDeleted" value = "false"/>
</c:if>

<div>
    <a class="show-btn" href="javascript:void(0)" onclick = "document.getElementById('insertCake').style.display='block';document.getElementById('fade').style.display='block'">
        <button style="float: left;">Додати новий торт</button>
    </a>
    <div id="insertCake" class="envelope">
        <a class="close-btn" href="javascript:void(0)" onclick = "document.getElementById('insertCake').style.display='none';document.getElementById('fade').style.display='none'">Закрити</a>
        <h1 class="title">Додати новий торт</h1>
        <form action="/cakeController/saveCake" method="POST" accept-charset="UTF-8">
                <select name="cakeType" title="Оберіть тип торту..." class="your-name" id="cakeTypeSelector">
                    <option value="CHILD_CAKE">Дитячий торт</option>
                    <option value="WEDDING_CAKE">Весільний торт</option>
                    <option value="MAN_CAKE">Торт для чоловіків</option>
                    <option value="WOMAN_CAKE">Торт для жінок</option>
                    <option value="HEN_PARTY">Торт для дівичвечорів</option>
                </select>

                <select name="cakeCoverType" title="Оберіть тип торту..." class="email-address" id="cakeCoverTypeSelector">
                    <option value="GUM_PASTE">Мастіка</option>
                    <option value="CHOKO_VELOURS">Шоко-Велюр</option>
                    <option value="CREAM">Крем</option>
                    <option value="CAP_CAKES">Кап-кейки</option>
                    <option value="SPACE">Пряник</option>
                </select>
            <input type="text" name="cakePathToImg" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'Посилання на малюнок':this.value;" value="Посилання на малюнок" class="price"/>

                <select name="cakeDecorComplexity" title="Оберіть тип торту..." class="your-message" id="cakeDecorComplexitySelector">
                    <option value="EASY">Легкий</option>
                    <option value="HARD">Складний</option>
                    <option value="_3D">3D торт</option>
                </select>
            <input type="submit" name="submit" value="Додати" class="send-message">
        </form>
    </div>


    <br />
    <br />


    <a class="show-btn" href="javascript:void(0)" onclick = "document.getElementById('deleteCake').style.display='block';document.getElementById('fade').style.display='block'">
        <button style="float: left;">Видалити торт</button>
    </a>
    <div id="deleteCake" class="envelope">
        <a class="close-btn" href="javascript:void(0)" onclick = "document.getElementById('deleteCake').style.display='none';document.getElementById('fade').style.display='none'">Закрити</a>
        <h1 class="title">Видалити торт</h1>
        <form action="/cakeController/deleteCake" method="POST" accept-charset="UTF-8">
            <input type="text" name="cakeId" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'Номер артикула':this.value;" value="Номер артикула" class="your-name"/>
            <input type="submit" name="submit" value="Видалити" class="send-message">
        </form>
    </div>
</div>

</body>
</html>
