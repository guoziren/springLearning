<%--
  Created by IntelliJ IDEA.
  User: v_zirenguo
  Date: 2020/12/12
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>springmvc获得集合参数</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/quick14" method="post">
        <%--                表明是第一个user对象的username--%>
        <input type="text" name="userList[0].name">
        <input type="text" name="userList[0].age">
        <input type="text" name="userList[1].name">
        <input type="text" name="userList[1].age">
        <input type="submit" value="提交">
    </form>
</body>
</html>
