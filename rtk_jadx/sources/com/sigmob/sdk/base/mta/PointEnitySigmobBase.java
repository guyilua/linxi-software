package com.sigmob.sdk.base.mta;

import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.mta.PointEntityBase;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.b;
import com.sigmob.sdk.base.f;
import com.sigmob.sdk.base.k;
import com.sigmob.sdk.base.l;
import com.sigmob.windad.WindAds;
import java.util.Iterator;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PointEnitySigmobBase extends PointEntityBase {
    private String a;
    private String b;

    /* renamed from: c, reason: collision with root package name */
    private String f414c;

    public String appId() {
        return WindAds.sharedAds().getAppId();
    }

    public DeviceContext getDeviceContext() {
        return b.b();
    }

    public String getIs_custom_android_id() {
        return this.b;
    }

    public String getIs_custom_imei() {
        return this.a;
    }

    public String getIs_custom_oaid() {
        return this.f414c;
    }

    public String getSdkversion() {
        return k.k;
    }

    public boolean isAcTypeBlock() {
        if (!f.a().i()) {
            return true;
        }
        Iterator<Integer> it = l.a().H().iterator();
        while (it.hasNext()) {
            if (getAc_type().equals(String.valueOf(it.next()))) {
                SigmobLog.e("black ac type " + getAc_type());
                return true;
            }
        }
        return false;
    }

    public void setIs_custom_android_id(String str) {
        this.b = str;
    }

    public void setIs_custom_imei(String str) {
        this.a = str;
    }

    public void setIs_custom_oaid(String str) {
        this.f414c = str;
    }
}
