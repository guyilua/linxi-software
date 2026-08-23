package com.weigan.loopview;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* compiled from: LoopViewGestureListener.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
final class b extends GestureDetector.SimpleOnGestureListener {
    final LoopView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(LoopView loopView) {
        this.a = loopView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.a.g(f2);
        return true;
    }
}
