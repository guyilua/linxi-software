package com.sigmob.sdk.base.common;

import android.app.DownloadManager;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.q;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.windad.WindAds;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class p {
    private static Map<String, String> a = new Hashtable();
    private static Set<a> b = new CopyOnWriteArraySet();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        String a;
        String b;

        /* renamed from: c, reason: collision with root package name */
        long f394c;

        public a(String str, String str2, long j) {
            this.a = str;
            this.b = str2;
            this.f394c = j;
        }

        public String a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }

        public long c() {
            return this.f394c;
        }
    }

    public static DownloadManager a() {
        Context e = com.sigmob.sdk.b.e();
        if (e != null) {
            return (DownloadManager) e.getSystemService("download");
        }
        return null;
    }

    public static String a(File file) {
        String name = file.getName();
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(name.substring(name.lastIndexOf(".") + 1, name.length()).toLowerCase());
    }

    private static String a(List<String> list, String str) {
        String str2;
        StringBuilder sb;
        if (!list.contains(str)) {
            return str;
        }
        Integer valueOf = Integer.valueOf(str.lastIndexOf("."));
        String str3 = "";
        if (valueOf.intValue() != -1) {
            str3 = str.substring(0, valueOf.intValue());
            str2 = str.substring(valueOf.intValue());
        } else {
            str2 = "";
        }
        Integer valueOf2 = Integer.valueOf(str3.lastIndexOf("("));
        if (valueOf2.intValue() == -1) {
            sb = new StringBuilder();
        } else {
            Integer valueOf3 = Integer.valueOf(str3.indexOf(")", valueOf2.intValue()));
            if (valueOf3.intValue() == -1) {
                sb = new StringBuilder();
            } else if (valueOf3.intValue() < str3.length() - 1) {
                sb = new StringBuilder();
            } else {
                try {
                    return a(list, str3.substring(0, valueOf2.intValue()) + "(" + Integer.valueOf(Integer.parseInt(str3.substring(valueOf2.intValue() + 1, valueOf3.intValue())) + 1) + ")" + str2);
                } catch (Throwable unused) {
                    sb = new StringBuilder();
                }
            }
        }
        sb.append(str3);
        sb.append("(1)");
        sb.append(str2);
        return a(list, sb.toString());
    }

    public static Map<String, Object> a(long j) {
        Cursor cursor;
        try {
            DownloadManager a2 = a();
            if (a2 != null) {
                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterById(j);
                Uri uriForDownloadedFile = a2.getUriForDownloadedFile(j);
                cursor = a2.query(query);
                try {
                    if (!cursor.moveToFirst()) {
                        cursor.close();
                        return null;
                    }
                    int i = cursor.getInt(cursor.getColumnIndexOrThrow("status"));
                    int i2 = cursor.getInt(cursor.getColumnIndexOrThrow("reason"));
                    String string = cursor.getString(cursor.getColumnIndexOrThrow("local_uri"));
                    HashMap hashMap = new HashMap();
                    hashMap.put("fileName", string);
                    hashMap.put("status", Integer.valueOf(i));
                    hashMap.put("uri", uriForDownloadedFile);
                    hashMap.put("reason", Integer.valueOf(i2));
                    cursor.close();
                    return hashMap;
                } catch (Throwable th) {
                    th = th;
                    try {
                        SigmobLog.e(th.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        return null;
    }

    private static void a(Context context, BaseAdUnit baseAdUnit, final String str, final File file) {
        if (baseAdUnit.isRecord()) {
            ae.a("download_start", "1", baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.p.1
                @Override // com.sigmob.sdk.base.common.ae.a
                public void a(Object obj) {
                    if (obj instanceof PointEntitySigmob) {
                        PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                        pointEntitySigmob.setFinal_url(str);
                        HashMap hashMap = new HashMap();
                        hashMap.put("apkfile", file.getAbsolutePath());
                        hashMap.put("apkurl", str);
                        pointEntitySigmob.setOptions(hashMap);
                    }
                }
            });
        }
        HashMap hashMap = new HashMap();
        hashMap.put("result", "1");
        hashMap.put("downloadId", baseAdUnit.getDownloadId());
        BaseBroadcastReceiver.a(context, baseAdUnit.getUuid(), hashMap, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.Context r10, final java.lang.String r11, com.sigmob.sdk.base.models.BaseAdUnit r12) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.p.a(android.content.Context, java.lang.String, com.sigmob.sdk.base.models.BaseAdUnit):void");
    }

    public static void a(final String str, final BaseAdUnit baseAdUnit) {
        String str2;
        final Context e = com.sigmob.sdk.b.e();
        try {
            ae.a(PointCategory.APK_CLICK, "download", baseAdUnit);
            SigmobLog.i("download apk:" + str);
            h.a(baseAdUnit);
            String apkMd5 = baseAdUnit.getApkMd5();
            if (TextUtils.isEmpty(apkMd5)) {
                str2 = Md5Util.md5(str) + ".apk";
            } else {
                str2 = apkMd5 + ".apk";
                final File file = new File(com.sigmob.sdk.base.utils.e.a(e.getApplicationContext()), str2);
                boolean exists = file.exists();
                boolean b2 = baseAdUnit.getApkDownloadType() != 0 ? com.sigmob.sdk.downloader.l.b(str, com.sigmob.sdk.base.utils.e.a(e.getApplicationContext()).getAbsolutePath(), str2) : true;
                if (exists && b2 && baseAdUnit.canUseDownloadApk() && b(file)) {
                    baseAdUnit.setApkName(str2);
                    if (baseAdUnit.getDownloadId() == null) {
                        ae.b(PointCategory.EXIT_APK_INSTALL, "", baseAdUnit);
                    }
                    WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.base.common.p.8
                        @Override // java.lang.Runnable
                        public void run() {
                            p.a(e, file.getAbsolutePath(), baseAdUnit);
                        }
                    });
                    return;
                }
            }
            baseAdUnit.setApkName(str2);
            baseAdUnit.setDownloadUrl(str);
            int apkDownloadType = baseAdUnit.getApkDownloadType();
            if (apkDownloadType == 0) {
                a(str2, str, baseAdUnit);
                return;
            }
            if (apkDownloadType == 1) {
                n.a(str, baseAdUnit, false);
                return;
            }
            if (apkDownloadType == 2) {
                n.a(str, baseAdUnit, true);
                return;
            }
            SigmobLog.e("not support Download Type: " + apkDownloadType);
            throw new Exception("not support Download Type: " + apkDownloadType);
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            if (baseAdUnit.isRecord()) {
                ae.a("download_start", "0", baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.p.9
                    @Override // com.sigmob.sdk.base.common.ae.a
                    public void a(Object obj) {
                        if (obj instanceof PointEntitySigmob) {
                            ((PointEntitySigmob) obj).setFinal_url(str);
                        }
                    }
                });
                ae.a("download_start", 0, th.getMessage(), baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.p.10
                    @Override // com.sigmob.sdk.base.common.ae.a
                    public void a(Object obj) {
                        if (obj instanceof PointEntitySigmobError) {
                            ((PointEntitySigmobError) obj).setFinal_url(str);
                        }
                    }
                });
            }
            try {
                aj.a(e, "下载失败", 1).show();
            } catch (Throwable th2) {
                SigmobLog.e(th2.getMessage());
            }
        }
    }

    private static void a(String str, final String str2, BaseAdUnit baseAdUnit) {
        String str3;
        Context e = com.sigmob.sdk.b.e();
        try {
            String str4 = TextUtils.isEmpty(str) ? Md5Util.md5(baseAdUnit.getLanding_page()) + ".apk" : str;
            final File file = new File(com.sigmob.sdk.base.utils.e.a(e), str4);
            Long c2 = c(-1L, file.getAbsolutePath());
            if (c2 != null && c2.longValue() > 0) {
                try {
                    aj.a(e, "正在下载", 1).show();
                    if (baseAdUnit.getDownloadId() == null) {
                        baseAdUnit.setDownloadId(c2);
                        File file2 = new File(com.sigmob.sdk.base.utils.e.g(), c2 + ".log");
                        if (file2.exists()) {
                            file2.delete();
                        }
                        FileUtil.writeToCache(baseAdUnit, file2.getAbsolutePath());
                        a(e, baseAdUnit, str2, file);
                        return;
                    }
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            HashMap<String, Object> b2 = b();
            if (b2 != null) {
                for (String str5 : b2.keySet()) {
                    if (!TextUtils.isEmpty(str5) && str5.equals(file.getAbsolutePath())) {
                        try {
                            aj.a(e, "正在下载", 1).show();
                        } catch (Throwable unused2) {
                        }
                        try {
                            Object obj = b2.get(str5);
                            if (obj instanceof Long) {
                                baseAdUnit.setDownloadId((Long) obj);
                                File file3 = new File(com.sigmob.sdk.base.utils.e.g(), c2 + ".log");
                                if (file3.exists()) {
                                    file3.delete();
                                }
                                FileUtil.writeToCache(baseAdUnit, file3.getAbsolutePath());
                                a(e, baseAdUnit, str2, file);
                                return;
                            }
                            return;
                        } catch (Throwable unused3) {
                            return;
                        }
                    }
                }
            }
            boolean containsKey = a.containsKey(baseAdUnit.getUuid());
            if (file.exists() && !containsKey && !a(e, file.getAbsolutePath())) {
                SigmobLog.i("cacheFile deleteFile:" + FileUtil.deleteFile(file.getAbsolutePath()));
            }
            SigmobLog.i(str4 + " exists:" + file.exists() + " containsKey:" + containsKey);
            if (file.exists()) {
                if (containsKey) {
                    a(e, file.getAbsolutePath(), baseAdUnit);
                    return;
                }
                long lastModified = file.lastModified();
                if (com.sigmob.sdk.base.l.a().S() == 0) {
                    str3 = "default deleteFile:" + FileUtil.deleteFile(file.getAbsolutePath());
                } else {
                    if (System.currentTimeMillis() - lastModified <= r9 * 1000) {
                        a(e, file.getAbsolutePath(), baseAdUnit);
                        return;
                    }
                    str3 = "timeOut deleteFile:" + FileUtil.deleteFile(file.getAbsolutePath());
                }
                SigmobLog.i(str3);
            }
            a.put(baseAdUnit.getUuid(), str4);
            String appName = baseAdUnit.getAppName();
            if (TextUtils.isEmpty(appName)) {
                appName = file.getName();
            }
            long b3 = b(str2, file.getAbsolutePath(), appName);
            if (b3 >= 0) {
                try {
                    aj.a(e, "已开始下载，可在通知栏尝试取消", 1).show();
                } catch (Throwable th) {
                    SigmobLog.e(th.getMessage());
                }
                a(b3, file.getAbsolutePath());
                File file4 = new File(com.sigmob.sdk.base.utils.e.g(), b3 + ".log");
                baseAdUnit.setDownloadId(Long.valueOf(b3));
                FileUtil.writeToCache(baseAdUnit, file4.getAbsolutePath());
                a(e, baseAdUnit, str2, file);
            } else {
                if (baseAdUnit.isRecord()) {
                    ae.a("download_start", "0", baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.p.4
                        @Override // com.sigmob.sdk.base.common.ae.a
                        public void a(Object obj2) {
                            if (obj2 instanceof PointEntitySigmob) {
                                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj2;
                                pointEntitySigmob.setFinal_url(str2);
                                HashMap hashMap = new HashMap();
                                hashMap.put("apkfile", file.getAbsolutePath());
                                hashMap.put("apkurl", str2);
                                pointEntitySigmob.setOptions(hashMap);
                            }
                        }
                    });
                    ae.a(PointCategory.DOWNLOAD_FAILED, (int) b3, "下载失败,错误码 " + b3, baseAdUnit);
                }
                aj.a(e, "下载失败,错误码 " + b3, 0).show();
                HashMap hashMap = new HashMap();
                hashMap.put("result", "0");
                hashMap.put("downloadId", -1);
                BaseBroadcastReceiver.a(e, baseAdUnit.getUuid(), hashMap, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START);
            }
            if (baseAdUnit.isRecord()) {
                com.sigmob.sdk.base.network.g.a(baseAdUnit, "download_start");
            }
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
            if (baseAdUnit.isRecord()) {
                ae.a("download_start", "0", baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.p.5
                    @Override // com.sigmob.sdk.base.common.ae.a
                    public void a(Object obj2) {
                        if (obj2 instanceof PointEntitySigmob) {
                            ((PointEntitySigmob) obj2).setFinal_url(str2);
                        }
                    }
                });
                ae.a("download_start", 0, th2.getMessage(), baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.p.6
                    @Override // com.sigmob.sdk.base.common.ae.a
                    public void a(Object obj2) {
                        if (obj2 instanceof PointEntitySigmobError) {
                            ((PointEntitySigmobError) obj2).setFinal_url(str2);
                        }
                    }
                });
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("result", "0");
            hashMap2.put("downloadId", -1);
            BaseBroadcastReceiver.a(e, baseAdUnit.getUuid(), hashMap2, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START);
            try {
                aj.a(e, "请先给予应用权限", 1).show();
            } catch (Throwable unused4) {
            }
        }
    }

    public static void a(final String str, final String str2, final String str3, final int i) {
        q.a(str, new q.a() { // from class: com.sigmob.sdk.base.common.p.7
            @Override // com.sigmob.sdk.base.common.q.a
            public void a(String str4, String str5) {
                String str6;
                int i2 = i;
                String str7 = str3;
                if (TextUtils.isEmpty(str7)) {
                    str7 = str4;
                }
                boolean z = true;
                if (i2 == 1) {
                    str6 = str2;
                    z = false;
                } else {
                    if (i2 != 2) {
                        p.c(str4, str5, str7);
                        return;
                    }
                    str6 = str2;
                }
                n.a(str4, str5, str6, str7, z);
            }

            @Override // com.sigmob.sdk.base.common.q.a
            public void a(String str4, Throwable th) {
                int i2 = i;
                String str5 = str3;
                String str6 = Md5Util.md5(str) + ".apk";
                if (TextUtils.isEmpty(str5)) {
                    str5 = str6;
                }
                if (i2 == 1) {
                    n.a(str6, str, str2, str5, false);
                } else if (i2 != 2) {
                    p.c(str6, str, str5);
                } else {
                    n.a(str6, str, str2, str5, true);
                }
            }
        });
    }

    public static boolean a(long j, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.add(new a(str, null, j));
        return true;
    }

    public static boolean a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageArchiveInfo(str, 1) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursor = null;
        try {
            DownloadManager a2 = a();
            if (a2 != null) {
                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterByStatus(3);
                Cursor query2 = a2.query(query);
                if (!query2.moveToFirst()) {
                    query2.close();
                    if (query2 != null) {
                        query2.close();
                    }
                    return false;
                }
                new ArrayList();
                do {
                    String string = query2.getString(query2.getColumnIndexOrThrow("uri"));
                    if (!TextUtils.isEmpty(string) && str.equalsIgnoreCase(string)) {
                        if (query2 != null) {
                            query2.close();
                        }
                        return true;
                    }
                } while (query2.moveToNext());
                query2.close();
                return false;
            }
        } catch (Throwable th) {
            try {
                SigmobLog.e(th.getMessage());
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        }
        return false;
    }

    public static long[] a(Context context, Long l) {
        long[] jArr = {-1, -1, 0};
        if (l == null || l.longValue() < 0) {
            return jArr;
        }
        Cursor cursor = null;
        try {
            cursor = ((DownloadManager) context.getSystemService("download")).query(new DownloadManager.Query().setFilterById(l.longValue()));
            if (cursor != null && cursor.moveToFirst()) {
                jArr[0] = cursor.getInt(cursor.getColumnIndexOrThrow("bytes_so_far"));
                jArr[1] = cursor.getInt(cursor.getColumnIndexOrThrow("total_size"));
                jArr[2] = cursor.getInt(cursor.getColumnIndexOrThrow("status"));
            }
            return jArr;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private static long b(String str, String str2, String str3) {
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    String trim = str.trim();
                    if (TextUtils.isEmpty(Uri.parse(trim).getScheme())) {
                        trim = "http://" + trim;
                    }
                    if (!trim.startsWith("http")) {
                        return -2L;
                    }
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(trim));
                    File file = new File(str2);
                    request.setTitle(str3);
                    request.setAllowedNetworkTypes(3);
                    request.setAllowedOverRoaming(true);
                    request.setVisibleInDownloadsUi(true);
                    request.setNotificationVisibility(1);
                    File parentFile = file.getParentFile();
                    if (parentFile.exists()) {
                        if (!parentFile.isDirectory()) {
                            parentFile.delete();
                            if (!parentFile.mkdirs()) {
                                return -3L;
                            }
                        }
                    } else if (!parentFile.mkdirs()) {
                        return -4L;
                    }
                    request.addRequestHeader(com.sigmob.sdk.downloader.core.c.d, Networking.getUserAgent());
                    request.setDestinationUri(Uri.fromFile(file));
                    return a().enqueue(request);
                }
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
            }
        }
        return -1L;
    }

    public static HashMap<String, Object> b() {
        Cursor cursor;
        try {
            DownloadManager a2 = a();
            if (a2 != null) {
                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterByStatus(3);
                cursor = a2.query(query);
                try {
                    if (!cursor.moveToFirst()) {
                        cursor.close();
                        return null;
                    }
                    HashMap<String, Object> hashMap = new HashMap<>();
                    do {
                        Long valueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(com.umeng.analytics.pro.ao.d)));
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("local_uri"));
                        if (!TextUtils.isEmpty(string)) {
                            hashMap.put(string, valueOf);
                        }
                    } while (cursor.moveToNext());
                    cursor.close();
                    return hashMap;
                } catch (Throwable th) {
                    th = th;
                    try {
                        SigmobLog.e(th.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        return null;
    }

    public static void b(long j, String str) {
        for (a aVar : b) {
            if (aVar.f394c == j || aVar.a.equalsIgnoreCase(str)) {
                b.remove(aVar);
                return;
            }
        }
    }

    public static boolean b(File file) {
        return (file == null || !file.exists() || ClientMetadata.getPackageInfoWithUri(com.sigmob.sdk.b.e(), file.getAbsolutePath()) == null) ? false : true;
    }

    public static Long c(long j, String str) {
        for (a aVar : b) {
            if (aVar.f394c == j || aVar.a.equalsIgnoreCase(str)) {
                return Long.valueOf(aVar.f394c);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str, final String str2, String str3) {
        Long l;
        if (TextUtils.isEmpty(str)) {
            str = Md5Util.md5(str2) + ".apk";
        }
        File a2 = com.sigmob.sdk.base.utils.e.a(com.sigmob.sdk.base.utils.e.a(com.sigmob.sdk.b.e()), str);
        if (a2 != null) {
            Long c2 = c(-1L, a2.getAbsolutePath());
            if (c2 != null && c2.longValue() > 0) {
                try {
                    aj.a(com.sigmob.sdk.b.e(), "正在下载", 1).show();
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            l = Long.valueOf(b(str2, a2.getAbsolutePath(), str3));
            if (l.longValue() > 0) {
                aj.a(com.sigmob.sdk.b.e(), "开始下载", 1).show();
                File file = new File(com.sigmob.sdk.base.utils.e.g(), l + ".log");
                if (!file.exists()) {
                    file.delete();
                }
                FileUtil.writeToCache(str, file.getAbsolutePath());
            }
        } else {
            l = null;
        }
        ae.a("download_start", (l == null || l.longValue() <= 0) ? "0" : "1", (BaseAdUnit) null, new ae.a() { // from class: com.sigmob.sdk.base.common.p.3
            @Override // com.sigmob.sdk.base.common.ae.a
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    ((PointEntitySigmob) obj).getOptions().put("url", str2);
                }
            }
        });
    }
}
