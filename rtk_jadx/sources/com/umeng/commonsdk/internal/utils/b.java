package com.umeng.commonsdk.internal.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import org.json.JSONObject;

/* compiled from: BatteryUtils.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    private static final String a = "BatteryUtils";
    private static boolean b = false;

    /* renamed from: c, reason: collision with root package name */
    private static Context f1092c;
    private BroadcastReceiver d;

    /* compiled from: BatteryUtils.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class a {
        private static final b a = new b();

        private a() {
        }
    }

    public static b a(Context context) {
        if (f1092c == null && context != null) {
            f1092c = context.getApplicationContext();
        }
        return a.a;
    }

    public synchronized void b() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            f1092c.registerReceiver(this.d, intentFilter);
            b = true;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f1092c, th);
        }
    }

    public synchronized void c() {
        try {
            f1092c.unregisterReceiver(this.d);
            b = false;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f1092c, th);
        }
    }

    private b() {
        this.d = new BroadcastReceiver() { // from class: com.umeng.commonsdk.internal.utils.b.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("le", intent.getIntExtra("level", 0));
                        } catch (Exception unused) {
                        }
                        try {
                            jSONObject.put("vol", intent.getIntExtra("voltage", 0));
                        } catch (Exception unused2) {
                        }
                        try {
                            jSONObject.put("temp", intent.getIntExtra("temperature", 0));
                            jSONObject.put("ts", System.currentTimeMillis());
                        } catch (Exception unused3) {
                        }
                        int intExtra = intent.getIntExtra("status", 0);
                        int i = -1;
                        int i2 = 2;
                        if (intExtra != 1) {
                            if (intExtra == 2) {
                                i = 1;
                            } else if (intExtra == 4) {
                                i = 0;
                            } else if (intExtra == 5) {
                                i = 2;
                            }
                        }
                        try {
                            jSONObject.put("st", i);
                        } catch (Exception unused4) {
                        }
                        int intExtra2 = intent.getIntExtra("plugged", 0);
                        if (intExtra2 == 1) {
                            i2 = 1;
                        } else if (intExtra2 != 2) {
                            i2 = 0;
                        }
                        try {
                            jSONObject.put("ct", i2);
                            jSONObject.put("ts", System.currentTimeMillis());
                        } catch (Exception unused5) {
                        }
                        ULog.i(b.a, jSONObject.toString());
                        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.h, com.umeng.commonsdk.internal.b.a(b.f1092c).a(), jSONObject.toString());
                        b.this.c();
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(b.f1092c, th);
                }
            }
        };
    }

    public synchronized boolean a() {
        return b;
    }
}
