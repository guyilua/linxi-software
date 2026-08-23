package com.windmill.baidu;

import com.baidu.mobads.sdk.api.NativeResponse;
import com.qumeng.advlib.core.ADEvent;
import com.windmill.sdk.natives.WMNativeAdData;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class BdNativeAdData2$3 implements NativeResponse.AdDislikeListener {
    final /* synthetic */ WMNativeAdData.DislikeInteractionCallback a;

    public void onDislikeClick() {
        WMNativeAdData.DislikeInteractionCallback dislikeInteractionCallback = this.a;
        if (dislikeInteractionCallback != null) {
            dislikeInteractionCallback.onSelected(0, ADEvent.BAIDU, true);
        }
    }

    public void onDislikeItemClick(String str) {
        WMNativeAdData.DislikeInteractionCallback dislikeInteractionCallback = this.a;
        if (dislikeInteractionCallback != null) {
            dislikeInteractionCallback.onSelected(0, ADEvent.BAIDU, true);
        }
    }

    public void onDislikeWindowClose() {
    }

    public void onDislikeWindowShow() {
    }
}
