package com.rtk.app.custom;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int a;

    public SpacesItemDecoration(int i) {
        this.a = i;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i = this.a;
        rect.left = i;
        rect.right = i;
        rect.bottom = i;
        if (recyclerView.getChildLayoutPosition(view) == 0) {
            rect.top = this.a;
        } else {
            rect.top = 0;
        }
    }
}
