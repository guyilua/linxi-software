package com.rtk.app.custom.CricularTool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CircleImageView extends ImageView {
    private Paint a;
    private int b;

    /* renamed from: c, reason: collision with root package name */
    private float f153c;

    public CircleImageView(Context context) {
        super(context);
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        this.a = new Paint();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            this.f153c = (this.b * 2.0f) / Math.min(bitmap.getHeight(), bitmap.getWidth());
            Matrix matrix = new Matrix();
            float f = this.f153c;
            matrix.setScale(f, f);
            bitmapShader.setLocalMatrix(matrix);
            this.a.setShader(bitmapShader);
            int i = this.b;
            canvas.drawCircle(i, i, i, this.a);
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int min = Math.min(getMeasuredWidth(), getMeasuredHeight());
        this.b = min / 2;
        setMeasuredDimension(min, min);
    }

    public CircleImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircleImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
