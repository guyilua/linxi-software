package com.rtk.app.tool.o;

import android.app.Activity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.rtk.app.bean.ResponseDataBean;
import com.rtk.app.bean.UpApkBean;
import com.rtk.app.bean.UpCheckApkExitBean;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.UpModule.UpLoadPoolControlActivity;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/* compiled from: UpApkNetListener.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class k {
    private static k e;
    private static OkHttpClient f;
    private static OkHttpClient.Builder g;
    private static HttpLoggingInterceptor h;
    private static Map<String, WeakReference<l>> i = new HashMap();
    private static Gson j = new GsonBuilder().enableComplexMapKeySerialization().create();
    public static int k = -1;
    private int a = 0;
    private int b = 15;

    /* renamed from: c, reason: collision with root package name */
    private List<String> f321c = new ArrayList();
    private Map<String, c> d = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UpApkNetListener.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements HttpLoggingInterceptor.Logger {
        a(k kVar) {
        }

        public void log(String str) {
            c0.u("UP_TAG UpApkNetListener", "当前响应码" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UpApkNetListener.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements h.j {
        final /* synthetic */ com.rtk.app.tool.g.g a;
        final /* synthetic */ h.j b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f322c;
        final /* synthetic */ s d;
        final /* synthetic */ int e;

        b(com.rtk.app.tool.g.g gVar, h.j jVar, String str, s sVar, int i) {
            this.a = gVar;
            this.b = jVar;
            this.f322c = str;
            this.d = sVar;
            this.e = i;
        }

        @Override // com.rtk.app.tool.o.h.j
        public void d(String str, int i) {
            UpCheckApkExitBean upCheckApkExitBean = (UpCheckApkExitBean) k.j.fromJson(str, UpCheckApkExitBean.class);
            if (upCheckApkExitBean.getCode() != 0) {
                return;
            }
            c0.u("UP_TAG UpApkNetListener", "服务器存在该文件");
            int parseInt = Integer.parseInt(this.a.q()) / 2097152;
            this.b.d(k.j.toJson(upCheckApkExitBean.getData(), UpApkBean.class), i);
            long j = parseInt;
            com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().c(j, j, this.a.E());
            com.rtk.app.tool.g.f.e(MyApplication.b()).w(this.f322c, parseInt + 1, parseInt);
        }

        @Override // com.rtk.app.tool.o.h.j
        public void g(int i, String str, int i2) {
            if (i != 200999) {
                c0.s("UP_TAG UpApkNetListener", "检查文件错误" + str);
                com.rtk.app.tool.f.a(MyApplication.b(), str, f.a.f);
                int i3 = this.e;
                if (i3 <= 2) {
                    k.this.h(this.b, i2, this.f322c, i3 + 1, this.d);
                    return;
                }
                com.rtk.app.tool.f.a(MyApplication.b(), "上传失败" + str, f.a.f);
                this.b.g(k.k, str, i2);
                return;
            }
            c0.u("UP_TAG UpApkNetListener", "服务器不存在该文件" + str);
            this.d.a(new String[0]);
        }
    }

    /* compiled from: UpApkNetListener.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class c implements Callback {
        private String a;
        private int b;

        /* renamed from: c, reason: collision with root package name */
        private int f323c;
        private int d;
        private boolean e;
        private h.j f;
        private com.rtk.app.tool.g.g g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: UpApkNetListener.java */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public class a extends TimerTask {
            final /* synthetic */ int a;

            a(int i) {
                this.a = i;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!k.this.f321c.contains(c.this.a)) {
                    h.j m = com.rtk.app.main.UpModule.UpControlPack.b.i().o(c.this.a) ? com.rtk.app.main.UpModule.UpControlPack.b.m(c.this.a) : c.this.f;
                    k.i().r(m, y.i + y.k, c.this.f323c, this.a, c.this.a, true);
                    return;
                }
                cancel();
                c0.t("UP_TAG UpApkNetListener", "upListPool contains the md5:" + c.this.a);
            }
        }

        public c() {
        }

        private void d(String str, int i) {
            h.j jVar;
            if (com.rtk.app.main.UpModule.UpControlPack.b.i().o(this.a)) {
                jVar = com.rtk.app.main.UpModule.UpControlPack.b.m(this.a);
            } else {
                jVar = this.f;
            }
            h.j jVar2 = jVar;
            if (str.contains("SocketTimeoutException")) {
                c0.s("UP_TAG UpApkNetListener", "upApkFile loadFailed 上传响应超时");
                j(i);
                return;
            }
            if (!str.contains("SocketException") && !str.contains("UnknownHostException")) {
                c0.u("UP_TAG UpApkNetListener", "upApkFile loadFailed 上传未知错误 :" + str);
                jVar2.g(-2, "上传apk出错:" + str, this.f323c);
                k.this.o(this.a);
                if (this.g.m() == 0) {
                    e(1, 100);
                    com.rtk.app.main.UpModule.UpHolderTool.b.a(MyApplication.b()).b((Activity) MyApplication.b(), this.g, "", 1);
                    k.i().r(jVar2, y.i + y.k, this.f323c, i, this.a, true);
                    return;
                }
                com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().d(this.g.E());
                com.rtk.app.main.UpModule.UpHolderTool.b.a(MyApplication.b()).c(this.g.E());
                return;
            }
            c0.s("UP_TAG UpApkNetListener", "upApkFile loadFailed SocketException or UnknownHostException");
            if (this.e && k.this.a < 300) {
                k.this.o(this.a);
                k.f(k.this);
                if (k.this.a > 1) {
                    com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().e(this.g.E());
                }
                f(i);
                return;
            }
            m();
        }

        private void e(int i, int i2) {
            c0.u("UP_TAG UpApkNetListener", "upApkFile onResponse stop");
            this.g.H(i);
            this.g.F(i2);
            com.rtk.app.main.UpModule.UpControlPack.b.i().s(this.g);
            com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().d(this.g.E());
            com.rtk.app.tool.g.f.e(MyApplication.b()).w(this.a, i, i2);
        }

        private void f(int i) {
            c0.u("UP_TAG UpApkNetListener", "reUpApkLoad index:" + i);
            k.this.o(this.a);
            new Timer().schedule(new a(i), 3000L);
        }

        private void h(ResponseDataBean responseDataBean) {
            c0.t("UP_TAG UpApkNetListener", "responseFail in");
            com.rtk.app.tool.g.f.e(MyApplication.b()).w(this.a, 1, 100);
            com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().c(100L, 1L, this.g.E());
            if (!com.rtk.app.main.UpModule.UpControlPack.b.i().o(this.a)) {
                if (responseDataBean == null) {
                    c0.s("UP_TAG UpApkNetListener", "responseFail responseDataBean is null");
                    return;
                }
                c0.u("UP_TAG UpApkNetListener", "upApkFile onResponse 上传失败我在这里3");
                h.f(this.f, responseDataBean.getCode(), responseDataBean.getMsg(), this.f323c);
                com.rtk.app.tool.g.f.e(MyApplication.b()).w(this.a, 1, this.d);
                com.rtk.app.main.UpModule.UpHolderTool.b.a(MyApplication.b()).c(this.g.E());
                c0.u("UP_TAG UpApkNetListener", "upApkFile onResponse 上传失败我在这里4");
                return;
            }
            c0.u("UP_TAG UpApkNetListener", "responseFail try again");
            com.rtk.app.tool.g.f.e(MyApplication.b()).v("uid" + y.K() + "_" + System.currentTimeMillis(), this.a);
            k.i().r(com.rtk.app.main.UpModule.UpControlPack.b.m(this.a), y.i + y.k, this.f323c, 1, this.a, true);
        }

        private void i(JsonSyntaxException jsonSyntaxException, String str) {
            c0.s("UP_TAG UpApkNetListener", "upApkFile onResponse responseJsonException" + jsonSyntaxException);
            com.rtk.app.tool.g.f.e(MyApplication.b()).w(this.a, 1, 100);
            if (com.rtk.app.main.UpModule.UpControlPack.b.i().o(this.a)) {
                k.i().r(com.rtk.app.main.UpModule.UpControlPack.b.m(this.a), y.i + y.k, this.f323c, 1, this.a, true);
                com.rtk.app.main.UpModule.UpHolderTool.b.a(MyApplication.b()).c(this.g.E());
                return;
            }
            h.e(this.f, this.f323c, jsonSyntaxException, str);
            com.rtk.app.main.UpModule.UpHolderTool.b.a(MyApplication.b()).c(this.g.E());
            k.i().r(this.f, y.i + y.k, this.f323c, 1, this.a, true);
        }

        private void j(int i) {
            h.j jVar;
            c0.u("UP_TAG UpApkNetListener", "upApkConnectTimeOut in");
            if (com.rtk.app.main.UpModule.UpControlPack.b.i().o(this.a)) {
                jVar = com.rtk.app.main.UpModule.UpControlPack.b.m(this.a);
            } else {
                jVar = this.f;
            }
            h.j jVar2 = jVar;
            if (k.this.a < 300) {
                k.this.o(this.a);
                k.f(k.this);
                c0.s("UP_TAG UpApkNetListener", "upApkConnectTimeOut reUpload");
                k.i().r(jVar2, y.i + y.k, this.f323c, i, this.a, true);
                return;
            }
            k.this.o(this.a);
            c0.s("UP_TAG UpApkNetListener", "upApkConnectTimeOut four failures then stop");
            jVar2.g(-2, "上传apk出错:", this.f323c);
            com.rtk.app.main.UpModule.UpHolderTool.b.a(MyApplication.b()).c(this.g.E());
            com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().d(this.g.E());
        }

        private void k(String str) {
            com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().c(this.d, this.b, this.g.E());
            k.this.o(this.a);
            c0.u("UP_TAG UpApkNetListener", "upApkFileResponseLastIndex 收到最后一片服务器返回消息" + str);
            try {
                ResponseDataBean responseDataBean = (ResponseDataBean) k.j.fromJson(str, ResponseDataBean.class);
                if (str != null && responseDataBean != null && responseDataBean.getCode() == 0) {
                    n(str);
                } else {
                    h(responseDataBean);
                }
            } catch (JsonSyntaxException e) {
                i(e, str);
            }
        }

        private void l() {
            h.j jVar;
            c0.u("UP_TAG UpApkNetListener", "upApkFileSucceedForIndex index:" + this.b);
            com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().c((long) this.d, (long) this.b, this.g.E());
            if (com.rtk.app.main.UpModule.UpControlPack.b.i().o(this.a)) {
                jVar = com.rtk.app.main.UpModule.UpControlPack.b.m(this.a);
            } else {
                jVar = this.f;
            }
            com.rtk.app.tool.g.f.e(MyApplication.b()).w(this.a, this.b + 1, this.d);
            k i = k.i();
            i.r(jVar, y.i + y.k, this.f323c, this.b + 1, this.a, true);
        }

        private void m() {
            c0.s("UP_TAG UpApkNetListener", "upApkTimeOut apkName:" + this.g.c());
            this.f.g(-2, "网络链接问题:", this.f323c);
            k.this.o(this.a);
            com.rtk.app.main.UpModule.UpHolderTool.b.a(MyApplication.b()).c(this.g.E());
            com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().d(this.g.E());
        }

        private void n(String str) {
            c0.u("UP_TAG UpApkNetListener", "upApkFile onResponse 上传结束，准备清空数据");
            this.g.K(2);
            if (com.rtk.app.main.UpModule.UpControlPack.b.i().o(this.a)) {
                c0.u("UP_TAG UpApkNetListener", "upApkFile onResponse 上传结束，后台上传");
                com.rtk.app.main.UpModule.UpControlPack.b.m(this.a).d(str, this.f323c);
                com.rtk.app.main.UpModule.UpHolderTool.b.a(MyApplication.b()).c(this.g.E());
                if (MyApplication.b() instanceof UpLoadPoolControlActivity) {
                    ((UpLoadPoolControlActivity) MyApplication.b()).M();
                }
                com.rtk.app.main.UpModule.UpControlPack.b.i().p(this.a);
                com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().f(this.g.E());
                com.rtk.app.main.UpModule.UpControlPack.b.i().r();
                return;
            }
            c0.u("UP_TAG UpApkNetListener", "upApkFile onResponse 前台上传");
            this.f.d(str, this.f323c);
            com.rtk.app.main.UpModule.UpHolderTool.b.a(MyApplication.b()).c(this.g.E());
            com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().f(this.g.E());
            com.rtk.app.tool.g.f e = com.rtk.app.tool.g.f.e(MyApplication.b());
            String str2 = this.a;
            int i = this.d;
            e.w(str2, i, i);
        }

        public void g(String str, int i, int i2, int i3, boolean z, h.j jVar) {
            this.a = str;
            this.b = i;
            this.f323c = i2;
            this.d = i3;
            this.e = z;
            this.f = jVar;
            this.g = com.rtk.app.tool.g.f.e(MyApplication.b()).i(this.a);
        }

        public void onFailure(Call call, IOException iOException) {
            c0.t("UP_TAG UpApkNetListener", "upApkFile onFailure " + iOException.toString());
            k.this.o(this.a);
            com.rtk.app.tool.g.g i = com.rtk.app.tool.g.f.e(MyApplication.b()).i(this.a);
            this.g = i;
            if (i == null) {
                c0.s("UP_TAG UpApkNetListener", "upApkFile onFailure LoadApkInfo is null" + this.a);
                return;
            }
            int i2 = this.b;
            if (i.u() == 1 && this.d > this.b) {
                c0.t("UP_TAG UpApkNetListener", "upApkFile onFailure上传失败 暂停");
                k.this.o(this.a);
                e(this.b, this.d);
                return;
            }
            if (com.rtk.app.main.UpModule.UpControlPack.b.i().o(this.a)) {
                c0.t("UP_TAG UpApkNetListener", "upApkFile onFailure upPoll is contain the md5:" + this.a);
                if (k.this.a >= 2) {
                    com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().e(this.g.E());
                }
                k.f(k.this);
                f(i2);
                return;
            }
            c0.u("UP_TAG UpApkNetListener", "upApkFile onFailure 上传Apk文件 onFailure = " + iOException);
            d(iOException.toString(), i2);
        }

        public void onResponse(Call call, Response response) {
            int code = response.code();
            c0.u("UP_TAG UpApkNetListener", "upApkFile onResponse index:" + this.b);
            k.this.a = 0;
            int i = this.b + 1;
            com.rtk.app.tool.g.g i2 = com.rtk.app.tool.g.f.e(MyApplication.b()).i(this.a);
            this.g = i2;
            if (i2 == null) {
                c0.s("UP_TAG UpApkNetListener", "onResponse mUpLoadApkInfo is null");
                return;
            }
            com.rtk.app.main.UpModule.UpControlPack.b.i().s(this.g);
            com.rtk.app.main.UpModule.UpHolderTool.b.a(MyApplication.b()).b((Activity) MyApplication.b(), this.g, ((this.b * 100) / this.d) + "%", (this.b * 100) / this.d);
            if (this.g.u() == 1 && this.d > this.b) {
                k.this.o(this.a);
                com.rtk.app.main.UpModule.UpHolderTool.b.a(MyApplication.b()).c(this.g.E());
                c0.u("UP_TAG UpApkNetListener", "upApkFile onResponse stop code " + code);
                if (code != 200) {
                    e(this.b, this.d);
                    return;
                }
                com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().c(this.d, this.b, this.g.E());
                com.rtk.app.tool.g.f.e(MyApplication.b()).w(this.a, this.b + 1, this.d);
                com.rtk.app.main.UpModule.UpControlPack.b.i().r();
                com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().d(this.g.E());
                return;
            }
            if (code != 200) {
                f(i - 1);
            } else if (i <= this.d) {
                l();
            } else {
                try {
                    k(response.body().string());
                } catch (IOException e) {
                    c0.u("UP_TAG UpApkNetListener", "IO err" + e);
                    e.printStackTrace();
                }
            }
            call.cancel();
        }
    }

    static /* synthetic */ int f(k kVar) {
        int i2 = kVar.a;
        kVar.a = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(h.j jVar, int i2, String str, int i3, s sVar) {
        c0.u("UP_TAG UpApkNetListener", "checkUpExit in");
        com.rtk.app.tool.g.g i4 = com.rtk.app.tool.g.f.e(MyApplication.b()).i(str);
        HashMap<String, String> l = y.l();
        l.put("packageName", i4.t().getPackageName());
        l.put("apkmd5", str);
        l.put("sourceByte", i4.q());
        l.put("key", t.L(l));
        h.l(MyApplication.b(), new b(i4, jVar, str, sVar, i3), i2, h.h(y.e).a(y.w("up/sec-trans/check", l)));
    }

    public static synchronized k i() {
        synchronized (k.class) {
            if (e == null) {
                e = new k();
            }
            synchronized (k.class) {
                if (e == null) {
                    e = new k();
                }
            }
            return e;
        }
        return e;
    }

    private synchronized OkHttpClient j() {
        if (f == null) {
            g = new OkHttpClient.Builder();
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new a(this));
            h = httpLoggingInterceptor;
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        OkHttpClient okHttpClient = f;
        if (okHttpClient != null && okHttpClient.readTimeoutMillis() / 1000 == this.b) {
            return f;
        }
        OkHttpClient.Builder builder = g;
        long j2 = this.b;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient build = builder.connectTimeout(j2, timeUnit).writeTimeout(this.b, timeUnit).readTimeout(this.b, timeUnit).addInterceptor(h).build();
        f = build;
        return build;
    }

    private l k(String str, m mVar, int i2) {
        com.rtk.app.tool.g.g k2;
        l lVar;
        WeakReference<l> weakReference = i.get(str);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        if (mVar == m.APK) {
            k2 = com.rtk.app.tool.g.f.e(MyApplication.b()).i(str);
        } else {
            k2 = com.rtk.app.tool.g.f.e(MyApplication.b()).k(str);
        }
        l lVar2 = null;
        if (k2 == null) {
            c0.s("UP_TAG UpApkNetListener", "getUpFileBeanForApk() upLoadApkInfo is null");
            return null;
        }
        String o = k2.o();
        if (o.isEmpty()) {
            c0.s("UP_TAG UpApkNetListener", "getUpFileBeanForApk() filePath is null");
            return null;
        }
        File file = new File(o);
        try {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                fileInputStream.skip((i2 - 1) * 2097152);
                lVar = new l(str, o, fileInputStream, file.length());
            } catch (IOException e2) {
                e = e2;
            }
            try {
                i.put(str, new WeakReference<>(lVar));
                return lVar;
            } catch (IOException e3) {
                e = e3;
                lVar2 = lVar;
                c0.s("UP_TAG UpApkNetListener", "upFileApk() IOException fileInputStream is null");
                e.printStackTrace();
                return lVar2;
            }
        } catch (FileNotFoundException unused) {
            c0.s("UP_TAG UpApkNetListener", "upFileApk() fileInputStream is null");
            return null;
        }
    }

    private byte[] l(int i2, int i3, l lVar) {
        if (i2 < 0) {
            byte[] bArr = new byte[2097152];
            c0.s("UP_TAG UpApkNetListener", "index error == " + i2);
            return bArr;
        }
        if (i2 >= i3) {
            long b2 = (long) (lVar.b() - ((i2 - 1.0d) * 2097152.0d));
            c0.u("UP_TAG UpApkNetListener", "最后一片的尺寸" + b2);
            if (b2 < 0) {
                c0.s("UP_TAG UpApkNetListener", "最后一片尺寸小于0" + b2);
                return new byte[0];
            }
            byte[] bArr2 = new byte[(int) b2];
            long b3 = lVar.b() / BaseConstants.MB_VALUE;
            if (b3 > ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLSX) {
                this.b = 480;
                return bArr2;
            }
            if (b3 > ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) {
                this.b = 480;
                return bArr2;
            }
            if (b3 > 512) {
                this.b = 150;
                return bArr2;
            }
            this.b = 60;
            return bArr2;
        }
        byte[] bArr3 = new byte[2097152];
        this.b = 15;
        return bArr3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(h.j jVar, String str, int i2, int i3, String str2, boolean z, String[] strArr) {
        s(jVar, str, i2, i3, str2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str) {
        this.f321c.remove(str);
        WeakReference<l> weakReference = i.get(str);
        if (weakReference != null && weakReference.get() != null) {
            try {
                weakReference.get().a().close();
            } catch (IOException e2) {
                c0.s("UP_TAG UpApkNetListener", "getFileInputStream close failed IOException");
                e2.printStackTrace();
            }
            i.remove(str);
            p(str);
            return;
        }
        i.remove(str);
    }

    private void q(String str, h.j jVar, int i2) {
        com.rtk.app.tool.f.a(MyApplication.b(), "apk文件已被卸载或删除", f.a.f);
        com.rtk.app.tool.g.g i3 = com.rtk.app.tool.g.f.e(MyApplication.b()).i(str);
        com.rtk.app.tool.g.f.e(MyApplication.b()).n(str);
        com.rtk.app.main.UpModule.UpControlPack.b.i().p(str);
        com.rtk.app.main.UpModule.UpHolderTool.b.a(MyApplication.b()).c(i3.E());
        com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().d(i3.E());
        com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().f(i3.E());
        jVar.g(-1, "文件不存在", i2);
    }

    private void s(h.j jVar, String str, int i2, int i3, String str2, boolean z) {
        c0.r("UP_TAG UpApkNetListener", "upFileApkInner in");
        if (this.f321c.size() > y.r) {
            c0.u("UP_TAG UpApkNetListener", "上传线程满了");
            o(str2);
            return;
        }
        if (!this.f321c.contains(str2)) {
            this.f321c.add(str2);
        }
        l k2 = k(str2, m.APK, i3);
        if (k2 == null) {
            c0.s("UP_TAG UpApkNetListener", "upFileBean is null");
            return;
        }
        int b2 = (int) (k2.b() / 2097152);
        if (k2.b() % 2097152 > 0) {
            b2++;
        }
        int i4 = b2;
        byte[] l = l(i3, i4, k2);
        c0.u("UP_TAG UpApkNetListener", "当前正在上传文件index:" + i3 + " 总数:" + i4);
        try {
            int read = k2.a().read(l);
            if (i3 <= i4 && read != -1) {
                c0.u("UP_TAG UpApkNetListener", "当前等待时间" + this.b + " upBytes.length:" + l.length + " team:" + read);
                if (read < 0) {
                    c0.t("UP_TAG UpApkNetListener", "no read byte");
                    return;
                }
                com.rtk.app.tool.g.g i5 = com.rtk.app.tool.g.f.e(MyApplication.b()).i(str2);
                if (i5 == null) {
                    c0.s("UP_TAG UpApkNetListener", "upFileApk is null" + str2);
                    return;
                }
                RequestBody create = RequestBody.create(MediaType.parse("application/octet-stream"), l, 0, read);
                MultipartBody build = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("file_data", i5.w() + ".apk", create).addFormDataPart("file_upid", y.K()).addFormDataPart("file_total", i4 + "").addFormDataPart("file_name", i5.w() + ".apk").addFormDataPart("file_index", i3 + "").addFormDataPart("file_md5", str2 + "").addFormDataPart("packageName", i5.t().getPackageName()).build();
                c0.u("UP_TAG UpApkNetListener", "upFileApk packageName:" + i5.t().getPackageName());
                Request build2 = new Request.Builder().url(str).post(build).build();
                c cVar = this.d.get(str2);
                if (cVar == null) {
                    cVar = new c();
                    this.d.put(str2, cVar);
                }
                c cVar2 = cVar;
                cVar2.g(str2, i3, i2, i4, z, jVar);
                j().newCall(build2).enqueue(cVar2);
                return;
            }
            c0.s("UP_TAG UpApkNetListener", "当前上传失败,切片已经大于最大值");
            com.rtk.app.tool.g.g i6 = com.rtk.app.tool.g.f.e(MyApplication.b()).i(str2);
            com.rtk.app.tool.g.f.e(MyApplication.b()).n(str2);
            com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().d(i6.E());
            com.rtk.app.tool.g.f.e(MyApplication.b()).w(str2, 1, 100);
        } catch (FileNotFoundException e2) {
            c0.s("UP_TAG UpApkNetListener", "文件上传失败 FileNotFoundException" + e2);
            q(str2, jVar, i2);
        } catch (IOException e3) {
            c0.s("UP_TAG UpApkNetListener", "文件上传失败 IOException" + e3);
            q(str2, jVar, i2);
        }
    }

    public void p(String str) {
        this.d.remove(str);
    }

    public void r(final h.j jVar, final String str, final int i2, final int i3, final String str2, final boolean z) {
        if (i3 > 1) {
            s(jVar, str, i2, i3, str2, z);
        } else {
            h(jVar, i2, str2, 0, new s() { // from class: com.rtk.app.tool.o.f
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    k.this.n(jVar, str, i2, i3, str2, z, strArr);
                }
            });
        }
    }

    public boolean t(String str) {
        return this.f321c.contains(str);
    }

    public int u() {
        return this.f321c.size();
    }
}
