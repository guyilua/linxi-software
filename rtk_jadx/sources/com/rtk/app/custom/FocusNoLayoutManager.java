package com.rtk.app.custom;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FocusNoLayoutManager extends LinearLayoutManager {
    public FocusNoLayoutManager(Context context) {
        super(context);
    }

    public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
        return requestChildRectangleOnScreen(recyclerView, view, rect, z, false);
    }

    public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
        return false;
    }

    public FocusNoLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
