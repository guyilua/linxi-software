package com.sigmob.sdk.mraid2;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import com.sigmob.sdk.mraid2.c;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class j extends HorizontalScrollView implements l {

    /* renamed from: c, reason: collision with root package name */
    public static final float f588c = 1000.0f;
    private static final String d = "PageScrollView";
    private static final int e = 1000;
    public final int a;
    public final int b;
    private int f;
    private long g;
    private c.InterfaceC0053c h;
    private int i;

    public j(Context context) {
        this(context, null);
    }

    public j(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public j(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2 = getResources().getDisplayMetrics().widthPixels;
        this.a = i2;
        this.b = i2 / 2;
        this.i = 0;
    }

    private boolean a(int i) {
        int i2 = this.a;
        int i3 = i % i2;
        Log.d(d, i3 + ":-----goPage------:" + (i / i2));
        float currentTimeMillis = (float) (((long) (i * 1000)) / (System.currentTimeMillis() - this.g));
        if (currentTimeMillis < 1000.0f && currentTimeMillis > -1000.0f) {
            int i4 = this.b;
            if (i3 < i4) {
                return false;
            }
            if (i3 > this.a - i4) {
            }
        }
        return true;
    }

    @Override // com.sigmob.sdk.mraid2.l
    public void a(int i, int i2) {
        this.f = i;
        this.g = System.currentTimeMillis();
        Log.d(d, this.i + "--------onTouchStart--------" + this.f);
    }

    @Override // com.sigmob.sdk.mraid2.l
    public void a(final g gVar, int i, int i2) {
        final int i3 = this.f - i;
        Log.d(d, this.i + "-----------onTouchEnd--------:" + i3);
        final boolean a = a(i3);
        final int width = getChildAt(0).getWidth();
        Log.d(d, width + "------是否翻页----" + a);
        post(new Runnable() { // from class: com.sigmob.sdk.mraid2.j.2
            @Override // java.lang.Runnable
            public void run() {
                int i4;
                if (a) {
                    if (i3 > 0) {
                        i4 = 1;
                        int i5 = j.this.i;
                        j jVar = j.this;
                        if (i5 + jVar.a < width) {
                            jVar.i += j.this.a;
                        }
                    } else {
                        i4 = 2;
                        if (j.this.i > 0) {
                            j.this.i -= j.this.a;
                        }
                    }
                    if (j.this.h != null) {
                        j.this.h.a(gVar, i4, j.this.i / j.this.a);
                    }
                }
                j jVar2 = j.this;
                jVar2.smoothScrollTo(jVar2.i, 0);
            }
        });
    }

    @Override // com.sigmob.sdk.mraid2.l
    public void b(int i, int i2) {
        final int i3 = this.f - i;
        final int width = getChildAt(0).getWidth();
        post(new Runnable() { // from class: com.sigmob.sdk.mraid2.j.1
            @Override // java.lang.Runnable
            public void run() {
                if (i3 <= 0) {
                    if (j.this.i > 0) {
                        j jVar = j.this;
                        jVar.scrollTo(jVar.i - Math.abs(i3), 0);
                        return;
                    }
                    return;
                }
                int i4 = j.this.i;
                j jVar2 = j.this;
                if (i4 + jVar2.a < width) {
                    jVar2.scrollTo(jVar2.i + Math.abs(i3), 0);
                }
            }
        });
    }

    @Override // android.widget.HorizontalScrollView
    public void fling(int i) {
        super.fling(0);
    }

    @Override // com.sigmob.sdk.mraid2.l
    public ViewGroup getView() {
        return this;
    }

    @Override // com.sigmob.sdk.mraid2.l
    public void setPageChangedListener(c.InterfaceC0053c interfaceC0053c) {
        this.h = interfaceC0053c;
    }
}
