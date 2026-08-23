package com.qq.e.ads.nativ.widget;

import android.view.MotionEvent;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface ViewStatusListener {
    void onAttachToWindow();

    void onDetachFromWindow();

    void onDispatchTouchEvent(MotionEvent motionEvent);

    void onWindowFocusChanged(boolean z);

    void onWindowVisibilityChanged(int i);
}
