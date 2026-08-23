package com.ss.android.downloadlib.a.a;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.ss.android.downloadlib.a.a.b.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i) {
            return new b[i];
        }
    };
    public int a;
    public int b;

    /* renamed from: c, reason: collision with root package name */
    public String f714c;
    public int d;
    public String e;
    public String f;

    public b() {
        this.f714c = "";
        this.e = "";
        this.f = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (this.a == bVar.a && this.b == bVar.b) {
                String str = this.f714c;
                if (str != null) {
                    return str.equals(bVar.f714c);
                }
                if (bVar.f714c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i = ((this.a * 31) + this.b) * 31;
        String str = this.f714c;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeString(this.f714c);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.d);
    }

    protected b(Parcel parcel) {
        this.f714c = "";
        this.e = "";
        this.f = "";
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.f714c = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.d = parcel.readInt();
    }
}
