package com.sigmob.sdk.downloader.core;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.StatFs;
import android.util.Log;
import com.sigmob.sdk.base.k;
import com.sigmob.sdk.base.l;
import com.sigmob.sdk.downloader.core.breakpoint.h;
import com.sigmob.sdk.downloader.core.breakpoint.j;
import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.core.connection.b;
import com.sigmob.sdk.downloader.core.connection.c;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.downloader.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.umeng.analytics.pro.ak;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {
    public static final String a = "HEAD";
    public static final String b = "Range";

    /* renamed from: c, reason: collision with root package name */
    public static final String f508c = "If-Match";
    public static final String d = "User-Agent";
    public static final String e = "Content-Length";
    public static final String f = "Content-Range";
    public static final String g = "Etag";
    public static final String h = "Transfer-Encoding";
    public static final String i = "Accept-Ranges";
    public static final String j = "Content-Disposition";
    public static final String k = "chunked";
    public static final int l = -1;
    public static final int m = 416;
    private static b n = new a();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a implements b {
        @Override // com.sigmob.sdk.downloader.core.c.b
        public void a(String str, String str2) {
        }

        @Override // com.sigmob.sdk.downloader.core.c.b
        public void a(String str, String str2, Exception exc) {
        }

        @Override // com.sigmob.sdk.downloader.core.c.b
        public void b(String str, String str2) {
        }

        @Override // com.sigmob.sdk.downloader.core.c.b
        public void c(String str, String str2) {
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface b {
        void a(String str, String str2);

        void a(String str, String str2, Exception exc);

        void b(String str, String str2);

        void c(String str, String str2);
    }

    public static long a(StatFs statFs) {
        return Build.VERSION.SDK_INT >= 18 ? statFs.getAvailableBytes() : statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    public static j a(Context context) {
        try {
            return (j) Class.forName("com.sigmob.sdk.downloader.core.breakpoint.i").getDeclaredConstructor(Context.class).newInstance(context);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            return new h();
        }
    }

    public static j a(j jVar) {
        try {
            jVar = (j) jVar.getClass().getMethod("createRemitSelf", new Class[0]).invoke(jVar, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        b("Util", "Get final download store is " + jVar);
        return jVar;
    }

    public static File a(File file) {
        File parentFile = file.getParentFile();
        return parentFile == null ? new File("/") : parentFile;
    }

    public static String a(long j2, boolean z) {
        int i2 = z ? 1000 : WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        if (j2 < i2) {
            return j2 + " B";
        }
        double d2 = j2;
        double d3 = i2;
        int log = (int) (Math.log(d2) / Math.log(d3));
        StringBuilder sb = new StringBuilder();
        sb.append((z ? "kMGTPE" : "KMGTPE").charAt(log - 1));
        sb.append(z ? "" : ak.aC);
        return String.format(Locale.ENGLISH, "%.1f %sB", Double.valueOf(d2 / Math.pow(d3, log)), sb.toString());
    }

    public static String a(String str) {
        byte[] bArr;
        try {
            bArr = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            int i2 = b2 & 255;
            if (i2 < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(i2));
        }
        return sb.toString();
    }

    public static ThreadFactory a(final String str, final boolean z) {
        return new ThreadFactory() { // from class: com.sigmob.sdk.downloader.core.c.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    public static void a() {
        n = null;
    }

    public static void a(com.sigmob.sdk.downloader.core.breakpoint.a aVar) {
        boolean z = true;
        if (aVar.a() >= 0 && aVar.a() <= aVar.d()) {
            z = false;
        }
        if (z) {
            a("resetBlockIfDirty", "block is dirty so have to reset: " + aVar);
            aVar.f();
        }
    }

    public static void a(b bVar) {
        n = bVar;
    }

    public static void a(com.sigmob.sdk.downloader.core.connection.a aVar) {
    }

    public static void a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, long j2, boolean z) {
        int a2 = g.j().g().a(z) ? g.j().g().a(fVar, j2) : 1;
        cVar.f();
        long j3 = a2;
        long j4 = j2 / j3;
        int i2 = 0;
        long j5 = 0;
        long j6 = 0;
        while (i2 < a2) {
            j5 += j6;
            j6 = i2 == 0 ? (j2 % j3) + j4 : j4;
            cVar.a(new com.sigmob.sdk.downloader.core.breakpoint.a(j5, j6));
            i2++;
        }
    }

    public static void a(String str, String str2) {
        b bVar = n;
        if (bVar != null) {
            bVar.a(str, str2);
        } else {
            Log.w(str, str2);
        }
    }

    public static void a(String str, String str2, Exception exc) {
        b bVar = n;
        if (bVar != null) {
            bVar.a(str, str2, exc);
        } else {
            Log.e(str, str2, exc);
        }
    }

    public static void a(Map<String, List<String>> map) {
        if (map.containsKey(f508c) || map.containsKey(b)) {
            throw new IOException("If-Match and Range only can be handle by internal!");
        }
    }

    public static void a(Map<String, List<String>> map, com.sigmob.sdk.downloader.core.connection.a aVar) {
        a(map);
        b(map, aVar);
    }

    public static boolean a(long j2, long j3) {
        return j2 == j3;
    }

    public static boolean a(ConnectivityManager connectivityManager) {
        if (connectivityManager == null) {
            a("Util", "failed to get connectivity manager!");
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo == null || activeNetworkInfo.getType() != 1;
    }

    public static boolean a(Uri uri) {
        return uri.getScheme().equals("content");
    }

    public static boolean a(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static long b(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            b("Util", "parseContentLength failed parse for '" + str + "'");
            return -1L;
        }
    }

    public static b b() {
        return n;
    }

    public static void b(String str, String str2) {
        b bVar = n;
        if (bVar != null) {
            bVar.b(str, str2);
        } else {
            Log.d(str, str2);
        }
    }

    public static void b(Map<String, List<String>> map, com.sigmob.sdk.downloader.core.connection.a aVar) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                aVar.a(key, it.next());
            }
        }
    }

    public static boolean b(ConnectivityManager connectivityManager) {
        if (connectivityManager == null) {
            a("Util", "failed to get connectivity manager!");
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean b(Uri uri) {
        return uri.getScheme().equals(k.y);
    }

    public static a.b c() {
        String name = b.a.class.getName();
        try {
            if (l.a().V()) {
                return (a.b) Class.forName(name).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return new c.b();
    }

    public static String c(Uri uri) {
        Cursor query = g.j().h().getContentResolver().query(uri, null, null, null, null);
        if (query == null) {
            return null;
        }
        try {
            query.moveToFirst();
            return query.getString(query.getColumnIndex("_display_name"));
        } finally {
            query.close();
        }
    }

    public static void c(String str, String str2) {
        b bVar = n;
        if (bVar != null) {
            bVar.c(str, str2);
        } else {
            Log.i(str, str2);
        }
    }

    public static boolean c(String str) {
        return g.j().h().checkCallingOrSelfPermission(str) == 0;
    }

    public static long d(Uri uri) {
        Cursor query = g.j().h().getContentResolver().query(uri, null, null, null, null);
        if (query == null) {
            return 0L;
        }
        try {
            query.moveToFirst();
            return query.getLong(query.getColumnIndex("_size"));
        } finally {
            query.close();
        }
    }

    public static long d(String str) {
        if (str != null && str.length() != 0) {
            try {
                Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(str);
                if (matcher.find()) {
                    return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                }
            } catch (Exception e2) {
                a("Util", "parse content-length from content-range failed " + e2);
            }
        }
        return -1L;
    }
}
