package com.sigmob.sdk.newInterstitial;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.czhj.sdk.common.utils.Preconditions;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.newInterstitial.e;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class NewInterstitialAdBroadcastReceiver extends BaseBroadcastReceiver {
    private static IntentFilter a;
    private e.a b;

    /* renamed from: c, reason: collision with root package name */
    private BaseAdUnit f624c;

    public NewInterstitialAdBroadcastReceiver(BaseAdUnit baseAdUnit, e.a aVar, String str) {
        super(str);
        this.f624c = baseAdUnit;
        this.b = aVar;
        a();
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public IntentFilter a() {
        if (a == null) {
            IntentFilter intentFilter = new IntentFilter();
            a = intentFilter;
            intentFilter.addAction(IntentActions.ACTION_REWARDED_VIDEO_PLAY);
            a.addAction(IntentActions.ACTION_REWARDED_VIDEO_SKIP);
            a.addAction(IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL);
            a.addAction(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
            a.addAction(IntentActions.ACTION_REWARDED_VIDEO_CLOSE);
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
        if (this.b == null || this.f624c == null || !a(intent)) {
            return;
        }
        String action = intent.getAction();
        action.hashCode();
        char c2 = 65535;
        switch (action.hashCode()) {
            case -1099669813:
                if (action.equals(IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL)) {
                    c2 = 0;
                    break;
                }
                break;
            case 450683405:
                if (action.equals(IntentActions.ACTION_REWARDED_VIDEO_PLAY)) {
                    c2 = 1;
                    break;
                }
                break;
            case 450772056:
                if (action.equals(IntentActions.ACTION_REWARDED_VIDEO_SKIP)) {
                    c2 = 2;
                    break;
                }
                break;
            case 1044738591:
                if (action.equals(IntentActions.ACTION_REWARDED_VIDEO_CLOSE)) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.b.c(this.f624c, intent.getStringExtra("error"));
                break;
            case 1:
                this.b.h(this.f624c);
                return;
            case 2:
                this.b.g(this.f624c);
                return;
            case 3:
                this.b.f(this.f624c);
                break;
            default:
                return;
        }
        b(this);
        this.f624c = null;
    }
}
