package com.sigmob.sdk.base.views;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import com.sigmob.sdk.base.views.r;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class k extends h {
    private final Paint a;
    private final float b;

    public k() {
        this(8.0f);
    }

    private k(float f) {
        this.b = f / 2.0f;
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(-1);
        paint.setStrokeWidth(f);
        paint.setStrokeCap(r.a.f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int width = getBounds().width();
        int height = getBounds().height();
        float f = this.b;
        float f2 = height;
        float f3 = width;
        canvas.drawLine(f + com.sigmob.sdk.base.blurkit.c.d, f2 - f, f3 - f, f + com.sigmob.sdk.base.blurkit.c.d, this.a);
        float f4 = this.b;
        canvas.drawLine(f4 + com.sigmob.sdk.base.blurkit.c.d, f4 + com.sigmob.sdk.base.blurkit.c.d, f3 - f4, f2 - f4, this.a);
    }

    @Override // com.sigmob.sdk.base.views.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // com.sigmob.sdk.base.views.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // com.sigmob.sdk.base.views.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }
}
