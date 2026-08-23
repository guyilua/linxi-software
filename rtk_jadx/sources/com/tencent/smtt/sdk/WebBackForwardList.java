package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class WebBackForwardList {
    private IX5WebBackForwardList a = null;
    private android.webkit.WebBackForwardList b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WebBackForwardList a(IX5WebBackForwardList iX5WebBackForwardList) {
        if (iX5WebBackForwardList == null) {
            return null;
        }
        WebBackForwardList webBackForwardList = new WebBackForwardList();
        webBackForwardList.a = iX5WebBackForwardList;
        return webBackForwardList;
    }

    public int getCurrentIndex() {
        IX5WebBackForwardList iX5WebBackForwardList = this.a;
        if (iX5WebBackForwardList != null) {
            return iX5WebBackForwardList.getCurrentIndex();
        }
        return this.b.getCurrentIndex();
    }

    public WebHistoryItem getCurrentItem() {
        IX5WebBackForwardList iX5WebBackForwardList = this.a;
        if (iX5WebBackForwardList != null) {
            return WebHistoryItem.a(iX5WebBackForwardList.getCurrentItem());
        }
        return WebHistoryItem.a(this.b.getCurrentItem());
    }

    public WebHistoryItem getItemAtIndex(int i) {
        IX5WebBackForwardList iX5WebBackForwardList = this.a;
        if (iX5WebBackForwardList != null) {
            return WebHistoryItem.a(iX5WebBackForwardList.getItemAtIndex(i));
        }
        return WebHistoryItem.a(this.b.getItemAtIndex(i));
    }

    public int getSize() {
        IX5WebBackForwardList iX5WebBackForwardList = this.a;
        if (iX5WebBackForwardList != null) {
            return iX5WebBackForwardList.getSize();
        }
        return this.b.getSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WebBackForwardList a(android.webkit.WebBackForwardList webBackForwardList) {
        if (webBackForwardList == null) {
            return null;
        }
        WebBackForwardList webBackForwardList2 = new WebBackForwardList();
        webBackForwardList2.b = webBackForwardList;
        return webBackForwardList2;
    }
}
