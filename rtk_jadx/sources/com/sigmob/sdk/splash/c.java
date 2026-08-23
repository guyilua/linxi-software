package com.sigmob.sdk.splash;

import android.content.Context;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.common.utils.TouchLocation;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.SplashAdSetting;
import com.sigmob.sdk.base.mta.PointCategory;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c extends com.sigmob.sdk.base.common.i {
    private int k = 3;
    private boolean l;

    public static c f(BaseAdUnit baseAdUnit) {
        c cVar = new c();
        cVar.b(baseAdUnit);
        return cVar;
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(Context context, int i, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
        ae.a("start", (String) null, baseAdUnit, (ae.a) null);
        com.sigmob.sdk.base.network.g.a(baseAdUnit, "start");
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(Context context, TouchLocation touchLocation, TouchLocation touchLocation2, com.sigmob.sdk.base.a aVar, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
        com.sigmob.sdk.base.network.g.a(baseAdUnit, "click");
    }

    @Override // com.sigmob.sdk.base.common.i
    public void b(Context context, int i, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
        ae.b(PointCategory.CLOSE, null, baseAdUnit);
        com.sigmob.sdk.base.network.g.a(baseAdUnit, "ad_close");
    }

    @Override // com.sigmob.sdk.base.common.i
    public void b(BaseAdUnit baseAdUnit) {
        super.b(baseAdUnit);
        SplashAdSetting splashAdSetting = baseAdUnit.getSplashAdSetting();
        if (splashAdSetting != null) {
            this.k = splashAdSetting.show_duration.intValue();
            this.l = splashAdSetting.enable_close_on_click.booleanValue();
        }
    }

    @Override // com.sigmob.sdk.base.common.i
    public void c(Context context, int i, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
        ae.b("skip", null, baseAdUnit);
        com.sigmob.sdk.base.network.g.a(baseAdUnit, "skip");
    }

    public int l() {
        return this.k;
    }

    public boolean m() {
        return this.l;
    }
}
