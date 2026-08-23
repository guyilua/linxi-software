package com.qumeng.advlib.core;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface IQLocation {
    public static final int TYPE_BAIDU = 2;
    public static final int TYPE_CGJ02 = 0;
    public static final int TYPE_WGS84 = 1;

    double getLatitude();

    double getLongitude();

    int getType();
}
