package com.rtk.app.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.core.widget.NestedScrollView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class NestedScrollView extends androidx.core.widget.NestedScrollView {
    private boolean a;
    private float b;

    /* renamed from: c, reason: collision with root package name */
    private float f165c;
    private float d;
    private float e;
    private int f;
    private boolean g;
    private NestedScrollView.OnScrollChangeListener h;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements NestedScrollView.OnScrollChangeListener {
        a() {
        }

        public void onScrollChange(androidx.core.widget.NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
            if (nestedScrollView.getChildAt(0).getHeight() - nestedScrollView.getHeight() == i2 || i2 == 0) {
                NestedScrollView.this.g = false;
                nestedScrollView.stopNestedScroll();
            } else {
                NestedScrollView.this.g = true;
            }
        }
    }

    public NestedScrollView(Context context) {
        super(context, (AttributeSet) null);
        this.a = true;
        this.g = false;
        a aVar = new a();
        this.h = aVar;
        setOnScrollChangeListener(aVar);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f165c = com.sigmob.sdk.base.blurkit.c.d;
            this.b = com.sigmob.sdk.base.blurkit.c.d;
            this.d = motionEvent.getX();
            this.e = motionEvent.getY();
        } else if (action == 2) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.b += Math.abs(x - this.d);
            float abs = this.f165c + Math.abs(y - this.e);
            this.f165c = abs;
            this.d = x;
            this.e = y;
            this.g = true;
            return this.b < abs && abs >= ((float) this.f) && this.a;
        }
        if (!this.g) {
            this.g = true;
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.a = true;
        this.g = false;
        a aVar = new a();
        this.h = aVar;
        setOnScrollChangeListener(aVar);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = true;
        this.g = false;
        this.h = new a();
        this.f = ViewConfiguration.get(context).getScaledTouchSlop();
        setOnScrollChangeListener(this.h);
    }
}
