<%--
  Created by IntelliJ IDEA.
  User: Eleun
  Date: 2023/5/31
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>1</title>
</head>
<body>
    <h1>1</h1>
    <%
        String username = (String) session.getAttribute("username");
        if (username == null) out.print("未登录！");
        else out.print("用户名：" + username);
    %>
    <hr/>
    <a href="./2.jsp">页面2</a>
</body>
</html>

