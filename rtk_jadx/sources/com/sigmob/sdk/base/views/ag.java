package com.sigmob.sdk.base.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ag extends View {
    private Paint a;
    private RectF b;

    /* renamed from: c, reason: collision with root package name */
    private float f450c;
    private String d;
    private Paint e;
    private Path f;
    private Paint g;
    private Path h;
    private int i;
    private int j;
    private int k;
    private float l;
    private int m;
    private int n;
    private int o;
    private int p;
    private ValueAnimator q;
    private ValueAnimator r;
    private String title;

    public ag(Context context) {
        super(context);
        this.l = 1.0f;
        a();
    }

    public ag(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = 1.0f;
        a();
    }

    public ag(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = 1.0f;
        a();
    }

    private int a(int i, float f) {
        return Color.argb((int) (Color.alpha(i) * f), Color.red(i), Color.green(i), Color.blue(i));
    }

    private void a() {
        setBackgroundColor(-65536);
        this.a = new Paint(1);
        this.e = new Paint(1);
        this.b = new RectF();
        this.h = new Path();
        this.f450c = Dips.dipsToIntPixels(2.0f, getContext());
        setBackgroundColor(0);
    }

    private void b() {
        ValueAnimator valueAnimator = this.q;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(-this.k, this.m + this.n);
        this.q = ofInt;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.ag.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ag.this.i = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                ag.this.d();
                ag.this.invalidate();
            }
        });
        this.q.setDuration(800L);
        this.q.setRepeatCount(-1);
        this.q.setRepeatMode(1);
        this.q.start();
        ValueAnimator valueAnimator2 = this.r;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.15f);
        this.r = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.ag.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                ag.this.l = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
            }
        });
        this.r.setDuration(1000L);
        this.r.setRepeatCount(-1);
        this.r.setRepeatMode(2);
        this.r.start();
    }

    private void c() {
        this.f = new Path();
        this.g = new Paint();
        this.j = this.n;
        this.k = Dips.dipsToIntPixels(60.0f, getContext());
        this.g.setShader(new LinearGradient(com.sigmob.sdk.base.blurkit.c.d, this.j, this.k, com.sigmob.sdk.base.blurkit.c.d, new int[]{a(-1, 0.2f), a(-1, 0.5f), a(-1, 0.2f)}, new float[]{0.2f, 0.8f, 1.0f}, Shader.TileMode.MIRROR));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.f.reset();
        this.f.moveTo((this.k / 2.0f) + this.i, com.sigmob.sdk.base.blurkit.c.d);
        this.f.lineTo(this.k + this.i, com.sigmob.sdk.base.blurkit.c.d);
        this.f.lineTo((this.k / 2.0f) + this.i, this.j);
        this.f.lineTo(this.i + 0, this.j);
        this.f.close();
    }

    public void a(String str, String str2) {
        this.title = str;
        this.d = str2;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.q;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.r;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setColor(-1);
        this.a.setAlpha(204);
        this.a.setStrokeWidth(this.f450c);
        RectF rectF = this.b;
        float f2 = this.f450c;
        rectF.set(f2, f2, this.m - (f2 * 2.0f), this.n - (f2 * 2.0f));
        Path path = this.h;
        RectF rectF2 = this.b;
        int i = this.p;
        path.addRoundRect(rectF2, i, i, Path.Direction.CCW);
        canvas.drawPath(this.h, this.a);
        this.a.setStyle(Paint.Style.FILL);
        this.a.setColor(-16777216);
        this.a.setAlpha(76);
        this.h.reset();
        Path path2 = this.h;
        RectF rectF3 = this.b;
        path2.addRoundRect(rectF3, rectF3.height() / 2.0f, this.b.height() / 2.0f, Path.Direction.CCW);
        canvas.drawPath(this.h, this.a);
        int i2 = this.n;
        float f3 = i2 * 0.3f * this.l;
        float f4 = this.m - ((i2 * 0.3f) * 2.0f);
        this.a.setColor(-1);
        this.a.setStyle(Paint.Style.FILL);
        canvas.drawCircle(f4, this.n / 2, f3, this.a);
        this.a.setColor(-16777216);
        this.a.setTextSize(TypedValue.applyDimension(2, this.l * 16.0f, getResources().getDisplayMetrics()));
        this.a.setTypeface(Typeface.DEFAULT_BOLD);
        float measureText = f4 - (this.a.measureText("GO") / 1.5f);
        canvas.drawText("GO", measureText, ((this.n / 2) + ((this.a.getFontMetrics().bottom - this.a.getFontMetrics().top) / 2.0f)) - this.a.getFontMetrics().bottom, this.a);
        float measureText2 = this.a.measureText("GO") * 0.4f;
        Path path3 = new Path();
        float f5 = measureText2 / 4.0f;
        float f6 = measureText2 / 2.0f;
        path3.moveTo(this.a.measureText("GO") + measureText + f5, (this.n / 2) - f6);
        path3.lineTo(this.a.measureText("GO") + measureText + measureText2, this.n / 2);
        path3.lineTo(measureText + this.a.measureText("GO") + f5, (this.n / 2) + f6);
        path3.close();
        canvas.drawPath(path3, this.a);
        this.e.setStyle(Paint.Style.FILL);
        this.e.setColor(-1);
        int i3 = 5;
        if (TextUtils.isEmpty(this.title)) {
            f = com.sigmob.sdk.base.blurkit.c.d;
        } else {
            this.e.setTextSize(TypedValue.applyDimension(2, 20.0f, getResources().getDisplayMetrics()));
            this.e.setTypeface(Typeface.DEFAULT_BOLD);
            String str = this.title;
            f = (this.e.getFontMetrics().bottom - this.e.getFontMetrics().top) * 1.5f;
            int i4 = 5;
            while (true) {
                if (i4 >= this.title.length()) {
                    break;
                }
                float measureText3 = this.e.measureText(this.title, 0, i4) + f;
                RectF rectF4 = this.b;
                if (measureText3 > ((rectF4.right - rectF4.left) - f) - f3) {
                    str = this.title.substring(0, i4 - 2) + "...";
                    break;
                }
                i4++;
            }
            canvas.drawText(str, f, ((this.n / 2) - (this.e.getFontMetrics().bottom - this.e.getFontMetrics().top)) - this.e.getFontMetrics().top, this.e);
        }
        if (!TextUtils.isEmpty(this.d)) {
            this.e.setTextSize(TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics()));
            this.e.setTypeface(Typeface.DEFAULT);
            float f7 = f > com.sigmob.sdk.base.blurkit.c.d ? f : (this.e.getFontMetrics().bottom - this.e.getFontMetrics().top) * 1.5f;
            String str2 = this.d;
            while (true) {
                if (i3 >= this.d.length()) {
                    break;
                }
                float measureText4 = this.e.measureText(this.d, 0, i3) + f;
                RectF rectF5 = this.b;
                if (measureText4 > ((rectF5.right - rectF5.left) - f) - f3) {
                    str2 = this.d.substring(0, i3 - 2) + "...";
                    break;
                }
                i3++;
            }
            canvas.drawText(str2, f7, (this.n / 2) + (this.e.getFontMetrics().bottom - this.e.getFontMetrics().top), this.e);
        }
        canvas.clipPath(this.h);
        canvas.drawPath(this.f, this.g);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.m = i;
        this.n = (int) (i2 * 0.8f);
        this.o = i / 2;
        this.p = i2 / 2;
        c();
        b();
    }
}
