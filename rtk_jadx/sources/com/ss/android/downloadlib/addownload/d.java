package com.ss.android.downloadlib.addownload;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d {
    private Handler a;
    private com.ss.android.downloadlib.addownload.b.e b;

    /* renamed from: c, reason: collision with root package name */
    private AtomicBoolean f744c = new AtomicBoolean(false);
    private AtomicBoolean d = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Handler handler) {
        this.a = handler;
    }

    public static long b() {
        if (k.n() != null) {
            return k.n().a();
        }
        return 0L;
    }

    static /* synthetic */ long c() {
        return d();
    }

    private static long d() {
        return com.ss.android.downloadlib.g.m.b(0L);
    }

    private void b(com.ss.android.downloadad.api.a.b bVar, JSONObject jSONObject, long j, long j2) {
        bVar.l("1");
        com.ss.android.downloadlib.addownload.b.i.a().a(bVar);
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(j2 - j));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("cleanspace_download_after_quite_clean", jSONObject, bVar);
    }

    public void a(com.ss.android.downloadlib.addownload.b.e eVar) {
        this.b = eVar;
    }

    public boolean a() {
        return this.d.get();
    }

    public void a(boolean z) {
        this.d.set(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final int i, final long j, long j2, final e.a aVar) {
        this.d.set(false);
        if (aVar == null) {
            return;
        }
        if (com.ss.android.downloadlib.g.e.f(i) && com.ss.android.downloadlib.g.e.e(i)) {
            long c2 = com.ss.android.downloadlib.g.e.c(i);
            this.f744c.set(false);
            final String downloadUrl = this.b.b.getDownloadUrl();
            com.ss.android.downloadad.api.a.b b = com.ss.android.downloadlib.addownload.b.f.a().b(downloadUrl);
            if (b == null) {
                com.ss.android.downloadlib.addownload.b.e eVar = this.b;
                b = new com.ss.android.downloadad.api.a.b(eVar.b, eVar.f728c, eVar.d, 0);
                com.ss.android.downloadlib.addownload.b.f.a().a(b);
            }
            final com.ss.android.downloadad.api.a.b bVar = b;
            bVar.e(false);
            if (k.n() != null) {
                k.n();
                bVar.b();
            }
            com.ss.android.downloadlib.addownload.c.d.a().a(bVar.a());
            boolean d = com.ss.android.downloadlib.g.e.d(i);
            if (j2 > 0) {
                a(i, downloadUrl, j2, bVar, j, aVar);
            } else if (d) {
                a(downloadUrl, bVar, new e.b() { // from class: com.ss.android.downloadlib.addownload.d.1
                    @Override // com.ss.android.downloadlib.addownload.e.b
                    public void a(long j3) {
                        d.this.a(i, downloadUrl, j3, bVar, j, aVar);
                    }
                });
            } else {
                c2 = 0;
            }
            this.a.postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.f744c.get()) {
                        return;
                    }
                    d.this.f744c.set(true);
                    aVar.a();
                }
            }, c2);
            return;
        }
        aVar.a();
    }

    private void a(String str, com.ss.android.downloadad.api.a.b bVar, final e.b bVar2) {
        if (bVar2 == null) {
            return;
        }
        com.ss.android.socialbase.downloader.network.a.b.a(str, new com.ss.android.socialbase.downloader.network.j() { // from class: com.ss.android.downloadlib.addownload.d.3
            @Override // com.ss.android.socialbase.downloader.network.j
            public void a(Map<String, String> map) {
                if (d.this.f744c.get()) {
                    return;
                }
                d.this.f744c.set(true);
                long a = d.this.a(map);
                if (a > 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("apk_size", Long.valueOf(a));
                        jSONObject.putOpt("available_space", Long.valueOf(d.c()));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                bVar2.a(a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if ("content-length".equalsIgnoreCase(key)) {
                        return Long.parseLong(value);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, long j, final com.ss.android.downloadad.api.a.b bVar, long j2, final e.a aVar) {
        this.f744c.set(true);
        boolean z = false;
        if (j > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("apk_size", Long.valueOf(j));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            long longValue = (Double.valueOf((com.ss.android.downloadlib.g.e.a(i) + 1.0d) * j).longValue() + com.ss.android.downloadlib.g.e.b(i)) - j2;
            long d = d();
            if (d < longValue) {
                a(bVar, jSONObject, longValue, d);
                a(bVar);
                long d2 = d();
                if (d2 < longValue) {
                    bVar.d(true);
                    final String a = bVar.a();
                    com.ss.android.downloadlib.addownload.c.d.a().a(a, new com.ss.android.downloadlib.addownload.c.e() { // from class: com.ss.android.downloadlib.addownload.d.4
                    });
                    z = a(i, bVar, str, longValue);
                    if (z) {
                        bVar.e(true);
                    }
                } else {
                    b(bVar, jSONObject, d, d2);
                }
            }
        }
        if (z) {
            return;
        }
        this.a.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.d.5
            @Override // java.lang.Runnable
            public void run() {
                aVar.a();
            }
        });
    }

    private boolean a(int i, @NonNull com.ss.android.downloadad.api.a.b bVar, String str, long j) {
        if (!com.ss.android.downloadlib.g.e.f(i)) {
            return false;
        }
        if (k.n() != null) {
            return k.n().a(i, str, true, j);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_dialog_result", 3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("cleanspace_window_show", jSONObject, bVar);
        return false;
    }

    public static boolean a(final DownloadInfo downloadInfo, long j) {
        int id = downloadInfo.getId();
        boolean z = false;
        if (!com.ss.android.downloadlib.g.e.f(id)) {
            return false;
        }
        if (k.n() != null && (z = k.n().a(id, downloadInfo.getUrl(), false, j))) {
            com.ss.android.downloadlib.addownload.c.d.a().a(downloadInfo.getUrl(), new com.ss.android.downloadlib.addownload.c.e() { // from class: com.ss.android.downloadlib.addownload.d.6
            });
        }
        return z;
    }

    public static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("clean_space_install_params", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static void a(int i) {
        if (com.ss.android.downloadlib.g.e.f(i) && k.n() != null && k.n().b()) {
            k.n();
        }
    }

    private static void a(com.ss.android.downloadad.api.a.b bVar) {
        long d = d();
        if (k.n() != null) {
            k.n();
        }
        com.ss.android.downloadlib.addownload.c.c.a();
        com.ss.android.downloadlib.addownload.c.c.b();
        if (com.ss.android.downloadlib.g.e.g(bVar.s())) {
            com.ss.android.downloadlib.addownload.c.c.a(k.a());
        }
        long d2 = d();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(d2 - d));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("clean_quite_finish", jSONObject, bVar);
    }

    private void a(com.ss.android.downloadad.api.a.b bVar, JSONObject jSONObject, long j, long j2) {
        try {
            jSONObject.putOpt("available_space", Long.valueOf(j2));
            jSONObject.putOpt("apk_download_need_size", Long.valueOf(j));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("clean_space_no_enough_for_download", jSONObject, bVar);
    }
}
