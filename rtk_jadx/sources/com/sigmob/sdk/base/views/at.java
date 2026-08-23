package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class at extends View {
    private Paint a;
    private Path b;

    /* renamed from: c, reason: collision with root package name */
    private int f460c;
    private RectF d;
    private RectF e;
    private RectF f;
    private int g;
    private int h;

    public at(Context context) {
        super(context);
    }

    public at(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public at(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void a() {
        this.a = new Paint();
        this.b = new Path();
        int width = getWidth();
        int height = getHeight();
        int dipsToIntPixels = Dips.dipsToIntPixels(1.0f, getContext());
        float f = dipsToIntPixels;
        this.a.setStrokeWidth(f);
        float f2 = width;
        float f3 = f2 / (100.0f * f);
        this.g = (int) (15.0f * f3);
        this.h = (int) (6.0f * f3);
        this.f460c = Math.max((int) (f3 * f * 3.0f), dipsToIntPixels * 2);
        float f4 = height;
        float f5 = 0.4f * f4;
        float f6 = (10.0f * f5) / 16.0f;
        float f7 = (f2 - f6) / 2.0f;
        float f8 = (f4 - f5) / 2.0f;
        this.f = new RectF(f7, f8, f6 + f7, f5 + f8);
        RectF rectF = this.f;
        float f9 = rectF.left;
        int i = this.f460c;
        this.e = new RectF(f9 + i, rectF.top + i, rectF.right - i, rectF.bottom - (i * 3));
        RectF rectF2 = this.f;
        float f10 = rectF2.left;
        float width2 = rectF2.width();
        int i2 = this.f460c;
        float f11 = f10 + ((width2 - (i2 * 2)) / 2.2f);
        RectF rectF3 = this.f;
        this.d = new RectF(f11, rectF3.bottom - (i2 * 2), rectF3.right - ((rectF3.width() - (r6 * 2)) / 2.2f), this.f.bottom - this.f460c);
    }

    private void a(Canvas canvas) {
        this.b.reset();
        this.a.setColor(-1);
        this.a.setStyle(Paint.Style.FILL);
        Path path = this.b;
        RectF rectF = this.f;
        int i = this.g;
        path.addRoundRect(rectF, i, i, Path.Direction.CW);
        Path path2 = this.b;
        RectF rectF2 = this.e;
        int i2 = this.h;
        path2.addRoundRect(rectF2, i2, i2, Path.Direction.CCW);
        Path path3 = this.b;
        RectF rectF3 = this.d;
        int i3 = this.h;
        path3.addRoundRect(rectF3, i3, i3, Path.Direction.CCW);
        this.b.close();
        canvas.drawPath(this.b, this.a);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a();
    }
}
