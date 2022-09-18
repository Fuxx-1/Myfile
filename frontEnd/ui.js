"ui"; // 启用ui引擎
var color = "#009688";

// ============================== 变量 ==============================

var storage = storages.create("cn.xupt.sign.mine.variable");
if (!storage.contains("agreement")) {
    setVariable(storage, "否", "", "1:00", "否", "否", "否", "36.5", "否");
}
var version = app.versionName;

// ============================== 功能函数 ==============================

/**
 * 检查软件更新
 */
function checkUpdate() {
    http.get("https://cdn.newimg.ltd/app/%E6%89%93%E5%8D%A1/version.json", {}, function (res, err) {
        if (err) {
            console.error(err);
            return;
        }
        log("[HttpRequest]:version.json");
        log("[thisVersion]:" + version);
        JSON.parse(res.body.string())['version'].forEach(element => {
            if (element['version'] > version) {
                log("[newVersion]:" + element['version']);
                log("发现新版本：v" + element['version']);
                notify(2, "发现新版本：v" + element['version'], "版本描述：" + element['describe'], true);
            }
        });
    });
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
    setView(getVariable(storage));
}

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

/**
 * 停止除当前线程外的所有线程，并启动签到线程
 */
function openSignThread() {
    // 停止除自己外的所有线程
    engines.all().map((ScriptEngine) => {
        if (engines.myEngine().toString() != ScriptEngine.toString()) {
            ScriptEngine.forceStop();
        }
    });
    // 启动签到线程
    var sign = threads.start(function () {
        //在新线程执行的代码
        engines.execScriptFile("./timer.js");
    });
    toastLog("[Setting]Restart Over!");
}

/**
 * 在视图中设置变量现在的状态
 * @param {Object} Variable 变量
 */
 function setView(Variable) {
    if (Variable.agreement === "是") {
        ui.agreement.checked = true;
    } else {
        ui.not_agreement.checked = true;
    }
    ui.pwd.setText(Variable.pwd);
    ui.signTime.setCurrentHour(Number(Variable.signTime.split(":")[0]));
    ui.signTime.setCurrentMinute(Number(Variable.signTime.split(":")[1]));
    if (Variable.healthyState === "是") {
        ui.healthyState.checked = true;
    } else {
        ui.not_healthyState.checked = true;
    }
    if (Variable.isQuarantine === "是") {
        ui.isQuarantine.checked = true;
    } else {
        ui.not_isQuarantine.checked = true;
    }
    if (Variable.needFix === "是") {
        ui.needFix.checked = true;
    } else {
        ui.not_needFix.checked = true;
    }
    ui.tamperature.setText(Variable.tamperature);
    if (Variable.autoSubmit === "是") {
        ui.autoSubmit.checked = true;
    } else {
        ui.not_autoSubmit.checked = true;
    }
    openSignThread();
}

// ============================== 主函数 ==============================

