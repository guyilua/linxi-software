package com.qumeng.advlib.core;

import android.os.Bundle;
import androidx.annotation.Keep;
import com.qumeng.advlib.core.ICliUtils;
import java.util.List;

@Keep
/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface _request {
    void InvokeADV(String str, int i, int i2, int i3);

    void InvokeADV(String str, int i, int i2, int i3, Bundle bundle);

    void InvokeADV(List<String> list);

    void InvokeADV(String... strArr);

    void bindAdContentListener(ICliUtils.a aVar);

    void onClickedReport();

    void onShowedReport();

    void removeAdContentListener();

    void unbindAdContentListener(ICliUtils.a aVar);
}
