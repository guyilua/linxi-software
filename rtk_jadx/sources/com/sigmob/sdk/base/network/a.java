package com.sigmob.sdk.base.network;

import android.text.TextUtils;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.models.App;
import com.czhj.sdk.common.models.ModelBuilderCreator;
import com.czhj.sdk.common.models.Privacy;
import com.czhj.sdk.common.models.User;
import com.czhj.sdk.common.network.SigmobRequest;
import com.czhj.sdk.common.utils.AESUtil;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.DefaultRetryPolicy;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.ParseError;
import com.czhj.volley.Response;
import com.czhj.volley.VolleyError;
import com.czhj.volley.toolbox.HttpHeaderParser;
import com.czhj.wire.Wire;
import com.sigmob.sdk.base.common.ab;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.common.y;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.BidResponse;
import com.sigmob.sdk.base.models.rtb.NativeAdSetting;
import com.sigmob.sdk.base.models.rtb.SlotAdSetting;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.base.network.e;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAds;
import java.util.ArrayList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a extends SigmobRequest<BidResponse> {
    private final e.a a;
    private final LoadAdRequest b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f421c;

    public a(String str, LoadAdRequest loadAdRequest, e.a aVar) {
        super(str, 1, (Response.ErrorListener) null);
        Preconditions.NoThrow.checkNotNull(aVar);
        this.a = aVar;
        this.b = loadAdRequest;
        setRetryPolicy(new DefaultRetryPolicy(5000, 0, com.sigmob.sdk.base.blurkit.c.d));
        setShouldCache(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x01cc A[Catch: all -> 0x03d8, TryCatch #1 {all -> 0x03d8, blocks: (B:3:0x0007, B:5:0x0035, B:6:0x003c, B:8:0x0043, B:10:0x004d, B:12:0x0057, B:18:0x0071, B:20:0x0087, B:22:0x009b, B:24:0x00a5, B:25:0x00c9, B:27:0x00d3, B:28:0x00de, B:30:0x00e5, B:31:0x01cf, B:33:0x01f6, B:34:0x01fd, B:36:0x0227, B:37:0x022e, B:39:0x0251, B:40:0x0258, B:42:0x0262, B:43:0x0269, B:45:0x027a, B:47:0x027e, B:48:0x0285, B:49:0x035c, B:51:0x03af, B:52:0x03ba, B:55:0x03d1, B:60:0x0132, B:62:0x0138, B:65:0x0140, B:67:0x0147, B:68:0x0162, B:69:0x01be, B:71:0x01cc, B:72:0x0166, B:73:0x0292), top: B:2:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.czhj.sdk.common.models.BidRequest.Builder a(com.sigmob.sdk.base.models.LoadAdRequest r11) {
        /*
            Method dump skipped, instructions count: 993
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.network.a.a(com.sigmob.sdk.base.models.LoadAdRequest):com.czhj.sdk.common.models.BidRequest$Builder");
    }

    private void a(final int i, final String str, final String str2, int i2, String str3) {
        ae.a(PointCategory.SERVER_ERROR, i2, str3, (BaseAdUnit) null, new ae.a() { // from class: com.sigmob.sdk.base.network.a.1
            @Override // com.sigmob.sdk.base.common.ae.a
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmobError) {
                    PointEntitySigmobError pointEntitySigmobError = (PointEntitySigmobError) obj;
                    pointEntitySigmobError.setRequest_id(str2);
                    pointEntitySigmobError.setPlacement_id(str);
                    pointEntitySigmobError.setAdtype(String.valueOf(i));
                }
            }
        });
    }

    public static App.Builder b() {
        App.Builder createApp = ModelBuilderCreator.createApp();
        if (!TextUtils.isEmpty(com.sigmob.sdk.b.a())) {
            createApp.sdk_ext_cap.add(4);
        }
        createApp.app_id(WindAds.sharedAds().getAppId());
        return createApp;
    }

    public static User.Builder c() {
        User.Builder builder = new User.Builder();
        builder.is_minor = Boolean.valueOf(!com.sigmob.sdk.base.f.a().d());
        builder.disable_personalized_recommendation = Boolean.valueOf(!com.sigmob.sdk.base.f.a().e());
        builder.change_recommendation_state = Boolean.valueOf(com.sigmob.sdk.base.f.a().f());
        return builder;
    }

    public static Privacy.Builder d() {
        int i;
        Privacy.Builder builder = new Privacy.Builder();
        builder.age(Integer.valueOf(com.sigmob.sdk.base.f.a().b()));
        builder.child_protection(Integer.valueOf(com.sigmob.sdk.base.f.a().c()));
        try {
            i = com.sigmob.sdk.base.f.a().g();
        } catch (Throwable unused) {
            i = 0;
        }
        builder.gdpr_consent(Integer.valueOf(i));
        return builder;
    }

    public e.a a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void deliverResponse(BidResponse bidResponse) {
        String DecryptString;
        y a;
        NativeAdSetting nativeAdSetting;
        if (bidResponse != null) {
            if (this.b.getAdType() == 5) {
                y a2 = y.a(this.b.getPlacementId());
                if (a2 != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    a2.f397c = currentTimeMillis;
                    a2.g = currentTimeMillis;
                    a2.b = 0;
                    a2.a = 0;
                    SlotAdSetting slotAdSetting = bidResponse.slot_ad_setting;
                    if (slotAdSetting != null && (nativeAdSetting = slotAdSetting.native_setting) != null) {
                        a2.e = ((Integer) Wire.get(nativeAdSetting.ad_pool_size, 0)).intValue();
                        a2.d = ((Integer) Wire.get(nativeAdSetting.req_interval_time, 0)).intValue();
                        a2.f = ((Integer) Wire.get(nativeAdSetting.media_expected_floor, 0)).intValue();
                        ab.a().a(((Integer) Wire.get(nativeAdSetting.log_interval_time, 0)).intValue());
                    }
                }
                y.a(this.b.getPlacementId(), a2);
            }
            String str = bidResponse.uid;
            if (!TextUtils.isEmpty(str)) {
                try {
                    DecryptString = AESUtil.DecryptStringServer(str, "KGpfzbYsn4T9Jyuq");
                } catch (NoSuchMethodError unused) {
                    DecryptString = AESUtil.DecryptString(str, "KGpfzbYsn4T9Jyuq");
                }
                ClientMetadata.getInstance().setUid(DecryptString);
            }
            if (!TextUtils.isEmpty(bidResponse.adx_id)) {
                this.b.setAdx_id(bidResponse.adx_id);
            }
            this.b.setRequestId(bidResponse.request_id);
            if (bidResponse.ads.size() <= 0) {
                a(this.b.getAdType(), this.b.getPlacementId(), bidResponse.request_id, bidResponse.error_code.intValue(), bidResponse.error_message);
                this.a.a(bidResponse.error_code.intValue(), bidResponse.error_message, bidResponse.request_id, this.b);
                return;
            }
            try {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < bidResponse.ads.size(); i++) {
                    BaseAdUnit adUnit = BaseAdUnit.adUnit(bidResponse.ads.get(i), bidResponse.request_id, this.b, bidResponse.slot_ad_setting, bidResponse.scene, bidResponse.uid, bidResponse.expiration_time, bidResponse.bidding_response);
                    adUnit.setAd_type(this.b.getAdType());
                    adUnit.setAdx_id(this.b.getAdx_id());
                    adUnit.setAdslot_id(this.b.getPlacementId());
                    adUnit.setHalfInterstitial(this.b.isHalfInterstitial());
                    adUnit.setRvCallBackUrl(bidResponse.rv_callback_url);
                    arrayList.add(adUnit);
                }
                if (this.b.getAdType() == 5 && (a = y.a(this.b.getPlacementId())) != null) {
                    h.a(this.b.getPlacementId(), arrayList, a.e);
                }
                e.a aVar = this.a;
                if (aVar != null) {
                    aVar.a(arrayList, this.b);
                }
                int adType = this.b.getAdType();
                if (adType == 6 || adType == 1 || adType == 4) {
                    h.a(bidResponse.request_id, bidResponse);
                    return;
                }
                return;
            } catch (Throwable th) {
                SigmobLog.e("ads Response: error ", th);
            }
        } else if (this.b.getAdType() == 5) {
            y a3 = y.a(this.b.getPlacementId());
            a3.g = a3.f397c;
        }
        this.a.a(WindAdError.ERROR_SIGMOB_INFORMATION_LOSE.getErrorCode(), "bidResponse is null", null, this.b);
    }

    public void deliverError(VolleyError volleyError) {
        e.a aVar;
        WindAdError windAdError;
        y a;
        if (this.b.getAdType() == 5 && (a = y.a(this.b.getPlacementId())) != null) {
            a.g = a.f397c;
        }
        if (volleyError instanceof ParseError) {
            aVar = this.a;
            windAdError = WindAdError.ERROR_SIGMOB_INFORMATION_LOSE;
        } else {
            SigmobLog.e(this.b.getPlacementId() + " ERROR_SIGMOB_NETWORK " + volleyError.getMessage());
            aVar = this.a;
            windAdError = WindAdError.ERROR_SIGMOB_NETWORK;
        }
        aVar.a(windAdError.getErrorCode(), volleyError.getMessage(), null, this.b);
    }

    public byte[] getBody() {
        return this.f421c;
    }

    public String getBodyContentType() {
        return "application/octet-stream";
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.Map<java.lang.String, java.lang.String> getHeaders() {
        /*
            r7 = this;
            java.lang.String r0 = "cp"
            java.lang.String r1 = "1"
            java.lang.String r2 = "e"
            java.lang.String r3 = "agn"
            java.util.Map r4 = super.getHeaders()
            byte[] r5 = com.czhj.sdk.common.utils.AESUtil.generateNonce()     // Catch: java.lang.NoSuchMethodError -> L19
            r6 = 2
            java.lang.String r5 = android.util.Base64.encodeToString(r5, r6)     // Catch: java.lang.NoSuchMethodError -> L19
            r4.put(r3, r5)     // Catch: java.lang.NoSuchMethodError -> L19
            goto L1c
        L19:
            r4.put(r2, r1)
        L1c:
            r5 = 0
            com.sigmob.sdk.base.models.LoadAdRequest r6 = r7.b     // Catch: java.lang.Throwable -> L2a
            if (r6 == 0) goto L32
            com.czhj.sdk.common.models.BidRequest$Builder r6 = a(r6)     // Catch: java.lang.Throwable -> L2a
            com.czhj.sdk.common.models.BidRequest r6 = r6.build()     // Catch: java.lang.Throwable -> L2a
            goto L33
        L2a:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.czhj.sdk.logger.SigmobLog.e(r6)
        L32:
            r6 = r5
        L33:
            if (r6 != 0) goto L3b
            java.lang.String r0 = "builder Ads Post entry fail "
            com.czhj.sdk.logger.SigmobLog.e(r0)
            return r5
        L3b:
            byte[] r5 = r6.encode()     // Catch: java.lang.Throwable -> L4b
            r7.f421c = r5     // Catch: java.lang.Throwable -> L4b
            byte[] r5 = com.sigmob.sdk.base.network.c.b(r5)     // Catch: java.lang.Throwable -> L4b
            r7.f421c = r5     // Catch: java.lang.Throwable -> L4b
            r4.put(r0, r1)     // Catch: java.lang.Throwable -> L4b
            goto L54
        L4b:
            r4.remove(r0)
            byte[] r0 = r6.encode()
            r7.f421c = r0
        L54:
            byte[] r0 = r7.f421c     // Catch: java.lang.Exception -> L5f
            java.lang.String r1 = "KGpfzbYsn4T9Jyuq"
            byte[] r0 = com.czhj.sdk.common.utils.AESUtil.Encrypt(r0, r1)     // Catch: java.lang.Exception -> L5f
            r7.f421c = r0     // Catch: java.lang.Exception -> L5f
            goto L69
        L5f:
            r0 = move-exception
            r0.printStackTrace()
            r4.remove(r2)
            r4.remove(r3)
        L69:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.network.a.getHeaders():java.util.Map");
    }

    protected Response<BidResponse> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            if (networkResponse.data == null) {
                return Response.error(new ParseError(networkResponse));
            }
            BidResponse bidResponse = (BidResponse) BidResponse.ADAPTER.decode((networkResponse.headers.containsKey("cp") && "1".equals(networkResponse.headers.get("cp"))) ? c.a(networkResponse.data) : networkResponse.data);
            return bidResponse != null ? Response.success(bidResponse, HttpHeaderParser.parseCacheHeaders(networkResponse)) : Response.error(new ParseError(networkResponse));
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return Response.error(new ParseError(th));
        }
    }
}
