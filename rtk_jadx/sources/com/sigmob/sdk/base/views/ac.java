package com.sigmob.sdk.base.views;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ResourceUtil;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ac extends v {
    private ImageView a;
    private ObjectAnimator b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f446c;
    private f d;

    public ac(Context context) {
        super(context);
        c();
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public ac(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }

    private void c() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        f fVar = new f(getContext());
        this.d = fVar;
        addView(fVar, layoutParams);
        int dipsToIntPixels = Dips.dipsToIntPixels(45.0f, getContext());
        this.a = new ImageView(getContext());
        this.a.setImageDrawable(getResources().getDrawable(ResourceUtil.getDrawableId(getContext(), "sig_image_shake_new")));
        this.a.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams2.addRule(13);
        addView(this.a, layoutParams2);
        d();
    }

    private void d() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sigmob.sdk.base.views.ac.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int height = ac.this.getHeight();
                int width = ac.this.getWidth();
                if (height == 0 || width == 0) {
                    return;
                }
                ac.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                ViewGroup.LayoutParams layoutParams = ac.this.a.getLayoutParams();
                int i = height / 2;
                layoutParams.width = i;
                layoutParams.height = i;
                ac.this.a.setLayoutParams(layoutParams);
                float f = i;
                ac.this.a.setPivotX(f);
                ac.this.a.setPivotY(f * 0.8f);
            }
        });
    }

    private void e() {
        if (this.b != null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, com.sigmob.sdk.base.common.a.F, com.sigmob.sdk.base.blurkit.c.d, 18.0f, com.sigmob.sdk.base.blurkit.c.d, -18.0f, com.sigmob.sdk.base.blurkit.c.d, 18.0f, com.sigmob.sdk.base.blurkit.c.d, -18.0f, com.sigmob.sdk.base.blurkit.c.d, 18.0f, com.sigmob.sdk.base.blurkit.c.d);
        this.b = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.b.addListener(new Animator.AnimatorListener() { // from class: com.sigmob.sdk.base.views.ac.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ac.this.f446c) {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.sigmob.sdk.base.views.ac.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ac.this.b.start();
                        }
                    }, 300L);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.b.setDuration(1200L);
    }

    @Override // com.sigmob.sdk.base.views.v
    public void a() {
        ObjectAnimator objectAnimator = this.b;
        if (objectAnimator != null && !this.f446c) {
            objectAnimator.start();
        }
        this.f446c = true;
    }

    @Override // com.sigmob.sdk.base.views.v
    public void b() {
        ObjectAnimator objectAnimator = this.b;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.f446c = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        d();
        e();
        if (this.f446c) {
            this.b.cancel();
            this.b.start();
        }
    }
}
