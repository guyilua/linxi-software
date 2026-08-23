package com.sigmob.sdk.base.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class EventForwardingBroadcastReceiver extends BaseBroadcastReceiver {
    private static IntentFilter b;
    public BaseAdUnit a;

    /* renamed from: c, reason: collision with root package name */
    private o.b f353c;

    public EventForwardingBroadcastReceiver(BaseAdUnit baseAdUnit, o.b bVar, String str) {
        super(str);
        this.a = baseAdUnit;
        this.f353c = bVar;
        a();
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public IntentFilter a() {
        if (b == null) {
            IntentFilter intentFilter = new IntentFilter();
            b = intentFilter;
            intentFilter.addAction(IntentActions.ACTION_INTERSTITIAL_FAIL);
            b.addAction(IntentActions.ACTION_INTERSTITIAL_SHOW);
            b.addAction(IntentActions.ACTION_INTERSTITIAL_DISMISS);
            b.addAction(IntentActions.ACTION_INTERSTITIAL_CLICK);
            b.addAction(IntentActions.ACTION_INTERSTITIAL_VOPEN);
        }
        return b;
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public void b(BroadcastReceiver broadcastReceiver) {
        super.b(broadcastReceiver);
        this.f353c = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f353c == null || this.a == null || !a(intent)) {
            return;
        }
        String action = intent.getAction();
        action.hashCode();
        char c2 = 65535;
        switch (action.hashCode()) {
            case -380765568:
                if (action.equals(IntentActions.ACTION_INTERSTITIAL_DISMISS)) {
                    c2 = 0;
                    break;
                }
                break;
            case 101552894:
                if (action.equals(IntentActions.ACTION_INTERSTITIAL_CLICK)) {
                    c2 = 1;
                    break;
                }
                break;
            case 119195958:
                if (action.equals(IntentActions.ACTION_INTERSTITIAL_VOPEN)) {
                    c2 = 2;
                    break;
                }
                break;
            case 696091368:
                if (action.equals(IntentActions.ACTION_INTERSTITIAL_FAIL)) {
                    c2 = 3;
                    break;
                }
                break;
            case 696485575:
                if (action.equals(IntentActions.ACTION_INTERSTITIAL_SHOW)) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.f353c.d(this.a);
                b(this);
                this.a = null;
                return;
            case 1:
                this.f353c.c(this.a);
                return;
            case 2:
                this.f353c.e(this.a);
                return;
            case 3:
                this.f353c.b(this.a, intent.getStringExtra("error"));
                return;
            case 4:
                this.f353c.b(this.a);
                return;
            default:
                return;
        }
    }
}
