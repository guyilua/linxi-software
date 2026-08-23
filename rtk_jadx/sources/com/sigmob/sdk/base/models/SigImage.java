package com.sigmob.sdk.base.models;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SigImage {
    private int height;
    private String imageUrl;
    private int width;

    public SigImage(String str, int i, int i2) {
        this.imageUrl = str;
        this.width = i;
        this.height = i2;
    }

    public int getHeight() {
        return this.height;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public int getWidth() {
        return this.width;
    }
}
