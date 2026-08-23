package com.qq.e.comm.pi;

import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface IBidding {
    public static final String ADN_ID = "adnId";
    public static final String EXPECT_COST_PRICE = "expectCostPrice";
    public static final String HIGHEST_LOSS_PRICE = "highestLossPrice";
    public static final String LOSS_REASON = "lossReason";
    public static final String WIN_PRICE = "winPrice";

    @Deprecated
    void sendLossNotification(int i, int i2, String str);

    void sendLossNotification(Map<String, Object> map);

    @Deprecated
    void sendWinNotification(int i);

    void sendWinNotification(Map<String, Object> map);

    void setBidECPM(int i);
}
