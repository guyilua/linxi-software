package com.sigmob.sdk.base;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.models.Config;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.SigmobRequestQueue;
import com.czhj.sdk.common.track.TrackManager;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.VolleyError;
import com.czhj.wire.Wire;
import com.sigmob.sdk.base.models.config.SigmobAndroid;
import com.sigmob.sdk.base.models.config.SigmobCommon;
import com.sigmob.sdk.base.models.config.SigmobCommonEndpointsConfig;
import com.sigmob.sdk.base.models.config.SigmobDialogSetting;
import com.sigmob.sdk.base.models.config.SigmobNativeConfig;
import com.sigmob.sdk.base.models.config.SigmobRvConfig;
import com.sigmob.sdk.base.models.config.SigmobSdkConfig;
import com.sigmob.sdk.base.models.config.SigmobSdkConfigResponse;
import com.sigmob.sdk.base.models.config.SigmobSplashConfig;
import com.sigmob.sdk.base.network.f;
import com.sigmob.windad.WindAdOptions;
import com.sigmob.windad.WindAds;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class l {
    private static final String a = "sdkConfigVer";
    private static l b = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f408c = false;
    private static String l = null;
    private static boolean m = false;
    private a k;
    private final String f = k.k;
    private long h = 0;
    private SigmobSdkConfig i = null;
    private SigmobSdkConfig j = null;
    private final Handler d = new Handler(Looper.getMainLooper());
    private final Runnable e = new Runnable() { // from class: com.sigmob.sdk.base.l.1
        @Override // java.lang.Runnable
        public void run() {
            l.this.ae();
        }
    };
    private boolean g = true;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a(boolean z);
    }

    private l() {
        ad();
    }

    public static synchronized l a() {
        l lVar;
        synchronized (l.class) {
            if (b == null) {
                b = new l();
            }
            lVar = b;
        }
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SigmobSdkConfig sigmobSdkConfig) {
        ObjectOutputStream objectOutputStream;
        if (sigmobSdkConfig != null) {
            ObjectOutputStream objectOutputStream2 = null;
            File file = new File(com.sigmob.sdk.base.utils.e.a() + "/config");
            if (file.exists()) {
                file.delete();
            }
            file.getParentFile().mkdirs();
            try {
                try {
                    try {
                        objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
                    } catch (IOException e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    sigmobSdkConfig.encode(objectOutputStream);
                    com.sigmob.sdk.base.utils.g.a().edit().putString(a, k.k).apply();
                    objectOutputStream.close();
                } catch (IOException e2) {
                    e = e2;
                    objectOutputStream2 = objectOutputStream;
                    SigmobLog.e(e.getMessage());
                    if (objectOutputStream2 != null) {
                        objectOutputStream2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    objectOutputStream2 = objectOutputStream;
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (IOException e3) {
                            SigmobLog.e(e3.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                SigmobLog.e(e4.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SigmobSdkConfig sigmobSdkConfig, boolean z) {
        SigmobCommon sigmobCommon;
        if (sigmobSdkConfig == null || (sigmobCommon = sigmobSdkConfig.sigmobCommon_config) == null) {
            return;
        }
        this.j = sigmobSdkConfig;
        this.h = ((Integer) Wire.get(sigmobCommon.configRefresh, 1800)).intValue() * 1000;
        SigmobLog.d("config: " + sigmobSdkConfig.toString());
        a aVar = this.k;
        if (aVar != null) {
            aVar.a(z);
        }
        Config.sharedInstance().setEnable_okhttp3(V());
        Config.sharedInstance().setNetworkTimeout(ai());
        Config.sharedInstance().update(f408c, Y(), U(), Q(), n(), G(), F(), af());
        TrackManager.getInstance().setRetryInterval(E());
        TrackManager.getInstance().setRetryExpiredTime(D());
    }

    private void ad() {
        if (this.i == null) {
            SigmobSdkConfig.Builder builder = new SigmobSdkConfig.Builder();
            SigmobCommon.Builder builder2 = new SigmobCommon.Builder();
            SigmobAndroid.Builder builder3 = new SigmobAndroid.Builder();
            SigmobCommonEndpointsConfig.Builder builder4 = new SigmobCommonEndpointsConfig.Builder();
            builder4.native_ad(p());
            builder2.endpoints(builder4.build());
            SigmobRvConfig.Builder builder5 = new SigmobRvConfig.Builder();
            builder5.cacheTop(4);
            builder2.rv_config(builder5.build());
            builder2.configRefresh(1000);
            Boolean bool = Boolean.TRUE;
            builder2.disable_up_location(bool);
            Boolean bool2 = Boolean.FALSE;
            builder2.is_gdpr_region(bool2);
            builder2.enable_debug_level(bool2);
            builder3.disable_boot_mark(bool);
            builder3.disableUpAppInfo(bool);
            builder3.oaid_api_is_disable(bool);
            builder3.enable_permission(bool2);
            builder3.enable_report_crash(bool2);
            builder.common_config(builder2.build());
            builder.android_config(builder3.build());
            this.i = builder.build();
        }
        SigmobLog.d("Default config: " + this.i.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae() {
        if (com.sigmob.sdk.b.e() == null) {
            return;
        }
        if (ClientMetadata.getInstance().isNetworkConnected(c()) && f.a().i()) {
            ag();
        } else {
            SigmobLog.d("Can't load an ad because there is no network connectivity.");
            ak();
        }
    }

    private boolean af() {
        SigmobCommon l2 = l();
        if (l2 != null) {
            return ((Boolean) Wire.get(l2.log_enc, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    private void ag() {
        SigmobRequestQueue sigRequestQueue = Networking.getSigRequestQueue();
        com.sigmob.sdk.base.network.f fVar = new com.sigmob.sdk.base.network.f(c(), new f.a() { // from class: com.sigmob.sdk.base.l.2
            @Override // com.sigmob.sdk.base.network.f.a
            public void a(SigmobSdkConfigResponse sigmobSdkConfigResponse) {
                boolean unused = l.m = false;
                SigmobLog.d(sigmobSdkConfigResponse.toString());
                final SigmobSdkConfig sigmobSdkConfig = sigmobSdkConfigResponse.config;
                if (sigmobSdkConfig != null) {
                    WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.base.l.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            l.this.a(sigmobSdkConfig, true);
                        }
                    });
                    l.this.a(sigmobSdkConfig);
                } else {
                    SigmobLog.e(sigmobSdkConfigResponse.error_message);
                }
                l.this.ak();
            }

            public void onErrorResponse(VolleyError volleyError) {
                String unused = l.l = l.this.ah();
                if (l.m) {
                    l.this.ak();
                } else {
                    boolean unused2 = l.m = true;
                    l.this.d.post(l.this.e);
                }
                SigmobLog.e(volleyError.toString());
            }
        });
        if (sigRequestQueue == null) {
            SigmobLog.e("queue is null");
            ak();
        } else {
            sigRequestQueue.add(fVar);
            SigmobLog.i("update sdk config");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ah() {
        SigmobCommon l2 = l();
        if (l2 == null || l2.endpoints == null) {
            return "";
        }
        return (String) Wire.get(l2.endpoints.config, BaseConstants.SCHEME_HTTPS + "://" + k.O);
    }

    private int ai() {
        SigmobCommon l2 = l();
        if (l2 != null) {
            return ((Integer) Wire.get(l2.network_timeout, 0)).intValue();
        }
        return 0;
    }

    private void aj() {
        this.d.removeCallbacks(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak() {
        aj();
        if (this.g) {
            this.d.postDelayed(this.e, Math.max(30000L, this.h));
        }
    }

    private SigmobSplashConfig al() {
        if (l() != null) {
            return l().splash_config;
        }
        return null;
    }

    private SigmobNativeConfig am() {
        if (l() != null) {
            return l().native_config;
        }
        return null;
    }

    public static String b() {
        return "appId=" + WindAds.sharedAds().getAppId() + "&sdkVersion=4.19.8";
    }

    public static String c() {
        String str;
        if (!TextUtils.isEmpty(l)) {
            if (l.indexOf(63) == -1) {
                return l + "?" + b();
            }
            return l + "&" + b();
        }
        WindAdOptions options = WindAds.sharedAds().getOptions();
        if (options != null && options.getExtData() != null && (str = options.getExtData().get(k.d)) != null && !TextUtils.isEmpty(str)) {
            if (str.indexOf(63) == -1) {
                return str + "?" + b();
            }
            return str + "&" + b();
        }
        String str2 = BaseConstants.SCHEME_HTTPS + "://" + k.g;
        if (TextUtils.isEmpty(str2)) {
            return BaseConstants.SCHEME_HTTPS + "://" + k.g + "?" + b();
        }
        if (str2.indexOf(63) == -1) {
            return str2 + "?" + b();
        }
        return str2 + "&" + b();
    }

    public static String d() {
        return BaseConstants.SCHEME_HTTPS + "://" + k.T + "?" + b();
    }

    public static boolean j() {
        return f408c;
    }

    public int A() {
        if (!z() || l().anti_fraud_log.motion_config == null) {
            return 0;
        }
        return ((Integer) Wire.get(l().anti_fraud_log.motion_config.interval, 0)).intValue();
    }

    public int B() {
        if (!z() || l().anti_fraud_log.motion_config == null) {
            return 0;
        }
        return ((Integer) Wire.get(l().anti_fraud_log.motion_config.count, 0)).intValue();
    }

    public int C() {
        if (!z() || l().anti_fraud_log.motion_config == null) {
            return 0;
        }
        return l().anti_fraud_log.motion_config.queue_max.intValue() + (-50) < l().anti_fraud_log.motion_config.count.intValue() * 2 ? (((Integer) Wire.get(l().anti_fraud_log.motion_config.count, 0)).intValue() * 2) + 50 : ((Integer) Wire.get(l().anti_fraud_log.motion_config.queue_max, 0)).intValue();
    }

    public long D() {
        long intValue = l() != null ? ((Integer) Wire.get(l().tracking_expiration_time, 86400)).intValue() : TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
        if (intValue < 180) {
            return 180L;
        }
        return intValue;
    }

    public int E() {
        int intValue = l() != null ? ((Integer) Wire.get(l().tracking_retry_interval, 180)).intValue() : 180;
        if (intValue < 10) {
            return 10;
        }
        return intValue;
    }

    public int F() {
        Integer num = SigmobCommon.DEFAULT_MAX_SEND_LOG_RECORDS;
        int intValue = num.intValue();
        if (l() != null) {
            intValue = ((Integer) Wire.get(l().max_send_log_records, num)).intValue();
        }
        return intValue < 10 ? num.intValue() : intValue;
    }

    public int G() {
        int intValue;
        if (l() == null || (intValue = ((Integer) Wire.get(l().send_log_interval, 3)).intValue()) < 3) {
            return 3;
        }
        return intValue;
    }

    public List<Integer> H() {
        if (l() != null) {
            return l().dclog_blacklist;
        }
        return null;
    }

    public boolean I() {
        if (l() != null) {
            return ((Boolean) Wire.get(l().enable_debug_level, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public long J() {
        if (l() == null) {
            return 0L;
        }
        long intValue = ((Integer) Wire.get(l().load_interval, 0)).intValue();
        if (intValue < 1) {
            return 0L;
        }
        return intValue * 1000;
    }

    public String K() {
        SigmobCommonEndpointsConfig sigmobCommonEndpointsConfig;
        StringBuilder sb;
        String str;
        SigmobCommon l2 = l();
        if (l2 != null && (sigmobCommonEndpointsConfig = l2.endpoints) != null) {
            String str2 = (String) Wire.get(sigmobCommonEndpointsConfig.native_ad, "");
            if (!TextUtils.isEmpty(str2)) {
                if (str2.indexOf(63) == -1) {
                    sb = new StringBuilder();
                    sb.append(str2);
                    str = "?";
                } else {
                    sb = new StringBuilder();
                    sb.append(str2);
                    str = "&";
                }
                sb.append(str);
                sb.append(b());
                return sb.toString();
            }
        }
        return "";
    }

    public boolean L() {
        if (l() != null) {
            return ((Boolean) Wire.get(l().disable_up_location, Boolean.FALSE)).booleanValue();
        }
        return true;
    }

    public boolean M() {
        if (m() != null) {
            return ((Boolean) Wire.get(m().disableUpAppInfo, Boolean.FALSE)).booleanValue();
        }
        return true;
    }

    public int N() {
        SigmobAndroid m2 = m();
        if (m2 != null) {
            return ((Integer) Wire.get(m2.report_log, 0)).intValue();
        }
        return 0;
    }

    public List<String> O() {
        SigmobAndroid m2 = m();
        return m2 != null ? m2.open_pkg_list : Collections.emptyList();
    }

    public boolean P() {
        SigmobAndroid m2 = m();
        return m2 != null && ((Integer) Wire.get(m2.up_wifi_list_interval, 0)).intValue() >= 60;
    }

    public int Q() {
        if (m() != null) {
            return ((Integer) Wire.get(m().disable_up_oaid, 0)).intValue();
        }
        return 0;
    }

    public boolean R() {
        if (m() != null) {
            return ((Boolean) Wire.get(m().enable_permission, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public int S() {
        if (m() != null) {
            return ((Integer) Wire.get(m().apk_expired_time, 0)).intValue();
        }
        return 0;
    }

    public boolean T() {
        if (m() != null) {
            return ((Boolean) Wire.get(m().enable_report_crash, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public boolean U() {
        if (m() != null) {
            return ((Boolean) Wire.get(m().oaid_api_is_disable, Boolean.FALSE)).booleanValue();
        }
        return true;
    }

    public boolean V() {
        return false;
    }

    public boolean W() {
        if (m() != null) {
            return ((Boolean) Wire.get(m().disable_install_monitor, Boolean.FALSE)).booleanValue();
        }
        return true;
    }

    public int X() {
        if (m() != null) {
            return ((Integer) Wire.get(m().enable_app_list, 0)).intValue();
        }
        return 0;
    }

    public boolean Y() {
        if (m() != null) {
            return ((Boolean) Wire.get(m().disable_boot_mark, Boolean.FALSE)).booleanValue();
        }
        return true;
    }

    public boolean Z() {
        SigmobAndroid m2 = m();
        if (m2 != null) {
            return ((Boolean) Wire.get(m2.use_web_source_cache, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public l a(a aVar) {
        this.k = aVar;
        return b;
    }

    public boolean a(String str) {
        if (!z() || l().anti_fraud_log.events == null) {
            return false;
        }
        return l().anti_fraud_log.events.contains(str);
    }

    public boolean aa() {
        SigmobCommon l2 = l();
        if (l2 != null) {
            return ((Boolean) Wire.get(l2.enable_extra_dclog, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public int ab() {
        SigmobAndroid m2 = m();
        if (m2 != null) {
            return ((Integer) Wire.get(m2.web_source_cache_expiration_time, 0)).intValue();
        }
        return 0;
    }

    public void e() {
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2 = null;
        String string = com.sigmob.sdk.base.utils.g.a().getString(a, null);
        File file = new File(com.sigmob.sdk.base.utils.e.a() + "/config");
        if (k.k.equals(string)) {
            try {
                if (file.exists()) {
                    try {
                        objectInputStream = new ObjectInputStream(new FileInputStream(file));
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        a((SigmobSdkConfig) SigmobSdkConfig.ADAPTER.decode(objectInputStream), false);
                        objectInputStream.close();
                    } catch (Throwable th2) {
                        th = th2;
                        objectInputStream2 = objectInputStream;
                        try {
                            a(this.i, false);
                            SigmobLog.e(th.getMessage());
                            if (objectInputStream2 != null) {
                                objectInputStream2.close();
                                return;
                            }
                            return;
                        } catch (Throwable th3) {
                            if (objectInputStream2 != null) {
                                try {
                                    objectInputStream2.close();
                                } catch (Throwable th4) {
                                    SigmobLog.e(th4.getMessage());
                                }
                            }
                            throw th3;
                        }
                    }
                    return;
                }
            } catch (Throwable th5) {
                SigmobLog.e(th5.getMessage());
                return;
            }
        }
        a(this.i, false);
    }

    public void f() {
        aj();
        this.d.post(this.e);
    }

    public boolean g() {
        SigmobCommon l2 = l();
        if (l2 != null) {
            return ((Boolean) Wire.get(l2.feedback_debug, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public boolean h() {
        SigmobAndroid m2 = m();
        if (m2 != null) {
            return ((Boolean) Wire.get(m2.lock_play, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public boolean i() {
        SigmobAndroid m2 = m();
        if (m2 != null) {
            return ((Boolean) Wire.get(m2.screen_keep, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public SigmobSdkConfig k() {
        SigmobSdkConfig sigmobSdkConfig = this.j;
        return sigmobSdkConfig == null ? this.i : sigmobSdkConfig;
    }

    public SigmobCommon l() {
        if (k() == null) {
            return null;
        }
        return k().sigmobCommon_config;
    }

    public SigmobAndroid m() {
        if (k() == null) {
            return null;
        }
        return k().sigmobAndroid_config;
    }

    public String n() {
        StringBuilder sb;
        String str;
        String str2 = l().endpoints.log;
        if (TextUtils.isEmpty(str2)) {
            str2 = BaseConstants.SCHEME_HTTPS + "://" + k.P;
        }
        if (str2.indexOf(63) == -1) {
            sb = new StringBuilder();
            sb.append(str2);
            str = "?";
        } else {
            sb = new StringBuilder();
            sb.append(str2);
            str = "&";
        }
        sb.append(str);
        sb.append(b());
        return sb.toString();
    }

    public String o() {
        StringBuilder sb;
        String str;
        String str2 = (String) Wire.get(l().endpoints.feedback, BaseConstants.SCHEME_HTTPS + "://" + k.Q);
        if (TextUtils.isEmpty(str2)) {
            return str2;
        }
        if (str2.indexOf(63) == -1) {
            sb = new StringBuilder();
            sb.append(str2);
            str = "?";
        } else {
            sb = new StringBuilder();
            sb.append(str2);
            str = "&";
        }
        sb.append(str);
        sb.append(b());
        return sb.toString();
    }

    public String p() {
        StringBuilder sb;
        String str;
        SigmobCommonEndpointsConfig sigmobCommonEndpointsConfig;
        SigmobCommon l2 = l();
        String str2 = (l2 == null || (sigmobCommonEndpointsConfig = l2.endpoints) == null) ? "" : sigmobCommonEndpointsConfig.ads;
        if (TextUtils.isEmpty(str2)) {
            str2 = BaseConstants.SCHEME_HTTPS + "://" + k.R;
        }
        if (str2.indexOf(63) == -1) {
            sb = new StringBuilder();
            sb.append(str2);
            str = "?";
        } else {
            sb = new StringBuilder();
            sb.append(str2);
            str = "&";
        }
        sb.append(str);
        sb.append(b());
        return sb.toString();
    }

    public String q() {
        StringBuilder sb;
        String str;
        String str2 = l().endpoints.hb_ads;
        if (TextUtils.isEmpty(str2)) {
            str2 = BaseConstants.SCHEME_HTTPS + "://" + k.S;
        }
        if (str2.indexOf(63) == -1) {
            sb = new StringBuilder();
            sb.append(str2);
            str = "?";
        } else {
            sb = new StringBuilder();
            sb.append(str2);
            str = "&";
        }
        sb.append(str);
        sb.append(b());
        return sb.toString();
    }

    public SigmobRvConfig r() {
        if (l() != null) {
            return l().rv_config;
        }
        return null;
    }

    public int s() {
        if (r() != null) {
            return ((Integer) Wire.get(r().cacheTop, 5)).intValue();
        }
        return 5;
    }

    public long t() {
        if (r() == null) {
            return 45000L;
        }
        int intValue = ((Integer) Wire.get(r().ad_load_timeout, 45)).intValue();
        if (intValue < 10) {
            intValue = 10;
        }
        return intValue * 1000;
    }

    public SigmobDialogSetting u() {
        if (r() != null) {
            return r().close_dialog_setting;
        }
        return null;
    }

    public int v() {
        if (al() == null) {
            return 50;
        }
        return ((Integer) Wire.get(al().cacheTop, 50)).intValue();
    }

    public long w() {
        int intValue = al() != null ? ((Integer) Wire.get(al().material_expired_time, 2)).intValue() : 2;
        return intValue < 0 ? intValue : intValue * 24 * 60 * 60 * 1000;
    }

    public int x() {
        if (am() != null) {
            return ((Integer) Wire.get(am().cacheTop, 50)).intValue();
        }
        return 50;
    }

    public long y() {
        SigmobNativeConfig am = am();
        if (am == null) {
            return 45000L;
        }
        int intValue = ((Integer) Wire.get(am.ad_load_timeout, 45)).intValue();
        if (intValue < 10) {
            intValue = 10;
        }
        return intValue * 1000;
    }

    public boolean z() {
        return (l() == null || l().anti_fraud_log == null || l().anti_fraud_log.events == null) ? false : true;
    }
}
