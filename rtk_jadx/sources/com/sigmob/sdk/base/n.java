package com.sigmob.sdk.base;

import com.sigmob.windad.WindAdRequest;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class n extends WindAdRequest {
    public n(String str, String str2, Map<String, Object> map) {
        super(str, str2, map);
        this.a = 1;
    }

    @Deprecated
    public n(String str, String str2, boolean z, Map<String, Object> map) {
        this(str, str2, map);
        this.a = z ? 1 : 4;
    }
}
