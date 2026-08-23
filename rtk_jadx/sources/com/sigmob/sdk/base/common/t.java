package com.sigmob.sdk.base.common;

import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class t implements ag {
    private final Set<s> a;
    private BaseAdUnit b;

    public t() {
        HashSet hashSet = new HashSet();
        this.a = hashSet;
        hashSet.add(new af());
    }

    @Override // com.sigmob.sdk.base.common.ag
    public void a() {
        SigmobLog.d("endDisplaySession() called");
        if (this.b == null) {
            SigmobLog.e("endDisplaySession() called  mAdUnit is null");
            return;
        }
        Iterator<s> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().b(this.b);
        }
        this.b.setSessionManager(null);
        this.b.destroy();
        this.b = null;
    }

    public void a(int i, int i2) {
        if (this.b == null) {
            SigmobLog.e("onVideoPrepared() called  mAdUnit is null");
            return;
        }
        Iterator<s> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(this.b, i, i2);
        }
    }

    @Override // com.sigmob.sdk.base.common.ag
    public void a(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null) {
            SigmobLog.e("createDisplaySession() called  adUnit is null");
            return;
        }
        this.b = baseAdUnit;
        baseAdUnit.setSessionManager(this);
        Iterator<s> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(baseAdUnit);
        }
    }

    @Override // com.sigmob.sdk.base.common.ag
    public void a(String str, int i) {
        if (this.b == null) {
            SigmobLog.e("recordDisplayEvent() called  mAdUnit is null");
            return;
        }
        Iterator<s> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(this.b, str, i);
        }
    }

    public void a(boolean z, int i) {
        if (this.b == null) {
            SigmobLog.e("onVideoShowSkip() called  mAdUnit is null");
            return;
        }
        Iterator<s> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(this.b, z, i);
        }
    }
}
