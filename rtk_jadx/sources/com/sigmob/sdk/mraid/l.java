package com.sigmob.sdk.mraid;

import android.content.Context;
import android.graphics.Rect;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class l {
    private final Context a;
    private final Rect b = new Rect();

    /* renamed from: c, reason: collision with root package name */
    private final Rect f569c = new Rect();
    private final Rect d = new Rect();
    private final Rect e = new Rect();
    private final Rect f = new Rect();
    private final Rect g = new Rect();
    private final Rect h = new Rect();
    private final Rect i = new Rect();
    private final float j;

    public l(Context context, float f) {
        this.a = context.getApplicationContext();
        this.j = f;
    }

    private void a(Rect rect, Rect rect2) {
        rect2.set(Dips.pixelsToIntDips(rect.left, this.a), Dips.pixelsToIntDips(rect.top, this.a), Dips.pixelsToIntDips(rect.right, this.a), Dips.pixelsToIntDips(rect.bottom, this.a));
    }

    public float a() {
        return this.j;
    }

    public void a(int i, int i2) {
        this.b.set(0, 0, i, i2);
        a(this.b, this.f569c);
    }

    public void a(int i, int i2, int i3, int i4) {
        this.d.set(i, i2, i3 + i, i4 + i2);
        a(this.d, this.e);
    }

    Rect b() {
        return this.b;
    }

    public void b(int i, int i2, int i3, int i4) {
        this.f.set(i, i2, i3 + i, i4 + i2);
        a(this.f, this.g);
    }

    public Rect c() {
        return this.f569c;
    }

    public void c(int i, int i2, int i3, int i4) {
        this.h.set(i, i2, i3 + i, i4 + i2);
        a(this.h, this.i);
    }

    Rect d() {
        return this.d;
    }

    public Rect e() {
        return this.e;
    }

    Rect f() {
        return this.f;
    }

    public Rect g() {
        return this.g;
    }

    Rect h() {
        return this.h;
    }

    public Rect i() {
        return this.i;
    }
}
