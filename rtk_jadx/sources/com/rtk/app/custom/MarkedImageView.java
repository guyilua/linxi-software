package com.rtk.app.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.rtk.app.tool.h;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MarkedImageView extends ImageView {
    private Paint a;
    private Paint b;

    /* renamed from: c, reason: collision with root package name */
    private int f160c;
    private boolean d;
    private Context e;
    private int f;
    private float g;
    private int h;

    public MarkedImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String str = this.f160c + "";
        Rect rect = new Rect();
        this.b.getTextBounds(str, 0, str.length(), rect);
        int height = rect.height();
        if (this.d) {
            return;
        }
        int i = this.f160c;
        if (i > 0 && i < 100) {
            float measuredWidth = getMeasuredWidth();
            float f = this.g;
            canvas.drawCircle(measuredWidth - (f * 2.0f), this.f + f, f, this.a);
            String str2 = this.f160c + "";
            float measuredWidth2 = getMeasuredWidth();
            float f2 = this.g;
            canvas.drawText(str2, measuredWidth2 - (2.0f * f2), f2 + (height / 2) + this.f, this.b);
            return;
        }
        if (i > 99) {
            float measuredWidth3 = getMeasuredWidth() - (this.g * 2.0f);
            float f3 = this.f;
            float measuredWidth4 = getMeasuredWidth();
            float f4 = this.g;
            RectF rectF = new RectF(measuredWidth3, f3, measuredWidth4 + (com.sigmob.sdk.base.blurkit.c.d * f4), (f4 * 2.0f) + this.f);
            float f5 = this.g;
            canvas.drawRoundRect(rectF, f5, f5, this.a);
            float measuredWidth5 = getMeasuredWidth();
            float f6 = this.g;
            canvas.drawText("99+", measuredWidth5 - (2.0f * f6), f6 + (height / 2) + this.f, this.b);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setIsHideMessageMark(boolean z) {
        this.d = z;
        invalidate();
    }

    public void setMessageNumber(int i) {
        this.f160c = i;
        invalidate();
    }

    public MarkedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MarkedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = false;
        this.e = context;
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setColor(Color.parseColor("#FF4400"));
        Paint paint2 = new Paint(1);
        this.b = paint2;
        paint2.setColor(-1);
        this.b.setTextAlign(Paint.Align.CENTER);
        this.f = h.a(5.0f, this.e);
        this.g = h.a(6.0f, this.e);
        int a = h.a(8.0f, this.e);
        this.h = a;
        this.b.setTextSize(a);
    }
}
