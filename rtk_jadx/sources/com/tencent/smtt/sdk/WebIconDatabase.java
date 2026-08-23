package com.tencent.smtt.sdk;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.webkit.WebIconDatabase;
import com.tencent.smtt.export.external.interfaces.IconListener;

@Deprecated
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class WebIconDatabase {
    private static WebIconDatabase a;

    @Deprecated
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a(String str, Bitmap bitmap);
    }

    private WebIconDatabase() {
    }

    private static synchronized WebIconDatabase a() {
        WebIconDatabase webIconDatabase;
        synchronized (WebIconDatabase.class) {
            if (a == null) {
                a = new WebIconDatabase();
            }
            webIconDatabase = a;
        }
        return webIconDatabase;
    }

    public static WebIconDatabase getInstance() {
        return a();
    }

    public void bulkRequestIconForPageUrl(ContentResolver contentResolver, String str, a aVar) {
    }

    public void close() {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().m();
        } else {
            android.webkit.WebIconDatabase.getInstance().close();
        }
    }

    public void open(String str) {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().b(str);
        } else {
            android.webkit.WebIconDatabase.getInstance().open(str);
        }
    }

    public void releaseIconForPageUrl(String str) {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().d(str);
        } else {
            android.webkit.WebIconDatabase.getInstance().releaseIconForPageUrl(str);
        }
    }

    public void removeAllIcons() {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().l();
        } else {
            android.webkit.WebIconDatabase.getInstance().removeAllIcons();
        }
    }

    public void requestIconForPageUrl(String str, final a aVar) {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().a(str, new IconListener() { // from class: com.tencent.smtt.sdk.WebIconDatabase.1
                @Override // com.tencent.smtt.export.external.interfaces.IconListener
                public void onReceivedIcon(String str2, Bitmap bitmap) {
                    aVar.a(str2, bitmap);
                }
            });
        } else {
            android.webkit.WebIconDatabase.getInstance().requestIconForPageUrl(str, new WebIconDatabase.IconListener() { // from class: com.tencent.smtt.sdk.WebIconDatabase.2
                @Override // android.webkit.WebIconDatabase.IconListener
                public void onReceivedIcon(String str2, Bitmap bitmap) {
                    aVar.a(str2, bitmap);
                }
            });
        }
    }

    public void retainIconForPageUrl(String str) {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().c(str);
        } else {
            android.webkit.WebIconDatabase.getInstance().retainIconForPageUrl(str);
        }
    }
}
