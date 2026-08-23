package com.sigmob.sdk.base.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class an extends v {
    private am a;
    private e b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f457c;

    public an(Context context) {
        super(context);
        this.f457c = false;
        View fVar = new f(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(fVar, layoutParams);
        this.b = new e(context);
        this.a = new am(context);
        this.b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.b);
        addView(this.a);
        c();
    }

    public an(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f457c = false;
        c();
    }

    public an(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f457c = false;
        c();
    }

    private void c() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sigmob.sdk.base.views.an.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                an.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                an.this.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int width = (int) (getWidth() * 0.25f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, (int) (width * 1.62f));
        layoutParams.setMargins(0, (int) (getHeight() * 0.38f), 0, 0);
        layoutParams.addRule(14);
        this.a.setLayoutParams(layoutParams);
    }

    @Override // com.sigmob.sdk.base.views.v
    public void a() {
        this.f457c = true;
        am amVar = this.a;
        if (amVar != null) {
            amVar.a();
        }
    }

    public void a(float f) {
        e eVar = this.b;
        if (eVar == null || !this.f457c) {
            return;
        }
        eVar.a(f);
    }

    @Override // com.sigmob.sdk.base.views.v
    public void b() {
        this.f457c = false;
        e eVar = this.b;
        if (eVar != null) {
            eVar.a(com.sigmob.sdk.base.blurkit.c.d);
        }
        am amVar = this.a;
        if (amVar != null) {
            amVar.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f457c) {
            a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        c();
    }
}
