<%--
  Created by IntelliJ IDEA.
  User: v_zirenguo
  Date: 2020/12/12
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件demo</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/quick21" method="post" enctype="multipart/form-data">
    名称<input type="text" name="username"><br/>
    文件<input type="file" name="uploadFile"><br/>
    <input type="submit" name="上传"><br/>
</form>
</body>
</html>
