<%--
  Created by IntelliJ IDEA.
  User: Eleun
  Date: 2023/7/1
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date,java.text.DateFormat" %>
<%@ page contentType="text/html;charset=gb2312" %>
<%@ page import="java.text.DateFormat" %>
<html>
<head><title>page指令示例</title></head>
<body>
    <h3 align="center">使用page指令导入java.util.Date类</h3>
    <% Date date = new Date();
        String s = DateFormat.getDateInstance().format(date);
        String s2 = DateFormat.getDateInstance(DateFormat.FULL).format(date);
    %>
    <p align="center">现在的时间是：<%=s%>
    <p align="center">现在的时间是：<%=s2%>
</body>
</html>

