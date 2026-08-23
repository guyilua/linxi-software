package com.rtk.app.custom;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.rtk.app.tool.c0;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class NoBugGridLayoutManager extends GridLayoutManager {
    public NoBugGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e) {
            e.printStackTrace();
            c0.u("NoBugGridLayoutManager", "捕捉到社区下拉刷新日志");
        }
    }

    public NoBugGridLayoutManager(Context context, int i) {
        super(context, i);
    }
}
