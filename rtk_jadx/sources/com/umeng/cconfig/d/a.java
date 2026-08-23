package com.umeng.cconfig.d;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.cconfig.UMRemoteConfig;
import com.umeng.cconfig.a.b;
import com.umeng.cconfig.b.d;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class a implements Runnable {
    private Context a;

    public a(Context context) {
        this.a = context;
    }

    private boolean a() {
        boolean a;
        try {
            d e = b.a(this.a).e();
            if (!"0".equals(e.f1077c)) {
                return false;
            }
            String str = e.a;
            if (TextUtils.isEmpty(str) || !(a = b.a(this.a).a(str))) {
                return false;
            }
            b.a(this.a).b(str);
            return a;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            UMRemoteConfig.getInstance().handlerMessage(3, Boolean.valueOf(a()), null);
        } catch (Exception unused) {
        }
    }
}
