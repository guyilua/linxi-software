package com.sigmob.sdk.nativead;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ab implements Parcelable {
    public static final Parcelable.Creator<ab> CREATOR = new Parcelable.Creator<ab>() { // from class: com.sigmob.sdk.nativead.ab.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ab createFromParcel(Parcel parcel) {
            return new ab(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ab[] newArray(int i) {
            return new ab[i];
        }
    };
    private int a;
    private int b;

    /* renamed from: c, reason: collision with root package name */
    private int f604c;
    private int d;

    public ab() {
    }

    protected ab(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.f604c = parcel.readInt();
        this.d = parcel.readInt();
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

    public int c() {
        return this.f604c;
    }

    public void c(int i) {
        this.f604c = i;
    }

    public int d() {
        return this.d;
    }

    public void d(int i) {
        this.d = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.f604c);
        parcel.writeInt(this.d);
    }
}
