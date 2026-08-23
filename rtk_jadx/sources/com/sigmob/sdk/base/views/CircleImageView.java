package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CircleImageView extends ImageView {
    protected float a;
    protected boolean b;

    /* renamed from: c, reason: collision with root package name */
    private BitmapShader f440c;
    private float d;
    private float e;
    private Paint f;
    private Matrix g;
    private RectF h;

    public CircleImageView(Context context) {
        this(context, null);
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = false;
        Paint paint = new Paint();
        this.f = paint;
        paint.setAntiAlias(true);
        this.g = new Matrix();
        this.a = TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics());
    }

    private BitmapShader a() {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getDrawable();
        if (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) {
            return null;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        float max = Math.max(this.d / bitmap.getWidth(), this.d / bitmap.getHeight());
        this.g.setScale(max, max);
        bitmapShader.setLocalMatrix(this.g);
        return bitmapShader;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        BitmapShader a = a();
        this.f440c = a;
        if (a == null) {
            super.onDraw(canvas);
            return;
        }
        this.f.setShader(a);
        if (this.b) {
            float f = this.d;
            canvas.drawCircle(f / 2.0f, f / 2.0f, f / 2.0f, this.f);
        } else {
            RectF rectF = this.h;
            float f2 = this.a;
            canvas.drawRoundRect(rectF, f2, f2, this.f);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.d = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        this.e = measuredHeight;
        this.d = Math.min(this.d, measuredHeight);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.h = new RectF(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d, getHeight(), getHeight());
    }

    public void setCircle(boolean z) {
        this.b = z;
    }
}
