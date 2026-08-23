package com.rtk.app.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyProgress extends ProgressBar {
    private Paint a;
    String b;

    /* renamed from: c, reason: collision with root package name */
    private Canvas f164c;

    public MyProgress(Context context) {
        super(context);
        this.b = "下载";
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        this.a = paint;
        this.f164c = canvas;
        paint.setTextSize(60.0f);
        this.a.setColor(-1);
        this.a.setStrokeWidth(5.0f);
        this.a.setAntiAlias(true);
        setText(this.b);
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i) {
        super.setProgress(i);
    }

    public void setText(String str) {
        this.b = str;
        this.a.getTextBounds(str, 0, str.length(), new Rect());
        Paint.FontMetricsInt fontMetricsInt = this.a.getFontMetricsInt();
        this.f164c.drawText(str, (getWidth() / 2) - (r0.width() / 2), ((getHeight() / 2) - fontMetricsInt.descent) + ((fontMetricsInt.bottom - fontMetricsInt.top) / 2), this.a);
    }

    public MyProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = "下载";
    }

    public MyProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = "下载";
    }
}
