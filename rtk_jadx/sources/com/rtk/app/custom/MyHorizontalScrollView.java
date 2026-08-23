package com.rtk.app.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyHorizontalScrollView extends HorizontalScrollView {
    public static boolean b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f161c = true;
    private SwipeRefreshLayout a;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    enum a {
        IDLE,
        TOUCH_SCROLL,
        FLING
    }

    public MyHorizontalScrollView(Context context) {
        super(context);
        a aVar = a.IDLE;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                b = false;
            } else if (action == 3) {
                b = false;
            }
        } else if (f161c) {
            b = false;
        } else {
            b = true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        int measuredWidth = getChildAt(0).getMeasuredWidth() - getMeasuredWidth();
        if (getScrollX() == 0) {
            f161c = true;
            b = false;
        } else if (getScrollX() == measuredWidth) {
            f161c = false;
            b = false;
        } else {
            f161c = false;
            b = false;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            SwipeRefreshLayout swipeRefreshLayout = this.a;
            if (swipeRefreshLayout != null) {
                swipeRefreshLayout.setEnabled(false);
            }
            if (f161c) {
                b = false;
            } else {
                b = true;
            }
        } else if (action == 1) {
            SwipeRefreshLayout swipeRefreshLayout2 = this.a;
            if (swipeRefreshLayout2 != null) {
                swipeRefreshLayout2.setEnabled(true);
            }
            b = false;
        } else if (action == 2) {
            SwipeRefreshLayout swipeRefreshLayout3 = this.a;
            if (swipeRefreshLayout3 != null) {
                swipeRefreshLayout3.setEnabled(false);
            }
        } else if (action == 3) {
            b = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setSwipeRefreshLayout(SwipeRefreshLayout swipeRefreshLayout) {
        this.a = swipeRefreshLayout;
    }

    public MyHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a aVar = a.IDLE;
    }

    public MyHorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a aVar = a.IDLE;
    }
}
