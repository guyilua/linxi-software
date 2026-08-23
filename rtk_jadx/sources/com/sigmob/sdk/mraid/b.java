package com.sigmob.sdk.mraid;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.json.JSONSerializer;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.track.AdTracker;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.common.utils.ReflectionUtil;
import com.czhj.sdk.common.utils.TouchLocation;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.StringUtil;
import com.qq.e.comm.pi.ACTD;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.ah;
import com.sigmob.sdk.base.common.aq;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.common.u;
import com.sigmob.sdk.base.models.AppInfo;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.CurrentAppOrientation;
import com.sigmob.sdk.base.models.ExposureChange;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.MraidEnv;
import com.sigmob.sdk.base.models.PlacementType;
import com.sigmob.sdk.base.models.VideoItem;
import com.sigmob.sdk.base.models.ViewState;
import com.sigmob.sdk.base.models.rtb.Ad;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.RvAdSetting;
import com.sigmob.sdk.base.models.rtb.SlotAdSetting;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.mraid.a;
import com.sigmob.sdk.mraid.i;
import com.sigmob.sdk.mraid.p;
import com.sigmob.sdk.videoAd.BaseAdActivity;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.WindAds;
import com.tencent.smtt.sdk.TbsListener;
import com.umeng.analytics.pro.ak;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    static final String a = "mraid://open?url=";
    private final BaseAdUnit b;

    /* renamed from: c, reason: collision with root package name */
    private final PlacementType f558c;
    private final i d;
    private String e;
    private InterfaceC0048b f;
    private p g;
    private aq h;
    private boolean i;
    private final q j;
    private c k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.sigmob.sdk.mraid.b$5, reason: invalid class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[g.values().length];
            a = iArr;
            try {
                iArr[g.CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[g.UNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[g.OPENFOURELEMENTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[g.RESIZE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[g.EXPAND.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[g.USE_CUSTOM_CLOSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[g.OPEN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[g.feedBack.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[g.SET_ORIENTATION_PROPERTIES.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[g.PLAY_VIDEO.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[g.STORE_PICTURE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[g.CREATE_CALENDAR_EVENT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[g.VPAID.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[g.EXTENSION.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[g.UNSPECIFIED.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class a {
        private final WeakReference<b> a;

        public a(b bVar) {
            this.a = new WeakReference<>(bVar);
        }

        public b a() {
            return this.a.get();
        }

        @JavascriptInterface
        public String addMacro(JSONObject jSONObject) {
            try {
                BaseAdUnit b = b();
                String string = jSONObject.has("key") ? jSONObject.getString("key") : null;
                String string2 = jSONObject.has("value") ? jSONObject.getString("value") : null;
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    b.getMacroCommon().addMarcoKey(string, string2);
                    return b.a(200, "addMacro success", (Object) null);
                }
                return b.a(TbsListener.ErrorCode.ERROR_CODE_LOAD_BASE, "key or value is empty", (Object) null);
            } catch (Throwable th) {
                return b.a(TbsListener.ErrorCode.INFO_CODE_MINIQB, "addMacro add fail " + th.getMessage(), (Object) null);
            }
        }

        public BaseAdUnit b() {
            b a = a();
            if (a != null) {
                return a.b;
            }
            return null;
        }

        @JavascriptInterface
        public String excuteRewardAdTrack(JSONObject jSONObject) {
            try {
                BaseAdUnit b = b();
                String string = jSONObject.getString("event");
                int b2 = com.sigmob.sdk.base.network.g.b(b, string, true);
                if (b2 == 0) {
                    return b.a(200, "excuteRewardAdTrack success", (Object) null);
                }
                if (b2 == -1) {
                    return b.a(TbsListener.ErrorCode.ERROR_CODE_LOAD_BASE, "event is empty", (Object) null);
                }
                if (b2 == -2) {
                    return b.a(TbsListener.ErrorCode.ERROR_CODE_LOAD_BASE, string + " can't find in trackers", (Object) null);
                }
                return b.a(TbsListener.ErrorCode.INFO_CODE_BASE, "unknown error: " + b2, (Object) null);
            } catch (Throwable th) {
                return b.a(TbsListener.ErrorCode.INFO_CODE_MINIQB, "unknown error: " + th.getMessage(), (Object) null);
            }
        }

        @JavascriptInterface
        public String func(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.has("func") ? jSONObject.getString("func") : null;
                if (TextUtils.isEmpty(string)) {
                    return b.a(TbsListener.ErrorCode.INFO_CODE_BASE, "func is empty", (Object) null);
                }
                ReflectionUtil.MethodBuilder methodBuilder = new ReflectionUtil.MethodBuilder(this, string.replace(":", ""));
                methodBuilder.addParam(JSONObject.class, jSONObject);
                return (String) methodBuilder.execute();
            } catch (Throwable th) {
                return b.a(TbsListener.ErrorCode.INFO_CODE_MINIQB, th.getMessage(), (Object) null);
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:17:0x01b6. Please report as an issue. */
        @JavascriptInterface
        public String getAppInfo(JSONObject jSONObject) {
            Object deviceId;
            int densityDpi;
            try {
                JSONObject jSONObject2 = new JSONObject();
                BaseAdUnit b = b();
                if (jSONObject != null && b != null && jSONObject.has("arguments")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("arguments");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getString(i);
                        char c2 = 65535;
                        try {
                            switch (string.hashCode()) {
                                case -1776992973:
                                    if (string.equals("ad_source_logo")) {
                                        c2 = 20;
                                        break;
                                    }
                                    break;
                                case -1590994477:
                                    if (string.equals("display_orientation")) {
                                        c2 = ' ';
                                        break;
                                    }
                                    break;
                                case -1581153970:
                                    if (string.equals("settlement_price_enc")) {
                                        c2 = 29;
                                        break;
                                    }
                                    break;
                                case -1534836170:
                                    if (string.equals("google_aid")) {
                                        c2 = 3;
                                        break;
                                    }
                                    break;
                                case -1342627961:
                                    if (string.equals("bid_price")) {
                                        c2 = 27;
                                        break;
                                    }
                                    break;
                                case -1295727824:
                                    if (string.equals("device_height")) {
                                        c2 = '\n';
                                        break;
                                    }
                                    break;
                                case -1152230954:
                                    if (string.equals("ad_type")) {
                                        c2 = 16;
                                        break;
                                    }
                                    break;
                                case -1093016302:
                                    if (string.equals("client_pixel")) {
                                        c2 = '\b';
                                        break;
                                    }
                                    break;
                                case -918718184:
                                    if (string.equals("forbiden_parse_landingpage")) {
                                        c2 = 31;
                                        break;
                                    }
                                    break;
                                case -901870406:
                                    if (string.equals("app_version")) {
                                        c2 = 5;
                                        break;
                                    }
                                    break;
                                case -702722614:
                                    if (string.equals("creative_type")) {
                                        c2 = 15;
                                        break;
                                    }
                                    break;
                                case -582019427:
                                    if (string.equals("device_width")) {
                                        c2 = '\t';
                                        break;
                                    }
                                    break;
                                case -568274923:
                                    if (string.equals("screen_density")) {
                                        c2 = 11;
                                        break;
                                    }
                                    break;
                                case -516987305:
                                    if (string.equals("pkgname")) {
                                        c2 = '\r';
                                        break;
                                    }
                                    break;
                                case -376724013:
                                    if (string.equals("sdk_version")) {
                                        c2 = 6;
                                        break;
                                    }
                                    break;
                                case -205033663:
                                    if (string.equals("is_override")) {
                                        c2 = 30;
                                        break;
                                    }
                                    break;
                                case -41411609:
                                    if (string.equals("screenangle")) {
                                        c2 = 14;
                                        break;
                                    }
                                    break;
                                case -19457365:
                                    if (string.equals(ak.T)) {
                                        c2 = '\f';
                                        break;
                                    }
                                    break;
                                case 3556:
                                    if (string.equals(ak.x)) {
                                        c2 = 0;
                                        break;
                                    }
                                    break;
                                case 116753:
                                    if (string.equals("vid")) {
                                        c2 = 23;
                                        break;
                                    }
                                    break;
                                case 3062218:
                                    if (string.equals("crid")) {
                                        c2 = 24;
                                        break;
                                    }
                                    break;
                                case 3236040:
                                    if (string.equals("imei")) {
                                        c2 = 1;
                                        break;
                                    }
                                    break;
                                case 37109963:
                                    if (string.equals("request_id")) {
                                        c2 = 17;
                                        break;
                                    }
                                    break;
                                case 93029116:
                                    if (string.equals(ACTD.APPID_KEY)) {
                                        c2 = 19;
                                        break;
                                    }
                                    break;
                                case 549673881:
                                    if (string.equals("camp_id")) {
                                        c2 = 25;
                                        break;
                                    }
                                    break;
                                case 672836989:
                                    if (string.equals(ak.y)) {
                                        c2 = 7;
                                        break;
                                    }
                                    break;
                                case 722989291:
                                    if (string.equals("android_id")) {
                                        c2 = 2;
                                        break;
                                    }
                                    break;
                                case 1103406469:
                                    if (string.equals("clienttype")) {
                                        c2 = 4;
                                        break;
                                    }
                                    break;
                                case 1127917191:
                                    if (string.equals("cust_id")) {
                                        c2 = 26;
                                        break;
                                    }
                                    break;
                                case 1139668345:
                                    if (string.equals("adslot_id")) {
                                        c2 = 22;
                                        break;
                                    }
                                    break;
                                case 1224358069:
                                    if (string.equals("placement_id")) {
                                        c2 = 18;
                                        break;
                                    }
                                    break;
                                case 1437471655:
                                    if (string.equals("expired_time")) {
                                        c2 = '!';
                                        break;
                                    }
                                    break;
                                case 1753008747:
                                    if (string.equals("product_id")) {
                                        c2 = 28;
                                        break;
                                    }
                                    break;
                                case 1765767291:
                                    if (string.equals("ad_source_channel")) {
                                        c2 = 21;
                                        break;
                                    }
                                    break;
                            }
                            switch (c2) {
                                case 0:
                                    jSONObject2.put(string, 2);
                                    break;
                                case 1:
                                    deviceId = ClientMetadata.getInstance().getDeviceId();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 2:
                                    deviceId = ClientMetadata.getInstance().getAndroidId();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 3:
                                    deviceId = ClientMetadata.getInstance().getAdvertisingId();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 4:
                                    deviceId = ClientMetadata.getDeviceModel();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 5:
                                    deviceId = ClientMetadata.getInstance().getAppVersion();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 6:
                                    deviceId = com.sigmob.sdk.base.k.k;
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 7:
                                    deviceId = ClientMetadata.getDeviceOsVersion();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case '\b':
                                    deviceId = String.format("%sx%s", Integer.valueOf(ClientMetadata.getInstance().getDisplayMetrics().widthPixels), Integer.valueOf(ClientMetadata.getInstance().getDisplayMetrics().heightPixels));
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case '\t':
                                    deviceId = ClientMetadata.getInstance().getDeviceScreenWidthDip();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case '\n':
                                    deviceId = ClientMetadata.getInstance().getDeviceScreenHeightDip();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 11:
                                    densityDpi = ClientMetadata.getInstance().getDensityDpi();
                                    jSONObject2.put(string, densityDpi);
                                    break;
                                case '\f':
                                    densityDpi = ClientMetadata.getInstance().getActiveNetworkType();
                                    jSONObject2.put(string, densityDpi);
                                    break;
                                case '\r':
                                    deviceId = ClientMetadata.getInstance().getAppPackageName();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 14:
                                    densityDpi = Math.abs(ClientMetadata.getInstance().getOrientationInt().intValue() - 1) * 90;
                                    jSONObject2.put(string, densityDpi);
                                    break;
                                case 15:
                                    densityDpi = b.getCreativeType();
                                    jSONObject2.put(string, densityDpi);
                                    break;
                                case 16:
                                    densityDpi = b.getAd_type();
                                    jSONObject2.put(string, densityDpi);
                                    break;
                                case 17:
                                    deviceId = b.getRequestId();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 18:
                                case 22:
                                    deviceId = b.getAdslot_id();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 19:
                                    deviceId = WindAds.sharedAds().getAppId();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 20:
                                    deviceId = b.getAd_source_logo();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 21:
                                    deviceId = b.getAd_source_channel();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 23:
                                    deviceId = b.getAd().vid;
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 24:
                                    deviceId = b.getCrid();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 25:
                                    deviceId = b.getCamp_id();
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 26:
                                    deviceId = b.getAd().cust_id;
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 27:
                                    deviceId = b.getAd().bid_price;
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 28:
                                    deviceId = b.getAd().product_id;
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 29:
                                    deviceId = b.getAd().settlement_price_enc;
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 30:
                                    deviceId = b.getAd().is_override;
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case 31:
                                    deviceId = b.getAd().forbiden_parse_landingpage;
                                    jSONObject2.put(string, deviceId);
                                    break;
                                case ' ':
                                    densityDpi = b.getDisplay_orientation();
                                    jSONObject2.put(string, densityDpi);
                                    break;
                                case '!':
                                    deviceId = b.getAd().expired_time;
                                    jSONObject2.put(string, deviceId);
                                    break;
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
                return b.a(200, "getAppInfo success ", jSONObject2);
            } catch (Throwable th) {
                return b.a(TbsListener.ErrorCode.INFO_CODE_MINIQB, "getAppInfo error: " + th.getMessage(), (Object) null);
            }
        }

        @JavascriptInterface
        public String hello(JSONObject jSONObject) {
            try {
                return jSONObject.toString();
            } catch (Throwable unused) {
                return null;
            }
        }

        @JavascriptInterface
        public String javascriptAddDcLog(final JSONObject jSONObject) {
            try {
                if (jSONObject == null) {
                    return b.a(TbsListener.ErrorCode.INFO_CODE_BASE, "not params", (Object) null);
                }
                if (!jSONObject.has("_ac_type")) {
                    return b.a(TbsListener.ErrorCode.ERROR_CODE_LOAD_BASE, "_ac_type is empty", (Object) null);
                }
                ae.a(jSONObject.getString("_ac_type"), b(), (LoadAdRequest) null, new ae.a() { // from class: com.sigmob.sdk.mraid.b.a.1
                    @Override // com.sigmob.sdk.base.common.ae.a
                    public void a(Object obj) {
                        HashMap hashMap = new HashMap();
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            if (next.equalsIgnoreCase(com.sigmob.sdk.base.k.m)) {
                                try {
                                    try {
                                        JSONObject jSONObject2 = new JSONObject(jSONObject.optString(next));
                                        Iterator<String> keys2 = jSONObject2.keys();
                                        while (keys2.hasNext()) {
                                            String next2 = keys2.next();
                                            hashMap.put(next2, jSONObject2.optString(next2));
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                } catch (Exception unused) {
                                    hashMap.put(com.sigmob.sdk.base.k.m, Base64.encodeToString(jSONObject.getString(com.sigmob.sdk.base.k.m).getBytes(), 2));
                                }
                            } else if (!next.equalsIgnoreCase("_ac_type")) {
                                try {
                                    hashMap.put(next, jSONObject.getString(next));
                                } catch (Throwable unused2) {
                                }
                            }
                        }
                        hashMap.put(com.sigmob.sdk.base.k.l, "js");
                        if (obj instanceof PointEntitySigmob) {
                            ((PointEntitySigmob) obj).setOptions(hashMap);
                        }
                    }
                });
                return b.a(200, "add dc log success", (Object) null);
            } catch (Throwable th) {
                return b.a(TbsListener.ErrorCode.INFO_CODE_MINIQB, th.toString(), (Object) null);
            }
        }

        @JavascriptInterface
        public String mraidJsLoaded() {
            b a = a();
            if (a == null || a.f == null) {
                return null;
            }
            a.f.b();
            return null;
        }

        @JavascriptInterface
        public void postMessage(final String str) {
            final b a = a();
            SigmobLog.d("postMessage: raw " + str);
            if (a != null) {
                a.g.post(new Runnable() { // from class: com.sigmob.sdk.mraid.b.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            a.a(jSONObject.optString("event"), jSONObject.optString("subEvent"), jSONObject.optJSONObject("args"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        a.e(str);
                    }
                });
            }
        }

        @JavascriptInterface
        public String tracking(JSONObject jSONObject) {
            try {
                BaseAdUnit b = b();
                String optString = jSONObject.optString("event");
                JSONArray optJSONArray = jSONObject.optJSONArray("urls");
                if (optJSONArray == null || optJSONArray.length() <= 0) {
                    return b.a(TbsListener.ErrorCode.ERROR_CODE_LOAD_BASE, "urls is empty", (Object) null);
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    ah ahVar = new ah(optJSONArray.optString(i), optString, b.getRequestId());
                    ahVar.setRetryNum(Integer.valueOf(b.getTrackingRetryNum()));
                    ahVar.setSource("js");
                    com.sigmob.sdk.base.network.g.a((AdTracker) ahVar, b, false);
                }
                return b.a(200, "tracking success", (Object) null);
            } catch (Throwable th) {
                return b.a(TbsListener.ErrorCode.INFO_CODE_MINIQB, "unknown error: " + th.getMessage(), (Object) null);
            }
        }
    }

    /* renamed from: com.sigmob.sdk.mraid.b$b, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface InterfaceC0048b {
        void a();

        void a(int i, int i2, int i3, int i4, a.EnumC0047a enumC0047a, boolean z);

        void a(WindAdError windAdError);

        void a(String str, Map<String, String> map);

        void a(URI uri);

        void a(URI uri, int i, String str);

        void a(URI uri, boolean z);

        void a(boolean z);

        void a(boolean z, k kVar);

        boolean a(ConsoleMessage consoleMessage);

        boolean a(String str, JsResult jsResult);

        void b();

        void b(String str, Map<String, String> map);

        void b(boolean z);

        void c();

        void d();

        void e();

        void f();

        void g();
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface c {
        void a(String str, JSONObject jSONObject);

        void b(String str, JSONObject jSONObject);

        void c(String str, JSONObject jSONObject);

        void d(String str, JSONObject jSONObject);

        void e(String str, JSONObject jSONObject);
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private interface d {
        void a(String str, Map<String, String> map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BaseAdUnit baseAdUnit, PlacementType placementType) {
        this(baseAdUnit, placementType, new i());
    }

    b(BaseAdUnit baseAdUnit, PlacementType placementType, i iVar) {
        this.j = new q() { // from class: com.sigmob.sdk.mraid.b.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                b.this.o();
            }

            @Override // com.sigmob.sdk.base.h, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                ae.a("h5_error", "mraid1", i, str2 + " error:" + str, (WindAdRequest) null, (LoadAdRequest) null, b.this.b, (ae.a) null);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                SigmobLog.i("onReceivedError:" + webResourceError.toString());
                int i = Build.VERSION.SDK_INT;
                if (i < 21 || i < 23) {
                    return;
                }
                ae.a("h5_error", "mraid1", 0, webResourceRequest.getUrl() + " error:" + ((Object) webResourceError.getDescription()), (WindAdRequest) null, (LoadAdRequest) null, b.this.b, (ae.a) null);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (Build.VERSION.SDK_INT >= 21) {
                    ae.a("h5_error", "mraid1", webResourceResponse.getStatusCode(), webResourceRequest.getUrl().toString(), (WindAdRequest) null, (LoadAdRequest) null, b.this.b, (ae.a) null);
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                b.this.a(renderProcessGoneDetail);
                return true;
            }

            @Override // com.sigmob.sdk.mraid.q, com.sigmob.sdk.base.h, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                if (!TextUtils.isEmpty(b.this.b.getVideoPath()) && str.endsWith(b.this.b.getVideoPath()) && b.this.b.isVideoExist()) {
                    try {
                        return new WebResourceResponse("video/mp4", "UTF-8", new FileInputStream(b.this.b.getVideoPath()));
                    } catch (FileNotFoundException e) {
                        SigmobLog.e(e.getMessage());
                    }
                }
                return super.shouldInterceptRequest(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return b.this.a(webView, str);
            }
        };
        this.b = baseAdUnit;
        this.f558c = placementType;
        this.d = iVar;
    }

    private int a(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            return i;
        }
        throw new com.sigmob.sdk.mraid.c("Integer parameter out of range: " + i);
    }

    private a.EnumC0047a a(String str, a.EnumC0047a enumC0047a) {
        if (TextUtils.isEmpty(str)) {
            return enumC0047a;
        }
        if (str.equals("top-left")) {
            return a.EnumC0047a.TOP_LEFT;
        }
        if (str.equals("top-right")) {
            return a.EnumC0047a.TOP_RIGHT;
        }
        if (str.equals("center")) {
            return a.EnumC0047a.CENTER;
        }
        if (str.equals("bottom-left")) {
            return a.EnumC0047a.BOTTOM_LEFT;
        }
        if (str.equals("bottom-right")) {
            return a.EnumC0047a.BOTTOM_RIGHT;
        }
        if (str.equals("top-center")) {
            return a.EnumC0047a.TOP_CENTER;
        }
        if (str.equals("bottom-center")) {
            return a.EnumC0047a.BOTTOM_CENTER;
        }
        throw new com.sigmob.sdk.mraid.c("Invalid close position: " + str);
    }

    public static String a(int i, String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("message", str);
            }
            if (obj != null) {
                jSONObject.put("data", obj);
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    private String a(Rect rect) {
        return rect.left + "," + rect.top + "," + rect.width() + "," + rect.height();
    }

    public static String a(String str) {
        if (str == null || str.equalsIgnoreCase("null") || str.equalsIgnoreCase("undefined")) {
            return null;
        }
        return str;
    }

    private URI a(String str, URI uri) {
        return str == null ? uri : i(str);
    }

    private void a(g gVar) {
        c("window.mraidbridge.nativeCallComplete(" + JSONObject.quote(gVar.a()) + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar, String str) {
        c("window.mraidbridge.notifyErrorEvent(" + JSONObject.quote(gVar.a()) + ", " + JSONObject.quote(str) + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, JSONObject jSONObject) {
        if (this.k == null) {
            return;
        }
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1068318794:
                if (str.equals("motion")) {
                    c2 = 0;
                    break;
                }
                break;
            case -720854149:
                if (str.equals("motionView")) {
                    c2 = 1;
                    break;
                }
                break;
            case 40710404:
                if (str.equals("addSubview")) {
                    c2 = 2;
                    break;
                }
                break;
            case 112408642:
                if (str.equals("vpaid")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1182268276:
                if (str.equals("belowSubview")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.k.d(str2, jSONObject);
                return;
            case 1:
                this.k.e(str2, jSONObject);
                return;
            case 2:
                this.k.c(str2, jSONObject);
                return;
            case 3:
                this.k.a(str2, jSONObject);
                return;
            case 4:
                this.k.b(str2, jSONObject);
                return;
            default:
                return;
        }
    }

    private boolean a(String str, boolean z) {
        return str == null ? z : h(str);
    }

    private String b(Rect rect) {
        return rect.width() + "," + rect.height();
    }

    private URI c(String str, String str2) {
        try {
            try {
                return str == null ? new URI(str2) : new URI(str);
            } catch (URISyntaxException unused) {
                return new URI(str2);
            }
        } catch (URISyntaxException unused2) {
            throw new com.sigmob.sdk.mraid.c("Invalid URL parameter: " + str);
        }
    }

    private int f(String str) {
        try {
            return Integer.parseInt(str, 10);
        } catch (NumberFormatException unused) {
            throw new com.sigmob.sdk.mraid.c("Invalid numeric parameter: " + str);
        }
    }

    private k g(String str) {
        if ("portrait".equals(str)) {
            return k.PORTRAIT;
        }
        if ("landscape".equals(str)) {
            return k.LANDSCAPE;
        }
        if ("none".equals(str)) {
            return k.NONE;
        }
        throw new com.sigmob.sdk.mraid.c("Invalid orientation: " + str);
    }

    private boolean h(String str) {
        if ("true".equals(str)) {
            return true;
        }
        if ("false".equals(str)) {
            return false;
        }
        throw new com.sigmob.sdk.mraid.c("Invalid boolean parameter: " + str);
    }

    private URI i(String str) {
        if (str == null) {
            throw new com.sigmob.sdk.mraid.c("Parameter cannot be null");
        }
        try {
            return new URI(str);
        } catch (URISyntaxException unused) {
            throw new com.sigmob.sdk.mraid.c("Invalid URL parameter: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.i) {
            return;
        }
        this.i = true;
        InterfaceC0048b interfaceC0048b = this.f;
        if (interfaceC0048b != null) {
            interfaceC0048b.a();
        }
    }

    public String a() {
        return this.e;
    }

    void a(int i) {
        c("bridge.notifyApkDownloadProcessEvent(" + i + ");");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2, int i3, int i4) {
        c("mraidbridge.setSafeAreaInsets(" + (i + "," + i2 + "," + i3 + "," + i4) + ")");
    }

    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    public void a(Context context, String str) {
        p pVar = this.g;
        if (pVar == null) {
            SigmobLog.e("MRAID bridge called setContentHtml before WebView was attached");
            return;
        }
        pVar.addJavascriptInterface(new a(this), "sigandroid");
        this.i = false;
        File b = com.sigmob.sdk.base.utils.e.b(str, Md5Util.md5(str) + ".html");
        if (b == null || TextUtils.isEmpty(b.getAbsolutePath())) {
            this.g.loadDataWithBaseURL(Networking.getBaseUrlScheme() + "://localhost/", str, "text/html", "UTF-8", null);
            return;
        }
        this.g.loadUrl("file://" + b.getAbsolutePath());
    }

    public void a(Location location) {
        c("mraidbridge.setLocation(" + location.getLatitude() + "," + location.getLongitude() + ",\"" + location.getProvider() + "\");");
    }

    @TargetApi(26)
    void a(RenderProcessGoneDetail renderProcessGoneDetail) {
        WindAdError windAdError = (renderProcessGoneDetail == null || !renderProcessGoneDetail.didCrash()) ? WindAdError.RENDER_PROCESS_GONE_UNSPECIFIED : WindAdError.RENDER_PROCESS_GONE_WITH_CRASH;
        SigmobLog.e("handleRenderProcessGone " + windAdError.toString());
        b();
        InterfaceC0048b interfaceC0048b = this.f;
        if (interfaceC0048b != null) {
            interfaceC0048b.a(windAdError);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ValueCallback valueCallback) {
        a("mraidbridge.getPlayProgress();", valueCallback);
    }

    void a(AppInfo appInfo) {
        c("bridge.fireChangeEvent({" + appInfo.toString().replace("=", ":") + "});");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(CurrentAppOrientation currentAppOrientation) {
        c("mraidbridge.fireChangeEvent({" + currentAppOrientation.toString().replace("=", ":") + "});");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ExposureChange exposureChange) {
        c("mraidbridge.fireChangeEvent({" + exposureChange.toString().replace("=", ":") + "});");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MraidEnv mraidEnv) {
        c("mraidbridge.fireChangeEvent(" + JSONSerializer.Serialize(mraidEnv, "env", true) + ");");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PlacementType placementType) {
        c("mraidbridge.setPlacementType(" + JSONObject.quote(placementType.toJavascriptString()) + ")");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(VideoItem videoItem) {
        c("bridge.fireChangeEvent(" + JSONSerializer.Serialize(videoItem, PointCategory.VIDEO, false) + ");");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ViewState viewState) {
        c("mraidbridge.setState(" + JSONObject.quote(viewState.toJavascriptString()) + ")");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Ad ad, SlotAdSetting slotAdSetting) {
        String Serialize = JSONSerializer.Serialize(ad, "ad", true);
        try {
            String Serialize2 = JSONSerializer.Serialize(slotAdSetting, (String) null, true);
            JSONObject jSONObject = new JSONObject(Serialize);
            jSONObject.getJSONObject("ad").put("slotAdSetting", new JSONObject(Serialize2));
            c("bridge.fireChangeEvent(" + jSONObject.toString() + ");");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MaterialMeta materialMeta) {
        c("bridge.fireChangeEvent(" + JSONSerializer.Serialize(materialMeta, ClickCommon.CLICK_AREA_MATERIAL, true) + ");");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RvAdSetting rvAdSetting) {
        c("bridge.fireChangeEvent(" + JSONSerializer.Serialize(rvAdSetting, "rvSetting", false) + ");");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(InterfaceC0048b interfaceC0048b) {
        this.f = interfaceC0048b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar) {
        this.k = cVar;
    }

    void a(final g gVar, Map<String, String> map) {
        if (this.f == null) {
            throw new com.sigmob.sdk.mraid.c("Invalid state to execute this command");
        }
        if (this.g == null) {
            throw new com.sigmob.sdk.mraid.c("The current WebView is being destroyed");
        }
        switch (AnonymousClass5.a[gVar.ordinal()]) {
            case 1:
                this.f.d();
                return;
            case 2:
                this.f.e();
                return;
            case 3:
                this.f.f();
                return;
            case 4:
                this.f.a(a(f(map.get("width")), 0, 100000), a(f(map.get("height")), 0, 100000), a(f(map.get("offsetX")), -100000, 100000), a(f(map.get("offsetY")), -100000, 100000), a(map.get("customClosePosition"), a.EnumC0047a.TOP_RIGHT), a(map.get("allowOffscreen"), true));
                return;
            case 5:
                this.f.a(a(map.get("url"), (URI) null), a(map.get("shouldUseCustomClose"), false));
                return;
            case 6:
                this.f.b(a(map.get("shouldUseCustomClose"), false));
                return;
            case 7:
                this.f.a(c(map.get("url"), ""), 1, a(map.get(com.sigmob.sdk.base.k.m)));
                return;
            case 8:
                this.f.g();
                return;
            case 9:
                this.f.a(h(map.get("allowOrientationChange")), g(map.get("forceOrientation")));
                return;
            case 10:
                this.f.a(i(map.get("uri")));
                return;
            case 11:
                this.d.a(this.g.getContext(), i(map.get("uri")).toString(), new i.a() { // from class: com.sigmob.sdk.mraid.b.4
                    @Override // com.sigmob.sdk.mraid.i.a
                    public void a(com.sigmob.sdk.mraid.c cVar) {
                        b.this.a(gVar, cVar.getMessage());
                    }
                });
                return;
            case 12:
                this.d.a(this.g.getContext(), map);
                return;
            case 13:
                this.f.a(map.get("event"), map);
                return;
            case 14:
                this.f.b(map.get("event"), map);
                return;
            case 15:
                throw new com.sigmob.sdk.mraid.c("Unspecified MRAID Javascript command");
            default:
                return;
        }
    }

    public void a(l lVar) {
        c("mraidbridge.setScreenSize(" + b(lVar.c()) + ");mraidbridge.setMaxSize(" + b(lVar.e()) + ");mraidbridge.setCurrentPosition(" + a(lVar.g()) + ");mraidbridge.setDefaultPosition(" + a(lVar.i()) + ")");
        StringBuilder sb = new StringBuilder();
        sb.append("mraidbridge.notifySizeChangeEvent(");
        sb.append(b(lVar.g()));
        sb.append(")");
        c(sb.toString());
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void a(p pVar) {
        this.g = pVar;
        try {
            ReflectionUtil.MethodBuilder methodBuilder = new ReflectionUtil.MethodBuilder(pVar.getSettings(), new String(Base64.decode(com.sigmob.sdk.base.k.C, 2)));
            methodBuilder.addParam(Boolean.TYPE, Boolean.TRUE);
            methodBuilder.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ReflectionUtil.MethodBuilder methodBuilder2 = new ReflectionUtil.MethodBuilder(pVar.getSettings(), new String(Base64.decode(com.sigmob.sdk.base.k.E, 2)));
            methodBuilder2.addParam(Boolean.TYPE, Boolean.TRUE);
            methodBuilder2.execute();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= 17 && this.f558c == PlacementType.INTERSTITIAL) {
            pVar.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        this.j.b(this.b.isDisablexRequestWith());
        this.j.a(com.sigmob.sdk.base.l.a().Z());
        this.g.setScrollContainer(false);
        this.g.setVerticalScrollBarEnabled(false);
        this.g.setHorizontalScrollBarEnabled(false);
        this.g.setBackgroundColor(0);
        this.g.setAdUnit(this.b);
        this.g.a((o.a) null);
        this.g.setWebViewClient(this.j);
        this.g.setWebChromeClient(new WebChromeClient() { // from class: com.sigmob.sdk.mraid.b.2
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                return b.this.f != null ? b.this.f.a(consoleMessage) : super.onConsoleMessage(consoleMessage);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                return b.this.f != null ? b.this.f.a(str2, jsResult) : super.onJsAlert(webView, str, str2, jsResult);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                super.onShowCustomView(view, customViewCallback);
            }
        });
        this.h = new aq(this.g.getContext(), this.g, this.b);
        this.g.setVisibilityChangedListener(new p.a() { // from class: com.sigmob.sdk.mraid.b.3
            @Override // com.sigmob.sdk.mraid.p.a
            public void a(boolean z) {
                if (b.this.f != null) {
                    b.this.f.a(z);
                }
            }
        });
    }

    public void a(String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uniqueId", str);
            jSONObject.put("currentTime", i / 1000.0f);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c("mraidbridge.setvdPlayToEnd(" + jSONObject + ")");
    }

    public void a(String str, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uniqueId", str);
            jSONObject.put("currentTime", i / 1000.0f);
            jSONObject.put("duration", i2 / 1000.0f);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c("mraidbridge.setvdPlayCurrentTime(" + jSONObject + ")");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, int i2, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uniqueId", str);
            jSONObject.put("duration", i / 1000.0f);
            jSONObject.put("width", i2);
            jSONObject.put("height", i3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c("mraidbridge.setvdReadyToPlay(" + jSONObject + ")");
    }

    void a(String str, ValueCallback valueCallback) {
        if (this.g == null) {
            SigmobLog.e("Attempted to inject Javascript into MRAID WebView while was not attached:\n\t" + str);
            return;
        }
        if (str.startsWith("bridge")) {
            str = str.replaceFirst("bridge", StringUtil.decode(StringUtil.s));
        }
        SigmobLog.d("Injecting Javascript into MRAID WebView:\n\t" + str);
        if (Build.VERSION.SDK_INT >= 19) {
            this.g.evaluateJavascript(str, valueCallback);
            return;
        }
        SigmobLog.e("Injecting Javascript into MRAID WebView:\n\t can't support less KITKAT" + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2) {
        this.e = String.format("%s,%s,%s,%s", str, str2, str, str2);
        this.b.getMacroCommon().updateClickMarco(str, str2, str, str2);
        this.b.getClickCommon().down = new TouchLocation(Integer.parseInt(str), Integer.parseInt(str2));
        this.b.getClickCommon().up = new TouchLocation(Integer.parseInt(str), Integer.parseInt(str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, String str3, HashMap<String, Object> hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("event", str3);
            jSONObject2.put("uniqueId", str);
            if (hashMap != null) {
                jSONObject2.put("args", new JSONObject(hashMap));
            }
            jSONObject.put("onChangeFired", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, HashMap<String, Object> hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("event", str);
            if (hashMap != null) {
                jSONObject2.put("args", new JSONObject(hashMap));
            }
            jSONObject.put("onChangeEvent", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        c("mraidbridge.setIsViewable(" + z + ")");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        c("mraidbridge.setSupports(" + z + "," + z2 + "," + z3 + "," + z4 + "," + z5 + "," + z6 + "," + z7 + ")");
    }

    boolean a(WebView webView, String str) {
        int i;
        InterfaceC0048b interfaceC0048b;
        try {
            new URI(str);
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            if (StringUtil.decode(StringUtil.s).equals(scheme)) {
                if ("failLoad".equals(host) && this.f558c == PlacementType.INLINE && (interfaceC0048b = this.f) != null) {
                    interfaceC0048b.c();
                }
                return true;
            }
            if (BaseAdActivity.f649c.equals(scheme)) {
                g a2 = g.a(host);
                try {
                    a(a2, ClientMetadata.getQueryParamMap(parse));
                } catch (Throwable th) {
                    a(a2, th.getMessage());
                }
                a(a2);
                return true;
            }
            if (!TextUtils.isEmpty(str)) {
                if (str.startsWith("http")) {
                    webView.loadUrl(str);
                } else {
                    try {
                        List<String> list = this.b.getAdSetting() != null ? this.b.getAdSetting().scheme_white_list : null;
                        if (list != null && list.size() > 0) {
                            while (i < list.size()) {
                                String str2 = list.get(i);
                                i = (str.startsWith(str2) || str2.equals("*")) ? 0 : i + 1;
                                u.a(this.g.getContext(), Uri.parse(str));
                                return true;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return true;
        } catch (URISyntaxException unused) {
            SigmobLog.e("Invalid MRAID URL: " + str);
            a(g.UNSPECIFIED, "Mraid command sent an invalid URL");
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f = null;
        this.k = null;
        p pVar = this.g;
        if (pVar != null) {
            pVar.destroy();
            this.g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ValueCallback valueCallback) {
        a("mraidbridge.getAdDuration();", valueCallback);
    }

    @SuppressLint({"JavascriptInterface"})
    public void b(String str) {
        p pVar = this.g;
        if (pVar == null) {
            SigmobLog.e("MRAID bridge called setContentHtml while WebView was not attached");
            return;
        }
        pVar.addJavascriptInterface(new a(this), "sigandroid");
        this.i = false;
        this.g.loadUrl(str);
    }

    public void b(String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uniqueId", str);
            jSONObject.put("state", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c("mraidbridge.setvdLoadStateChanged(" + jSONObject + ")");
    }

    public void b(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uniqueId", str);
            jSONObject.put("error", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c("mraidbridge.setvdPlayError(" + jSONObject + ")");
    }

    void c() {
        c("bridge.fireChangeEvent({\"osType\":2});");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str) {
        if (this.g == null) {
            SigmobLog.e("Attempted to inject Javascript into MRAID WebView while was not attached:\n\t" + str);
            return;
        }
        if (str.startsWith("bridge")) {
            str = str.replaceFirst("bridge", StringUtil.decode(StringUtil.s));
        }
        SigmobLog.d("Injecting Javascript into MRAID WebView:\n\t" + str);
        if (Build.VERSION.SDK_INT >= 19) {
            this.g.evaluateJavascript(str, null);
            return;
        }
        this.g.loadUrl("javascript:" + str);
    }

    public void c(String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uniqueId", str);
            jSONObject.put("state", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c("mraidbridge.setvdPlayStateChanged(" + jSONObject + ")");
    }

    void d() {
        c("mraidbridge.fireChangeEvent({\"hostSDKVersion\":4.19.8});");
    }

    void d(String str) {
        c("mraidbridge.fireVideoSrc(\"" + str + "\")");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        c("mraidbridge.notifyReadyEvent();");
    }

    void e(String str) {
        c("mraidbridge.nativeCallCompleteV2(" + JSONObject.quote(str) + ")");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        c("bridge.notifyApkDownloadStartEvent();");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        c("bridge.notifyApkDownloadFailEvent();");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        c("bridge.notifyApkDownloadEndEvent();");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        c("bridge.notifyApkDownloadInstalledEvent();");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        c("mraidbridge.startAd();");
    }

    boolean k() {
        aq aqVar = this.h;
        return aqVar != null && aqVar.c();
    }

    boolean l() {
        p pVar = this.g;
        return pVar != null && pVar.j();
    }

    boolean m() {
        return this.g != null;
    }

    boolean n() {
        return this.i;
    }
}
