package com.sigmob.sdk.base.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.czhj.sdk.common.utils.AppPackageUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.wire.Wire;
import com.sigmob.sdk.base.common.MiMarketManager;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.AndroidMarket;
import com.sigmob.sdk.base.models.rtb.WXProgramRes;
import com.sigmob.sdk.videoAd.BaseAdActivity;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public enum am {
    IGNORE_ABOUT_SCHEME(0 == true ? 1 : 0) { // from class: com.sigmob.sdk.base.common.am.1
        @Override // com.sigmob.sdk.base.common.am
        public String a(BaseAdUnit baseAdUnit) {
            return null;
        }

        @Override // com.sigmob.sdk.base.common.am
        protected void a(Context context, Uri uri, an anVar, BaseAdUnit baseAdUnit) {
            SigmobLog.d("Link to about page ignored.");
        }

        @Override // com.sigmob.sdk.base.common.am
        public boolean a(Uri uri, int i) {
            return "about".equalsIgnoreCase(uri.getScheme());
        }
    },
    MINI_PROGRAM(0 == true ? 1 : 0) { // from class: com.sigmob.sdk.base.common.am.2
        @Override // com.sigmob.sdk.base.common.am
        public String a(BaseAdUnit baseAdUnit) {
            if (baseAdUnit == null || baseAdUnit.getWXProgramRes() == null) {
                return null;
            }
            return baseAdUnit.getWXProgramRes().wx_app_path;
        }

        @Override // com.sigmob.sdk.base.common.am
        protected void a(Context context, Uri uri, an anVar, BaseAdUnit baseAdUnit) {
            if (baseAdUnit.getInteractionType() != 7) {
                throw new Exception("performAction interaction_type is not right with " + baseAdUnit.getInteractionType());
            }
            WXProgramRes wXProgramRes = baseAdUnit.getWXProgramRes();
            if (wXProgramRes != null) {
                u.a(com.sigmob.sdk.b.e(), wXProgramRes.wx_app_id, wXProgramRes.wx_app_username, wXProgramRes.wx_app_path, wXProgramRes.wx_business_type.intValue(), wXProgramRes.wx_ext_msg);
            }
        }

        @Override // com.sigmob.sdk.base.common.am
        public boolean a(Uri uri, int i) {
            String scheme = uri.getScheme();
            return ("HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme) || i != 7) ? false : true;
        }
    },
    FOLLOW_DEEP_LINK(1 == true ? 1 : 0) { // from class: com.sigmob.sdk.base.common.am.3
        @Override // com.sigmob.sdk.base.common.am
        public String a(BaseAdUnit baseAdUnit) {
            if (baseAdUnit == null) {
                return null;
            }
            return baseAdUnit.getDeeplinkUrl();
        }

        @Override // com.sigmob.sdk.base.common.am
        protected void a(Context context, Uri uri, an anVar, BaseAdUnit baseAdUnit) {
            try {
                h.d(baseAdUnit);
                baseAdUnit.setDeeplinkUri(uri);
                if (baseAdUnit.getInteractionType() == 8) {
                    u.a(context, uri, com.sigmob.sdk.b.a());
                } else {
                    u.a(context, uri);
                }
            } catch (Throwable th) {
                h.d((BaseAdUnit) null);
                baseAdUnit.setDeeplinkUri(null);
                throw th;
            }
        }

        @Override // com.sigmob.sdk.base.common.am
        public boolean a(Uri uri, int i) {
            String scheme = uri.getScheme();
            return i == 8 ? "HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme) || "HAP".equalsIgnoreCase(scheme) : ("HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme)) ? false : true;
        }
    },
    FOLLOW_PACKAGE_NAME(1 == true ? 1 : 0) { // from class: com.sigmob.sdk.base.common.am.4
        @Override // com.sigmob.sdk.base.common.am
        public String a(BaseAdUnit baseAdUnit) {
            if (baseAdUnit == null) {
                return null;
            }
            return TextUtils.isEmpty(baseAdUnit.getApkPackageName()) ? baseAdUnit.getProductId() : baseAdUnit.getApkPackageName();
        }

        @Override // com.sigmob.sdk.base.common.am
        protected void a(Context context, Uri uri, an anVar, final BaseAdUnit baseAdUnit) {
            PackageManager packageManager;
            String productId;
            if (baseAdUnit.getsubInteractionType() == 2 || !TextUtils.isEmpty(baseAdUnit.getApkPackageName())) {
                if (TextUtils.isEmpty(baseAdUnit.getApkPackageName())) {
                    packageManager = context.getPackageManager();
                    productId = baseAdUnit.getProductId();
                } else {
                    packageManager = context.getPackageManager();
                    productId = baseAdUnit.getApkPackageName();
                }
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(productId);
                if (launchIntentForPackage != null) {
                    h.c(baseAdUnit);
                    new Handler().postDelayed(new Runnable() { // from class: com.sigmob.sdk.base.common.am.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.f() != null) {
                                ae.a("open_pkg", "0", baseAdUnit);
                                h.c((BaseAdUnit) null);
                            }
                        }
                    }, 3000L);
                    u.b(context, launchIntentForPackage);
                    return;
                }
            }
            throw new Exception("can't launch application for packageName" + baseAdUnit.getProductId());
        }

        @Override // com.sigmob.sdk.base.common.am
        public boolean a(Uri uri, int i) {
            return i == 2;
        }
    },
    MARKET_SCHEME(0 == true ? 1 : 0) { // from class: com.sigmob.sdk.base.common.am.5
        @Override // com.sigmob.sdk.base.common.am
        public String a(BaseAdUnit baseAdUnit) {
            if (baseAdUnit == null || baseAdUnit.getAndroidMarket() == null) {
                return null;
            }
            return baseAdUnit.getAndroidMarket().market_url;
        }

        @Override // com.sigmob.sdk.base.common.am
        protected void a(Context context, Uri uri, an anVar, BaseAdUnit baseAdUnit) {
            AndroidMarket androidMarket = baseAdUnit.getAndroidMarket();
            if (androidMarket != null) {
                int intValue = ((Integer) Wire.get(androidMarket.type, 0)).intValue();
                Intent intent = new Intent("android.intent.action.VIEW");
                if (!TextUtils.isEmpty(androidMarket.appstore_package_name)) {
                    try {
                        if (AppPackageUtil.getPackageManager(context).getPackageInfo(androidMarket.appstore_package_name, 0) != null) {
                            intent.setPackage(androidMarket.appstore_package_name);
                        }
                    } catch (Throwable th) {
                        SigmobLog.e("get store package error " + th.getMessage());
                    }
                }
                intent.setData(Uri.parse(androidMarket.market_url));
                if (intValue != 1) {
                    u.b(context, intent);
                    return;
                }
                new MiMarketManager.DirectMailStatusReceiver().a(com.sigmob.sdk.b.e(), baseAdUnit);
                Activity h = com.sigmob.sdk.b.h();
                if (h == null) {
                    h = com.sigmob.sdk.b.c();
                }
                if (h != null) {
                    h.startActivity(intent);
                } else {
                    context.startActivity(intent);
                }
            }
        }

        @Override // com.sigmob.sdk.base.common.am
        public boolean a(Uri uri, int i) {
            String scheme = uri.getScheme();
            return ("HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme)) ? false : true;
        }
    },
    DOWNLOAD_APK(1 == true ? 1 : 0) { // from class: com.sigmob.sdk.base.common.am.6
        @Override // com.sigmob.sdk.base.common.am
        public String a(BaseAdUnit baseAdUnit) {
            if (baseAdUnit == null) {
                return null;
            }
            return baseAdUnit.getLanding_page();
        }

        @Override // com.sigmob.sdk.base.common.am
        protected void a(Context context, Uri uri, an anVar, BaseAdUnit baseAdUnit) {
            if (baseAdUnit.getInteractionType() == 2 || baseAdUnit.getInteractionType() == 3) {
                return;
            }
            throw new Exception("Could not handle download Scheme url: " + uri);
        }

        @Override // com.sigmob.sdk.base.common.am
        public boolean a(Uri uri, int i) {
            String scheme = uri.getScheme();
            return "HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme);
        }
    },
    OPEN_WITH_BROWSER(1 == true ? 1 : 0) { // from class: com.sigmob.sdk.base.common.am.7
        @Override // com.sigmob.sdk.base.common.am
        public String a(BaseAdUnit baseAdUnit) {
            if (baseAdUnit == null) {
                return null;
            }
            return baseAdUnit.getLanding_page();
        }

        @Override // com.sigmob.sdk.base.common.am
        protected void a(Context context, Uri uri, an anVar, BaseAdUnit baseAdUnit) {
            if (baseAdUnit.getInteractionType() != 8) {
                if (anVar.b()) {
                    u.b(context, new Intent("android.intent.action.VIEW", uri));
                    return;
                } else {
                    h.a(baseAdUnit);
                    BaseAdActivity.a(context, (Class<? extends BaseAdActivity>) AdActivity.class, baseAdUnit.getUuid());
                    return;
                }
            }
            try {
                h.d(baseAdUnit);
                baseAdUnit.setDeeplinkUri(uri);
                u.a(context, uri, com.sigmob.sdk.b.a());
            } catch (Throwable th) {
                h.d((BaseAdUnit) null);
                baseAdUnit.setDeeplinkUri(null);
                throw th;
            }
        }

        @Override // com.sigmob.sdk.base.common.am
        public boolean a(Uri uri, int i) {
            String scheme = uri.getScheme();
            return "HTTP".equalsIgnoreCase(scheme) || "HTTPS".equalsIgnoreCase(scheme);
        }
    },
    NOOP(0 == true ? 1 : 0) { // from class: com.sigmob.sdk.base.common.am.8
        @Override // com.sigmob.sdk.base.common.am
        public String a(BaseAdUnit baseAdUnit) {
            return null;
        }

        @Override // com.sigmob.sdk.base.common.am
        protected void a(Context context, Uri uri, an anVar, BaseAdUnit baseAdUnit) {
        }

        @Override // com.sigmob.sdk.base.common.am
        public boolean a(Uri uri, int i) {
            return false;
        }
    };

    private final boolean i;

    am(boolean z) {
        this.i = z;
    }

    public abstract String a(BaseAdUnit baseAdUnit);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(Context context, Uri uri, an anVar, BaseAdUnit baseAdUnit);

    public void a(an anVar, Context context, Uri uri, boolean z, BaseAdUnit baseAdUnit) {
        SigmobLog.d("Ad event URL: " + uri);
        if (this.i && !z) {
            throw new Exception("Attempted to handle action without user interaction.");
        }
        a(context, uri, anVar, baseAdUnit);
    }

    public abstract boolean a(Uri uri, int i);
}
