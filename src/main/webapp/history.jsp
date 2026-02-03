<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head><title>История</title></head>
<body>
<h2>История вычислений</h2>

<c:choose>
    <c:when test="${empty history}">
        <p>История пуста. <a href="${pageContext.request.contextPath}/calculator">Калькулятор</a></p>
    </c:when>
    <c:otherwise>
        <ol>
            <c:forEach var="calc" items="${history}">
                <li>${calc}</li>
            </c:forEach>
        </ol>
        <p>Всего операций: ${history.size()}</p>
    </c:otherwise>
</c:choose>

<a href="${pageContext.request.contextPath}/calculator">← Калькулятор</a>
</body>
</html>
