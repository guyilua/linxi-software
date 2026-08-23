package com.sigmob.sdk.base.mta;

import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.mta.PointEntitySuper;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.b;
import com.sigmob.sdk.base.f;
import com.sigmob.sdk.base.k;
import com.sigmob.sdk.base.l;
import com.sigmob.windad.WindAds;
import java.util.Iterator;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PointEntitySigmobSuper extends PointEntitySuper {
    public String appId() {
        return WindAds.sharedAds().getAppId();
    }

    public DeviceContext getDeviceContext() {
        return b.b();
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
}
