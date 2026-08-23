package com.qumeng.advlib.open.oaid.qma;

import android.annotation.SuppressLint;
import android.content.Context;
import com.qumeng.advlib.open.oaid.OAIDException;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class j implements com.qumeng.advlib.open.oaid.b {
    private final Context a;
    private Class<?> b;

    /* renamed from: c, reason: collision with root package name */
    private Object f32c;

    @SuppressLint({"PrivateApi"})
    public j(Context context) {
        this.a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.b = cls;
            this.f32c = cls.newInstance();
        } catch (Exception unused) {
        }
    }

    private String b() {
        return (String) this.b.getMethod("getOAID", Context.class).invoke(this.f32c, this.a);
    }

    @Override // com.qumeng.advlib.open.oaid.b
    public boolean a() {
        return this.f32c != null;
    }

    @Override // com.qumeng.advlib.open.oaid.b
    public void a(com.qumeng.advlib.open.oaid.a aVar) {
        if (this.a == null || aVar == null) {
            return;
        }
        if (this.b != null && this.f32c != null) {
            try {
                String b = b();
                if (b != null && b.length() != 0) {
                    aVar.a(b);
                    return;
                }
                throw new OAIDException("OAID query failed");
            } catch (Exception e) {
                aVar.a(e);
                return;
            }
        }
        aVar.a(new OAIDException("Xiaomi IdProvider not exists"));
    }
}
