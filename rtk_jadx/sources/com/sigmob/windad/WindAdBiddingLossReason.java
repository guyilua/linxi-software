package com.sigmob.windad;

import com.qq.e.comm.constants.ErrorCode;
import com.sigmob.sdk.downloader.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public enum WindAdBiddingLossReason {
    LOSS_REASON_LOW_PRICE(2, "出价过低"),
    LOSS_REASON_RETURN_TIMEOUT(f.a.f, "返回超时"),
    LOSS_REASON_RETURN_ERROR(ErrorCode.INIT_ERROR, "广告素材格式错误");

    private int a;
    private String message;

    WindAdBiddingLossReason(int i, String str) {
        this.a = i;
        this.message = str;
    }

    public int getCode() {
        return this.a;
    }

    public String getMessage() {
        return this.message;
    }
}
