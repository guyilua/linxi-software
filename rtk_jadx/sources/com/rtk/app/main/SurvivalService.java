package com.rtk.app.main;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.bean.SurvivalPathBean;
import com.rtk.app.main.dialogPack.DialogForService;
import com.rtk.app.tool.o.h;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SurvivalService extends Service implements h.j {
    private Context a;

    /* renamed from: c, reason: collision with root package name */
    private DialogForService f212c;
    private NotificationManager f;
    private int b = 0;
    String d = "channelId";
    String e = "软天空检查服务器状态";

    private Notification b() {
        Notification.Builder contentText = new Notification.Builder(this).setSmallIcon(R.mipmap.icon_logo).setContentTitle("软天空正在启动").setContentText("正在启动软天空...");
        if (Build.VERSION.SDK_INT >= 26) {
            contentText.setChannelId(this.d);
        }
        return contentText.build();
    }

    private void c() {
        this.f = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            this.f.createNotificationChannel(new NotificationChannel(this.d, this.e, 2));
        }
        startForeground(1, b());
    }

    public void a(int... iArr) {
        int i = iArr[0];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            com.rtk.app.tool.o.h.l(this.a, this, 2, com.rtk.app.tool.o.h.h(new String[0]).a(com.rtk.app.tool.y.h + com.rtk.app.tool.y.u(this.a) + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.a, new String[0])))));
            return;
        }
        String str = com.rtk.app.tool.y.g + com.rtk.app.tool.y.u(this.a) + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.a, new String[0])));
        int i2 = 0;
        while (true) {
            String[] strArr = com.rtk.app.tool.y.f;
            if (i2 >= strArr.length) {
                return;
            }
            String b = com.rtk.app.tool.q.b(com.rtk.app.tool.q.a(strArr[i2]));
            com.rtk.app.tool.o.h.l(this.a, this, iArr[0], com.rtk.app.tool.o.h.h(b).a(str));
            com.rtk.app.tool.c0.u("SurvivalService", "请求地址" + b + str);
            i2++;
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public synchronized void d(String str, int i) {
        try {
            if (i == 1) {
                com.rtk.app.tool.c0.u("SurvivalService", "服务器返回地址" + str);
                SurvivalPathBean survivalPathBean = (SurvivalPathBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, SurvivalPathBean.class);
                com.rtk.app.tool.y.d = survivalPathBean.getData().getData();
                com.rtk.app.tool.y.e = survivalPathBean.getData().getData2();
                com.rtk.app.tool.y.i = survivalPathBean.getData().getUpload();
                com.rtk.app.tool.y.j = survivalPathBean.getData().getVideoUpload();
                com.rtk.app.tool.v.h(this.a, "ServicePath", com.rtk.app.tool.y.d);
                com.rtk.app.tool.v.h(this.a, "ServicePathNew", com.rtk.app.tool.y.e);
                com.rtk.app.tool.v.h(this.a, "ServiceUpPath", com.rtk.app.tool.y.i);
                com.rtk.app.tool.v.h(this.a, "ServiceUpVideoPath", com.rtk.app.tool.y.j);
                com.rtk.app.tool.o.h.t(com.rtk.app.tool.y.d);
                if (this.b == 1) {
                    this.f212c.show();
                }
                this.b++;
                stopSelf();
            } else if (i == 2) {
                com.rtk.app.tool.c0.u("SurvivalService", "我链接到了软天空");
                stopSelf();
            }
        } catch (Exception e) {
            com.rtk.app.tool.c0.u("SurvivalService", "服务器返回地址" + e.toString());
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (i2 == 1) {
            com.rtk.app.tool.c0.u("SurvivalService", "服务器返回地址失败" + str);
            stopSelf();
            return;
        }
        if (i2 != 2) {
            return;
        }
        com.rtk.app.tool.c0.u("SurvivalService", "链接软天空失败" + str);
        try {
            if (com.rtk.app.tool.t.t1(this.a)) {
                com.rtk.app.tool.v.h(this.a, "ServicePath", "");
                a(1);
                this.b++;
                this.f212c = new DialogForService(MyApplication.b());
            }
        } catch (Exception e) {
            com.rtk.app.tool.c0.u("SurvivalService", "链接软天空失败异常" + e.toString());
        }
        stopSelf();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.a = this;
        com.rtk.app.tool.c0.u("SurvivalService", "服务地址");
        c();
        a(2);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        stopSelf();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
