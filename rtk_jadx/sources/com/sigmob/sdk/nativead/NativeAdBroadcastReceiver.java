package com.sigmob.sdk.nativead;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.czhj.sdk.common.utils.Preconditions;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.nativead.d;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class NativeAdBroadcastReceiver extends BaseBroadcastReceiver {
    private static IntentFilter a;
    private d.a b;

    public NativeAdBroadcastReceiver(d.a aVar, String str) {
        super(str);
        this.b = aVar;
        a();
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public IntentFilter a() {
        if (a == null) {
            IntentFilter intentFilter = new IntentFilter();
            a = intentFilter;
            intentFilter.addAction(IntentActions.ACTION_NATIVE_TEMPLIE_SHOW);
            a.addAction(IntentActions.ACTION_NATIVE_TEMPLE_CLICK);
            a.addAction(IntentActions.ACTION_NATIVE_TEMPLE_DISMISS);
            a.addAction(IntentActions.ACTION_LANDPAGE_SHOW);
            a.addAction(IntentActions.ACTION_LANDPAGE_DISMISS);
        }
        return a;
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public void b(BroadcastReceiver broadcastReceiver) {
        super.b(broadcastReceiver);
        this.b = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(intent);
        if (this.b != null && a(intent)) {
            String action = intent.getAction();
            action.hashCode();
            char c2 = 65535;
            switch (action.hashCode()) {
                case -1808899352:
                    if (action.equals(IntentActions.ACTION_NATIVE_TEMPLE_DISMISS)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1060959590:
                    if (action.equals(IntentActions.ACTION_NATIVE_TEMPLE_CLICK)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1697265503:
                    if (action.equals(IntentActions.ACTION_NATIVE_TEMPLIE_SHOW)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1946088222:
                    if (action.equals(IntentActions.ACTION_LANDPAGE_SHOW)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 2050136777:
                    if (action.equals(IntentActions.ACTION_LANDPAGE_DISMISS)) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    this.b.e();
                    return;
                case 1:
                    this.b.d();
                    return;
                case 2:
                    this.b.c();
                    return;
                case 3:
                    this.b.a();
                    return;
                case 4:
                    this.b.b();
                    return;
                default:
                    return;
            }
        }
    }
}
