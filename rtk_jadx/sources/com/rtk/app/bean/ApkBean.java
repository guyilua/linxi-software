package com.rtk.app.bean;

import android.graphics.drawable.Drawable;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ApkBean {
    private Drawable icon;
    private boolean isInstall;
    private String name;
    private String packageName;
    private String path;
    private String size;
    private String version;
    private int versionCode;

    public Drawable getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPath() {
        return this.path;
    }

    public String getSize() {
        return this.size;
    }

    public String getVersion() {
        return this.version;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public boolean isInstall() {
        return this.isInstall;
    }

    public void setIcon(Drawable drawable) {
        this.icon = drawable;
    }

    public void setInstall(boolean z) {
        this.isInstall = z;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setSize(String str) {
        this.size = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void setVersionCode(int i) {
        this.versionCode = i;
    }
}
