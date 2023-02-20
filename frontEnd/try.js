


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