// ============================== 变量获取或初始化 ==============================

var storage = storages.create("cn.xupt.sign.mine.variable");
if (!storage.contains("agreement")) {
    setVariable(storage, "否", "", "1:00", "是", "否", "否", "36.5", "否");
}
var myVariable = getVariable(storage);
const deviceWidth = device.width,
    deviceHeight = device.height;

// ============================== 主函数 ==============================
function main() {
    // 定时执行脚本
    while (true) {
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
        } else if (new Date().getHours() == Number(myVariable.signTime.split(":")[0]) && new Date().getMinutes() <= Number(myVariable.signTime.split(":")[1])) {
            var sleepTime = Number(myVariable.signTime.split(":")[1]) * 60000 - new Date().getTime() % 3600000;
            sleepTime = sleepTime > 0 ? sleepTime : 0; // 负数置零
            console.log("[Sleep]" + sleepTime / 60000);
            sleep(sleepTime);
        } else {
            var sleepTime = 3600000 - new Date().getTime() % 3600000;
            console.log("[Sleep]" + sleepTime / 60000);
            sleep(sleepTime);
        }
        threads.shutDownAll();
    }
}

// ============================== 功能函数 ==============================

/**
 * 设置变量
 * @param {Storage} storage 储存
 * @param {String} agreement 用户协议同意状态
 * @param {String} pwd 密码
 * @param {String} signTime 执行时间
 * @param {String} healthyState 健康状态
 * @param {String} isQuarantine 是否隔离
 * @param {String} needFix 是否需要填体温
 * @param {String} tamperature 体温
 * @param {String} autoSubmit 自动提交
 */
 function setVariable(storage, agreement, pwd, signTime, healthyState, isQuarantine, needFix, tamperature, autoSubmit) {
    storage.put("agreement", agreement);
    storage.put("pwd", pwd);
    storage.put("signTime", signTime);
    storage.put("healthyState", healthyState);
    storage.put("isQuarantine", isQuarantine);
    storage.put("needFix", needFix);
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
        "isQuarantine": storage.get("isQuarantine"),
        "needFix": storage.get("needFix"),
        "tamperature": storage.get("tamperature"),
        "autoSubmit": storage.get("autoSubmit")
    };
}

// ============================== 触发函数============================== 
main();
// 主函数