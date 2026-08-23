package com.sigmob.sdk.videoplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class m extends TextureView {
    protected static final String a = "ResizeTextureView";
    public int b;

    /* renamed from: c, reason: collision with root package name */
    public int f686c;

    public m(Context context) {
        super(context);
        this.b = 0;
        this.f686c = 0;
        this.b = 0;
        this.f686c = 0;
    }

    public m(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        this.f686c = 0;
        this.b = 0;
        this.f686c = 0;
    }

    public void a(int i, int i2) {
        if (this.b == i && this.f686c == i2) {
            return;
        }
        this.b = i;
        this.f686c = i2;
        requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00eb, code lost:
    
        if (r2 > r12) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ed, code lost:
    
        r2 = (r12 * r4) / r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0100, code lost:
    
        if (r2 > r12) goto L41;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r18, int r19) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.videoplayer.m.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public void setRotation(float f) {
        if (f != getRotation()) {
            super.setRotation(f);
            requestLayout();
        }
    }
}
