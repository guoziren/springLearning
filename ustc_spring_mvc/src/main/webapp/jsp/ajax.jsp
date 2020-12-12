<%--
  Created by IntelliJ IDEA.
  User: v_zirenguo
  Date: 2020/12/12
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>通过ajax提交集合参数，web中直接用List接收</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script>
        var userList = new Array();
        userList.push({name:"zhangsan",age:18});
        userList.push({name:"lisi",age:22});

        $.ajax({
            type : "POST",
            url : "${pageContext.request.contextPath}/quick15",
            data : JSON.stringify(userList),
            contentType : "application/json;charset=utf-8"
        });
    </script>
</head>
<body>

</body>
</html>
