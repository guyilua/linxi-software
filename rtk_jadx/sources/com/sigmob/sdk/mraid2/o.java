package com.sigmob.sdk.mraid2;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.sigmob.sdk.mraid2.c;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class o extends ScrollView implements l {

    /* renamed from: c, reason: collision with root package name */
    public static final float f593c = 1000.0f;
    private static final String d = "PageScrollView";
    private static final int e = 1000;
    public final int a;
    public final int b;
    private int f;
    private long g;
    private c.InterfaceC0053c h;
    private int i;

    public o(Context context) {
        this(context, null);
    }

    public o(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public o(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2 = getResources().getDisplayMetrics().heightPixels;
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
        this.f = i2;
        this.g = System.currentTimeMillis();
        Log.d(d, this.i + "--------onTouchStart--------" + this.f);
    }

    @Override // com.sigmob.sdk.mraid2.l
    public void a(final g gVar, int i, int i2) {
        final int i3 = this.f - i2;
        Log.d(d, this.i + "-----------onTouchEnd--------:" + i3);
        final boolean a = a(i3);
        final int height = getChildAt(0).getHeight();
        post(new Runnable() { // from class: com.sigmob.sdk.mraid2.o.2
            @Override // java.lang.Runnable
            public void run() {
                int i4;
                if (a) {
                    if (i3 > 0) {
                        i4 = 1;
                        int i5 = o.this.i;
                        o oVar = o.this;
                        if (i5 + oVar.a < height) {
                            oVar.i += o.this.a;
                        }
                    } else {
                        i4 = 2;
                        if (o.this.i > 0) {
                            o.this.i -= o.this.a;
                        }
                    }
                    if (o.this.h != null) {
                        o.this.h.a(gVar, i4, o.this.i / o.this.a);
                    }
                }
                o oVar2 = o.this;
                oVar2.smoothScrollTo(0, oVar2.i);
            }
        });
    }

    @Override // com.sigmob.sdk.mraid2.l
    public void b(int i, int i2) {
        final int i3 = this.f - i2;
        final int height = getChildAt(0).getHeight();
        post(new Runnable() { // from class: com.sigmob.sdk.mraid2.o.1
            @Override // java.lang.Runnable
            public void run() {
                if (i3 <= 0) {
                    if (o.this.i > 0) {
                        o oVar = o.this;
                        oVar.scrollTo(0, oVar.i - Math.abs(i3));
                        return;
                    }
                    return;
                }
                int i4 = o.this.i;
                o oVar2 = o.this;
                if (i4 + oVar2.a < height) {
                    oVar2.scrollTo(0, oVar2.i + Math.abs(i3));
                }
            }
        });
    }

    @Override // android.widget.ScrollView
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
