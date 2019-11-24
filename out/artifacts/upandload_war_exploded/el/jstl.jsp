<%--
  Created by IntelliJ IDEA.
  User: 杨本胜
  Date: 2019/11/2
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl</title>
</head>
<body>
    <c:set var="name" value="zhangsan" scope="request"></c:set>

    ${requestScope.get("name")}
</body>
</html>
