package com.sigmob.sdk.downloader.core.breakpoint;

import android.database.Cursor;
import java.io.File;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d {
    private final int a;
    private final String b;

    /* renamed from: c, reason: collision with root package name */
    private final String f499c;
    private final String d;
    private final String e;
    private final boolean f;
    private final boolean g;

    public d(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        boolean z = false;
        this.a = columnIndex >= 0 ? cursor.getInt(columnIndex) : 0;
        int columnIndex2 = cursor.getColumnIndex("url");
        this.b = columnIndex2 >= 0 ? cursor.getString(columnIndex2) : "";
        int columnIndex3 = cursor.getColumnIndex(f.f503c);
        this.f499c = columnIndex3 >= 0 ? cursor.getString(columnIndex3) : "";
        int columnIndex4 = cursor.getColumnIndex(f.d);
        this.d = columnIndex4 >= 0 ? cursor.getString(columnIndex4) : "";
        int columnIndex5 = cursor.getColumnIndex("filename");
        this.e = columnIndex5 >= 0 ? cursor.getString(columnIndex5) : "";
        int columnIndex6 = cursor.getColumnIndex(f.f);
        this.f = columnIndex6 >= 0 && cursor.getInt(columnIndex6) == 1;
        int columnIndex7 = cursor.getColumnIndex("chunked");
        if (columnIndex7 >= 0 && cursor.getInt(columnIndex7) == 1) {
            z = true;
        }
        this.g = z;
    }

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.f499c;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    public boolean g() {
        return this.g;
    }

    public c h() {
        c cVar = new c(this.a, this.b, new File(this.d), this.e, this.f);
        cVar.a(this.f499c);
        cVar.a(this.g);
        return cVar;
    }
}
