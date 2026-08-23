package com.sigmob.sdk.newInterstitial;

import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ag;
import com.sigmob.sdk.base.models.BaseAdUnit;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c implements ag {
    private final HashSet<b> a;
    private boolean d;
    private int e;
    private int b = 0;

    /* renamed from: c, reason: collision with root package name */
    private BaseAdUnit f631c = null;
    private int f = 0;

    public c() {
        HashSet<b> hashSet = new HashSet<>();
        this.a = hashSet;
        hashSet.add(new b());
    }

    @Override // com.sigmob.sdk.base.common.ag
    public void a() {
        if (this.f631c == null) {
            SigmobLog.e("endDisplaySession() called  mAdUnit is null");
            return;
        }
        Iterator<b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().b(this.f631c);
        }
        this.f631c.setSessionManager(null);
        this.f631c.destroy();
        com.sigmob.sdk.base.common.h.b(this.f631c);
        this.f631c = null;
    }

    @Override // com.sigmob.sdk.base.common.ag
    public void a(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null) {
            SigmobLog.e("createDisplaySession() called  mAdUnit is null");
            return;
        }
        Iterator<b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(baseAdUnit);
        }
        this.f631c = baseAdUnit;
        baseAdUnit.setSessionManager(this);
    }

    @Override // com.sigmob.sdk.base.common.ag
    public void a(String str, int i) {
        if (this.f631c == null) {
            SigmobLog.e("createDisplaySession() called  mAdUnit is null");
            return;
        }
        Iterator<b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(this.f631c, str, i);
        }
    }
}
