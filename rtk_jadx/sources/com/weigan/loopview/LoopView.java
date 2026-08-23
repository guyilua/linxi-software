package com.weigan.loopview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class LoopView extends View {
    private static final int L = (int) (Resources.getSystem().getDisplayMetrics().density * 15.0f);
    String[] A;
    int B;
    int C;
    int D;
    int E;
    private int F;
    private float G;
    long H;
    private Rect I;
    private int J;
    private int K;
    private float a;
    private Context b;

    /* renamed from: c, reason: collision with root package name */
    Handler f1128c;
    private GestureDetector d;
    d e;
    ScheduledExecutorService f;
    private ScheduledFuture<?> g;
    private Paint h;
    private Paint i;
    private Paint j;
    List<String> k;
    int l;
    int m;
    int n;
    int o;
    int p;
    float q;
    boolean r;
    int s;
    int t;
    int u;
    int v;
    private int w;
    int x;
    int y;
    int z;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum a {
        CLICK,
        FLING,
        DAGGLE
    }

    public LoopView(Context context) {
        super(context);
        this.a = 1.05f;
        this.f = Executors.newSingleThreadScheduledExecutor();
        this.F = 0;
        this.H = 0L;
        this.I = new Rect();
        c(context, null);
    }

    private int b(String str, Paint paint, Rect rect) {
        paint.getTextBounds(str, 0, str.length(), rect);
        int width = (int) (rect.width() * this.a);
        int i = this.C;
        int i2 = this.J;
        return (((i - i2) - width) / 2) + i2;
    }

    private void c(Context context, AttributeSet attributeSet) {
        this.b = context;
        this.f1128c = new c(this);
        GestureDetector gestureDetector = new GestureDetector(context, new b(this));
        this.d = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.androidWheelView);
        this.l = obtainStyledAttributes.getInteger(R.styleable.androidWheelView_awv_textsize, L);
        this.l = (int) (Resources.getSystem().getDisplayMetrics().density * this.l);
        this.q = obtainStyledAttributes.getFloat(R.styleable.androidWheelView_awv_lineSpace, 2.0f);
        this.o = obtainStyledAttributes.getInteger(R.styleable.androidWheelView_awv_centerTextColor, -13553359);
        this.n = obtainStyledAttributes.getInteger(R.styleable.androidWheelView_awv_outerTextColor, -5263441);
        this.p = obtainStyledAttributes.getInteger(R.styleable.androidWheelView_awv_dividerTextColor, -3815995);
        int integer = obtainStyledAttributes.getInteger(R.styleable.androidWheelView_awv_itemsVisibleCount, 9);
        this.z = integer;
        if (integer % 2 == 0) {
            this.z = 9;
        }
        this.r = obtainStyledAttributes.getBoolean(R.styleable.androidWheelView_awv_isLoop, true);
        obtainStyledAttributes.recycle();
        this.A = new String[this.z];
        this.u = 0;
        this.v = -1;
        d();
    }

    private void d() {
        Paint paint = new Paint();
        this.h = paint;
        paint.setColor(this.n);
        this.h.setAntiAlias(true);
        this.h.setTypeface(Typeface.MONOSPACE);
        this.h.setTextSize(this.l);
        Paint paint2 = new Paint();
        this.i = paint2;
        paint2.setColor(this.o);
        this.i.setAntiAlias(true);
        this.i.setTextScaleX(this.a);
        this.i.setTypeface(Typeface.MONOSPACE);
        this.i.setTextSize(this.l);
        Paint paint3 = new Paint();
        this.j = paint3;
        paint3.setColor(this.p);
        this.j.setAntiAlias(true);
    }

    private void f() {
        if (this.k == null) {
            return;
        }
        this.C = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.B = measuredHeight;
        if (this.C == 0 || measuredHeight == 0) {
            return;
        }
        this.J = getPaddingLeft();
        int paddingRight = getPaddingRight();
        this.K = paddingRight;
        this.C -= paddingRight;
        this.i.getTextBounds("星期", 0, 2, this.I);
        this.m = this.I.height();
        int i = this.B;
        int i2 = (int) ((i * 3.141592653589793d) / 2.0d);
        this.D = i2;
        float f = this.q;
        int i3 = (int) (i2 / ((this.z - 1) * f));
        this.m = i3;
        this.E = i / 2;
        this.s = (int) ((i - (i3 * f)) / 2.0f);
        this.t = (int) ((i + (f * i3)) / 2.0f);
        if (this.v == -1) {
            if (this.r) {
                this.v = (this.k.size() + 1) / 2;
            } else {
                this.v = 0;
            }
        }
        this.x = this.v;
    }

    public void a() {
        ScheduledFuture<?> scheduledFuture = this.g;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.g.cancel(true);
        this.g = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e() {
        if (this.e != null) {
            postDelayed(new e(this), 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(float f) {
        a();
        this.g = this.f.scheduleWithFixedDelay(new com.weigan.loopview.a(this, f), 0L, 10, TimeUnit.MILLISECONDS);
    }

    public final int getSelectedItem() {
        return this.w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(a aVar) {
        a();
        if (aVar == a.FLING || aVar == a.DAGGLE) {
            float f = this.q * this.m;
            int i = (int) (((this.u % f) + f) % f);
            this.F = i;
            if (i > f / 2.0f) {
                this.F = (int) (f - i);
            } else {
                this.F = -i;
            }
        }
        this.g = this.f.scheduleWithFixedDelay(new f(this, this.F), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        List<String> list = this.k;
        if (list == null) {
            return;
        }
        int i = (int) (this.u / (this.q * this.m));
        this.y = i;
        int size = this.v + (i % list.size());
        this.x = size;
        if (!this.r) {
            if (size < 0) {
                this.x = 0;
            }
            if (this.x > this.k.size() - 1) {
                this.x = this.k.size() - 1;
            }
        } else {
            if (size < 0) {
                this.x = this.k.size() + this.x;
            }
            if (this.x > this.k.size() - 1) {
                this.x -= this.k.size();
            }
        }
        int i2 = (int) (this.u % (this.q * this.m));
        int i3 = 0;
        while (true) {
            int i4 = this.z;
            if (i3 >= i4) {
                break;
            }
            int i5 = this.x - ((i4 / 2) - i3);
            if (this.r) {
                while (i5 < 0) {
                    i5 += this.k.size();
                }
                while (i5 > this.k.size() - 1) {
                    i5 -= this.k.size();
                }
                this.A[i3] = this.k.get(i5);
            } else if (i5 < 0) {
                this.A[i3] = "";
            } else if (i5 > this.k.size() - 1) {
                this.A[i3] = "";
            } else {
                this.A[i3] = this.k.get(i5);
            }
            i3++;
        }
        float f = this.J;
        int i6 = this.s;
        canvas.drawLine(f, i6, this.C, i6, this.j);
        float f2 = this.J;
        int i7 = this.t;
        canvas.drawLine(f2, i7, this.C, i7, this.j);
        for (int i8 = 0; i8 < this.z; i8++) {
            canvas.save();
            float f3 = this.m * this.q;
            double d = (((i8 * f3) - i2) * 3.141592653589793d) / this.D;
            if (d < 3.141592653589793d && d > 0.0d) {
                int cos = (int) ((this.E - (Math.cos(d) * this.E)) - ((Math.sin(d) * this.m) / 2.0d));
                canvas.translate(com.sigmob.sdk.base.blurkit.c.d, cos);
                canvas.scale(1.0f, (float) Math.sin(d));
                int i9 = this.s;
                if (cos <= i9 && this.m + cos >= i9) {
                    canvas.save();
                    canvas.clipRect(0, 0, this.C, this.s - cos);
                    canvas.drawText(this.A[i8], b(r4[i8], this.h, this.I), this.m, this.h);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0, this.s - cos, this.C, (int) f3);
                    canvas.drawText(this.A[i8], b(r3[i8], this.i, this.I), this.m, this.i);
                    canvas.restore();
                } else {
                    int i10 = this.t;
                    if (cos <= i10 && this.m + cos >= i10) {
                        canvas.save();
                        canvas.clipRect(0, 0, this.C, this.t - cos);
                        canvas.drawText(this.A[i8], b(r4[i8], this.i, this.I), this.m, this.i);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0, this.t - cos, this.C, (int) f3);
                        canvas.drawText(this.A[i8], b(r3[i8], this.h, this.I), this.m, this.h);
                        canvas.restore();
                    } else if (cos >= i9 && this.m + cos <= i10) {
                        canvas.clipRect(0, 0, this.C, (int) f3);
                        canvas.drawText(this.A[i8], b(r3[i8], this.i, this.I), this.m, this.i);
                        this.w = this.k.indexOf(this.A[i8]);
                    } else {
                        canvas.clipRect(0, 0, this.C, (int) f3);
                        canvas.drawText(this.A[i8], b(r3[i8], this.h, this.I), this.m, this.h);
                    }
                }
                canvas.restore();
            } else {
                canvas.restore();
            }
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        f();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.d.onTouchEvent(motionEvent);
        float f = this.q * this.m;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.H = System.currentTimeMillis();
            a();
            this.G = motionEvent.getRawY();
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        } else if (action != 2) {
            if (!onTouchEvent) {
                float y = motionEvent.getY();
                int i = this.E;
                int acos = (int) (((Math.acos((i - y) / i) * this.E) + (f / 2.0f)) / f);
                this.F = (int) (((acos - (this.z / 2)) * f) - (((this.u % f) + f) % f));
                if (System.currentTimeMillis() - this.H > 120) {
                    h(a.DAGGLE);
                } else {
                    h(a.CLICK);
                }
            }
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        } else {
            float rawY = this.G - motionEvent.getRawY();
            this.G = motionEvent.getRawY();
            this.u = (int) (this.u + rawY);
            if (!this.r) {
                float f2 = (-this.v) * f;
                float size = ((this.k.size() - 1) - this.v) * f;
                int i2 = this.u;
                if (i2 < f2) {
                    this.u = (int) f2;
                } else if (i2 > size) {
                    this.u = (int) size;
                }
            }
        }
        invalidate();
        return true;
    }

    public void setCenterTextColor(int i) {
        this.o = i;
        this.i.setColor(i);
    }

    public void setCurrentPosition(int i) {
        List<String> list = this.k;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.k.size();
        if (i < 0 || i >= size || i == this.w) {
            return;
        }
        this.v = i;
        this.u = 0;
        this.F = 0;
        invalidate();
    }

    public void setDividerColor(int i) {
        this.p = i;
        this.j.setColor(i);
    }

    public final void setInitPosition(int i) {
        if (i < 0) {
            this.v = 0;
            return;
        }
        List<String> list = this.k;
        if (list == null || list.size() <= i) {
            return;
        }
        this.v = i;
    }

    public final void setItems(List<String> list) {
        this.k = list;
        f();
        invalidate();
    }

    public void setItemsVisibleCount(int i) {
        if (i % 2 == 0 || i == this.z) {
            return;
        }
        this.z = i;
        this.A = new String[i];
    }

    public void setLineSpacingMultiplier(float f) {
        if (f > 1.0f) {
            this.q = f;
        }
    }

    public final void setListener(d dVar) {
        this.e = dVar;
    }

    public void setNotLoop() {
        this.r = false;
    }

    public void setOuterTextColor(int i) {
        this.n = i;
        this.h.setColor(i);
    }

    @Override // android.view.View
    public void setScaleX(float f) {
        this.a = f;
    }

    public final void setTextSize(float f) {
        if (f > com.sigmob.sdk.base.blurkit.c.d) {
            int i = (int) (this.b.getResources().getDisplayMetrics().density * f);
            this.l = i;
            this.h.setTextSize(i);
            this.i.setTextSize(this.l);
        }
    }

    public LoopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 1.05f;
        this.f = Executors.newSingleThreadScheduledExecutor();
        this.F = 0;
        this.H = 0L;
        this.I = new Rect();
        c(context, attributeSet);
    }

    public LoopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 1.05f;
        this.f = Executors.newSingleThreadScheduledExecutor();
        this.F = 0;
        this.H = 0L;
        this.I = new Rect();
        c(context, attributeSet);
    }
}
