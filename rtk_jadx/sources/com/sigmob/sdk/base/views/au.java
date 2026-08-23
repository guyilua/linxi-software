package com.sigmob.sdk.base.views;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class au extends v {
    private as a;
    private at b;

    /* renamed from: c, reason: collision with root package name */
    private ObjectAnimator f461c;
    private boolean d;

    public au(Context context) {
        super(context);
        c();
    }

    public au(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public au(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }

    private void c() {
        addView(new f(getContext()), new FrameLayout.LayoutParams(-1, -1));
        this.a = new as(getContext());
        this.b = new at(getContext());
        addView(this.a, new ViewGroup.LayoutParams(-1, -1));
        addView(this.b, new ViewGroup.LayoutParams(-1, -1));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b, (Property<at, Float>) View.ROTATION_Y, -45.0f, com.sigmob.sdk.base.blurkit.c.d, 45.0f);
        this.f461c = ofFloat;
        ofFloat.setDuration(1000L);
        this.f461c.setRepeatCount(-1);
        this.f461c.setRepeatMode(2);
    }

    @Override // com.sigmob.sdk.base.views.v
    public void a() {
        this.d = true;
        ObjectAnimator objectAnimator = this.f461c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f461c.start();
        }
    }

    @Override // com.sigmob.sdk.base.views.v
    public void b() {
        this.d = false;
        ObjectAnimator objectAnimator = this.f461c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.d) {
            a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }
}
