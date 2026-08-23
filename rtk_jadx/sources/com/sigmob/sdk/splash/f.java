package com.sigmob.sdk.splash;

import android.os.Bundle;
import android.text.TextUtils;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.common.x;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class f extends x {

    /* renamed from: c, reason: collision with root package name */
    c f643c;
    private SplashAdBroadcastReceiver d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a extends o.b, o.c {
        void c();

        void d();

        void e();

        void f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(o.b bVar) {
        super(bVar);
    }

    public static boolean c(BaseAdUnit baseAdUnit) {
        MaterialMeta material = baseAdUnit.getMaterial();
        if (TextUtils.isEmpty(baseAdUnit.getCrid())) {
            return false;
        }
        return (TextUtils.isEmpty(material.video_url) && TextUtils.isEmpty(material.image_src)) ? false : true;
    }

    @Override // com.sigmob.sdk.base.common.x
    protected void a(o.b bVar) {
        this.a = bVar;
    }

    @Override // com.sigmob.sdk.base.common.x
    public void a(BaseAdUnit baseAdUnit, Bundle bundle) {
        if (baseAdUnit == null) {
            baseAdUnit = this.b;
        }
        this.f643c = (c) baseAdUnit.getAdConfig();
        super.a(baseAdUnit, bundle);
        if (this.a instanceof a) {
            SplashAdBroadcastReceiver splashAdBroadcastReceiver = new SplashAdBroadcastReceiver((a) this.a, baseAdUnit.getUuid());
            this.d = splashAdBroadcastReceiver;
            splashAdBroadcastReceiver.a(splashAdBroadcastReceiver);
        }
    }

    @Override // com.sigmob.sdk.base.common.x
    public void a(Map<String, Object> map, BaseAdUnit baseAdUnit) {
        super.a(map, baseAdUnit);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sigmob.sdk.base.common.x
    public boolean a(BaseAdUnit baseAdUnit) {
        return c(baseAdUnit);
    }

    @Override // com.sigmob.sdk.base.common.x
    public void b(BaseAdUnit baseAdUnit) {
        super.b(baseAdUnit);
        SplashAdBroadcastReceiver splashAdBroadcastReceiver = this.d;
        if (splashAdBroadcastReceiver != null) {
            splashAdBroadcastReceiver.b(splashAdBroadcastReceiver);
            this.d = null;
        }
    }
}
