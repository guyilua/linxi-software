package com.qumeng.advlib.core;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.Keep;
import java.util.List;

@Keep
/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface _factory extends Runnable {
    void appListFromClientNotice();

    IMultiAdRequest createNativeMultiAdRequest();

    void notifyMsg(int i, Bundle bundle);

    @Override // java.lang.Runnable
    void run();

    void setAppList(List<PackageInfo> list);

    void setImageAutoDownload(boolean z);

    void terminate();

    void useDebugServer(int i);

    void useDebugServer(boolean z);

    void whenPermDialogReturns(int i, String[] strArr, int[] iArr);
}
