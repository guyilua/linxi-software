package com.rtk.app.custom;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.rtk.app.main.MyApplication;

/* compiled from: RoundBackgroundColorSpan.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d extends ReplacementSpan {
    private int a;
    private int b;

    /* renamed from: c, reason: collision with root package name */
    private int f176c;
    private int d;
    private int f = 0;
    private Paint e = new Paint();

    public d(int i, int i2, int i3) {
        this.b = i;
        this.f176c = i2;
        this.d = i3;
    }

    public static int a(int i) {
        return (int) ((i / MyApplication.b().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        this.e.setAntiAlias(true);
        if (this.f == 1) {
            this.e.setColor(this.f176c);
            this.e.setStyle(Paint.Style.STROKE);
        } else {
            this.e.setColor(this.b);
            this.e.setStyle(Paint.Style.FILL);
        }
        float f2 = i4;
        RectF rectF = new RectF(f, (paint.ascent() + f2) - 5.0f, ((int) paint.measureText(charSequence, i, i2)) + 10 + f, ((f2 + paint.descent()) - 10.0f) + 5.0f);
        int i6 = this.d;
        canvas.drawRoundRect(rectF, i6, i6, this.e);
        a((int) paint.getTextSize());
        paint.setTextSize(30.0f);
        paint.setColor(this.f176c);
        canvas.drawText(charSequence, i, i2, f + (((int) (this.a - paint.measureText(charSequence.subSequence(i, i2).toString()))) / 2), i4 - 5, paint);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        int measureText = (int) (paint.measureText(charSequence, i, i2) + 15.0f);
        this.a = measureText;
        return measureText;
    }
}
