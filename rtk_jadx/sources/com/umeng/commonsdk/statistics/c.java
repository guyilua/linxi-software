package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.aw;
import com.umeng.analytics.pro.bl;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.internal.d;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.statistics.proto.Response;
import java.io.File;

/* compiled from: NetWorkManager.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {
    private static final int b = 1;

    /* renamed from: c, reason: collision with root package name */
    private static final int f1102c = 2;
    private static final int d = 3;
    private static final String o = "thtstart";
    private static final String p = "gkvc";
    private static final String q = "ekvc";
    String a;
    private com.umeng.commonsdk.statistics.internal.c f;
    private ImprintHandler g;
    private e h;
    private ImprintHandler.a i;
    private Defcon k;
    private long l;
    private int m;
    private int n;
    private Context r;
    private final int e = 1;
    private ABTest j = null;

    public c(Context context) {
        this.h = null;
        this.i = null;
        this.k = null;
        this.l = 0L;
        this.m = 0;
        this.n = 0;
        this.a = null;
        this.r = context;
        this.i = ImprintHandler.getImprintService(context).c();
        this.k = Defcon.getService(this.r);
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.r);
        this.l = sharedPreferences.getLong(o, 0L);
        this.m = sharedPreferences.getInt(p, 0);
        this.n = sharedPreferences.getInt(q, 0);
        this.a = UMEnvelopeBuild.imprintProperty(this.r, "track_list", null);
        ImprintHandler imprintService = ImprintHandler.getImprintService(this.r);
        this.g = imprintService;
        imprintService.a(new d() { // from class: com.umeng.commonsdk.statistics.c.1
            @Override // com.umeng.commonsdk.statistics.internal.d
            public void onImprintChanged(ImprintHandler.a aVar) {
                c.this.k.onImprintChanged(aVar);
                c cVar = c.this;
                cVar.a = UMEnvelopeBuild.imprintProperty(cVar.r, "track_list", null);
            }
        });
        if (!UMConfigure.needSendZcfgEnv(this.r)) {
            this.h = e.a(this.r);
        }
        com.umeng.commonsdk.statistics.internal.c cVar = new com.umeng.commonsdk.statistics.internal.c(this.r);
        this.f = cVar;
        cVar.a(StatTracer.getInstance(this.r));
    }

    public boolean a(File file) {
        String str;
        if (file == null) {
            return false;
        }
        try {
            byte[] byteArray = UMFrUtils.toByteArray(file.getPath());
            if (byteArray == null) {
                return false;
            }
            String name = file.getName();
            if (TextUtils.isEmpty(name)) {
                return false;
            }
            com.umeng.commonsdk.statistics.internal.a a = com.umeng.commonsdk.statistics.internal.a.a(this.r);
            a.d(name);
            boolean a2 = a.a(name);
            boolean b2 = a.b(name);
            boolean c2 = a.c(name);
            String d2 = com.umeng.commonsdk.stateless.d.d(name);
            if (!TextUtils.isEmpty(d2)) {
                str = com.umeng.commonsdk.stateless.d.c(d2);
            } else if (c2) {
                str = UMServerURL.ZCFG_PATH;
            } else {
                str = UMServerURL.PATH_ANALYTICS;
            }
            byte[] a3 = this.f.a(byteArray, a2, c2, str);
            int a4 = a3 == null ? 1 : a(a3);
            if (UMConfigure.isDebugLog()) {
                if (c2 && a4 == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Zero req: succeed.");
                } else if (b2 && a4 == 2) {
                    MLog.d("本次启动数据: 发送成功!");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Send instant data: succeed.");
                } else if (a2 && a4 == 2) {
                    MLog.d("普通统计数据: 发送成功!");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Send analytics data: succeed.");
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Inner req: succeed.");
                }
            }
            if (a4 == 2) {
                e eVar = this.h;
                if (eVar != null) {
                    eVar.e();
                }
                StatTracer.getInstance(this.r).saveSate();
            } else if (a4 == 3) {
                StatTracer.getInstance(this.r).saveSate();
                if (c2) {
                    FieldManager.a().a(this.r);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 零号报文应答内容报错!!! ，特殊处理!，继续正常流程。");
                    Context context = this.r;
                    UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.s, com.umeng.commonsdk.internal.b.a(context).a(), null);
                    return true;
                }
            }
            return a4 == 2;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.r, th);
            return false;
        }
    }

    private int a(byte[] bArr) {
        Response response = new Response();
        try {
            new aw(new bl.a()).a(response, bArr);
            if (response.resp_code == 1) {
                this.g.b(response.getImprint());
                this.g.d();
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.r, th);
        }
        return response.resp_code == 1 ? 2 : 3;
    }
}
