package com.sigmob.sdk.base.common;

import com.czhj.sdk.common.network.Networking;
import com.czhj.volley.toolbox.FileDownloader;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class r {
    private static FileDownloader a;
    private static FileDownloader b;

    public static FileDownloader a() {
        if (a == null) {
            synchronized (r.class) {
                if (a == null && Networking.getDownloadRequestQueue() != null) {
                    a = new FileDownloader(Networking.getDownloadRequestQueue(), 3);
                }
            }
        }
        return a;
    }
}
