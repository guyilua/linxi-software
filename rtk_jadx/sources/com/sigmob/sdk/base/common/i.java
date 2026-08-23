package com.sigmob.sdk.base.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.czhj.sdk.common.network.JsonRequest;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.SigmobRequestQueue;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.common.utils.TouchLocation;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.VolleyError;
import com.czhj.wire.Wire;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.an;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.AndroidMarket;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.base.views.q;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class i {
    private static final long serialVersionUID = 2;
    protected Map<String, String> a;
    protected String b;

    /* renamed from: c, reason: collision with root package name */
    protected String f386c;
    protected String d;
    protected String e;
    protected String f;
    protected String g;
    protected String h;
    public boolean j;
    private boolean l;
    private boolean m;
    private String n;
    private boolean o;
    private ac p;
    private com.sigmob.sdk.base.views.q q;
    private WeakReference<Activity> r;
    private q.b s;
    private WeakReference<BaseAdUnit> t;
    private boolean u;
    private int v;
    protected int i = 1;
    private final List<com.sigmob.sdk.videoAd.f> k = new ArrayList();

    /* renamed from: com.sigmob.sdk.base.common.i$2, reason: invalid class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[am.values().length];
            b = iArr;
            try {
                iArr[am.FOLLOW_PACKAGE_NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[am.IGNORE_ABOUT_SCHEME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[am.MINI_PROGRAM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[am.FOLLOW_DEEP_LINK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[am.MARKET_SCHEME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[am.DOWNLOAD_APK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[am.OPEN_WITH_BROWSER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[am.NOOP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[com.sigmob.sdk.base.a.values().length];
            a = iArr2;
            try {
                iArr2[com.sigmob.sdk.base.a.COMPANION.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[com.sigmob.sdk.base.a.VIDEO_CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public static i a(BaseAdUnit baseAdUnit) {
        i iVar = new i();
        iVar.b(baseAdUnit);
        return iVar;
    }

    public static void a(final BaseAdUnit baseAdUnit, String str, boolean z) {
        Intent launchIntentForPackage;
        final String macroProcess = baseAdUnit.getMacroCommon().macroProcess(str);
        String apkPackageName = baseAdUnit.getApkPackageName();
        if (baseAdUnit.getsubInteractionType() == 2 || !TextUtils.isEmpty(apkPackageName)) {
            String productId = baseAdUnit.getProductId();
            if (TextUtils.isEmpty(apkPackageName)) {
                apkPackageName = productId;
            }
            if (!TextUtils.isEmpty(apkPackageName) && (launchIntentForPackage = com.sigmob.sdk.b.e().getPackageManager().getLaunchIntentForPackage(apkPackageName)) != null) {
                try {
                    h.c(baseAdUnit);
                    new Handler().postDelayed(new Runnable() { // from class: com.sigmob.sdk.base.common.i.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.f() != null) {
                                h.c((BaseAdUnit) null);
                                ae.a("open_pkg", "0", BaseAdUnit.this);
                            }
                        }
                    }, 3000L);
                    u.b(com.sigmob.sdk.b.e(), launchIntentForPackage);
                    return;
                } catch (Throwable th) {
                    SigmobLog.e("launch fail", th);
                }
            }
        }
        if (baseAdUnit.getsubInteractionType() != 1 || z) {
            p.a(macroProcess, baseAdUnit);
            return;
        }
        JsonRequest jsonRequest = new JsonRequest(macroProcess, new JsonRequest.Listener() { // from class: com.sigmob.sdk.base.common.i.7
            public void onErrorResponse(VolleyError volleyError) {
                ae.a("download_start", "0", BaseAdUnit.this, new ae.a() { // from class: com.sigmob.sdk.base.common.i.7.5
                    @Override // com.sigmob.sdk.base.common.ae.a
                    public void a(Object obj) {
                        if (obj instanceof PointEntitySigmob) {
                            ((PointEntitySigmob) obj).setFinal_url(macroProcess);
                        }
                    }
                });
                ae.a("download_start", 0, volleyError.getMessage(), BaseAdUnit.this, new ae.a() { // from class: com.sigmob.sdk.base.common.i.7.6
                    @Override // com.sigmob.sdk.base.common.ae.a
                    public void a(Object obj) {
                        if (obj instanceof PointEntitySigmobError) {
                            ((PointEntitySigmobError) obj).setFinal_url(macroProcess);
                        }
                    }
                });
                SigmobLog.e(volleyError.getMessage());
            }

            public void onSuccess(JSONObject jSONObject) {
                try {
                    SigmobLog.d("GDTConvertRequest response " + jSONObject);
                    if (jSONObject.getInt("ret") == 0) {
                        String string = jSONObject.getJSONObject("data").getString("dstlink");
                        BaseAdUnit.this.getMacroCommon().addMarcoKey(SigMacroCommon._CLICKID_, jSONObject.getJSONObject("data").getString("clickid"));
                        p.a(string, BaseAdUnit.this);
                    } else {
                        ae.a("download_start", "0", BaseAdUnit.this, new ae.a() { // from class: com.sigmob.sdk.base.common.i.7.1
                            @Override // com.sigmob.sdk.base.common.ae.a
                            public void a(Object obj) {
                                if (obj instanceof PointEntitySigmob) {
                                    ((PointEntitySigmob) obj).setFinal_url(macroProcess);
                                }
                            }
                        });
                        ae.a("download_start", 0, jSONObject.toString(), BaseAdUnit.this, new ae.a() { // from class: com.sigmob.sdk.base.common.i.7.2
                            @Override // com.sigmob.sdk.base.common.ae.a
                            public void a(Object obj) {
                                if (obj instanceof PointEntitySigmobError) {
                                    ((PointEntitySigmobError) obj).setFinal_url(macroProcess);
                                }
                            }
                        });
                    }
                } catch (Throwable th2) {
                    SigmobLog.e(th2.getMessage());
                    ae.a("download_start", "0", BaseAdUnit.this, new ae.a() { // from class: com.sigmob.sdk.base.common.i.7.3
                        @Override // com.sigmob.sdk.base.common.ae.a
                        public void a(Object obj) {
                            if (obj instanceof PointEntitySigmob) {
                                ((PointEntitySigmob) obj).setFinal_url(macroProcess);
                            }
                        }
                    });
                    ae.a("download_start", 0, th2.getMessage(), BaseAdUnit.this, new ae.a() { // from class: com.sigmob.sdk.base.common.i.7.4
                        @Override // com.sigmob.sdk.base.common.ae.a
                        public void a(Object obj) {
                            if (obj instanceof PointEntitySigmobError) {
                                ((PointEntitySigmobError) obj).setFinal_url(macroProcess);
                            }
                        }
                    });
                }
            }
        }, 1);
        SigmobRequestQueue sigRequestQueue = Networking.getSigRequestQueue();
        if (sigRequestQueue == null) {
            ae.a("download_start", "0", baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.i.8
                @Override // com.sigmob.sdk.base.common.ae.a
                public void a(Object obj) {
                    if (obj instanceof PointEntitySigmob) {
                        ((PointEntitySigmob) obj).setFinal_url(macroProcess);
                    }
                }
            });
            ae.a("download_start", 0, "request queue is null", baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.i.9
                @Override // com.sigmob.sdk.base.common.ae.a
                public void a(Object obj) {
                    if (obj instanceof PointEntitySigmobError) {
                        ((PointEntitySigmobError) obj).setFinal_url(macroProcess);
                    }
                }
            });
        } else {
            jsonRequest.setTag("GDTRequestConvert");
            sigRequestQueue.add(jsonRequest);
        }
    }

    private void a(BaseAdUnit baseAdUnit, boolean z) {
        if (baseAdUnit == null || !z) {
            return;
        }
        String str = baseAdUnit.getClickCommon().is_final_click ? "1" : "0";
        SigMacroCommon macroCommon = baseAdUnit.getMacroCommon();
        if (macroCommon instanceof SigMacroCommon) {
            macroCommon.addMarcoKey("_AX_", baseAdUnit.getClickCommon().adarea_x);
            macroCommon.addMarcoKey("_AY_", baseAdUnit.getClickCommon().adarea_y);
            macroCommon.addMarcoKey("_AW_", baseAdUnit.getClickCommon().adarea_w);
            macroCommon.addMarcoKey("_AH_", baseAdUnit.getClickCommon().adarea_h);
            if ("5".equals(baseAdUnit.getClickCommon().sld)) {
                macroCommon.updateClickMarco("-999", "-999", "-999", "-999");
                macroCommon.addMarcoKey(SigMacroCommon._SLD_, baseAdUnit.getClickCommon().sld);
                macroCommon.addMarcoKey("_TURNX_", baseAdUnit.getClickCommon().turn_x);
                macroCommon.addMarcoKey("_TURNY_", baseAdUnit.getClickCommon().turn_y);
                macroCommon.addMarcoKey("_TURNZ_", baseAdUnit.getClickCommon().turn_z);
                macroCommon.addMarcoKey("_TURNTIME_", baseAdUnit.getClickCommon().turn_time);
                macroCommon.addMarcoKey("_CPTIDS_", String.valueOf(baseAdUnit.getClickCommon().widget_id));
            } else if ("2".equals(baseAdUnit.getClickCommon().sld)) {
                macroCommon.updateClickMarco("-999", "-999", "-999", "-999");
                macroCommon.addMarcoKey(SigMacroCommon._SLD_, baseAdUnit.getClickCommon().sld);
                macroCommon.addMarcoKey("_CPTIDS_", String.valueOf(baseAdUnit.getClickCommon().widget_id));
                macroCommon.addMarcoKey("_XMAXACC_", baseAdUnit.getClickCommon().x_max_acc);
                macroCommon.addMarcoKey("_YMAXACC_", baseAdUnit.getClickCommon().y_max_acc);
                macroCommon.addMarcoKey("_ZMAXACC_", baseAdUnit.getClickCommon().z_max_acc);
            } else if (baseAdUnit.getCreativeType() != 9) {
                baseAdUnit.getClickCommon().sld = "0";
                macroCommon.updateClickMarco(baseAdUnit.getClickCommon().down, baseAdUnit.getClickCommon().up);
                macroCommon.addMarcoKey(SigMacroCommon._SLD_, "0");
            }
            if (baseAdUnit.getTemplateId() > 0) {
                macroCommon.addMarcoKey(SigMacroCommon._TEMPLATE_, String.valueOf(baseAdUnit.getTemplateId()));
            }
            if (!TextUtils.isEmpty(baseAdUnit.getClickCommon().click_area)) {
                macroCommon.addMarcoKey(SigMacroCommon._CLICKAREA_, String.valueOf(baseAdUnit.getClickCommon().click_area));
            }
            if (!TextUtils.isEmpty(baseAdUnit.getClickCommon().click_scene)) {
                macroCommon.addMarcoKey(SigMacroCommon._CLICKSCENE_, String.valueOf(baseAdUnit.getClickCommon().click_scene));
            }
            macroCommon.addMarcoKey(SigMacroCommon._FINALCLICK_, str);
        }
    }

    private void b(com.sigmob.sdk.base.a aVar, String str, String str2, boolean z) {
        ag sessionManager;
        String str3;
        int i = AnonymousClass2.a[aVar.ordinal()];
        if (i == 1) {
            sessionManager = l().getSessionManager();
            str3 = a.w;
        } else if (i != 2) {
            sessionManager = l().getSessionManager();
            str3 = "click";
        } else {
            sessionManager = l().getSessionManager();
            str3 = "full_video_click";
        }
        sessionManager.a(str3, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseAdUnit l() {
        WeakReference<BaseAdUnit> weakReference = this.t;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public List<com.sigmob.sdk.videoAd.f> a(long j, long j2) {
        if (j2 <= 0 || j < 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        com.sigmob.sdk.videoAd.f fVar = new com.sigmob.sdk.videoAd.f("play_quarter", ((float) j) / ((float) j2));
        int size = this.k.size();
        for (int i = 0; i < size; i++) {
            com.sigmob.sdk.videoAd.f fVar2 = this.k.get(i);
            if (fVar2.compareTo(fVar) > 0) {
                break;
            }
            if (!fVar2.isTracked()) {
                arrayList.add(fVar2);
            }
        }
        return arrayList;
    }

    public void a(int i) {
        this.v = i;
    }

    public void a(Activity activity, BaseAdUnit baseAdUnit, q.b bVar) {
        if (baseAdUnit == null) {
            return;
        }
        if (activity != null) {
            this.r = new WeakReference<>(activity);
        }
        this.s = bVar;
    }

    public void a(Context context, int i, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
        ae.b("start", null, baseAdUnit);
        com.sigmob.sdk.base.network.g.a(baseAdUnit, "start");
    }

    public void a(Context context, TouchLocation touchLocation, TouchLocation touchLocation2, com.sigmob.sdk.base.a aVar, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    public void a(Context context, BaseAdUnit baseAdUnit) {
        ae.a(PointCategory.LANDING_PAGE_SHOW, (String) null, baseAdUnit);
    }

    public void a(Context context, String str, BaseAdUnit baseAdUnit, String str2, int i) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
        ae.a(str2, i, str, baseAdUnit);
    }

    public void a(com.sigmob.sdk.base.a aVar, String str, String str2, boolean z) {
        a(aVar, str, str2, z, false);
    }

    public void a(final com.sigmob.sdk.base.a aVar, String str, String str2, final boolean z, final boolean z2) {
        String str3 = this.b;
        if (!TextUtils.isEmpty(str)) {
            str3 = str;
        }
        l().getClickCommon().clickUIType = aVar;
        l().getClickCommon().clickCoordinate = str2;
        l().getClickCommon().clickUrl = str3;
        a(l(), z);
        new an.a().a(am.IGNORE_ABOUT_SCHEME, am.OPEN_WITH_BROWSER, am.MARKET_SCHEME, am.DOWNLOAD_APK, am.FOLLOW_PACKAGE_NAME, am.FOLLOW_DEEP_LINK, am.MINI_PROGRAM).a(new an.b() { // from class: com.sigmob.sdk.base.common.i.10
            @Override // com.sigmob.sdk.base.common.an.b
            public void a(final String str4, am amVar) {
                AndroidMarket androidMarket;
                SigmobLog.d("urlHandlingSucceeded: " + amVar.name() + " url: " + str4);
                i.this.l().getClickCommon().is_final_click = true;
                if (!i.this.l().getAd().forbiden_parse_landingpage.booleanValue()) {
                    ae.a(i.this.l(), amVar.name(), str4);
                }
                i.this.l().getClickCommon().isDeeplink = "0";
                int i = AnonymousClass2.b[amVar.ordinal()];
                if (i == 3) {
                    if (z) {
                        com.sigmob.sdk.base.network.g.a(i.this.l(), "open_deeplink");
                        ae.a("open_deeplink", (String) null, i.this.l(), new ae.a() { // from class: com.sigmob.sdk.base.common.i.10.1
                            @Override // com.sigmob.sdk.base.common.ae.a
                            public void a(Object obj) {
                                if (obj instanceof PointEntitySigmob) {
                                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                                    pointEntitySigmob.setFinal_url(str4);
                                    if (i.this.l().getInteractionType() == 8) {
                                        pointEntitySigmob.getOptions().put("fast_pkg", com.sigmob.sdk.b.a());
                                    }
                                }
                            }
                        });
                    }
                    i.this.l().getClickCommon().isDeeplink = "1";
                } else if (i != 5) {
                    if (i == 6) {
                        if (z2 && i.this.j()) {
                            i.this.l().getClickCommon().is_final_click = false;
                        } else {
                            i.this.f(str4);
                        }
                    }
                } else if (z) {
                    BaseAdUnit l = i.this.l();
                    if (l != null && (androidMarket = l.getAndroidMarket()) != null) {
                        ae.a(PointCategory.APK_CLICK, ((Integer) Wire.get(androidMarket.type, 0)).intValue() == 0 ? BaseConstants.SCHEME_MARKET : "mimarket", l);
                        if (!TextUtils.isEmpty(androidMarket.app_package_name)) {
                            try {
                                FileUtil.writeToCache(l, new File(com.sigmob.sdk.base.utils.e.g(), androidMarket.app_package_name + ".log").getAbsolutePath());
                            } catch (Throwable th) {
                                SigmobLog.e("write ad info with package error " + th.getMessage());
                            }
                        }
                    }
                    ae.a(PointCategory.OPEN_MARKET, (String) null, i.this.l(), new ae.a() { // from class: com.sigmob.sdk.base.common.i.10.2
                        @Override // com.sigmob.sdk.base.common.ae.a
                        public void a(Object obj) {
                            if (obj instanceof PointEntitySigmob) {
                                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                                pointEntitySigmob.setFinal_url(str4);
                                if (i.this.l().getAndroidMarket() != null) {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("app_package_name", i.this.l().getAndroidMarket().app_package_name);
                                    hashMap.put("store_package_name", i.this.l().getAndroidMarket().appstore_package_name);
                                    pointEntitySigmob.setOptions(hashMap);
                                }
                            }
                        }
                    });
                }
                i.this.l().setCustomDeeplink(null);
                i.this.l().setCustomAndroidMarket(null);
                i.this.l().setCustomLandPageUrl(null);
                if (i.this.p != null) {
                    i.this.p.a(z, aVar);
                }
            }

            @Override // com.sigmob.sdk.base.common.an.b
            public void b(final String str4, am amVar) {
                SigmobLog.d("urlHandlingFailed: " + amVar.name() + " url: " + str4);
                i.this.l().getClickCommon().isDeeplink = "0";
                int i = AnonymousClass2.b[amVar.ordinal()];
                if (i == 3 || i == 4) {
                    if (z) {
                        com.sigmob.sdk.base.network.g.a(i.this.l(), "open_deeplink_failed");
                        ae.a("open_deeplink_failed", (String) null, i.this.l(), new ae.a() { // from class: com.sigmob.sdk.base.common.i.10.3
                            @Override // com.sigmob.sdk.base.common.ae.a
                            public void a(Object obj) {
                                if (obj instanceof PointEntitySigmob) {
                                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                                    pointEntitySigmob.setFinal_url(str4);
                                    if (i.this.l().getInteractionType() == 8) {
                                        pointEntitySigmob.getOptions().put("fast_pkg", com.sigmob.sdk.b.a());
                                    }
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                if (i == 5) {
                    if (z) {
                        ae.a(PointCategory.OPEN_MARKET_FAILED, str4, i.this.l(), new ae.a() { // from class: com.sigmob.sdk.base.common.i.10.4
                            @Override // com.sigmob.sdk.base.common.ae.a
                            public void a(Object obj) {
                                if (obj instanceof PointEntitySigmob) {
                                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                                    pointEntitySigmob.setFinal_url(str4);
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("app_package_name", i.this.l().getAndroidMarket().app_package_name);
                                    hashMap.put("store_package_name", i.this.l().getAndroidMarket().appstore_package_name);
                                    pointEntitySigmob.setOptions(hashMap);
                                }
                            }
                        });
                    }
                } else {
                    if (i != 8) {
                        return;
                    }
                    if (TextUtils.isEmpty(str4) && !i.this.l().getAd().forbiden_parse_landingpage.booleanValue()) {
                        ae.a(i.this.l(), amVar.name(), str4);
                    }
                    i.this.l().setCustomDeeplink(null);
                    i.this.l().setCustomAndroidMarket(null);
                    i.this.l().setCustomLandPageUrl(null);
                    if (i.this.p != null) {
                        i.this.p.a(z, aVar);
                    }
                }
            }
        }).a(l()).a(l().isSkipSigmobBrowser()).b(l().getAd().forbiden_parse_landingpage.booleanValue()).a().a(com.sigmob.sdk.b.e(), str);
    }

    public void a(com.sigmob.sdk.base.a aVar, String str, String str2, boolean z, boolean z2, JSONObject jSONObject) {
        int i;
        boolean z3;
        if (jSONObject != null) {
            i = jSONObject.optInt("interaction_type", 2);
            z3 = jSONObject.optBoolean("disable_landing");
        } else {
            i = 2;
            z3 = false;
        }
        if (!z3 || TextUtils.isEmpty(str)) {
            a(aVar, str, str2, z, z2);
            return;
        }
        String optString = jSONObject.optString("failback_url");
        String optString2 = jSONObject.optString("product_name");
        String optString3 = jSONObject.optString("app_icon_url");
        try {
            try {
                if (i == 1) {
                    u.a(com.sigmob.sdk.b.e(), Uri.parse(str));
                } else if (i == 2) {
                    this.n = str;
                    BaseAdUnit l = l();
                    p.a(this.n, optString3, optString2, l != null ? l.getApkDownloadType() : 0);
                } else if (i == 7) {
                    u.a(com.sigmob.sdk.b.e(), jSONObject.optString("wx_app_id"), jSONObject.optString("wx_app_username"), jSONObject.optString("wx_app_path"), jSONObject.optInt("wx_business_type"), jSONObject.optString("wx_ext_msg"));
                } else if (i == 9) {
                    u.b(com.sigmob.sdk.b.e(), jSONObject.optString("package_name"));
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            u.a(com.sigmob.sdk.b.e(), Uri.parse(optString));
        }
        ac acVar = this.p;
        if (acVar != null) {
            acVar.a(z, aVar);
        }
    }

    public void a(com.sigmob.sdk.base.a aVar, String str, boolean z) {
        a(aVar, (String) null, str, z, true);
    }

    public void a(ac acVar) {
        this.p = acVar;
    }

    public void a(String str) {
        this.h = str;
    }

    public void a(List<com.sigmob.sdk.videoAd.f> list) {
        Preconditions.NoThrow.checkNotNull(list, "fractionalTrackers cannot be null");
        this.k.addAll(list);
        Collections.sort(this.k);
    }

    public boolean a() {
        return this.u;
    }

    public String b() {
        return this.h;
    }

    public void b(Context context, int i, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    public void b(Context context, BaseAdUnit baseAdUnit) {
        ae.a(PointCategory.LANDING_PAGE_CLOSE, (String) null, baseAdUnit);
    }

    public void b(BaseAdUnit baseAdUnit) {
        this.t = new WeakReference<>(baseAdUnit);
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.b;
    }

    public void c(Context context, int i, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    public void c(BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.base.network.g.a(baseAdUnit, a.w);
    }

    public void c(String str) {
        if (str != null) {
            this.e = str;
        }
    }

    public String d() {
        return this.e;
    }

    public void d(BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.base.network.g.a(baseAdUnit, "full_video_click");
    }

    public void d(String str) {
        if (str != null) {
            this.f = str;
        }
    }

    public String e() {
        return this.f;
    }

    public void e(BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.base.network.g.a(baseAdUnit, "click");
    }

    public void e(String str) {
        if (str != null) {
            this.g = str;
        }
    }

    public String f() {
        return this.g;
    }

    public void f(String str) {
        boolean a = p.a(this.n);
        BaseAdUnit l = l();
        if (l == null) {
            return;
        }
        if (a) {
            try {
                aj.a(com.sigmob.sdk.b.e(), "正在下载", 1).show();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        String landing_page = l.getLanding_page();
        if (!TextUtils.isEmpty(str)) {
            landing_page = str;
        }
        String macroProcess = l.getMacroCommon().macroProcess(landing_page);
        if (l.getsubInteractionType() != 1) {
            this.n = str;
            p.a(str, l());
            return;
        }
        JsonRequest jsonRequest = new JsonRequest(macroProcess, new JsonRequest.Listener() { // from class: com.sigmob.sdk.base.common.i.3
            public void onErrorResponse(VolleyError volleyError) {
                if (i.this.l() == null) {
                    return;
                }
                ae.a("download_start", "0", i.this.l(), new ae.a() { // from class: com.sigmob.sdk.base.common.i.3.5
                    @Override // com.sigmob.sdk.base.common.ae.a
                    public void a(Object obj) {
                        if (obj instanceof PointEntitySigmob) {
                            ((PointEntitySigmob) obj).setFinal_url(i.this.n);
                        }
                    }
                });
                ae.a("download_start", 0, volleyError.getMessage(), i.this.l(), new ae.a() { // from class: com.sigmob.sdk.base.common.i.3.6
                    @Override // com.sigmob.sdk.base.common.ae.a
                    public void a(Object obj) {
                        if (obj instanceof PointEntitySigmobError) {
                            ((PointEntitySigmobError) obj).setFinal_url(i.this.n);
                        }
                    }
                });
                SigmobLog.e(volleyError.getMessage());
            }

            public void onSuccess(JSONObject jSONObject) {
                try {
                    if (i.this.l() == null) {
                        return;
                    }
                    SigmobLog.d("GDTConvertRequest response " + jSONObject);
                    if (jSONObject.getInt("ret") == 0) {
                        String string = jSONObject.getJSONObject("data").getString("dstlink");
                        i.this.l().getMacroCommon().addMarcoKey(SigMacroCommon._CLICKID_, jSONObject.getJSONObject("data").getString("clickid"));
                        i.this.n = string;
                        p.a(string, i.this.l());
                    } else {
                        ae.a("download_start", "0", i.this.l(), new ae.a() { // from class: com.sigmob.sdk.base.common.i.3.1
                            @Override // com.sigmob.sdk.base.common.ae.a
                            public void a(Object obj) {
                                if (obj instanceof PointEntitySigmob) {
                                    ((PointEntitySigmob) obj).setFinal_url(i.this.n);
                                }
                            }
                        });
                        ae.a("download_start", 0, jSONObject.toString(), i.this.l(), new ae.a() { // from class: com.sigmob.sdk.base.common.i.3.2
                            @Override // com.sigmob.sdk.base.common.ae.a
                            public void a(Object obj) {
                                if (obj instanceof PointEntitySigmobError) {
                                    ((PointEntitySigmobError) obj).setFinal_url(i.this.n);
                                }
                            }
                        });
                    }
                } catch (Throwable th) {
                    SigmobLog.e(th.getMessage());
                    ae.a("download_start", "0", i.this.l(), new ae.a() { // from class: com.sigmob.sdk.base.common.i.3.3
                        @Override // com.sigmob.sdk.base.common.ae.a
                        public void a(Object obj) {
                            if (obj instanceof PointEntitySigmob) {
                                ((PointEntitySigmob) obj).setFinal_url(i.this.n);
                            }
                        }
                    });
                    ae.a("download_start", 0, th.getMessage(), i.this.l(), new ae.a() { // from class: com.sigmob.sdk.base.common.i.3.4
                        @Override // com.sigmob.sdk.base.common.ae.a
                        public void a(Object obj) {
                            if (obj instanceof PointEntitySigmobError) {
                                ((PointEntitySigmobError) obj).setFinal_url(i.this.n);
                            }
                        }
                    });
                }
            }
        }, 1);
        SigmobRequestQueue sigRequestQueue = Networking.getSigRequestQueue();
        if (sigRequestQueue == null) {
            ae.a("download_start", "0", l(), new ae.a() { // from class: com.sigmob.sdk.base.common.i.4
                @Override // com.sigmob.sdk.base.common.ae.a
                public void a(Object obj) {
                    if (obj instanceof PointEntitySigmob) {
                        ((PointEntitySigmob) obj).setFinal_url(i.this.n);
                    }
                }
            });
            ae.a("download_start", 0, "request queue is null", l(), new ae.a() { // from class: com.sigmob.sdk.base.common.i.5
                @Override // com.sigmob.sdk.base.common.ae.a
                public void a(Object obj) {
                    if (obj instanceof PointEntitySigmobError) {
                        ((PointEntitySigmobError) obj).setFinal_url(i.this.n);
                    }
                }
            });
        } else {
            jsonRequest.setTag("GDTRequestConvert");
            sigRequestQueue.add(jsonRequest);
        }
    }

    public Map<String, String> g() {
        return this.a;
    }

    public boolean h() {
        return this.m;
    }

    public boolean i() {
        WeakReference<Activity> weakReference = this.r;
        Activity activity = weakReference != null ? weakReference.get() : null;
        if (l() == null) {
            return false;
        }
        if (activity != null && l().getadPrivacy() != null && this.q == null) {
            com.sigmob.sdk.base.views.q qVar = new com.sigmob.sdk.base.views.q(activity, l());
            this.q = qVar;
            qVar.a(new q.b() { // from class: com.sigmob.sdk.base.common.i.1
                @Override // com.sigmob.sdk.base.views.q.b
                public void a() {
                    if (i.this.q != null) {
                        i.this.q.dismiss();
                        i.this.q.c();
                        i.this.q = null;
                        i.this.l = false;
                    }
                    if (i.this.l() == null) {
                        return;
                    }
                    ag sessionManager = i.this.l().getSessionManager();
                    if (sessionManager != null) {
                        sessionManager.a(a.g, 0);
                    }
                    if (i.this.s != null) {
                        i.this.s.a();
                    }
                }

                @Override // com.sigmob.sdk.base.views.q.b
                public void a(String str, String str2) {
                    if (i.this.l() == null) {
                        return;
                    }
                    if (i.this.s != null) {
                        i.this.s.a(str, str2);
                    }
                    i iVar = i.this;
                    iVar.a(iVar.l().getClickCommon().clickUIType, str, str2, true);
                }

                @Override // com.sigmob.sdk.base.views.q.b
                public void b() {
                    if (i.this.l() == null) {
                        return;
                    }
                    ag sessionManager = i.this.l().getSessionManager();
                    if (sessionManager != null) {
                        sessionManager.a(a.f, 0);
                    }
                    if (i.this.s == null || !i.this.l) {
                        return;
                    }
                    i.this.s.b();
                }
            });
        }
        com.sigmob.sdk.base.views.q qVar2 = this.q;
        if (qVar2 == null || !qVar2.a() || this.l) {
            return false;
        }
        if (activity != null) {
            boolean isFinishing = activity.isFinishing();
            boolean isDestroyed = activity.isDestroyed();
            if (!isFinishing && !isDestroyed) {
                this.q.show();
                this.l = true;
                return true;
            }
        }
        this.l = false;
        this.q.dismiss();
        this.q.c();
        this.q = null;
        return true;
    }

    public boolean j() {
        if (l() == null || !l().isDownloadDialog()) {
            return false;
        }
        return i();
    }

    public void k() {
        this.s = null;
        this.p = null;
        com.sigmob.sdk.base.views.q qVar = this.q;
        if (qVar != null) {
            qVar.dismiss();
            this.q.c();
            this.q = null;
            this.l = false;
        }
    }
}
