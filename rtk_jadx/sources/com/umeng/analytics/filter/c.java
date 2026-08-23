package com.umeng.analytics.filter;

import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback;

/* compiled from: KeyFilter.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c implements UMImprintChangeCallback, UMImprintPreProcessCallback {
    @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
    public void onImprintValueChanged(String str, String str2) {
    }

    public boolean onPreProcessImprintKey(String str, String str2) {
        return false;
    }
}
