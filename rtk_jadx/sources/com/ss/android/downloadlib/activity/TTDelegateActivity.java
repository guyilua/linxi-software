package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import com.sigmob.sdk.base.blurkit.c;
import com.ss.android.download.api.config.l;
import com.ss.android.download.api.config.t;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadad.api.a.b;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.a.e;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.addownload.n;
import com.ss.android.downloadlib.g.h;
import com.ss.android.downloadlib.g.m;
import com.ss.android.downloadlib.guide.install.a;
import com.ss.android.downloadlib.j;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.umeng.analytics.pro.d;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TTDelegateActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {
    private static a d;
    protected Intent a = null;
    private boolean b;

    /* renamed from: c, reason: collision with root package name */
    private b f716c;

    public static void a(String str, String[] strArr) {
        Intent intent = new Intent(k.a(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra(d.y, 1);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (k.a() != null) {
            k.a().startActivity(intent);
        }
    }

    public static void b(String str, com.ss.android.downloadad.api.a.a aVar) {
        Intent c2 = c(aVar);
        c2.addFlags(268435456);
        c2.putExtra(d.y, 11);
        c2.putExtra("package_name", str);
        if (k.a() != null) {
            k.a().startActivity(c2);
        }
    }

    private static Intent c(@NonNull com.ss.android.downloadad.api.a.a aVar) {
        return new Intent(k.a(), (Class<?>) TTDelegateActivity.class);
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        b();
        this.a = getIntent();
        k.b(this);
        a();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.a = intent;
        k.b(this);
        a();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        k.f().a(this, i, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onStop() {
        b bVar;
        DownloadInfo b;
        super.onStop();
        if (!this.b || (bVar = this.f716c) == null) {
            return;
        }
        if (!TextUtils.isEmpty(bVar.af())) {
            b = j.a(k.a()).a(this.f716c.af(), null, true);
        } else {
            b = j.a(k.a()).b(this.f716c.a());
        }
        if (b == null || b.getCurBytes() < b.getTotalBytes() || isFinishing()) {
            return;
        }
        finish();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c() {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.activity.TTDelegateActivity.c():void");
    }

    public static void b(String str, long j, String str2) {
        Intent intent = new Intent(k.a(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra(d.y, 14);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra("market_app_id", str2);
        if (k.a() != null) {
            k.a().startActivity(intent);
        }
    }

    public static void a(String str, com.ss.android.downloadad.api.a.a aVar) {
        Intent c2 = c(aVar);
        c2.addFlags(268435456);
        c2.putExtra(d.y, 2);
        c2.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
        if (k.a() != null) {
            k.a().startActivity(c2);
        }
    }

    public static void a(com.ss.android.downloadad.api.a.a aVar) {
        Intent c2 = c(aVar);
        c2.addFlags(268435456);
        c2.putExtra(d.y, 4);
        c2.putExtra("model_id", aVar.b());
        if (k.a() != null) {
            k.a().startActivity(c2);
        }
    }

    public static void b(@NonNull com.ss.android.downloadad.api.a.a aVar) {
        a(aVar, 5, "", "", "", "");
    }

    public static void b(@NonNull com.ss.android.downloadad.api.a.a aVar, String str, String str2, String str3) {
        a(aVar, 7, str, str2, str3, "");
    }

    public static void b(@NonNull com.ss.android.downloadad.api.a.a aVar, String str, String str2, String str3, String str4) {
        a(aVar, 20, str, str2, str3, str4);
    }

    private void b() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = c.d;
        window.setAttributes(attributes);
    }

    public static void a(com.ss.android.downloadad.api.a.a aVar, a aVar2) {
        Intent c2 = c(aVar);
        c2.addFlags(268435456);
        c2.putExtra(d.y, 9);
        d = aVar2;
        if (k.a() != null) {
            k.a().startActivity(c2);
        }
    }

    private void b(final String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            t tVar = new t() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.1

                /* renamed from: c, reason: collision with root package name */
                private WeakReference<Activity> f717c;

                {
                    this.f717c = new WeakReference<>(TTDelegateActivity.this);
                }

                @Override // com.ss.android.download.api.config.t
                public void a() {
                    com.ss.android.downloadlib.g.j.a(str);
                    com.ss.android.socialbase.appdownloader.c.a(this.f717c.get());
                }

                @Override // com.ss.android.download.api.config.t
                public void a(String str2) {
                    com.ss.android.downloadlib.g.j.a(str, str2);
                    com.ss.android.socialbase.appdownloader.c.a(this.f717c.get());
                }
            };
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    k.f().a(this, strArr, tVar);
                    return;
                } catch (Exception e) {
                    k.u().a(e, "requestPermission");
                }
            }
            tVar.a();
            return;
        }
        com.ss.android.socialbase.appdownloader.c.a((Activity) this);
    }

    public static void a(long j) {
        Intent intent = new Intent(k.a(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra(d.y, 10);
        intent.putExtra("app_info_id", j);
        if (k.a() != null) {
            k.a().startActivity(intent);
        }
    }

    private void b(String str) {
        Intent g = m.g(this, str);
        if (g == null) {
            return;
        }
        try {
            g.addFlags(268435456);
            g.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            startActivity(g);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            com.ss.android.socialbase.appdownloader.c.a((Activity) this);
        }
    }

    public static void a(String str, long j, String str2, @NonNull JSONObject jSONObject) {
        Intent intent = new Intent(k.a(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra(d.y, 12);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra("param", str2);
        intent.putExtra("ext_json", jSONObject.toString());
        if (k.a() != null) {
            k.a().startActivity(intent);
        }
    }

    private void b(long j) {
        final b d2 = f.a().d(j);
        if (d2 == null) {
            com.ss.android.downloadlib.e.c.a().a("showOpenAppDialogInner nativeModel null");
            com.ss.android.socialbase.appdownloader.c.a((Activity) this);
            return;
        }
        l d3 = k.d();
        b.a a = new b.a(this).a("已安装完成");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(d2.N()) ? "刚刚下载的应用" : d2.N();
        d3.b(a.b(String.format("%1$s已安装完成，是否立即打开？", objArr)).c("打开").d("取消").a(false).a(m.d(this, d2.e())).a(new b.InterfaceC0069b() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.2
            @Override // com.ss.android.download.api.model.b.InterfaceC0069b
            public void a(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.b.a.b(d2);
                TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                com.ss.android.socialbase.appdownloader.c.a((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC0069b
            public void b(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.d.a.a().b("market_openapp_cancel", d2);
                TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                com.ss.android.socialbase.appdownloader.c.a((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC0069b
            public void c(DialogInterface dialogInterface) {
                com.ss.android.socialbase.appdownloader.c.a((Activity) TTDelegateActivity.this);
            }
        }).a(2).a());
        com.ss.android.downloadlib.d.a.a().b("market_openapp_window_show", d2);
    }

    public static void a(String str, long j, String str2) {
        Intent intent = new Intent(k.a(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra(d.y, 13);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra(BaseConstants.VIVO_MARKET_NEED_COMMENT, str2);
        if (k.a() != null) {
            k.a().startActivity(intent);
        }
    }

    public static void a(String str, long j) {
        Intent intent = new Intent(k.a(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra(d.y, 15);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        if (k.a() != null) {
            k.a().startActivity(intent);
        }
    }

    private void c(long j) {
        new com.ss.android.downloadlib.addownload.compliance.a(this, j).show();
    }

    public static void a(Context context, String str, long j) {
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra(d.y, 16);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public static void a(@NonNull com.ss.android.downloadad.api.a.a aVar, String str) {
        a(aVar, 19, "", "", "", str);
    }

    public static void a(@NonNull com.ss.android.downloadad.api.a.a aVar, String str, String str2, String str3) {
        a(aVar, 8, str, str2, str3, "");
    }

    public static void a(@NonNull com.ss.android.downloadad.api.a.a aVar, String str, String str2, String str3, String str4) {
        a(aVar, 21, str, str2, str3, str4);
    }

    private static void a(@NonNull com.ss.android.downloadad.api.a.a aVar, int i, String str, String str2, String str3, String str4) {
        Intent c2 = c(aVar);
        c2.addFlags(268435456);
        c2.putExtra(d.y, i);
        if (!TextUtils.isEmpty(str2)) {
            c2.putExtra("positive_button_text", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            c2.putExtra("negative_button_text", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            c2.putExtra("delete_button_text", str4);
        }
        if (!TextUtils.isEmpty(str)) {
            c2.putExtra("message_text", str);
        }
        c2.putExtra("model_id", aVar.b());
        if (k.a() != null) {
            k.a().startActivity(c2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a() {
        Intent intent = this.a;
        if (intent != null) {
            switch (intent.getIntExtra(d.y, 0)) {
                case 1:
                    b(this.a.getStringExtra("permission_id_key"), this.a.getStringArrayExtra("permission_content_key"));
                    break;
                case 2:
                    a(this.a.getStringExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL));
                    break;
                case 3:
                case 6:
                case 17:
                case 18:
                default:
                    com.ss.android.socialbase.appdownloader.c.a((Activity) this);
                    break;
                case 4:
                    b(this.a.getLongExtra("model_id", 0L));
                    break;
                case 5:
                    a(this.a.getLongExtra("model_id", 0L), "");
                    break;
                case 7:
                case 8:
                case 20:
                case 21:
                    c();
                    break;
                case 9:
                    a aVar = d;
                    if (aVar != null) {
                        aVar.a();
                    }
                    com.ss.android.socialbase.appdownloader.c.a((Activity) this);
                    break;
                case 10:
                    c(this.a.getLongExtra("app_info_id", 0L));
                    break;
                case 11:
                    b(this.a.getStringExtra("package_name"));
                    break;
                case 12:
                    h.a(this, this.a.getStringExtra("package_name"), this.a.getLongExtra("model_id", 0L), this.a.getStringExtra("param"), this.a.getStringExtra("ext_json"));
                    com.ss.android.socialbase.appdownloader.c.a((Activity) this);
                    break;
                case 13:
                    h.a(this, this.a.getStringExtra("package_name"), this.a.getLongExtra("model_id", 0L), this.a.getStringExtra(BaseConstants.VIVO_MARKET_NEED_COMMENT));
                    com.ss.android.socialbase.appdownloader.c.a((Activity) this);
                    break;
                case 14:
                    h.b(this, this.a.getStringExtra("package_name"), this.a.getLongExtra("model_id", 0L), this.a.getStringExtra("market_app_id"));
                    com.ss.android.socialbase.appdownloader.c.a((Activity) this);
                    break;
                case 15:
                    h.a(this, this.a.getStringExtra("package_name"), this.a.getLongExtra("model_id", 0L));
                    com.ss.android.socialbase.appdownloader.c.a((Activity) this);
                    break;
                case 16:
                    h.b(this, this.a.getStringExtra("package_name"), this.a.getLongExtra("model_id", 0L));
                    com.ss.android.socialbase.appdownloader.c.a((Activity) this);
                    break;
                case 19:
                    a(this.a.getLongExtra("model_id", 0L), this.a.getStringExtra("delete_button_text"));
                    break;
            }
            this.a = null;
        }
    }

    private void a(long j, String str) {
        if (n.a() == null) {
            return;
        }
        com.ss.android.downloadad.api.a.b d2 = f.a().d(j);
        if (d2 != null) {
            DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(d2.s());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - d2.T()));
                jSONObject.putOpt("click_download_size", Long.valueOf(d2.U()));
                if (downloadInfo != null) {
                    jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
                    jSONObject.putOpt("download_percent", Long.valueOf(downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_current_bytes", Integer.valueOf((int) (downloadInfo.getCurBytes() / BaseConstants.MB_VALUE)));
                    jSONObject.putOpt("download_total_bytes", Integer.valueOf((int) (downloadInfo.getTotalBytes() / BaseConstants.MB_VALUE)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.d.a.a().a("cancel_pause_reserve_wifi_dialog_show", jSONObject, d2);
            } else {
                com.ss.android.downloadlib.d.a.a().b("pause_reserve_wifi_dialog_show", jSONObject, d2);
            }
        }
        e.a a = new e.a(this).a(false).a(n.a());
        if (!TextUtils.isEmpty(str)) {
            a.d(str).a(n.b());
        }
        a.a().show();
        this.b = true;
        this.f716c = d2;
    }

    private void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
            intent.addFlags(268435456);
            if (com.ss.android.socialbase.downloader.g.a.c().a("fix_app_link_flag")) {
                intent.addFlags(67108864);
            }
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            com.ss.android.socialbase.appdownloader.c.a((Activity) this);
        }
    }
}
