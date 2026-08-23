package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ah extends View {
    private int a;
    private int b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f451c;
    private Path d;

    public ah(Context context) {
        super(context);
        a();
    }

    public ah(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ah(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
    }

    private void a(Path path, PointF pointF) {
        float tan = (float) (pointF.x - (this.b * Math.tan(2.0943951023931953d)));
        float f = pointF.y;
        int i = this.b;
        float f2 = f + i;
        float tan2 = (float) (pointF.x + (i * Math.tan(2.0943951023931953d)));
        float f3 = pointF.y + this.b;
        path.moveTo(tan, f2);
        path.lineTo(pointF.x, pointF.y);
        path.lineTo(tan2, f3);
    }

    private void b() {
        int width = getWidth();
        int height = getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        this.a = Dips.dipsToIntPixels(5.0f, getContext());
        this.b = height / 2;
        this.d = new Path();
        Paint paint = new Paint(1);
        this.f451c = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f451c.setStrokeWidth(this.a);
        this.f451c.setColor(-1);
        a(this.d, new PointF(width / 2, this.b));
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.d, this.f451c);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        b();
    }
}
