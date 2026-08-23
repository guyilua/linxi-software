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
public class as extends View {
    private Paint a;
    private Path b;

    /* renamed from: c, reason: collision with root package name */
    private int f459c;
    private RectF d;
    private RectF e;
    private RectF f;

    public as(Context context) {
        super(context);
    }

    public as(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public as(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void a() {
        this.a = new Paint();
        this.b = new Path();
        float dipsToIntPixels = Dips.dipsToIntPixels(1.0f, getContext());
        this.a.setStrokeWidth(dipsToIntPixels);
        this.f459c = (int) ((getWidth() / (100.0f * dipsToIntPixels)) * dipsToIntPixels * 20.0f);
        int width = getWidth() - this.f459c;
        int height = getHeight();
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setColor(-1);
        this.a.setAntiAlias(true);
        float f = height;
        float f2 = f / 2.2f;
        this.d = new RectF(this.f459c, f2, width / 2, f - f2);
        float f3 = this.f459c;
        RectF rectF = this.d;
        this.e = new RectF(f3, rectF.top, rectF.right, rectF.bottom);
        float width2 = this.d.right + this.e.width();
        RectF rectF2 = this.d;
        this.f = new RectF(width2, rectF2.top, rectF2.right + rectF2.width() + this.e.width(), this.d.bottom);
    }

    private void a(Canvas canvas, RectF rectF) {
        this.b.reset();
        this.a.setColor(-1);
        this.a.setStyle(Paint.Style.STROKE);
        this.b.addArc(this.e, 90.0f, 180.0f);
        canvas.drawPath(this.b, this.a);
    }

    private void b(Canvas canvas, RectF rectF) {
        this.b.reset();
        this.a.setColor(-1);
        this.a.setStyle(Paint.Style.STROKE);
        this.b.addArc(this.f, 90.0f, -180.0f);
        canvas.drawPath(this.b, this.a);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas, this.d);
        b(canvas, this.d);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a();
    }
}
