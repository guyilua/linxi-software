package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class j extends View {
    private static float a;
    private Paint b;

    /* renamed from: c, reason: collision with root package name */
    private Path f474c;
    private PointF d;
    private float e;
    private float f;
    private float g;
    private boolean h;
    private Paint i;

    public j(Context context) {
        super(context);
        a();
    }

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public j(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.b = new Paint();
        this.i = new Paint();
        a = Dips.dipsToIntPixels(6.0f, getContext());
        this.b.setColor(-1);
        this.b.setStrokeWidth(a);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setAntiAlias(true);
        this.i.setAntiAlias(true);
        this.i.setColor(-16777216);
        this.i.setStyle(Paint.Style.FILL);
        this.i.setAlpha(51);
    }

    private void b() {
        double d = 0.62831855f;
        this.e = ((this.f / 2.0f) * ((float) Math.tan(d))) / ((float) Math.sin(d));
        this.d = new PointF(this.f / 2.0f, this.e + Dips.dipsToIntPixels(30.0f, getContext()));
        this.f474c = new Path();
        PointF pointF = this.d;
        float f = pointF.x;
        float f2 = this.e;
        float f3 = pointF.y;
        this.f474c.addArc(new RectF(f - f2, f3 - f2, f + f2, f3 + f2), com.sigmob.sdk.base.blurkit.c.d, -180.0f);
    }

    public void a(boolean z) {
        this.h = z;
    }

    public float getLineWidth() {
        return this.b.getStrokeWidth();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.h) {
            canvas.drawPath(this.f474c, this.i);
        }
        canvas.drawPath(this.f474c, this.b);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f = i;
        this.g = i2;
        b();
    }

    public void setLineWidth(float f) {
        this.b.setStrokeWidth(f);
        invalidate();
    }
}
