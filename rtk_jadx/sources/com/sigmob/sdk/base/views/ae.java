package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ae extends View {
    private Paint a;
    private RectF b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f448c;
    private int d;
    private int e;
    private int f;

    public ae(Context context) {
        super(context);
        this.e = 15;
    }

    public ae(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 15;
    }

    public ae(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 15;
    }

    private void a() {
        Paint paint = new Paint();
        this.a = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.a.setColor(-1);
        int asIntPixels = Dips.asIntPixels(1.0f, getContext());
        this.f = asIntPixels;
        this.a.setStrokeWidth(asIntPixels);
        this.a.setAlpha(127);
        Paint paint2 = new Paint();
        this.f448c = paint2;
        paint2.setColor(-1);
        this.f448c.setStyle(Paint.Style.FILL);
        this.f448c.setTextSize(TypedValue.applyDimension(2, 12.0f, getResources().getDisplayMetrics()));
        this.d = Dips.asIntPixels(10.0f, getContext());
        int i = this.f;
        this.b = new RectF(i, i, getWidth() - this.f, getHeight() - this.f);
    }

    public void a(int i) {
        this.e = i;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String valueOf;
        int i;
        super.onDraw(canvas);
        this.a.setStyle(Paint.Style.FILL);
        this.a.setColor(-16777216);
        this.a.setAlpha(127);
        RectF rectF = this.b;
        float f = rectF.right;
        canvas.drawRoundRect(rectF, f / 2.0f, f / 2.0f, this.a);
        canvas.drawText("跳过", this.d, ((this.b.bottom / 2.0f) + ((this.f448c.getFontMetrics().bottom - this.f448c.getFontMetrics().top) / 2.0f)) - this.f448c.getFontMetrics().bottom, this.f448c);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setColor(-1);
        int asIntPixels = Dips.asIntPixels(1.0f, getContext());
        this.f = asIntPixels;
        this.a.setStrokeWidth(asIntPixels);
        this.a.setAlpha(127);
        RectF rectF2 = this.b;
        float f2 = rectF2.right;
        canvas.drawRoundRect(rectF2, f2 / 2.0f, f2 / 2.0f, this.a);
        float measureText = this.d + this.f448c.measureText("跳过") + (this.d / 2);
        int i2 = this.f;
        canvas.drawLine(measureText + (i2 * 2), i2 * 2, measureText + (i2 * 2), this.b.bottom - (i2 * 2), this.a);
        int i3 = this.e;
        if (i3 > 9) {
            valueOf = String.valueOf(i3);
            i = this.d / 2;
        } else {
            valueOf = String.valueOf(i3);
            i = this.d;
        }
        canvas.drawText(valueOf, measureText + i, ((this.b.bottom / 2.0f) + ((this.f448c.getFontMetrics().bottom - this.f448c.getFontMetrics().top) / 2.0f)) - this.f448c.getFontMetrics().bottom, this.f448c);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a();
    }
}
