package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TbsMediaFactory {
    private Context a;
    private r b = null;

    /* renamed from: c, reason: collision with root package name */
    private DexLoader f943c = null;

    public TbsMediaFactory(Context context) {
        this.a = null;
        this.a = context.getApplicationContext();
        a();
    }

    private void a() {
        if (this.a == null) {
            Log.e("TbsVideo", "TbsVideo needs context !!");
            return;
        }
        if (this.b == null) {
            d.a(true).a(this.a, false, false);
            r a = d.a(true).a();
            this.b = a;
            if (a != null) {
                this.f943c = a.b();
            }
        }
        if (this.b == null || this.f943c == null) {
            throw new RuntimeException("tbs core dex(s) load failure !!!");
        }
    }

    public TbsMediaPlayer createPlayer() {
        DexLoader dexLoader;
        if (this.b != null && (dexLoader = this.f943c) != null) {
            return new TbsMediaPlayer(new m(dexLoader, this.a));
        }
        throw new RuntimeException("tbs core dex(s) did not loaded !!!");
    }
}
