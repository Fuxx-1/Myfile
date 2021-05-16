$(function () {
    var i = 1;
    var Reg = /^\d{11}$/;
    var $phoneObj = $("#phone");
    $(".btn").click(function () {
        alert($phoneObj.val());
    });
    $phoneObj.blur(function () {
        var isTrue = Reg.test($phoneObj.val());
        if (isTrue) {
            $("#phone_check").html("合法");
            $("#phone_check").css("color", "green");
            $("#phone_check").css("font-size", "12px");
            $("<p>$控制台:&nbsp;电话项[合法]&nbsp;第&nbsp;" + i++ + "&nbsp;次审查完毕</p>").prependTo(".message").css("color", "green");
        } else {
            $("#phone_check").html("不合法");
            $("#phone_check").css("color", "red");
            $("#phone_check").css("font-size", "12px");
            $("<p>$控制台:&nbsp;电话项[不合法]&nbsp;第&nbsp;" + i++ + "&nbsp;次审查完毕</p>").prependTo(".message").css("color", "red");
        }
    });
});