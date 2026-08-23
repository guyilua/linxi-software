package com.sigmob.sdk.nativead;

import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ag;
import com.sigmob.sdk.base.models.BaseAdUnit;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f implements ag {
    private final HashSet<e> a;
    private boolean d;
    private int e;
    private int b = 0;

    /* renamed from: c, reason: collision with root package name */
    private BaseAdUnit f610c = null;
    private int f = 0;

    public f() {
        HashSet<e> hashSet = new HashSet<>();
        this.a = hashSet;
        hashSet.add(new e());
    }

    @Override // com.sigmob.sdk.base.common.ag
    public void a() {
        if (this.f610c == null) {
            SigmobLog.e("endDisplaySession() called  mAdUnit is null");
            return;
        }
        Iterator<e> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().b(this.f610c);
        }
        this.f610c.setSessionManager(null);
        this.f610c.destroy();
        this.f610c = null;
    }

    @Override // com.sigmob.sdk.base.common.ag
    public void a(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null) {
            SigmobLog.e("createDisplaySession() called  mAdUnit is null");
            return;
        }
        Iterator<e> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(baseAdUnit);
        }
        this.f610c = baseAdUnit;
        baseAdUnit.setSessionManager(this);
    }

    @Override // com.sigmob.sdk.base.common.ag
    public void a(String str, int i) {
        if (this.f610c == null) {
            SigmobLog.e("createDisplaySession() called  mAdUnit is null");
            return;
        }
        Iterator<e> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(this.f610c, str, i);
        }
    }
}
