package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class WebHistoryItem {
    private IX5WebHistoryItem a = null;
    private android.webkit.WebHistoryItem b = null;

    private WebHistoryItem() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WebHistoryItem a(IX5WebHistoryItem iX5WebHistoryItem) {
        if (iX5WebHistoryItem == null) {
            return null;
        }
        WebHistoryItem webHistoryItem = new WebHistoryItem();
        webHistoryItem.a = iX5WebHistoryItem;
        return webHistoryItem;
    }

    public Bitmap getFavicon() {
        IX5WebHistoryItem iX5WebHistoryItem = this.a;
        if (iX5WebHistoryItem != null) {
            return iX5WebHistoryItem.getFavicon();
        }
        return this.b.getFavicon();
    }

    public String getOriginalUrl() {
        IX5WebHistoryItem iX5WebHistoryItem = this.a;
        if (iX5WebHistoryItem != null) {
            return iX5WebHistoryItem.getOriginalUrl();
        }
        return this.b.getOriginalUrl();
    }

    public String getTitle() {
        IX5WebHistoryItem iX5WebHistoryItem = this.a;
        if (iX5WebHistoryItem != null) {
            return iX5WebHistoryItem.getTitle();
        }
        return this.b.getTitle();
    }

    public String getUrl() {
        IX5WebHistoryItem iX5WebHistoryItem = this.a;
        if (iX5WebHistoryItem != null) {
            return iX5WebHistoryItem.getUrl();
        }
        return this.b.getUrl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WebHistoryItem a(android.webkit.WebHistoryItem webHistoryItem) {
        if (webHistoryItem == null) {
            return null;
        }
        WebHistoryItem webHistoryItem2 = new WebHistoryItem();
        webHistoryItem2.b = webHistoryItem;
        return webHistoryItem2;
    }
}
