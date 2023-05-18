const RoomList = {
    '3号宿舍楼': ['301', '302', '303'], '7号宿舍楼': ['701', '702', '703'], '8号宿舍楼': ['801', '802', '803'],
};
const pswdRegExp = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[^]{8,16}$/
const emailExp = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/
let hasMore = false
$(document).ready(function () {
    const lessBtn = $("#lessBtn");
    const moreBtn = $("#moreBtn");
    const submitBtn = $("#submitBtn");
    const form = {
        name: $("#name"), pwd: $("#pwd"), pwd2: $("#pwd2"), gender: $("#gender"), email: $("#email"), room: $("#room1"), roomDetail: $("#room2")
    };
    for (let formKey in form) {
        form[formKey].on('input', testForm);
    }
    lessBtn.click(function () {
        $(".moreInf").hide();
        moreBtn.show() && lessBtn.hide();
        hasMore = false;
    });
    moreBtn.click(function () {
        $(".moreInf").show();
        moreBtn.hide() && lessBtn.show();
        hasMore = true;
    });
    lessBtn.click();
    submitBtn.click(function () {
        if (testForm() !== true) { alert("表单存在问题"); return; }
        else if ($("#agree")[0].checked !== true) { alert("请同意用户协议"); return; }//协议验证
        const formData = { name: $("#name").val(), pwd: $("#pwd").val(), gender: $("#gender").val(), hasDetail: hasMore, email: $("#email").val(), room: $("#room1").val(), roomDetail: $("#room2").val() };
        $("hr").show();
        $("#resp").load("./Register", formData, function (responseTxt, statusTxt, xhr) {
            if (statusTxt === "success") { console.log("外部内容加载成功!"); }
            else { console.log("Error: " + xhr.status + ": " + xhr.statusText); }
        });
    });
});

function updateRoom2() {
    const selectedRoom = $("#room1").val();
    const roomList = RoomList[selectedRoom] || [];
    $("#room2")[0].innerHTML = '<option value="NONE">请选择</option>' + roomList.map(roomId => `<option value="${roomId}">${roomId}</option>`).join('');
}

function testForm() {
    let result = true;
    const form = {
        name: $("#name"), pwd: $("#pwd"), pwd2: $("#pwd2"), gender: $("#gender"), email: $("#email"), room: $("#room1"), roomDetail: $("#room2")
    };
    /* 用户名验证 */
    const name = form.name.val(), nameStatus = $("#nameStatus");
    if (name.length === 0) {
        nameStatus.text("请填写用户名").css("color", "red");
        result = false;
    } else if (name === "shangsan" || name === "lisi") {
        nameStatus.text("该用户名已经注册").css("color", "red");
        result = false;
    } else {
        nameStatus.text("该用户名可以使用").css("color", "black");
    }
    /* 密码验证 */
    const pwd = form.pwd.val(), pwdStatus = $("#pwdStatus");
    if (pwd.length === 0) {
        pwdStatus.text("请填写密码").css("color", "red");
        result = false;
    } else if (!pswdRegExp.test(pwd)) {
        pwdStatus.text("密码需包含大小写字母、数字、特殊字符，且长度在8到16位").css("color", "red");
        result = false;
    } else {
        pwdStatus.text("密码正常").css("color", "black");
    }
    /* 密码确认验证 */
    if (form.pwd.val() !== form.pwd2.val()) {
        $("#pwd2Status").text("两次输入的密码不一致").css("color", "red");
        result = false;
    } else {
        $("#pwd2Status").text("密码一致").css("color", "black");
    }
    /* 性别验证 */
    if (form.gender.val() === "M" || form.gender.val() === "F") {
        $("#genderStatus").text("性别已选择").css("color", "black");
    } else {
        $("#genderStatus").text("请选择性别").css("color", "red");
        result = false;
    }
    if (hasMore) {
        /* 邮箱验证 */
        const email = form.email.val();
        if (email.length === 0) {
            $("#emailStatus").text("请填写邮箱").css("color", "red");
            result = false;
        } else if (!emailExp.test(email)) {
            $("#emailStatus").text("邮箱格式有误").css("color", "red");
            result = false;
        } else {
            $("#emailStatus").text("邮箱正常").css("color", "black");
        }
        /* 宿舍验证 */
        if (form.room.val() === "NONE" || form.roomDetail.val() === "NONE") {
            $("#roomStatus").text("请选择宿舍").css("color", "red");
            result = false;
        } else {
            $("#roomStatus").text("宿舍已选择").css("color", "black");
        }
    }
    console.log(result);
    return result;
}

