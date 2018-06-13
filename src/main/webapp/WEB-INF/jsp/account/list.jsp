<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2018/6/9
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>账户列表</title>
</head>
<body>
账户列表：
<table>
    <tr>
        <th>账户Id</th>
        <th>账户名称</th>
        <th>账户金额</th>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.money}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
