package com.ss.android.downloadlib.guide.install;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.sigmob.sdk.base.blurkit.c;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ClipImageView extends ImageView {
    private boolean a;
    private Path b;

    /* renamed from: c, reason: collision with root package name */
    private RectF f782c;
    private Paint d;
    private float[] e;

    public ClipImageView(Context context) {
        super(context);
        this.a = true;
        a(context);
    }

    protected void a(Context context) {
        this.b = new Path();
        this.f782c = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.a) {
            this.b.reset();
            this.f782c.set(c.d, c.d, getWidth(), getHeight());
            float[] fArr = this.e;
            if (fArr != null) {
                this.b.addRoundRect(this.f782c, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.b);
            Paint paint = this.d;
            if (paint != null) {
                canvas.drawPath(this.b, paint);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Paint paint = new Paint(1);
        this.d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.d.setColor(i);
    }

    public void setClip(boolean z) {
        this.a = z;
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.e = fArr;
    }

    public void setRoundRadius(int i) {
        if (i > 0) {
            float f = i;
            setRadius(new float[]{f, f, f, f, f, f, f, f});
        }
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
        a(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = true;
        a(context);
    }
}
