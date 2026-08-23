package com.windmill.baidu;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.NativeResponse;
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
public final class k extends g {
    List<WMNativeAdData> a = new ArrayList();
    g.a b;

    /* renamed from: c, reason: collision with root package name */
    WMCustomNativeAdapter f1152c;
    private BaiduNativeManager d;

    public k(WMCustomNativeAdapter wMCustomNativeAdapter, g.a aVar) {
        this.f1152c = wMCustomNativeAdapter;
        this.b = aVar;
    }

    @Override // com.windmill.baidu.g
    public final void a(final Context context, final String str, Map<String, Object> map, final Map<String, Object> map2) {
        try {
            this.a.clear();
            SigmobLog.i(getClass().getSimpleName() + " loadAd " + str);
            this.d = new BaiduNativeManager(context, str);
            RequestParameters.Builder downloadAppConfirmPolicy = new RequestParameters.Builder().downloadAppConfirmPolicy(1);
            BidInfo lastBidInfo = this.f1152c.getLastBidInfo();
            if (lastBidInfo != null) {
                SigmobLog.i(getClass().getSimpleName() + " bidInfo:" + lastBidInfo.toString());
                downloadAppConfirmPolicy.addCustExt("A", lastBidInfo.getWinner()).addCustExt("B", lastBidInfo.getECpm()).addCustExt("C", lastBidInfo.getBidType()).addCustExt("S", lastBidInfo.getExposureStatus()).addCustExt("D", lastBidInfo.getClickStatus()).addCustExt("H", lastBidInfo.getFailReason()).addCustExt("I", lastBidInfo.getSecondPrice()).addCustExt("J", lastBidInfo.getBidTime()).addCustExt("K", lastBidInfo.getRequestId());
            }
            try {
                Object obj = map2.get("bidFloor");
                if (obj != null) {
                    this.d.setBidFloor(((Integer) obj).intValue());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.d.loadPortraitVideoAd(downloadAppConfirmPolicy.build(), new BaiduNativeManager.PortraitVideoAdListener() { // from class: com.windmill.baidu.BdNativeDrawUnifiedAd$1
                public void onAdClick() {
                    WMCustomNativeAdapter wMCustomNativeAdapter;
                    WMLogUtil.d(WMLogUtil.TAG, "-----------onAdClick---------");
                    List<WMNativeAdData> list = k.this.a;
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    for (int i = 0; i < k.this.a.size(); i++) {
                        j jVar = (j) k.this.a.get(i);
                        if (jVar != null) {
                            try {
                                if (jVar.hashCode() == jVar.f1151c.hashCode()) {
                                    WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener = jVar.a;
                                    if (nativeAdInteractionListener != null && (wMCustomNativeAdapter = jVar.b) != null) {
                                        nativeAdInteractionListener.onADClicked(wMCustomNativeAdapter.getAdInFo(jVar));
                                    }
                                    WMLogUtil.d(WMLogUtil.TAG, "-----------onAdClicked------------");
                                    WMCustomNativeAdapter wMCustomNativeAdapter2 = jVar.b;
                                    if (wMCustomNativeAdapter2 != null) {
                                        wMCustomNativeAdapter2.callNativeAdClick(jVar.f1151c);
                                    }
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }

                public void onLpClosed() {
                    WMLogUtil.d(WMLogUtil.TAG, "-----------onLpClosed---------");
                }

                public void onNativeFail(int i, String str2) {
                    WMLogUtil.d(WMLogUtil.TAG, "-----------onNativeFail---------:" + i + ":" + str2);
                    if (k.this.b != null) {
                        k.this.b.onNativeAdFailToLoad(new WMAdapterError(i, str2 + " codeId " + str));
                    }
                }

                public void onNativeFail(int i, String str2, NativeResponse nativeResponse) {
                    onNativeFail(i, str2);
                }

                public void onNativeLoad(List<NativeResponse> list) {
                    if (list == null || list.isEmpty()) {
                        if (k.this.b != null) {
                            k.this.b.onNativeAdFailToLoad(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "ads is null or size be 0 " + str));
                            return;
                        }
                        return;
                    }
                    WMLogUtil.d(WMLogUtil.TAG, "-------------onNativeLoad-----------" + list.size());
                    String str2 = null;
                    String str3 = "";
                    int i = 0;
                    while (i < list.size()) {
                        NativeResponse nativeResponse = list.get(i);
                        k.this.a.add(new j(context, nativeResponse, k.this.f1152c, map2));
                        String pecpm = nativeResponse.getPECPM();
                        if (TextUtils.isEmpty(str2)) {
                            str2 = nativeResponse.getECPMLevel();
                        }
                        i++;
                        str3 = pecpm;
                    }
                    k kVar = k.this;
                    g.a aVar = kVar.b;
                    if (aVar != null) {
                        aVar.onNativeAdLoadSuccess(kVar.a, str2, str3);
                    }
                }

                public void onNoAd(int i, String str2) {
                    WMLogUtil.d(WMLogUtil.TAG, "-----------onNoAd---------:" + i + ":" + str2);
                    if (k.this.b != null) {
                        k.this.b.onNativeAdFailToLoad(new WMAdapterError(i, str2 + " codeId " + str));
                    }
                }

                public void onNoAd(int i, String str2, NativeResponse nativeResponse) {
                    onNoAd(i, str2);
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
        a.a((NativeResponse) ((h) this.a.get(0)).getOriginNativeAdData(), str, linkedHashMap);
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
        a.b((NativeResponse) ((h) this.a.get(0)).getOriginNativeAdData(), str, linkedHashMap);
    }

    @Override // com.windmill.baidu.g
    public final Map<String, Object> c() {
        NativeResponse nativeResponse;
        Object adDataForKey;
        try {
            List<WMNativeAdData> list = this.a;
            if (list == null || list.size() <= 0 || (nativeResponse = (NativeResponse) this.a.get(0).getOriginNativeAdData()) == null || (adDataForKey = nativeResponse.getAdDataForKey("request_id")) == null) {
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
