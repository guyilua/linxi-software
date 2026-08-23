package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tbs.video.interfaces.IUserStateChangedListener;

/* compiled from: TbsVideoPlayer.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
class o {
    private static o e;
    q a;
    Context b;

    /* renamed from: c, reason: collision with root package name */
    com.tencent.tbs.video.interfaces.a f966c;
    IUserStateChangedListener d;

    private o(Context context) {
        this.a = null;
        this.b = context.getApplicationContext();
        this.a = new q(this.b);
    }

    public static synchronized o a(Context context) {
        o oVar;
        synchronized (o.class) {
            if (e == null) {
                e = new o(context);
            }
            oVar = e;
        }
        return oVar;
    }

    public boolean a(String str, Bundle bundle, com.tencent.tbs.video.interfaces.a aVar) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("videoUrl", str);
        }
        if (aVar != null) {
            this.a.a();
            if (!this.a.b()) {
                return false;
            }
            this.f966c = aVar;
            IUserStateChangedListener iUserStateChangedListener = new IUserStateChangedListener() { // from class: com.tencent.smtt.sdk.o.1
                @Override // com.tencent.tbs.video.interfaces.IUserStateChangedListener
                public void onUserStateChanged() {
                    o.this.a.c();
                }
            };
            this.d = iUserStateChangedListener;
            this.f966c.a(iUserStateChangedListener);
            bundle.putInt("callMode", 3);
        } else {
            bundle.putInt("callMode", 1);
        }
        this.a.a(bundle, aVar == null ? null : this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Activity activity, int i) {
        this.a.a(activity, i);
    }

    public boolean a() {
        this.a.a();
        return this.a.b();
    }

    public void a(int i, int i2, Intent intent) {
        com.tencent.tbs.video.interfaces.a aVar = this.f966c;
        if (aVar != null) {
            aVar.a(i, i2, intent);
        }
    }
}
