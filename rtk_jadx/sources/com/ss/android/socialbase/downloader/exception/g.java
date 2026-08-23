package com.ss.android.socialbase.downloader.exception;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class g extends BaseException {
    public g(int i, String str) {
        super(i, str);
    }

    public g a(String str) {
        setExtraInfo(str);
        return this;
    }

    public String a() {
        return getExtraInfo();
    }
}
