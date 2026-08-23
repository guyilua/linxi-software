package com.sigmob.sdk.base.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class v extends RelativeLayout {
    public v(Context context) {
        super(context);
    }

    public v(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public v(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public abstract void a();

    public abstract void b();
}
