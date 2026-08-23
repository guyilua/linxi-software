package com.ss.android.socialbase.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c implements Parcelable, Comparable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.ss.android.socialbase.downloader.model.c.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int i) {
            return new c[i];
        }
    };
    private final String a;
    private final String b;

    public c(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (!(obj instanceof c)) {
            return 1;
        }
        c cVar = (c) obj;
        if (TextUtils.equals(this.a, cVar.a())) {
            return 0;
        }
        String str = this.a;
        if (str == null) {
            return -1;
        }
        int compareTo = str.compareTo(cVar.a());
        if (compareTo > 0) {
            return 1;
        }
        return compareTo < 0 ? -1 : 0;
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
            c cVar = (c) obj;
            if (TextUtils.equals(this.a, cVar.a) && TextUtils.equals(this.b, cVar.b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "HttpHeader{name='" + this.a + "', value='" + this.b + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }

    protected c(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }
}
