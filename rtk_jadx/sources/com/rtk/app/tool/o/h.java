package com.rtk.app.tool.o;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import c.a.a.m;
import c.a.a.r;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.rtk.app.bean.LoginAndToken;
import com.rtk.app.bean.ResponseBean;
import com.rtk.app.bean.ResponseDataBean;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.coins.ExchangeGoldCoinsActivity;
import com.rtk.app.main.coins.RechargeRCoinsActivity;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import com.ss.android.download.api.constant.BaseConstants;
import com.umeng.analytics.pro.ak;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import g.m;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* compiled from: MyNetListener.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class h {
    private static c.a.a.l b;

    /* renamed from: c, reason: collision with root package name */
    private static com.android.volley.toolbox.l f315c;
    private static OkHttpClient d;
    private static OkHttpClient f;
    private static Map<String, com.rtk.app.tool.o.i> a = new HashMap();
    private static Gson e = new GsonBuilder().enableComplexMapKeySerialization().create();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyNetListener.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a implements g.d<String> {
        final /* synthetic */ Context a;
        final /* synthetic */ Context b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ j f316c;
        final /* synthetic */ int d;

        a(Context context, Context context2, j jVar, int i) {
            this.a = context;
            this.b = context2;
            this.f316c = jVar;
            this.d = i;
        }

        public void a(g.b<String> bVar, Throwable th) {
            try {
                if (!t.t1(this.b)) {
                    c0.s("MyNetListener", "load failure");
                    com.rtk.app.tool.f.a(this.b, "请检查您的网络", f.a.f);
                    this.f316c.g(-1, y.E, this.d);
                } else {
                    c0.s("MyNetListener", "请求失败的原因" + th.toString());
                    com.rtk.app.tool.f.a(this.b, "请求超时！", 200);
                    this.f316c.g(-1, y.E, this.d);
                }
            } catch (Exception unused) {
            }
        }

        public void b(g.b<String> bVar, g.l<String> lVar) {
            String str;
            try {
                try {
                    if (lVar != null) {
                        ResponseBean responseBean = (ResponseBean) h.e.fromJson(((String) lVar.a()).trim(), ResponseBean.class);
                        if (responseBean.isValidation()) {
                            str = t.b(((String) lVar.a()).trim());
                        } else {
                            str = new String(Base64.decode(responseBean.getData().toString(), 2));
                        }
                        ResponseDataBean responseDataBean = (ResponseDataBean) h.e.fromJson(str, ResponseDataBean.class);
                        int code = responseDataBean.getCode();
                        if (code == 0) {
                            this.f316c.d(str, this.d);
                            return;
                        }
                        if (code == 601) {
                            h.u((Activity) this.a, str);
                            return;
                        }
                        if (code == 2001) {
                            LoginAndToken loginAndToken = (LoginAndToken) h.e.fromJson(str, LoginAndToken.class);
                            if (loginAndToken.getData() != null && (loginAndToken.getData().getAc().equals("userLoginGetScore") || loginAndToken.getData().getAc().equals("userBaseInfo"))) {
                                this.f316c.g(responseDataBean.getCode(), responseDataBean.getMsg(), this.d);
                                return;
                            }
                            c0.s("MyNetListener", responseDataBean.getMsg());
                            this.f316c.g(responseDataBean.getCode(), responseDataBean.getMsg(), this.d);
                            t.w0(MyApplication.b());
                            return;
                        }
                        if (code != 3015 && code != 3028) {
                            if (code == 7701 || code == 7713) {
                                c0.s("MyNetListener", "密码错误");
                                c0.s("MyNetListener", "密码错误" + responseDataBean.getMsg());
                            } else if (code == 8801) {
                                c0.s("MyNetListener", this.b.getClass().getName() + "       " + responseDataBean.getCode() + "       " + responseDataBean.getMsg());
                                this.f316c.g(responseDataBean.getCode(), responseDataBean.getMsg(), this.d);
                                if (this.b.getClass().getName().contains("MainActivity")) {
                                    return;
                                }
                                ((Activity) this.b).finish();
                                return;
                            }
                            c0.s("MyNetListener", this.b.getClass().getName() + "    mark   " + this.d + "       " + responseDataBean.getCode() + "       " + responseDataBean.getMsg());
                            this.f316c.g(responseDataBean.getCode(), responseDataBean.getMsg(), this.d);
                            return;
                        }
                        Context context = this.a;
                        if (context instanceof Activity) {
                            h.g((Activity) context, responseDataBean.getCode()).show();
                            return;
                        }
                        c0.s("MyNetListener", this.b.getClass().getName() + " " + responseDataBean.getCode() + " " + responseDataBean.getMsg());
                        this.f316c.g(responseDataBean.getCode(), responseDataBean.getMsg(), this.d);
                        return;
                    }
                    this.f316c.g(-1, "请求内容为空", this.d);
                } catch (NullPointerException e) {
                    c0.s("MyNetListener", "空指针异常" + e.toString() + "\n界面" + this.b.getClass().getName());
                    this.f316c.g(-1, "空指针异常", this.d);
                } catch (JsonSyntaxException e2) {
                    c0.s("MyNetListener", "json解析异常" + e2.toString());
                    this.f316c.g(-1, "数据解析异常", this.d);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: MyNetListener.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class b implements m.b<String> {
        final /* synthetic */ j a;
        final /* synthetic */ int b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f317c;

        b(j jVar, int i, String str) {
            this.a = jVar;
            this.b = i;
            this.f317c = str;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(String str) {
            if (str != null) {
                try {
                    ResponseDataBean responseDataBean = (ResponseDataBean) h.e.fromJson(t.b(str.toString().trim()), ResponseDataBean.class);
                    if (responseDataBean.getCode() == 0) {
                        this.a.d(t.b(str.toString().trim()), this.b);
                    } else {
                        c0.r("MyNetListener", "       " + responseDataBean.getCode() + "       " + responseDataBean.getMsg());
                        this.a.g(responseDataBean.getCode(), responseDataBean.getMsg(), this.b);
                    }
                } catch (NullPointerException e) {
                    c0.s("MyNetListener", "空指针异常" + e.toString() + " 链接地址  " + this.f317c);
                } catch (JsonSyntaxException e2) {
                    c0.s("MyNetListener", "json解析异常" + e2.toString() + "   链接地址  " + this.f317c);
                }
            }
        }
    }

    /* compiled from: MyNetListener.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class c extends com.android.volley.toolbox.l {
        final /* synthetic */ Map o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i, String str, m.b bVar, m.a aVar, Map map) {
            super(i, str, bVar, aVar);
            this.o = map;
        }

        protected Map<String, String> o() {
            return h.s(this.o);
        }
    }

    /* compiled from: MyNetListener.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class d extends com.android.volley.toolbox.l {
        final /* synthetic */ Map o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(int i, String str, m.b bVar, m.a aVar, Map map) {
            super(i, str, bVar, aVar);
            this.o = map;
        }

        protected Map<String, String> o() {
            Map<String, String> s = h.s(this.o);
            if (!s.containsKey("os_info")) {
                s.put("os_info", y.y());
            }
            return s;
        }
    }

    /* compiled from: MyNetListener.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class e implements m.b<String> {
        final /* synthetic */ j a;
        final /* synthetic */ int b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f318c;

        e(j jVar, int i, Context context) {
            this.a = jVar;
            this.b = i;
            this.f318c = context;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(String str) {
            if (str != null) {
                try {
                    ResponseDataBean responseDataBean = (ResponseDataBean) h.e.fromJson(str.toString().trim(), ResponseDataBean.class);
                    if (responseDataBean.getCode() == 0) {
                        this.a.d(str.toString().trim(), this.b);
                        return;
                    }
                    int code = responseDataBean.getCode();
                    if (code == 0) {
                        this.a.d(str.trim(), this.b);
                        return;
                    }
                    if (code != 2001) {
                        c0.s("MyNetListener", this.f318c.getClass().getName() + "       " + responseDataBean.getCode() + "       " + responseDataBean.getMsg());
                        this.a.g(responseDataBean.getCode(), responseDataBean.getMsg(), this.b);
                        return;
                    }
                    String trim = str.trim();
                    c0.s("MyNetListener", "   登录失败   " + trim);
                    LoginAndToken loginAndToken = (LoginAndToken) h.e.fromJson(trim, LoginAndToken.class);
                    if (loginAndToken.getData() != null && (loginAndToken.getData().getAc().equals("userLoginGetScore") || loginAndToken.getData().getAc().equals("userBaseInfo"))) {
                        this.a.g(responseDataBean.getCode(), responseDataBean.getMsg(), this.b);
                        return;
                    }
                    c0.s("MyNetListener", responseDataBean.getMsg());
                    this.a.g(responseDataBean.getCode(), responseDataBean.getMsg(), this.b);
                    t.w0(MyApplication.b());
                } catch (NullPointerException e) {
                    c0.s("MyNetListener", "空指针异常" + e.toString());
                }
            }
        }
    }

    /* compiled from: MyNetListener.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class f implements m.a {
        final /* synthetic */ j a;
        final /* synthetic */ String b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f319c;

        f(j jVar, String str, int i) {
            this.a = jVar;
            this.b = str;
            this.f319c = i;
        }

        public void a(r rVar) {
            this.a.g(-1, "服务器异常x305  " + this.b + "   " + rVar.toString(), this.f319c);
        }
    }

    /* compiled from: MyNetListener.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class g extends com.android.volley.toolbox.l {
        final /* synthetic */ Map o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(int i, String str, m.b bVar, m.a aVar, Map map) {
            super(i, str, bVar, aVar);
            this.o = map;
        }

        protected Map<String, String> o() {
            return this.o;
        }
    }

    /* compiled from: MyNetListener.java */
    /* renamed from: com.rtk.app.tool.o.h$h, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class C0027h implements Callback {
        final /* synthetic */ j a;
        final /* synthetic */ int b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f320c;

        C0027h(j jVar, int i, String str) {
            this.a = jVar;
            this.b = i;
            this.f320c = str;
        }

        public void onFailure(Call call, IOException iOException) {
            c0.s("MyNetListener", " 上传图片文件 onFailure e=" + iOException);
            this.a.g(-1, "上传图片出错:" + iOException, this.b);
        }

        public void onResponse(Call call, Response response) {
            try {
                String string = response.body().string();
                if (response != null) {
                    ResponseDataBean responseDataBean = (ResponseDataBean) h.e.fromJson(string, ResponseDataBean.class);
                    if (responseDataBean.getCode() == 0) {
                        this.a.d(string, this.b);
                    } else {
                        c0.s("MyNetListener", "失败完整Json  " + string);
                        this.a.g(responseDataBean.getCode(), responseDataBean.getMsg(), this.b);
                    }
                }
            } catch (JsonSyntaxException e) {
                c0.s("MyNetListener", "json解析异常" + e.toString() + "   链接地址  " + this.f320c);
                this.a.g(-1, "解析异常X0101", this.b);
            } catch (NullPointerException e2) {
                c0.s("MyNetListener", "空指针异常" + e2.toString() + " 链接地址  " + this.f320c);
                this.a.g(-1, "服务器数据异常X0100", this.b);
            }
        }
    }

    /* compiled from: MyNetListener.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class i implements Callback {
        final /* synthetic */ com.rtk.app.custom.RichEditText.a.f a;

        i(com.rtk.app.custom.RichEditText.a.f fVar) {
            this.a = fVar;
        }

        public void onFailure(Call call, IOException iOException) {
            c0.s("MyNetListener", " 上传图片文件 onFailure e=" + iOException);
            this.a.c().g(-1, "上传图片出错:" + iOException, this.a.d());
        }

        public void onResponse(Call call, Response response) {
            try {
                String string = response.body().string();
                if (response != null) {
                    ResponseDataBean responseDataBean = (ResponseDataBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(string, ResponseDataBean.class);
                    if (responseDataBean.getCode() == 0) {
                        this.a.c().d(string, this.a.d());
                    } else {
                        c0.s("MyNetListener", "失败完整Json  " + string);
                        this.a.c().g(responseDataBean.getCode(), responseDataBean.getMsg(), this.a.d());
                    }
                }
            } catch (NullPointerException e) {
                c0.s("MyNetListener", "空指针异常" + e.toString() + " 链接地址  " + this.a.h());
                this.a.c().g(-1, "服务器数据异常X0100", this.a.d());
            } catch (JsonSyntaxException e2) {
                c0.s("MyNetListener", "json解析异常" + e2.toString() + "   链接地址  " + this.a.h());
                this.a.c().g(-1, "解析异常X0101", this.a.d());
            }
        }
    }

    /* compiled from: MyNetListener.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface j {
        void d(String str, int i);

        void g(int i, String str, int i2);
    }

    private static void d(ResponseDataBean responseDataBean, j jVar, int i2) {
        if (jVar instanceof com.rtk.app.tool.o.j) {
            ((com.rtk.app.tool.o.j) jVar).a(responseDataBean, i2);
        } else {
            jVar.g(responseDataBean.getCode(), responseDataBean.getMsg(), i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void e(j jVar, int i2, JsonSyntaxException jsonSyntaxException, String str) {
        c0.s("MyNetListener", "Json解析异常" + jsonSyntaxException.toString() + UMCustomLogInfoBuilder.LINE_SEP + str);
        jVar.g(-1, "解析异常X0101", i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void f(j jVar, int i2, String str, int i3) {
        c0.s("MyNetListener", "       " + i2 + "       " + str);
        jVar.g(i2, str, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AlertDialog.Builder g(final Activity activity, final int i2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("温馨提示");
        builder.setMessage(i2 == 3015 ? "您的金币不足，无法继续操作，是否需要转到充值界面？" : "您的金币不足，可用R币兑换金币，是否跳转到兑换界面？");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.rtk.app.tool.o.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                h.n(i2, activity, dialogInterface, i3);
            }
        });
        builder.setNegativeButton("取消", (DialogInterface.OnClickListener) null);
        return builder;
    }

    public static synchronized com.rtk.app.tool.o.i h(String... strArr) {
        com.rtk.app.tool.o.i iVar;
        String str;
        synchronized (h.class) {
            if (strArr.length > 0) {
                iVar = a.get(strArr[0]);
            } else {
                iVar = a.get(y.d);
            }
            if (iVar != null) {
                return iVar;
            }
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            d = builder.connectTimeout(6L, timeUnit).readTimeout(10L, timeUnit).build();
            m.b bVar = new m.b();
            bVar.f(d);
            bVar.a(g.p.a.k.d());
            if (strArr.length > 0) {
                str = strArr[0];
            } else {
                str = y.d;
            }
            bVar.b(str);
            com.rtk.app.tool.o.i iVar2 = (com.rtk.app.tool.o.i) bVar.d().d(com.rtk.app.tool.o.i.class);
            a.put(str, iVar2);
            return iVar2;
        }
    }

    private static synchronized OkHttpClient i() {
        OkHttpClient okHttpClient;
        synchronized (h.class) {
            if (f == null) {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                f = builder.connectTimeout(20L, timeUnit).writeTimeout(20L, timeUnit).build();
            }
            okHttpClient = f;
        }
        return okHttpClient;
    }

    public static void j(final Context context, final j jVar, final String str, final int i2, Map<String, String> map) {
        try {
            if (b == null) {
                b = k(context);
            }
            d dVar = new d(1, str.replace(" ", ""), new m.b() { // from class: com.rtk.app.tool.o.b
                public final void onResponse(Object obj) {
                    h.o(h.j.this, i2, context, (String) obj);
                }
            }, new m.a() { // from class: com.rtk.app.tool.o.d
                public final void a(r rVar) {
                    h.p(str, jVar, i2, rVar);
                }
            }, map);
            f315c = dVar;
            dVar.I(false);
            b.a(f315c);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static c.a.a.l k(Context context) {
        if (b == null) {
            b = com.android.volley.toolbox.m.a(context.getApplicationContext());
        }
        com.android.volley.toolbox.d dVar = new com.android.volley.toolbox.d(new File(context.getCacheDir(), "ZBW"));
        b.d();
        b.a(new com.android.volley.toolbox.c(dVar, (Runnable) null));
        return b;
    }

    public static void l(Context context, j jVar, int i2, g.b<String> bVar) {
        bVar.b(new a(context, context.getApplicationContext(), jVar, i2));
    }

    public static void m(Context context, j jVar, String str, int i2, Map<String, String> map) {
        try {
            if (b == null) {
                b = k(context);
            }
            g gVar = new g(1, str.replace(" ", ""), new e(jVar, i2, context), new f(jVar, str, i2), map);
            f315c = gVar;
            gVar.G(new c.a.a.d(BaseConstants.Time.MINUTE, 1, 1.0f));
            f315c.I(false);
            b.a(f315c);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void n(int i2, Activity activity, DialogInterface dialogInterface, int i3) {
        if (i2 == 3015) {
            activity.startActivity(new Intent(activity, (Class<?>) RechargeRCoinsActivity.class));
        } else {
            if (i2 != 3028) {
                return;
            }
            activity.startActivity(new Intent(activity, (Class<?>) ExchangeGoldCoinsActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void o(j jVar, int i2, Context context, String str) {
        String str2;
        if (str != null) {
            try {
                ResponseBean responseBean = (ResponseBean) e.fromJson(str, ResponseBean.class);
                if (responseBean.isValidation()) {
                    str2 = t.b(str);
                } else {
                    str2 = new String(Base64.decode(responseBean.getData().toString(), 2));
                }
                ResponseDataBean responseDataBean = (ResponseDataBean) e.fromJson(str2, ResponseDataBean.class);
                if (responseDataBean.getCode() == 0) {
                    jVar.d(str2, i2);
                    return;
                }
                int code = responseDataBean.getCode();
                if (code == 0) {
                    jVar.d(str2, i2);
                    return;
                }
                if (code == 601) {
                    u((Activity) context, str2);
                    return;
                }
                if (code == 2001) {
                    c0.s("MyNetListener", "   登录失败   " + str2);
                    LoginAndToken loginAndToken = (LoginAndToken) e.fromJson(str2, LoginAndToken.class);
                    if (loginAndToken.getData() != null && (loginAndToken.getData().getAc().equals("userLoginGetScore") || loginAndToken.getData().getAc().equals("userBaseInfo"))) {
                        d(responseDataBean, jVar, i2);
                        return;
                    }
                    c0.s("MyNetListener", responseDataBean.getMsg());
                    d(responseDataBean, jVar, i2);
                    t.w0(MyApplication.b());
                    return;
                }
                if (code != 3015 && code != 3028) {
                    c0.s("MyNetListener", context.getClass().getName() + " " + responseDataBean.getCode() + " " + responseDataBean.getMsg());
                    d(responseDataBean, jVar, i2);
                    return;
                }
                if (context instanceof Activity) {
                    g((Activity) context, responseDataBean.getCode()).show();
                    return;
                }
                c0.s("MyNetListener", context.getClass().getName() + " " + responseDataBean.getCode() + " " + responseDataBean.getMsg());
                d(responseDataBean, jVar, i2);
            } catch (NullPointerException e2) {
                c0.s("MyNetListener", "空指针异常" + e2.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void p(String str, j jVar, int i2, r rVar) {
        ResponseDataBean responseDataBean = new ResponseDataBean();
        responseDataBean.setCode(-1);
        responseDataBean.setMsg("服务器异常x305  " + str + "   " + rVar.toString());
        d(responseDataBean, jVar, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void q(String str, Activity activity, DialogInterface dialogInterface, int i2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        activity.startActivity(intent);
    }

    public static Map<String, String> s(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith("$*$")) {
                key = key.substring(3, key.length());
            }
            hashMap.put(key, entry.getValue());
        }
        return hashMap;
    }

    public static synchronized void t(String str) {
        synchronized (h.class) {
            if (d == null) {
                y.d = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void u(final Activity activity, String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
            String optString = optJSONObject.optString("tips");
            final String optString2 = optJSONObject.optString("updatesUrl");
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle("温馨提示");
            builder.setMessage(optString);
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.rtk.app.tool.o.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    h.q(optString2, activity, dialogInterface, i2);
                }
            });
            builder.show();
        } catch (Exception e2) {
            c0.s("MyNetListener", e2.getMessage());
        }
    }

    public static void v(Context context, com.rtk.app.custom.RichEditText.a.f fVar, boolean... zArr) {
        String str = "";
        try {
            str = "." + c.d.a.b.c(fVar.a().getPath());
            c0.u("MyNetListener", "文件后缀名  " + str);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        boolean z = zArr.length == 1 ? zArr[0] : false;
        if (c0.q(str)) {
            str = ".jpg";
        }
        RequestBody create = RequestBody.create(MediaType.parse("application/octet-stream"), fVar.a());
        c0.u("MyNetListener", " 上传图片    type     " + fVar.f() + "图片大小" + fVar.a().length() + "   后缀名" + str);
        try {
            i().newCall(new Request.Builder().url(fVar.h()).post(new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart(z ? "upfile" : "upfile[]", fVar.a().getName() + str, create).addFormDataPart("channel", y.m(context, context.getPackageName())).addFormDataPart("version", y.i(context)).addFormDataPart(ak.aj, y.g()).addFormDataPart("phone_model", y.T()).addFormDataPart(com.umeng.analytics.pro.d.y, fVar.f()).addFormDataPart("uid", fVar.g()).addFormDataPart("token", fVar.e()).addFormDataPart("level", fVar.b()).build()).build()).enqueue(new i(fVar));
        } catch (Exception unused) {
            fVar.c().g(-1, "数组越界异常", fVar.d());
        }
    }

    public static void w(Context context, final j jVar, String str, final int i2, Map<String, String> map) {
        try {
            if (b == null) {
                b = k(context);
            }
            b.a(new c(1, str, new b(jVar, i2, str), new m.a() { // from class: com.rtk.app.tool.o.e
                public final void a(r rVar) {
                    h.j.this.g(-1, rVar.toString(), i2);
                }
            }, map));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void x(Context context, j jVar, String str, int i2, File file, String str2, String str3) {
        String str4 = "";
        try {
            str4 = "." + c.d.a.b.c(file.getPath());
            c0.s("MyNetListener", "文件后缀名  " + str4);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (c0.q(str4)) {
            str4 = ".jpg";
        }
        RequestBody create = RequestBody.create(MediaType.parse("application/octet-stream"), file);
        c0.u("MyNetListener", " 上传图片    type     " + str2 + "图片大小" + file.length() + "   后缀名" + str4);
        try {
            i().newCall(new Request.Builder().url(str).post(new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("upfile[]", str3 + str4, create).addFormDataPart("channel", y.m(context, context.getPackageName())).addFormDataPart("version", y.i(context)).addFormDataPart(ak.aj, y.g()).addFormDataPart("phone_model", y.T()).addFormDataPart(com.umeng.analytics.pro.d.y, str2).build()).build()).enqueue(new C0027h(jVar, i2, str));
        } catch (Exception unused) {
            jVar.g(-1, "数组越界异常", i2);
        }
    }
}
