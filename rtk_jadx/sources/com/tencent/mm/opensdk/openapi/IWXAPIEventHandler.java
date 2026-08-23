package com.tencent.mm.opensdk.openapi;

import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface IWXAPIEventHandler {
    void onReq(BaseReq baseReq);

    void onResp(BaseResp baseResp);
}
