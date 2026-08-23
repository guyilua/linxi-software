package com.ss.android.socialbase.downloader.exception;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class BaseException extends Exception implements Parcelable {
    public static final Parcelable.Creator<BaseException> CREATOR = new Parcelable.Creator<BaseException>() { // from class: com.ss.android.socialbase.downloader.exception.BaseException.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BaseException createFromParcel(Parcel parcel) {
            return new BaseException(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BaseException[] newArray(int i) {
            return new BaseException[i];
        }
    };
    private static final String TAG = "[d-ex]:";
    private int errorCode;
    private String errorMsg;
    private String extraInfo;

    public BaseException() {
        this.extraInfo = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMsg;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public void readFromParcel(Parcel parcel) {
        this.errorCode = parcel.readInt();
        this.errorMsg = parcel.readString();
        this.extraInfo = parcel.readString();
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setExtraInfo(String str) {
        this.extraInfo = str;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "BaseException{errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.errorCode);
        parcel.writeString(this.errorMsg);
        parcel.writeString(this.extraInfo);
    }

    public BaseException(int i, String str) {
        super(TAG.concat(String.valueOf(str)));
        this.extraInfo = "";
        this.errorMsg = TAG.concat(String.valueOf(str));
        this.errorCode = i;
    }

    public BaseException(int i, Throwable th) {
        this(i, com.ss.android.socialbase.downloader.i.f.j(th));
    }

    public BaseException(int i, String str, Throwable th) {
        super(TAG.concat(String.valueOf(str)), th);
        this.extraInfo = "";
        this.errorMsg = TAG.concat(String.valueOf(str));
        this.errorCode = i;
    }

    protected BaseException(Parcel parcel) {
        this.extraInfo = "";
        readFromParcel(parcel);
    }
}
