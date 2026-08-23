package com.sigmob.sdk.splash;

import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ag;
import com.sigmob.sdk.base.models.BaseAdUnit;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class k implements ag {
    private final HashSet<j> a;
    private boolean d;
    private int e;
    private int b = 0;

    /* renamed from: c, reason: collision with root package name */
    private BaseAdUnit f648c = null;
    private int f = 0;

    public k() {
        HashSet<j> hashSet = new HashSet<>();
        this.a = hashSet;
        hashSet.add(new j());
    }

    @Override // com.sigmob.sdk.base.common.ag
    public void a() {
        if (this.f648c == null) {
            SigmobLog.e("endDisplaySession() called  mAdUnit is null");
            return;
        }
        Iterator<j> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().b(this.f648c);
        }
        this.f648c.setSessionManager(null);
        this.f648c.destroy();
        this.f648c = null;
    }

    @Override // com.sigmob.sdk.base.common.ag
    public void a(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null) {
            SigmobLog.e("createDisplaySession() called  mAdUnit is null");
            return;
        }
        Iterator<j> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(baseAdUnit);
        }
        this.f648c = baseAdUnit;
        baseAdUnit.setSessionManager(this);
    }

    @Override // com.sigmob.sdk.base.common.ag
    public void a(String str, int i) {
        if (this.f648c == null) {
            SigmobLog.e("recordDisplayEvent() called  mAdUnit is null");
            return;
        }
        Iterator<j> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(this.f648c, str, i);
        }
    }
}
