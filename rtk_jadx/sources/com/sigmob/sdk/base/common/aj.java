package com.sigmob.sdk.base.common;

import android.content.Context;
import android.widget.Toast;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class aj extends Toast {
    public aj(Context context) {
        super(context);
    }

    public static Toast a(Context context, CharSequence charSequence, int i) {
        Toast makeText = Toast.makeText(context, charSequence, i);
        makeText.setGravity(17, 0, 0);
        return makeText;
    }
}
