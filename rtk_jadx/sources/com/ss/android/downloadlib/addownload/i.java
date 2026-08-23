package com.ss.android.downloadlib.addownload;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class i {
    public static boolean a(int i) {
        return i == 0 || i == 1;
    }

    public static boolean a(DownloadModel downloadModel) {
        return downloadModel.isAd() && (downloadModel instanceof AdDownloadModel) && downloadModel.getModelType() == 1;
    }

    public static boolean b(int i) {
        return i == 2 || i == 1;
    }

    public static boolean b(DownloadModel downloadModel) {
        return downloadModel != null && downloadModel.getModelType() == 2;
    }

    public static String c(DownloadModel downloadModel) {
        try {
            if (TextUtils.isEmpty(downloadModel.getLogExtra())) {
                return null;
            }
            return new JSONObject(downloadModel.getLogExtra()).optString("clickid");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String d(DownloadModel downloadModel) {
        try {
            if (TextUtils.isEmpty(downloadModel.getLogExtra())) {
                return null;
            }
            return new JSONObject(downloadModel.getLogExtra()).optString(AdBaseConstants.MARKET_OPEN_INTENT_EXTRA);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean a(DownloadModel downloadModel, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return downloadModel.isAd() && iDownloadButtonClickListener != null;
    }

    public static int a(@NonNull com.ss.android.downloadlib.addownload.b.e eVar, boolean z, com.ss.android.socialbase.appdownloader.f fVar) {
        int i;
        if (fVar == null || TextUtils.isEmpty(fVar.c()) || fVar.b() == null) {
            return 0;
        }
        try {
            i = a(fVar, fVar.c());
        } catch (Throwable th) {
            k.u().a(th, "redirectSavePathIfPossible");
            i = 4;
        }
        fVar.a(i);
        if (i == 0) {
            fVar.a(new com.ss.android.downloadlib.c.a());
        }
        if (!fVar.ac()) {
            fVar.a(new com.ss.android.downloadlib.c.b());
        }
        int a = com.ss.android.socialbase.appdownloader.d.j().a(fVar);
        com.ss.android.downloadad.api.a.b a2 = a(eVar, a);
        com.ss.android.downloadlib.addownload.b.f.a().a(a2);
        a2.g(a);
        a2.h(System.currentTimeMillis());
        a2.i(0L);
        com.ss.android.socialbase.downloader.g.a a3 = com.ss.android.socialbase.downloader.g.a.a(fVar.ag());
        if (!a(fVar, a3, a) && eVar.b.isShowToast()) {
            String startToast = eVar.b.getStartToast();
            if (TextUtils.isEmpty(startToast)) {
                startToast = a3.c("download_start_toast_text");
            }
            if (TextUtils.isEmpty(startToast)) {
                startToast = z ? "已开始下载，可在\"我的\"里查看管理" : "已开始下载";
            }
            k.d().a(2, fVar.b(), eVar.b, startToast, null, 0);
        }
        return a;
    }

    private static com.ss.android.downloadad.api.a.b a(com.ss.android.downloadlib.addownload.b.e eVar, int i) {
        com.ss.android.downloadad.api.a.b bVar = new com.ss.android.downloadad.api.a.b(eVar.b, eVar.f728c, eVar.d, i);
        boolean z = true;
        if (com.ss.android.socialbase.downloader.g.a.a(i).a("download_event_opt", 1) > 1) {
            try {
                String packageName = eVar.b.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    if (k.a().getPackageManager().getPackageInfo(packageName, 0) == null) {
                        z = false;
                    }
                    bVar.h(z);
                }
            } catch (Throwable unused) {
            }
        }
        return bVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0092, code lost:
    
        switch(r9) {
            case 0: goto L57;
            case 1: goto L57;
            case 2: goto L56;
            case 3: goto L70;
            case 4: goto L57;
            case 5: goto L57;
            case 6: goto L53;
            case 7: goto L70;
            default: goto L79;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009c, code lost:
    
        if (com.ss.android.socialbase.appdownloader.b.b(r6, r12).b != 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x009f, code lost:
    
        r4 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a7, code lost:
    
        if (com.ss.android.socialbase.appdownloader.b.a(r6, r12).b != 0) goto L78;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean a(com.ss.android.socialbase.appdownloader.f r11, @androidx.annotation.NonNull com.ss.android.socialbase.downloader.g.a r12, int r13) {
        /*
            java.lang.String r11 = "ah_plans"
            org.json.JSONArray r11 = r12.e(r11)
            r0 = 0
            if (r11 == 0) goto Lca
            int r1 = r11.length()
            if (r1 != 0) goto L11
            goto Lca
        L11:
            int r1 = r11.length()
            r2 = 0
            r4 = r2
            r3 = 0
        L18:
            r5 = 1
            if (r3 >= r1) goto Lae
            org.json.JSONObject r6 = r11.optJSONObject(r3)
            if (r6 == 0) goto Laa
            java.lang.String r7 = "type"
            java.lang.String r7 = r6.optString(r7)
            java.lang.String r8 = "plan_c"
            if (r7 == r8) goto L31
            boolean r9 = com.ss.android.socialbase.appdownloader.f.a.a(r6)
            if (r9 == 0) goto Laa
        L31:
            r7.hashCode()
            r9 = -1
            int r10 = r7.hashCode()
            switch(r10) {
                case -985763637: goto L88;
                case -985763636: goto L7d;
                case -985763635: goto L74;
                case -985763634: goto L69;
                case -985763633: goto L5e;
                case -985763632: goto L53;
                case -985763631: goto L48;
                case -985763630: goto L3d;
                default: goto L3c;
            }
        L3c:
            goto L92
        L3d:
            java.lang.String r8 = "plan_h"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L46
            goto L92
        L46:
            r9 = 7
            goto L92
        L48:
            java.lang.String r8 = "plan_g"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L51
            goto L92
        L51:
            r9 = 6
            goto L92
        L53:
            java.lang.String r8 = "plan_f"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L5c
            goto L92
        L5c:
            r9 = 5
            goto L92
        L5e:
            java.lang.String r8 = "plan_e"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L67
            goto L92
        L67:
            r9 = 4
            goto L92
        L69:
            java.lang.String r8 = "plan_d"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L72
            goto L92
        L72:
            r9 = 3
            goto L92
        L74:
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L7b
            goto L92
        L7b:
            r9 = 2
            goto L92
        L7d:
            java.lang.String r8 = "plan_b"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L86
            goto L92
        L86:
            r9 = 1
            goto L92
        L88:
            java.lang.String r8 = "plan_a"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L91
            goto L92
        L91:
            r9 = 0
        L92:
            switch(r9) {
                case 0: goto La1;
                case 1: goto La1;
                case 2: goto L9f;
                case 3: goto Lae;
                case 4: goto La1;
                case 5: goto La1;
                case 6: goto L96;
                case 7: goto Lae;
                default: goto L95;
            }
        L95:
            goto Laa
        L96:
            com.ss.android.socialbase.appdownloader.a r6 = com.ss.android.socialbase.appdownloader.b.b(r6, r12)
            int r6 = r6.b
            if (r6 != 0) goto Laa
            goto Lae
        L9f:
            r4 = r6
            goto Laa
        La1:
            com.ss.android.socialbase.appdownloader.a r6 = com.ss.android.socialbase.appdownloader.b.a(r6, r12)
            int r6 = r6.b
            if (r6 != 0) goto Laa
            goto Lae
        Laa:
            int r3 = r3 + 1
            goto L18
        Lae:
            if (r4 == 0) goto Lca
            java.lang.String r11 = "show_unknown_source_on_startup"
            int r11 = r4.optInt(r11)
            if (r11 != r5) goto Lb9
            goto Lba
        Lb9:
            r5 = 0
        Lba:
            if (r5 == 0) goto Lca
            android.content.Context r11 = com.ss.android.socialbase.downloader.downloader.c.O()
            com.ss.android.socialbase.appdownloader.a r12 = new com.ss.android.socialbase.appdownloader.a
            r12.<init>()
            boolean r11 = com.ss.android.socialbase.appdownloader.b.a(r11, r2, r4, r13, r12)
            return r11
        Lca:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.i.a(com.ss.android.socialbase.appdownloader.f, com.ss.android.socialbase.downloader.g.a, int):boolean");
    }

    public static String a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        try {
            String extra = downloadInfo.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                return new JSONObject(extra).optString("notification_jump_url", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static int a(com.ss.android.socialbase.appdownloader.f fVar, String str) {
        com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(fVar.ag());
        JSONObject d = a.d("download_dir");
        if (d == null || TextUtils.isEmpty(d.optString("dir_name"))) {
            return -1;
        }
        String d2 = fVar.d();
        String N = fVar.N();
        if (TextUtils.isEmpty(N)) {
            N = com.ss.android.socialbase.appdownloader.c.a(str, d2, fVar.n(), true);
        }
        if (N.length() > 255) {
            N = N.substring(N.length() - 255);
        }
        if (TextUtils.isEmpty(d2)) {
            d2 = N;
        }
        String e = fVar.e();
        if (TextUtils.isEmpty(e)) {
            e = com.ss.android.socialbase.appdownloader.c.b();
        }
        String str2 = e + File.separator + com.ss.android.socialbase.appdownloader.c.a(d2, a);
        DownloadInfo a2 = com.ss.android.socialbase.appdownloader.d.j().a(fVar.b(), str);
        if (a2 != null && a2.isSavePathRedirected()) {
            fVar.c(a2.getSavePath());
            try {
                fVar.a(new JSONObject(a2.getDownloadSettingString()));
                return 0;
            } catch (Throwable unused) {
                return 0;
            }
        }
        if (a2 != null || !AdBaseConstants.MIME_APK.equalsIgnoreCase(com.ss.android.socialbase.appdownloader.d.j().a(N, fVar.n()))) {
            return a2 != null ? 8 : 9;
        }
        int a3 = com.ss.android.socialbase.appdownloader.b.a(a);
        if (a3 != 0) {
            return a3;
        }
        fVar.c(str2);
        return a3;
    }
}
