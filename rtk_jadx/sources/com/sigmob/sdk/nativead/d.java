package com.sigmob.sdk.nativead;

import android.os.Bundle;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.volley.toolbox.DownloadItem;
import com.czhj.volley.toolbox.FileDownloadRequest;
import com.czhj.volley.toolbox.FileDownloader;
import com.sigmob.sdk.base.common.AdActivity;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.videoAd.BaseAdActivity;
import java.io.File;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d extends com.sigmob.sdk.base.common.x {

    /* renamed from: c, reason: collision with root package name */
    private NativeAdBroadcastReceiver f609c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a extends o.b, o.c {
        void c();

        void d();

        void e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(o.b bVar) {
        super(bVar);
    }

    private static boolean a(MaterialMeta materialMeta) {
        return true;
    }

    @Override // com.sigmob.sdk.base.common.x
    protected void a(o.b bVar) {
        ThreadPoolFactory.getFixIOExecutor().submit(new Runnable() { // from class: com.sigmob.sdk.nativead.d.1
            @Override // java.lang.Runnable
            public void run() {
                File adPrivacyTemplateFile = ((com.sigmob.sdk.base.common.x) d.this).b.getAdPrivacyTemplateFile();
                if (adPrivacyTemplateFile == null || adPrivacyTemplateFile.exists()) {
                    return;
                }
                DownloadItem downloadItem = new DownloadItem();
                downloadItem.url = ((com.sigmob.sdk.base.common.x) d.this).b.getadPrivacy().privacy_template_url;
                downloadItem.filePath = adPrivacyTemplateFile.getAbsolutePath();
                downloadItem.type = DownloadItem.FileType.OTHER;
                FileDownloader a2 = com.sigmob.sdk.base.common.r.a();
                if (a2 != null) {
                    a2.add(downloadItem, new FileDownloadRequest.FileDownloadListener() { // from class: com.sigmob.sdk.nativead.d.1.1
                        public void downloadProgress(DownloadItem downloadItem2, long j, long j2) {
                        }

                        public void onCancel(DownloadItem downloadItem2) {
                        }

                        public void onErrorResponse(DownloadItem downloadItem2) {
                        }

                        public void onSuccess(DownloadItem downloadItem2) {
                        }
                    });
                }
            }
        });
    }

    @Override // com.sigmob.sdk.base.common.x
    public void a(BaseAdUnit baseAdUnit, Bundle bundle) {
        super.a(baseAdUnit, bundle);
        if (this.f609c == null && (this.a instanceof a)) {
            NativeAdBroadcastReceiver nativeAdBroadcastReceiver = new NativeAdBroadcastReceiver((a) this.a, baseAdUnit.getUuid());
            this.f609c = nativeAdBroadcastReceiver;
            nativeAdBroadcastReceiver.a(nativeAdBroadcastReceiver);
        }
        BaseAdActivity.a(com.sigmob.sdk.b.e(), AdActivity.class, baseAdUnit.getUuid(), bundle, BaseAdActivity.e);
    }

    @Override // com.sigmob.sdk.base.common.x
    public void a(Map<String, Object> map, BaseAdUnit baseAdUnit) {
        super.a(map, baseAdUnit);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sigmob.sdk.base.common.x
    public boolean a(BaseAdUnit baseAdUnit) {
        if (baseAdUnit.getMaterial() != null) {
            return a(baseAdUnit.getMaterial());
        }
        return false;
    }

    @Override // com.sigmob.sdk.base.common.x
    public void b(BaseAdUnit baseAdUnit) {
        NativeAdBroadcastReceiver nativeAdBroadcastReceiver = this.f609c;
        if (nativeAdBroadcastReceiver != null) {
            nativeAdBroadcastReceiver.b(nativeAdBroadcastReceiver);
            this.f609c = null;
        }
        super.b(baseAdUnit);
    }
}
