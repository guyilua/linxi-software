package com.qq.e.ads.nativ;

import android.content.Context;
import android.widget.FrameLayout;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.pi.LADI;
import com.qq.e.comm.pi.NFBI;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class NativeExpressADView extends FrameLayout implements DownloadConfirmListener, LADI, NFBI {
    private int a;
    private double b;

    /* renamed from: c, reason: collision with root package name */
    private double f10c;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface ViewBindStatusListener {
        void onAttachedToWindow();

        void onDetachedFromWindow();

        void onFinishTemporaryDetach();

        void onStartTemporaryDetach();
    }

    public NativeExpressADView(Context context) {
        super(context);
        this.a = -1;
        this.b = -1.0d;
        this.f10c = -1.0d;
    }

    public abstract void destroy();

    public abstract AdData getBoundData();

    public abstract void negativeFeedback();

    /* JADX WARN: Removed duplicated region for block: B:18:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r16, int r17) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.ads.nativ.NativeExpressADView.onMeasure(int, int):void");
    }

    public abstract void preloadVideo();

    public abstract void render();

    @Deprecated
    public abstract void setAdSize(ADSize aDSize);

    public abstract void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener);

    public void setSizeRules(int i, double d, double d2) {
        this.a = i;
        this.b = d;
        this.f10c = d2;
    }

    public abstract void setViewBindStatusListener(ViewBindStatusListener viewBindStatusListener);
}