ui.layout( 
    <drawer id="drawer">
        <vertical>
            <appbar bg="#7ABD9A">
                <toolbar id="toolbar" title="打卡" />
                <tabs id="tabs" />
                <horizontal id="teach" bg="#FFB103">
                    <img h="*" padding="5 5 0 5" margin="0" src="@drawable/ic_warning_black_48dp" tint="#FF0000"/>
                    <vertical>
                        <text w="*" text="公告、软件和使用教程请点这里" ellipsize="marquee" padding="0 8 8 8" textSize="12sp"/>
                    </vertical>
                </horizontal>
            </appbar>
            <viewpager id="viewpager">
                <frame>
                    <ScrollView>
                        <vertical padding="20">
                            <text textSize="23sp" textStyle="bold" margin="10" gravity="center" padding="5">
                                免责及隐私保护声明
                            </text>
                            <text textSize="19sp" textStyle="bold" margin="0 10 10 10" gravity="left" padding="5">
                                关于本声明
                            </text>
                            <text textSize="15sp" textStyle="bold" gravity="left" padding="10">
                                1、本免责及隐私保护声明（以下简称“隐私声明”或“本声明”）适用于“打卡”软件（以下简称“本软件”）。
                            </text>
                            <text textSize="15sp" textStyle="bold" gravity="left" padding="10">
                                2、任何单位或个人认为通过本产品提供的软件可能涉嫌侵犯其合法权益，应该及时向作者发邮件反馈，并提供身份证明、权属证明及详细侵权情况证明，作者在收到文件后，将会尽快移除被控侵权软件。
                            </text>
                            <text textSize="15sp" textStyle="bold" gravity="left" padding="10">
                                3、在您阅读本声明后若不同意此声明中的任何条款，或对本声明存在质疑，请立刻停止使用并卸载本软件。若您已经开始或正在使用本软件，则表示您已阅读并同意本声明的所有条款。
                            </text>
                            <text textSize="19sp" textStyle="bold" margin="0 10 10 10" gravity="left" padding="5">
                                免责声明
                            </text>
                            <text textSize="15sp" gravity="left" padding="10">
                                1、使用软件造成的任何后果均由用户自行承担。
                            </text>
                            <text textSize="15sp" gravity="left" padding="10">
                                2、本软件完全免费，仅供学习参考，请勿在任何环境使用，不得用于任何商业或任何非法用途。
                            </text>
                            <text textSize="15sp" gravity="left" padding="10">
                                3、您必须在下载后24个小时内，停止使用并彻底卸载本软件，否则，一切后果将由用户自行承担。
                            </text>
                            <text textSize="19sp" textStyle="bold" margin="0 10 10 10" gravity="left" padding="5">
                                隐私保护声明
                            </text>
                            <text textSize="15sp" gravity="left" padding="10">
                                1、您所填写的所有信息均在本地保存，仅在本地使用，不会以任何形式上传云端。
                            </text>
                        </vertical>
                    </ScrollView>
                </frame>
                <frame>
                    <ScrollView>
                        <vertical padding="25">
                            <horizontal>
                                <text textSize="15sp" gravity="left" padding="5 5 0 5">1、关于无障碍服务</text>
                                <text textSize="15sp" gravity="left" padding="0" textColor="#FF0000">【请确保开启】</text>
                            </horizontal>
                            <horizontal>
                                <Switch id="autoSwitch" text="无障碍服务" checked="{{auto.service != null}}" textSize="15sp"/>
                            </horizontal>
                            <text textSize="15sp" gravity="left" padding="5 10 5 5">2、关于用户条款【必填】</text>
                            <horizontal>
                                <radiogroup orientation="horizontal">
                                    <radio id="agreement" marginRight="20" text="我同意" />
                                    <radio id="not_agreement" text="我不同意" />
                                </radiogroup>
                            </horizontal>
                            <text textSize="15sp" gravity="left" padding="5 10 5 5">3、手机密码（目前不支持手势密码）【选填】</text>
                            <input id="pwd" textSize="15sp" password="true" hint="密码保存在本地，仅用于解锁屏幕" />
                            <text textSize="15sp" gravity="left" padding="5 10 5 5">4、脚本每天执行时间（误差不超过10min）【选填】</text>
                            <timepicker id="signTime" textSize="15sp" timePickerMode="spinner" />
                            <horizontal gravity="center" padding="5 20 5 5">
                                <button id="reset_fir" text="重置" layout_gravity="center" marginRight="50" w="auto"></button>
                                <button id="confirm_fir" text="确认" layout_gravity="center" w="auto" style="Widget.AppCompat.Button.Colored"></button>
                            </horizontal>
                        </vertical>
                    </ScrollView>
                </frame>
                <frame>
                    <ScrollView>
                        <vertical padding="25">
                            <text textSize="15sp" gravity="left" padding="5 10 5 5">1、关于新冠，我的状况【必填】</text>
                            <horizontal>
                                <radiogroup orientation="vertical">
                                    <radio id="healthyState" text="无相关情况，身体健康" />
                                    <radio id="not_healthyState" text="其他，并暂停打卡" />
                                </radiogroup>
                            </horizontal>
                            <text textSize="15sp" gravity="left" padding="5 10 5 5">2、是否处于居家隔离【必填】</text>
                            <horizontal>
                                <radiogroup orientation="horizontal">
                                    <radio id="isQuarantine" marginRight="20" text="是" />
                                    <radio id="not_isQuarantine" text="否" />
                                </radiogroup>
                            </horizontal>
                            <text textSize="15sp" gravity="left" padding="5 10 5 5">3、是否需要填写体温（可能不兼容）【必填】</text>
                            <horizontal>
                                <radiogroup orientation="vertical" padding="3">
                                    <radio id="needFix" text="是" />
                                    <radio id="not_needFix" text="否" />
                                </radiogroup>
                                <horizontal>
                                    <text textSize="15sp" digits="1234567890.">，且体温为：</text>
                                    <input id="tamperature" width="100sp" gravity="center" textSize="15sp" hint="体温" text="36.5" />
                                </horizontal>
                            </horizontal>
                            <text textSize="15sp" gravity="left" padding="5 10 5 5">4、关于打卡提交（建议先手动几次，再自动）【必填】</text>
                            <horizontal>
                                <radiogroup orientation="horizontal">
                                    <radio id="autoSubmit" marginRight="20" text="自动" />
                                    <radio id="not_autoSubmit" text="手动" />
                                </radiogroup>
                            </horizontal>
                            <horizontal gravity="center" padding="5 20 5 5">
                                <button id="reset_sec" text="重置" layout_gravity="center" marginRight="50" w="auto"></button>
                                <button id="confirm_sec" text="确认" layout_gravity="center" w="auto" style="Widget.AppCompat.Button.Colored"></button>
                            </horizontal>
                        </vertical>
                    </ScrollView>
                </frame>
            </viewpager>
        </vertical>
        <vertical layout_gravity="left" bg="#ffffff" w="280">
            <img w="280" h="200" scaleType="fitXY"
                src="http://images.shejidaren.com/wp-content/uploads/2014/10/023746fki.jpg" />
            <list id="menu">
                <horizontal bg="?selectableItemBackground" w="*">
                    <img w="50" h="50" padding="16" src="{{this.icon}}" tint="{{color}}" />
                    <text textColor="black" textSize="15sp" text="{{this.title}}" layout_gravity="center" />
                </horizontal>
            </list>
        </vertical>
    </drawer>
);

