package com.sigmob.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.media.AudioManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.AdLifecycleManager;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.AdActivity;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.common.u;
import com.sigmob.sdk.base.k;
import com.sigmob.sdk.base.l;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntityActive;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.network.g;
import com.sigmob.sdk.base.utils.e;
import com.sigmob.sdk.videoAd.BaseAdActivity;
import com.sigmob.windad.WindAdOptions;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.WindCustomController;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    private static WeakReference<Activity> a = null;
    private static Context b = null;

    /* renamed from: c, reason: collision with root package name */
    private static a f346c = null;
    private static String d = null;
    private static WeakReference<Activity> e = null;
    private static boolean f = false;
    private static boolean g = false;
    private static boolean h = false;
    private static DeviceContext i;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class a implements AdLifecycleManager.LifecycleListener {
        private String a;
        private long b;
        private String d;
        private int e;
        private boolean i;

        /* renamed from: c, reason: collision with root package name */
        private Map<String, String> f347c = new HashMap();
        private boolean f = true;
        private boolean g = false;
        private boolean h = false;
        private BroadcastReceiver j = new BroadcastReceiver() { // from class: com.sigmob.sdk.b.a.1
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:
            
                if (r3.equals(com.sigmob.sdk.base.k.L) == false) goto L4;
             */
            /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0039. Please report as an issue. */
            @Override // android.content.BroadcastReceiver
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onReceive(android.content.Context r3, android.content.Intent r4) {
                /*
                    r2 = this;
                    java.lang.String r3 = r4.getAction()
                    byte[] r3 = r3.getBytes()
                    r4 = 2
                    java.lang.String r3 = android.util.Base64.encodeToString(r3, r4)
                    r3.hashCode()
                    int r0 = r3.hashCode()
                    r1 = -1
                    switch(r0) {
                        case -252353173: goto L2e;
                        case 1349729289: goto L23;
                        case 1349784159: goto L1a;
                        default: goto L18;
                    }
                L18:
                    r4 = -1
                    goto L38
                L1a:
                    java.lang.String r0 = "YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlNDUkVFTl9PTg=="
                    boolean r3 = r3.equals(r0)
                    if (r3 != 0) goto L38
                    goto L18
                L23:
                    java.lang.String r4 = "YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlNDUkVFTl9PRkY="
                    boolean r3 = r3.equals(r4)
                    if (r3 != 0) goto L2c
                    goto L18
                L2c:
                    r4 = 1
                    goto L38
                L2e:
                    java.lang.String r4 = "YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlVTRVJfUFJFU0VOVA=="
                    boolean r3 = r3.equals(r4)
                    if (r3 != 0) goto L37
                    goto L18
                L37:
                    r4 = 0
                L38:
                    r3 = 0
                    switch(r4) {
                        case 0: goto L50;
                        case 1: goto L48;
                        case 2: goto L3d;
                        default: goto L3c;
                    }
                L3c:
                    goto L58
                L3d:
                    java.lang.String r4 = "screen on"
                    com.czhj.sdk.logger.SigmobLog.d(r4)
                    java.lang.String r4 = "screen_on"
                L44:
                    com.sigmob.sdk.base.common.ae.b(r4, r3, r3)
                    goto L58
                L48:
                    java.lang.String r4 = "screen off"
                    com.czhj.sdk.logger.SigmobLog.d(r4)
                    java.lang.String r4 = "locked"
                    goto L44
                L50:
                    java.lang.String r4 = "screen user present"
                    com.czhj.sdk.logger.SigmobLog.d(r4)
                    java.lang.String r4 = "unlock"
                    goto L44
                L58:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.b.a.AnonymousClass1.onReceive(android.content.Context, android.content.Intent):void");
            }
        };

        a() {
            AdLifecycleManager.getInstance().initialize(b.g());
            this.b = System.currentTimeMillis();
            this.a = UUID.randomUUID().toString();
            SigmobLog.i("session_start: " + this.b + ":" + this.a);
            PointEntityActive.ActiveTracking(PointCategory.SESSION_START, this.a, "0", String.valueOf(this.b));
            AdLifecycleManager.getInstance().addLifecycleListener(this);
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(new String(Base64.decode(k.L, 2)));
                intentFilter.addAction(new String(Base64.decode(k.M, 2)));
                intentFilter.addAction(new String(Base64.decode(k.N, 2)));
                u.a(b.b, this.j, intentFilter);
            } catch (Throwable th) {
                SigmobLog.e("register screen status receiver error" + th.getMessage());
            }
        }

        private void b() {
            BaseAdUnit f = h.f();
            if (f != null) {
                g.a(f, "open_pkg");
                ae.a("open_pkg", "1", f);
            }
            h.c((BaseAdUnit) null);
        }

        private void c() {
            final BaseAdUnit m = h.m();
            if (m != null) {
                h.d((BaseAdUnit) null);
                m.getClickCommon().isDeeplink = "1";
                g.a(m, "open_deeplink");
                ae.a("open_deeplink", (String) null, m, new ae.a() { // from class: com.sigmob.sdk.b.a.2
                    @Override // com.sigmob.sdk.base.common.ae.a
                    public void a(Object obj) {
                        if (obj instanceof PointEntitySigmob) {
                            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                            Uri deeplinkUri = m.getDeeplinkUri();
                            pointEntitySigmob.setFinal_url(deeplinkUri != null ? deeplinkUri.toString() : m.getDeeplinkUrl());
                            if (m.getInteractionType() == 8) {
                                pointEntitySigmob.getOptions().put("fast_pkg", b.a());
                            }
                        }
                    }
                });
            }
        }

        private void c(Activity activity) {
            Uri parse;
            BaseAdUnit m = h.m();
            if (m == null || activity == null) {
                return;
            }
            h.d((BaseAdUnit) null);
            m.getClickCommon().isDeeplink = "0";
            g.a(m, "open_deeplink_failed");
            ae.a("open_deeplink_failed", (String) null, m);
            String landing_page = m.getLanding_page();
            if (TextUtils.isEmpty(landing_page) || (parse = Uri.parse(landing_page)) == null) {
                return;
            }
            if (!m.isSkipSigmobBrowser()) {
                h.a(m);
                BaseAdActivity.a(activity, (Class<? extends BaseAdActivity>) AdActivity.class, m.getUuid());
            } else {
                try {
                    u.b(activity, new Intent("android.intent.action.VIEW", parse));
                } catch (Throwable th) {
                    SigmobLog.e("can't open load ", th);
                }
            }
        }

        public int a() {
            return this.e;
        }

        public void a(Activity activity) {
        }

        public void a(Activity activity, int i, int i2, Intent intent) {
        }

        public void b(Activity activity) {
        }

        public void onCreate(Activity activity) {
            String simpleName = activity.getClass().getSimpleName();
            this.d = simpleName;
            this.f347c.put(simpleName, simpleName);
            this.f = true;
            this.g = false;
        }

        public void onDestroy(Activity activity) {
            if (activity instanceof AdActivity) {
                this.i = false;
            }
            this.f347c.remove(activity.getClass().getSimpleName());
            if (this.f347c.size() == 0 && this.f) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = (currentTimeMillis - this.b) / 1000;
                SigmobLog.i("onActivityDestroyed session_end: " + currentTimeMillis + ":" + this.a + ":" + j);
                PointEntityActive.ActiveTracking(PointCategory.SESSION_END, this.a, String.valueOf(j), String.valueOf(currentTimeMillis));
                this.b = System.currentTimeMillis();
                this.f = false;
            }
            if (this.f347c.size() == 0) {
                this.h = true;
            }
        }

        public void onPause(Activity activity) {
        }

        public void onResume(Activity activity) {
            if (activity instanceof AdActivity) {
                this.i = true;
            } else if (!this.i) {
                WeakReference unused = b.e = new WeakReference(activity);
            }
            c(activity);
            this.g = !activity.getClass().getSimpleName().equals(this.d);
            this.d = activity.getClass().getSimpleName();
            if (this.g) {
                WeakReference unused2 = b.a = new WeakReference(activity);
            }
            if (!this.f || this.h) {
                this.h = false;
                this.a = UUID.randomUUID().toString();
                this.b = System.currentTimeMillis();
                this.f = true;
                SigmobLog.i("onActivityResumed session_start: " + this.b + ":" + this.a);
                PointEntityActive.ActiveTracking(PointCategory.SESSION_START, this.a, "0", String.valueOf(this.b));
            }
        }

        public void onStart(Activity activity) {
            this.e++;
        }

        public void onStop(Activity activity) {
            this.e--;
            Activity h = b.h();
            if (activity.getClass().getSimpleName().equals(this.d) || (h != null && activity.getClass().getSimpleName().equals(h.getClass().getSimpleName()))) {
                b();
                c();
                if (!this.g || this.f347c.size() == 1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = (currentTimeMillis - this.b) / 1000;
                    SigmobLog.i("onActivityStopped session_end: " + currentTimeMillis + ":" + this.a + ":" + j);
                    PointEntityActive.ActiveTracking(PointCategory.SESSION_END, this.a, String.valueOf(j), String.valueOf(currentTimeMillis));
                    this.b = System.currentTimeMillis();
                    this.f = false;
                }
            }
        }
    }

    public static String a() {
        return d;
    }

    public static void a(Activity activity) {
        if (activity != null) {
            a = new WeakReference<>(activity);
        }
    }

    public static void a(Context context) {
        try {
            if (TextUtils.isEmpty(d)) {
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("hap://app/")), 0);
                if (queryIntentActivities.isEmpty()) {
                    return;
                }
                d = queryIntentActivities.get(0).activityInfo.packageName;
            }
        } catch (NullPointerException unused) {
        }
    }

    public static void a(boolean z) {
        f = z;
    }

    public static DeviceContext b() {
        DeviceContext deviceContext = i;
        if (deviceContext != null || b == null) {
            return deviceContext;
        }
        DeviceContext deviceContext2 = new DeviceContext() { // from class: com.sigmob.sdk.b.1
            public String getAndroidId() {
                WindCustomController customController = WindAds.sharedAds().getOptions().getCustomController();
                if ((customController == null || customController.isCanUseAndroidId()) && b.f && WindAds.sharedAds().isPersonalizedAdvertisingOn()) {
                    return ClientMetadata.getInstance().getAndroidId();
                }
                if (customController == null || customController.isCanUseAndroidId()) {
                    return null;
                }
                return customController.getAndroidId();
            }

            public String getCarrier() {
                WindCustomController customController = WindAds.sharedAds().getOptions().getCustomController();
                if (customController == null || customController.isCanUsePhoneState()) {
                    return ClientMetadata.getInstance().getNetworkOperatorForUrl();
                }
                return null;
            }

            public String getCarrierName() {
                WindCustomController customController = WindAds.sharedAds().getOptions().getCustomController();
                if (customController == null || customController.isCanUsePhoneState()) {
                    return ClientMetadata.getInstance().getNetworkOperatorName();
                }
                return null;
            }

            public String getImei() {
                WindCustomController customController = WindAds.sharedAds().getOptions().getCustomController();
                if ((customController == null || customController.isCanUsePhoneState()) && b.f && WindAds.sharedAds().isPersonalizedAdvertisingOn()) {
                    return ClientMetadata.getInstance().getDeviceId();
                }
                if (customController == null || customController.isCanUsePhoneState()) {
                    return null;
                }
                return customController.getDevImei();
            }

            public String getImei1() {
                WindCustomController customController = WindAds.sharedAds().getOptions().getCustomController();
                if ((customController == null || customController.isCanUsePhoneState()) && b.f && WindAds.sharedAds().isPersonalizedAdvertisingOn()) {
                    return ClientMetadata.getInstance().getDeviceId(0);
                }
                if (customController == null || customController.isCanUsePhoneState()) {
                    return null;
                }
                return customController.getDevImei();
            }

            public String getImei2() {
                WindCustomController customController = WindAds.sharedAds().getOptions().getCustomController();
                if ((customController == null || customController.isCanUsePhoneState()) && b.f && WindAds.sharedAds().isPersonalizedAdvertisingOn()) {
                    return ClientMetadata.getInstance().getDeviceId(1);
                }
                if (customController == null || customController.isCanUsePhoneState()) {
                    return null;
                }
                return customController.getDevImei();
            }

            public Location getLocation() {
                WindCustomController customController = WindAds.sharedAds().getOptions().getCustomController();
                if (customController == null || customController.isCanUseLocation()) {
                    return ClientMetadata.getInstance().getLocation();
                }
                if (customController.isCanUseLocation()) {
                    return null;
                }
                return customController.getLocation();
            }

            public String getOaid() {
                WindCustomController customController = WindAds.sharedAds().getOptions().getCustomController();
                return (customController == null || customController.isCanUseOaid()) ? ClientMetadata.getInstance().getOAID() : customController.getDevOaid();
            }

            public boolean isCustomAndroidId() {
                WindCustomController customController = WindAds.sharedAds().getOptions().getCustomController();
                return customController == null || customController.isCanUseAndroidId();
            }

            public boolean isCustomOaId() {
                WindCustomController customController = WindAds.sharedAds().getOptions().getCustomController();
                return (customController == null || customController.isCanUseOaid()) ? false : true;
            }

            public boolean isCustomPhoneState() {
                WindCustomController customController = WindAds.sharedAds().getOptions().getCustomController();
                return customController == null || customController.isCanUsePhoneState();
            }
        };
        i = deviceContext2;
        return deviceContext2;
    }

    public static synchronized void b(Context context) {
        synchronized (b.class) {
            if (b == null) {
                Context applicationContext = context.getApplicationContext();
                b = applicationContext;
                a(applicationContext);
                e.a(b, k.o);
                l.a().e();
                c(b);
                com.sigmob.sdk.base.db.a.a(b);
                ClientMetadata.getInstance().initialize(b);
                k();
            }
        }
    }

    public static Activity c() {
        WeakReference<Activity> weakReference = e;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private static void c(Context context) {
        Networking.AddSigmobServerURL(l.c());
        Networking.AddSigmobServerURL(l.a().p());
        Networking.AddSigmobServerURL(l.a().q());
        Networking.AddSigmobServerURL(l.a().n());
        Networking.initializeV2(context);
        Networking.initializeSigRequestQueue(context);
    }

    public static void d() {
        if (f346c == null) {
            f346c = new a();
        }
    }

    public static Context e() {
        return b;
    }

    public static boolean f() {
        AudioManager audioManager;
        return (b == null || (audioManager = (AudioManager) e().getSystemService("audio")) == null || audioManager.getStreamVolume(3) != 0) ? false : true;
    }

    public static Application g() {
        Context context = b;
        if (context instanceof Application) {
            return (Application) context;
        }
        return null;
    }

    public static Activity h() {
        WeakReference<Activity> weakReference = a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private static void k() {
        WindCustomController customController;
        List<PackageInfo> installPackageInfoList;
        WindAdOptions options = WindAds.sharedAds().getOptions();
        if (options == null || options.getCustomController() == null || (customController = options.getCustomController()) == null || customController.isCanUseAppList() || (installPackageInfoList = customController.getInstallPackageInfoList()) == null) {
            return;
        }
        Iterator<PackageInfo> it = installPackageInfoList.iterator();
        while (it.hasNext()) {
            ae.a(it.next(), 2);
        }
    }
}
