package com.sigmob.sdk.newInterstitial;

import android.content.Context;
import android.os.Bundle;
import com.sigmob.sdk.base.common.AdActivity;
import com.sigmob.sdk.base.common.TransparentAdActivity;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.m;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.videoAd.BaseAdActivity;
import com.sigmob.windad.WindAdRequest;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e extends com.sigmob.sdk.mraid.e {

    /* renamed from: c, reason: collision with root package name */
    private NewInterstitialAdBroadcastReceiver f632c;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a extends o.b {
        void c(BaseAdUnit baseAdUnit, String str);

        void f(BaseAdUnit baseAdUnit);

        void g(BaseAdUnit baseAdUnit);

        void h(BaseAdUnit baseAdUnit);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(o.b bVar) {
        super(bVar);
    }

    private static boolean b(MaterialMeta materialMeta) {
        return materialMeta.creative_type.intValue() == m.CreativeTypeMRAIDTWO.a();
    }

    public static boolean c(BaseAdUnit baseAdUnit) {
        boolean d = com.sigmob.sdk.mraid.e.d(baseAdUnit);
        MaterialMeta material = baseAdUnit.getMaterial();
        return d && (b(material) || c(material));
    }

    private static boolean c(MaterialMeta materialMeta) {
        return materialMeta.creative_type.intValue() == m.CreativeTypeNewInterstitial.a() && materialMeta.template_id.intValue() != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.x
    public void a(o.b bVar) {
        super.a(bVar);
    }

    @Override // com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.x
    public void a(BaseAdUnit baseAdUnit, Bundle bundle) {
        Context e;
        Class cls;
        com.sigmob.sdk.base.common.h.a(baseAdUnit);
        super.a(baseAdUnit, bundle);
        if (this.a instanceof a) {
            NewInterstitialAdBroadcastReceiver newInterstitialAdBroadcastReceiver = new NewInterstitialAdBroadcastReceiver(baseAdUnit, (a) this.a, baseAdUnit.getUuid());
            this.f632c = newInterstitialAdBroadcastReceiver;
            newInterstitialAdBroadcastReceiver.a(newInterstitialAdBroadcastReceiver);
        }
        int ad_type = baseAdUnit.getAd_type();
        String str = BaseAdActivity.j;
        if (ad_type == 6) {
            if (baseAdUnit.getCreativeType() == m.CreativeTypeMRAIDTWO.a()) {
                str = BaseAdActivity.d;
            } else {
                baseAdUnit.getCreativeType();
                m.CreativeTypeNewInterstitial.a();
            }
        }
        final String adslot_id = baseAdUnit.getAdslot_id();
        ae.a(PointCategory.VOPEN, (String) null, baseAdUnit, (WindAdRequest) null, (LoadAdRequest) null, new ae.a() { // from class: com.sigmob.sdk.newInterstitial.e.1
            @Override // com.sigmob.sdk.base.common.ae.a
            public void a(Object obj) {
                Map options;
                if (!(obj instanceof PointEntitySigmob) || (options = ((PointEntitySigmob) obj).getOptions()) == null) {
                    return;
                }
                options.put("show_count", String.valueOf(com.sigmob.sdk.base.common.h.h(adslot_id)));
                com.sigmob.sdk.base.common.h.g(adslot_id);
            }
        });
        if (baseAdUnit.getMaterial().theme_data.intValue() == 1 || baseAdUnit.getTemplateType() == 1) {
            e = com.sigmob.sdk.b.e();
            cls = TransparentAdActivity.class;
        } else {
            e = com.sigmob.sdk.b.e();
            cls = AdActivity.class;
        }
        BaseAdActivity.a(e, cls, baseAdUnit.getUuid(), bundle, str);
    }

    @Override // com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.x
    public boolean a(BaseAdUnit baseAdUnit) {
        boolean a2 = super.a(baseAdUnit);
        MaterialMeta material = baseAdUnit.getMaterial();
        return a2 && (b(material) || c(material));
    }

    @Override // com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.x
    public void b(BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.base.common.h.b(baseAdUnit);
        super.b(baseAdUnit);
    }
}
