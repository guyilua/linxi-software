package com.rtk.app.custom;

import android.view.MotionEvent;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class OnRecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
    private GestureDetectorCompat a;

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.a.onTouchEvent(motionEvent);
        return false;
    }

    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.a.onTouchEvent(motionEvent);
    }
}
