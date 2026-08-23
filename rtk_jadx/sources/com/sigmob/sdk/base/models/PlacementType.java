package com.sigmob.sdk.base.models;

import java.util.Locale;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public enum PlacementType {
    INLINE,
    INTERSTITIAL;

    public String toJavascriptString() {
        return toString().toLowerCase(Locale.US);
    }
}
