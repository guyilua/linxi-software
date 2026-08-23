package com.sigmob.sdk.base.views;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class al extends View {
    private Paint a;
    private Paint b;

    /* renamed from: c, reason: collision with root package name */
    private RectF f455c;
    private RectF d;
    private float e;
    private Float f;
    private float g;
    private Paint h;
    private float i;
    private PointF j;
    private Path k;
    private Paint l;
    private int m;
    private int n;
    private float o;
    private float p;
    private PointF q;
    private float r;
    private float s;

    public al(Context context) {
        super(context);
        this.e = com.sigmob.sdk.base.blurkit.c.d;
        this.g = 3.0f;
        a(context);
    }

    public al(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = com.sigmob.sdk.base.blurkit.c.d;
        this.g = 3.0f;
        a(context);
    }

    public al(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = com.sigmob.sdk.base.blurkit.c.d;
        this.g = 3.0f;
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.a == null) {
            Paint paint = new Paint(1);
            this.a = paint;
            paint.setColor(-1);
            this.a.setStyle(Paint.Style.STROKE);
            float dipsToIntPixels = Dips.dipsToIntPixels(this.g, getContext());
            this.g = dipsToIntPixels;
            this.a.setStrokeWidth(dipsToIntPixels);
            Paint paint2 = new Paint(1);
            this.b = paint2;
            paint2.setColor(-3355444);
            this.b.setStyle(Paint.Style.FILL);
            Paint paint3 = new Paint(1);
            this.h = paint3;
            paint3.setColor(-1);
            this.h.setStyle(Paint.Style.FILL);
            float dipsToIntPixels2 = (this.m * 1.0f) / Dips.dipsToIntPixels(92.0f, getContext());
            this.r = dipsToIntPixels2;
            this.i = dipsToIntPixels2 * Dips.dipsToIntPixels(11.0f, getContext());
            this.f455c = new RectF();
            this.d = new RectF();
            this.j = new PointF(getWidth() / 2, com.sigmob.sdk.base.blurkit.c.d);
            this.q = new PointF(getWidth() / 2, this.i);
            this.k = new Path();
            Paint paint4 = new Paint(1);
            this.l = paint4;
            paint4.setStyle(Paint.Style.FILL);
            this.l.setColor(-1);
            this.o = this.m - (this.i * 3.0f);
            this.p = this.g / 2.0f;
        }
    }

    private void a(Context context) {
        com.sigmob.sdk.base.utils.f.a(this, new Runnable() { // from class: com.sigmob.sdk.base.views.al.1
            @Override // java.lang.Runnable
            public void run() {
                al.this.a();
            }
        });
    }

    private void a(Path path, PointF pointF) {
        float tan = (float) (pointF.x - (this.i * Math.tan(0.7853981633974483d)));
        float f = pointF.y;
        float f2 = this.i;
        float f3 = f + f2;
        float tan2 = (float) (pointF.x + (f2 * Math.tan(0.7853981633974483d)));
        float f4 = pointF.y + this.i;
        path.moveTo(tan, f3);
        path.lineTo(pointF.x, pointF.y);
        path.lineTo(tan2, f4);
        path.lineTo(pointF.x, pointF.y + (this.i / 2.0f));
        path.close();
    }

    private void b() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(com.sigmob.sdk.base.blurkit.c.d, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.al.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                al.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ofFloat.setDuration(2000L);
        ofFloat.start();
    }

    public void a(float f) {
        if (this.l == null) {
            return;
        }
        float max = Math.max(0.2f, f);
        this.e = max;
        float min = Math.min(1.0f, max);
        this.e = min;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "rotationX", min * 40.0f, f * 40.0f);
        ofFloat.setDuration(50L);
        ofFloat.start();
        this.l.setAlpha((int) (this.e * 255.0f));
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.l == null) {
            return;
        }
        this.k.reset();
        a(this.k, this.j);
        canvas.drawPath(this.k, this.l);
        this.k.reset();
        a(this.k, this.q);
        canvas.drawPath(this.k, this.l);
        float f = this.g;
        float f2 = this.m;
        float f3 = this.o;
        float f4 = this.p;
        float f5 = (f2 - f3) - f4;
        this.f455c.set(f, f5, this.n - f, (f3 + f5) - (f4 * 2.0f));
        RectF rectF = this.f455c;
        float f6 = this.p;
        canvas.drawRoundRect(rectF, f6, f6, this.a);
        float f7 = this.e;
        float f8 = f7 > 0.98f ? this.g - this.p : this.g + ((1.0f - f7) * this.o);
        Log.d("", "onDraw: " + f8);
        float f9 = f8 + f5;
        float f10 = this.o;
        float f11 = this.g;
        float f12 = f5 + f10 + f11;
        if (this.e > 0.2f) {
            f12 = (f10 + f5) - f11;
        }
        this.d.set(f + this.p, f9, this.n - f11, f12);
        canvas.drawRect(this.d, this.b);
        float min = Math.min(this.r * Dips.dipsToIntPixels(3.0f, getContext()), this.g);
        int i = this.n;
        float f13 = i > 0 ? i / 5 : this.g;
        float f14 = (i - f13) / 2.0f;
        float f15 = ((f5 + this.o) - min) - this.g;
        canvas.drawRect(f14, f15, f14 + f13, f15 + min, this.h);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.m = i2;
        this.n = i;
        a();
    }
}
