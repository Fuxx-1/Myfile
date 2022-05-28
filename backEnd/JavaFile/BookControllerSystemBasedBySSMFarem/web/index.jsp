<%--
  Created by IntelliJ IDEA.
  User: Fxx
  Date: 2021/7/27
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>首页</title>
    <script src="./layui/layui.js"></script>
    <link rel="stylesheet" href="./layui/css/layui.css">
    <script>
      function cannotvisit() {
        layer.msg("请通过全部书籍的操作栏进入该界面");
      }
      layui.use('carousel', function () {
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
          elem: '#carousel',
          width: '90%', //设置容器宽度
          arrow: 'hover' //始终显示箭头
          //,anim: 'updown' //切换动画方式
        });
      });
      //注意：导航 依赖 element 模块，否则无法进行功能性操作
      layui.use('element', function () {
        var element = layui.element;
      });
    </script>
  </head>

  <body style="background-color: rgba(242, 242, 242, 0.8);">
    <ul class="layui-nav" lay-filter="">
      <li class="layui-nav-item layui-this"><a href="">首页</a></li>
      <li class="layui-nav-item"><a href="./book/allbook">全部书籍</a></li>
      <li class="layui-nav-item"><a href="./book/querybook">查询书籍</a></li>
      <li class="layui-nav-item"><a href="./book/addbook">增加书籍</a></li>
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
      <div class="layui-card-header" style="padding:40px;text-align: center;font-size: 30px;">首页</div>
      <div class="layui-carousel" id="carousel" style="margin: 0 auto;">
        <div carousel-item style="text-align: center;">
          <div><img height="100%" src="http://www.yaokj.net/wp-content/uploads/2017/03/zm-001.jpg" alt="">
          </div>
          <div><img height="100%"
                    src="https://tse1-mm.cn.bing.net/th/id/R-C.aac15df2528246b0794b422f5f588fd2?rik=se6ftZnhjFn9MA&riu=http%3a%2f%2fi.52desktop.cn%3a81%2fupimg%2fallimg%2f0912%2f2009122194852396778026.jpg&ehk=NXZvB%2fTd3RvKxMh2O7VoBMu5TirWEu3EeOcqlT%2faZZc%3d&risl=&pid=ImgRaw"
                    alt="">
          </div>
          <div><img height="100%"
                    src="https://tse1-mm.cn.bing.net/th/id/R-C.edc178052b59525f10403d48cdf775b1?rik=%2bU7CV61oykooSw&riu=http%3a%2f%2fpic3.bbzhi.com%2fxitongbizhi%2fjingpinzhencang1080pgao%2fcomputer_kuan_201910_15.jpg&ehk=YCkz4TjbZFB0LWPSmMhFat4HP2lo5y%2bCXTiJVN3BjjE%3d&risl=&pid=ImgRaw"
                    alt="">
          </div>
          <div><img height="100%"
                    src="https://i1.3conline.com/images/piclib/200912/28/batch/1/50775/1261981340895sbzeca5ic3.jpg"
                    alt="">
          </div>
          <div><img height="100%"
                    src="https://tse1-mm.cn.bing.net/th/id/R-C.031f207211004ab124d937e2772f9267?rik=yiCqVZr0kDe0xQ&riu=http%3a%2f%2fpic3.bbzhi.com%2fxitongbizhi%2fjingpinzhencang1080pgao%2fcomputer_kuan_201752_14.jpg&ehk=KZjdauS7MYE9W%2bYx02mbLovfjLCpOQ9FkLWqm3%2f2vx0%3d&risl=&pid=ImgRaw"
                    alt="">
          </div>
        </div>
      </div>
      <div class="layui-card-body" style="padding: 50px;">
        <font style="font-size: 20px;">书籍 </font>
        <font style="font-size: 13px;">（中国文学词语）</font>
        <br>
        <hr>
        书籍（英文:Book；拼音:shū jí；注音:ㄕㄨ ㄐㄧˊ）是指装订成册的图书和文字，在狭义上的理解是带有文字和图像、纸张的集合。中国古代纸张推广前，书籍多用以火焙干的竹子编成。
      </div>
    </div>
  </body>

</html>