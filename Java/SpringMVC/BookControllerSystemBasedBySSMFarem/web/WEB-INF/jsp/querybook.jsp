<%--
  Created by IntelliJ IDEA.
  User: Fxx
  Date: 2021/7/30
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>查询书籍</title>
        <script src="../../layui/layui.js"></script>
        <link rel="stylesheet" href="../../layui/css/layui.css">
        <script>
            function cannotvisit() {
                layer.msg("请通过全部书籍的操作栏进入该界面");
            }
            window.onload = function () {
                function query(isid, data) {
                    layui.use('table', function () {
                        var table = layui.table;
                        table.render({
                            elem: '#test',
                            toolbar: 'true',
                            page: 'true',
                            url: isid ? '/book/query/' + data : '/book/queryname?name=' + data,
                            cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
                            cols: [
                                [{
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
                                    width: 120,
                                    title: '剩余数量',
                                    sort: false
                                }, {
                                    field: 'detail',
                                    width: 800,
                                    title: '详情'
                                }]
                            ]
                        });
                    });
                }
                //注意：导航 依赖 element 模块，否则无法进行功能性操作
                layui.use('element', function () {
                    var element = layui.element;
                });
                layui.use('form', function () {
                    var form = layui.form;
                    //监听提交
                    form.on('submit(id)', function (data) {
                        layer.msg("正在查询……");
                        if (data.field.bookID == "" || data.field.bookID.length == 0) {
                            return false;
                        }
                        query(true, data.field.bookID);
                        return false;
                    });
                    form.on('submit(Name)', function (data) {
                        layer.msg("正在查询……");
                        if (data.field.bookName == "" || data.field.bookName.length == 0) {
                            return false;
                        }
                        query(false, data.field.bookName);
                        return false;
                    });
                });
                // layui.use('form', function () {
                //     var form = layui.form;
                //     form.on('submit()', function (data) {
                //         console.log(data.field.bookID);
                //         // console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
                //         // console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
                //         // console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
                //         return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
                //     });
                //     //各种基于事件的操作，下面会有进一步介绍
                // });
            }
        </script>
    </head>

    <body style="background-color: rgba(242, 242, 242, 0.8);">
        <ul class="layui-nav" lay-filter="">
            <li class="layui-nav-item"><a href="../../">首页</a></li>
            <li class="layui-nav-item"><a href="./allbook">全部书籍</a></li>
            <li class="layui-nav-item layui-this"><a href="">查询书籍</a></li>
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
                查询书籍
            </div>
            <div class="layui-card-body" style="padding:20px;">
                <form class="layui-form">
                    <div class="layui-form-item">
                        <label class="layui-form-label">编号查询</label>
                        <div class="layui-input-block">
                            <input type="text" name="bookID" autocomplete="off" placeholder="请输入要查询书籍的编号"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button type="submit" class="layui-btn" lay-submit lay-filter="id">查询</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="layui-card-body" style="padding:20px;">
                <form class="layui-form">
                    <div class="layui-form-item">
                        <label class="layui-form-label">书名查询</label>
                        <div class="layui-input-block">
                            <input type="text" name="bookName" autocomplete="off" placeholder="请输入要查询书籍名称"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button type="submit" class="layui-btn" lay-submit lay-filter="Name">查询</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>
            </div>

            <div style="width: 90%;margin: 0 auto;padding-bottom: 100px;">
                <table class="layui-hide" id="test"></table>
            </div>
        </div>

    </body>

</html>
