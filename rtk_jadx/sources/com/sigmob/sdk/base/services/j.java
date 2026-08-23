package com.sigmob.sdk.base.services;

import com.czhj.sdk.common.ClientMetadata;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class j {
    public static final String a = "LocationService";
    public static final String b = "AppInstallService";

    /* renamed from: c, reason: collision with root package name */
    public static final String f433c = "WifiScanService";
    public static final String d = "DownloadService";
    private static a e;
    private static a f;
    private static a g;
    private static a h;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        boolean e();

        k f();

        void g();

        Error h();
    }

    public static a a() {
        return f;
    }

    public static synchronized a a(String str) {
        synchronized (j.class) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case -967662845:
                    if (str.equals(f433c)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 353926395:
                    if (str.equals(b)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 854806816:
                    if (str.equals(a)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1382229229:
                    if (str.equals(d)) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                a aVar = e;
                if (aVar != null) {
                    return aVar;
                }
                e eVar = new e();
                e = eVar;
                return eVar;
            }
            if (c2 == 1) {
                a aVar2 = f;
                if (aVar2 != null) {
                    return aVar2;
                }
                b bVar = new b();
                f = bVar;
                return bVar;
            }
            if (c2 == 2) {
                a aVar3 = g;
                if (aVar3 != null) {
                    return aVar3;
                }
                l lVar = new l();
                g = lVar;
                return lVar;
            }
            if (c2 != 3) {
                return null;
            }
            a aVar4 = h;
            if (aVar4 != null) {
                return aVar4;
            }
            d dVar = new d();
            h = dVar;
            return dVar;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0037. Please report as an issue. */
    public static void a(String str, boolean z) {
        a aVar;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -967662845:
                if (str.equals(f433c)) {
                    c2 = 0;
                    break;
                }
                break;
            case 353926395:
                if (str.equals(b)) {
                    c2 = 1;
                    break;
                }
                break;
            case 854806816:
                if (str.equals(a)) {
                    c2 = 2;
                    break;
                }
                break;
            case 1382229229:
                if (str.equals(d)) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                if (!z) {
                    aVar = g;
                    if (aVar == null) {
                        return;
                    }
                    aVar.g();
                    return;
                }
                a(str).e();
                return;
            case 1:
                if (!z) {
                    aVar = f;
                    if (aVar == null) {
                        return;
                    }
                    aVar.g();
                    return;
                }
                a(str).e();
                return;
            case 2:
                if (z) {
                    a(str).e();
                } else {
                    a aVar2 = e;
                    if (aVar2 != null) {
                        aVar2.g();
                    }
                }
                ClientMetadata.getInstance().setEnableLocation(z);
                return;
            case 3:
                if (!z) {
                    aVar = h;
                    if (aVar == null) {
                        return;
                    }
                    aVar.g();
                    return;
                }
                a(str).e();
                return;
            default:
                return;
        }
    }

    public static a b() {
        return g;
    }

    public static a c() {
        return h;
    }

    public static a d() {
        return e;
    }
}
