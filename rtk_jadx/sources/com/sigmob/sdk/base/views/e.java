package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e extends View {
    private Paint a;
    private Paint b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f465c;
    private Paint d;
    private Path e;
    private Path f;
    private Path g;
    private Path h;
    private RectF i;
    private float j;
    private float k;
    private float l;
    private PointF m;
    private int n;
    private PointF o;
    private PointF p;
    private PathMeasure q;
    private PathMeasure r;
    private float s;
    private Path t;

    public e(Context context) {
        super(context);
        this.s = 0.2f;
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setColor(-3355444);
        this.a.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.b = paint2;
        paint2.setColor(-1);
        this.b.setStyle(Paint.Style.STROKE);
        Paint paint3 = new Paint(1);
        this.f465c = paint3;
        paint3.setColor(-1);
        this.f465c.setStyle(Paint.Style.STROKE);
        Paint paint4 = new Paint(1);
        this.d = paint4;
        paint4.setColor(-3355444);
        this.d.setStyle(Paint.Style.FILL);
        this.t = new Path();
        this.e = new Path();
        this.f = new Path();
        this.g = new Path();
        this.h = new Path();
        this.q = new PathMeasure();
        this.r = new PathMeasure();
        a();
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.s = 0.2f;
        a();
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.s = 0.2f;
        a();
    }

    private void a() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sigmob.sdk.base.views.e.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                e.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                e.this.b();
            }
        });
    }

    private void a(Path path, PointF pointF, PointF pointF2, float f) {
        float f2 = (pointF2.y - pointF.y) / (pointF2.x - pointF.x);
        float f3 = 0.5f * f;
        double d = f2;
        PointF pointF3 = new PointF(pointF2.x + (((float) Math.sin(1.5707963267948966d - Math.atan(d))) * f3), pointF2.y + (((float) Math.cos(1.5707963267948966d - Math.atan(d))) * f3));
        PointF pointF4 = new PointF(pointF2.x - (((float) Math.sin(1.5707963267948966d - Math.atan(d))) * f3), pointF2.y - (f3 * ((float) Math.cos(1.5707963267948966d - Math.atan(d)))));
        double d2 = 1.0f / f2;
        PointF pointF5 = new PointF(pointF4.x - (((float) Math.sin(1.0471975511965976d - Math.atan(d2))) * f), pointF4.y + (f * ((float) Math.cos(1.0471975511965976d - Math.atan(d2)))));
        path.moveTo(pointF3.x, pointF3.y);
        path.lineTo(pointF4.x, pointF4.y);
        path.lineTo(pointF5.x, pointF5.y);
        path.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        int height = getHeight();
        int width = getWidth();
        if (height == 0 || width == 0) {
            return;
        }
        int dipsToIntPixels = Dips.dipsToIntPixels(1.0f, getContext());
        float f = height;
        float f2 = dipsToIntPixels;
        float f3 = f / (100.0f * f2);
        float max = Math.max((int) (f3 * 3.0f * f2), dipsToIntPixels * 2);
        this.j = max;
        this.n = (int) (f3 * (0.4f / f3) * f);
        this.k = 0.7853982f;
        this.l = 3.0f * max;
        this.b.setStrokeWidth(max);
        this.a.setStrokeWidth(this.j);
        this.f465c.setStrokeWidth(this.j);
        float f4 = f / 2.0f;
        float f5 = f4 - ((this.l * f) / this.n);
        this.m = new PointF(width / 2.0f, f4);
        PointF pointF = this.m;
        float f6 = pointF.x;
        float f7 = pointF.y;
        this.i = new RectF(f6 - f5, f7 - f5, f6 + f5, f7 + f5);
        this.o = new PointF(this.m.x - ((float) (Math.cos(this.k) * (this.i.width() / 2.0f))), this.m.y - ((float) (Math.sin(this.k) * (this.i.height() / 2.0f))));
        this.p = new PointF(this.m.x + ((float) (Math.cos(this.k) * (this.i.width() / 2.0f))), this.m.y - ((float) (Math.sin(this.k) * (this.i.height() / 2.0f))));
    }

    private void b(Path path, PointF pointF, PointF pointF2, float f) {
        float f2 = (pointF2.y - pointF.y) / (pointF2.x - pointF.x);
        float f3 = 0.5f * f;
        double d = f2;
        PointF pointF3 = new PointF(pointF2.x + (((float) Math.sin(1.5707963267948966d - Math.atan(d))) * f3), pointF2.y + (((float) Math.cos(1.5707963267948966d - Math.atan(d))) * f3));
        PointF pointF4 = new PointF(pointF2.x - (((float) Math.sin(1.5707963267948966d - Math.atan(d))) * f3), pointF2.y - (f3 * ((float) Math.cos(1.5707963267948966d - Math.atan(d)))));
        double d2 = 1.0f / f2;
        PointF pointF5 = new PointF(pointF4.x + (((float) Math.sin(Math.atan(d2) + 2.0943951023931953d)) * f), pointF4.y + (f * ((float) Math.cos(Math.atan(d2) + 2.0943951023931953d))));
        path.moveTo(pointF3.x, pointF3.y);
        path.lineTo(pointF4.x, pointF4.y);
        path.lineTo(pointF5.x, pointF5.y);
        path.close();
    }

    public void a(float f) {
        this.s = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Paint paint;
        int i;
        super.onDraw(canvas);
        if (this.i == null) {
            return;
        }
        double degrees = Math.toDegrees(this.k);
        float f = (float) (180.0d - (2.0d * degrees));
        canvas.drawArc(this.i, (float) (degrees + 180.0d), f, false, this.a);
        this.e.reset();
        this.e.lineTo(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
        this.t.reset();
        this.t.lineTo(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
        this.e.arcTo(this.i, -90.0f, (-f) / 2.0f, true);
        this.q.setPath(this.e, false);
        this.q.getSegment(com.sigmob.sdk.base.blurkit.c.d, this.q.getLength() * this.s, this.t, true);
        canvas.drawPath(this.t, this.b);
        this.f.reset();
        this.f.lineTo(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
        this.t.reset();
        this.t.lineTo(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
        this.f.arcTo(this.i, -90.0f, f / 2.0f, true);
        this.r.setPath(this.f, false);
        this.r.getSegment(com.sigmob.sdk.base.blurkit.c.d, this.r.getLength() * this.s, this.t, true);
        canvas.drawPath(this.t, this.f465c);
        if (this.s == 1.0f) {
            paint = this.d;
            i = -1;
        } else {
            paint = this.d;
            i = -3355444;
        }
        paint.setColor(i);
        this.g.reset();
        this.g.lineTo(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
        a(this.g, this.m, this.o, this.l);
        canvas.drawPath(this.g, this.d);
        this.h.reset();
        this.h.lineTo(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
        b(this.h, this.m, this.p, this.l);
        canvas.drawPath(this.h, this.d);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }
}
