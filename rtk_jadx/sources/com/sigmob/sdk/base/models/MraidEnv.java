package com.sigmob.sdk.base.models;

import com.czhj.sdk.common.ClientMetadata;
import com.czhj.volley.toolbox.StringUtil;
import com.sigmob.sdk.base.f;
import com.sigmob.sdk.base.k;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MraidEnv {
    public final Boolean coppa;
    public final String version = "2.0";
    public final String sdk = StringUtil.decode(StringUtil.s);
    public final String sdkVersion = k.k;
    public final String appId = ClientMetadata.getInstance().getAppPackageName();
    public final String ifa = ClientMetadata.getInstance().getAdvertisingId();
    public final Boolean limitAdTracking = Boolean.valueOf(ClientMetadata.getInstance().getLimitAdTrackingEnabled());

    public MraidEnv() {
        this.coppa = Boolean.valueOf(f.a().c() == 1);
    }
}
