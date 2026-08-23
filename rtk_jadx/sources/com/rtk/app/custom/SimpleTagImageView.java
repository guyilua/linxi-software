package com.rtk.app.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SimpleTagImageView extends ImageView {
    private static final float s = (float) Math.sqrt(2.0d);
    private float a;
    private float b;

    /* renamed from: c, reason: collision with root package name */
    private int f171c;
    private Path d;
    private Paint e;
    private String f;
    private int g;
    private Paint h;
    private Rect i;
    private int j;
    private float k;
    private int l;
    private a m;
    private a n;
    private Paint o;
    private RectF p;
    private boolean q;
    private int r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        float a;
        float b;

        a() {
        }
    }

    public SimpleTagImageView(Context context) {
        this(context, null);
    }

    private void a(float f) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i = this.l;
        if (i == 0) {
            a aVar = this.m;
            aVar.a = com.sigmob.sdk.base.blurkit.c.d;
            aVar.b = f;
            a aVar2 = this.n;
            aVar2.a = f;
            aVar2.b = com.sigmob.sdk.base.blurkit.c.d;
            return;
        }
        if (i == 1) {
            a aVar3 = this.m;
            float f2 = measuredWidth;
            aVar3.a = f2 - f;
            aVar3.b = com.sigmob.sdk.base.blurkit.c.d;
            a aVar4 = this.n;
            aVar4.a = f2;
            aVar4.b = f;
            return;
        }
        if (i == 2) {
            a aVar5 = this.m;
            aVar5.a = com.sigmob.sdk.base.blurkit.c.d;
            float f3 = measuredHeight;
            aVar5.b = f3 - f;
            a aVar6 = this.n;
            aVar6.a = f;
            aVar6.b = f3;
            return;
        }
        if (i != 3) {
            return;
        }
        a aVar7 = this.m;
        float f4 = measuredWidth;
        aVar7.a = f4 - f;
        float f5 = measuredHeight;
        aVar7.b = f5;
        a aVar8 = this.n;
        aVar8.a = f4;
        aVar8.b = f5 - f;
    }

    private int b(int i) {
        return (int) ((this.k * i) + 0.5f);
    }

    private Bitmap c(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    private int d(float f) {
        return (int) ((f / this.k) + 0.5f);
    }

    private void e() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        Bitmap c2 = c(drawable);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(c2, tileMode, tileMode);
        if (getScaleType() != ImageView.ScaleType.FIT_XY) {
            Log.w("SimpleTagImageView", String.format("Now scale type just support fitXY,other type invalid", new Object[0]));
        }
        Matrix matrix = new Matrix();
        matrix.setScale((getWidth() * 1.0f) / c2.getWidth(), (getHeight() * 1.0f) / c2.getHeight());
        bitmapShader.setLocalMatrix(matrix);
        if (this.o == null) {
            Paint paint = new Paint();
            this.o = paint;
            paint.setDither(false);
            this.o.setAntiAlias(true);
            this.o.setShader(bitmapShader);
        }
    }

    public int getCornerDistance() {
        return d(this.a);
    }

    public int getTagBackgroundColor() {
        return this.f171c;
    }

    public boolean getTagEnable() {
        return this.q;
    }

    public int getTagOrientation() {
        return this.l;
    }

    public int getTagRoundRadius() {
        return this.r;
    }

    public String getTagText() {
        return this.f;
    }

    public int getTagTextColor() {
        return this.j;
    }

    public int getTagTextSize() {
        return this.g;
    }

    public int getTagWidth() {
        return d(this.b);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.r == 0) {
            super.onDraw(canvas);
        } else {
            Drawable drawable = getDrawable();
            if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
                return;
            }
            e();
            this.p.set(getPaddingLeft(), getPaddingTop(), getMeasuredWidth() - getPaddingRight(), getMeasuredHeight() - getPaddingBottom());
            RectF rectF = this.p;
            int i = this.r;
            canvas.drawRoundRect(rectF, i, i, this.o);
        }
        float f = this.b;
        if (f <= com.sigmob.sdk.base.blurkit.c.d || !this.q) {
            return;
        }
        float f2 = this.a + (f / 2.0f);
        a(f2);
        this.h.setTextSize(this.g);
        Paint paint = this.h;
        String str = this.f;
        paint.getTextBounds(str, 0, str.length(), this.i);
        this.e.setDither(true);
        this.e.setAntiAlias(true);
        this.e.setColor(this.f171c);
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setStrokeJoin(Paint.Join.ROUND);
        this.e.setStrokeCap(Paint.Cap.SQUARE);
        this.e.setStrokeWidth(this.b);
        this.d.reset();
        Path path = this.d;
        a aVar = this.m;
        path.moveTo(aVar.a, aVar.b);
        Path path2 = this.d;
        a aVar2 = this.n;
        path2.lineTo(aVar2.a, aVar2.b);
        canvas.drawPath(this.d, this.e);
        this.h.setColor(this.j);
        this.h.setTextSize(this.g);
        this.h.setAntiAlias(true);
        canvas.drawTextOnPath(this.f, this.d, ((s * f2) / 2.0f) - (this.i.width() / 2), this.i.height() / 2, this.h);
    }

    public void setCornerDistance(int i) {
        if (this.a == i) {
            return;
        }
        this.a = b(i);
        invalidate();
    }

    public void setTagBackgroundColor(int i) {
        if (this.f171c == i) {
            return;
        }
        this.f171c = i;
        invalidate();
    }

    public void setTagEnable(boolean z) {
        if (this.q == z) {
            return;
        }
        this.q = z;
        invalidate();
    }

    public void setTagOrientation(int i) {
        if (i == this.l) {
            return;
        }
        this.l = i;
        invalidate();
    }

    public void setTagRoundRadius(int i) {
        if (this.r == i) {
            return;
        }
        this.r = i;
        invalidate();
    }

    public void setTagText(String str) {
        if (str.equals(this.f)) {
            return;
        }
        this.f = str;
        invalidate();
    }

    public void setTagTextColor(int i) {
        if (this.j == i) {
            return;
        }
        this.j = i;
        invalidate();
    }

    public void setTagTextSize(int i) {
        this.g = b(i);
        invalidate();
    }

    public void setTagWidth(int i) {
        this.b = b(i);
        invalidate();
    }

    public SimpleTagImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SimpleTagImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = context.getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SimpleTagImageView, i, 0);
        this.l = obtainStyledAttributes.getInteger(3, 0);
        this.b = obtainStyledAttributes.getDimensionPixelSize(8, b(20));
        this.a = obtainStyledAttributes.getDimensionPixelSize(0, b(20));
        this.f171c = obtainStyledAttributes.getColor(1, -1624781376);
        this.f = obtainStyledAttributes.getString(5);
        this.g = obtainStyledAttributes.getDimensionPixelSize(7, b(15));
        this.j = obtainStyledAttributes.getColor(6, -1);
        this.q = obtainStyledAttributes.getBoolean(2, true);
        this.r = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        obtainStyledAttributes.recycle();
        if (TextUtils.isEmpty(this.f)) {
            this.f = "";
        }
        this.e = new Paint();
        this.d = new Path();
        this.h = new Paint();
        this.i = new Rect();
        this.m = new a();
        this.n = new a();
        this.p = new RectF();
    }
}
