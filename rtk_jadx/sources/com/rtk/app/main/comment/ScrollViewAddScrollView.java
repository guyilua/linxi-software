package com.rtk.app.main.comment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ScrollView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ScrollViewAddScrollView extends ScrollView {
    public ScrollViewAddScrollView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (((ViewGroup) getChildAt(0)).getChildAt(0).isFocused()) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        } catch (Exception unused) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public ScrollViewAddScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrollViewAddScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
