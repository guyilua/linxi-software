package com.sigmob.sdk.base.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ak extends v {
    private aj a;
    private f b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f454c;

    public ak(Context context) {
        super(context);
        this.f454c = false;
        c();
    }

    public ak(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f454c = false;
        c();
    }

    public ak(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f454c = false;
        c();
    }

    private void c() {
        f fVar = new f(getContext());
        this.b = fVar;
        addView(fVar, new RelativeLayout.LayoutParams(-1, -1));
        this.a = new aj(getContext());
        addView(this.a, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.sigmob.sdk.base.views.v
    public void a() {
        this.f454c = true;
    }

    public void a(float f) {
        aj ajVar = this.a;
        if (ajVar == null || !this.f454c) {
            return;
        }
        ajVar.a(f);
    }

    @Override // com.sigmob.sdk.base.views.v
    public void b() {
        this.f454c = false;
        aj ajVar = this.a;
        if (ajVar != null) {
            ajVar.a(com.sigmob.sdk.base.blurkit.c.d);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }
}
