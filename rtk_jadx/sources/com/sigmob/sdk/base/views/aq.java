package com.sigmob.sdk.base.views;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class aq extends ImageView {
    private y a;
    private final int b;

    public aq(Context context) {
        super(context);
        y yVar = new y(context);
        this.a = yVar;
        setImageDrawable(yVar);
        this.b = Dips.dipsToIntPixels(2.0f, context);
    }

    public void a(int i) {
        this.a.a(i);
    }

    public void a(int i, int i2) {
        this.a.a(i, i2);
        setVisibility(0);
    }

    @Deprecated
    y getImageViewDrawable() {
        return this.a;
    }

    public void setAnchorId(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.b);
        layoutParams.addRule(12, i);
        setLayoutParams(layoutParams);
    }

    @Deprecated
    void setImageViewDrawable(y yVar) {
        this.a = yVar;
    }
}
