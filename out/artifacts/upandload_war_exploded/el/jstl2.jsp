<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 杨本胜
  Date: 2019/11/2
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl2</title>
</head>
<body>
    <c:if test="${10 gt 3}">
        true
    </c:if>
<br />========================================<br />
    <c:forEach begin="0" end="5" step="1" varStatus="index">
        ${index.index}<br />
    </c:forEach>
</body>
<br />========================================<br />
    <%
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        request.setAttribute("list",list);
    %>
    <c:forEach items="${requestScope.list}" var="name">
        ${name}<br />
    </c:forEach>
</html>