//创建选项菜单(右上角)
ui.emitter.on("create_options_menu", menu=>{
    menu.add("开始等待");
    menu.add("日志");
    menu.add("设置");
    menu.add("退出");
});
//监听选项菜单点击
ui.emitter.on("options_item_selected", (e, item)=>{
    switch(item.getTitle()){
        case "开始等待":
            openSignThread();
            break;
        case "日志":
            app.startActivity("console");
            break;
        case "设置":
            app.startActivity("settings");
            break;
        case "退出":
            ui.finish();
            break;
    }
    e.consumed = true;
});
activity.setSupportActionBar(ui.toolbar);

//设置滑动页面的标题
ui.viewpager.setTitles(["用户条款", "脚本设置", "打卡设置"]);
//让滑动页面和标签栏联动
ui.tabs.setupWithViewPager(ui.viewpager);

//让工具栏左上角可以打开侧拉菜单
ui.toolbar.setupWithDrawer(ui.drawer);

ui.menu.setDataSource([
    {
      title: "作者：Fuxx-1@Github",
      icon: "@drawable/ic_person_black_48dp"
    },
    {
    title: "尝试打卡一次（不计入）",
    icon: "@drawable/ic_verified_user_black_48dp"
    },
    {
      title: "日志",
      icon: "@drawable/ic_assignment_black_48dp"
    },
    {
      title: "设置",
      icon: "@drawable/ic_settings_black_48dp"
    },
    {
      title: "退出",
      icon: "@drawable/ic_exit_to_app_black_48dp"
    }
]);

ui.menu.on("item_click", item => {
    switch(item.title){
        case "作者：Fuxx-1@Github":
            app.openUrl("https://github.com/fuxx-1");
            break;        
        case "尝试打卡一次（不计入）":
            var sign = threads.start(function () {
                // 在新线程执行的代码，并启动签到线程
                engines.execScriptFile("./sign.js");
            });
            break;
        case "日志":
            app.startActivity("console");
            break;
        case "设置":
            app.startActivity("settings");
            break;
        case "退出":
            ui.finish();
            break;
    }
})

ui.signTime.setIs24HourView(true);//设置当前时间控件为24小时制

// 设置视图
setView(getVariable(storage));
checkUpdate();

// 点击确定
ui.confirm_fir.on("click", function() {
    confirm();
});

ui.confirm_sec.on("click", function() {
    confirm();
});

// 点击重置
ui.reset_fir.on("click", function() {
    setVariable(storage, "否", "", "1:00",
        ui.healthyState.checked ? "是" : "否",
        ui.isQuarantine.checked ? "是" : "否",
        ui.needFix.checked ? "是" : "否",
        String(ui.tamperature.getText() ? ui.tamperature.getText() : ""),
        ui.autoSubmit.checked ? "是" : "否"
    );
    toastLog("[Setting]Reset Over!");
    console.log("现设置：\n" + JSON.stringify(getVariable(storage)));
    openSignThread();
    setView(getVariable(storage));
});

ui.reset_sec.on("click", function() {
    setVariable(storage, 
        ui.agreement.checked ? "是" : "否", 
        String(ui.pwd.getText() ? ui.pwd.getText() : ""),
        ui.signTime.getCurrentHour() + ": " + ui.signTime.getCurrentMinute(),
        "否", "否", "否", "36.5", "否"
    );
    toastLog("[Setting]Reset Over!");
    console.log("现设置：\n" + JSON.stringify(getVariable(storage)));
    openSignThread();
    setView(getVariable(storage));
});

ui.emitter.on("resume", function() {
    setView(getVariable(storage));
    ui.autoSwitch.checked = auto.service != null;
    openSignThread();
});

ui.teach.on("click", function() {
    app.openUrl("https://ali.newimg.ltd/Uadgb_J5m9g30JDMbcJqLJ");
});

ui.autoSwitch.on("check", function(checked) {
    // 用户勾选无障碍服务的选项时，跳转到页面让用户去开启
    if (checked && auto.service == null) {
        app.startActivity({
            action: "android.settings.ACCESSIBILITY_SETTINGS"
        });
    }
    if (!checked && auto.service != null) {
        auto.service.disableSelf();
    }
});