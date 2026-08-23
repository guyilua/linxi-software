package com.rtk.app.custom;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;

/* compiled from: RoundBackgroundColorSpanToUser.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e extends ReplacementSpan {
    private int a;
    private int b;

    /* renamed from: c, reason: collision with root package name */
    private int f177c;
    private int d;

    public e(int i, int i2) {
        this.f177c = 5;
        this.d = 5;
        this.a = i;
        this.b = i2;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        int color = paint.getColor();
        paint.setColor(this.a);
        canvas.drawRoundRect(new RectF(f, i3 + 1, ((int) paint.measureText(charSequence, i, i2)) + 20 + f, i5 - 1), this.f177c, this.d, paint);
        paint.setColor(this.b);
        canvas.drawText(charSequence, i, i2, f + 10.0f, i4, paint);
        paint.setColor(color);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return ((int) paint.measureText(charSequence, i, i2)) + 30;
    }

    public e(int i, int i2, int i3, int i4) {
        this.f177c = 5;
        this.d = 5;
        this.a = i;
        this.b = i2;
        this.f177c = i3;
        this.d = i4;
    }
}
