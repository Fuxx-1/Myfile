// ============================== 变量获取或初始化 ==============================

var storage = storages.create("cn.xupt.sign.mine.variable");
if (!storage.contains("agreement")) {
    setVariable(storage, "否", "", "1:00", "否", "36.5", "否");
}
var myVariable = getVariable(storage);
const deviceWidth = device.width,
    deviceHeight = device.height;

// ============================== 主函数 ==============================


function main() {
    try {
        storage.put("signState", "F");
        unlock(); // 解锁屏幕,自动判断是否需要
        signIn(); // 签到
    } catch (error) {
        console.log("[WARN]" + error);
    }
}

// ============================== 功能函数 ==============================
/**
 * 休眠函数
 * @param n 要休眠几秒
 * @return void
 **/
function My_SLEEP(n) {
    toastLog("等待" + n + "秒");
    sleep(n * 1000);
}
/**
 * 发送通知
 * @param {Integer} notifyId 通知id
 * @param {String} title 标题
 * @param {String} text 通知文本
 * @param {boolean} onGoing 是否能侧滑取消
 */
function notify(notifyId, title, text, onGoing) {
    // var intent = Intent(this, MaterialButtonActivity::class.java);
    // var pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
    var manager = context.getSystemService(android.app.Service.NOTIFICATION_SERVICE);
    var notification;
    var channel = new android.app.NotificationChannel("CaptureForegroundService.foreground", "cn.xupt.sign", android.app.NotificationManager.IMPORTANCE_HIGH);
    channel.enableLights(true);
    channel.setLightColor(0xff0000);
    channel.setShowBadge(true);
    manager.createNotificationChannel(channel);
    notification = new android.app.Notification.Builder(context, "CaptureForegroundService.foreground")
        .setContentTitle(title)
        .setContentText(text)
        .setWhen(new Date().getTime())
        .setSmallIcon(android.R.drawable.ic_delete)
        .setTicker("这是状态栏显示的内容")
        .setOngoing(!onGoing)
        .setPriority(android.app.NotificationManager.IMPORTANCE_HIGH)
        // .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .setAutoCancel(true)
        // .setContentIntent(pendingIntent)
        .build();
    manager.notify(notifyId % 2000000000, notification);
}

/**
 * 点击函数
 * @param textToClick 点击的文本
 * @param latencyTime 等待时间 
 * @return 是否点击成功
 **/
function ClickOvertime(textToClick, latencyTime) {
    console.log("[等待]" + textToClick.replace(/\n/g, ''));
    // 等待日志
    sleep(50);
    // 等待
    for (let i = 0; i < latencyTime * 5; i++) {
        if (text(textToClick).exists()) {
            for (let i = 0; i < 3; i++) {
                if (text(textToClick).findOnce().click() || click(textToClick)) {
                    console.log("[点击成功]" + textToClick.replace(/\n/g, ''));
                    return true;
                }
            }
            // 尝试点击三次后失败
            throw ButtonClickFailedError;
        } else {
            sleep(200);
        }
    }
    throw ButtonNotFoundError;
    // 未找到按钮
}

/**
 * 点击函数
 * @param textToClick 点击的文本
 * @param latencyTime 等待时间 
 * @return 是否点击成功
 **/
function TryClickXY(textToClick, latencyTime) {
    console.log("[等待]" + textToClick.replace(/\n/g, ''));
    // 等待日志
    sleep(50);
    // 等待
    for (let i = 0; i < latencyTime * 5; i++) {
        if (text(textToClick).exists()) {
            var obj = text(textToClick).findOnce();
            click(obj.parent().bounds().centerX(), obj.parent().bounds().centerY());
            return true
        } else {
            sleep(200);
        }
    }
    throw ButtonNotFoundError;
    // 未找到按钮
}

/**
 * 初始化终端
 */
function initConsole() {
    // console.show();
    // console.setSize(deviceWidth / 2, deviceHeight / 2);
    // console.setPosition(200, 50);
    console.log("体温: " + myVariable.tamperature +
        "\n自动提交：" + myVariable.autoSubmit
    );
}

/**
 * 输入密码
 */
function password_input() {
    for (var i = 0; i < myVariable.pwd.length; i++) {
        var p = text(myVariable.pwd[i].toString()).findOne().bounds();
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
        swipe(200, 1800, 200, 400, 500);
        try {
            password_input();
        } catch (Error) {
            throw Error;
        }
    }
}


/**
 * 启动微信
 */
function openWechat() {
    // 确保启动微信
    sleep(100);
    launch('com.tencent.mm');

    waitForPackage('com.tencent.mm');

    // 确保微信启动中不被打断
    while (true) {
        var activityRegex = /com.tencent.mm.(splash|app.WeChatSplashActivity)[a-zA-Z.]{0,}/;
        if (!activityRegex.test(currentActivity())) {
            break;
        }
        press(deviceWidth / 2, deviceHeight / 2, 10);
        sleep(500);
    }
    My_SLEEP(1);
    // 确保在微信主页面
    for (let i = 0; i < 10; i++) {
        if (text("我").find().length < 1) {
            back();
            sleep(1000);
        } else {
            break;
        }
    }
    My_SLEEP(1);
    var weMain = text("微信").findOnce();
    while (!click(weMain.bounds().centerX(), weMain.bounds().centerY()));
    console.log("==微信主页==");
}

