package com.tencent.mm.opensdk.diffdev;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface OAuthListener {
    void onAuthFinish(OAuthErrCode oAuthErrCode, String str);

    void onAuthGotQrcode(String str, byte[] bArr);

    void onQrcodeScanned();
}
