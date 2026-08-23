package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class p extends View {
    private Paint a;
    private Path b;

    public p(Context context) {
        super(context);
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setColor(-12303292);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(3.0f);
        this.a.setPathEffect(new DashPathEffect(new float[]{10.0f, 5.0f}, com.sigmob.sdk.base.blurkit.c.d));
        this.b = new Path();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.b.reset();
        getHeight();
        getWidth();
        this.b.moveTo(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
        this.b.lineTo(com.sigmob.sdk.base.blurkit.c.d, getHeight());
        canvas.drawPath(this.b, this.a);
    }
}
