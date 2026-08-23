package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;

@RequiresApi(api = 26)
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b extends a {
    public b(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + this.a.getPackageName()));
        intent.addFlags(WXVideoFileObject.FILE_SIZE_LIMIT);
        intent.addFlags(8388608);
        intent.addFlags(268435456);
        return intent;
    }
}
