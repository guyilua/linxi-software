package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.smtt.sdk.TbsListener;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public enum d {
    UUID_EXPIRED(402),
    UUID_CANCELED(403),
    UUID_SCANED(404),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(TbsListener.ErrorCode.INFO_CAN_NOT_DISABLED_BY_CRASH),
    UUID_ERROR(TbsListener.ErrorCode.INFO_CODE_MINIQB);

    private int a;

    d(int i) {
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UUIDStatusCode:" + this.a;
    }
}
