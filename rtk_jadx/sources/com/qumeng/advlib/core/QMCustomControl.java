package com.qumeng.advlib.core;

import android.content.pm.PackageInfo;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class QMCustomControl {
    public String getAndroidId() {
        return null;
    }

    public List<PackageInfo> getAppList() {
        return null;
    }

    public String getDevImei() {
        return null;
    }

    public String getDevImsi() {
        return null;
    }

    public String getMacAddress() {
        return null;
    }

    public String getOaid() {
        return null;
    }

    public IQLocation getQLocation() {
        return null;
    }

    public boolean isCanUseAndroidId() {
        return true;
    }

    public boolean isCanUseAppList() {
        return true;
    }

    public boolean isCanUseBootId() {
        return true;
    }

    public boolean isCanUseOaid() {
        return true;
    }

    public boolean isCanUsePhoneState() {
        return true;
    }
}
