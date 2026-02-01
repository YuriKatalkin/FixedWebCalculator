<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Калькулятор</title></head>
<body>
<form action="${pageContext.request.contextPath}/calculator" method="post">
    <input type="number" name="num1" placeholder="Число 1" value="${num1}">
    <input type="number" name="num2" placeholder="Число 2" value="${num2}">
    <select name="operation">
        <option value="+">+</option><option value="-">-</option>
        <option value="*">*</option><option value="/">/</option>
    </select>
    <button>Вычислить</button>

    <% if (request.getAttribute("result") != null) { %>
    <p>Результат: <%=request.getAttribute("result")%></p>
    <% } %>

    <a href="${pageContext.request.contextPath}/history">История</a>
</form>
</body>
</html>
