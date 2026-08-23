package com.sigmob.sdk.base.common;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.sigmob.sdk.base.models.BaseAdUnit;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b extends GestureDetector.SimpleOnGestureListener {
    private static final int b = 4;

    /* renamed from: c, reason: collision with root package name */
    private static final float f378c = 100.0f;
    private static final float d = 100.0f;
    boolean a;
    private final BaseAdUnit e;
    private float f;
    private float g;
    private boolean h;
    private boolean i;
    private int j;
    private float k;
    private a l = a.UNSET;
    private View m;

    /* renamed from: com.sigmob.sdk.base.common.b$1, reason: invalid class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            a = iArr;
            try {
                iArr[a.UNSET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[a.GOING_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[a.GOING_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[a.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum a {
        UNSET,
        GOING_RIGHT,
        GOING_LEFT,
        FINISHED,
        FAILED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(View view, BaseAdUnit baseAdUnit) {
        this.f = 100.0f;
        if (view != null && view.getWidth() > 0) {
            this.f = Math.min(100.0f, view.getWidth() / 3.0f);
        }
        this.a = false;
        this.m = view;
        this.e = baseAdUnit;
    }

    private void a(float f) {
        if (f > this.k) {
            this.l = a.GOING_RIGHT;
        }
    }

    private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (motionEvent == null || motionEvent2 == null) {
            return false;
        }
        return Math.abs(motionEvent2.getY() - motionEvent.getY()) > 100.0f;
    }

    private void b(float f) {
        if (d(f) && g(f)) {
            this.l = a.GOING_LEFT;
            this.k = f;
        }
    }

    private void c(float f) {
        if (e(f) && f(f)) {
            this.l = a.GOING_RIGHT;
            this.k = f;
        }
    }

    private boolean d(float f) {
        if (this.i) {
            return true;
        }
        if (f < this.k + this.f) {
            return false;
        }
        this.h = false;
        this.i = true;
        return true;
    }

    private void e() {
        int i = this.j + 1;
        this.j = i;
        if (i >= 4) {
            this.l = a.FINISHED;
        }
    }

    private boolean e(float f) {
        if (this.h) {
            return true;
        }
        if (f > this.k - this.f) {
            return false;
        }
        this.i = false;
        this.h = true;
        e();
        return true;
    }

    private boolean f(float f) {
        return f > this.g;
    }

    private boolean g(float f) {
        return f < this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        a aVar = a.FINISHED;
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.j = 0;
        this.l = a.UNSET;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.a = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.a;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent == null || motionEvent2 == null) {
            return false;
        }
        if (this.l == a.FINISHED) {
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
        if (a(motionEvent, motionEvent2)) {
            this.l = a.FAILED;
        } else {
            int i = AnonymousClass1.a[this.l.ordinal()];
            if (i == 1) {
                this.k = motionEvent.getX();
                a(motionEvent2.getX());
            } else if (i == 2) {
                b(motionEvent2.getX());
            } else if (i == 3) {
                c(motionEvent2.getX());
            }
            this.g = motionEvent2.getX();
        }
        return super.onScroll(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.a = true;
        return super.onSingleTapUp(motionEvent);
    }
}
