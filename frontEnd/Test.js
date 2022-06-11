/**
 * 本脚本完全免费，仅供学习参考，请勿在真实环境使用，不得用于任何商业或任何非法用途，您必须在下载后24个小时内，彻底删除该脚本，否则，一切后果由用户自行承担。
 */
const {
    isQuarantine,
    tamperature,
    pwd,
    needFix,
    agreement
} = hamibot.env;

const deviceWidth = device.width,
    deviceHeight = device.height;

/**
 * 初始化终端
 */
function initConsole() {
    console.show();
    console.setSize(deviceWidth / 2, deviceHeight / 2);
    console.setPosition(200, 50);
    console.log("是否居家隔离: " + isQuarantine +
        "\n是否填体温: " + needFix +
        " | " + tamperature);
}

function main() {
    init();
    initConsole();
    // 打开console并输出用户变量
    openWechat();
    // 打开微信
    /* 打卡流程 */
    enterDailyPage();
    // 进入健康打卡
    sleep(200);
    /* 排除已打卡情况 */
    if (text("已打卡").find().length > 0) {
        toast("今日已打卡");
        execOver();
    }
    fixForm();
    // 填表单
    ClickUntilAppear('点击获取位置', 1);
    // 获取位置
    /* 等待并点击确认 */
    while (true) {
        if (textMatches("/[^市]{1,}[市][^市]{1,}/").find().length > 0) {
            ClickUntilAppear('提交', 1);
            ClickUntilAppear('确定', 1);
            break;
        }
        sleep(200);
    }
    sleep(300);
    toast("打卡完毕");
    sleep(500);
    // 输出打卡完毕提示
    execOver();
    //结束运行
}

// =============== 功能函数 ===============
/**
 * 休眠函数
 * @param n 要休眠几秒
 * @return void
 **/
function My_SLEEP(n) {
    toast("等待" + n + "秒");
    sleep(n * 1000);
}

/**
 * 死等点击函数
 * @param t 点击的文本
 * @param i 选择使用哪种点击方式 
 * @return void
 **/
function ClickUntilAppear(t, i) {
    var tNoEnter = t.replace(/\n/g, '');
    console.log("=>等待" + tNoEnter + "...", end = "");
    sleep(200);
    if (i == 0 || i == null) {
        text(t).waitFor();
        sleep(200);
        if (click(t)) {
            console.log(tNoEnter + "点击成功");
        } else {
            console.log(tNoEnter + "点击失败");
        }
    } else {
        text(t).waitFor();
        sleep(200);
        if (text(t).findOnce().click()) {
            console.log(tNoEnter + "点击成功");
        } else {
            console.log(tNoEnter + "点击失败");
        }
    }
}

/**
 * 睡眠点击函数
 * @param t 点击的文本
 * @param i sleep时间 
 * @return void
 **/
function ClickWithSleep(t, i) {
    sleep(i * 1000);
    click(t);
    text(t).findOnce().click();
}

/**
 * 输入密码
 */
function password_input() {
    for (var i = 0; i < pwd.length; i++) {
        var p = text(pwd[i].toString()).findOne().bounds();
        click(p.centerX(), p.centerY());
        sleep(100);
    }
    sleep(2000);
}

/**
 * 解锁屏幕
 */
function unlock() {
    if (!device.isScreenOn()) {
        device.wakeUp();
        sleep(500);
        swipe(500, 1000, 500, 50, 400);
        password_input();
    }
}

/**
 * 启动微信
 */
function openWechat() {
    // 确保启动微信
    sleep(100);
    launch('com.tencent.mm');

    // 确保微信启动中不被打断
    while (true) {
        var activityRegex = /com.tencent.mm.(splash|app.WeChatSplashActivity)[a-zA-Z.]{0,}/;
        if (!activityRegex.test(currentActivity())) { break; }
        press(deviceWidth / 2, deviceHeight / 2, 10);
        sleep(500);
    }
    sleep(500);
    // 确保在微信主页面
    while (text("我").find().length < 1) {
        back();
        sleep(200);
    }
    console.log("==微信主页==");
}

/**
 * 检查环境并返回主页
 */
function init() {
    //用户协议是否同意
    if (agreement === "No") {
        toast("请在编辑中同意协议！否则脚本拒绝执行");
        exit();
    }
    // 无障碍及回主页
    auto.waitFor();
    home();
}

/**
 * 进入打卡界面
 * 要求现在正在微信主页
 */
function enterDailyPage() {
    for (let i = 0; i < 50; i++) {
        swipe(50, 500, 50, deviceHeight - 400, 10);
    }
    swipe(50, deviceHeight - 400, 50, 500, 500);
    while (!click('我在校园')) {
        swipe(50, deviceHeight - 200, 50, 500, 300);
    }
    for (let i = 0; i < 3; i++) {
        click('学生端');
        if (id("fc").find().length > 0) {
            break;
        }
        sleep(1000);
    }
    console.log("==我在校园主页==");
    while (1) {
        My_SLEEP(1);
        while (className("android.widget.ProgressBar").find().length > 0) {
            sleep(20);
        }
        My_SLEEP(1.5);
        if (text("健康打卡").find().length > 0) {
            break;
        }
        while (!id("fc").findOne().click());
        ClickUntilAppear('重新进入\n小程序', 0);
    }
    ClickUntilAppear('健康打卡', 0);
    text("每日健康情况登记").waitFor();
    console.log("==健康打卡主页==");
}

/**
 * 结束执行
 */
function execOver() {
    home();
    // 回主页
    console.hide();
    // 隐藏对话框
    exit();
    // 退出
}

/**
 * 填写表单
 */
function fixForm() {
    // 填选择
    ClickUntilAppear(isQuarantine, 1);
    if (text('').find().length <= 1) {
        ClickUntilAppear('无下列情况,身体健康', 1);
    }
    // 填体温
    if (needFix === "是") {
        swipe(500, 1000, 500, 50, 400);
        var obj = text("3 . 您今日的体温是多少？(填空)").findOnce().parent().child(17).child(0);
        click(obj.parent().bounds().centerX(), obj.parent().bounds().centerY());
        setClip("914857062894570234895703123459872345823940534759" +
            "823475923485792384748957234905872034857234089574590823457023485734589237692347856 ");
        obj.paste();
        sleep(200);
        longClick(30, obj.parent().bounds().centerY());
        sleep(200);
        setClip(tamperature);
        obj.paste();
    }
}

// ===============触发函数===============
unlock();
// 解锁屏幕,自动判断是否需要
main();
// 主函数