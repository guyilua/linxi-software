package com.sigmob.sdk.videoplayer;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.Surface;
import android.view.TextureView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class j implements TextureView.SurfaceTextureListener {
    public SurfaceTexture a;
    public Handler b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f682c;
    public i d;

    public j(i iVar) {
        this.d = iVar;
    }

    public abstract void a();

    public abstract void a(float f);

    public abstract void a(long j);

    public abstract void a(Surface surface);

    public abstract void a(boolean z);

    public abstract void b();

    public abstract void b(float f);

    public abstract void c();

    public abstract void d();

    public abstract boolean e();

    public abstract void f();

    public abstract long g();

    public abstract int h();

    public abstract int i();

    public abstract long j();
}
