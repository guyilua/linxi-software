package com.sigmob.sdk.base.views;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ab extends Drawable {
    private static final int i = 1;
    private final Paint a;
    private final int b;

    /* renamed from: c, reason: collision with root package name */
    private final int f444c;
    private final int d;
    private final int e;
    private final int f;
    private final int[] g;
    private RectF h;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        private int a = 1;
        private int b = 12;

        /* renamed from: c, reason: collision with root package name */
        private int f445c = Color.parseColor("#4d000000");
        private int d = 18;
        private int e;
        private int f;
        private int[] g;

        a() {
            this.e = 0;
            this.f = 0;
            this.e = 0;
            this.f = 0;
            this.g = r1;
            int[] iArr = {0};
        }

        a a(int i) {
            this.a = i;
            return this;
        }

        a a(int[] iArr) {
            this.g = iArr;
            return this;
        }

        ab a() {
            return new ab(this.a, this.g, this.b, this.f445c, this.d, this.e, this.f);
        }

        a b(int i) {
            this.b = i;
            return this;
        }

        a c(int i) {
            this.f445c = i;
            return this;
        }

        a d(int i) {
            this.d = i;
            return this;
        }

        a e(int i) {
            this.e = i;
            return this;
        }

        a f(int i) {
            this.f = i;
            return this;
        }

        a g(int i) {
            this.g[0] = i;
            return this;
        }
    }

    private ab(int i2, int[] iArr, int i3, int i4, int i5, int i6, int i7) {
        this.f444c = i2;
        this.g = iArr;
        this.d = i3;
        this.b = i5;
        this.e = i6;
        this.f = i7;
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(0);
        paint.setAntiAlias(true);
        paint.setShadowLayer(i5, i6, i7, i4);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    }

    public static void a(View view, int i2, int i3, int i4, int i5, int i6, int i7) {
        ab a2 = new a().g(i2).b(i3).c(i4).d(i5).e(i6).f(i7).a();
        view.setLayerType(1, null);
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(a2);
        } else {
            view.setBackgroundDrawable(a2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        int[] iArr = this.g;
        if (iArr != null) {
            if (iArr.length == 1) {
                paint.setColor(iArr[0]);
            } else {
                RectF rectF = this.h;
                float f = rectF.left;
                float height = rectF.height() / 2.0f;
                RectF rectF2 = this.h;
                paint.setShader(new LinearGradient(f, height, rectF2.right, rectF2.height() / 2.0f, this.g, (float[]) null, Shader.TileMode.CLAMP));
            }
        }
        paint.setAntiAlias(true);
        if (this.f444c != 1) {
            canvas.drawCircle(this.h.centerX(), this.h.centerY(), Math.min(this.h.width(), this.h.height()) / 2.0f, this.a);
            canvas.drawCircle(this.h.centerX(), this.h.centerY(), Math.min(this.h.width(), this.h.height()) / 2.0f, paint);
            return;
        }
        RectF rectF3 = this.h;
        int i2 = this.d;
        canvas.drawRoundRect(rectF3, i2, i2, this.a);
        RectF rectF4 = this.h;
        int i3 = this.d;
        canvas.drawRoundRect(rectF4, i3, i3, paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.a.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i2, int i3, int i4, int i5) {
        super.setBounds(i2, i3, i4, i5);
        int i6 = this.b;
        int i7 = this.e;
        int i8 = this.f;
        this.h = new RectF((i2 + i6) - i7, (i3 + i6) - i8, (i4 - i6) - i7, (i5 - i6) - i8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }
}
