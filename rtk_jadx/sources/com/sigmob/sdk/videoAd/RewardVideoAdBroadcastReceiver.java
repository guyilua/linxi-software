package com.sigmob.sdk.videoAd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.czhj.sdk.common.utils.Preconditions;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.videoAd.k;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class RewardVideoAdBroadcastReceiver extends BaseBroadcastReceiver {
    private static IntentFilter a;
    private k.a b;

    /* renamed from: c, reason: collision with root package name */
    private BaseAdUnit f650c;

    public RewardVideoAdBroadcastReceiver(BaseAdUnit baseAdUnit, k.a aVar, String str) {
        super(str);
        this.f650c = baseAdUnit;
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
        if (this.b == null || this.f650c == null || !a(intent)) {
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
            case 717517714:
                if (action.equals(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE)) {
                    c2 = 3;
                    break;
                }
                break;
            case 1044738591:
                if (action.equals(IntentActions.ACTION_REWARDED_VIDEO_CLOSE)) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.b.c(this.f650c, intent.getStringExtra("error"));
                break;
            case 1:
                this.b.g(this.f650c);
                return;
            case 2:
                this.b.h(this.f650c);
                return;
            case 3:
                this.b.f(this.f650c);
                return;
            case 4:
                this.b.i(this.f650c);
                break;
            default:
                return;
        }
        b(this);
        this.f650c = null;
    }
}
