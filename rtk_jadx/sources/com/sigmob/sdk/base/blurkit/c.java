package com.sigmob.sdk.base.blurkit;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c extends FrameLayout {
    public static final float a = 0.12f;
    public static final int b = 12;

    /* renamed from: c, reason: collision with root package name */
    public static final int f350c = 24;
    public static final float d = 0.0f;
    public static final float e = Float.NaN;
    private float f;
    private int g;
    private int h;
    private float i;
    private float j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private d o;
    private WeakReference<View> p;
    private Point q;
    private Bitmap r;
    private Choreographer.FrameCallback s;

    public c(Context context) {
        super(context, null);
        this.f = 0.12f;
        this.g = 12;
        this.h = 24;
        this.i = d;
        this.j = Float.NaN;
        this.s = new Choreographer.FrameCallback() { // from class: com.sigmob.sdk.base.blurkit.c.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                c.this.invalidate();
                Choreographer.getInstance().postFrameCallbackDelayed(this, 1000 / c.this.h);
            }
        };
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 0.12f;
        this.g = 12;
        this.h = 24;
        this.i = d;
        this.j = Float.NaN;
        this.s = new Choreographer.FrameCallback() { // from class: com.sigmob.sdk.base.blurkit.c.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                c.this.invalidate();
                Choreographer.getInstance().postFrameCallbackDelayed(this, 1000 / c.this.h);
            }
        };
        if (!isInEditMode()) {
            a.a(context);
        }
        d dVar = new d(getContext());
        this.o = dVar;
        dVar.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.o);
        setCornerRadius(this.i);
    }

    private Bitmap a(View view, Rect rect, float f) {
        View rootView = view.getRootView();
        int width = (int) (rect.width() * f);
        int height = (int) (rect.height() * f);
        if (rootView.getWidth() <= 0 || rootView.getHeight() <= 0 || width <= 0 || height <= 0) {
            throw new b("No screen available (width or height = 0)");
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        matrix.preScale(f, f);
        matrix.postTranslate((-rect.left) * f, (-rect.top) * f);
        canvas.setMatrix(matrix);
        rootView.draw(canvas);
        return createBitmap;
    }

    private PointF a(View view) {
        if (getParent() == null) {
            return new PointF();
        }
        try {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup == null) {
                return new PointF();
            }
            PointF a2 = a(viewGroup);
            a2.offset(view.getX(), view.getY());
            return a2;
        } catch (Exception unused) {
            return new PointF();
        }
    }

    private Bitmap g() {
        Point positionInScreen;
        Bitmap a2;
        if (getContext() != null && !isInEditMode()) {
            WeakReference<View> weakReference = this.p;
            if (weakReference == null || weakReference.get() == null) {
                WeakReference<View> weakReference2 = new WeakReference<>(getActivityView());
                this.p = weakReference2;
                if (weakReference2.get() == null) {
                    return null;
                }
            }
            if (this.m) {
                if (this.q == null) {
                    this.q = getPositionInScreen();
                }
                positionInScreen = this.q;
            } else {
                positionInScreen = getPositionInScreen();
            }
            super.setAlpha(d);
            int width = this.p.get().getWidth();
            int height = this.p.get().getHeight();
            int width2 = (int) (getWidth() * this.f);
            float height2 = getHeight();
            float f = this.f;
            int i = (int) (height2 * f);
            int i2 = (int) (positionInScreen.x * f);
            int i3 = (int) (positionInScreen.y * f);
            int width3 = getWidth() / 8;
            int height3 = getHeight() / 8;
            int i4 = -width3;
            if (i2 + i4 < 0) {
                i4 = 0;
            }
            if ((i2 + width) - width3 > width) {
                width3 = (width + width) - i2;
            }
            int i5 = -height3;
            if (i3 + i5 < 0) {
                i5 = 0;
            }
            if (getHeight() + i3 + height3 > height) {
                height3 = 0;
            }
            if (this.n) {
                if (this.r == null) {
                    c();
                }
                if (width2 == 0 || i == 0) {
                    return null;
                }
                a2 = Bitmap.createBitmap(this.r, i2, i3, width2, i);
            } else {
                try {
                    View view = this.p.get();
                    int i6 = positionInScreen.x;
                    a2 = a(view, new Rect(i6 + i4, positionInScreen.y + i5, i6 + getWidth() + Math.abs(i4) + width3, positionInScreen.y + getHeight() + Math.abs(i5) + height3), this.f);
                } catch (b | NullPointerException unused) {
                }
            }
            if (!this.n) {
                a2 = Bitmap.createBitmap(a.a().a(a2, this.g), (int) (Math.abs(i4) * this.f), (int) (Math.abs(i5) * this.f), width2, i);
            }
            super.setAlpha(Float.isNaN(this.j) ? 1.0f : this.j);
            return a2;
        }
        return null;
    }

    private View getActivityView() {
        try {
            return ((Activity) getContext()).getWindow().getDecorView().findViewById(R.id.content);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    private Point getPositionInScreen() {
        PointF a2 = a((View) this);
        return new Point((int) a2.x, (int) a2.y);
    }

    public void a() {
        if (!this.k && this.h > 0) {
            this.k = true;
            Choreographer.getInstance().postFrameCallback(this.s);
        }
    }

    public void b() {
        if (this.k) {
            this.k = false;
            Choreographer.getInstance().removeFrameCallback(this.s);
        }
    }

    public void c() {
        this.n = true;
        WeakReference<View> weakReference = this.p;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View rootView = this.p.get().getRootView();
        try {
            super.setAlpha(d);
            this.r = a(rootView, new Rect(0, 0, rootView.getWidth(), rootView.getHeight()), this.f);
            if (Float.isNaN(this.j)) {
                super.setAlpha(1.0f);
            } else {
                super.setAlpha(this.j);
            }
            this.r = a.a().a(this.r, this.g);
        } catch (Exception unused) {
        }
    }

    public void d() {
        this.n = false;
        this.r = null;
    }

    public void e() {
        this.m = true;
        this.q = getPositionInScreen();
    }

    public void f() {
        this.m = false;
        this.q = null;
    }

    @Override // android.view.View
    public float getAlpha() {
        return this.j;
    }

    public int getBlurRadius() {
        return this.g;
    }

    public float getCornerRadius() {
        return this.i;
    }

    public float getDownscaleFactor() {
        return this.f;
    }

    public int getFPS() {
        return this.h;
    }

    public boolean getPositionLocked() {
        return this.m;
    }

    public boolean getViewLocked() {
        return this.n;
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Bitmap g = g();
        if (g != null) {
            this.o.setImageBitmap(g);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.l = true;
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.l = false;
        b();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        invalidate();
    }

    @Override // android.view.View
    public void setAlpha(float f) {
        this.j = f;
        if (this.n) {
            return;
        }
        super.setAlpha(f);
    }

    public void setBlurRadius(int i) {
        this.g = i;
        this.r = null;
        invalidate();
    }

    public void setCornerRadius(float f) {
        this.i = f;
        d dVar = this.o;
        if (dVar != null) {
            dVar.setCornerRadius(f);
        }
        invalidate();
    }

    public void setDownscaleFactor(float f) {
        this.f = f;
        this.r = null;
        invalidate();
    }

    public void setFPS(int i) {
        if (this.k) {
            b();
        }
        this.h = i;
        if (this.l) {
            a();
        }
    }
}
