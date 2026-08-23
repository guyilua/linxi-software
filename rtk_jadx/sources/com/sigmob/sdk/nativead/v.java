package com.sigmob.sdk.nativead;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.network.e;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.natives.WindNativeAdData;
import com.sigmob.windad.natives.WindNativeAdRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class v implements e.a {
    public static final int a = 1;
    public static final int b = 2;

    /* renamed from: c, reason: collision with root package name */
    public static final int f620c = 3;
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    private List<BaseAdUnit> h;
    private x i;
    private WindNativeAdRequest j;
    private boolean k;
    private final int l = 20481;
    private Handler g = new Handler(Looper.getMainLooper()) { // from class: com.sigmob.sdk.nativead.v.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 20481 && v.this.k) {
                v.this.g.removeMessages(20481);
                v vVar = v.this;
                WindAdError windAdError = WindAdError.ERROR_SIGMOB_AD_TIME_OUT;
                vVar.a(null, windAdError.getErrorCode(), windAdError.getMessage());
            }
        }
    };

    public v(WindNativeAdRequest windNativeAdRequest, x xVar) {
        this.j = windNativeAdRequest;
        this.i = xVar;
    }

    private WindNativeAdData a(BaseAdUnit baseAdUnit) {
        return new ad(baseAdUnit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final List<WindNativeAdData> list, final int i, final String str) {
        this.k = false;
        this.g.removeMessages(20481);
        this.g.post(new Runnable() { // from class: com.sigmob.sdk.nativead.v.2
            @Override // java.lang.Runnable
            public void run() {
                if (v.this.i != null) {
                    if (i != 0) {
                        v.this.i.onNativeAdLoadFail(i, str);
                    } else {
                        v.this.i.onNativeAdLoaded(list);
                    }
                }
            }
        });
    }

    public int a(int i, String str, int i2, String str2) {
        WindAdError windAdError;
        int i3 = 1;
        this.k = true;
        com.sigmob.sdk.base.common.y a2 = com.sigmob.sdk.base.common.y.a(this.j.getPlacementId());
        LoadAdRequest loadAdRequest = new LoadAdRequest(this.j);
        loadAdRequest.setBidToken(str);
        loadAdRequest.setBidFloor(i2);
        loadAdRequest.setCurrency(str2);
        loadAdRequest.setAd_count(i);
        a2.a++;
        com.sigmob.sdk.base.common.z a3 = com.sigmob.sdk.base.common.z.a(this.j.getPlacementId());
        a3.a++;
        if (i < 1) {
            windAdError = WindAdError.ERROR_SIGMOB_NATIVE_ADCOUNT;
        } else {
            long j = a2.g;
            if (j <= 0 || j + (a2.d * 1000) <= System.currentTimeMillis()) {
                this.g.sendEmptyMessageDelayed(20481, com.sigmob.sdk.base.l.a().y());
                a2.g = System.currentTimeMillis();
                com.sigmob.sdk.base.network.e.a(loadAdRequest, this);
                com.sigmob.sdk.base.common.y.a(this.j.getPlacementId(), a2);
                com.sigmob.sdk.base.common.z.a(this.j.getPlacementId(), a3);
                return i3;
            }
            List<BaseAdUnit> a4 = com.sigmob.sdk.base.common.h.a(this.j.getPlacementId(), a2.f, i);
            if (!a4.isEmpty()) {
                this.h = a4;
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < a4.size(); i4++) {
                    BaseAdUnit baseAdUnit = a4.get(i4);
                    baseAdUnit.setLoad_id(loadAdRequest.getLoadId());
                    arrayList.add(a(baseAdUnit));
                    if (baseAdUnit.getAd_source_channel().equalsIgnoreCase(com.sigmob.sdk.base.k.i)) {
                        com.sigmob.sdk.base.common.h.g().f(baseAdUnit);
                    }
                }
                ae.a(PointCategory.READY, (String) null, this.h.get(0), loadAdRequest, (ae.a) null);
                a2.b += a4.size();
                a3.b += a4.size();
                a(arrayList, 0, null);
                i3 = 0;
                com.sigmob.sdk.base.common.y.a(this.j.getPlacementId(), a2);
                com.sigmob.sdk.base.common.z.a(this.j.getPlacementId(), a3);
                return i3;
            }
            windAdError = WindAdError.ERROR_NO_AD;
        }
        a(null, windAdError.getErrorCode(), windAdError.getMessage());
        i3 = 0;
        com.sigmob.sdk.base.common.y.a(this.j.getPlacementId(), a2);
        com.sigmob.sdk.base.common.z.a(this.j.getPlacementId(), a3);
        return i3;
    }

    public String a() {
        BaseAdUnit baseAdUnit;
        BiddingResponse biddingResponse;
        List<BaseAdUnit> list = this.h;
        if (list == null || list.size() <= 0 || (baseAdUnit = this.h.get(0)) == null || (biddingResponse = baseAdUnit.bidding_response) == null) {
            return null;
        }
        return String.valueOf(biddingResponse.ecpm);
    }

    @Override // com.sigmob.sdk.base.network.e.a
    public void a(int i, String str, String str2, LoadAdRequest loadAdRequest) {
        ae.a(PointCategory.RESPOND, "0", loadAdRequest);
        a(null, i, str);
    }

    public void a(String str, String str2) {
        BaseAdUnit baseAdUnit;
        List<BaseAdUnit> list = this.h;
        if (list == null || (baseAdUnit = list.get(0)) == null || baseAdUnit.bidding_response == null) {
            return;
        }
        baseAdUnit.getMacroCommon().addMarcoKey(str, str2);
    }

    @Override // com.sigmob.sdk.base.network.e.a
    public void a(final List<BaseAdUnit> list, LoadAdRequest loadAdRequest) {
        ae.a(PointCategory.RESPOND, "1", (BaseAdUnit) null, loadAdRequest, new ae.a() { // from class: com.sigmob.sdk.nativead.v.3
            @Override // com.sigmob.sdk.base.common.ae.a
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("ad_count", String.valueOf(list.size()));
                    ((PointEntitySigmob) obj).setOptions(hashMap);
                }
            }
        });
        com.sigmob.sdk.base.common.y a2 = com.sigmob.sdk.base.common.y.a(this.j.getPlacementId());
        if (a2.e > 0 && ((list = com.sigmob.sdk.base.common.h.a(this.j.getPlacementId(), a2.f, this.j.getAdCount())) == null || list.isEmpty())) {
            this.h = null;
            WindAdError windAdError = WindAdError.ERROR_NO_AD;
            a(null, windAdError.getErrorCode(), windAdError.getMessage());
            return;
        }
        this.h = list;
        com.sigmob.sdk.base.common.z a3 = com.sigmob.sdk.base.common.z.a(this.j.getPlacementId());
        a2.b += this.h.size();
        a3.b += this.h.size();
        com.sigmob.sdk.base.common.y.a(this.j.getPlacementId(), a2);
        com.sigmob.sdk.base.common.z.a(this.j.getPlacementId(), a3);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.h.size(); i++) {
            BaseAdUnit baseAdUnit = this.h.get(i);
            arrayList.add(a(baseAdUnit));
            if (baseAdUnit.getAd_source_channel().equalsIgnoreCase(com.sigmob.sdk.base.k.i)) {
                com.sigmob.sdk.base.common.h.g().f(baseAdUnit);
            }
        }
        ae.a(PointCategory.READY, (String) null, this.h.get(0), loadAdRequest, (ae.a) null);
        a(arrayList, 0, null);
    }

    public Map<String, BiddingResponse> b() {
        BaseAdUnit baseAdUnit;
        List<BaseAdUnit> list = this.h;
        if (list == null || (baseAdUnit = list.get(0)) == null || baseAdUnit.bidding_response == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(baseAdUnit.getRequestId(), baseAdUnit.bidding_response);
        return hashMap;
    }
}
