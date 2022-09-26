<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: Fxx
  Date: 2021/6/1
  Time: 19:29
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- <%@ %> 是 JSP 指令用来设置与整个JSP页面相关的属性。--%>
<%--JSP的全称是 Java Server Pages--%>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%!
            int a = 0;

            String getRemoteAddr() {
                a++;
                //Integer.toString(a);
                return String.valueOf(a);
            }

            ;
        %>
        <%
            // 这里可以写 Java 代码
            out.println("请求次数：" + getRemoteAddr() + "<br>");
            System.out.println(a);
            out.println("Hello World！<br>");
            out.println("你的 IP 是：" + request.getRemoteAddr() + "<br>");
        %>
        <%--下面是JSP的表达式（该部分注释在网页中不会被显示）--%>
        今天的日期是: <%= (new Date()).toString()%>
    </body>
</html>
