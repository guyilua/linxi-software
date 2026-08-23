package com.rtk.app.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class YcProgressBarAddText extends ProgressBar {
    private Paint a;
    private int b;

    public YcProgressBarAddText(Context context) {
        super(context);
        b(context, null);
    }

    private void a(int i) {
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(i);
        this.a.setTextSize(50.0f);
        this.a.setAntiAlias(true);
    }

    public void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.YcProgressBarAddText);
        if (obtainStyledAttributes != null) {
            a(obtainStyledAttributes.getColor(0, -1));
            this.b = obtainStyledAttributes.getInt(0, 0);
        }
        invalidate();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        String str;
        super.onDraw(canvas);
        Paint.FontMetricsInt fontMetricsInt = this.a.getFontMetricsInt();
        int i = this.b;
        if (i != 1) {
            str = i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 11 ? "下载" : "等待中..." : "解压中" : "打开" : "安装" : "继续";
        } else {
            str = ((getProgress() * 100) / getMax()) + "%";
        }
        int measuredWidth = (((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - ((int) this.a.measureText(str))) / 2;
        int i2 = (fontMetricsInt.descent + fontMetricsInt.ascent) / 2;
        this.a.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(str, com.sigmob.sdk.base.blurkit.c.d, -20.0f, this.a);
    }

    public void setState(int i) {
        this.b = i;
    }

    public YcProgressBarAddText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    public YcProgressBarAddText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet);
    }
}
