package com.rtk.app.custom;

import android.content.Context;
import android.util.AttributeSet;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ScrollViewHasScrollListener extends androidx.core.widget.NestedScrollView {
    private a a;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a(ScrollViewHasScrollListener scrollViewHasScrollListener, int i, int i2, int i3, int i4);
    }

    public ScrollViewHasScrollListener(Context context) {
        super(context);
        this.a = null;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(this, i, i2, i3, i4);
        }
    }

    public void setScrollViewListener(a aVar) {
        this.a = aVar;
    }

    public ScrollViewHasScrollListener(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
    }

    public ScrollViewHasScrollListener(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
    }
}
