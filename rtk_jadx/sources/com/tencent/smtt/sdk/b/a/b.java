package com.tencent.smtt.sdk.b.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import com.tencent.smtt.sdk.TbsConfig;
import java.io.BufferedInputStream;
import java.util.Map;

/* compiled from: BrowsingActivityInfo.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    private Context a;
    private ResolveInfo b;

    /* renamed from: c, reason: collision with root package name */
    private Drawable f956c;
    private String d;
    private String e;
    private int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, ResolveInfo resolveInfo) {
        this.f = 0;
        this.a = context.getApplicationContext();
        this.b = resolveInfo;
        this.f956c = null;
        this.d = null;
        this.e = null;
    }

    public Drawable a(Map<String, Drawable> map) {
        Drawable a = a(this.a, c());
        if (a != null) {
            return a;
        }
        ResolveInfo resolveInfo = this.b;
        if (resolveInfo != null) {
            return resolveInfo.loadIcon(this.a.getPackageManager());
        }
        return this.f956c;
    }

    public ResolveInfo b() {
        return this.b;
    }

    public String c() {
        ResolveInfo resolveInfo = this.b;
        if (resolveInfo != null) {
            return resolveInfo.activityInfo.packageName;
        }
        String str = this.e;
        return str == null ? "" : str;
    }

    public String a() {
        ResolveInfo resolveInfo = this.b;
        if (resolveInfo != null) {
            return resolveInfo.loadLabel(this.a.getPackageManager()).toString();
        }
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, Drawable drawable, String str, String str2) {
        this.f = 0;
        this.a = context.getApplicationContext();
        this.b = null;
        this.f956c = drawable;
        this.d = str;
        this.e = str2;
    }

    public void a(ResolveInfo resolveInfo) {
        this.b = resolveInfo;
    }

    public static Drawable a(Context context, String str) {
        if (TbsConfig.APP_QB.equals(str)) {
            try {
                return d.a("application_icon");
            } catch (Throwable th) {
                Log.e("error", "getApkIcon Error:" + Log.getStackTraceString(th));
                return null;
            }
        }
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (applicationInfo == null) {
                return null;
            }
            Resources resourcesForApplication = packageManager.getResourcesForApplication(applicationInfo);
            TypedValue typedValue = new TypedValue();
            resourcesForApplication.getValue(applicationInfo.icon, typedValue, true);
            try {
                return Drawable.createFromResourceStream(resourcesForApplication, typedValue, new BufferedInputStream(resourcesForApplication.getAssets().openNonAssetFd(typedValue.assetCookie, typedValue.string.toString()).createInputStream()), null);
            } catch (Exception unused) {
                return null;
            }
        } catch (Exception e) {
            Log.e("sdk", "e = " + e);
            return null;
        }
    }
}
