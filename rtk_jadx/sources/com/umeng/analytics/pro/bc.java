package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bm;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: TSerializer.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class bc {
    private final ByteArrayOutputStream a;
    private final ce b;

    /* renamed from: c, reason: collision with root package name */
    private bs f1024c;

    public bc() {
        this(new bm.a());
    }

    public byte[] a(at atVar) {
        this.a.reset();
        atVar.write(this.f1024c);
        return this.a.toByteArray();
    }

    public String b(at atVar) {
        return new String(a(atVar));
    }

    public bc(bu buVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.a = byteArrayOutputStream;
        ce ceVar = new ce(byteArrayOutputStream);
        this.b = ceVar;
        this.f1024c = buVar.a(ceVar);
    }

    public String a(at atVar, String str) {
        try {
            return new String(a(atVar), str);
        } catch (UnsupportedEncodingException unused) {
            throw new az("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }
}
