<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head><title>Калькулятор</title></head>
<body>
<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>

<form action="${pageContext.request.contextPath}/calculator" method="post">
    <input type="number" name="num1" placeholder="Число 1" value="${num1}">
    <input type="number" name="num2" placeholder="Число 2" value="${num2}">
    <select name="operation">
        <option value="SUM" ${operation == 'SUM' ? 'selected' : ''}>+</option>
        <option value="DIFF" ${operation == 'DIFF' ? 'selected' : ''}>-</option>
        <option value="MULTIPLY" ${operation == 'MULTIPLY' ? 'selected' : ''}>*</option>
        <option value="DIVIDE" ${operation == 'DIVIDE' ? 'selected' : ''}>/</option>
    </select>
    <button>Вычислить</button>

    <c:if test="${not empty result}">
        <p>Результат: ${result}</p>
    </c:if>

    <a href="${pageContext.request.contextPath}/history">История</a>
</form>
</body>
</html>
