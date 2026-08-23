package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.h.h;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.tencent.smtt.sdk.TbsListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    private static final String a = "b";
    private static c b;

    /* renamed from: c, reason: collision with root package name */
    private static a f800c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a implements a.InterfaceC0086a {
        private final e a;
        private final int b;

        /* renamed from: c, reason: collision with root package name */
        private JSONObject f801c;

        public a(Context context, Intent intent, int i, JSONObject jSONObject, InterfaceC0083b interfaceC0083b) {
            this.f801c = jSONObject;
            int optInt = jSONObject.optInt("query_interval", 1000);
            this.b = optInt;
            this.a = new e(context, intent, i, interfaceC0083b, optInt);
        }

        @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0086a
        public void b() {
            if (!this.a.i) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                this.a.f.sendMessage(obtain);
            }
            com.ss.android.socialbase.downloader.a.a.a().b(this);
            a unused = b.f800c = null;
        }

        @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0086a
        public void c() {
            int optInt = this.f801c.optInt("time_out_second", 20);
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.a.f.sendMessage(obtain);
            if (optInt <= 0 || optInt >= 60) {
                return;
            }
            Message obtain2 = Message.obtain();
            obtain2.what = 2;
            this.a.f.sendMessageDelayed(obtain2, optInt * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.android.socialbase.appdownloader.b$b, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface InterfaceC0083b {
        boolean a(@NonNull Context context);
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface c {
        void a(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.a aVar);
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class d implements Callable<Boolean> {
        private final Context a;
        private final InterfaceC0083b b;

        /* renamed from: c, reason: collision with root package name */
        private final Handler f802c;
        private final long d;

        public d(Handler handler, Context context, InterfaceC0083b interfaceC0083b, long j) {
            this.a = context;
            this.b = interfaceC0083b;
            this.f802c = handler;
            this.d = j;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            InterfaceC0083b interfaceC0083b;
            try {
                interfaceC0083b = this.b;
            } catch (Throwable unused) {
            }
            if (interfaceC0083b != null) {
                long j = this.d;
                if (j > 0 && j <= 10000) {
                    Context context = this.a;
                    boolean a = context != null ? interfaceC0083b.a(context) : false;
                    Message obtain = Message.obtain();
                    if (a) {
                        obtain.what = 2;
                        this.f802c.sendMessage(obtain);
                    } else {
                        obtain.what = 1;
                        this.f802c.sendMessageDelayed(obtain, this.d);
                    }
                    return Boolean.FALSE;
                }
            }
            return Boolean.FALSE;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class e implements h.a {
        public static int a;
        private static int b;

        /* renamed from: c, reason: collision with root package name */
        private final Context f803c;
        private final Intent d;
        private final InterfaceC0083b e;
        private final Handler f;
        private final long g;
        private Future<Boolean> h;
        private boolean i = false;

        public e(Context context, Intent intent, int i, InterfaceC0083b interfaceC0083b, long j) {
            this.f803c = context;
            this.d = intent;
            b = i;
            this.e = interfaceC0083b;
            this.f = new com.ss.android.socialbase.downloader.h.h(Looper.getMainLooper(), this);
            this.g = j;
        }

        @Override // com.ss.android.socialbase.downloader.h.h.a
        public void a(Message message) {
            if (message != null) {
                int i = message.what;
                if (i == 1) {
                    long j = this.g;
                    if (j <= 0 || j > 10000) {
                        return;
                    }
                    a = 1;
                    this.h = com.ss.android.socialbase.downloader.downloader.c.l().submit(new d(this.f, this.f803c, this.e, this.g));
                    return;
                }
                if (i == 2) {
                    a = 2;
                    this.f.removeMessages(2);
                    this.f.removeMessages(1);
                    Future<Boolean> future = this.h;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.i && (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.a.a.a().b())) {
                        Intent intent = this.d;
                        if (intent != null) {
                            b.b(this.f803c, intent);
                        } else {
                            DownloadInfo downloadInfo = Downloader.getInstance(this.f803c).getDownloadInfo(b);
                            if (downloadInfo != null && downloadInfo.isDownloadOverStatus()) {
                                com.ss.android.socialbase.appdownloader.c.b(this.f803c, b, false);
                            }
                        }
                        this.i = true;
                    }
                    b.b(b, this.d == null, b.a(this.f803c));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 26)
    public static boolean e(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable unused) {
            return true;
        }
    }

    private static boolean b(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.a aVar) {
        if (context != null && jSONObject != null) {
            String savePath = downloadInfo.getSavePath();
            if (TextUtils.isEmpty(savePath)) {
                return false;
            }
            aVar.d = "custom";
            com.ss.android.socialbase.appdownloader.a.a a2 = com.ss.android.socialbase.appdownloader.a.d.a(context, "custom", jSONObject, downloadInfo);
            if (a2 != null && a2.a()) {
                Intent b2 = a2.b();
                if (b2 == null) {
                    return false;
                }
                if (a(new File(savePath), downloadInfo, jSONObject)) {
                    if (b(context, b2)) {
                        aVar.b = 0;
                        return true;
                    }
                    aVar.b = 1;
                } else {
                    aVar.b = 6;
                }
                return false;
            }
            aVar.b = 3;
        }
        return false;
    }

    public static void c(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.c.Q().b(i, "guide_auth_open_setting", jSONObject2);
    }

    private static void d(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.c.Q().b(i, "guide_auth_dialog_show", jSONObject2);
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, Intent intent, boolean z) {
        JSONArray e2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).e("ah_plans");
        if (e2 == null) {
            return false;
        }
        int length = e2.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = e2.optJSONObject(i);
            if (com.ss.android.socialbase.appdownloader.f.a.a(optJSONObject) && a(context, downloadInfo, intent, optJSONObject, z)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0085. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean a(android.content.Context r11, com.ss.android.socialbase.downloader.model.DownloadInfo r12, android.content.Intent r13, org.json.JSONObject r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.b.a(android.content.Context, com.ss.android.socialbase.downloader.model.DownloadInfo, android.content.Intent, org.json.JSONObject, boolean):boolean");
    }

    public static com.ss.android.socialbase.appdownloader.a b(JSONObject jSONObject, com.ss.android.socialbase.downloader.g.a aVar) {
        com.ss.android.socialbase.appdownloader.a aVar2 = new com.ss.android.socialbase.appdownloader.a();
        if (jSONObject == null) {
            return aVar2;
        }
        aVar2.a = jSONObject.optString(com.umeng.analytics.pro.d.y);
        aVar2.e = "vbi";
        if (com.ss.android.socialbase.appdownloader.a.d.a(com.ss.android.socialbase.downloader.downloader.c.O(), "vbi", jSONObject, aVar)) {
            aVar2.b = 0;
        } else {
            a(aVar2, 3);
        }
        return aVar2;
    }

    public static void b(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.c.Q().b(i, "guide_auth_dialog_cancel", jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        int i2 = 1;
        try {
            jSONObject.put("scene", z ? 1 : 2);
            if (!z2) {
                i2 = 2;
            }
            jSONObject.put("result_code", i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.c.Q().b(i, "guide_auth_result", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context, Intent intent) {
        return a(context, intent, true);
    }

    private static boolean a(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.a aVar, com.ss.android.socialbase.downloader.g.a aVar2) {
        boolean z;
        String optString = jSONObject.optString(com.umeng.analytics.pro.d.y);
        aVar.a = optString;
        Intent b2 = com.ss.android.socialbase.appdownloader.a.d.a(context, "vbi", jSONObject, downloadInfo).b();
        StringBuilder sb = new StringBuilder();
        try {
            z = b(context, b2);
        } catch (Throwable th) {
            sb.append(optString);
            sb.append(" startActivity failed : ");
            sb.append(a(th));
            a(aVar, 1);
            z = false;
        }
        if (!z) {
            aVar.f798c = sb.toString();
        } else {
            aVar.b = 0;
        }
        return true;
    }

    private static boolean a(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.a aVar) {
        boolean z;
        if (context != null && jSONObject != null) {
            String optString = jSONObject.optString("device_plans");
            aVar.e = optString;
            if (!TextUtils.isEmpty(optString)) {
                String[] split = optString.split(",");
                String savePath = downloadInfo.getSavePath();
                if (TextUtils.isEmpty(savePath)) {
                    return false;
                }
                File file = new File(savePath);
                StringBuilder sb = new StringBuilder();
                String str = null;
                int length = split.length;
                int i = 0;
                while (true) {
                    z = true;
                    if (i >= length) {
                        z = false;
                        break;
                    }
                    String str2 = split[i];
                    com.ss.android.socialbase.appdownloader.a.a a2 = com.ss.android.socialbase.appdownloader.a.d.a(context, str2, jSONObject, downloadInfo);
                    if (a2 != null) {
                        Intent b2 = a2.b();
                        if (b2 != null) {
                            if (a(file, downloadInfo, jSONObject)) {
                                try {
                                    a(context, b2, false);
                                    str = str2;
                                    break;
                                } catch (Throwable th) {
                                    sb.append(str2);
                                    sb.append(" startActivity failed : ");
                                    sb.append(a(th));
                                    a(aVar, 1);
                                }
                            } else {
                                a(aVar, 6);
                                sb.append(str2);
                                sb.append(" createDescFile failed! ");
                            }
                        } else {
                            a(aVar, 3);
                            sb.append(str2);
                            sb.append(" resolveActivity failed! ");
                        }
                    }
                    sb.append("  ");
                    i++;
                }
                if (!z) {
                    aVar.f798c = sb.toString();
                } else {
                    aVar.d = str;
                    aVar.b = 0;
                }
                return z;
            }
        }
        return false;
    }

    public static int a(@NonNull com.ss.android.socialbase.downloader.g.a aVar) {
        if (!(aVar.d("download_dir") != null ? !TextUtils.isEmpty(r0.optString("dir_name")) : false)) {
            return 5;
        }
        if (!com.ss.android.socialbase.downloader.g.a.c().a("get_download_info_by_list")) {
            return 4;
        }
        JSONArray e2 = aVar.e("ah_plans");
        int i = -1;
        if (e2 != null) {
            int length = e2.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = e2.optJSONObject(i2);
                if (com.ss.android.socialbase.appdownloader.f.a.a(optJSONObject)) {
                    String optString = optJSONObject.optString(com.umeng.analytics.pro.d.y);
                    if (!"plan_a".equals(optString) && !"plan_b".equals(optString) && !"plan_e".equals(optString) && !"plan_f".equals(optString)) {
                        if ("plan_d".equalsIgnoreCase(optString) || "plan_h".equalsIgnoreCase(optString) || ("plan_g".equalsIgnoreCase(optString) && (i = b(optJSONObject, aVar).b) == 0)) {
                            return 0;
                        }
                    } else {
                        i = a(optJSONObject, aVar).b;
                        if (i == 0) {
                            return 0;
                        }
                    }
                }
            }
        }
        return i;
    }

    @NonNull
    public static com.ss.android.socialbase.appdownloader.a a(JSONObject jSONObject, com.ss.android.socialbase.downloader.g.a aVar) {
        com.ss.android.socialbase.appdownloader.a aVar2 = new com.ss.android.socialbase.appdownloader.a();
        if (jSONObject == null) {
            return aVar2;
        }
        String optString = jSONObject.optString(com.umeng.analytics.pro.d.y);
        aVar2.a = optString;
        if ("plan_b".equals(optString)) {
            aVar2.e = "custom";
            if (com.ss.android.socialbase.appdownloader.a.d.a(com.ss.android.socialbase.downloader.downloader.c.O(), "custom", jSONObject, aVar)) {
                aVar2.b = 0;
                return aVar2;
            }
            a(aVar2, 3);
        } else {
            String optString2 = jSONObject.optString("device_plans");
            aVar2.e = optString2;
            if (!TextUtils.isEmpty(optString2)) {
                for (String str : optString2.split(",")) {
                    if (com.ss.android.socialbase.appdownloader.a.d.a(com.ss.android.socialbase.downloader.downloader.c.O(), str, jSONObject, aVar)) {
                        aVar2.b = 0;
                        return aVar2;
                    }
                    a(aVar2, 3);
                }
            }
        }
        return aVar2;
    }

    public static com.ss.android.socialbase.appdownloader.a a(JSONObject jSONObject, String str, Context context, com.ss.android.socialbase.downloader.g.a aVar) {
        com.ss.android.socialbase.appdownloader.a aVar2 = new com.ss.android.socialbase.appdownloader.a();
        if (jSONObject != null && com.ss.android.socialbase.appdownloader.f.e.c()) {
            aVar2.a = jSONObject.optString(com.umeng.analytics.pro.d.y);
            if (aVar.a("bi", 0) == 1) {
                aVar2.b = 0;
                return aVar2;
            }
            if (a(context)) {
                aVar2.b = 2;
            } else if (com.ss.android.socialbase.appdownloader.f.a.a(str) != null) {
                aVar2.b = 0;
            } else {
                aVar2.b = 9;
            }
        }
        return aVar2;
    }

    private static void a(com.ss.android.socialbase.appdownloader.a aVar, int i) {
        int i2 = aVar.b;
        if (i2 != -1) {
            aVar.b = (i2 * 10) + i;
        } else {
            aVar.b = i;
        }
    }

    private static boolean a(File file, DownloadInfo downloadInfo, @NonNull JSONObject jSONObject) {
        if (file == null) {
            return false;
        }
        String path = file.getPath();
        JSONObject d2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).d("download_dir");
        File file2 = null;
        String optString = d2 != null ? d2.optString("ins_desc") : null;
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString)) {
            file2 = new File(path + File.separator + optString);
        }
        if (file2 == null) {
            return true;
        }
        try {
            if (!file2.createNewFile()) {
                return true;
            }
            file2.deleteOnExit();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean a(Context context, @Nullable Intent intent, JSONObject jSONObject, int i, @Nullable com.ss.android.socialbase.appdownloader.a aVar) {
        if (context != null && jSONObject != null) {
            long optLong = jSONObject.optLong("jump_interval", 0L);
            if (optLong <= 0) {
                return false;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("sp_ah_config", 0);
            if ((System.currentTimeMillis() - sharedPreferences.getLong("last_jump_unknown_source_time", 0L)) / 60000 >= optLong && !a(context)) {
                sharedPreferences.edit().putLong("last_jump_unknown_source_time", System.currentTimeMillis()).apply();
                if (jSONObject.optInt("show_unknown_source_dialog", 0) == 1) {
                    Intent intent2 = new Intent(context, (Class<?>) JumpUnknownSourceActivity.class);
                    intent2.addFlags(268435456);
                    intent2.putExtra("intent", intent);
                    intent2.putExtra("config", jSONObject.toString());
                    intent2.putExtra("id", i);
                    try {
                        if (a(context, intent2, false)) {
                            d(i, jSONObject);
                        }
                        return true;
                    } catch (Throwable th) {
                        if (aVar != null) {
                            aVar.b = 1;
                            aVar.f798c = "tryShowUnknownSourceDialog" + a(th);
                        }
                        return false;
                    }
                }
                if (a(context, intent, i, jSONObject)) {
                    c(i, jSONObject);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean a(Context context, @Nullable Intent intent, int i, JSONObject jSONObject) {
        try {
            if (com.ss.android.socialbase.appdownloader.f.e.c() && Build.VERSION.SDK_INT < 26 && !d(context)) {
                com.ss.android.socialbase.appdownloader.a.f fVar = new com.ss.android.socialbase.appdownloader.a.f(context);
                if (fVar.a()) {
                    a(context, intent, i, jSONObject, new InterfaceC0083b() { // from class: com.ss.android.socialbase.appdownloader.b.1
                        @Override // com.ss.android.socialbase.appdownloader.b.InterfaceC0083b
                        public boolean a(@NonNull Context context2) {
                            return b.d(context2);
                        }
                    });
                    return b(context, fVar.b());
                }
            } else if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26 && !e(context)) {
                com.ss.android.socialbase.appdownloader.a.b bVar = new com.ss.android.socialbase.appdownloader.a.b(context);
                if (bVar.a()) {
                    a(context, intent, i, jSONObject, new InterfaceC0083b() { // from class: com.ss.android.socialbase.appdownloader.b.2
                        @Override // com.ss.android.socialbase.appdownloader.b.InterfaceC0083b
                        public boolean a(@NonNull Context context2) {
                            return b.e(context2);
                        }
                    });
                    return b(context, bVar.b());
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean a(Context context) {
        if (context == null) {
            return true;
        }
        if (com.ss.android.socialbase.appdownloader.f.e.c() && Build.VERSION.SDK_INT < 26) {
            return d(context);
        }
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            return e(context);
        }
        return true;
    }

    public static boolean a() {
        return e.a == 1;
    }

    public static void a(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.c.Q().b(i, "guide_auth_dialog_confirm", jSONObject2);
    }

    private static void a(Context context, Intent intent, int i, JSONObject jSONObject, InterfaceC0083b interfaceC0083b) {
        if (f800c != null) {
            com.ss.android.socialbase.downloader.a.a.a().b(f800c);
            f800c = null;
        }
        f800c = new a(context, intent, i, jSONObject, interfaceC0083b);
        com.ss.android.socialbase.downloader.a.a.a().a(f800c);
    }

    public static boolean a(Context context, Intent intent, boolean z) {
        if (context == null || intent == null) {
            return false;
        }
        if (z) {
            try {
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                context.startActivity(intent);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        context.startActivity(intent);
        return true;
    }

    public static String a(Throwable th) {
        String th2 = th.toString();
        return th2.length() > 800 ? th2.substring(0, TbsListener.ErrorCode.INFO_CODE_MINIQB) : th2;
    }

    public static void a(c cVar) {
        b = cVar;
    }
}
