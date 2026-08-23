package com.qq.e.ads.nativ;

import com.qq.e.ads.NativeAbstractAD;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface NativeADUnifiedListener extends NativeAbstractAD.BasicADListener {
    void onADLoaded(List<NativeUnifiedADData> list);
}
