package com.sigmob.sdk.nativead;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.czhj.sdk.common.utils.Preconditions;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.models.IntentActions;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class APKStatusBroadcastReceiver extends BaseBroadcastReceiver {
    o.a a;
    IntentFilter b;

    public APKStatusBroadcastReceiver(o.a aVar, String str) {
        super(str);
        this.a = aVar;
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public IntentFilter a() {
        if (this.b == null) {
            IntentFilter intentFilter = new IntentFilter();
            this.b = intentFilter;
            intentFilter.addAction(IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START);
            this.b.addAction(IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_PAUSE);
            this.b.addAction(IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_END);
            this.b.addAction(IntentActions.ACTION_INTERSTITIAL_INSTALL_START);
            this.b.addAction(IntentActions.ACTION_INTERSTITIAL_INSTALL_END);
        }
        return this.b;
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public void b(BroadcastReceiver broadcastReceiver) {
        super.b(broadcastReceiver);
        this.a = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(intent);
        if (this.a != null && a(intent)) {
            String action = intent.getAction();
            boolean equalsIgnoreCase = "1".equalsIgnoreCase(intent.getStringExtra("result"));
            long longExtra = intent.getLongExtra("downloadId", -1L);
            action.hashCode();
            char c2 = 65535;
            switch (action.hashCode()) {
                case -2105804737:
                    if (action.equals(IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_END)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -738964390:
                    if (action.equals(IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_PAUSE)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -735647034:
                    if (action.equals(IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 376155902:
                    if (action.equals(IntentActions.ACTION_INTERSTITIAL_INSTALL_END)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 721677765:
                    if (action.equals(IntentActions.ACTION_INTERSTITIAL_INSTALL_START)) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    this.a.b(equalsIgnoreCase, longExtra);
                    return;
                case 1:
                    this.a.c(equalsIgnoreCase, longExtra);
                    return;
                case 2:
                    this.a.a(equalsIgnoreCase, longExtra);
                    return;
                case 3:
                    this.a.b(equalsIgnoreCase);
                    return;
                case 4:
                    this.a.a(equalsIgnoreCase);
                    return;
                default:
                    return;
            }
        }
    }
}
