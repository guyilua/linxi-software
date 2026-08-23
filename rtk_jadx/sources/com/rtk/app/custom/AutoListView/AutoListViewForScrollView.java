package com.rtk.app.custom.AutoListView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AutoListViewForScrollView extends AutoListView {
    public AutoListViewForScrollView(Context context) {
        super(context);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public AutoListViewForScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AutoListViewForScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
