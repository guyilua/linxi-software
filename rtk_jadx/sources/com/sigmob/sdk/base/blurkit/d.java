package com.sigmob.sdk.base.blurkit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d extends ImageView {
    public static final int a = -16777216;
    public static final int b = 0;

    /* renamed from: c, reason: collision with root package name */
    private float f351c;
    private RectF d;
    private PorterDuffXfermode e;

    public d(Context context) {
        super(context, null);
        this.f351c = c.d;
        this.d = new RectF();
        this.e = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f351c = c.d;
        this.d = new RectF();
        this.e = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    }

    public float getCornerRadius() {
        return this.f351c;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable) || this.f351c <= c.d) {
            super.onDraw(canvas);
            return;
        }
        this.d.set(drawable.getBounds());
        int saveLayer = canvas.saveLayer(this.d, null, 31);
        getImageMatrix().mapRect(this.d);
        Paint paint = ((BitmapDrawable) drawable).getPaint();
        paint.setAntiAlias(true);
        paint.setColor(-16777216);
        Xfermode xfermode = paint.getXfermode();
        canvas.drawARGB(0, 0, 0, 0);
        RectF rectF = this.d;
        float f = this.f351c;
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(this.e);
        super.onDraw(canvas);
        paint.setXfermode(xfermode);
        canvas.restoreToCount(saveLayer);
    }

    public void setCornerRadius(float f) {
        this.f351c = f;
    }
}
