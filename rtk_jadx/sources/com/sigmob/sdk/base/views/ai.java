package com.sigmob.sdk.base.views;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ai extends View {
    private float a;
    private Paint b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f452c;
    private Paint d;
    private Path e;
    private Path f;
    private Path g;
    private PointF h;
    private PointF i;
    private PointF j;
    private float k;

    public ai(Context context) {
        super(context);
        b();
    }

    public ai(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public ai(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    private AnimatorSet a(final PointF pointF, final Paint paint, int i) {
        int alpha = paint.getAlpha();
        float f = pointF.y;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, (f - getHeight()) - this.a);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.ai.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                pointF.y = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ai.this.c();
                ai.this.invalidate();
            }
        });
        ofFloat.setRepeatCount(-1);
        ValueAnimator ofInt = ValueAnimator.ofInt(alpha, 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.ai.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                paint.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                ai.this.invalidate();
            }
        });
        ofInt.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(i * 1000);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.playTogether(ofFloat, ofInt);
        return animatorSet;
    }

    private void a(Path path, PointF pointF) {
        float tan = (float) (pointF.x - (this.k * Math.tan(2.0943951023931953d)));
        float f = pointF.y;
        float f2 = this.k;
        float f3 = f + f2;
        float tan2 = (float) (pointF.x + (f2 * Math.tan(2.0943951023931953d)));
        float f4 = pointF.y + this.k;
        path.moveTo(tan, f3);
        path.lineTo(pointF.x, pointF.y);
        path.lineTo(tan2, f4);
    }

    private void b() {
        float dipsToIntPixels = Dips.dipsToIntPixels(5.0f, getContext());
        this.a = dipsToIntPixels;
        this.k = dipsToIntPixels * 2.0f;
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.b.setStrokeWidth(this.a);
        this.b.setColor(-1);
        this.b.setAlpha(255);
        Paint paint2 = new Paint(1);
        this.f452c = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f452c.setStrokeWidth(this.a);
        this.f452c.setColor(-1);
        this.f452c.setAlpha(127);
        Paint paint3 = new Paint(1);
        this.d = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        this.d.setStrokeWidth(this.a);
        this.d.setColor(-1);
        this.d.setAlpha(76);
        this.e = new Path();
        this.f = new Path();
        this.g = new Path();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.e.reset();
        this.f.reset();
        this.g.reset();
        a(this.e, this.h);
        a(this.f, this.i);
        a(this.g, this.j);
    }

    public void a() {
        AnimatorSet a = a(this.h, this.b, 2);
        AnimatorSet a2 = a(this.i, this.f452c, 2);
        AnimatorSet a3 = a(this.j, this.d, 2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(a, a2, a3);
        animatorSet.start();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.e, this.b);
        canvas.drawPath(this.f, this.f452c);
        canvas.drawPath(this.g, this.d);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i / 2.0f;
        float f2 = i2;
        float dipsToIntPixels = Dips.dipsToIntPixels(13.0f, getContext());
        this.h = new PointF(f, this.a + f2);
        this.i = new PointF(f, this.a + f2 + dipsToIntPixels);
        this.j = new PointF(f, f2 + this.a + (dipsToIntPixels * 2.0f));
        c();
        a();
    }
}
