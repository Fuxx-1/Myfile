var storage = storages.create("cn.xupt.sign.mine.variable");
const deviceWidth = device.width,
    deviceHeight = device.height;
function notify(notifyId, title, text) {
    // var intent = Intent(this, MaterialButtonActivity::class.java);
    // var pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
    var manager = context.getSystemService(android.app.Service.NOTIFICATION_SERVICE);
    var notification;
    var channel = new android.app.NotificationChannel("CaptureForegroundService.foreground", "cn.xupt.sign", android.app.NotificationManager.IMPORTANCE_HIGH);
    channel.enableLights(true);
    channel.setLightColor(0xff0000);
    channel.setShowBadge(true);
    manager.createNotificationChannel(channel);
    notification = new android.app.Notification.Builder(context, CaptureForegroundService.foreground)   
        .setContentTitle(title)
        .setContentText(text)
        .setWhen(new Date().getTime())
        .setSmallIcon(android.R.drawable.ic_delete)
        .setTicker("这是状态栏显示的内容")
        .setOngoing(true)
        .setPriority(android.app.NotificationManager.IMPORTANCE_HIGH)
        // .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .setAutoCancel(true)
        // .setContentIntent(pendingIntent)
        .build();
    manager.notify(notifyId % 2000000000, notification);
}
notify(2, "打卡正在运行中", "状态待更新 · 今日打卡成功");
