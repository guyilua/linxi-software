package com.weigan.loopview;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnItemSelectedRunnable.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class e implements Runnable {
    final LoopView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LoopView loopView) {
        this.a = loopView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LoopView loopView = this.a;
        loopView.e.a(loopView.getSelectedItem());
    }
}
