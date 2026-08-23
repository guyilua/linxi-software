package com.qq.e.mediation.interfaces;

@Deprecated
/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface INoticeUrlProvider {
    public static final String IMPL_CLASS_NAME = "util.NoticeUrlProviderImpl";

    String getAssembledLossNoticeUrl(String str, String str2, boolean z);

    String getAssembledWinNoticeUrl(String str, String str2, boolean z);

    String getOtherAssembledLossNoticeUrl(String str, String str2);
}
