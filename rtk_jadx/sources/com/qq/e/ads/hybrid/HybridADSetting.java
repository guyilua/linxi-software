package com.qq.e.ads.hybrid;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HybridADSetting {
    public static final int TYPE_REWARD_VIDEO = 1;
    private String f;
    private String g;
    private String h;
    private int a = 1;
    private int b = 44;

    /* renamed from: c, reason: collision with root package name */
    private int f7c = -1;
    private int d = -14013133;
    private int e = 16;
    private int i = -1776153;
    private int j = 16;

    public HybridADSetting backButtonImage(String str) {
        this.g = str;
        return this;
    }

    public HybridADSetting backSeparatorLength(int i) {
        this.j = i;
        return this;
    }

    public HybridADSetting closeButtonImage(String str) {
        this.h = str;
        return this;
    }

    public String getBackButtonImage() {
        return this.g;
    }

    public int getBackSeparatorLength() {
        return this.j;
    }

    public String getCloseButtonImage() {
        return this.h;
    }

    public int getSeparatorColor() {
        return this.i;
    }

    public String getTitle() {
        return this.f;
    }

    public int getTitleBarColor() {
        return this.f7c;
    }

    public int getTitleBarHeight() {
        return this.b;
    }

    public int getTitleColor() {
        return this.d;
    }

    public int getTitleSize() {
        return this.e;
    }

    public int getType() {
        return this.a;
    }

    public HybridADSetting separatorColor(int i) {
        this.i = i;
        return this;
    }

    public HybridADSetting title(String str) {
        this.f = str;
        return this;
    }

    public HybridADSetting titleBarColor(int i) {
        this.f7c = i;
        return this;
    }

    public HybridADSetting titleBarHeight(int i) {
        this.b = i;
        return this;
    }

    public HybridADSetting titleColor(int i) {
        this.d = i;
        return this;
    }

    public HybridADSetting titleSize(int i) {
        this.e = i;
        return this;
    }

    public HybridADSetting type(int i) {
        this.a = i;
        return this;
    }
}
