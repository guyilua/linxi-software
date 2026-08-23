package com.tencent.smtt.sdk;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MimeTypeMap {
    private static MimeTypeMap a;

    private MimeTypeMap() {
    }

    public static String getFileExtensionFromUrl(String str) {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            return a2.c().h(str);
        }
        return android.webkit.MimeTypeMap.getFileExtensionFromUrl(str);
    }

    public static synchronized MimeTypeMap getSingleton() {
        MimeTypeMap mimeTypeMap;
        synchronized (MimeTypeMap.class) {
            if (a == null) {
                a = new MimeTypeMap();
            }
            mimeTypeMap = a;
        }
        return mimeTypeMap;
    }

    public String getExtensionFromMimeType(String str) {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            return a2.c().l(str);
        }
        return android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
    }

    public String getMimeTypeFromExtension(String str) {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            return a2.c().j(str);
        }
        return android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
    }

    public boolean hasExtension(String str) {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            return a2.c().k(str);
        }
        return android.webkit.MimeTypeMap.getSingleton().hasExtension(str);
    }

    public boolean hasMimeType(String str) {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            return a2.c().i(str);
        }
        return android.webkit.MimeTypeMap.getSingleton().hasMimeType(str);
    }
}
