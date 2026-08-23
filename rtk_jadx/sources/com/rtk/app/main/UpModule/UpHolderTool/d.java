package com.rtk.app.main.UpModule.UpHolderTool;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.rtk.app.R;
import com.rtk.app.main.DownLoadActivity;
import com.rtk.app.main.UpModule.UpLoadPoolControlActivity;
import com.rtk.app.tool.g.g;
import java.util.HashMap;
import java.util.Map;

/* compiled from: UpZipNotificationTool.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    private static d f222c = null;
    private static NotificationManager d = null;
    private static NotificationChannel e = null;
    private static String f = "上传通知";
    private static String g = "upChannelId";
    private Map<Integer, NotificationCompat.Builder> a = new HashMap();
    private Map<Integer, Notification.Builder> b = new HashMap();

    public static d a(Context context) {
        if (f222c == null || d == null) {
            f222c = new d();
            d = (NotificationManager) context.getSystemService("notification");
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel(g, f, 2);
                e = notificationChannel;
                d.createNotificationChannel(notificationChannel);
            }
        }
        return f222c;
    }

    public void b(Activity activity, g gVar, String str, int i) {
        if (gVar == null) {
            return;
        }
        int E = gVar.E();
        if (this.b.get(Integer.valueOf(E)) == null && this.a.get(Integer.valueOf(E)) == null) {
            Intent intent = new Intent(activity, (Class<?>) DownLoadActivity.class);
            if (Build.VERSION.SDK_INT >= 26) {
                Notification.Builder when = new Notification.Builder(activity, E + "").setSmallIcon(R.mipmap.icon_logo).setContentTitle(gVar.c()).setContentText("上传中").setContentIntent(PendingIntent.getActivity(activity, 0, intent, 134217728)).setProgress(100, 0, false).setWhen(System.currentTimeMillis());
                when.setChannelId(g);
                this.b.put(Integer.valueOf(E), when);
                d.notify(E, when.build());
                return;
            }
            NotificationCompat.Builder builder = new NotificationCompat.Builder(activity);
            builder.setSmallIcon(R.mipmap.icon_logo).setContentTitle(gVar.c()).setContentIntent(PendingIntent.getActivity(activity, 0, intent, 134217728)).setContentText("上传中").setProgress(100, 0, false).setWhen(System.currentTimeMillis());
            this.a.put(Integer.valueOf(E), builder);
            d.notify(E, builder.build());
            return;
        }
        Intent intent2 = new Intent(activity, (Class<?>) UpLoadPoolControlActivity.class);
        if (Build.VERSION.SDK_INT >= 26) {
            d.notify(E, this.b.get(Integer.valueOf(E)).setSmallIcon(R.mipmap.icon_logo).setContentTitle(gVar.c()).setContentText(str).setContentIntent(PendingIntent.getActivity(activity, 0, intent2, 134217728)).setProgress(100, i, false).build());
        } else {
            NotificationCompat.Builder builder2 = this.a.get(Integer.valueOf(E));
            builder2.setSmallIcon(R.mipmap.icon_logo).setContentTitle(gVar.c()).setContentText(str).setContentIntent(PendingIntent.getActivity(activity, 0, intent2, 134217728)).setProgress(100, i, false);
            d.notify(E, builder2.build());
        }
    }

    public void c(g gVar) {
        try {
            d.cancel(gVar.E());
        } catch (Exception unused) {
        }
    }
}
