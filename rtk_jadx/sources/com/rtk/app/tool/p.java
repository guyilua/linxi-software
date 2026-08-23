package com.rtk.app.tool;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.rtk.app.R;
import com.rtk.app.main.DownLoadActivity;
import java.util.HashMap;
import java.util.Map;

/* compiled from: NotificationTool.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class p {

    /* renamed from: c, reason: collision with root package name */
    private static p f329c = null;
    private static NotificationManager d = null;
    private static NotificationChannel e = null;
    private static String f = "下载通知";
    private static String g = "downloadChannelId";
    private Map<Integer, NotificationCompat.Builder> a = new HashMap();
    private Map<Integer, Notification.Builder> b = new HashMap();

    public static p a(Context context) {
        if (f329c == null || d == null) {
            f329c = new p();
            d = (NotificationManager) context.getSystemService("notification");
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel(g, f, 2);
                e = notificationChannel;
                d.createNotificationChannel(notificationChannel);
            }
        }
        return f329c;
    }

    public void b(Activity activity, ApkInfo apkInfo, String str, int i, int i2) {
        PendingIntent activity2 = PendingIntent.getActivity(activity, 0, new Intent(activity, (Class<?>) DownLoadActivity.class), 134217728);
        if (Build.VERSION.SDK_INT >= 26) {
            d.notify(i2, this.b.get(Integer.valueOf(i2)).setSmallIcon(R.mipmap.icon_logo).setContentTitle(apkInfo.getAppName()).setContentText(str).setContentIntent(activity2).setProgress(100, i, false).build());
        } else {
            NotificationCompat.Builder builder = this.a.get(Integer.valueOf(i2));
            builder.setSmallIcon(R.mipmap.icon_logo).setContentTitle(apkInfo.getAppName()).setContentText(str).setContentIntent(activity2).setProgress(100, i, false);
            d.notify(i2, builder.build());
        }
    }

    public void c(Activity activity, ApkInfo apkInfo) {
        Intent intent = new Intent(activity, (Class<?>) DownLoadActivity.class);
        Bundle bundle = new Bundle();
        c0.u("NotificationTool", "我被执行了" + apkInfo.getGameId());
        bundle.putInt("openPage", 2);
        bundle.putInt("gameId", apkInfo.getGameId());
        intent.putExtras(bundle);
        PendingIntent activity2 = PendingIntent.getActivity(activity, apkInfo.getGameId(), intent, 134217728);
        if (Build.VERSION.SDK_INT >= 26) {
            d.notify(apkInfo.getGameId(), this.b.get(Integer.valueOf(apkInfo.getGameId())).setSmallIcon(R.mipmap.icon_logo).setContentTitle(apkInfo.getAppName()).setContentText("下载完成").setProgress(100, 100, false).setContentIntent(activity2).build());
        } else {
            NotificationCompat.Builder builder = this.a.get(Integer.valueOf(apkInfo.getGameId()));
            builder.setSmallIcon(R.mipmap.icon_logo).setContentTitle(apkInfo.getAppName()).setProgress(100, 100, false).setContentIntent(activity2).setContentText("下载完成");
            d.notify(apkInfo.getGameId(), builder.build());
        }
    }

    public void d(int i) {
        d.cancel(i);
    }

    public void e(Activity activity, ApkInfo apkInfo, int i) {
        PendingIntent activity2 = PendingIntent.getActivity(activity, 0, new Intent(activity, (Class<?>) DownLoadActivity.class), 134217728);
        if (Build.VERSION.SDK_INT >= 26) {
            Notification.Builder when = new Notification.Builder(activity, i + "").setSmallIcon(R.mipmap.icon_logo).setContentTitle(apkInfo.getAppName()).setContentText("下载中").setContentIntent(activity2).setProgress(100, 0, false).setWhen(System.currentTimeMillis());
            when.setChannelId(g);
            this.b.put(Integer.valueOf(i), when);
            d.notify(i, when.build());
            return;
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(activity);
        builder.setSmallIcon(R.mipmap.icon_logo).setContentTitle(apkInfo.getAppName()).setContentIntent(activity2).setContentText("下载中").setProgress(100, 0, false).setWhen(System.currentTimeMillis());
        this.a.put(Integer.valueOf(i), builder);
        d.notify(i, builder.build());
    }
}
