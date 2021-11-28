(function () {
    //填写问卷题目数量
    'use strict';
    var number = 20;
    var flag = new Array( //题目类型
        1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
    );
    var ans = new Array( //题目答案
        1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
    );
    var tag = {
        china: 143243243,
    }
    $(function () {
        var button = document.createElement("button"); //创建一个input对象（提示框按钮）
        button.textContent = "自动答题";
        button.style.cssText = "position:absolute;top:130px;left:50px;z-index:1;background-color:pink;width:75px;height:50px;border:0;";
        button.style.align = "center";
        document.body.appendChild(button);
        button.onclick = function fix() {
            for (let i = 0; i < number; i++) {
                var n = i + 1;
                if (flag[i] == 1) {
                    document.getElementById('div' + n).getElementsByTagName('li')[ans[i] - 1].click();
                } else if (flag[i] == 2) {
                    for (var everychose in ans[i]) {
                        console.log(everychose);
                        document.getElementById('div' + n).getElementsByTagName('li')[everychose - 1].click();
                    }
                }
            }
        }
    });
    // Your code here...
})();

