package com.sigmob.sdk.base.models;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class VideoItem {
    public final int height;
    public final String url;
    public final int width;

    public VideoItem(String str, int i, int i2) {
        this.url = str;
        this.width = i;
        this.height = i2;
    }

    public String toString() {
        return "\"video\":{\"url\"=\"" + this.url + "\", \"width\"=" + this.width + ", \"height\"=" + this.height + '}';
    }
}
