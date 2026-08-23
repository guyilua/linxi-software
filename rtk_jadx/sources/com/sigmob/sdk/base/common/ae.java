package com.sigmob.sdk.base.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.track.AdTracker;
import com.czhj.sdk.common.utils.AppPackageUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.VolleyError;
import com.czhj.volley.toolbox.DownloadItem;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntityClick;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.base.mta.PointEntitySigmobRequest;
import com.sigmob.sdk.base.mta.PointEntitySigmobSuper;
import com.sigmob.sdk.base.mta.PointType;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdOptions;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.WindCustomController;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ae {

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a(Object obj);
    }

    public static void a(PackageInfo packageInfo, int i) {
        if (packageInfo == null) {
            return;
        }
        PointEntitySigmobSuper pointEntitySigmobSuper = new PointEntitySigmobSuper();
        pointEntitySigmobSuper.setAc_type(PointType.SIGMOB_APP);
        pointEntitySigmobSuper.setCategory(PointCategory.APP);
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("app_name", String.valueOf(AppPackageUtil.getPackageManager(com.sigmob.sdk.b.e()).getApplicationLabel(packageInfo.applicationInfo)));
        } catch (Throwable unused) {
        }
        hashMap.put("package_name", packageInfo.packageName);
        hashMap.put(com.sigmob.sdk.base.k.q, String.valueOf(packageInfo.lastUpdateTime));
        hashMap.put("app_version", packageInfo.versionName);
        hashMap.put("source_type", String.valueOf(i));
        pointEntitySigmobSuper.setOptions(hashMap);
        pointEntitySigmobSuper.commit();
    }

    public static void a(final AdTracker adTracker, final String str, BaseAdUnit baseAdUnit, final NetworkResponse networkResponse, final a aVar) {
        ak.a(adTracker.getEvent()).c(PointType.SIGMOB_REPORT_TRACKING).a(baseAdUnit).a(new a() { // from class: com.sigmob.sdk.base.common.ae.4
            @Override // com.sigmob.sdk.base.common.ae.a
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                    pointEntitySigmob.setAc_type(PointType.SIGMOB_REPORT_TRACKING);
                    pointEntitySigmob.setUrl(str);
                    AdTracker adTracker2 = adTracker;
                    if (adTracker2 != null) {
                        pointEntitySigmob.setRetry(adTracker2.getId() != null ? "1" : "0");
                        pointEntitySigmob.setCategory(adTracker.getEvent());
                        pointEntitySigmob.setRequest_id(adTracker.getRequest_id());
                        if (adTracker.getTimestamp() != 0) {
                            pointEntitySigmob.setTimestamp(String.valueOf(adTracker.getTimestamp()));
                        }
                        pointEntitySigmob.setSource(adTracker.getSource());
                        NetworkResponse networkResponse2 = networkResponse;
                        if (networkResponse2 != null) {
                            byte[] bArr = networkResponse2.data;
                            pointEntitySigmob.setResponse(bArr != null ? Base64.encodeToString(bArr, 2) : null);
                            pointEntitySigmob.setHttp_code(String.valueOf(networkResponse.statusCode));
                            pointEntitySigmob.setTime_spend(String.valueOf(networkResponse.networkTimeMs));
                            pointEntitySigmob.setContent_type((String) networkResponse.headers.get("Content-Type"));
                            pointEntitySigmob.setContent_length((String) networkResponse.headers.get(com.sigmob.sdk.downloader.core.c.e));
                        }
                    }
                }
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(obj);
                }
            }
        }).a();
    }

    public static void a(AdTracker adTracker, String str, BaseAdUnit baseAdUnit, final VolleyError volleyError) {
        NetworkResponse networkResponse = volleyError != null ? volleyError.networkResponse : null;
        a(adTracker, str, baseAdUnit, networkResponse, networkResponse == null ? new a() { // from class: com.sigmob.sdk.base.common.ae.3
            @Override // com.sigmob.sdk.base.common.ae.a
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                    pointEntitySigmob.setHttp_code("-1");
                    VolleyError volleyError2 = volleyError;
                    if (volleyError2 == null) {
                        pointEntitySigmob.setTime_spend("0");
                    } else {
                        pointEntitySigmob.setTime_spend(String.valueOf(volleyError2.getNetworkTimeMs()));
                        pointEntitySigmob.setError_message(volleyError.getMessage());
                    }
                }
            }
        } : null);
    }

    public static void a(DownloadItem downloadItem, BaseAdUnit baseAdUnit, String str, boolean z) {
        PointEntitySigmob pointEntitySigmob = new PointEntitySigmob();
        pointEntitySigmob.setAc_type(PointType.DOWNLOAD_TRACKING);
        pointEntitySigmob.setIssuccess(String.valueOf(downloadItem.status));
        pointEntitySigmob.setIscached(z ? "1" : "0");
        pointEntitySigmob.setDuration(String.valueOf(downloadItem.networkMs));
        pointEntitySigmob.setFile_size(String.valueOf(downloadItem.size));
        pointEntitySigmob.setFile_name(Base64.encodeToString(downloadItem.url.getBytes(), 2));
        pointEntitySigmob.setError_message(str);
        pointEntitySigmob.setCategory(String.valueOf(downloadItem.type.getType()));
        a(pointEntitySigmob.getCategory(), pointEntitySigmob.getSub_category(), baseAdUnit, pointEntitySigmob);
        pointEntitySigmob.commit();
    }

    public static void a(com.sigmob.sdk.base.a aVar, String str, BaseAdUnit baseAdUnit, String str2, String str3, String str4) {
        a(aVar, str, baseAdUnit, str2, str3, str4, 0L);
    }

    public static void a(com.sigmob.sdk.base.a aVar, String str, BaseAdUnit baseAdUnit, String str2, String str3, String str4, long j) {
        a(aVar, str, baseAdUnit, str2, str3, str4, j, (JSONObject) null);
    }

    public static void a(com.sigmob.sdk.base.a aVar, final String str, final BaseAdUnit baseAdUnit, final String str2, final String str3, final String str4, final long j, final JSONObject jSONObject) {
        a(aVar == null ? str : aVar.name().toLowerCase(), str, baseAdUnit, new a() { // from class: com.sigmob.sdk.base.common.ae.6
            /* JADX WARN: Removed duplicated region for block: B:17:0x0148  */
            @Override // com.sigmob.sdk.base.common.ae.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void a(java.lang.Object r6) {
                /*
                    Method dump skipped, instructions count: 453
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.ae.AnonymousClass6.a(java.lang.Object):void");
            }
        });
    }

    public static void a(z zVar) {
        if (zVar != null) {
            if (zVar.a == 0 && zVar.b == 0) {
                return;
            }
            PointEntitySigmobSuper pointEntitySigmobSuper = new PointEntitySigmobSuper();
            pointEntitySigmobSuper.setAc_type(PointType.LOAD_READY);
            pointEntitySigmobSuper.setCategory("load_ready");
            Map options = pointEntitySigmobSuper.getOptions();
            options.put("placement_id", String.valueOf(zVar.f398c));
            options.put("feed_pre_request_count", String.valueOf(zVar.a));
            options.put("feed_pre_ready_count", String.valueOf(zVar.b));
            pointEntitySigmobSuper.commit();
        }
    }

    public static void a(BaseAdUnit baseAdUnit, MotionEvent motionEvent, String str, boolean z) {
        long eventTime = motionEvent.getEventTime() - motionEvent.getDownTime();
        PointEntityClick pointEntityClick = new PointEntityClick();
        pointEntityClick.setAc_type("102");
        pointEntityClick.setCategory(str);
        pointEntityClick.setLocation(String.format("{x:%f,y:%f}", Float.valueOf(motionEvent.getRawX()), Float.valueOf(motionEvent.getRawY())));
        pointEntityClick.setClick_duration(String.valueOf(eventTime));
        pointEntityClick.setPressure(String.valueOf(motionEvent.getPressure()));
        pointEntityClick.setTouchSize(String.valueOf(motionEvent.getSize()));
        pointEntityClick.setTouchType(String.valueOf(motionEvent.getToolType(0)));
        pointEntityClick.setIs_valid_click(z ? "1" : "0");
        if (baseAdUnit != null) {
            pointEntityClick.setLoad_id(baseAdUnit.getLoad_id());
        }
        pointEntityClick.commit();
    }

    public static void a(final BaseAdUnit baseAdUnit, final String str, final PackageInfo packageInfo, final String str2) {
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable() { // from class: com.sigmob.sdk.base.common.ae.5
            @Override // java.lang.Runnable
            public void run() {
                ae.a(str, str2, baseAdUnit, new a() { // from class: com.sigmob.sdk.base.common.ae.5.1
                    @Override // com.sigmob.sdk.base.common.ae.a
                    public void a(Object obj) {
                        Context e = com.sigmob.sdk.b.e();
                        if (obj instanceof PointEntitySigmob) {
                            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                            HashMap hashMap = new HashMap();
                            if (Build.VERSION.SDK_INT >= 26) {
                                try {
                                    hashMap.put(com.sigmob.sdk.base.k.s, e.getPackageManager().canRequestPackageInstalls() ? "1" : "0");
                                } catch (Throwable th) {
                                    SigmobLog.e(th.getMessage());
                                }
                            }
                            PackageInfo packageInfo2 = packageInfo;
                            if (packageInfo2 != null) {
                                try {
                                    hashMap.put("app_name", e.getPackageManager().getApplicationLabel(packageInfo2.applicationInfo).toString());
                                } catch (Throwable unused) {
                                }
                                hashMap.put("package_name", packageInfo.packageName);
                                hashMap.put(com.sigmob.sdk.base.k.q, String.valueOf(packageInfo.lastUpdateTime));
                                hashMap.put("app_version", packageInfo.versionName);
                            }
                            pointEntitySigmob.setOptions(hashMap);
                        }
                    }
                });
            }
        });
    }

    public static void a(BaseAdUnit baseAdUnit, String str, final String str2) {
        a(PointCategory.TARGET_URL, (String) null, baseAdUnit, new a() { // from class: com.sigmob.sdk.base.common.ae.2
            @Override // com.sigmob.sdk.base.common.ae.a
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    ((PointEntitySigmob) obj).setFinal_url(str2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(PointEntitySigmob pointEntitySigmob) {
        WindAdOptions options = WindAds.sharedAds().getOptions();
        String str = "0";
        if (options == null || WindAds.sharedAds().getOptions().getCustomController() == null) {
            pointEntitySigmob.setIs_custom_imei("0");
            pointEntitySigmob.setIs_custom_android_id("0");
        } else {
            WindCustomController customController = options.getCustomController();
            pointEntitySigmob.setIs_custom_imei(customController.isCanUsePhoneState() ? "0" : "1");
            pointEntitySigmob.setIs_custom_android_id(customController.isCanUseAndroidId() ? "0" : "1");
            if (!TextUtils.isEmpty(customController.getDevOaid())) {
                str = "1";
            }
        }
        pointEntitySigmob.setIs_custom_oaid(str);
    }

    public static void a(String str) {
        PointEntitySigmobSuper pointEntitySigmobSuper = new PointEntitySigmobSuper();
        pointEntitySigmobSuper.setAc_type("102");
        pointEntitySigmobSuper.setCategory(str);
        pointEntitySigmobSuper.setSha1(ClientMetadata.getInstance().getApkSha1());
        pointEntitySigmobSuper.setMd5(ClientMetadata.getInstance().getApkMd5());
        pointEntitySigmobSuper.commit();
    }

    public static void a(String str, int i, String str2, BaseAdUnit baseAdUnit) {
        a(str, i, str2, baseAdUnit, (a) null);
    }

    public static void a(String str, int i, String str2, BaseAdUnit baseAdUnit, a aVar) {
        PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError(str, i, str2);
        if (aVar != null) {
            aVar.a(SigmobError);
        }
        a(str, str, baseAdUnit, SigmobError);
        SigmobError.commit();
    }

    public static void a(String str, a aVar) {
        ad adVar = new ad();
        adVar.setAc_type("1");
        adVar.setCategory(str);
        adVar.setAppinfo_switch(!com.sigmob.sdk.base.l.a().M() ? "1,1" : "0,0");
        DeviceContext b = com.sigmob.sdk.b.b();
        int i = 1;
        int i2 = 0;
        int i3 = (b != null ? b.getLocation() : ClientMetadata.getInstance().getLocation()) != null ? 1 : 0;
        if (com.sigmob.sdk.base.l.a().L()) {
            i = 0;
        } else {
            i2 = i3;
        }
        adVar.setLocation_switch(i + "," + i2);
        if (aVar != null) {
            aVar.a(adVar);
        }
        WindAdOptions options = WindAds.sharedAds().getOptions();
        if (options == null || WindAds.sharedAds().getOptions().getCustomController() == null) {
            adVar.a("0");
            adVar.b("0");
            adVar.c("0");
        } else {
            WindCustomController customController = options.getCustomController();
            adVar.a(customController.isCanUsePhoneState() ? "0" : "1");
            adVar.b(customController.isCanUseAndroidId() ? "0" : "1");
            adVar.c(TextUtils.isEmpty(customController.getDevOaid()) ? "0" : "1");
        }
        adVar.commit();
    }

    public static void a(String str, BaseAdUnit baseAdUnit, LoadAdRequest loadAdRequest, a aVar) {
        PointEntitySigmob pointEntitySigmob = new PointEntitySigmob();
        pointEntitySigmob.setAc_type(str);
        if (aVar != null) {
            aVar.a(pointEntitySigmob);
        }
        a(pointEntitySigmob.getCategory(), pointEntitySigmob.getSub_category(), baseAdUnit, pointEntitySigmob);
        if (loadAdRequest != null) {
            pointEntitySigmob.setLoad_id(loadAdRequest.getLoadId());
            pointEntitySigmob.setAdtype(String.valueOf(loadAdRequest.getAdType()));
            pointEntitySigmob.setScene_id(loadAdRequest.getAdSceneId());
            pointEntitySigmob.setScene_desc(loadAdRequest.getAdSceneDesc());
            pointEntitySigmob.setPlacement_id(loadAdRequest.getPlacementId());
        }
        pointEntitySigmob.commit();
    }

    public static void a(String str, BaseAdUnit baseAdUnit, String str2, String str3, String str4) {
        a(null, str, baseAdUnit, str2, str3, str4, 0L);
    }

    public static void a(String str, WindAdError windAdError, BaseAdUnit baseAdUnit) {
        a(str, (String) null, windAdError.getErrorCode(), windAdError.getMessage(), (WindAdRequest) null, (LoadAdRequest) null, baseAdUnit, (a) null);
    }

    public static void a(String str, WindAdError windAdError, BaseAdUnit baseAdUnit, a aVar) {
        if (windAdError != null) {
            String message = windAdError.getMessage();
            PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError(str, windAdError.getErrorCode(), windAdError.getMessage());
            a(str, str, baseAdUnit, SigmobError);
            if (message != null && message.equals(WindAdError.ERROR_SIGMOB_VIDEO_FILE.getMessage()) && str != null && str.equals("load") && baseAdUnit != null) {
                SigmobError.getOptions().put("video_url", baseAdUnit.getVideo_url());
            }
            if (aVar != null) {
                aVar.a(SigmobError);
            }
            SigmobError.commit();
        }
    }

    public static void a(String str, WindAdError windAdError, BaseAdUnit baseAdUnit, LoadAdRequest loadAdRequest) {
        a(str, (String) null, windAdError.getErrorCode(), windAdError.getMessage(), (WindAdRequest) null, loadAdRequest, baseAdUnit, (a) null);
    }

    public static void a(String str, WindAdError windAdError, WindAdRequest windAdRequest) {
        a(str, (String) null, windAdError.getErrorCode(), windAdError.getMessage(), windAdRequest, (LoadAdRequest) null, (BaseAdUnit) null, (a) null);
    }

    public static void a(String str, String str2, int i, String str3, LoadAdRequest loadAdRequest) {
        a(str, str2, i, str3, (WindAdRequest) null, loadAdRequest, (BaseAdUnit) null, (a) null);
    }

    public static void a(String str, String str2, int i, String str3, WindAdRequest windAdRequest, LoadAdRequest loadAdRequest, BaseAdUnit baseAdUnit, a aVar) {
        PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError(str, i, str3);
        SigmobError.setSub_category(str2);
        a(str, str, SigmobError, windAdRequest);
        a(str, str, SigmobError, loadAdRequest);
        a(str, str, baseAdUnit, SigmobError);
        if (aVar != null) {
            aVar.a(SigmobError);
        }
        SigmobError.commit();
    }

    public static void a(String str, String str2, BaseAdUnit baseAdUnit) {
        a(str, str2, baseAdUnit, (a) null);
    }

    public static void a(String str, String str2, BaseAdUnit baseAdUnit, a aVar) {
        a(str, str2, baseAdUnit, (WindAdRequest) null, (LoadAdRequest) null, aVar);
    }

    public static void a(String str, String str2, BaseAdUnit baseAdUnit, LoadAdRequest loadAdRequest, a aVar) {
        a(str, str2, baseAdUnit, (WindAdRequest) null, loadAdRequest, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(String str, String str2, BaseAdUnit baseAdUnit, PointEntitySigmob pointEntitySigmob) {
        if (baseAdUnit != null) {
            try {
                pointEntitySigmob.setAdtype(String.valueOf(baseAdUnit.getAd_type()));
                pointEntitySigmob.setCampaign_id(baseAdUnit.getCamp_id());
                pointEntitySigmob.setCreative_id(baseAdUnit.getCrid());
                pointEntitySigmob.setRequest_id(baseAdUnit.getRequestId());
                pointEntitySigmob.setPlacement_id(baseAdUnit.getAdslot_id());
                pointEntitySigmob.setLoad_id(baseAdUnit.getLoad_id());
                pointEntitySigmob.setVid(baseAdUnit.getVid());
                pointEntitySigmob.setScene_id(baseAdUnit.getAd_scene_id());
                pointEntitySigmob.setScene_desc(baseAdUnit.getAd_scene_desc());
                pointEntitySigmob.setPlay_mode(String.valueOf(baseAdUnit.getPlayMode()));
                pointEntitySigmob.setCreative_type(String.valueOf(baseAdUnit.getCreativeType()));
                pointEntitySigmob.setBid_token(baseAdUnit.getBid_token());
                BiddingResponse biddingResponse = baseAdUnit.bidding_response;
                if (biddingResponse != null) {
                    pointEntitySigmob.setHb_price(biddingResponse.ecpm.intValue());
                }
                pointEntitySigmob.setPrice(baseAdUnit.getAd().settlement_price_enc);
                if (!TextUtils.isEmpty(baseAdUnit.getAd().product_id)) {
                    pointEntitySigmob.setProduct_id(baseAdUnit.getAd().product_id);
                }
                if (baseAdUnit.getAdx_id() != null) {
                    pointEntitySigmob.setAdx_id(baseAdUnit.getAdx_id());
                }
                pointEntitySigmob.setTemplate_id(String.valueOf(baseAdUnit.getTemplateId()));
                if (baseAdUnit.getMaterial() != null) {
                    pointEntitySigmob.setTemplate_type(baseAdUnit.getMaterial().template_type.intValue());
                }
                if (TextUtils.isEmpty(pointEntitySigmob.getTarget_url())) {
                    pointEntitySigmob.setTarget_url(baseAdUnit.getLanding_page());
                }
                if (baseAdUnit.getWXProgramRes() != null) {
                    if (!TextUtils.isEmpty(baseAdUnit.getWXProgramRes().wx_app_path)) {
                        pointEntitySigmob.setWx_app_path(URLEncoder.encode(baseAdUnit.getWXProgramRes().wx_app_path, "UTF-8"));
                    }
                    if (!TextUtils.isEmpty(baseAdUnit.getWXProgramRes().wx_app_username)) {
                        pointEntitySigmob.setWx_app_username(baseAdUnit.getWXProgramRes().wx_app_username);
                    }
                }
                pointEntitySigmob.getOptions().put("apk_md5", baseAdUnit.getApkMd5());
                pointEntitySigmob.setAd_source_channel(baseAdUnit.getAd_source_channel());
                if (!TextUtils.isEmpty(pointEntitySigmob.getShow_type()) || TextUtils.isEmpty(str)) {
                    return;
                }
                if ((str.equals(PointCategory.REQUEST) || str.equals(PointCategory.READY) || str.equals("start") || str.equals("endcard") || (!TextUtils.isEmpty(str2) && str2.equals("click"))) && baseAdUnit.getAd_type() == 4) {
                    pointEntitySigmob.setShow_type(baseAdUnit.isHalfInterstitial() ? "2" : "1");
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str, String str2, BaseAdUnit baseAdUnit, WindAdRequest windAdRequest, a aVar) {
        a(str, str2, baseAdUnit, windAdRequest, (LoadAdRequest) null, aVar);
    }

    public static void a(String str, String str2, BaseAdUnit baseAdUnit, WindAdRequest windAdRequest, LoadAdRequest loadAdRequest, final a aVar) {
        ak.a(str).d(str2).a(baseAdUnit).a(windAdRequest).a(loadAdRequest).a(new a() { // from class: com.sigmob.sdk.base.common.ae.1
            @Override // com.sigmob.sdk.base.common.ae.a
            public void a(Object obj) {
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.a(obj);
                }
            }
        }).a();
    }

    public static void a(String str, String str2, LoadAdRequest loadAdRequest) {
        a(str, str2, (BaseAdUnit) null, (WindAdRequest) null, loadAdRequest, (a) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(String str, String str2, PointEntitySigmob pointEntitySigmob, LoadAdRequest loadAdRequest) {
        if (pointEntitySigmob == null || loadAdRequest == null) {
            return;
        }
        pointEntitySigmob.setPlacement_id(loadAdRequest.getPlacementId());
        if (!TextUtils.isEmpty(loadAdRequest.getBidToken())) {
            pointEntitySigmob.setBid_token(loadAdRequest.getBidToken());
        }
        if (!TextUtils.isEmpty(loadAdRequest.getLoadId())) {
            pointEntitySigmob.setLoad_id(loadAdRequest.getLoadId());
        }
        if (!TextUtils.isEmpty(loadAdRequest.getAdx_id())) {
            pointEntitySigmob.setAdx_id(loadAdRequest.getAdx_id());
        }
        pointEntitySigmob.setAdtype(String.valueOf(loadAdRequest.getAdType()));
        if (!TextUtils.isEmpty(loadAdRequest.getRequestId())) {
            pointEntitySigmob.setRequest_id(loadAdRequest.getRequestId());
        }
        if (loadAdRequest.getOptions() != null) {
            pointEntitySigmob.setExtinfo(new JSONObject(loadAdRequest.getOptions()).toString());
        }
        if ((!(TextUtils.isEmpty(pointEntitySigmob.getShow_type()) && !TextUtils.isEmpty(str) && (str.equals(PointCategory.REQUEST) || str.equals(PointCategory.READY) || str.equals("start") || str.equals("endcard"))) && (TextUtils.isEmpty(str2) || !str2.equals("click"))) || loadAdRequest.getAdType() != 4) {
            return;
        }
        pointEntitySigmob.setShow_type(loadAdRequest.isHalfInterstitial() ? "2" : "1");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(String str, String str2, PointEntitySigmob pointEntitySigmob, WindAdRequest windAdRequest) {
        if (pointEntitySigmob == null || windAdRequest == null) {
            return;
        }
        pointEntitySigmob.setPlacement_id(windAdRequest.getPlacementId());
        pointEntitySigmob.setLoad_id(windAdRequest.getLoadId());
        pointEntitySigmob.setAdx_id(windAdRequest.getAdxId());
        pointEntitySigmob.setAdtype(String.valueOf(windAdRequest.getAdType()));
        if (windAdRequest.hasOptions()) {
            try {
                pointEntitySigmob.setExtinfo(new JSONObject(windAdRequest.getOptions()).toString());
            } catch (Throwable unused) {
            }
        }
        if ((!(TextUtils.isEmpty(pointEntitySigmob.getShow_type()) && !TextUtils.isEmpty(str) && (str.equals(PointCategory.REQUEST) || str.equals(PointCategory.READY) || str.equals("start") || str.equals("endcard"))) && (TextUtils.isEmpty(str2) || !str2.equals("click"))) || windAdRequest.getAdType() != 4) {
            return;
        }
        pointEntitySigmob.setShow_type(windAdRequest.isHalfInterstitial() ? "2" : "1");
    }

    public static void a(String str, String str2, WindAdRequest windAdRequest, LoadAdRequest loadAdRequest, a aVar) {
        PointEntitySigmobRequest pointEntitySigmobRequest = new PointEntitySigmobRequest();
        pointEntitySigmobRequest.setAc_type("5");
        pointEntitySigmobRequest.setCategory(str);
        pointEntitySigmobRequest.setSub_category(str2);
        a(str, str, pointEntitySigmobRequest, windAdRequest);
        a(str, str, pointEntitySigmobRequest, loadAdRequest);
        if (aVar != null) {
            aVar.a(pointEntitySigmobRequest);
        }
        a(pointEntitySigmobRequest);
        pointEntitySigmobRequest.commit();
    }

    public static void a(String str, boolean z) {
        PointEntitySigmobSuper pointEntitySigmobSuper = new PointEntitySigmobSuper();
        pointEntitySigmobSuper.setAc_type(PointType.SIGMOB_CANOPEN_APP);
        pointEntitySigmobSuper.setCategory(PointCategory.OPEN_APP);
        HashMap hashMap = new HashMap();
        hashMap.put("app_pkg_name", str);
        hashMap.put("can_op", z ? "1" : "0");
        pointEntitySigmobSuper.setOptions(hashMap);
        pointEntitySigmobSuper.commit();
    }

    public static void b(String str, String str2, BaseAdUnit baseAdUnit) {
        a(str, str2, baseAdUnit, (a) null);
    }
}
