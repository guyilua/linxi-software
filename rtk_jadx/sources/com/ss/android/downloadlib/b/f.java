package com.ss.android.downloadlib.b;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.a.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f {
    private static Handler a = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(@NonNull final com.ss.android.downloadad.api.a.b bVar, final int i) {
        if (i <= 0) {
            return;
        }
        com.ss.android.downloadlib.e.a().a(new Runnable() { // from class: com.ss.android.downloadlib.b.f.2
            @Override // java.lang.Runnable
            public void run() {
                int i2 = 1;
                if (m.c(com.ss.android.downloadad.api.a.b.this.e())) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (!com.ss.android.downloadad.api.a.b.this.aa()) {
                            i2 = 2;
                        }
                        jSONObject.putOpt("deeplink_source", Integer.valueOf(i2));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    com.ss.android.downloadlib.d.a.a().a("deeplink_success_2", jSONObject, com.ss.android.downloadad.api.a.b.this);
                    return;
                }
                f.b(com.ss.android.downloadad.api.a.b.this, i - 1);
            }
        }, i(bVar) * 1000);
    }

    public static boolean c(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.g.e.a((com.ss.android.downloadad.api.a.a) bVar).b("app_link_opt_invoke_switch") == 1;
    }

    public static boolean d(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.g.e.a((com.ss.android.downloadad.api.a.a) bVar).b("app_link_opt_dialog_switch") == 1;
    }

    public static long e(com.ss.android.downloadad.api.a.b bVar) {
        if (bVar == null) {
            return 3000L;
        }
        return com.ss.android.downloadlib.g.e.a((com.ss.android.downloadad.api.a.a) bVar).a("app_link_opt_back_time_limit", 3) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long h(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.g.e.a((com.ss.android.downloadad.api.a.a) bVar).a("app_link_check_timeout", 300000L);
    }

    private static int i(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.g.e.a((com.ss.android.downloadad.api.a.a) bVar).a("app_link_check_delay", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int j(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.g.e.a((com.ss.android.downloadad.api.a.a) bVar).a("app_link_check_count", 10);
    }

    public static void a(final com.ss.android.downloadad.api.a.b bVar, @NonNull final h hVar) {
        boolean b = com.ss.android.socialbase.downloader.a.a.a().b();
        if (!b && Build.VERSION.SDK_INT >= 29) {
            m.c();
        }
        boolean b2 = com.ss.android.socialbase.downloader.a.a.a().b();
        boolean z = !b && b2;
        if (bVar != null) {
            bVar.l(z);
        }
        hVar.a(z);
        if (bVar == null) {
            return;
        }
        b(bVar, j(bVar));
        if (b2) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        com.ss.android.socialbase.downloader.a.a.a().a(new a.InterfaceC0086a() { // from class: com.ss.android.downloadlib.b.f.1
            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0086a
            public void b() {
                com.ss.android.socialbase.downloader.a.a.a().b(this);
                com.ss.android.downloadlib.e.a().a(new Runnable() { // from class: com.ss.android.downloadlib.b.f.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean c2 = m.c(com.ss.android.downloadad.api.a.b.this.e());
                        long e = f.e(com.ss.android.downloadad.api.a.b.this);
                        if (!c2 || e >= System.currentTimeMillis() - currentTimeMillis) {
                            long h = f.h(com.ss.android.downloadad.api.a.b.this);
                            long currentTimeMillis2 = System.currentTimeMillis();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            if (currentTimeMillis2 - currentTimeMillis > h) {
                                com.ss.android.downloadlib.d.a.a().a("deeplink_delay_timeout", com.ss.android.downloadad.api.a.b.this);
                                return;
                            }
                            com.ss.android.downloadad.api.a.b.this.l(true);
                            com.ss.android.downloadlib.d.a.a().a("deeplink_delay_invoke", com.ss.android.downloadad.api.a.b.this);
                            hVar.a(true);
                            com.ss.android.downloadad.api.a.b bVar2 = com.ss.android.downloadad.api.a.b.this;
                            f.b(bVar2, f.j(bVar2));
                        }
                    }
                });
            }

            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0086a
            public void c() {
            }
        });
    }

    public static boolean b(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.g.e.a((com.ss.android.downloadad.api.a.a) bVar).b("app_link_opt_install_switch") == 1;
    }

    public static boolean a(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.g.e.a((com.ss.android.downloadad.api.a.a) bVar).b("app_link_opt_switch") == 1;
    }
}
