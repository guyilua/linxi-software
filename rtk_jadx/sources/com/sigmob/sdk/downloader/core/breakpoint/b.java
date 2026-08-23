package com.sigmob.sdk.downloader.core.breakpoint;

import android.database.Cursor;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    private final int a;
    private final long b;

    /* renamed from: c, reason: collision with root package name */
    private final long f497c;
    private final long d;

    public b(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex(f.h);
        this.a = columnIndex >= 0 ? cursor.getInt(columnIndex) : 0;
        this.b = cursor.getColumnIndex(f.j) >= 0 ? cursor.getInt(r0) : 0L;
        this.f497c = cursor.getColumnIndex(f.k) >= 0 ? cursor.getInt(r0) : 0L;
        this.d = cursor.getColumnIndex(f.l) >= 0 ? cursor.getInt(r0) : 0L;
    }

    public int a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }

    public long c() {
        return this.f497c;
    }

    public long d() {
        return this.d;
    }

    public a e() {
        return new a(this.b, this.f497c, this.d);
    }
}
