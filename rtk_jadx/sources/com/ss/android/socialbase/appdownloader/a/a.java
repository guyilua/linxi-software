package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.util.Log;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class a implements e {
    protected final Context a;
    protected final com.ss.android.socialbase.downloader.g.a b;

    /* renamed from: c, reason: collision with root package name */
    protected final String f799c;

    public a(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str) {
        this.a = context;
        this.b = aVar;
        this.f799c = str;
    }

    public boolean a() {
        if (this.a == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                Log.e("AbsDevicePlan", "check is valid failed!", th);
            }
        }
        return b().resolveActivity(this.a.getPackageManager()) != null;
    }
}
