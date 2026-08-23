package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class g extends a {
    public g(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str) {
        super(context, aVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        Intent intent = new Intent(com.ss.android.socialbase.downloader.constants.e.f843c + ".filemanager.intent.action.BROWSER_FILE");
        intent.putExtra("CurrentDir", this.f799c);
        intent.putExtra("CurrentMode", 1);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(WXVideoFileObject.FILE_SIZE_LIMIT);
        return intent;
    }
}
