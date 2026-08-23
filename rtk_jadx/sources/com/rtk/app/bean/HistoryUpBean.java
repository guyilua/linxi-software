package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HistoryUpBean {
    private String Size;
    private long clickTime;
    private String icon;
    private String name;
    private int upId;
    private String versionName;

    public HistoryUpBean(int i, String str, String str2, String str3, String str4, long j) {
        this.upId = i;
        this.icon = str;
        this.name = str2;
        this.versionName = str3;
        this.Size = str4;
        this.clickTime = j;
    }

    public long getClickTime() {
        return this.clickTime;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public String getSize() {
        return this.Size;
    }

    public int getUpId() {
        return this.upId;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setClickTime(long j) {
        this.clickTime = j;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSize(String str) {
        this.Size = str;
    }

    public void setUpId(int i) {
        this.upId = i;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }
}
