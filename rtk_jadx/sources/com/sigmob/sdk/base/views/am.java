package com.sigmob.sdk.base.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class am extends View {
    private Paint a;
    private RectF b;

    /* renamed from: c, reason: collision with root package name */
    private float f456c;
    private float d;
    private float e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private Path m;
    private AnimatorSet n;
    private boolean o;

    public am(Context context) {
        super(context);
        this.a = new Paint(1);
        this.m = new Path();
        this.b = new RectF();
        c();
    }

    public am(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public am(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }

    private Animator a(int i) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, com.sigmob.sdk.base.common.a.F, com.sigmob.sdk.base.blurkit.c.d, i, com.sigmob.sdk.base.blurkit.c.d);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(com.sigmob.sdk.base.blurkit.c.d, (-this.l) * 0.6f, com.sigmob.sdk.base.blurkit.c.d);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.am.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                am.this.f456c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                am.this.invalidate();
            }
        });
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.setDuration(1000L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    private void c() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sigmob.sdk.base.views.am.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                am.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                am.this.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.k = getWidth();
        int height = getHeight();
        this.l = height;
        if (this.k == 0 || height == 0) {
            return;
        }
        this.a.setStyle(Paint.Style.STROKE);
        int dipsToIntPixels = Dips.dipsToIntPixels(1.0f, getContext());
        this.g = dipsToIntPixels;
        this.a.setStrokeWidth(dipsToIntPixels);
        this.a.setColor(-1);
        this.f = (int) ((this.k / (this.g * 75.0f)) * Dips.dipsToIntPixels(5.0f, getContext()));
        setLayerType(2, null);
        float f = this.k;
        int i = this.g;
        this.h = Math.max((int) ((f / (i * 25.0f)) * i * 11.0f), i * 3);
        float f2 = this.k;
        int i2 = this.g;
        this.i = Math.max((int) ((f2 / (i2 * 25.0f)) * 3.0f * i2), i2 * 2);
        float f3 = this.k;
        int i3 = this.g;
        this.j = Math.max((int) ((f3 / (i3 * 25.0f)) * 11.0f * i3), i3 * 5);
        e();
    }

    private void e() {
        AnimatorSet animatorSet = this.n;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.n = new AnimatorSet();
        this.n.playSequentially(a(-45), a(45), getFlipLeftAnimation(), getFlipRightAnimation());
        this.n.addListener(new Animator.AnimatorListener() { // from class: com.sigmob.sdk.base.views.am.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (am.this.n == null || !am.this.o) {
                    return;
                }
                am.this.n.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        if (this.o) {
            this.n.start();
        }
    }

    private Animator getFlipLeftAnimation() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "rotationY", com.sigmob.sdk.base.blurkit.c.d, 45.0f, com.sigmob.sdk.base.blurkit.c.d);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(com.sigmob.sdk.base.blurkit.c.d, this.k * 0.6f, com.sigmob.sdk.base.blurkit.c.d);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.am.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                am.this.d = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                am.this.invalidate();
            }
        });
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.setDuration(1000L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    private Animator getFlipRightAnimation() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "rotationY", com.sigmob.sdk.base.blurkit.c.d, -45.0f, com.sigmob.sdk.base.blurkit.c.d);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(com.sigmob.sdk.base.blurkit.c.d, (-this.k) * 0.6f, com.sigmob.sdk.base.blurkit.c.d);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.am.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                am.this.e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                am.this.invalidate();
            }
        });
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.setDuration(1000L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    public void a() {
        this.o = true;
        AnimatorSet animatorSet = this.n;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    public void b() {
        this.o = false;
        AnimatorSet animatorSet = this.n;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.k == 0 || this.l == 0) {
            return;
        }
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setColor(-1);
        this.m.reset();
        RectF rectF = this.b;
        int i = this.g;
        rectF.set(i, i, this.k - i, this.l - i);
        Path path = this.m;
        RectF rectF2 = this.b;
        int i2 = this.f;
        path.addRoundRect(rectF2, i2, i2, Path.Direction.CCW);
        canvas.drawPath(this.m, this.a);
        canvas.clipPath(this.m);
        this.a.setStyle(Paint.Style.FILL);
        this.a.setColor(-7829368);
        this.a.setAlpha(204);
        canvas.drawRect(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d, this.k, this.l, this.a);
        this.a.setColor(-3355444);
        this.a.setAlpha(255);
        int i3 = this.l;
        canvas.drawRect(com.sigmob.sdk.base.blurkit.c.d, i3 + this.f456c, this.k, i3, this.a);
        float f = this.d;
        canvas.drawRect(((-this.k) * 0.6f) + f, com.sigmob.sdk.base.blurkit.c.d, f, this.l, this.a);
        int i4 = this.k;
        float f2 = this.e;
        canvas.drawRect(i4 + f2, com.sigmob.sdk.base.blurkit.c.d, (i4 * 1.6f) + f2, this.l, this.a);
        this.a.setStyle(Paint.Style.FILL);
        int i5 = this.k;
        int i6 = this.h;
        int i7 = (i5 - i6) / 2;
        int i8 = this.l - this.j;
        if (Build.VERSION.SDK_INT < 21) {
            canvas.drawRect(i7, i8, i7 + i6, i8 + this.i, this.a);
            return;
        }
        float f3 = i7 + i6;
        int i9 = this.i;
        canvas.drawRoundRect(i7, i8, f3, i8 + i9, i9, i9, this.a);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        c();
    }
}
