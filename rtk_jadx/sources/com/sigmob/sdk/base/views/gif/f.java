package com.sigmob.sdk.base.views.gif;

import android.graphics.Bitmap;
import com.sigmob.sdk.base.views.gif.a;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f implements a.InterfaceC0039a {
    @Override // com.sigmob.sdk.base.views.gif.a.InterfaceC0039a
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // com.sigmob.sdk.base.views.gif.a.InterfaceC0039a
    public void a(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.sigmob.sdk.base.views.gif.a.InterfaceC0039a
    public void a(byte[] bArr) {
    }

    @Override // com.sigmob.sdk.base.views.gif.a.InterfaceC0039a
    public void a(int[] iArr) {
    }

    @Override // com.sigmob.sdk.base.views.gif.a.InterfaceC0039a
    public byte[] a(int i) {
        return new byte[i];
    }

    @Override // com.sigmob.sdk.base.views.gif.a.InterfaceC0039a
    public int[] b(int i) {
        return new int[i];
    }
}
