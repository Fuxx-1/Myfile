<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>input</title>
</head>

<body style="text-align: center;">
    <form action="first" method="get">
        <table style="margin: auto;">
            <tr>
                <td>学号：</td>
                <td><input type="text" name="uid" id="uid"></td>
            </tr>
            <tr>
                <td>姓名：</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
        </table>
        <input type="submit" value="提交">&emsp;&emsp;
        <input type="reset" value="重置">
    </form>
</body>
</html>

