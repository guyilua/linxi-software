package com.windmill.baidu;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.czhj.sdk.logger.SigmobLog;
import com.windmill.baidu.g;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.base.WMLogUtil;
import com.windmill.sdk.custom.WMCustomNativeAdapter;
import com.windmill.sdk.models.BidInfo;
import com.windmill.sdk.natives.WMNativeAdData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class l extends g {
    List<WMNativeAdData> a = new ArrayList();
    g.a b;

    /* renamed from: c, reason: collision with root package name */
    WMCustomNativeAdapter f1153c;
    private BaiduNativeManager d;

    public l(WMCustomNativeAdapter wMCustomNativeAdapter, g.a aVar) {
        this.f1153c = wMCustomNativeAdapter;
        this.b = aVar;
    }

    @Override // com.windmill.baidu.g
    public final void a(Context context, final String str, Map<String, Object> map, Map<String, Object> map2) {
        try {
            this.a.clear();
            int i = 0;
            int i2 = 340;
            if (map != null) {
                try {
                    Object obj = map.get("ad_key_width");
                    int parseInt = (obj == null || ((Integer) obj).intValue() == 0) ? 340 : Integer.parseInt(String.valueOf(obj));
                    Object obj2 = map.get("ad_key_height");
                    if (obj2 != null && ((Integer) obj2).intValue() != 0) {
                        i = Integer.parseInt(String.valueOf(obj2));
                    }
                    i2 = parseInt;
                } catch (Exception e) {
                    WMLogUtil.d(WMLogUtil.TAG, "expressViewWidth:" + e.getMessage());
                }
            }
            WMLogUtil.d(WMLogUtil.TAG, i2 + "-----expressViewWidth--------expressViewHeight-------:" + i);
            this.d = new BaiduNativeManager(context, str);
            RequestParameters.Builder height = new RequestParameters.Builder().downloadAppConfirmPolicy(1).setWidth(i2).setHeight(i);
            BidInfo lastBidInfo = this.f1153c.getLastBidInfo();
            if (lastBidInfo != null) {
                SigmobLog.i(getClass().getSimpleName() + " bidInfo:" + lastBidInfo.toString());
                height.addCustExt("A", lastBidInfo.getWinner()).addCustExt("B", lastBidInfo.getECpm()).addCustExt("C", lastBidInfo.getBidType()).addCustExt("S", lastBidInfo.getExposureStatus()).addCustExt("D", lastBidInfo.getClickStatus()).addCustExt("H", lastBidInfo.getFailReason()).addCustExt("I", lastBidInfo.getSecondPrice()).addCustExt("J", lastBidInfo.getBidTime()).addCustExt("K", lastBidInfo.getRequestId());
            }
            try {
                Object obj3 = map2.get("bidFloor");
                if (obj3 != null) {
                    this.d.setBidFloor(((Integer) obj3).intValue());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.d.loadExpressAd(height.build(), new BaiduNativeManager.ExpressAdListener() { // from class: com.windmill.baidu.BdNativeExpressAd$1
                public void onLpClosed() {
                    WMLogUtil.d(WMLogUtil.TAG, "-----------onLpClosed---------");
                }

                public void onNativeFail(int i3, String str2) {
                    WMLogUtil.d(WMLogUtil.TAG, "-----------onNativeFail---------:" + i3 + ":" + str2);
                    if (l.this.b != null) {
                        l.this.b.onNativeAdFailToLoad(new WMAdapterError(i3, str2 + " codeId " + str));
                    }
                }

                public void onNativeFail(int i3, String str2, ExpressResponse expressResponse) {
                    onNativeFail(i3, str2);
                }

                public void onNativeLoad(List<ExpressResponse> list) {
                    if (list == null || list.isEmpty()) {
                        if (l.this.b != null) {
                            l.this.b.onNativeAdFailToLoad(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "list is null or size be 0 " + str));
                            return;
                        }
                        return;
                    }
                    WMLogUtil.d(WMLogUtil.TAG, "-----------onNativeExpressAdLoad---------" + list.size());
                    String str2 = null;
                    String str3 = "";
                    int i3 = 0;
                    while (i3 < list.size()) {
                        ExpressResponse expressResponse = list.get(i3);
                        b bVar = new b(expressResponse, l.this.f1153c);
                        String pecpm = expressResponse.getPECPM();
                        l.this.a.add(bVar);
                        if (TextUtils.isEmpty(str2)) {
                            str2 = expressResponse.getECPMLevel();
                        }
                        i3++;
                        str3 = pecpm;
                    }
                    l lVar = l.this;
                    g.a aVar = lVar.b;
                    if (aVar != null) {
                        aVar.onNativeAdLoadSuccess(lVar.a, str2, str3);
                    }
                }

                public void onNoAd(int i3, String str2) {
                    WMLogUtil.d(WMLogUtil.TAG, "-----------onNoAd---------:" + i3 + ":" + str2);
                    if (l.this.b != null) {
                        l.this.b.onNativeAdFailToLoad(new WMAdapterError(i3, str2 + " codeId " + str));
                    }
                }

                public void onNoAd(int i3, String str2, ExpressResponse expressResponse) {
                    onNoAd(i3, str2);
                }

                public void onVideoDownloadFailed() {
                    WMLogUtil.d(WMLogUtil.TAG, "-----------onVideoDownloadFailed---------");
                }

                public void onVideoDownloadSuccess() {
                    WMLogUtil.d(WMLogUtil.TAG, "-----------onVideoDownloadSuccess---------");
                }
            });
        } catch (Throwable th) {
            if (this.b != null) {
                this.b.onNativeAdFailToLoad(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), th.getMessage()));
            }
        }
    }

    @Override // com.windmill.baidu.g
    public final void a(String str, LinkedHashMap<String, Object> linkedHashMap) {
        List<WMNativeAdData> list = this.a;
        if (list == null || list.size() <= 0) {
            return;
        }
        a.a((ExpressResponse) ((b) this.a.get(0)).getOriginNativeAdData(), str, linkedHashMap);
    }

    @Override // com.windmill.baidu.g
    public final boolean a() {
        return this.a.size() > 0;
    }

    @Override // com.windmill.baidu.g
    public final List<WMNativeAdData> b() {
        return this.a;
    }

    @Override // com.windmill.baidu.g
    public final void b(String str, LinkedHashMap<String, Object> linkedHashMap) {
        List<WMNativeAdData> list = this.a;
        if (list == null || list.size() <= 0) {
            return;
        }
        a.b((ExpressResponse) ((b) this.a.get(0)).getOriginNativeAdData(), str, linkedHashMap);
    }

    @Override // com.windmill.baidu.g
    public final Map<String, Object> c() {
        ExpressResponse expressResponse;
        Object adDataForKey;
        try {
            List<WMNativeAdData> list = this.a;
            if (list == null || list.size() <= 0 || (expressResponse = (ExpressResponse) this.a.get(0).getOriginNativeAdData()) == null || (adDataForKey = expressResponse.getAdDataForKey("request_id")) == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("request_id", adDataForKey);
            return hashMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
