package com.tencent.smtt.sdk;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownLoadListenerAdapter.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b implements com.tencent.smtt.export.external.interfaces.DownloadListener {
    private DownloadListener a;
    private WebView b;

    public b(WebView webView, DownloadListener downloadListener, boolean z) {
        this.a = downloadListener;
        this.b = webView;
    }

    @Override // com.tencent.smtt.export.external.interfaces.DownloadListener
    public void onDownloadStart(String str, String str2, byte[] bArr, String str3, String str4, String str5, long j, String str6, String str7) {
        DownloadListener downloadListener = this.a;
        if (downloadListener == null) {
            if (QbSdk.canOpenMimeFileType(this.b.getContext(), str5)) {
                Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
                intent.setFlags(268435456);
                intent.putExtra("key_reader_sdk_url", str);
                intent.putExtra("key_reader_sdk_type", 1);
                intent.setData(Uri.parse(str));
                this.b.getContext().startActivity(intent);
                return;
            }
            ApplicationInfo applicationInfo = this.b.getContext().getApplicationInfo();
            if (applicationInfo == null || !"com.tencent.mm".equals(applicationInfo.packageName)) {
                com.tencent.smtt.sdk.a.c.a(this.b.getContext(), str, null, null);
                return;
            }
            return;
        }
        downloadListener.onDownloadStart(str, str3, str4, str5, j);
    }

    @Override // com.tencent.smtt.export.external.interfaces.DownloadListener
    public void onDownloadVideo(String str, long j, int i) {
    }

    @Override // com.tencent.smtt.export.external.interfaces.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        onDownloadStart(str, null, null, str2, str3, str4, j, null, null);
    }
}
