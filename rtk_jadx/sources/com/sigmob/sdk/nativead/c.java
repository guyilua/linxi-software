package com.sigmob.sdk.nativead;

import android.content.Context;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.TouchLocation;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.NativeAdSetting;
import com.sigmob.sdk.base.models.rtb.SingleNativeAdSetting;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c extends com.sigmob.sdk.base.common.i {
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private Boolean r;

    public static c f(BaseAdUnit baseAdUnit) {
        c cVar = new c();
        cVar.b(baseAdUnit);
        return cVar;
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(Context context, TouchLocation touchLocation, TouchLocation touchLocation2, com.sigmob.sdk.base.a aVar, BaseAdUnit baseAdUnit) {
        String str;
        SigMacroCommon macroCommon = baseAdUnit.getMacroCommon();
        if (macroCommon != null) {
            macroCommon.updateClickMarco(touchLocation, touchLocation2);
            str = macroCommon.getCoordinate();
        } else {
            str = "";
        }
        a(aVar, str, true);
    }

    public void a(BaseAdUnit baseAdUnit, final int i, final int i2) {
        ae.a("video_start", (String) null, baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.nativead.c.1
            @Override // com.sigmob.sdk.base.common.ae.a
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("video_time", String.valueOf(i));
                    hashMap.put("begin_time", String.valueOf(i2));
                    ((PointEntitySigmob) obj).setOptions(hashMap);
                }
            }
        });
        SigMacroCommon macroCommon = baseAdUnit.getMacroCommon();
        macroCommon.addMarcoKey(SigMacroCommon._VIDEOTIME_, String.valueOf(i2));
        macroCommon.addMarcoKey(SigMacroCommon._BEGINTIME_, String.valueOf(i));
        com.sigmob.sdk.base.network.g.a(baseAdUnit, "video_start");
    }

    public void a(BaseAdUnit baseAdUnit, final int i, final int i2, final int i3) {
        ae.a("video_pause", (String) null, baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.nativead.c.2
            @Override // com.sigmob.sdk.base.common.ae.a
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("video_time", String.valueOf(i3));
                    hashMap.put("begin_time", String.valueOf(i2));
                    hashMap.put(com.umeng.analytics.pro.d.q, String.valueOf(i));
                    hashMap.put("is_first", String.valueOf(i2 == 0 ? 1 : 0));
                    hashMap.put("is_last", String.valueOf(i < i3 + (-1000) ? 0 : 1));
                    ((PointEntitySigmob) obj).setOptions(hashMap);
                }
            }
        });
        SigMacroCommon macroCommon = baseAdUnit.getMacroCommon();
        macroCommon.addMarcoKey(SigMacroCommon._VIDEOTIME_, String.valueOf(i3));
        macroCommon.addMarcoKey(SigMacroCommon._BEGINTIME_, String.valueOf(i2));
        macroCommon.addMarcoKey(SigMacroCommon._ENDTIME_, String.valueOf(i));
        macroCommon.addMarcoKey(SigMacroCommon._PLAYFIRSTFRAME_, String.valueOf(i2 == 0 ? 1 : 0));
        macroCommon.addMarcoKey(SigMacroCommon._ENDTIME_, String.valueOf(i));
        macroCommon.addMarcoKey(SigMacroCommon._ENDTIME_, String.valueOf(i));
        com.sigmob.sdk.base.network.g.a(baseAdUnit, "video_pause");
    }

    public void a(boolean z) {
        this.r = Boolean.valueOf(z);
    }

    @Override // com.sigmob.sdk.base.common.i
    public void b(BaseAdUnit baseAdUnit) {
        super.b(baseAdUnit);
        NativeAdSetting nativeAdSetting = baseAdUnit.getNativeAdSetting();
        SingleNativeAdSetting singleNativeSetting = baseAdUnit.getSingleNativeSetting();
        if (singleNativeSetting != null) {
            this.q = singleNativeSetting.use_na_video_component.booleanValue();
        }
        if (nativeAdSetting != null) {
            this.l = nativeAdSetting.preview_page_video_mute.intValue();
            this.m = nativeAdSetting.detail_page_video_mute.intValue();
            this.n = nativeAdSetting.impression_percent.intValue();
            this.o = nativeAdSetting.impression_time.intValue();
            this.k = nativeAdSetting.video_auto_play.intValue();
            this.p = nativeAdSetting.end_impression_time.intValue();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.sigmob.sdk.videoAd.f("play_quarter", 0.25f));
        arrayList.add(new com.sigmob.sdk.videoAd.f("play_two_quarters", 0.5f));
        arrayList.add(new com.sigmob.sdk.videoAd.f("play_three_quarters", 0.75f));
        a(arrayList);
    }

    public void c(Context context, BaseAdUnit baseAdUnit) {
        ae.a(PointCategory.TEMPLATE_SHOW, (String) null, baseAdUnit);
    }

    public void d(Context context, BaseAdUnit baseAdUnit) {
        ae.a(PointCategory.TEMPLATE_CLOSE, (String) null, baseAdUnit);
    }

    public void e(Context context, BaseAdUnit baseAdUnit) {
        ae.b("ad_show", null, baseAdUnit);
        com.sigmob.sdk.base.network.g.a(baseAdUnit, "ad_show");
    }

    public void f(Context context, BaseAdUnit baseAdUnit) {
        ae.b("feed_click", null, baseAdUnit);
        com.sigmob.sdk.base.network.g.a(baseAdUnit, "feed_click");
    }

    public boolean l() {
        return this.q;
    }

    public int m() {
        return this.k;
    }

    public boolean n() {
        Boolean bool = this.r;
        return bool != null ? bool.booleanValue() : this.l == 0;
    }

    public boolean o() {
        return this.m != 0;
    }

    public int p() {
        return this.n;
    }

    public int q() {
        return this.o;
    }

    public int r() {
        return this.p;
    }

    public int s() {
        int i = this.n;
        if (i >= 0) {
            return i;
        }
        return 50;
    }

    public int t() {
        int i = this.o;
        if (i >= 0) {
            return i;
        }
        return 1;
    }

    public boolean u() {
        if (m() != 0) {
            return m() == 1 && ClientMetadata.getInstance().getActiveNetworkType() == 100;
        }
        return true;
    }
}
