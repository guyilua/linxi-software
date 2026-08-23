package com.sigmob.sdk.videoAd;

import com.sigmob.sdk.base.common.ap;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.models.BaseAdUnit;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class k extends ap {

    /* renamed from: c, reason: collision with root package name */
    private RewardVideoAdBroadcastReceiver f657c;
    private boolean d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a extends o.b {
        void c(BaseAdUnit baseAdUnit, String str);

        void f(BaseAdUnit baseAdUnit);

        void g(BaseAdUnit baseAdUnit);

        void h(BaseAdUnit baseAdUnit);

        void i(BaseAdUnit baseAdUnit);
    }

    public k(o.b bVar, boolean z) {
        super(bVar);
        this.d = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    @Override // com.sigmob.sdk.base.common.ap, com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.sigmob.sdk.base.models.BaseAdUnit r11, android.os.Bundle r12) {
        /*
            r10 = this;
            super.a(r11, r12)
            com.sigmob.sdk.base.common.o$b r0 = r10.a
            boolean r0 = r0 instanceof com.sigmob.sdk.videoAd.k.a
            if (r0 == 0) goto L1b
            com.sigmob.sdk.videoAd.RewardVideoAdBroadcastReceiver r0 = new com.sigmob.sdk.videoAd.RewardVideoAdBroadcastReceiver
            com.sigmob.sdk.base.common.o$b r1 = r10.a
            com.sigmob.sdk.videoAd.k$a r1 = (com.sigmob.sdk.videoAd.k.a) r1
            java.lang.String r2 = r11.getUuid()
            r0.<init>(r11, r1, r2)
            r10.f657c = r0
            r0.a(r0)
        L1b:
            int r0 = r11.getAd_type()
            r1 = 4
            r2 = 1
            if (r0 == r2) goto L29
            int r0 = r11.getAd_type()
            if (r0 != r1) goto L47
        L29:
            int r0 = r11.getCreativeType()
            com.sigmob.sdk.base.common.m r3 = com.sigmob.sdk.base.common.m.CreativeTypeMRAID
            int r3 = r3.a()
            if (r0 != r3) goto L38
            java.lang.String r0 = "mraid"
            goto L49
        L38:
            int r0 = r11.getCreativeType()
            com.sigmob.sdk.base.common.m r3 = com.sigmob.sdk.base.common.m.CreativeTypeMRAIDTWO
            int r3 = r3.a()
            if (r0 != r3) goto L47
            java.lang.String r0 = "mraid_two"
            goto L49
        L47:
            java.lang.String r0 = "reward"
        L49:
            if (r12 == 0) goto L52
            boolean r3 = r10.d
            java.lang.String r4 = "isHalfInterstitial"
            r12.putBoolean(r4, r3)
        L52:
            java.lang.String r3 = r11.getAdslot_id()
            r5 = 0
            r7 = 0
            r8 = 0
            com.sigmob.sdk.videoAd.k$1 r9 = new com.sigmob.sdk.videoAd.k$1
            r9.<init>()
            java.lang.String r4 = "vopen"
            r6 = r11
            com.sigmob.sdk.base.common.ae.a(r4, r5, r6, r7, r8, r9)
            int r3 = r11.getAd_type()
            if (r3 != r1) goto L7a
            com.sigmob.sdk.base.models.rtb.MaterialMeta r1 = r11.getMaterial()
            java.lang.Integer r1 = r1.theme_data
            int r1 = r1.intValue()
            if (r1 == r2) goto L98
            boolean r1 = r10.d
            if (r1 != 0) goto L98
        L7a:
            int r1 = r11.getCreativeType()
            com.sigmob.sdk.base.common.m r3 = com.sigmob.sdk.base.common.m.CreativeTypeMRAIDTWO
            int r3 = r3.a()
            if (r1 != r3) goto L9f
            com.sigmob.sdk.base.models.rtb.MaterialMeta r1 = r11.getMaterial()
            java.lang.Integer r1 = r1.theme_data
            int r1 = r1.intValue()
            if (r1 == r2) goto L98
            int r1 = r11.getTemplateType()
            if (r1 != r2) goto L9f
        L98:
            android.content.Context r1 = com.sigmob.sdk.b.e()
            java.lang.Class<com.sigmob.sdk.base.common.TransparentAdActivity> r2 = com.sigmob.sdk.base.common.TransparentAdActivity.class
            goto La5
        L9f:
            android.content.Context r1 = com.sigmob.sdk.b.e()
            java.lang.Class<com.sigmob.sdk.base.common.AdActivity> r2 = com.sigmob.sdk.base.common.AdActivity.class
        La5:
            java.lang.String r11 = r11.getUuid()
            com.sigmob.sdk.videoAd.BaseAdActivity.a(r1, r2, r11, r12, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.videoAd.k.a(com.sigmob.sdk.base.models.BaseAdUnit, android.os.Bundle):void");
    }

    @Override // com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.x
    public void a(Map<String, Object> map, BaseAdUnit baseAdUnit) {
        super.a(map, baseAdUnit);
    }

    @Override // com.sigmob.sdk.base.common.ap, com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.x
    public void b(BaseAdUnit baseAdUnit) {
        RewardVideoAdBroadcastReceiver rewardVideoAdBroadcastReceiver = this.f657c;
        if (rewardVideoAdBroadcastReceiver != null) {
            rewardVideoAdBroadcastReceiver.b(rewardVideoAdBroadcastReceiver);
            this.f657c = null;
        }
        super.b(baseAdUnit);
    }
}
