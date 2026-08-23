package com.rtk.app.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FixedViewPager extends ViewPager {
    public FixedViewPager(Context context) {
        super(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            return super/*android.view.ViewGroup*/.dispatchTouchEvent(motionEvent);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused) {
            return false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    public FixedViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
