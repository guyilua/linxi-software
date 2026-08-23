package com.sigmob.sdk.base.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.views.r;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class y extends h {
    private final Paint a;
    private final Paint b;

    /* renamed from: c, reason: collision with root package name */
    private int f489c;
    private int d;
    private int e;
    private int f;
    private float g;
    private final int h;

    public y(Context context) {
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(-1);
        paint.setAlpha(128);
        paint.setStyle(r.b.e);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setColor(r.b.f);
        paint2.setAlpha(255);
        paint2.setStyle(r.b.h);
        paint2.setAntiAlias(true);
        this.h = Dips.dipsToIntPixels(4.0f, context);
    }

    private void d() {
        this.e = this.f489c;
    }

    public void a() {
        this.f = 0;
    }

    @SuppressLint({"DefaultLocale"})
    public void a(int i) {
        int i2 = this.f;
        if (i >= i2) {
            this.e = i;
            this.f = i;
        } else if (i != 0) {
            SigmobLog.d(String.format("Progress not monotonically increasing: last = %d, current = %d", Integer.valueOf(i2), Integer.valueOf(i)));
            d();
        }
        invalidateSelf();
    }

    public void a(int i, int i2) {
        this.f489c = i;
        this.d = i2;
        this.g = i > 0 ? i2 / i : com.sigmob.sdk.base.blurkit.c.d;
    }

    @Deprecated
    public float b() {
        return this.g;
    }

    @Deprecated
    public int c() {
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawRect(getBounds(), this.a);
        int i = this.f489c;
        canvas.drawRect(getBounds().left, getBounds().top, getBounds().right * (i > 0 ? this.e / i : com.sigmob.sdk.base.blurkit.c.d), getBounds().bottom, this.b);
        int i2 = this.d;
        if (i2 <= 0 || i2 >= this.f489c) {
            return;
        }
        float f = getBounds().right * this.g;
        canvas.drawRect(f, getBounds().top, f + this.h, getBounds().bottom, this.b);
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
