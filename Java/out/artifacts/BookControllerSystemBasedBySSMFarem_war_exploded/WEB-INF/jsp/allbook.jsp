<%@ page import="com.demo.pojo.Books" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Fxx
  Date: 2021/7/27
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>全部书籍</title>
        <script src="../../layui/layui.js"></script>
        <link rel="stylesheet" href="../../layui/css/layui.css">
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
            layui.use('table', function () {
                var table = layui.table;
                table.render({
                    elem: '#test',
                    toolbar: 'true',
                    page: 'true',
                    limit: 10,
                    limits: [5, 10, 20, 30, 50, 100],
                    url: '/book/all',
                    cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
                    cols: [
                        [{
                            field: "选择",
                            title: "全选",
                            type: "checkbox",
                            hide: true
                        }, {
                            field: 'bookID',
                            width: 80,
                            title: '编号',
                            sort: true
                        }, {
                            field: 'bookName',
                            width: 240,
                            title: '书籍名'
                        }, {
                            field: 'bookCounts',
                            width: 100,
                            title: '剩余数量',
                            sort: false
                        }, {
                            field: 'detail',
                            width: 450,
                            title: '详情'
                        }, {
                            field: "操作",
                            title: "操作",
                            width: 109,
                            toolbar: "#toolbarDemo"
                        }]
                    ]
                });
                table.on('tool(filter)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
                    console.log(obj);
                    if (obj.event == 'update') {
                        location.href = "./updatebook?id=" + obj.data.bookID;
                    } else if (obj.event == 'delete') {
                        location.href = "./deletebook?id=" + obj.data.bookID;
                    }
                });
            });
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
            <li class="layui-nav-item"><a href="../../">首页</a></li>
            <li class="layui-nav-item layui-this"><a href="">全部书籍</a></li>
            <li class="layui-nav-item"><a href="./querybook">查询书籍</a></li>
            <li class="layui-nav-item"><a href="./addbook">增加书籍</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">修改或删除书籍信息</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:cannotvisit();">修改书籍信息</a></dd>
                    <hr>
                    <dd><a href="javascript:cannotvisit();">删除书籍</a></dd>
                </dl>
            </li>
        </ul>

        <div class="layui-card" style="width: 80%;margin: 0 auto;height: 100%;">
            <div class="layui-card-header" style="padding:40px;text-align: center;font-size: 30px;">
                全部书籍
            </div>
            <div style="width: 90%;margin: 0 auto;padding-bottom: 100px;">
                <table class="layui-hide" id="test" lay-filter="filter"></table>
            </div>
        </div>

    </body>

</html>