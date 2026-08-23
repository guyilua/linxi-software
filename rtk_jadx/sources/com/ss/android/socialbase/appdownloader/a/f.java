package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f extends a {
    public f(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        Intent intent = new Intent("android.settings.SECURITY_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(WXVideoFileObject.FILE_SIZE_LIMIT);
        intent.addFlags(8388608);
        return intent;
    }
}
