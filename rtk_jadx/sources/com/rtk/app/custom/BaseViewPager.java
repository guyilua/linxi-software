package com.rtk.app.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class BaseViewPager extends ViewPager {
    private boolean a;

    public BaseViewPager(Context context) {
        super(context);
        this.a = true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.a) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public void setScrollable(boolean z) {
        this.a = z;
    }

    public BaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
    }
}
