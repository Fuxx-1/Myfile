<%--
  Created by IntelliJ IDEA.
  User: Eleun
  Date: 2023/7/1
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page contentType="text/html;charset=gb2312" %>--%>
<%@ page errorPage="errorHandler.jsp" %>
<html>
<body>
    <%
        String name = request.getParameter("name");
        if (name == null) {
            throw new RuntimeException("没有指定name 属性。");
        } else {
            // 将字符串name的字符编码转换为汉字编码
            name = new String(name.getBytes("UTF-8"), "UTF-8");
        }
    %>
    Hello, <%=name %>
</body>
</html>

