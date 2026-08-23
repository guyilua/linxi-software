package com.ss.android.socialbase.downloader.d;

import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.downloader.q;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.g;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.e;
import com.ss.android.socialbase.downloader.network.i;
import com.tencent.smtt.sdk.TbsListener;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    public static void a(DownloadTask downloadTask, BaseException baseException, int i) {
        if (downloadTask == null) {
            return;
        }
        try {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo == null) {
                return;
            }
            x monitorDepend = downloadTask.getMonitorDepend();
            boolean isMonitorStatus = DownloadStatus.isMonitorStatus(i);
            if (!isMonitorStatus && !(isMonitorStatus = a(downloadInfo.getExtraMonitorStatus(), i)) && monitorDepend != null && (monitorDepend instanceof com.ss.android.socialbase.downloader.depend.c)) {
                isMonitorStatus = a(((com.ss.android.socialbase.downloader.depend.c) monitorDepend).a(), i);
            }
            if (isMonitorStatus) {
                try {
                    n depend = downloadTask.getDepend();
                    if (depend != null) {
                        depend.a(downloadInfo, baseException, i);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                a(monitorDepend, downloadInfo, baseException, i);
                a(com.ss.android.socialbase.downloader.downloader.c.g(), downloadInfo, baseException, i);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private static boolean a(int[] iArr, int i) {
        if (iArr != null && iArr.length > 0) {
            for (int i2 : iArr) {
                if (i == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void a(x xVar, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (xVar == null) {
            return;
        }
        try {
            String b = xVar.b();
            if (TextUtils.isEmpty(b)) {
                b = "default";
            }
            JSONObject a = a(b, downloadInfo, baseException, i);
            if (a == null) {
                a = new JSONObject();
            }
            xVar.a(a);
        } catch (Throwable unused) {
        }
    }

    public static void a(b bVar, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (bVar == null || !downloadInfo.isNeedSDKMonitor() || TextUtils.isEmpty(downloadInfo.getMonitorScene())) {
            return;
        }
        try {
            JSONObject a = a(downloadInfo.getMonitorScene(), downloadInfo, baseException, i);
            if (a == null) {
                a = new JSONObject();
            }
            if (i == -1) {
                a.put("status", baseException.getErrorCode());
            } else {
                a(i, a, downloadInfo);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void a(int i, JSONObject jSONObject, DownloadInfo downloadInfo) {
        String str;
        if (i == -5) {
            str = "download_uncomplete";
        } else if (i == -4) {
            str = "download_cancel";
        } else if (i != -3) {
            str = i != -2 ? i != 0 ? i != 2 ? i != 6 ? "" : "download_first_start" : "download_start" : "download_create" : "download_pause";
        } else {
            double downloadSpeed = downloadInfo.getDownloadSpeed();
            if (downloadSpeed >= 0.0d) {
                jSONObject.put("download_speed", downloadSpeed);
            }
            str = "download_success";
        }
        jSONObject.put("status", str);
    }

    public static String a(String str) {
        try {
            return TextUtils.isDigitsOnly(str) ? String.valueOf(Long.valueOf(str).longValue() % 100) : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static JSONObject a(String str, DownloadInfo downloadInfo, BaseException baseException, int i) {
        String str2;
        String str3;
        String str4;
        int i2;
        String str5;
        String str6;
        String str7;
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                q k = com.ss.android.socialbase.downloader.downloader.c.k();
                if (k != null) {
                    str2 = k.b();
                    str3 = a(str2);
                    str4 = k.a();
                    i2 = k.c();
                } else {
                    str2 = "";
                    str3 = str2;
                    str4 = str3;
                    i2 = 0;
                }
                String a = (baseException == null || !(baseException instanceof g)) ? "" : ((g) baseException).a();
                jSONObject2.put("event_page", str);
                jSONObject2.put("app_id", str4);
                jSONObject2.put("device_id", str2);
                jSONObject2.put("device_id_postfix", str3);
                jSONObject2.put("update_version", i2);
                jSONObject2.put("download_status", i);
                if (downloadInfo != null) {
                    jSONObject2.put("setting_tag", com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).c("setting_tag"));
                    jSONObject2.put("download_id", downloadInfo.getId());
                    jSONObject2.put("name", downloadInfo.getName());
                    jSONObject2.put("url", downloadInfo.getUrl());
                    jSONObject2.put("save_path", downloadInfo.getSavePath());
                    jSONObject2.put("download_time", downloadInfo.getDownloadTime());
                    jSONObject2.put("cur_bytes", downloadInfo.getCurBytes());
                    jSONObject2.put("total_bytes", downloadInfo.getTotalBytes());
                    jSONObject2.put("network_quality", downloadInfo.getNetworkQuality());
                    int i3 = 1;
                    jSONObject2.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                    jSONObject2.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                    jSONObject2.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                    jSONObject2.put("md5", downloadInfo.getMd5() == null ? "" : downloadInfo.getMd5());
                    jSONObject2.put("chunk_count", downloadInfo.getChunkCount());
                    jSONObject2.put("is_force", downloadInfo.isForce() ? 1 : 0);
                    jSONObject2.put("retry_count", downloadInfo.getRetryCount());
                    jSONObject2.put("cur_retry_time", downloadInfo.getCurRetryTime());
                    jSONObject2.put("need_retry_delay", downloadInfo.isNeedRetryDelay() ? 1 : 0);
                    jSONObject2.put("need_reuse_first_connection", downloadInfo.isNeedReuseFirstConnection() ? 1 : 0);
                    jSONObject2.put("default_http_service_backup", downloadInfo.isNeedDefaultHttpServiceBackUp() ? 1 : 0);
                    jSONObject2.put("retry_delay_status", downloadInfo.getRetryDelayStatus().ordinal());
                    jSONObject2.put("backup_url_used", downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                    jSONObject2.put("download_byte_error_retry_status", downloadInfo.getByteInvalidRetryStatus().ordinal());
                    jSONObject2.put("forbidden_handler_status", downloadInfo.getAsyncHandleStatus().ordinal());
                    jSONObject2.put("need_independent_process", downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                    jSONObject2.put("head_connection_error_msg", downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                    jSONObject2.put(BaseConstants.EVENT_LABEL_EXTRA, downloadInfo.getExtra() != null ? downloadInfo.getExtra() : "");
                    if (!downloadInfo.isAddListenerToSameTask()) {
                        i3 = 0;
                    }
                    jSONObject2.put("add_listener_to_same_task", i3);
                    jSONObject2.put("backup_url_count", downloadInfo.getBackUpUrls() != null ? downloadInfo.getBackUpUrls().size() : 0);
                    jSONObject2.put("cur_backup_url_index", downloadInfo.getBackUpUrls() != null ? downloadInfo.getCurBackUpUrlIndex() : -1);
                    jSONObject2.put("forbidden_urls", downloadInfo.getForbiddenBackupUrls() != null ? downloadInfo.getForbiddenBackupUrls().toString() : "");
                    jSONObject2.put("task_id", TextUtils.isEmpty(downloadInfo.getTaskId()) ? "" : downloadInfo.getTaskId());
                    try {
                        String url = downloadInfo.getUrl();
                        if (TextUtils.isEmpty(url)) {
                            str5 = "";
                            str6 = str5;
                            str7 = str6;
                        } else {
                            Uri parse = Uri.parse(url);
                            str6 = parse.getHost();
                            str7 = parse.getPath();
                            str5 = parse.getLastPathSegment();
                            if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str5)) {
                                try {
                                    str7 = str7.substring(0, str7.length() - str5.length());
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                        }
                        jSONObject2.put("url_host", str6);
                        jSONObject2.put("url_path", str7);
                        jSONObject2.put("url_last_path_segment", str5);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                jSONObject2.put("error_code", baseException != null ? baseException.getErrorCode() : 0);
                jSONObject2.put("error_msg", baseException != null ? baseException.getErrorMessage() : "");
                jSONObject2.put("request_log", a);
                return jSONObject2;
            } catch (JSONException e) {
                e = e;
                jSONObject = jSONObject2;
                e.printStackTrace();
                return jSONObject;
            }
        } catch (JSONException e2) {
            e = e2;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:12|(4:65|66|67|(15:69|70|15|(2:46|(1:(2:54|(1:56)(2:57|58)))(1:51))|18|(2:22|23)|26|27|28|(1:30)|31|32|(1:42)|35|(2:39|40)(1:38)))|14|15|(0)|46|(1:48)|(0)|18|(3:20|22|23)|26|27|28|(0)|31|32|(0)|42|35|(0)|39|40) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0112, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0113, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e7 A[Catch: JSONException -> 0x0112, all -> 0x0132, TryCatch #0 {JSONException -> 0x0112, blocks: (B:28:0x00ac, B:30:0x00e7, B:31:0x00f8), top: B:27:0x00ac, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0058 A[Catch: all -> 0x0132, TRY_LEAVE, TryCatch #1 {all -> 0x0132, blocks: (B:67:0x002f, B:69:0x0033, B:18:0x007e, B:20:0x0094, B:26:0x00a7, B:28:0x00ac, B:30:0x00e7, B:31:0x00f8, B:39:0x0124, B:42:0x011c, B:45:0x0113, B:46:0x0047, B:48:0x004d, B:54:0x0058, B:58:0x0065, B:62:0x006b, B:64:0x0077, B:74:0x002c, B:66:0x0025), top: B:12:0x0023, inners: #0, #3, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(@androidx.annotation.Nullable com.ss.android.socialbase.downloader.network.g r13, java.lang.String r14, java.lang.String r15, long r16, java.lang.String r18, int r19, java.io.IOException r20, com.ss.android.socialbase.downloader.model.DownloadInfo r21) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.d.a.a(com.ss.android.socialbase.downloader.network.g, java.lang.String, java.lang.String, long, java.lang.String, int, java.io.IOException, com.ss.android.socialbase.downloader.model.DownloadInfo):void");
    }

    public static void a(com.ss.android.socialbase.downloader.g.a aVar, DownloadInfo downloadInfo, String str, i iVar, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        a("download_io", aVar.b("monitor_download_io"), aVar, downloadInfo, str, null, null, iVar, z, z2, baseException, j, j2, z3, j3, j4, j5, null);
    }

    public static void a(com.ss.android.socialbase.downloader.g.a aVar, DownloadInfo downloadInfo, String str, String str2, String str3, boolean z, i iVar, BaseException baseException, long j, long j2) {
        a("segment_io", aVar.b("monitor_segment_io"), aVar, downloadInfo, str, str2, str3, iVar, z, false, baseException, j, j2, false, -1L, -1L, -1L, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v4 */
    private static void a(String str, int i, com.ss.android.socialbase.downloader.g.a aVar, DownloadInfo downloadInfo, String str2, String str3, String str4, i iVar, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        String str5;
        int i2;
        String str6;
        long j6;
        int i3;
        int i4;
        if (i <= 0 || j2 <= 0) {
            return;
        }
        try {
            Uri parse = Uri.parse(str2);
            String host = parse.getHost();
            String path = parse.getPath();
            String lastPathSegment = parse.getLastPathSegment();
            if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                try {
                    path = path.substring(0, path.length() - lastPathSegment.length());
                } catch (Throwable unused) {
                }
            }
            if (z) {
                str5 = null;
                i2 = 1;
            } else if (z2) {
                str5 = null;
                i2 = 2;
            } else if (baseException != null) {
                i2 = !f.c(com.ss.android.socialbase.downloader.downloader.c.O()) ? 1049 : baseException.getErrorCode();
                str5 = baseException.getErrorMessage();
            } else {
                str5 = null;
                i2 = 0;
            }
            JSONObject jSONObject2 = new JSONObject();
            str6 = "";
            if (iVar != null) {
                i4 = iVar instanceof e ? 0 : 1;
                String a = iVar.a("X-Cache");
                ?? contains = TextUtils.isEmpty(a) ? -1 : a.toLowerCase().contains("hit");
                aVar.a("monitor_sla", 1);
                str6 = iVar instanceof com.ss.android.socialbase.downloader.network.a ? ((com.ss.android.socialbase.downloader.network.a) iVar).f() : "";
                j6 = j;
                i3 = contains;
            } else {
                j6 = j;
                i3 = -1;
                i4 = -1;
            }
            double d = j6 / 1048576.0d;
            double d2 = j2;
            double nanos = d2 / TimeUnit.SECONDS.toNanos(1L);
            jSONObject2.put("setting_tag", aVar.c("setting_tag"));
            jSONObject2.put("url_host", host);
            jSONObject2.putOpt("host_ip", str3);
            jSONObject2.putOpt("host_real_ip", str4);
            jSONObject2.put("url_path", path);
            jSONObject2.put("url_last_path_segment", lastPathSegment);
            jSONObject2.put("net_lib", i4);
            jSONObject2.put("hit_cdn_cache", i3);
            jSONObject2.put("status_code", i2);
            jSONObject2.put("request_log", str6);
            if (str5 != null) {
                jSONObject2.put("error_msg", f.a(str5, aVar.a("exception_msg_length", TbsListener.ErrorCode.INFO_CODE_MINIQB)));
            }
            jSONObject2.put("download_sec", nanos);
            jSONObject2.put("download_mb", d);
            if (nanos > 0.0d) {
                jSONObject2.put("download_speed", d / nanos);
            }
            if (z3) {
                jSONObject2.put("rw_read_time", j3 / d2);
                jSONObject2.put("rw_write_time", j4 / d2);
                jSONObject2.put("rw_sync_time", j5 / d2);
            }
            jSONObject2.put("pkg_name", downloadInfo.getPackageName());
            jSONObject2.put("name", downloadInfo.getTitle());
            if (i != 1) {
                if (i == 3) {
                }
                if (i != 2 || i == 3) {
                    com.ss.android.socialbase.downloader.downloader.c.Q().a(downloadInfo.getId(), str, jSONObject2);
                }
                return;
            }
            com.ss.android.socialbase.downloader.downloader.c.g();
            if (i != 2) {
            }
            com.ss.android.socialbase.downloader.downloader.c.Q().a(downloadInfo.getId(), str, jSONObject2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(DownloadInfo downloadInfo, List<com.ss.android.socialbase.downloader.f.i> list) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("segments", com.ss.android.socialbase.downloader.f.i.a(list));
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            c Q = com.ss.android.socialbase.downloader.downloader.c.Q();
            if (Q != null) {
                Q.a(downloadInfo.getId(), "segments_error", jSONObject);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
