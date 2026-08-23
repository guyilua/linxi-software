package com.sigmob.sdk.base.common;

import android.os.Parcel;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class g {
    private int a;
    private int b;

    public g(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    protected g(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public int b() {
        return this.b;
    }

    public void b(int i) {
        this.b = i;
    }
}
