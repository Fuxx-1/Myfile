<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JQueryTest</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.4/jquery.js"></script>
    <link rel="stylesheet" type="text/css" href="resource/jq.css"/>
    <script type="text/javascript" src="resource/jq.js"></script>
</head>
<body>
    <div class="main">
        <p>XX班级同学信息注册系统</p>
        <table>
            <tr>
                <td colspan="3"><button id="lessBtn">填写简要信息</button><button id="moreBtn">填写详细信息</button></td>
            </tr>
            <tr>
                <td>姓&emsp;&emsp;名：</td><td><input type="text" id="name"/></td><td id="nameStatus" class="status"></td>
            </tr>
            <tr>
                <td>密&emsp;&emsp;码：</td><td><input type="password" id="pwd"/></td><td id="pwdStatus" class="status"></td>
            </tr>
            <tr>
                <td>密码确认：</td><td><input type="password" id="pwd2"/></td><td id="pwd2Status" class="status"></td>
            </tr>
            <tr>
                <td>性&emsp;&emsp;别：</td>
                <td>
                    <select name="gender" id="gender">
                        <option value="NONE">请选择</option>
                        <option value="M">男</option>
                        <option value="F">女</option>
                    </select>
                </td>
                <td id="genderStatus" class="status"></td>
            </tr>
            <tr class="moreInf">
                <td>邮&emsp;&emsp;箱：</td><td><input type="email" id="email"/></td><td id="emailStatus" class="status"></td>
            </tr>
            <tr class="moreInf">
                <td>宿&emsp;&emsp;舍：</td>
                <td id="room">
                    <select name="room1" id="room1" onchange="updateRoom2()">
                        <option value="NONE">请选择</option>
                        <option value="3号宿舍楼">3号宿舍楼</option>
                        <option value="7号宿舍楼">7号宿舍楼</option>
                        <option value="8号宿舍楼">8号宿舍楼</option>
                    </select>
                    <select name="room2" id="room2"><option value="NONE">请选择</option></select>
                </td>
                <td id="roomStatus" class="status"></td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="checkbox" id="agree"/>同意本系统使用协议&emsp;<a href="javascript:void(0)" onclick="">查看使用协议</a>
                </td>
            </tr>
            <tr><td colspan="3"><button id="submitBtn">注册</button></td></tr>
        </table>
        <hr hidden/>
        <div id="resp"></div>
    </div>
</body>
</html>
