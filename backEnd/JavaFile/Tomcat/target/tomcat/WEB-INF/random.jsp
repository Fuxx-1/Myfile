<%@ page import="java.util.Random" %>
<%--
  Created by IntelliJ IDEA.
  User: Eleun
  Date: 2023/3/8
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>随机数</title>
</head>
<body>
<h1>随机数</h1><br>
<%=new Random().nextInt(10)%>
<h1>sessionid</h1><br>
<%=request.getAttribute("sessionid")%>
</body>
</html>
