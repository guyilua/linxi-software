package com.sigmob.windad;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.Sigmob;
import com.sigmob.sdk.b;
import com.sigmob.sdk.base.f;
import com.sigmob.sdk.base.k;
import com.sigmob.windad.consent.ConsentStatus;
import com.sigmob.windad.consent.WindAdConsentInformation;
import java.util.logging.Level;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class WindAds {
    public static final String ADN_ID = "ADN_ID";
    public static final String ADX_ID = "_adx_id";
    public static final String AD_SCENE_DESC = "scene_desc";
    public static final String AD_SCENE_ID = "scene_id";
    public static final String AUCTION_PRICE = "AUCTION_PRICE";
    public static final String CNY = "CNY";
    public static final String CURRENCY = "CURRENCY";
    public static final String HIGHEST_LOSS_PRICE = "HIGHEST_LOSS_PRICE";
    public static final String LOSS_REASON = "LOSS_REASON";
    public static final String REWARD_TYPE = "reward_type";
    public static final String SERVER_ARRIVED = "server_arrived";
    public static final String TRANS_ID = "trans_id";
    public static final String USD = "USD";
    private static volatile WindAds a;
    private boolean d;
    private OnInitializationListener f;
    private int h;
    private int j;
    private int k;
    private volatile boolean b = false;
    private boolean g = true;
    private boolean i = true;

    /* renamed from: c, reason: collision with root package name */
    private WindAdOptions f694c = null;
    private Handler e = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.sigmob.windad.WindAds$1, reason: invalid class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ConsentStatus.values().length];
            a = iArr;
            try {
                iArr[ConsentStatus.ACCEPT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ConsentStatus.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ConsentStatus.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private WindAds() {
    }

    private void a(String str) {
        SigmobLog.e("startWithOptions " + str);
        OnInitializationListener onInitializationListener = this.f;
        if (onInitializationListener != null) {
            onInitializationListener.OnInitializationFail(str);
        }
    }

    private void b() {
        OnInitializationListener onInitializationListener = this.f;
        if (onInitializationListener != null) {
            onInitializationListener.OnInitializationSuccess();
        }
    }

    private void c() {
        if (this.h == 0) {
            try {
                this.h = f.a().g();
            } catch (Throwable unused) {
            }
            if (this.h == 0) {
                try {
                    int i = AnonymousClass1.a[WindAdConsentInformation.getInstance(b.e()).getConsentStatus().ordinal()];
                    int i2 = 1;
                    if (i != 1) {
                        i2 = 2;
                        if (i != 2) {
                        }
                    }
                    this.h = i2;
                } catch (Throwable unused2) {
                }
            }
        }
        f.a().c(this.h, false);
    }

    private void d() {
        try {
            if (this.j == 0) {
                this.j = f.a().c();
            } else {
                f.a().b(this.j, false);
            }
            if (this.k == 0) {
                this.k = f.a().b();
            } else {
                f.a().a(this.k, false);
            }
        } catch (Throwable unused) {
        }
    }

    private void e() {
        try {
            d();
            c();
            f.a().b(this.i, false);
            f.a().a(this.g, false);
        } catch (Throwable th) {
            SigmobLog.e("loadPrivacyInfo", th);
        }
    }

    public static String getUserId() {
        return ClientMetadata.getUserId();
    }

    public static String getVersion() {
        return k.k;
    }

    public static void requestPermission(Activity activity) {
        if (activity == null || Build.VERSION.SDK_INT < 23) {
            return;
        }
        boolean isPermissionGranted = ClientMetadata.isPermissionGranted(activity, "android.permission.READ_PHONE_STATE");
        boolean isPermissionGranted2 = ClientMetadata.isPermissionGranted(activity, "android.permission.ACCESS_FINE_LOCATION");
        if (isPermissionGranted && isPermissionGranted2) {
            return;
        }
        activity.requestPermissions(new String[]{"android.permission.READ_PHONE_STATE", "android.permission.ACCESS_FINE_LOCATION"}, 0);
    }

    public static void setOAIDCertPem(String str) {
        try {
            ClientMetadata.setOAIDCertPem(str);
        } catch (Throwable unused) {
            SigmobLog.e("not support OAID Module");
        }
    }

    public static void setUserId(String str) {
        ClientMetadata.setUserId(str);
    }

    public static WindAds sharedAds() {
        if (a == null) {
            synchronized (WindAds.class) {
                if (a == null) {
                    WindAds windAds = new WindAds();
                    windAds.setDebugEnable(true);
                    a = windAds;
                }
            }
        }
        return a;
    }

    protected int a() {
        return k.h;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void debugDeviceID() {
        /*
            r6 = this;
            r0 = 0
            com.czhj.sdk.common.ClientMetadata r1 = com.czhj.sdk.common.ClientMetadata.getInstance()     // Catch: java.lang.Throwable -> L58
            java.lang.String r1 = r1.getDeviceId()     // Catch: java.lang.Throwable -> L58
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L58
            r3 = 1
            if (r2 != 0) goto L1f
            java.lang.String r2 = "debug device Type: IMEI,  ID => %s"
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L58
            r4[r0] = r1     // Catch: java.lang.Throwable -> L58
            java.lang.String r1 = java.lang.String.format(r2, r4)     // Catch: java.lang.Throwable -> L58
            com.czhj.sdk.logger.SigmobLog.i(r1)     // Catch: java.lang.Throwable -> L58
            r1 = 1
            goto L20
        L1f:
            r1 = 0
        L20:
            com.czhj.sdk.common.ClientMetadata r2 = com.czhj.sdk.common.ClientMetadata.getInstance()     // Catch: java.lang.Throwable -> L59
            java.lang.String r2 = r2.getAdvertisingId()     // Catch: java.lang.Throwable -> L59
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L59
            if (r4 != 0) goto L3c
            java.lang.String r4 = "debug device Type: gaid, ID => %s"
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L59
            r5[r0] = r2     // Catch: java.lang.Throwable -> L59
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch: java.lang.Throwable -> L59
            com.czhj.sdk.logger.SigmobLog.i(r4)     // Catch: java.lang.Throwable -> L59
            r1 = 1
        L3c:
            com.czhj.sdk.common.ClientMetadata r4 = com.czhj.sdk.common.ClientMetadata.getInstance()     // Catch: java.lang.Throwable -> L59
            java.lang.String r4 = r4.getOAID()     // Catch: java.lang.Throwable -> L59
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L59
            if (r4 != 0) goto L59
            java.lang.String r4 = "debug device Type oaid, ID => %s"
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L59
            r5[r0] = r2     // Catch: java.lang.Throwable -> L59
            java.lang.String r2 = java.lang.String.format(r4, r5)     // Catch: java.lang.Throwable -> L59
            com.czhj.sdk.logger.SigmobLog.i(r2)     // Catch: java.lang.Throwable -> L59
            goto L5a
        L58:
            r1 = 0
        L59:
            r3 = r1
        L5a:
            if (r3 != 0) goto L67
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = "can't find any can be used debug valid Device Type"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            com.czhj.sdk.logger.SigmobLog.e(r0)
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.windad.WindAds.debugDeviceID():void");
    }

    public int getAgeRestrictedStatus() {
        return this.j;
    }

    public String getAppId() {
        WindAdOptions windAdOptions = this.f694c;
        if (windAdOptions != null) {
            return windAdOptions.getAppId();
        }
        return null;
    }

    public String getAppKey() {
        WindAdOptions windAdOptions = this.f694c;
        if (windAdOptions != null) {
            return windAdOptions.getAppKey();
        }
        return null;
    }

    public int getCommonVersion() {
        try {
            return Constants.getVersion();
        } catch (Throwable unused) {
            return 174;
        }
    }

    public Handler getHandler() {
        if (this.e == null) {
            this.e = new Handler(Looper.getMainLooper());
        }
        return this.e;
    }

    public WindAdOptions getOptions() {
        return this.f694c;
    }

    public String getSDKToken() {
        if (this.b) {
            return Sigmob.getInstance().getSDKToken();
        }
        return null;
    }

    public int getUserAge() {
        return this.k;
    }

    public int getUserGDPRConsentStatus() {
        return this.h;
    }

    public String getWindUid() {
        try {
            return ClientMetadata.getUid();
        } catch (Exception e) {
            e.printStackTrace();
            return "Please initialize the SDK properly first";
        }
    }

    public boolean isAdult() {
        return this.g;
    }

    public boolean isDebugEnable() {
        return this.d;
    }

    public boolean isInit() {
        return this.b;
    }

    public boolean isPersonalizedAdvertisingOn() {
        return this.i;
    }

    public void setAdult(boolean z) {
        this.g = z;
        SigmobLog.i("Windads -> setAdult " + z);
        if (this.b) {
            f.a().a(z, true);
        }
    }

    public void setDebugEnable(boolean z) {
        Level level;
        this.d = z;
        if (k.f.booleanValue()) {
            if (z) {
                level = Level.FINE;
            }
            level = Level.SEVERE;
        } else {
            if (z) {
                level = Level.INFO;
            }
            level = Level.SEVERE;
        }
        SigmobLog.setSdkHandlerLevel(level);
    }

    public void setIsAgeRestrictedUser(int i) {
        this.j = i;
        if (this.b) {
            f.a().b(i, true);
        }
    }

    public void setOAIDCertFileName(String str) {
        ClientMetadata.setOaidCertFileName(str);
    }

    public void setPersonalizedAdvertisingOn(boolean z) {
        this.i = z;
        SigmobLog.i("Windads -> setPersonalized " + z);
        if (this.b) {
            f.a().b(z, true);
        }
    }

    public void setUserAge(int i) {
        this.k = i;
        if (this.b) {
            f.a().a(i, true);
        }
    }

    public void setUserGDPRConsentStatus(int i) {
        this.h = i;
        if (this.b) {
            f.a().c(i, true);
        }
    }

    public boolean startWithOptions(Context context, WindAdOptions windAdOptions) {
        return startWithOptions(context, windAdOptions, null);
    }

    public synchronized boolean startWithOptions(Context context, WindAdOptions windAdOptions, OnInitializationListener onInitializationListener) {
        this.f = onInitializationListener;
        if (this.b) {
            SigmobLog.i("already init appId: " + windAdOptions.getAppId());
        } else {
            try {
                if (Build.VERSION.SDK_INT < 18) {
                    a("Wind SDK Only Support SigmobAndroid API 18+");
                    return false;
                }
                if (context == null) {
                    a("context is null ");
                    return false;
                }
                if (windAdOptions == null) {
                    a("WindAdOptions is null ");
                    return false;
                }
                if (TextUtils.isEmpty(windAdOptions.getAppId())) {
                    a("appId is empty ");
                    return false;
                }
                if (getCommonVersion() < 174) {
                    a("Your COMMON Lib version must be equal or higher than 174 ,current Version :[ " + getCommonVersion() + " ]");
                    return false;
                }
                this.f694c = windAdOptions;
                b.b(context.getApplicationContext());
                e();
                Sigmob.getInstance().init();
                this.b = true;
                SigmobLog.i("init appId: " + windAdOptions.getAppId());
            } catch (Throwable th) {
                a("init fail Exception " + th.getMessage());
                SigmobLog.e("startWithOptions fail", th);
                return false;
            }
        }
        b();
        return this.b;
    }
}
