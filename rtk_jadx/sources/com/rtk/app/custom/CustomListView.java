package com.rtk.app.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CustomListView extends ListView {
    public CustomListView(Context context) {
        super(context);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public CustomListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
