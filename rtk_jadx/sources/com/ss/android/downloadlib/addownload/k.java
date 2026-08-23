package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.o;
import com.ss.android.download.api.config.p;
import com.ss.android.download.api.config.q;
import com.ss.android.download.api.config.s;
import com.ss.android.download.api.config.u;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.model.a;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class k {
    public static final JSONObject a = new JSONObject();
    private static Context b;

    /* renamed from: c, reason: collision with root package name */
    private static com.ss.android.download.api.config.g f758c;
    private static com.ss.android.download.api.config.c d;
    private static com.ss.android.download.api.config.l e;
    private static com.ss.android.download.api.config.h f;
    private static com.ss.android.download.api.config.i g;
    private static com.ss.android.download.api.config.j h;
    private static com.ss.android.download.api.model.a i;
    private static com.ss.android.download.api.config.b j;
    private static com.ss.android.socialbase.appdownloader.c.h k;
    private static com.ss.android.download.api.config.d l;
    private static com.ss.android.download.api.config.e m;
    private static o n;
    private static com.ss.android.download.api.config.k o;
    private static u p;
    private static com.ss.android.download.api.config.n q;
    private static com.ss.android.download.api.config.m r;
    private static p s;
    private static com.ss.android.download.api.b.a t;
    private static q u;
    private static s v;

    public static void a(Context context) {
        if (context != null && context.getApplicationContext() != null) {
            b = context.getApplicationContext();
            return;
        }
        throw new IllegalArgumentException("Context is null");
    }

    public static void b(Context context) {
        if (b != null || context == null || context.getApplicationContext() == null) {
            return;
        }
        b = context.getApplicationContext();
    }

    @NonNull
    public static com.ss.android.download.api.config.c c() {
        if (d == null) {
            d = new com.ss.android.download.api.config.c() { // from class: com.ss.android.downloadlib.addownload.k.1
            };
        }
        return d;
    }

    @NonNull
    public static com.ss.android.download.api.config.l d() {
        if (e == null) {
            e = new com.ss.android.download.api.a.a();
        }
        return e;
    }

    public static com.ss.android.download.api.config.h e() {
        return f;
    }

    @NonNull
    public static com.ss.android.download.api.config.i f() {
        if (g == null) {
            g = new com.ss.android.download.api.a.b();
        }
        return g;
    }

    public static com.ss.android.socialbase.appdownloader.c.h g() {
        if (k == null) {
            k = new com.ss.android.socialbase.appdownloader.c.h() { // from class: com.ss.android.downloadlib.addownload.k.2
                @Override // com.ss.android.socialbase.appdownloader.c.h
                public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) {
                }
            };
        }
        return k;
    }

    public static o h() {
        return n;
    }

    @NonNull
    public static p i() {
        if (s == null) {
            s = new p() { // from class: com.ss.android.downloadlib.addownload.k.3
            };
        }
        return s;
    }

    @NonNull
    public static JSONObject j() {
        com.ss.android.download.api.config.j jVar = h;
        if (jVar != null && jVar.a() != null) {
            return h.a();
        }
        return a;
    }

    @NonNull
    public static com.ss.android.download.api.model.a k() {
        if (i == null) {
            i = new a.C0068a().a();
        }
        return i;
    }

    public static com.ss.android.download.api.config.m l() {
        return r;
    }

    @Nullable
    public static com.ss.android.download.api.config.b m() {
        return j;
    }

    @Nullable
    public static com.ss.android.download.api.config.n n() {
        return q;
    }

    public static String o() {
        return "1.7.0";
    }

    public static com.ss.android.download.api.config.d p() {
        return l;
    }

    public static com.ss.android.download.api.config.e q() {
        return m;
    }

    public static com.ss.android.download.api.config.k r() {
        return o;
    }

    @NonNull
    public static q s() {
        return u;
    }

    public static u t() {
        return p;
    }

    @NonNull
    public static com.ss.android.download.api.b.a u() {
        if (t == null) {
            t = new com.ss.android.download.api.b.a() { // from class: com.ss.android.downloadlib.addownload.k.4
                @Override // com.ss.android.download.api.b.a
                public void a(Throwable th, String str) {
                }
            };
        }
        return t;
    }

    @NonNull
    public static s v() {
        if (v == null) {
            v = new s() { // from class: com.ss.android.downloadlib.addownload.k.5
            };
        }
        return v;
    }

    public static String w() {
        try {
            int i2 = a().getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT >= 29 && ((i2 == 29 && !Environment.isExternalStorageLegacy()) || i2 > 29)) {
                return a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            }
            return Environment.getExternalStorageDirectory().getPath() + File.separator + j().optString("default_save_dir_name", BaseConstants.DOWNLOAD_DIR);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean x() {
        return (f758c == null || f == null || h == null || j == null || u == null) ? false : true;
    }

    public static com.ss.android.download.api.config.g b() {
        return f758c;
    }

    public static Context a() {
        Context context = b;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("Context is null");
    }

    public static void a(@NonNull com.ss.android.download.api.config.g gVar) {
        f758c = gVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.l lVar) {
        e = lVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.h hVar) {
        f = hVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.i iVar) {
        g = iVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.j jVar) {
        h = jVar;
    }

    public static void a(@NonNull com.ss.android.download.api.model.a aVar) {
        i = aVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.b bVar) {
        j = bVar;
    }

    public static void a(String str) {
        com.ss.android.socialbase.appdownloader.d.j().a(str);
    }

    public static void a(q qVar) {
        u = qVar;
    }

    public static void a(com.ss.android.download.api.b.a aVar) {
        t = aVar;
    }
}
