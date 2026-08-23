package com.sigmob.sdk.base.views;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class aj extends View {
    private Paint a;
    private Paint b;

    /* renamed from: c, reason: collision with root package name */
    private RectF f453c;
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
    private float q;
    private PointF r;
    private float s;
    private float t;

    public aj(Context context) {
        super(context);
        this.e = com.sigmob.sdk.base.blurkit.c.d;
        this.g = 1.0f;
    }

    public aj(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = com.sigmob.sdk.base.blurkit.c.d;
        this.g = 1.0f;
    }

    public aj(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = com.sigmob.sdk.base.blurkit.c.d;
        this.g = 1.0f;
    }

    private void a() {
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setColor(-1);
        this.a.setStyle(Paint.Style.STROKE);
        float dipsToIntPixels = Dips.dipsToIntPixels(1.0f, getContext());
        this.g = dipsToIntPixels;
        this.a.setStrokeWidth((this.m / (dipsToIntPixels * 100.0f)) * 3.0f * dipsToIntPixels);
        Paint paint2 = new Paint(1);
        this.b = paint2;
        paint2.setColor(Color.parseColor("#B7B7B7"));
        this.b.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.h = paint3;
        paint3.setColor(-1);
        this.h.setStyle(Paint.Style.FILL);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(92.0f, getContext());
        int i = this.m;
        float f = (i * 1.0f) / dipsToIntPixels2;
        this.s = f;
        float f2 = this.g;
        this.i = f * (i / (100.0f * f2)) * 11.0f * f2;
        this.f453c = new RectF();
        this.d = new RectF();
        this.j = new PointF(getWidth() / 2, this.g * 15.0f);
        this.r = new PointF(getWidth() / 2, this.i + (this.g * 15.0f));
        this.k = new Path();
        Paint paint4 = new Paint(1);
        this.l = paint4;
        paint4.setStyle(Paint.Style.FILL);
        this.l.setColor(-1);
        float f3 = this.m - (this.i * 3.0f);
        float f4 = this.g;
        float f5 = f3 - ((15.0f * f4) * 2.0f);
        this.o = f5;
        this.p = (f5 / 60.0f) * 55.0f;
        this.q = f4 * 2.0f;
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
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.aj.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                aj.this.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ofFloat.setDuration(2000L);
        ofFloat.start();
    }

    public void a(float f) {
        if (this.l != null) {
            float max = Math.max(com.sigmob.sdk.base.blurkit.c.d, f);
            this.e = max;
            float min = Math.min(1.0f, max);
            this.e = min;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "rotationX", min * 40.0f, f * 40.0f);
            ofFloat.setDuration(50L);
            ofFloat.start();
            this.l.setAlpha((int) (this.e * 255.0f));
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.a == null) {
            return;
        }
        this.k.reset();
        a(this.k, this.j);
        canvas.drawPath(this.k, this.l);
        this.k.reset();
        a(this.k, this.r);
        canvas.drawPath(this.k, this.l);
        float f = this.n / 2;
        float f2 = this.p;
        float f3 = f - (f2 / 2.0f);
        float f4 = this.m;
        float f5 = this.o;
        float f6 = this.q;
        float f7 = this.g;
        float f8 = ((f4 - f5) - f6) - (15.0f * f7);
        this.f453c.set(f3 + f6, f8, (f2 + f3) - f6, f5 + f8 + f7);
        RectF rectF = this.f453c;
        float f9 = this.q;
        canvas.drawRoundRect(rectF, f9, f9, this.a);
        float f10 = this.e;
        float f11 = f10 > 0.98f ? this.g : this.g + ((1.0f - f10) * this.o);
        Log.d("", "onDraw: " + f11);
        float f12 = f11 + f8;
        float f13 = this.f453c.bottom;
        float f14 = this.g;
        if (f12 >= f13 - f14) {
            f12 = f13 - f14;
        }
        this.d.set(this.q + f3, f12, (f3 + this.p) - (f14 * 2.0f), f13);
        canvas.drawRect(this.d, this.b);
        float min = Math.min(this.s * Dips.dipsToIntPixels(3.0f, getContext()), this.g * 2.0f);
        float f15 = this.p;
        float f16 = f15 > com.sigmob.sdk.base.blurkit.c.d ? f15 / 5.0f : this.g * 3.0f;
        float f17 = (this.n - f16) / 2.0f;
        float f18 = this.o;
        float f19 = (f8 + f18) - (f18 / 4.0f);
        canvas.drawRect(f17, f19, f17 + f16, f19 + min, this.h);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.m = i2;
        this.n = i;
        a();
    }
}
