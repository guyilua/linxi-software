package com.sigmob.sdk.videocache;

import android.content.Context;
import android.os.Environment;
import com.czhj.sdk.logger.SigmobLog;
import java.io.File;

/* loaded from: /tmp/rtk_apk/classes3.dex */
final class w {
    private static final String a = "video-cache";

    w() {
    }

    public static File a(Context context) {
        return new File(a(context, true), a);
    }

    private static File a(Context context, boolean z) {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            str = "";
        }
        File b = (z && "mounted".equals(str)) ? b(context) : null;
        if (b == null) {
            b = context.getCacheDir();
        }
        if (b != null) {
            return b;
        }
        String str2 = "/data/data/" + context.getPackageName() + "/cache/";
        SigmobLog.w("Can't define system cache directory! '" + str2 + "%s' will be used.");
        return new File(str2);
    }

    private static File b(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "SigmobAndroid"), "data"), context.getPackageName()), "cache");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        SigmobLog.w("Unable to create external cache directory");
        return null;
    }
}
