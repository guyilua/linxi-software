package com.sigmob.windad;

import android.content.pm.PackageInfo;
import android.location.Location;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class WindCustomController {
    public String getAndroidId() {
        return null;
    }

    public String getDevImei() {
        return null;
    }

    public String getDevOaid() {
        return null;
    }

    public List<PackageInfo> getInstallPackageInfoList() {
        return null;
    }

    public Location getLocation() {
        return null;
    }

    public boolean isCanUseAndroidId() {
        return true;
    }

    public boolean isCanUseAppList() {
        return true;
    }

    public boolean isCanUseLocation() {
        return true;
    }

    public boolean isCanUseOaid() {
        return true;
    }

    public boolean isCanUsePhoneState() {
        return true;
    }
}
