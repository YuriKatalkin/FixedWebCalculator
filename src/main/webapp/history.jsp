<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head><title>История</title></head>
<body>
<h2>История вычислений</h2>

<%
    List<String> history = (List<String>) request.getAttribute("history");
    if (history == null || history.isEmpty()) {
%>
<p>История пуста. Перейдите к <a href="${pageContext.request.contextPath}/calculator">калькулятору</a></p>
<%
} else {
%>
<ol>
    <% for (String calc : history) { %>
    <li><%= calc %></li>
    <% } %>
</ol>
<p><strong>Всего операций: <%=history.size()%></strong></p>
<%
    }
%>

<br>
<a href="${pageContext.request.contextPath}/calculator">← Назад к калькулятору</a>
</body>
</html>
