package com.ss.android.socialbase.downloader.depend;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class b implements v {
    private boolean a = false;

    @Override // com.ss.android.socialbase.downloader.depend.v
    public void a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.a = true;
    }

    @Override // com.ss.android.socialbase.downloader.depend.v
    public boolean a() {
        return this.a;
    }
}
