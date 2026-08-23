package com.sigmob.sdk.mraid2;

import com.umeng.analytics.pro.ak;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class n {
    private final String a;
    private int b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f592c;
    private c d;
    private Timer e = null;
    private TimerTask f = null;

    public n(c cVar, JSONObject jSONObject) {
        this.d = cVar;
        this.b = jSONObject.optInt(ak.aT);
        this.f592c = jSONObject.optBoolean("repeats");
        this.a = jSONObject.optString("uniqueId");
    }

    private void d() {
        this.e = new Timer();
        this.f = new TimerTask() { // from class: com.sigmob.sdk.mraid2.n.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (n.this.d != null) {
                    n.this.d.a().post(new Runnable() { // from class: com.sigmob.sdk.mraid2.n.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            n.this.d.e(n.this.a);
                        }
                    });
                }
            }
        };
    }

    public void a() {
        c();
    }

    public void b() {
        try {
            c();
            d();
            int i = this.b;
            if (i > 0) {
                if (this.f592c) {
                    this.e.schedule(this.f, i, i);
                } else {
                    this.e.schedule(this.f, i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c() {
        TimerTask timerTask = this.f;
        if (timerTask != null) {
            timerTask.cancel();
            this.f = null;
        }
        Timer timer = this.e;
        if (timer != null) {
            timer.cancel();
            this.e.purge();
            this.e = null;
        }
    }
}
