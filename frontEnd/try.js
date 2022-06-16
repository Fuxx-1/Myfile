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
    for (let i = 0; i < latencyTime; i++) {
        if (text(textToClick).exists()) {
            for (let i = 0; i < 3; i++) {
                if (click(textToClick) || text(textToClick).findOnce().click()) {
                    console.log("[点击成功]" + textToClick.replace(/\n/g, ''));
                    return true;
                }
            }
            // 尝试点击三次后失败
            throw ButtonClickFailedError;
        } else {
            sleep(1000);
        }
    }
    throw ButtonNotFoundError;
    // 未找到按钮
}

while (!id("fc").findOne().click());
ClickOvertime("重新进入\n小程序", 3);

/**
 * 确定
 */
function confirm() {
    console.log("旧设置：\n" + JSON.stringify(getVariable(storage)));
    setVariable(storage,
        ui.agreement.checked ? "是" : "否",
        String(ui.pwd.getText() ? ui.pwd.getText() : ""),
        ui.signTime.getCurrentHour() + ": " + ui.signTime.getCurrentMinute(),
        ui.healthyState.checked ? "是" : "否",
        ui.isQuarantine.checked ? "是" : "否",
        ui.needFix.checked ? "是" : "否",
        String(ui.tamperature.getText() ? ui.tamperature.getText() : ""),
        ui.autoSubmit.checked ? "是" : "否"
    );
    toastLog("[Setting]Save Over!");
    console.log("现设置：\n" + JSON.stringify(getVariable(storage)));
    openSignThread();
    toastLog("[Setting]Restart Over!");
    setView(getVariable(storage));
}