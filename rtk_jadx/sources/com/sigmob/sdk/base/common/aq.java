package com.sigmob.sdk.base.common;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.sigmob.sdk.base.models.BaseAdUnit;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class aq extends GestureDetector {
    private final View a;
    private b b;

    private aq(Context context, View view, b bVar) {
        super(context, bVar);
        this.b = bVar;
        this.a = view;
        setIsLongpressEnabled(false);
    }

    public aq(Context context, View view, BaseAdUnit baseAdUnit) {
        this(context, view, new b(view, baseAdUnit));
    }

    private boolean a(MotionEvent motionEvent, View view) {
        if (motionEvent == null || view == null) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        return x >= com.sigmob.sdk.base.blurkit.c.d && x <= ((float) view.getWidth()) && y >= com.sigmob.sdk.base.blurkit.c.d && y <= ((float) view.getHeight());
    }

    void a() {
        this.b.b();
    }

    public void b() {
        this.b.c();
    }

    public boolean c() {
        return this.b.d();
    }

    @Override // android.view.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 1) {
            this.b.a();
        } else if (action == 2 && !a(motionEvent, this.a)) {
            a();
        }
        return onTouchEvent;
    }
}
