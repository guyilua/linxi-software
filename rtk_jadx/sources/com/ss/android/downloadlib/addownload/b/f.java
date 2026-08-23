package com.ss.android.downloadlib.addownload.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f {
    private volatile boolean a;
    private final ConcurrentHashMap<Long, DownloadModel> b;

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<Long, DownloadEventConfig> f729c;
    private final ConcurrentHashMap<Long, DownloadController> d;
    private final ConcurrentHashMap<Long, com.ss.android.downloadad.api.a.b> e;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class a {
        private static f a = new f();
    }

    public DownloadController c(long j) {
        return this.d.get(Long.valueOf(j));
    }

    public com.ss.android.downloadad.api.a.b d(long j) {
        return this.e.get(Long.valueOf(j));
    }

    @NonNull
    public e e(long j) {
        e eVar = new e();
        eVar.a = j;
        eVar.b = a(j);
        DownloadEventConfig b = b(j);
        eVar.f728c = b;
        if (b == null) {
            eVar.f728c = new com.ss.android.download.api.download.c();
        }
        DownloadController c2 = c(j);
        eVar.d = c2;
        if (c2 == null) {
            eVar.d = new com.ss.android.download.api.download.b();
        }
        return eVar;
    }

    public void f(long j) {
        this.b.remove(Long.valueOf(j));
        this.f729c.remove(Long.valueOf(j));
        this.d.remove(Long.valueOf(j));
    }

    private f() {
        this.a = false;
        this.b = new ConcurrentHashMap<>();
        this.f729c = new ConcurrentHashMap<>();
        this.d = new ConcurrentHashMap<>();
        this.e = new ConcurrentHashMap<>();
    }

    public void b() {
        com.ss.android.downloadlib.e.a().a(new Runnable() { // from class: com.ss.android.downloadlib.addownload.b.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.a) {
                    return;
                }
                synchronized (f.class) {
                    if (!f.this.a) {
                        f.this.e.putAll(i.a().b());
                        f.this.a = true;
                    }
                }
            }
        }, true);
    }

    public ConcurrentHashMap<Long, com.ss.android.downloadad.api.a.b> c() {
        return this.e;
    }

    public static f a() {
        return a.a;
    }

    public DownloadEventConfig b(long j) {
        return this.f729c.get(Long.valueOf(j));
    }

    public void a(DownloadModel downloadModel) {
        if (downloadModel != null) {
            this.b.put(Long.valueOf(downloadModel.getId()), downloadModel);
            if (downloadModel.getDeepLink() != null) {
                downloadModel.getDeepLink().setId(downloadModel.getId());
                downloadModel.getDeepLink().setPackageName(downloadModel.getPackageName());
            }
        }
    }

    public com.ss.android.downloadad.api.a.b b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.a.b bVar : this.e.values()) {
            if (bVar != null && str.equals(bVar.a())) {
                return bVar;
            }
        }
        return null;
    }

    public void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        for (DownloadModel downloadModel : this.b.values()) {
            if ((downloadModel instanceof AdDownloadModel) && TextUtils.equals(downloadModel.getDownloadUrl(), str)) {
                ((AdDownloadModel) downloadModel).setPackageName(str2);
            }
        }
    }

    public void a(long j, DownloadEventConfig downloadEventConfig) {
        if (downloadEventConfig != null) {
            this.f729c.put(Long.valueOf(j), downloadEventConfig);
        }
    }

    public void a(long j, DownloadController downloadController) {
        if (downloadController != null) {
            this.d.put(Long.valueOf(j), downloadController);
        }
    }

    public synchronized void a(com.ss.android.downloadad.api.a.b bVar) {
        if (bVar == null) {
            return;
        }
        this.e.put(Long.valueOf(bVar.b()), bVar);
        i.a().a(bVar);
    }

    public DownloadModel a(long j) {
        return this.b.get(Long.valueOf(j));
    }

    public com.ss.android.downloadad.api.a.b a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.a.b bVar : this.e.values()) {
            if (bVar != null && str.equals(bVar.e())) {
                return bVar;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.a.b a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        for (com.ss.android.downloadad.api.a.b bVar : this.e.values()) {
            if (bVar != null && bVar.s() == downloadInfo.getId()) {
                return bVar;
            }
        }
        if (!TextUtils.isEmpty(downloadInfo.getExtra())) {
            try {
                long a2 = m.a(new JSONObject(downloadInfo.getExtra()), BaseConstants.EVENT_LABEL_EXTRA);
                if (a2 != 0) {
                    for (com.ss.android.downloadad.api.a.b bVar2 : this.e.values()) {
                        if (bVar2 != null && bVar2.b() == a2) {
                            return bVar2;
                        }
                    }
                    com.ss.android.downloadlib.e.c.a().a("getNativeModelByInfo");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (com.ss.android.downloadad.api.a.b bVar3 : this.e.values()) {
            if (bVar3 != null && TextUtils.equals(bVar3.a(), downloadInfo.getUrl())) {
                return bVar3;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.a.b a(int i) {
        for (com.ss.android.downloadad.api.a.b bVar : this.e.values()) {
            if (bVar != null && bVar.s() == i) {
                return bVar;
            }
        }
        return null;
    }

    @NonNull
    public Map<Long, com.ss.android.downloadad.api.a.b> a(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (com.ss.android.downloadad.api.a.b bVar : this.e.values()) {
                if (bVar != null && TextUtils.equals(bVar.a(), str)) {
                    bVar.b(str2);
                    hashMap.put(Long.valueOf(bVar.b()), bVar);
                }
            }
        }
        return hashMap;
    }

    public synchronized void a(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            arrayList.add(String.valueOf(longValue));
            this.e.remove(Long.valueOf(longValue));
        }
        i.a().a((List<String>) arrayList);
    }
}
