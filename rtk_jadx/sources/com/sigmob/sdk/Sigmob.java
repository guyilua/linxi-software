package com.sigmob.sdk;

import android.text.TextUtils;
import android.util.Base64;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.ThreadPool.RepeatingHandlerRunnable;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.exceptions.CrashHandler;
import com.czhj.sdk.common.models.BidRequest;
import com.czhj.sdk.common.mta.PointEntityCommon;
import com.czhj.sdk.common.mta.PointEntitySuper;
import com.czhj.sdk.common.network.BuriedPointRequest;
import com.czhj.sdk.common.network.JsonRequest;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.track.AdTracker;
import com.czhj.sdk.common.track.TrackManager;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.VolleyError;
import com.czhj.volley.VolleyLog;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.f;
import com.sigmob.sdk.base.k;
import com.sigmob.sdk.base.l;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointEntitySigmobCrash;
import com.sigmob.sdk.base.services.j;
import com.sigmob.sdk.base.utils.e;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdOptions;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.WindCustomController;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.zip.DeflaterOutputStream;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Sigmob {
    private static Sigmob a;
    private static boolean b;
    public static SigMacroCommon macroCommon;

    /* renamed from: c, reason: collision with root package name */
    private WindAdError f338c;
    private RepeatingHandlerRunnable d = null;

    private Sigmob() {
    }

    private String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        try {
            deflaterOutputStream.write(bArr);
            deflaterOutputStream.flush();
            deflaterOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final File file, String str) {
        PointEntitySigmobCrash WindCrash = PointEntitySigmobCrash.WindCrash(str);
        if (file != null) {
            try {
                WindCrash.setCrashTime(Long.parseLong(file.getName().replace(".log", "")));
            } catch (Throwable th) {
                SigmobLog.e("set crash time fail", th);
            }
        }
        WindCrash.sendServe(new BuriedPointRequest.RequestListener() { // from class: com.sigmob.sdk.Sigmob.7
            public void onErrorResponse(VolleyError volleyError) {
            }

            public void onSuccess() {
                File file2 = file;
                if (file2 != null) {
                    file2.delete();
                }
            }
        });
    }

    public static BidRequest createRequest() {
        BidRequest.Builder builder = new BidRequest.Builder();
        try {
            builder = com.sigmob.sdk.base.network.a.a((LoadAdRequest) null);
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        h.b();
        h.l();
        h.j();
        h.i();
        h.h();
        h.k();
        h.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e() {
        try {
            j.a(j.a, f.a().i() && !l.a().L());
        } catch (Throwable th) {
            SigmobLog.e("updateLocationMonitor fail", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f() {
        try {
            j.a(j.b, true);
        } catch (Throwable th) {
            SigmobLog.e("initAppInstallService fail", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g() {
        try {
            j.a(j.f433c, f.a().i() && l.a().P());
        } catch (Throwable th) {
            SigmobLog.e("updateWifiScanService fail", th);
        }
    }

    public static synchronized Sigmob getInstance() {
        Sigmob sigmob;
        synchronized (Sigmob.class) {
            if (a == null) {
                synchronized (Sigmob.class) {
                    a = new Sigmob();
                }
            }
            sigmob = a;
        }
        return sigmob;
    }

    private static void h() {
        try {
            j.a(j.d, true);
        } catch (Throwable th) {
            SigmobLog.e("initDownloadService fail", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Networking.getSigRequestQueue().add(new JsonRequest(l.d(), new JsonRequest.Listener() { // from class: com.sigmob.sdk.Sigmob.6
            public void onErrorResponse(VolleyError volleyError) {
                Sigmob.this.k();
                f.a().a((Boolean) null);
            }

            public void onSuccess(JSONObject jSONObject) {
                if (jSONObject != null) {
                    try {
                        f.a().a(Boolean.valueOf(jSONObject.getBoolean("is_request_in_eea_or_unknown")));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                Sigmob.this.k();
            }
        }, 0));
    }

    private void j() {
        try {
            File[] k = e.k();
            if (k != null) {
                for (File file : k) {
                    String readFileToString = FileUtil.readFileToString(file);
                    if (!TextUtils.isEmpty(readFileToString)) {
                        a(file, readFileToString);
                    }
                }
            }
        } catch (Throwable th) {
            SigmobLog.e("send crash Log fail", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        h();
        b.d();
        l.a().a(new l.a() { // from class: com.sigmob.sdk.Sigmob.8
            @Override // com.sigmob.sdk.base.l.a
            public void a(boolean z) {
                Sigmob.e();
                Sigmob.g();
                if (z) {
                    com.sigmob.sdk.base.services.b.b();
                    Sigmob.f();
                    com.sigmob.sdk.base.services.b.d();
                }
            }
        }).f();
        if (l.a().T()) {
            String[] split = WindAds.class.getName().split("\\.");
            if (split.length <= 2) {
                return;
            }
            final String str = split[0] + "." + split[1] + ".";
            CrashHandler.getInstance().add(new CrashHandler.CrashHandlerListener() { // from class: com.sigmob.sdk.Sigmob.9
                public void reportCrash(String str2) {
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    if (str2.contains(str) || str2.contains("com.czhj.")) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("crashTime", System.currentTimeMillis());
                            jSONObject.put("appId", WindAds.sharedAds().getAppId());
                            jSONObject.put("sdkVersion", WindAds.sharedAds().getAppId());
                            jSONObject.put("commonVersion", k.k);
                            jSONObject.put("wmsession_id", PointEntitySuper.getSessionId());
                            jSONObject.put("crashLog", URLEncoder.encode(str2, "UTF-8"));
                            String jSONObject2 = jSONObject.toString();
                            SigmobLog.e("crashLog " + jSONObject2);
                            File j = e.j();
                            if (j != null) {
                                FileUtil.writeToBuffer(jSONObject2.getBytes(), j.getAbsolutePath());
                            }
                            Sigmob.this.a(j, jSONObject2);
                        } catch (Throwable th) {
                            SigmobLog.e("error ", th);
                        }
                    }
                }
            });
            j();
        }
        l();
    }

    private void l() {
        ImageManager.with(b.e()).clearCache();
    }

    public SigMacroCommon getMacroCommon() {
        if (macroCommon == null) {
            macroCommon = new SigMacroCommon();
        }
        return macroCommon;
    }

    public String getSDKToken() {
        b.a(true);
        String str = "2.01|" + a(createRequest().encode());
        ae.a("token_request", (String) null, (BaseAdUnit) null, (ae.a) null);
        SigmobLog.d("getSDKToken: " + str);
        return str;
    }

    public WindAdError getSigMobError() {
        return this.f338c;
    }

    public void init() {
        boolean z;
        final int i;
        final boolean z2;
        VolleyLog.DEBUG = k.f.booleanValue();
        WindAdOptions options = WindAds.sharedAds().getOptions();
        WindCustomController customController = WindAds.sharedAds().getOptions().getCustomController();
        final int X = l.a().X();
        final boolean M = l.a().M();
        boolean z3 = false;
        if (options == null || customController == null) {
            z = true;
            i = 0;
        } else {
            z = customController.isCanUseAppList();
            i = z ? 1 : 2;
        }
        if (X == 1) {
            z2 = true;
        } else if (X != 2) {
            if (z && !M) {
                z3 = true;
            }
            z2 = z3;
        } else {
            z2 = false;
        }
        final boolean d = com.sigmob.sdk.base.common.f.d();
        ae.a(PointCategory.INIT, new ae.a() { // from class: com.sigmob.sdk.Sigmob.1
            @Override // com.sigmob.sdk.base.common.ae.a
            public void a(Object obj) {
                if (obj instanceof PointEntityCommon) {
                    PointEntityCommon pointEntityCommon = (PointEntityCommon) obj;
                    HashMap hashMap = new HashMap();
                    hashMap.put("is_minor", f.a().d() ? "0" : "1");
                    hashMap.put("is_unpersonalized", f.a().e() ? "0" : "1");
                    hashMap.put("canUseAppList", String.valueOf(i));
                    hashMap.put("appListPermission", d ? "1" : "0");
                    hashMap.put("disableUpAppInfo", M ? "1" : "0");
                    hashMap.put("EnableAppList", String.valueOf(X));
                    hashMap.put("uploadAppList", z2 ? "1" : "0");
                    hashMap.put("common_version", String.valueOf(WindAds.sharedAds().getCommonVersion()));
                    pointEntityCommon.setOptions(hashMap);
                }
            }
        });
        if (l.a().R()) {
            ae.a(PointCategory.PERMISSION, PointCategory.INIT, (BaseAdUnit) null, new ae.a() { // from class: com.sigmob.sdk.Sigmob.2
                @Override // com.sigmob.sdk.base.common.ae.a
                public void a(Object obj) {
                    if (obj instanceof PointEntitySigmob) {
                        ((PointEntitySigmob) obj).setPermission(ClientMetadata.getInstance().getPermission(b.e()));
                    }
                }
            });
        }
        h.e();
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable() { // from class: com.sigmob.sdk.Sigmob.3
            @Override // java.lang.Runnable
            public void run() {
                ae.a(PointCategory.APP);
                Sigmob.this.f338c = com.sigmob.sdk.base.common.f.b();
                Sigmob.this.i();
            }
        });
        TrackManager.getInstance().setSigmobTrackListener(new TrackManager.Listener() { // from class: com.sigmob.sdk.Sigmob.4
            public void onErrorResponse(AdTracker adTracker, VolleyError volleyError) {
                ae.a(adTracker, adTracker.getUrl(), (BaseAdUnit) null, volleyError);
            }

            public void onSuccess(AdTracker adTracker, NetworkResponse networkResponse) {
                ae.a(adTracker, adTracker.getUrl(), (BaseAdUnit) null, networkResponse, (ae.a) null);
            }
        });
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable() { // from class: com.sigmob.sdk.Sigmob.5
            @Override // java.lang.Runnable
            public void run() {
                Sigmob.this.d();
            }
        });
        TrackManager.getInstance().startRetryTracking();
        b = true;
    }
}
