package com.ss.android.socialbase.downloader.i;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.depend.ah;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.l;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.tencent.smtt.sdk.TbsListener;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.internal.http2.StreamResetException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f {
    private static final String a = "f";
    private static final Pattern b = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");

    /* renamed from: c, reason: collision with root package name */
    private static String f875c = null;
    private static volatile SparseArray<Boolean> d = new SparseArray<>();
    private static volatile SparseArray<List<ah>> e = new SparseArray<>();
    private static final char[] f = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static Pattern g = null;
    private static Pattern h = null;
    private static ConnectivityManager i;
    private static Boolean j;
    private static Boolean k;

    public static double a(long j2) {
        return j2 / 1048576.0d;
    }

    public static String a(byte[] bArr) {
        Objects.requireNonNull(bArr, "bytes is null");
        return a(bArr, 0, bArr.length);
    }

    public static boolean a(int i2) {
        return i2 == 0 || i2 == 2;
    }

    public static long b(com.ss.android.socialbase.downloader.network.g gVar) {
        if (gVar == null) {
            return -1L;
        }
        String b2 = b(gVar, com.sigmob.sdk.downloader.core.c.f);
        if (TextUtils.isEmpty(b2)) {
            return -1L;
        }
        try {
            Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(b2);
            if (matcher.find()) {
                return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            }
        } catch (Exception e2) {
            com.ss.android.socialbase.downloader.c.a.d(a, "parse content-length from content-range failed ".concat(String.valueOf(e2)));
        }
        return -1L;
    }

    public static boolean b(long j2) {
        return j2 == -1;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.format("%s.tp", str);
    }

    public static boolean c(int i2) {
        return i2 == 200 || i2 == 201 || i2 == 0;
    }

    public static boolean d(int i2) {
        return i2 == 206 || i2 == 200;
    }

    public static boolean d(DownloadInfo downloadInfo) {
        boolean z = false;
        if (!downloadInfo.isDeleteCacheIfCheckFailed() && TextUtils.isEmpty(downloadInfo.getLastModified())) {
            com.ss.android.socialbase.downloader.c.a.b(a, "dcache::last modify is emtpy, so just return cache");
        } else {
            com.ss.android.socialbase.downloader.c.a.b(a, "dcache::curt=" + System.currentTimeMillis() + " expired=" + downloadInfo.getCacheExpiredTime());
            if (System.currentTimeMillis() > downloadInfo.getCacheExpiredTime()) {
                z = true;
            }
        }
        com.ss.android.socialbase.downloader.c.a.b(a, "cacheExpired::dcache::name=" + downloadInfo.getName() + " expired=" + z);
        return z;
    }

    public static String e(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes("UTF-8"));
                    return a(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String d2 = d(com.ss.android.socialbase.downloader.downloader.c.O());
        return d2 != null && d2.equals(str);
    }

    public static String g(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static boolean h(Throwable th) {
        if (th == null) {
            return false;
        }
        if (th instanceof BaseException) {
            BaseException baseException = (BaseException) th;
            int errorCode = baseException.getErrorCode();
            if (errorCode == 1006) {
                return true;
            }
            if (errorCode == 1023 || errorCode == 1039 || errorCode == 1040 || errorCode == 1054 || errorCode == 1064) {
                String message = baseException.getMessage();
                return !TextUtils.isEmpty(message) && message.contains("ENOSPC");
            }
        } else if (th instanceof IOException) {
            String j2 = j(th);
            if (!TextUtils.isEmpty(j2) && j2.contains("ENOSPC")) {
                return true;
            }
        }
        return false;
    }

    private static String i() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = bufferedReader.read();
                if (read <= 0) {
                    break;
                }
                sb.append((char) read);
            }
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.b("Process", "get processName = " + sb.toString());
            }
            String sb2 = sb.toString();
            a(bufferedReader);
            return sb2;
        } catch (Throwable unused2) {
            a(bufferedReader);
            return null;
        }
    }

    private static String j(String str) {
        Matcher matcher;
        if (str == null) {
            return null;
        }
        try {
            if (g == null) {
                g = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
            }
            matcher = g.matcher(str);
        } catch (Exception unused) {
        }
        if (matcher.find()) {
            return matcher.group(1);
        }
        if (h == null) {
            h = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
        }
        Matcher matcher2 = h.matcher(str);
        if (matcher2.find()) {
            return matcher2.group(1);
        }
        return null;
    }

    private static boolean k(String str) {
        String str2 = a;
        Log.w(str2, "deleteDirIfEmpty on thread: " + Thread.currentThread());
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.isDirectory()) {
                if (file.delete()) {
                    return true;
                }
                Log.w(str2, "deleteDirIfEmpty return false");
                return false;
            }
        }
        return false;
    }

    public static String a(byte[] bArr, int i2, int i3) {
        Objects.requireNonNull(bArr, "bytes is null");
        if (i2 >= 0 && i2 + i3 <= bArr.length) {
            int i4 = i3 * 2;
            char[] cArr = new char[i4];
            int i5 = 0;
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = bArr[i6 + i2] & 255;
                int i8 = i5 + 1;
                char[] cArr2 = f;
                cArr[i5] = cArr2[i7 >> 4];
                i5 = i8 + 1;
                cArr[i8] = cArr2[i7 & 15];
            }
            return new String(cArr, 0, i4);
        }
        throw new IndexOutOfBoundsException();
    }

    public static void c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            Log.e(a, "deleteFile: " + str + "/" + str2);
            file.delete();
        }
    }

    public static boolean f(Throwable th) {
        if (th == null) {
            return false;
        }
        String j2 = j(th);
        return !TextUtils.isEmpty(j2) && j2.contains("Requested Range Not Satisfiable");
    }

    public static long d(String str) {
        try {
            StatFs statFs = new StatFs(str);
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getAvailableBytes();
            }
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (IllegalArgumentException e2) {
            throw new BaseException(1050, e2);
        } catch (Throwable th) {
            throw new BaseException(1052, th);
        }
    }

    private static String e(Context context) {
        if (context == null) {
            return null;
        }
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        if (com.ss.android.socialbase.downloader.c.a.a()) {
                            com.ss.android.socialbase.downloader.c.a.b("Process", "processName = " + runningAppProcessInfo.processName);
                        }
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public static long f(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0L;
        }
        List<com.ss.android.socialbase.downloader.model.b> c2 = com.ss.android.socialbase.downloader.downloader.c.y().c(downloadInfo.getId());
        int chunkCount = downloadInfo.getChunkCount();
        boolean z = chunkCount > 1;
        if (!downloadInfo.isBreakpointAvailable()) {
            return 0L;
        }
        if (z) {
            if (c2 == null || chunkCount != c2.size()) {
                return 0L;
            }
            return b(c2);
        }
        return downloadInfo.getCurBytes();
    }

    public static boolean g(Throwable th) {
        return com.ss.android.socialbase.downloader.downloader.c.N().a(th);
    }

    private static String k() {
        String str;
        Throwable th;
        Object invoke;
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            invoke = declaredMethod.invoke(null, new Object[0]);
        } catch (Throwable th2) {
            str = null;
            th = th2;
        }
        if (!(invoke instanceof String)) {
            return null;
        }
        str = (String) invoke;
        try {
            if (!TextUtils.isEmpty(str) && com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.b("Process", "processName = ".concat(String.valueOf(str)));
            }
        } catch (Throwable th3) {
            th = th3;
            th.printStackTrace();
            return str;
        }
        return str;
    }

    public static boolean c(DownloadInfo downloadInfo) {
        return a(downloadInfo, downloadInfo.isForce(), downloadInfo.getMd5());
    }

    public static File g() {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (Exception unused) {
            str = "";
        }
        if ("mounted".equals(str)) {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        }
        return null;
    }

    public static long b(String str) {
        if (str == null) {
            return -1L;
        }
        String[] split = str.split("/");
        if (split.length >= 2) {
            try {
                return Long.parseLong(split[1]);
            } catch (NumberFormatException unused) {
                com.ss.android.socialbase.downloader.c.a.d(a, "parse instance length failed with ".concat(String.valueOf(str)));
            }
        }
        return -1L;
    }

    public static boolean c(String str, String str2, String str3) {
        return a(b(str, str2, str3));
    }

    public static boolean h(String str) {
        Context O;
        if (com.ss.android.socialbase.downloader.g.a.c().b("save_path_security") > 0 && (O = com.ss.android.socialbase.downloader.downloader.c.O()) != null && !TextUtils.isEmpty(str) && !str.startsWith("/data")) {
            if (!str.contains("Android/data/" + O.getPackageName())) {
                return false;
            }
        }
        return true;
    }

    public static boolean i(Throwable th) {
        if (!(th instanceof BaseException)) {
            return false;
        }
        int errorCode = ((BaseException) th).getErrorCode();
        return errorCode == 1055 || errorCode == 1023 || errorCode == 1041 || errorCode == 1022 || errorCode == 1048 || errorCode == 1056 || errorCode == 1057 || errorCode == 1058 || errorCode == 1059 || errorCode == 1060 || errorCode == 1061 || errorCode == 1067 || errorCode == 1049 || errorCode == 1047 || errorCode == 1051 || errorCode == 1004 || errorCode == 1011 || errorCode == 1002 || errorCode == 1013;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            try {
                bArr[i2] = (byte) (Integer.parseInt(str.substring(i3, i3 + 2), 16) & 255);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            return new String(bArr, "utf-8");
        } catch (Exception e3) {
            e3.printStackTrace();
            return str;
        }
    }

    public static boolean c(com.ss.android.socialbase.downloader.network.g gVar) {
        if (gVar == null) {
            return false;
        }
        return a.a(8) ? "chunked".equals(gVar.a(com.sigmob.sdk.downloader.core.c.h)) || a(gVar) == -1 : a(gVar) == -1;
    }

    private static String j() {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            String processName = Application.getProcessName();
            if (!TextUtils.isEmpty(processName) && com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.b("Process", "processName = ".concat(String.valueOf(processName)));
            }
            return processName;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean d(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return new File(str, str2).exists();
    }

    public static String f() {
        return a(Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.O()).getGlobalSaveTempDir(), false);
    }

    public static String b(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public static long i(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        Matcher matcher = Pattern.compile("max-age=([0-9]+)").matcher(str);
        if (!matcher.find()) {
            return 0L;
        }
        try {
            return Long.parseLong(matcher.group(1));
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public static boolean c(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager a2 = a(context);
            if (a2 == null || (activeNetworkInfo = a2.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean e(Throwable th) {
        if (th == null) {
            return false;
        }
        String j2 = j(th);
        return !TextUtils.isEmpty(j2) && j2.contains("Precondition Failed");
    }

    public static boolean h() {
        Context O = com.ss.android.socialbase.downloader.downloader.c.O();
        return (O == null || b(O) || !c(O)) ? false : true;
    }

    public static long b(List<com.ss.android.socialbase.downloader.model.b> list) {
        Iterator<com.ss.android.socialbase.downloader.model.b> it = list.iterator();
        long j2 = 0;
        while (it.hasNext()) {
            j2 += it.next().o();
        }
        return j2;
    }

    public static String d(Context context) {
        String str = f875c;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String j2 = j();
        f875c = j2;
        if (!TextUtils.isEmpty(j2)) {
            return f875c;
        }
        String k2 = k();
        f875c = k2;
        if (!TextUtils.isEmpty(k2)) {
            return f875c;
        }
        String e2 = e(context);
        f875c = e2;
        if (!TextUtils.isEmpty(e2)) {
            return f875c;
        }
        String i2 = i();
        f875c = i2;
        return i2;
    }

    public static com.ss.android.socialbase.downloader.constants.f e(int i2) {
        com.ss.android.socialbase.downloader.constants.f fVar = com.ss.android.socialbase.downloader.constants.f.MAIN;
        com.ss.android.socialbase.downloader.constants.f fVar2 = com.ss.android.socialbase.downloader.constants.f.SUB;
        if (i2 != fVar2.ordinal()) {
            fVar2 = com.ss.android.socialbase.downloader.constants.f.NOTIFICATION;
            if (i2 != fVar2.ordinal()) {
                return fVar;
            }
        }
        return fVar2;
    }

    public static String j(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            return th.toString();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "throwable getMsg error";
        }
    }

    public static void b(DownloadInfo downloadInfo) {
        com.ss.android.socialbase.downloader.g.a a2;
        JSONObject d2;
        if (downloadInfo == null || (d2 = (a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId())).d("download_dir")) == null) {
            return;
        }
        String optString = d2.optString("ins_desc");
        if (!TextUtils.isEmpty(optString)) {
            c(downloadInfo.getSavePath(), optString);
        }
        String title = downloadInfo.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = downloadInfo.getName();
        }
        String a3 = a(title, a2);
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(a3) || TextUtils.isEmpty(savePath)) {
            return;
        }
        File file = new File(a3);
        for (File file2 = new File(savePath); file != null && file2 != null && file2.isDirectory() && TextUtils.equals(file.getName(), file2.getName()); file2 = file2.getParentFile()) {
            k(file2.getPath());
            file = file.getParentFile();
        }
    }

    public static boolean c() {
        Boolean bool = k;
        if (bool != null) {
            return bool.booleanValue();
        }
        String d2 = d(com.ss.android.socialbase.downloader.downloader.c.O());
        if (d2 != null) {
            if (d2.equals(com.ss.android.socialbase.downloader.downloader.c.O().getPackageName() + ":downloader")) {
                k = Boolean.TRUE;
                return k.booleanValue();
            }
        }
        k = Boolean.FALSE;
        return k.booleanValue();
    }

    public static long a(com.ss.android.socialbase.downloader.network.g gVar) {
        if (gVar == null) {
            return -1L;
        }
        String b2 = b(gVar, com.sigmob.sdk.downloader.core.c.e);
        if (TextUtils.isEmpty(b2) && a.a(1)) {
            return b(gVar);
        }
        try {
            return Long.parseLong(b2);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static long e(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return -1L;
        }
        List<com.ss.android.socialbase.downloader.model.b> c2 = com.ss.android.socialbase.downloader.downloader.c.y().c(downloadInfo.getId());
        if (downloadInfo.getChunkCount() == 1) {
            return downloadInfo.getCurBytes();
        }
        if (c2 == null || c2.size() <= 1) {
            return 0L;
        }
        long d2 = d(c2);
        if (d2 >= 0) {
            return d2;
        }
        return 0L;
    }

    public static String a(com.ss.android.socialbase.downloader.network.g gVar, String str) {
        String j2 = j(gVar.a(com.sigmob.sdk.downloader.core.c.j));
        return TextUtils.isEmpty(j2) ? e(str) : j2;
    }

    public static boolean c(Throwable th) {
        if (th == null) {
            return false;
        }
        String j2 = j(th);
        return !TextUtils.isEmpty(j2) && j2.contains("network not available");
    }

    public static String e() {
        return a(Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.O()).getGlobalSaveDir(), true);
    }

    public static com.ss.android.socialbase.downloader.model.e a(DownloadInfo downloadInfo, String str, String str2, int i2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str, str2);
            boolean z = false;
            if (file.exists() && file.isDirectory()) {
                throw new BaseException(1035, new IOException(String.format("path is :%s, path is directory:%B:", str, Boolean.valueOf(file.isDirectory()))));
            }
            if (!file.exists()) {
                try {
                    File file2 = new File(str);
                    if (!file2.exists() || !file2.isDirectory()) {
                        if (!file2.exists()) {
                            if (!file2.mkdirs() && !file2.exists()) {
                                if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo).a("opt_mkdir_failed", 0) != 1) {
                                    throw new BaseException(1030, "download savePath directory can not created:" + str);
                                }
                                int i3 = 0;
                                while (!z) {
                                    int i4 = i3 + 1;
                                    if (i3 >= 3) {
                                        break;
                                    }
                                    try {
                                        Thread.sleep(10L);
                                        z = file2.mkdirs();
                                        i3 = i4;
                                    } catch (InterruptedException unused) {
                                    }
                                }
                                if (!z) {
                                    if (d(downloadInfo.getSavePath()) < 16384) {
                                        throw new BaseException(1006, "download savePath directory can not created:" + str);
                                    }
                                    throw new BaseException(1030, "download savePath directory can not created:" + str);
                                }
                            }
                        } else {
                            file2.delete();
                            if (!file2.mkdirs() && !file2.exists()) {
                                throw new BaseException(1031, "download savePath is not directory:path=" + str);
                            }
                            throw new BaseException(1031, "download savePath is not directory:" + str);
                        }
                    }
                    file.createNewFile();
                } catch (IOException e2) {
                    throw new BaseException(1036, e2);
                }
            }
            return new com.ss.android.socialbase.downloader.model.e(file, i2);
        }
        throw new BaseException(1021, new IOException("path must be not empty"));
    }

    public static boolean c(BaseException baseException) {
        if (baseException == null) {
            return false;
        }
        if (baseException.getErrorCode() != 1011) {
            return baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException);
        }
        return true;
    }

    public static String e(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String e2 = e(str2);
        return (TextUtils.isEmpty(e2) || str.contains(e2)) ? str : new File(str, e2).getAbsolutePath();
    }

    private static void c(Throwable th, String str) {
        com.ss.android.socialbase.downloader.exception.g a2 = com.ss.android.socialbase.downloader.downloader.c.N().a(th, null);
        if (a2 == null) {
            a2 = com.ss.android.socialbase.downloader.downloader.c.N().a(th.getCause(), null);
        }
        if (a2 == null) {
            return;
        }
        throw new com.ss.android.socialbase.downloader.exception.g(a2.getErrorCode(), b(a2, str)).a(a2.a());
    }

    public static boolean d() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static boolean d(Throwable th) {
        if (th == null) {
            return false;
        }
        String j2 = j(th);
        return !TextUtils.isEmpty(j2) && j2.contains("Exception in connect");
    }

    private static long d(List<com.ss.android.socialbase.downloader.model.b> list) {
        if (list == null || list.isEmpty()) {
            return -1L;
        }
        long j2 = -1;
        for (com.ss.android.socialbase.downloader.model.b bVar : list) {
            if (bVar != null && (bVar.n() <= bVar.p() || bVar.p() == 0)) {
                if (j2 == -1 || j2 > bVar.n()) {
                    j2 = bVar.n();
                }
            }
        }
        return j2;
    }

    public static long c(long j2) {
        return System.currentTimeMillis() - j2;
    }

    public static boolean c(List<com.ss.android.socialbase.downloader.model.c> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (com.ss.android.socialbase.downloader.model.c cVar : list) {
            if (cVar != null && !TextUtils.isEmpty(cVar.a()) && !TextUtils.isEmpty(cVar.b()) && "download-tc21-1-15".equals(cVar.a()) && "download-tc21-1-15".equals(cVar.b())) {
                return true;
            }
        }
        return false;
    }

    public static int b(String str, String str2, String str3) {
        return com.ss.android.a.c.a(str3, new File(str, str2));
    }

    public static String b(int i2) {
        String str = "ttmd5 check code = " + i2 + ", ";
        if (i2 != 99) {
            switch (i2) {
                case 0:
                    return str + "md5 match";
                case 1:
                    return str + "md5 not match";
                case 2:
                    return str + "md5 empty";
                case 3:
                    return str + "ttmd5 version not support";
                case 4:
                    return str + "ttmd5 tag parser error";
                case 5:
                    return str + "file not exist";
                case 6:
                    return str + "get file md5 error";
                default:
                    return str;
            }
        }
        return str + "unknown error";
    }

    @TargetApi(19)
    private static void b(File file, File file2, boolean z) {
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileChannel channel = fileInputStream.getChannel();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    FileChannel channel2 = fileOutputStream.getChannel();
                    try {
                        long size = channel.size();
                        long j2 = 0;
                        while (j2 < size) {
                            long j3 = size - j2;
                            long transferFrom = channel2.transferFrom(channel, j2, j3 > 31457280 ? 31457280L : j3);
                            if (transferFrom == 0) {
                                break;
                            } else {
                                j2 += transferFrom;
                            }
                        }
                        if (channel2 != null) {
                            channel2.close();
                        }
                        fileOutputStream.close();
                        if (channel != null) {
                            channel.close();
                        }
                        fileInputStream.close();
                        long length = file.length();
                        long length2 = file2.length();
                        if (length == length2) {
                            if (z) {
                                file2.setLastModified(file.lastModified());
                                return;
                            }
                            return;
                        }
                        throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + length + " Actual: " + length2);
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    public static List<com.ss.android.socialbase.downloader.model.b> a(List<com.ss.android.socialbase.downloader.model.b> list) {
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray2 = new SparseArray();
        for (com.ss.android.socialbase.downloader.model.b bVar : list) {
            if (bVar != null) {
                if (bVar.d()) {
                    sparseArray.put(bVar.s(), bVar);
                    List<com.ss.android.socialbase.downloader.model.b> list2 = (List) sparseArray2.get(bVar.s());
                    if (list2 != null) {
                        Iterator<com.ss.android.socialbase.downloader.model.b> it = list2.iterator();
                        while (it.hasNext()) {
                            it.next().a(bVar);
                        }
                        bVar.a(list2);
                    }
                } else {
                    com.ss.android.socialbase.downloader.model.b bVar2 = (com.ss.android.socialbase.downloader.model.b) sparseArray.get(bVar.b());
                    if (bVar2 != null) {
                        List<com.ss.android.socialbase.downloader.model.b> g2 = bVar2.g();
                        if (g2 == null) {
                            g2 = new ArrayList<>();
                            bVar2.a(g2);
                        }
                        bVar.a(bVar2);
                        g2.add(bVar);
                    } else {
                        List list3 = (List) sparseArray2.get(bVar.b());
                        if (list3 == null) {
                            list3 = new ArrayList();
                            sparseArray2.put(bVar.b(), list3);
                        }
                        list3.add(bVar);
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i2)));
        }
        return arrayList.isEmpty() ? list : arrayList;
    }

    public static boolean b(File file, File file2) {
        String str = a;
        Log.e(str, "moveFile1: src:" + file.getPath() + " dest:" + file2.getPath());
        boolean renameTo = file.renameTo(file2);
        if (!renameTo) {
            renameTo = a(file, file2);
            try {
                Log.e(str, "moveFile2: src:" + file.getPath() + " dest:" + file2.getPath());
                file.delete();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return renameTo;
    }

    public static boolean b(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager a2 = a(context);
            if (a2 != null && (activeNetworkInfo = a2.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                if (1 == activeNetworkInfo.getType()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return String.format("%s%s%s", str, File.separator, str2);
    }

    public static String a(String str, String str2, String str3) {
        String a2;
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (!TextUtils.isEmpty(str2)) {
            a2 = a(str2, str3);
        } else {
            a2 = a(str, str3);
        }
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        return String.format("%s.tp", a2);
    }

    public static boolean b() {
        return !c() && com.ss.android.socialbase.downloader.downloader.c.c() && l.a(true).h();
    }

    public static boolean b(Throwable th) {
        com.ss.android.socialbase.downloader.exception.b bVar;
        if (th == null) {
            return false;
        }
        String j2 = j(th);
        if (!(th instanceof com.ss.android.socialbase.downloader.exception.b) || (((bVar = (com.ss.android.socialbase.downloader.exception.b) th) == null || bVar.a() != 403) && (TextUtils.isEmpty(j2) || !j2.contains("403")))) {
            return !TextUtils.isEmpty(j2) && j2.contains("Forbidden");
        }
        return true;
    }

    public static void a(DownloadInfo downloadInfo) {
        a(downloadInfo, true);
    }

    public static void a(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (z) {
            try {
                c(downloadInfo.getSavePath(), downloadInfo.getName());
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        c(downloadInfo.getTempPath(), downloadInfo.getTempName());
        if (downloadInfo.isSavePathRedirected()) {
            b(downloadInfo);
        }
        if (z) {
            String e2 = e(downloadInfo.getUrl());
            if (TextUtils.isEmpty(e2) || TextUtils.isEmpty(downloadInfo.getSavePath()) || !downloadInfo.getSavePath().contains(e2)) {
                return;
            }
            k(downloadInfo.getSavePath());
        }
    }

    public static boolean b(BaseException baseException) {
        if (!(baseException instanceof com.ss.android.socialbase.downloader.exception.b)) {
            return false;
        }
        com.ss.android.socialbase.downloader.exception.b bVar = (com.ss.android.socialbase.downloader.exception.b) baseException;
        return bVar.a() == 412 || bVar.a() == 416;
    }

    public static String b(Throwable th, String str) {
        if (str == null) {
            return j(th);
        }
        return str + "-" + j(th);
    }

    public static void b(List<com.ss.android.socialbase.downloader.model.c> list, DownloadInfo downloadInfo) {
        long ttnetProtectTimeout = downloadInfo.getTtnetProtectTimeout();
        if (ttnetProtectTimeout > 300) {
            list.add(new com.ss.android.socialbase.downloader.model.c("extra_ttnet_protect_timeout", String.valueOf(ttnetProtectTimeout)));
        }
    }

    public static String b(com.ss.android.socialbase.downloader.network.g gVar, String str) {
        if (gVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String a2 = gVar.a(str);
        if (!com.ss.android.socialbase.downloader.g.a.c().b("fix_get_http_resp_head_ignore_case", true)) {
            return a2;
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = gVar.a(str.toLowerCase());
        }
        return TextUtils.isEmpty(a2) ? gVar.a(str.toUpperCase()) : a2;
    }

    public static boolean a(Context context, String str) {
        return (context == null || TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) != 0) ? false : true;
    }

    public static boolean a(DownloadInfo downloadInfo, boolean z, String str) {
        if (!z && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            try {
                if (new File(downloadInfo.getSavePath(), downloadInfo.getName()).exists()) {
                    if (c(downloadInfo.getSavePath(), downloadInfo.getName(), str)) {
                        return true;
                    }
                }
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static boolean b(BaseException baseException, DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.isOnlyWifi() && c(com.ss.android.socialbase.downloader.downloader.c.O());
    }

    public static int a(File file, String str) {
        return com.ss.android.a.c.a(str, file);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0193 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(com.ss.android.socialbase.downloader.model.DownloadInfo r18, com.ss.android.socialbase.downloader.depend.x r19, com.ss.android.socialbase.downloader.depend.ah r20) {
        /*
            Method dump skipped, instructions count: 610
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.i.f.a(com.ss.android.socialbase.downloader.model.DownloadInfo, com.ss.android.socialbase.downloader.depend.x, com.ss.android.socialbase.downloader.depend.ah):void");
    }

    private static void a(int i2, boolean z, BaseException baseException) {
        synchronized (d) {
            List<ah> list = e.get(i2);
            if (list != null) {
                for (ah ahVar : list) {
                    if (ahVar != null) {
                        if (z) {
                            ahVar.a();
                        } else {
                            ahVar.a(baseException);
                        }
                    }
                }
            }
            com.ss.android.socialbase.downloader.c.a.b(a, "handleTempSaveCallback id:".concat(String.valueOf(i2)));
            d.remove(i2);
        }
    }

    public static void a(DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null || TextUtils.isEmpty(str) || str.equals(downloadInfo.getName())) {
            return;
        }
        File file = new File(downloadInfo.getSavePath(), str);
        File file2 = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        Log.e(a, "copyFileFromExistFileWithSameName: existFile:" + file.getPath() + " targetFile:" + file2.getPath());
        if (file2.exists() && !file2.canWrite()) {
            throw new BaseException(1001, "targetPath file exists but read-only");
        }
        if (!a(file, file2)) {
            throw new BaseException(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", downloadInfo.getSavePath(), str, downloadInfo.getSavePath(), downloadInfo.getName()));
        }
    }

    public static boolean a(File file, File file2) {
        return a(file, file2, true);
    }

    public static boolean a(File file, File file2, boolean z) {
        if (file != null && file2 != null) {
            try {
                if (file.exists() && !file.isDirectory() && !file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    File parentFile = file2.getParentFile();
                    if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                        throw new BaseException(1053, "Destination '" + parentFile + "' directory cannot be created");
                    }
                    Log.e(a, "copyFile: srcFile:" + file.getPath() + " destFile:" + file2.getPath());
                    if (file2.exists() && !file2.canWrite()) {
                        throw new IOException("Destination '" + file2 + "' exists but is read-only");
                    }
                    b(file, file2, z);
                    return true;
                }
            } catch (BaseException e2) {
                throw e2;
            } catch (Throwable th) {
                a(th, "CopyFile");
                return false;
            }
        }
        return false;
    }

    public static boolean a(int i2, String str) {
        if (a.a(16777216)) {
            return i2 == 206 || i2 == 1;
        }
        if (i2 >= 400) {
            return false;
        }
        return i2 == 206 || i2 == 1 || "bytes".equals(str);
    }

    public static List<com.ss.android.socialbase.downloader.model.c> a(List<com.ss.android.socialbase.downloader.model.c> list, String str, com.ss.android.socialbase.downloader.model.b bVar) {
        return a(list, str, bVar.m(), bVar.p());
    }

    public static List<com.ss.android.socialbase.downloader.model.c> a(List<com.ss.android.socialbase.downloader.model.c> list, String str, long j2, long j3) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                if (cVar != null) {
                    arrayList.add(cVar);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new com.ss.android.socialbase.downloader.model.c(com.sigmob.sdk.downloader.core.c.f508c, str));
        }
        arrayList.add(new com.ss.android.socialbase.downloader.model.c("Accept-Encoding", "identity"));
        String format = j3 <= 0 ? String.format("bytes=%s-", String.valueOf(j2)) : String.format("bytes=%s-%s", String.valueOf(j2), String.valueOf(j3));
        arrayList.add(new com.ss.android.socialbase.downloader.model.c(com.sigmob.sdk.downloader.core.c.b, format));
        com.ss.android.socialbase.downloader.c.a.b(a, " range CurrentOffset:" + j2 + " EndOffset:" + j3 + ", range = " + format);
        return arrayList;
    }

    public static boolean a(int i2, String str, String str2) {
        return i2 == -3 && !d(str, str2);
    }

    public static ConnectivityManager a(Context context) {
        ConnectivityManager connectivityManager = i;
        if (connectivityManager != null) {
            return connectivityManager;
        }
        ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
        i = connectivityManager2;
        return connectivityManager2;
    }

    public static boolean a() {
        Boolean bool = j;
        if (bool != null) {
            return bool.booleanValue();
        }
        String d2 = d(com.ss.android.socialbase.downloader.downloader.c.O());
        Boolean valueOf = Boolean.valueOf((d2 == null || !d2.contains(":")) && d2 != null && d2.equals(com.ss.android.socialbase.downloader.downloader.c.O().getPackageName()));
        j = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean a(Throwable th) {
        if (th == null) {
            return false;
        }
        String j2 = j(th);
        if (th instanceof SocketTimeoutException) {
            return true;
        }
        return !TextUtils.isEmpty(j2) && (j2.contains("time out") || j2.contains("Time-out"));
    }

    public static boolean a(BaseException baseException) {
        return baseException != null && baseException.getErrorCode() == 1051;
    }

    public static void a(Throwable th, String str) {
        String str2 = !TextUtils.isEmpty(str) ? str : "";
        if (!(th instanceof BaseException)) {
            if (!(th instanceof SSLHandshakeException)) {
                if (!a(th)) {
                    if (!e(th)) {
                        if (!f(th)) {
                            if (!b(th)) {
                                if (!c(th)) {
                                    if (!d(th)) {
                                        if (th instanceof IOException) {
                                            c(th, str);
                                            a((IOException) th, str);
                                            return;
                                        }
                                        throw new BaseException(1000, b(th, str2));
                                    }
                                    throw new BaseException(1041, b(th, str2));
                                }
                                throw new BaseException(1049, b(th, str2));
                            }
                            throw new BaseException(1047, b(th, str2));
                        }
                        throw new com.ss.android.socialbase.downloader.exception.b(1004, 416, b(th, str2));
                    }
                    throw new com.ss.android.socialbase.downloader.exception.b(1004, TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX, b(th, str2));
                }
                throw new BaseException(1048, b(th, str2));
            }
            throw new BaseException(1011, b(th, str2));
        }
        BaseException baseException = (BaseException) th;
        baseException.setErrorMsg(str2 + "-" + baseException.getErrorMessage());
        throw baseException;
    }

    public static void a(IOException iOException, String str) {
        if (str == null) {
            str = "";
        }
        String b2 = b(iOException, str);
        if (!(iOException instanceof ConnectException)) {
            if (!(iOException instanceof UnknownHostException)) {
                if (!(iOException instanceof NoRouteToHostException)) {
                    if (!(iOException instanceof UnknownServiceException)) {
                        if (!(iOException instanceof PortUnreachableException)) {
                            if (!(iOException instanceof SocketTimeoutException)) {
                                if (!(iOException instanceof SocketException)) {
                                    if (!(iOException instanceof HttpRetryException)) {
                                        if (!(iOException instanceof ProtocolException)) {
                                            if (!(iOException instanceof MalformedURLException)) {
                                                if (!(iOException instanceof FileNotFoundException)) {
                                                    if (!(iOException instanceof InterruptedIOException)) {
                                                        if (!(iOException instanceof UnsupportedEncodingException)) {
                                                            if (!(iOException instanceof EOFException)) {
                                                                if (!(iOException instanceof StreamResetException)) {
                                                                    if (!(iOException instanceof SSLException)) {
                                                                        if (h(iOException)) {
                                                                            throw new BaseException(1006, b2);
                                                                        }
                                                                        throw new BaseException(1023, b2);
                                                                    }
                                                                    throw new BaseException(1011, b2);
                                                                }
                                                                throw new BaseException(1067, b2);
                                                            }
                                                            throw new BaseException(1066, b2);
                                                        }
                                                        throw new BaseException(1065, b2);
                                                    }
                                                    throw new BaseException(1064, b2);
                                                }
                                                throw new BaseException(1063, b2);
                                            }
                                            throw new BaseException(1062, b2);
                                        }
                                        throw new BaseException(1061, b2);
                                    }
                                    throw new BaseException(1060, b2);
                                }
                                throw new BaseException(1059, b2);
                            }
                            throw new BaseException(1048, b2);
                        }
                        throw new BaseException(1058, b2);
                    }
                    throw new BaseException(1057, b2);
                }
                throw new BaseException(1056, b2);
            }
            throw new BaseException(1055, b2);
        }
        throw new BaseException(1041, b2);
    }

    public static boolean a(BaseException baseException, DownloadInfo downloadInfo) {
        if (baseException == null) {
            return false;
        }
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1000 || errorCode == 1032 || errorCode == 1033 || errorCode == 1034 || errorCode == 1008 || errorCode == 1026 || errorCode == 1027 || errorCode == 1044 || errorCode == 1020) {
            return true;
        }
        return (errorCode == 1049 || errorCode == 1055 || errorCode == 1006 || downloadInfo == null || downloadInfo.getCurBytes() >= 8388608) ? false : true;
    }

    public static <K> HashMap<Integer, K> a(SparseArray<K> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        HashMap<Integer, K> hashMap = new HashMap<>();
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            int keyAt = sparseArray.keyAt(i2);
            hashMap.put(Integer.valueOf(keyAt), sparseArray.valueAt(i2));
        }
        return hashMap;
    }

    public static <K> void a(SparseArray<K> sparseArray, Map<Integer, K> map) {
        if (map == null || sparseArray == null) {
            return;
        }
        for (Integer num : map.keySet()) {
            if (num != null) {
                sparseArray.put(num.intValue(), map.get(num));
            }
        }
    }

    public static boolean a(List<com.ss.android.socialbase.downloader.model.c> list, List<com.ss.android.socialbase.downloader.model.c> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        return new HashSet(list).equals(new HashSet(list2));
    }

    public static void a(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void a(Cursor... cursorArr) {
        if (cursorArr == null) {
            return;
        }
        for (Cursor cursor : cursorArr) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static String a(String str, int i2) {
        return i2 == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i2) ? str : str.substring(0, i2);
    }

    public static String a(String str, com.ss.android.socialbase.downloader.g.a aVar) {
        JSONObject d2;
        String format;
        if (aVar == null || (d2 = aVar.d("download_dir")) == null) {
            return "";
        }
        String optString = d2.optString("dir_name");
        if (!TextUtils.isEmpty(optString) && optString.startsWith("/")) {
            optString = optString.substring(1);
        }
        if (TextUtils.isEmpty(optString)) {
            return optString;
        }
        if (!optString.contains("%s")) {
            format = optString + str;
        } else {
            try {
                format = String.format(optString, str);
            } catch (Throwable unused) {
            }
        }
        optString = format;
        return optString.length() > 255 ? optString.substring(optString.length() - 255) : optString;
    }

    private static String a(File file, boolean z) {
        Context O = com.ss.android.socialbase.downloader.downloader.c.O();
        if (a(file)) {
            return file.getAbsolutePath();
        }
        int i2 = O.getApplicationInfo().targetSdkVersion;
        if (Build.VERSION.SDK_INT >= 29 && ((i2 == 29 && !Environment.isExternalStorageLegacy()) || i2 > 29)) {
            if (com.ss.android.socialbase.downloader.g.a.c().b("fix_save_external_dir") <= 0) {
                File externalFilesDir = O.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
                if (a(externalFilesDir)) {
                    return externalFilesDir.getAbsolutePath();
                }
            }
        } else {
            if (z) {
                File g2 = g();
                if (a(g2)) {
                    return g2.getAbsolutePath();
                }
            }
            if (com.ss.android.socialbase.downloader.g.a.c().b("fix_save_external_dir") <= 0) {
                File externalFilesDir2 = O.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
                if (a(externalFilesDir2)) {
                    return externalFilesDir2.getAbsolutePath();
                }
            }
        }
        return O.getFilesDir().getAbsolutePath();
    }

    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.exists() || file.mkdirs()) {
                return file.isDirectory();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void a(List<com.ss.android.socialbase.downloader.model.c> list, DownloadInfo downloadInfo) {
        long throttleNetSpeed = downloadInfo.getThrottleNetSpeed();
        if (throttleNetSpeed > 0) {
            list.add(new com.ss.android.socialbase.downloader.model.c("extra_throttle_net_speed", String.valueOf(throttleNetSpeed)));
        }
    }

    public static int a(Object obj, int i2) {
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException unused) {
            return i2;
        }
    }

    public static String a(Object obj, String str) {
        try {
            return (String) obj;
        } catch (ClassCastException unused) {
            return str;
        }
    }

    public static boolean a(Object obj, boolean z) {
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException unused) {
            return z;
        }
    }
}
