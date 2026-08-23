package com.rtk.app.tool.o;

import android.app.Activity;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.rtk.app.bean.ResponseDataBean;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.dialogPack.DialogJustEnsure;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.s;
import com.rtk.app.tool.v;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
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

/* compiled from: UpNetListener.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class n {
    public static int a = 2097152;
    private static int b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static int f326c = 0;
    private static int d = 15;
    private static OkHttpClient g;
    private static OkHttpClient.Builder h;
    private static HttpLoggingInterceptor i;
    private static d k;
    public static List<String> e = new ArrayList();
    public static Map<String, h.j> f = new HashMap();
    private static Map<String, WeakReference<l>> j = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UpNetListener.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a implements HttpLoggingInterceptor.Logger {
        a() {
        }

        public void log(String str) {
            c0.u("UpNetListener", "当前响应码" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UpNetListener.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class b implements Callback {
        final /* synthetic */ String a;
        final /* synthetic */ int b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f327c;
        final /* synthetic */ l d;
        final /* synthetic */ h.j e;
        final /* synthetic */ int f;
        final /* synthetic */ String g;
        final /* synthetic */ boolean h;
        final /* synthetic */ String i;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: UpNetListener.java */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public class a extends TimerTask {
            a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                h.j jVar;
                if (n.e.contains(b.this.a)) {
                    cancel();
                    return;
                }
                c0.u("UpNetListener", "网络波动值续传");
                int i = b.this.f327c;
                String d = v.d(MyApplication.b(), b.this.d.c() + "MD5");
                if (com.rtk.app.main.UpModule.UpControlPack.b.i().o(d)) {
                    jVar = com.rtk.app.main.UpModule.UpControlPack.b.m(d);
                } else {
                    jVar = b.this.e;
                }
                h.j jVar2 = jVar;
                String str = y.i + "html/filelist/appsUploadDataBag";
                b bVar = b.this;
                n.p(jVar2, str, bVar.f, i, d, bVar.g, true);
                cancel();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: UpNetListener.java */
        /* renamed from: com.rtk.app.tool.o.n$b$b, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public class C0028b extends TimerTask {
            C0028b() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (n.e.contains(b.this.a)) {
                    cancel();
                    return;
                }
                c0.u("UpNetListener", "网络波动值续传");
                int i = b.this.f327c;
                String d = v.d(MyApplication.b(), b.this.d.c() + "MD5");
                h.j jVar = b.this.e;
                String str = y.i + "html/filelist/appsUploadDataBag";
                b bVar = b.this;
                n.p(jVar, str, bVar.f, i, d, bVar.g, true);
                cancel();
            }
        }

        b(String str, int i, int i2, l lVar, h.j jVar, int i3, String str2, boolean z, String str3) {
            this.a = str;
            this.b = i;
            this.f327c = i2;
            this.d = lVar;
            this.e = jVar;
            this.f = i3;
            this.g = str2;
            this.h = z;
            this.i = str3;
        }

        public void onFailure(Call call, IOException iOException) {
            n.m(this.a);
            com.rtk.app.tool.g.g j = com.rtk.app.tool.g.f.e(MyApplication.b()).j(this.a);
            if (j.v() == 1 && this.b > this.f327c) {
                n.m(this.a);
                com.rtk.app.main.UpModule.UpHolderTool.d.a(MyApplication.b()).c(j);
                com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().d(j.y());
                com.rtk.app.main.UpModule.UpControlPack.b.i().r();
                return;
            }
            int i = this.f327c;
            if (com.rtk.app.main.UpModule.UpControlPack.b.i().o(this.a)) {
                if (n.f326c >= 2) {
                    com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().e(j.y());
                }
                n.d();
                new Timer().schedule(new a(), 2000L);
                return;
            }
            c0.u("UpNetListener", " 上传Apk文件 onFailuree=" + iOException);
            if (iOException.toString().contains("SocketTimeoutException")) {
                if (n.f326c >= 300) {
                    n.m(this.a);
                    this.e.g(-2, "上传apk出错:" + iOException.toString(), this.f);
                    com.rtk.app.main.UpModule.UpHolderTool.d.a(MyApplication.b()).c(j);
                    com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().d(j.y());
                    return;
                }
                n.d();
                String d = v.d(MyApplication.b(), this.d.c() + "MD5");
                n.p(this.e, y.i + "html/filelist/appsUploadDataBag", this.f, i, d, this.g, true);
                return;
            }
            if (!iOException.toString().contains("SocketException") && !iOException.toString().contains("UnknownHostException") && !iOException.toString().contains("ConnectException")) {
                c0.u("UpNetListener", " 上传apk出错 onFailuree=" + iOException);
                this.e.g(-2, "上传apk出错:" + iOException, this.f);
                int unused = n.b = 0;
                n.m(this.a);
                if (j.m() == 0) {
                    j.H(1);
                    j.F(100);
                    com.rtk.app.main.UpModule.UpHolderTool.d.a(MyApplication.b()).b((Activity) MyApplication.b(), j, "", 1);
                    com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().d(j.y());
                    com.rtk.app.tool.g.f.e(MyApplication.b()).y(this.a, 1, 100, this.i);
                    n.p(this.e, y.i + "html/filelist/appsUploadDataBag", this.f, i, this.a, this.g, true);
                    return;
                }
                com.rtk.app.main.UpModule.UpHolderTool.d.a(MyApplication.b()).c(j);
                com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().d(j.y());
                return;
            }
            if (this.h && n.f326c < 300) {
                n.d();
                if (n.f326c > 1) {
                    com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().e(j.y());
                }
                new Timer().schedule(new C0028b(), 2000L);
                return;
            }
            this.e.g(-2, "网络链接问题:" + iOException, this.f);
            int unused2 = n.b = 0;
            n.m(this.a);
            com.rtk.app.main.UpModule.UpHolderTool.d.a(MyApplication.b()).c(j);
            com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().d(j.y());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:54:0x038a  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x03b8  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0323  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0347  */
        /* JADX WARN: Type inference failed for: r2v20 */
        /* JADX WARN: Type inference failed for: r2v31 */
        /* JADX WARN: Type inference failed for: r2v38, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v39 */
        /* JADX WARN: Type inference failed for: r2v57 */
        /* JADX WARN: Type inference failed for: r2v58 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onResponse(okhttp3.Call r24, okhttp3.Response r25) {
            /*
                Method dump skipped, instructions count: 974
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.tool.o.n.b.onResponse(okhttp3.Call, okhttp3.Response):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UpNetListener.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class c implements Callback {
        final /* synthetic */ String a;
        final /* synthetic */ int b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ h.j f328c;
        final /* synthetic */ int d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;
        final /* synthetic */ boolean g;
        final /* synthetic */ String h;
        final /* synthetic */ int i;

        /* compiled from: UpNetListener.java */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        class a extends TimerTask {
            a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                c0.u("UpNetListener", "网络波动值续传");
                c cVar = c.this;
                int i = cVar.b;
                h.j jVar = cVar.f328c;
                String str = y.j + y.m;
                c cVar2 = c.this;
                n.o(jVar, str, cVar2.d, cVar2.a, i, cVar2.h, cVar2.e, cVar2.f, false);
                cancel();
            }
        }

        c(String str, int i, h.j jVar, int i2, String str2, String str3, boolean z, String str4, int i3) {
            this.a = str;
            this.b = i;
            this.f328c = jVar;
            this.d = i2;
            this.e = str2;
            this.f = str3;
            this.g = z;
            this.h = str4;
            this.i = i3;
        }

        public void onFailure(Call call, IOException iOException) {
            if (iOException.toString().contains("SocketTimeoutException")) {
                if (n.b < 150) {
                    n.g();
                    String d = v.d(MyApplication.b(), this.a + "MD5");
                    int i = this.b;
                    n.o(this.f328c, y.j + y.m, this.d, this.a, i, d, this.e, this.f, true);
                    return;
                }
                this.f328c.g(-1, "上传视频:" + iOException, this.d);
                int unused = n.b = 0;
                return;
            }
            if (iOException.toString().contains("SocketException") && this.g) {
                new Timer().schedule(new a(), 2000L);
                return;
            }
            c0.u("UpNetListener", " 上传视频 onFailuree=" + iOException);
            this.f328c.g(-1, "上传视频:" + iOException, this.d);
            int unused2 = n.b = 0;
        }

        public void onResponse(Call call, Response response) {
            int unused = n.b = 0;
            int i = this.b + 1;
            v.h(MyApplication.b(), "upVideoPath", this.a);
            v.f(MyApplication.b(), "upVideoIndex" + this.h, i);
            if (n.k != null) {
                n.k.o(this.i, this.b);
                if (n.k.i()) {
                    return;
                }
            }
            if (i <= this.i) {
                String d = v.d(MyApplication.b(), this.a + "MD5");
                n.o(this.f328c, y.j + y.m, this.d, this.a, i, d, this.e, this.f, true);
            } else {
                String string = response.body().string();
                ResponseDataBean responseDataBean = (ResponseDataBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(string, ResponseDataBean.class);
                if (string != null) {
                    try {
                        if (responseDataBean.getCode() == 0) {
                            this.f328c.d(string, this.d);
                            v.f(MyApplication.b(), "upVideoIndex" + this.h, 0);
                        }
                    } catch (JsonSyntaxException e) {
                        h.e(this.f328c, this.d, e, string);
                    } catch (Exception unused2) {
                    }
                }
                h.f(this.f328c, responseDataBean.getCode(), responseDataBean.getMsg(), this.d);
            }
            call.cancel();
        }
    }

    /* compiled from: UpNetListener.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface d {
        boolean i();

        void o(int i, int i2);
    }

    static {
        new GsonBuilder().enableComplexMapKeySerialization().create();
    }

    static /* synthetic */ int d() {
        int i2 = f326c;
        f326c = i2 + 1;
        return i2;
    }

    static /* synthetic */ int g() {
        int i2 = b;
        b = i2 + 1;
        return i2;
    }

    private static synchronized OkHttpClient i() {
        OkHttpClient build;
        synchronized (n.class) {
            if (g == null) {
                h = new OkHttpClient.Builder();
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new a());
                i = httpLoggingInterceptor;
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
            }
            OkHttpClient.Builder builder = h;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            build = builder.connectTimeout(15L, timeUnit).writeTimeout(d, timeUnit).readTimeout(d, timeUnit).addInterceptor(i).build();
            g = build;
        }
        return build;
    }

    private static l j(String str, m mVar, int i2) {
        com.rtk.app.tool.g.g k2;
        String D;
        l lVar;
        WeakReference<l> weakReference = j.get(str);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        if (mVar == m.APK) {
            k2 = com.rtk.app.tool.g.f.e(MyApplication.b()).i(str);
            D = k2.o();
        } else {
            k2 = com.rtk.app.tool.g.f.e(MyApplication.b()).k(str);
            D = k2.D();
        }
        String str2 = D;
        l lVar2 = null;
        if (k2 == null) {
            c0.s("UpNetListener", "getUpFileBeanForApk() upLoadApkInfo is null");
            return null;
        }
        if (str2.isEmpty()) {
            c0.s("UpNetListener", "getUpFileBeanForApk() filePath is null");
            return null;
        }
        File file = new File(str2);
        try {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                fileInputStream.skip((i2 - 1) * a);
                lVar = new l(str, str2, fileInputStream, file.length());
            } catch (FileNotFoundException unused) {
                c0.s("UpNetListener", "upFileApk() fileInputStream is null");
                return null;
            }
        } catch (IOException e2) {
            e = e2;
        }
        try {
            j.put(str, new WeakReference<>(lVar));
            return lVar;
        } catch (IOException e3) {
            e = e3;
            lVar2 = lVar;
            c0.s("UpNetListener", "upFileApk() IOException fileInputStream is null");
            e.printStackTrace();
            return lVar2;
        }
    }

    private static byte[] k(int i2, int i3, l lVar) {
        if (i2 < 0) {
            byte[] bArr = new byte[a];
            c0.s("UpNetListener", "index error == " + i2);
            return bArr;
        }
        if (i2 >= i3) {
            long b2 = (long) (lVar.b() - ((i2 - 1.0d) * a));
            c0.u("UpNetListener", "最后一片的尺寸" + b2);
            byte[] bArr2 = new byte[(int) b2];
            long b3 = lVar.b() / BaseConstants.MB_VALUE;
            if (b3 > ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLSX) {
                d = 480;
                return bArr2;
            }
            if (b3 > ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) {
                d = 480;
                return bArr2;
            }
            if (b3 > 512) {
                d = 150;
                return bArr2;
            }
            d = 60;
            return bArr2;
        }
        byte[] bArr3 = new byte[a];
        d = 9;
        return bArr3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void l(String str, String str2, String[] strArr) {
        com.rtk.app.tool.g.g j2 = com.rtk.app.tool.g.f.e(MyApplication.b()).j(str);
        com.rtk.app.tool.g.f.e(MyApplication.b()).o(j2.n());
        com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().d(j2.y());
        com.rtk.app.tool.g.f.e(MyApplication.b()).y(str, 1, 100, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(String str) {
        e.remove(str);
        WeakReference<l> weakReference = j.get(str);
        if (weakReference != null && weakReference.get() != null) {
            try {
                weakReference.get().a().close();
            } catch (IOException e2) {
                c0.s("UpNetListener", "getFileInputStream close failed IOException");
                e2.printStackTrace();
            }
            j.remove(str);
            return;
        }
        j.remove(str);
    }

    public static void n(d dVar) {
        k = dVar;
    }

    public static void o(h.j jVar, String str, int i2, String str2, int i3, String str3, String str4, String str5, boolean z) {
        h.j jVar2;
        int i4;
        int i5;
        RequestBody create;
        try {
            try {
            } catch (Exception e2) {
                e = e2;
                i4 = -1;
            }
            try {
                try {
                    File file = new File(str2);
                    int length = (int) (file.length() / a);
                    long length2 = file.length();
                    int i6 = a;
                    if (length2 % i6 > 0) {
                        length++;
                    }
                    i5 = length;
                    byte[] bArr = new byte[i6];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    fileInputStream.skip((i3 - 1) * a);
                    int read = fileInputStream.read(bArr);
                    fileInputStream.close();
                    if (i3 == i5) {
                        d = 60;
                    } else {
                        d = 9;
                    }
                    create = RequestBody.create(MediaType.parse("application/octet-stream"), bArr, 0, read);
                    i4 = -1;
                } catch (IOException unused) {
                    i4 = -1;
                }
                try {
                    i().newCall(new Request.Builder().url(str).post(new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("file_data", str4 + str5, create).addFormDataPart("file_upid", y.K()).addFormDataPart("file_total", i5 + "").addFormDataPart("file_name", str4 + str5).addFormDataPart("file_index", i3 + "").addFormDataPart("file_md5", str3 + "").build()).build()).enqueue(new c(str2, i3, jVar, i2, str4, str5, z, str3, i5));
                } catch (IOException unused2) {
                    jVar2 = jVar;
                    jVar2.g(i4, "请检查文件", i2);
                } catch (Exception e3) {
                    e = e3;
                    jVar.g(i4, e.toString(), i2);
                }
            } catch (ArrayIndexOutOfBoundsException unused3) {
                v.f(MyApplication.b(), "upVideoIndex" + str3, 0);
                o(jVar, y.j + y.m, i2, str2, 1, str3, str4, str5, false);
            }
        } catch (IOException unused4) {
            jVar2 = jVar;
            i4 = -1;
        } catch (ArrayIndexOutOfBoundsException unused5) {
        }
    }

    public static void p(h.j jVar, String str, int i2, int i3, final String str2, String str3, boolean z) {
        l j2 = j(str2, m.ZIP, i3);
        if (j2 == null) {
            c0.s("UpNetListener", "upFileBean is null");
            return;
        }
        final String str4 = j2.b() + "";
        c0.u("UpNetListener", "当前上传的切片是 " + i3 + "当前线程池内容" + e.size());
        if (e.size() > y.r) {
            m(str2);
            c0.u("UpNetListener", "线程池满了");
            return;
        }
        if (!e.contains(str2)) {
            e.add(str2);
        }
        int b2 = (int) (j2.b() / a);
        if (j2.b() % a > 0) {
            b2++;
        }
        int i4 = b2;
        byte[] k2 = k(i3, i4, j2);
        try {
            int read = j2.a().read(k2);
            if (i3 > i4) {
                new DialogJustEnsure(MyApplication.b(), "当前上传失败,切片已经大于最大值", new s() { // from class: com.rtk.app.tool.o.g
                    @Override // com.rtk.app.tool.s
                    public final void a(String[] strArr) {
                        n.l(str2, str4, strArr);
                    }
                }).show();
                return;
            }
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(k2);
            String a2 = com.rtk.app.tool.n.a(messageDigest);
            RequestBody create = RequestBody.create(MediaType.parse("application/octet-stream"), k2, 0, read);
            MultipartBody build = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("file_data", str3 + ".zip", create).addFormDataPart("file_upid", y.K()).addFormDataPart("file_total", i4 + "").addFormDataPart("file_name", str3 + ".zip").addFormDataPart("file_index", i3 + "").addFormDataPart("file_md5", str2 + "").addFormDataPart("currentmd5", a2 + "").build();
            c0.u("UpNetListener", "upZipApk zipMd5:" + str2);
            i().newCall(new Request.Builder().url(str).post(build).build()).enqueue(new b(str2, i4, i3, j2, jVar, i2, str3, z, str4));
        } catch (FileNotFoundException unused) {
            try {
                c0.s("UpNetListener", "apk文件已被卸载或删除");
                com.rtk.app.tool.f.a(MyApplication.b(), "apk文件已被卸载或删除", f.a.f);
                com.rtk.app.tool.g.g i5 = com.rtk.app.tool.g.f.e(MyApplication.b()).i(str2);
                com.rtk.app.tool.g.f.e(MyApplication.b()).n(str2);
                com.rtk.app.main.UpModule.UpControlPack.b.i().q(str2);
                com.rtk.app.main.UpModule.UpHolderTool.d.a(MyApplication.b()).c(i5);
                com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().d(i5.y());
                com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().f(i5.y());
                jVar.g(-1, "文件不存在", i2);
            } catch (Exception unused2) {
            }
        } catch (Exception e2) {
            c0.s("UpNetListener", "未知异常" + e2);
            jVar.g(-1, e2.toString(), i2);
        }
    }
}
