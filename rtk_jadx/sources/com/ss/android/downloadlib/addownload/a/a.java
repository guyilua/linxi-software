package com.ss.android.downloadlib.addownload.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.l;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.g.m;
import com.ss.android.downloadlib.j;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    private static final String a = "a";
    private static a b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.b.a> f719c;
    private boolean d = false;
    private String e;
    private b f;

    /* renamed from: com.ss.android.downloadlib.addownload.a.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface InterfaceC0073a {
        void a();
    }

    private a() {
        b bVar = new b();
        this.f = bVar;
        this.f719c = bVar.a("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.e = "";
        } else if (TextUtils.equals(this.e, str)) {
            this.e = "";
        }
    }

    private boolean a(Activity activity, DownloadInfo downloadInfo, boolean z, InterfaceC0073a interfaceC0073a) {
        if (downloadInfo == null) {
            try {
                if (this.f719c.isEmpty()) {
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (activity != null && !activity.isFinishing()) {
            boolean z2 = true;
            if (downloadInfo != null && this.f719c.isEmpty()) {
                a(activity, new com.ss.android.downloadlib.addownload.b.a(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC0073a);
                return true;
            }
            long lastModified = downloadInfo != null ? new File(downloadInfo.getTargetFilePath()).lastModified() : 0L;
            CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.b.a> copyOnWriteArrayList = this.f719c;
            ListIterator<com.ss.android.downloadlib.addownload.b.a> listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    z2 = false;
                    break;
                }
                com.ss.android.downloadlib.addownload.b.a previous = listIterator.previous();
                if (previous != null && !m.e(k.a(), previous.d) && m.a(previous.g)) {
                    if (new File(previous.g).lastModified() >= lastModified) {
                        a(activity, previous, z, interfaceC0073a);
                    } else {
                        a(activity, new com.ss.android.downloadlib.addownload.b.a(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC0073a);
                    }
                }
            }
            com.ss.android.downloadlib.g.k.a(a, "tryShowInstallDialog isShow:".concat(String.valueOf(z2)), null);
            return z2;
        }
        return false;
    }

    @MainThread
    public boolean a(Activity activity, boolean z, InterfaceC0073a interfaceC0073a) {
        if (k.j().optInt("disable_install_app_dialog") == 1 || this.d) {
            return false;
        }
        return a(activity, a(activity), z, interfaceC0073a);
    }

    public void a(Context context, com.ss.android.downloadlib.addownload.b.a aVar, boolean z, InterfaceC0073a interfaceC0073a) {
        this.f719c.clear();
        a(context, aVar, interfaceC0073a, z);
        this.d = true;
        j.a(context).c();
        this.f.b("sp_ad_install_back_dialog", "key_uninstalled_list");
        com.ss.android.downloadlib.g.k.a(a, "tryShowInstallDialog isShow:true", null);
    }

    public DownloadInfo a(Context context) {
        long b2;
        List<DownloadInfo> successedDownloadInfosWithMimeType;
        DownloadInfo downloadInfo = null;
        try {
            b2 = j.a(context).b();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (k.j().optInt("enable_miniapp_dialog", 0) != 0 && (successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK)) != null && !successedDownloadInfosWithMimeType.isEmpty()) {
            long j = 0;
            for (DownloadInfo downloadInfo2 : successedDownloadInfosWithMimeType) {
                if (downloadInfo2 != null && !m.e(context, downloadInfo2.getPackageName()) && m.a(downloadInfo2.getTargetFilePath())) {
                    long lastModified = new File(downloadInfo2.getTargetFilePath()).lastModified();
                    if (lastModified >= b2 && downloadInfo2.getExtra() != null) {
                        try {
                            if (new JSONObject(downloadInfo2.getExtra()).has("isMiniApp") && (j == 0 || lastModified > j)) {
                                downloadInfo = downloadInfo2;
                                j = lastModified;
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            return downloadInfo;
        }
        return null;
    }

    public void a(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        for (int i = 0; i < this.f719c.size(); i++) {
            com.ss.android.downloadlib.addownload.b.a aVar = this.f719c.get(i);
            if (aVar != null && aVar.b == j2) {
                this.f719c.set(i, new com.ss.android.downloadlib.addownload.b.a(j, j2, j3, str, str2, str3, str4));
                this.f.a("sp_ad_install_back_dialog", "key_uninstalled_list", this.f719c);
                return;
            }
        }
        this.f719c.add(new com.ss.android.downloadlib.addownload.b.a(j, j2, j3, str, str2, str3, str4));
        this.f.a("sp_ad_install_back_dialog", "key_uninstalled_list", this.f719c);
    }

    private void a(final Context context, final com.ss.android.downloadlib.addownload.b.a aVar, final InterfaceC0073a interfaceC0073a, boolean z) {
        final com.ss.android.downloadad.api.a.b d = f.a().d(aVar.b);
        if (d == null) {
            com.ss.android.downloadlib.e.c.a().a("showBackInstallDialog nativeModel null");
            return;
        }
        l d2 = k.d();
        b.a a2 = new b.a(context).a(z ? "应用安装确认" : "退出确认");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(aVar.e) ? "刚刚下载的应用" : aVar.e;
        d2.b(a2.b(String.format("%1$s下载完成，是否立即安装？", objArr)).c("立即安装").d(z ? "暂不安装" : String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes))).a(false).a(m.a(context, aVar.g)).a(new b.InterfaceC0069b() { // from class: com.ss.android.downloadlib.addownload.a.a.1
            @Override // com.ss.android.download.api.model.b.InterfaceC0069b
            public void a(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.d.a.a().b("backdialog_install", d);
                com.ss.android.socialbase.appdownloader.d.a(context, (int) aVar.a);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC0069b
            public void b(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.d.a.a().b("backdialog_exit", d);
                InterfaceC0073a interfaceC0073a2 = interfaceC0073a;
                if (interfaceC0073a2 != null) {
                    interfaceC0073a2.a();
                }
                a.this.b("");
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC0069b
            public void c(DialogInterface dialogInterface) {
                a.this.b("");
            }
        }).a(1).a());
        com.ss.android.downloadlib.d.a.a().b("backdialog_show", d);
        this.e = aVar.d;
    }

    public boolean a(String str) {
        return TextUtils.equals(this.e, str);
    }

    public void a(com.ss.android.downloadad.api.a.b bVar) {
        if (k.j().optInt("enable_open_app_dialog", 0) == 1 && !bVar.Z() && bVar.q() && Build.VERSION.SDK_INT < 34) {
            bVar.k(true);
            TTDelegateActivity.a(bVar);
        }
    }
}
