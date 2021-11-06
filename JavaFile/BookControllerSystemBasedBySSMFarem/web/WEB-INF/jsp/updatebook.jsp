<%--
  Created by IntelliJ IDEA.
  User: Fxx
  Date: 2021/7/28
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("utf-8"); %>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>修改书籍信息</title>
        <script src="../layui/layui.js"></script>
        <link rel="stylesheet" href="../layui/css/layui.css">
        <script>
            function cannotvisit() {
                layer.msg("请通过全部书籍的操作栏进入该界面");
            }
            //注意：导航 依赖 element 模块，否则无法进行功能性操作
            layui.use('element', function () {
                var element = layui.element;
            });
            layui.use("form", function () {
                var form = layui.form;
            })
        </script>

        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-xs" lay-event="update">编辑</button>
                <button class="layui-btn layui-btn-xs layui-btn-danger" lay-event="delete">删除</button>
            </div>
        </script>
    </head>

    <body style="background-color: rgba(242, 242, 242, 0.8);">
        <ul class="layui-nav" lay-filter="">
            <li class="layui-nav-item"><a href="../">首页</a></li>
            <li class="layui-nav-item"><a href="./allbook">全部书籍</a></li>
            <li class="layui-nav-item"><a href="./querybook">查询书籍</a></li>
            <li class="layui-nav-item"><a href="./addbook">增加书籍</a></li>
            <li class="layui-nav-item layui-this">
                <a href="javascript:;">修改或删除书籍信息</a>
                <dl class="layui-nav-child">
                    <dd class="layui-this"><a href="javascript:cannotvisit();">修改书籍信息</a></dd>
                    <hr>
                    <dd><a href="javascript:cannotvisit();">删除书籍</a></dd>
                </dl>
            </li>
        </ul>

        <div class="layui-card" style="width: 80%;margin: 0 auto;height: 100%;">
            <div class="layui-card-header" style="padding:40px;text-align: center;font-size: 30px;">
                修改书籍信息
            </div>
            <div class="layui-card-body" style="padding:20px;">
                <form class="layui-form" action="./update" method="POST">
                    <div class="layui-form-item">
                        <label class="layui-form-label">编号</label>
                        <div class="layui-input-block">
                            <input type="text" readonly="readonly" value="${books.bookID}" name="bookID"
                                   autocomplete="off"
                                   placeholder="请输入书籍编号" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">书籍名</label>
                        <div class="layui-input-block">
                            <input type="text" name="bookName" value="${books.bookName}" autocomplete="off"
                                   placeholder="请输入书籍名" class="layui-input"
                                   required>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">剩余数量</label>
                        <div class="layui-input-block">
                            <input type="text" name="bookCounts" value="${books.bookCounts}" autocomplete="off"
                                   placeholder="请输入书籍剩余数量"
                                   class="layui-input" required>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">详情</label>
                        <div class="layui-input-block">
                            <textarea name="detail" placeholder="请输入书籍详情" class="layui-textarea"
                                      required>${books.detail}</textarea>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button type="submit" class="layui-btn" lay-submit>修改</button>
                            <button class="layui-btn layui-btn-primary" onclick="location.href='./allbook'"
                                    type="button">取消
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

    </body>

</html>