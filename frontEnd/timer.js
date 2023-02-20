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
    if (!(storage.get("signDate") == new Date().getDay())) {
        notify(1, "打卡结果", "等待中 · 今日未执行，请手动执行", true);
    } else {
        notify(1, "打卡结果", storage.get("signState") === "T" ? "等待中 · 今日打卡成功" : "等待中 · 今日打卡失败", true);
    }
    // 定时执行脚本
    while (true) {
        threads.shutDownAll();
        if (!(new Date().getDay() === storage.get("signDate")) && new Date().getHours() == Number(myVariable.signTime.split(":")[0]) && new Date().getMinutes() >= Number(myVariable.signTime.split(":")[1])) {
            console.clear();
            console.log("========== 时间到，开始打卡 ========== ");
            var sign = threads.start(function () {
                // 在新线程执行的代码
                engines.execScriptFile("./sign.js");
                // 启动签到线程
            });
            sign.join();
            storage.put("signDate", new Date().getDay());
            notify(1, "打卡结果", storage.get("signState") === "T" ? "等待中 · 今日打卡成功" : "等待中 · 今日打卡失败", true);
            var sleepTime = 3600000 * 20;
            console.log("[Sleep*20]" + sleepTime / 60000);
            sleep(sleepTime);
        } else if (new Date().getHours() == Number(myVariable.signTime.split(":")[0]) && new Date().getMinutes() < Number(myVariable.signTime.split(":")[1])) {
            var sleepTime = Number(myVariable.signTime.split(":")[1]) * 60000 - new Date().getTime() % 3600000;
            sleepTime = sleepTime > 60000 ? sleepTime : 60000; // 负数置60000
            console.log("[Sleep]" + sleepTime / 60000);
            sleep(sleepTime);
        } else {
            var sleepTime = 3660000 - new Date().getTime() % 3600000;
            console.log("[Sleep]" + sleepTime / 60000);
            sleep(sleepTime);
        }
        threads.shutDownAll();
    }
}

// ============================== 功能函数 ==============================

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
 * 设置变量
 * @param {Storage} storage 储存
 * @param {String} agreement 用户协议同意状态
 * @param {String} pwd 密码
 * @param {String} signTime 执行时间
 * @param {String} healthyState 健康状态
 * @param {String} isQuarantine 是否隔离
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