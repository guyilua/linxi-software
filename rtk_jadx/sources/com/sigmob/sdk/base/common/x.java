package com.sigmob.sdk.base.common;

import android.os.Bundle;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.models.BaseAdUnit;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class x extends o {
    protected o.b a;
    protected BaseAdUnit b;

    /* renamed from: c, reason: collision with root package name */
    private EventForwardingBroadcastReceiver f396c;

    /* JADX INFO: Access modifiers changed from: protected */
    public x(o.b bVar) {
        this.a = null;
        this.a = bVar;
    }

    protected abstract void a(o.b bVar);

    public void a(BaseAdUnit baseAdUnit, Bundle bundle) {
        EventForwardingBroadcastReceiver eventForwardingBroadcastReceiver = new EventForwardingBroadcastReceiver(baseAdUnit, this.a, baseAdUnit.getUuid());
        this.f396c = eventForwardingBroadcastReceiver;
        eventForwardingBroadcastReceiver.a(eventForwardingBroadcastReceiver);
    }

    public void a(Map<String, Object> map, BaseAdUnit baseAdUnit) {
        this.b = baseAdUnit;
        a(this.a);
    }

    protected abstract boolean a(BaseAdUnit baseAdUnit);

    public void b(BaseAdUnit baseAdUnit) {
        if (baseAdUnit != null) {
            h.b(baseAdUnit);
            baseAdUnit.destroy();
        }
        this.b = null;
        EventForwardingBroadcastReceiver eventForwardingBroadcastReceiver = this.f396c;
        if (eventForwardingBroadcastReceiver != null) {
            eventForwardingBroadcastReceiver.b(eventForwardingBroadcastReceiver);
        }
    }
}
