package com.tencent.smtt.sdk.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloadUpload;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.sdk.TbsPVConfig;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.h;
import com.tencent.smtt.utils.n;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import org.json.JSONObject;

/* compiled from: HttpUtils.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    public static byte[] a;

    static {
        try {
            a = "65dRa93L".getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(18:1|2|3|4|(13:11|(1:13)(1:46)|14|15|(1:17)(1:45)|18|(5:20|21|(1:23)(1:27)|24|(1:26))|28|30|31|(3:33|34|(1:36)(2:37|(1:39)))|40|41)|47|14|15|(0)(0)|18|(0)|28|30|31|(0)|40|41|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ed A[Catch: Exception -> 0x0177, TRY_ENTER, TryCatch #0 {Exception -> 0x0177, blocks: (B:3:0x0006, B:6:0x0079, B:8:0x0081, B:11:0x008c, B:13:0x0090, B:14:0x00d8, B:17:0x00ed, B:18:0x0105, B:20:0x0109, B:23:0x011f, B:26:0x0131, B:27:0x012b, B:28:0x0136, B:45:0x00f5, B:46:0x0096, B:47:0x009a), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0109 A[Catch: Exception -> 0x0177, TRY_LEAVE, TryCatch #0 {Exception -> 0x0177, blocks: (B:3:0x0006, B:6:0x0079, B:8:0x0081, B:11:0x008c, B:13:0x0090, B:14:0x00d8, B:17:0x00ed, B:18:0x0105, B:20:0x0109, B:23:0x011f, B:26:0x0131, B:27:0x012b, B:28:0x0136, B:45:0x00f5, B:46:0x0096, B:47:0x009a), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0143 A[Catch: Exception -> 0x0176, TRY_LEAVE, TryCatch #1 {Exception -> 0x0176, blocks: (B:31:0x013d, B:33:0x0143, B:36:0x014f, B:37:0x0163, B:39:0x016b), top: B:30:0x013d }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f5 A[Catch: Exception -> 0x0177, TryCatch #0 {Exception -> 0x0177, blocks: (B:3:0x0006, B:6:0x0079, B:8:0x0081, B:11:0x008c, B:13:0x0090, B:14:0x00d8, B:17:0x00ed, B:18:0x0105, B:20:0x0109, B:23:0x011f, B:26:0x0131, B:27:0x012b, B:28:0x0136, B:45:0x00f5, B:46:0x0096, B:47:0x009a), top: B:2:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject c(a.a r12, android.content.Context r13) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.a.b.c(a.a, android.content.Context):org.json.JSONObject");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(17:1|(2:2|3)|(13:(1:75)|9|10|11|12|13|(2:14|(1:16)(1:17))|(1:19)(2:35|36)|20|21|(2:27|28)|23|24)(1:7)|8|9|10|11|12|13|(3:14|(0)(0)|16)|(0)(0)|20|21|(0)|23|24|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006b, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006c, code lost:
    
        r4.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007e, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x007f, code lost:
    
        r0 = r4;
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0089, code lost:
    
        r4.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008c, code lost:
    
        if (r0 != null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0096, code lost:
    
        if (r1 != null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a0, code lost:
    
        r5 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0098, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x009c, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009d, code lost:
    
        r4.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x008e, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0092, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0093, code lost:
    
        r4.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x007a, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x007b, code lost:
    
        r0 = r4;
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c2, code lost:
    
        if (r0 != 0) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00cc, code lost:
    
        if (r1 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ce, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d2, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d3, code lost:
    
        r5.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00d6, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:?, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00c4, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c8, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c9, code lost:
    
        r5.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0082, code lost:
    
        r4 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040 A[Catch: all -> 0x007a, Exception -> 0x007e, LOOP:0: B:14:0x0039->B:16:0x0040, LOOP_END, TryCatch #12 {Exception -> 0x007e, all -> 0x007a, blocks: (B:13:0x0037, B:14:0x0039, B:16:0x0040, B:19:0x0047, B:35:0x0059), top: B:12:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0045 A[EDGE_INSN: B:17:0x0045->B:18:0x0045 BREAK  A[LOOP:0: B:14:0x0039->B:16:0x0040], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047 A[Catch: all -> 0x007a, Exception -> 0x007e, TryCatch #12 {Exception -> 0x007e, all -> 0x007a, blocks: (B:13:0x0037, B:14:0x0039, B:16:0x0040, B:19:0x0047, B:35:0x0059), top: B:12:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0059 A[Catch: all -> 0x007a, Exception -> 0x007e, TRY_LEAVE, TryCatch #12 {Exception -> 0x007e, all -> 0x007a, blocks: (B:13:0x0037, B:14:0x0039, B:16:0x0040, B:19:0x0047, B:35:0x0059), top: B:12:0x0037 }] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(java.net.HttpURLConnection r4, java.lang.String r5, boolean r6) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.a.b.b(java.net.HttpURLConnection, java.lang.String, boolean):java.lang.String");
    }

    public static void a(final a.a aVar, final Context context) {
        new Thread("HttpUtils") { // from class: com.tencent.smtt.sdk.a.b.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                String str;
                String str2;
                String str3;
                byte[] a2;
                aVar.k = com.tencent.smtt.utils.b.a();
                if (Build.VERSION.SDK_INT < 8) {
                    return;
                }
                JSONObject jSONObject = null;
                if (b.a == null) {
                    try {
                        b.a = "65dRa93L".getBytes("utf-8");
                    } catch (UnsupportedEncodingException unused) {
                        b.a = null;
                        TbsLog.e("sdkreport", "Post failed -- get POST_DATA_KEY failed!");
                    }
                }
                if (b.a == null) {
                    TbsLog.e("sdkreport", "Post failed -- POST_DATA_KEY is null!");
                    return;
                }
                String string = TbsDownloadConfig.getInstance(context).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_DESkEY_TOKEN, "");
                if (TextUtils.isEmpty(string)) {
                    str = "";
                    str2 = str;
                } else {
                    str2 = string.substring(0, string.indexOf("&"));
                    str = string.substring(string.indexOf("&") + 1, string.length());
                }
                boolean z = TextUtils.isEmpty(str2) || str2.length() != 96 || TextUtils.isEmpty(str) || str.length() != 24;
                try {
                    n a3 = n.a();
                    if (z) {
                        str3 = a3.b() + h.a().b();
                    } else {
                        str3 = a3.f() + str2;
                    }
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str3).openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setConnectTimeout(AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS);
                    if (Build.VERSION.SDK_INT > 13) {
                        httpURLConnection.setRequestProperty("Connection", PointCategory.CLOSE);
                    }
                    try {
                        jSONObject = b.c(aVar, context);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (jSONObject == null) {
                        TbsLog.e("sdkreport", "post -- jsonData is null!");
                        return;
                    }
                    try {
                        byte[] bytes = jSONObject.toString().getBytes("utf-8");
                        if (z) {
                            a2 = h.a().a(bytes);
                        } else {
                            a2 = h.a(bytes, str);
                        }
                        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        httpURLConnection.setRequestProperty(com.sigmob.sdk.downloader.core.c.e, String.valueOf(a2.length));
                        try {
                            OutputStream outputStream = httpURLConnection.getOutputStream();
                            outputStream.write(a2);
                            outputStream.flush();
                            if (httpURLConnection.getResponseCode() == 200) {
                                TbsLog.i("sdkreport", "Post successful!");
                                TbsLog.i("sdkreport", "SIGNATURE is " + jSONObject.getString("SIGNATURE"));
                                b.b(context, b.b(httpURLConnection, str, z));
                                new TbsDownloadUpload(context).clearUploadCode();
                                return;
                            }
                            TbsLog.e("sdkreport", "Post failed -- not 200 code is " + httpURLConnection.getResponseCode());
                            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
                            tbsLogInfo.setErrorCode(126);
                            tbsLogInfo.setFailDetail("" + httpURLConnection.getResponseCode());
                            TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
                        } catch (Throwable th) {
                            TbsLog.e("sdkreport", "Post failed -- exceptions:" + th.getMessage());
                            TbsLogReport.TbsLogInfo tbsLogInfo2 = TbsLogReport.getInstance(context).tbsLogInfo();
                            tbsLogInfo2.setErrorCode(126);
                            tbsLogInfo2.setFailDetail(th);
                            TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo2);
                        }
                    } catch (Throwable unused2) {
                    }
                } catch (IOException e2) {
                    TbsLog.e("sdkreport", "Post failed -- IOException:" + e2);
                } catch (AssertionError e3) {
                    TbsLog.e("sdkreport", "Post failed -- AssertionError:" + e3);
                } catch (NoClassDefFoundError e4) {
                    TbsLog.e("sdkreport", "Post failed -- NoClassDefFoundError:" + e4);
                }
            }
        }.start();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00b9 A[Catch: all -> 0x0146, TryCatch #2 {all -> 0x0146, blocks: (B:22:0x0075, B:24:0x00b9, B:25:0x00bb, B:27:0x00bf, B:28:0x00c8, B:30:0x00dc, B:32:0x00e2, B:34:0x00e6, B:36:0x00ec, B:37:0x00ee, B:39:0x00f4, B:41:0x00f8, B:43:0x00fe, B:44:0x0100, B:47:0x010d, B:49:0x0113, B:51:0x011b, B:52:0x012c, B:54:0x0136, B:55:0x013e, B:58:0x0117, B:59:0x011e, B:62:0x0124, B:65:0x012a, B:66:0x00c2), top: B:21:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bf A[Catch: all -> 0x0146, TryCatch #2 {all -> 0x0146, blocks: (B:22:0x0075, B:24:0x00b9, B:25:0x00bb, B:27:0x00bf, B:28:0x00c8, B:30:0x00dc, B:32:0x00e2, B:34:0x00e6, B:36:0x00ec, B:37:0x00ee, B:39:0x00f4, B:41:0x00f8, B:43:0x00fe, B:44:0x0100, B:47:0x010d, B:49:0x0113, B:51:0x011b, B:52:0x012c, B:54:0x0136, B:55:0x013e, B:58:0x0117, B:59:0x011e, B:62:0x0124, B:65:0x012a, B:66:0x00c2), top: B:21:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f4 A[Catch: all -> 0x0146, TryCatch #2 {all -> 0x0146, blocks: (B:22:0x0075, B:24:0x00b9, B:25:0x00bb, B:27:0x00bf, B:28:0x00c8, B:30:0x00dc, B:32:0x00e2, B:34:0x00e6, B:36:0x00ec, B:37:0x00ee, B:39:0x00f4, B:41:0x00f8, B:43:0x00fe, B:44:0x0100, B:47:0x010d, B:49:0x0113, B:51:0x011b, B:52:0x012c, B:54:0x0136, B:55:0x013e, B:58:0x0117, B:59:0x011e, B:62:0x0124, B:65:0x012a, B:66:0x00c2), top: B:21:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0136 A[Catch: all -> 0x0146, TryCatch #2 {all -> 0x0146, blocks: (B:22:0x0075, B:24:0x00b9, B:25:0x00bb, B:27:0x00bf, B:28:0x00c8, B:30:0x00dc, B:32:0x00e2, B:34:0x00e6, B:36:0x00ec, B:37:0x00ee, B:39:0x00f4, B:41:0x00f8, B:43:0x00fe, B:44:0x0100, B:47:0x010d, B:49:0x0113, B:51:0x011b, B:52:0x012c, B:54:0x0136, B:55:0x013e, B:58:0x0117, B:59:0x011e, B:62:0x0124, B:65:0x012a, B:66:0x00c2), top: B:21:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c2 A[Catch: all -> 0x0146, TryCatch #2 {all -> 0x0146, blocks: (B:22:0x0075, B:24:0x00b9, B:25:0x00bb, B:27:0x00bf, B:28:0x00c8, B:30:0x00dc, B:32:0x00e2, B:34:0x00e6, B:36:0x00ec, B:37:0x00ee, B:39:0x00f4, B:41:0x00f8, B:43:0x00fe, B:44:0x0100, B:47:0x010d, B:49:0x0113, B:51:0x011b, B:52:0x012c, B:54:0x0136, B:55:0x013e, B:58:0x0117, B:59:0x011e, B:62:0x0124, B:65:0x012a, B:66:0x00c2), top: B:21:0x0075 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.Context r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, boolean r11, long r12, boolean r14) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.a.b.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, int, boolean, long, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str) {
        try {
            TbsPVConfig.releaseInstance();
            TbsPVConfig.getInstance(context).clear();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            for (String str2 : str.split("\\|")) {
                try {
                    String[] split = str2.split("=");
                    if (split.length == 2) {
                        a(context, split[0], split[1]);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            TbsPVConfig.getInstance(context).commit();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static String a(Context context) {
        try {
            byte[] byteArray = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
            if (byteArray != null) {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                messageDigest.update(byteArray);
                byte[] digest = messageDigest.digest();
                if (digest != null) {
                    StringBuilder sb = new StringBuilder("");
                    if (digest != null && digest.length > 0) {
                        for (int i = 0; i < digest.length; i++) {
                            String upperCase = Integer.toHexString(digest[i] & 255).toUpperCase();
                            if (i > 0) {
                                sb.append(":");
                            }
                            if (upperCase.length() < 2) {
                                sb.append(0);
                            }
                            sb.append(upperCase);
                        }
                        return sb.toString();
                    }
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void a(Context context, String str, String str2) {
        if ("reset".equals(str) && "true".equals(str2)) {
            QbSdk.reset(context);
        } else {
            TbsPVConfig.getInstance(context).putData(str, str2);
        }
    }
}
