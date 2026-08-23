package com.sigmob.sdk.nativead;

import java.lang.ref.WeakReference;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class r implements q {
    private WeakReference<com.sigmob.sdk.videoplayer.g> a;
    private i b;

    public r(com.sigmob.sdk.videoplayer.g gVar) {
        this.a = new WeakReference<>(gVar);
    }

    private com.sigmob.sdk.videoplayer.g k() {
        return this.a.get();
    }

    @Override // com.sigmob.sdk.nativead.q
    public void a() {
        com.sigmob.sdk.videoplayer.g k = k();
        if (k != null) {
            k.D();
        }
    }

    public void a(int i) {
        com.sigmob.sdk.videoplayer.g k = k();
        if (k != null) {
            k.setHolderImageResource(i);
        }
    }

    @Override // com.sigmob.sdk.nativead.q
    public void a(i iVar) {
        this.b = iVar;
    }

    @Override // com.sigmob.sdk.nativead.q
    public void a(boolean z) {
        com.sigmob.sdk.videoplayer.g k = k();
        if (k != null) {
            k.setSoundChange(z);
        }
    }

    @Override // com.sigmob.sdk.nativead.q
    public void b() {
        com.sigmob.sdk.videoplayer.g k = k();
        if (k != null) {
            k.C();
        }
    }

    @Override // com.sigmob.sdk.nativead.q
    public void c() {
        com.sigmob.sdk.videoplayer.g k = k();
        if (k != null) {
            k.C();
        }
    }

    @Override // com.sigmob.sdk.nativead.q
    public void d() {
        com.sigmob.sdk.videoplayer.g k = k();
        if (k != null) {
            k.E();
        }
    }

    @Override // com.sigmob.sdk.nativead.q
    public int e() {
        com.sigmob.sdk.videoplayer.g k = k();
        if (k == null || k.getDuration() == 0) {
            return 0;
        }
        return (int) (k.getDuration() / 1000);
    }

    @Override // com.sigmob.sdk.nativead.q
    public int f() {
        com.sigmob.sdk.videoplayer.g k = k();
        if (k == null || k.getCurrentPositionWhenPlaying() == 0) {
            return 0;
        }
        return (int) ((k.getCurrentPositionWhenPlaying() * 100) / k.getDuration());
    }

    @Override // com.sigmob.sdk.nativead.q
    public i g() {
        return this.b;
    }

    @Override // com.sigmob.sdk.nativead.q
    public void h() {
        com.sigmob.sdk.videoplayer.g k = k();
        if (k != null) {
            k.d();
        }
    }

    @Override // com.sigmob.sdk.nativead.q
    public void i() {
        com.sigmob.sdk.videoplayer.g gVar = this.a.get();
        if (gVar != null) {
            gVar.a();
        }
        this.a.clear();
        this.b = null;
    }

    @Override // com.sigmob.sdk.nativead.q
    public int j() {
        com.sigmob.sdk.videoplayer.g k = k();
        if (k != null) {
            return (int) (k.getCurrentPositionWhenPlaying() / 1000);
        }
        return 0;
    }
}
