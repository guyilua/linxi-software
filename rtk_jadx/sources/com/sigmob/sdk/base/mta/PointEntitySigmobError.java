package com.sigmob.sdk.base.mta;

import com.czhj.sdk.common.mta.DeviceContext;
import com.sigmob.sdk.b;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class PointEntitySigmobError extends PointEntitySigmob {
    private String a;

    public static PointEntitySigmobError SigmobError(String str, int i, String str2) {
        PointEntitySigmobError pointEntitySigmobError = new PointEntitySigmobError();
        pointEntitySigmobError.setAc_type("9");
        pointEntitySigmobError.setCategory(str);
        pointEntitySigmobError.setError_code(String.valueOf(i));
        pointEntitySigmobError.setError_message(str2);
        return pointEntitySigmobError;
    }

    @Override // com.sigmob.sdk.base.mta.PointEnitySigmobBase
    public DeviceContext getDeviceContext() {
        return b.b();
    }

    @Override // com.sigmob.sdk.base.mta.PointEntitySigmob
    public String getError_message() {
        return this.a;
    }

    @Override // com.sigmob.sdk.base.mta.PointEntitySigmob
    public void setError_message(String str) {
        this.a = str;
    }
}
