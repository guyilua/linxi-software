package com.qumeng.advlib.ui.front;

import android.os.Bundle;
import androidx.annotation.Keep;

@Keep
/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface InciteVideoListener {
    void onADClick(Bundle bundle);

    void onADClose(Bundle bundle);

    void onADShow(Bundle bundle);

    void onReward(Bundle bundle);

    void onVideoComplete(Bundle bundle);

    void onVideoFail(Bundle bundle);
}
