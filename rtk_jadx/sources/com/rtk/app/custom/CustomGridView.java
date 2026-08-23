package com.rtk.app.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CustomGridView extends GridView {
    public CustomGridView(Context context) {
        super(context);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public CustomGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
