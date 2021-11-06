<%--
  Created by IntelliJ IDEA.
  User: Fxx
  Date: 2021/7/30
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

    <head lang="en">
        <meta charset="UTF-8">
        <script src="http://cdn.sockjs.org/sockjs-0.3.min.js"></script>
        <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
        <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
        <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <title>webSocket-用户${id}</title>
        <script type="text/javascript">

            $(function () {
                var websocket;
                if ('WebSocket' in window) {
                    console.log("此浏览器支持websocket");
                    websocket = new WebSocket("ws://192.168.1.107:8080/websocketDemo/${id}");
                } else if ('MozWebSocket' in window) {
                    alert("此浏览器只支持MozWebSocket");
                } else {
                    alert("此浏览器只支持SockJS");
                }
                websocket.onopen = function (evnt) {
                    $("#tou").html("链接服务器成功!")
                };
                websocket.onmessage = function (evnt) {
                    $("#msg").html($("#msg").html() + "<br/>" + evnt.data);
                };
                websocket.onerror = function (evnt) {
                };
                websocket.onclose = function (evnt) {
                    $("#tou").html("与服务器断开了链接!")
                }
                $('#send').bind('click', function () {
                    send();
                });

                function send() {
                    if (websocket != null) {
                        var message = document.getElementById('message').value;
                        websocket.send(message);
                    } else {
                        alert('未与服务器链接.');
                    }
                }
            });
        </script>
    </head>

    <body>
        <div class="page-header" id="tou">
            webSocket多终端聊天测试
        </div>
        <div class="well" id="msg"></div>
        <div class="col-lg">
            <form style="text-align: center">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="发送信息..." id="message">
                    <br>
                    <span class="input-group-btn">
                    <button class="btn btn-default" type="button" id="send">发送</button>
                </span>
                </div>
            </form>
        </div>
    </body>

</html>
