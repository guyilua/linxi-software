package com.qq.e.comm.pi;

import android.content.Context;
import com.qq.e.ads.dfa.GDTApk;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface DFA {
    void loadGDTApk();

    void startInstall(Context context, GDTApk gDTApk);
}