/**
 * 检查环境并返回主页
 */
function init() {
    // 无障碍及回主页
    auto.waitFor();
    home();
}

/**
 * 进入打卡界面
 * 要求现在正在微信主页
 */
function enterDailyPage() {
    while (!desc("搜索").findOnce().click());
    setClip("https://gw.wozaixiaoyuan.com/h5/mobile/health/index/health");
    text("取消").waitFor();
    paste();
    setClip("");
    TryClickXY("小程序、公众号、文章、朋友圈和表情等", 7);
    My_SLEEP(2);
    TryClickXY("搜索", 15);
    TryClickXY("访问网页", 20);
    for (let i = 0; i < 3; i++) {
        sleep(500);
        click("允许");
    }
    text("我在校园").waitFor();
    if (text("已打卡").exists()) {
        storage.put("signState", "T");
        notify(1, "打卡结果", "状态待更新 · 今日打卡成功", true);
        toastLog("打卡成功");
        execOver(true);
    } else {
        ClickOvertime("未打卡", 5);
        text("* 1.当前位置").waitFor();
    }
    console.log("==健康打卡主页==");
}

/**
 * 结束执行
 * @param backHome 是否返回主页
 */
function execOver(backHome) {
    if (backHome) {
        home();
        // 回主页
    }
    console.hide();
    // 隐藏对话框
    console.log("子进程结束");
    // 结束子进程
    threads.currentThread().interrupt();
    // 退出
}

/**
 * 前置判断
 */
function prePending() {
    //用户协议是否同意
    if (myVariable.agreement === "否") {
        toastLog("请在编辑中同意协议！否则脚本拒绝执行");
        exit();
    }
    if (myVariable.healthyState === "否") {
        toastLog("打卡因您关于新冠的状况暂停");
        exit();
    }
}

/**
 * 填写表单
 */
function fixForm() {
    // 填选择
    var father = text("* 1.当前位置").findOnce().parent()
    father.child(2).click()
    for (let i = 0; i < 3; i++) {
        sleep(500);
        click("允许");
    }
    var tam = father.child(4).child(0).child(0);
    click(tam.bounds().left + 15, tam.bounds().top + 15);
    sleep(200);
    setClip(myVariable.tamperature);
    tam.paste();
    ClickOvertime(" 无下列情况,身体健康", 5);
}

/**
 * 打卡子线程
 */
function signIn() {
    sleep(500);
    prePending();
    init();
    initConsole();
    // 打开console并输出用户变量
    openWechat();
    // 打开微信
    /* 打卡流程 */
    enterDailyPage();
    // 进入健康打卡
    sleep(500);
    /* 排除已打卡情况 */
    if (text("已打卡").find().length > 0) {
        toastLog("今日已打卡");
        sleep(1500);
        storage.put("signState", "T");
        notify(1, "打卡结果", "状态待更新 · 今日打卡成功", true);
        execOver(true);
    } else {
        fixForm();
        // 填表单
        // 获取位置
        /* 等待并点击确认 */
        while (true) {
            if (textMatches("/[^市]{1,}[市][^市]{1,}/").find().length > 0) {
                if (myVariable.autoSubmit === "是") {
                    ClickOvertime('确认提交', 3);
                    ClickOvertime('确认', 3);
                } else {
                    storage.put("signState", "F");
                    notify(1, "打卡结果", "状态待更新 · 今日打卡失败", true);
                }
                break;
            }
            sleep(200);
        }
        sleep(1000);
        if(text("* 1.当前位置").exists()) {
            back();
        }
        if (text("已打卡").find().length > 0) {
            storage.put("signState", "T");
            notify(1, "打卡结果", "状态待更新 · 今日打卡成功", true);
            toastLog("打卡成功");
            execOver(true);
        } else {
            toastLog("打卡失败");
        }
        sleep(1500);
        // 输出打卡完毕提示
        execOver(false);
        //结束运行
    }
}

/**
 * 设置变量
 * @param {Storage} storage 储存
 * @param {String} agreement 用户协议同意状态
 * @param {String} pwd 密码
 * @param {String} signTime 执行时间
 * @param {String} healthyState 健康状态
 * @param {String} tamperature 体温
 * @param {String} autoSubmit 自动提交
 */
function setVariable(storage, agreement, pwd, signTime, healthyState, tamperature, autoSubmit) {
    storage.put("agreement", agreement);
    storage.put("pwd", pwd);
    storage.put("signTime", signTime);
    storage.put("healthyState", healthyState);
    storage.put("tamperature", tamperature);
    storage.put("autoSubmit", autoSubmit);
}

/**
 * 获取参数
 * @param {Storage} storage 储存
 * @returns Object
 */
function getVariable(storage) {
    return {
        "agreement": storage.get("agreement"),
        "pwd": storage.get("pwd"),
        "signTime": storage.get("signTime"),
        "healthyState": storage.get("healthyState"),
        "tamperature": storage.get("tamperature"),
        "autoSubmit": storage.get("autoSubmit")
    };
}

// ============================== 触发函数============================== 
main();
// 主函数