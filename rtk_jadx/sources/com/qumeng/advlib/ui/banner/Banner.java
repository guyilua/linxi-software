package com.qumeng.advlib.ui.banner;

import androidx.annotation.Keep;
import com.qumeng.advlib.core.ICliBundle;
import com.qumeng.advlib.core.ICliUtils;
import com.qumeng.advlib.core.IMultiAdObject;

@Keep
/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface Banner {
    void OnBannerInit();

    void UpdateView(ICliBundle iCliBundle);

    void setADStateListener(IMultiAdObject.ADStateListener aDStateListener);

    void setPageUniqueId(int i);

    void setStateListener(ICliUtils.BannerStateListener bannerStateListener);

    void updateViewWithAds(Object obj);
}
