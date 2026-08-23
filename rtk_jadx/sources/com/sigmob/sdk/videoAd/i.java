package com.sigmob.sdk.videoAd;

import com.sigmob.sdk.base.models.BaseAdUnit;
import java.io.Serializable;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class i implements Serializable {
    private static final long serialVersionUID = 0;
    private final int a;
    private final int b;

    /* renamed from: c, reason: collision with root package name */
    private final com.sigmob.sdk.base.views.n f656c;
    private final int d;
    private String e;
    private a f;
    private String g;
    private String h;
    private int i;
    private boolean j = false;
    private com.sigmob.sdk.videoAd.a k;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(int i, int i2, int i3, String str, String str2, com.sigmob.sdk.base.views.n nVar) {
        this.a = i;
        this.b = i2;
        this.d = i3;
        this.h = str2;
        this.g = str;
        this.f656c = nVar;
    }

    private void a(BaseAdUnit baseAdUnit, String str, String str2, com.sigmob.sdk.base.a aVar) {
    }

    public com.sigmob.sdk.base.views.n a() {
        return this.f656c;
    }

    public void a(int i) {
        this.i = i;
    }

    public void a(com.sigmob.sdk.videoAd.a aVar) {
        this.k = aVar;
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    public void a(String str) {
        this.h = str;
    }

    public String b() {
        return this.h;
    }

    public int c() {
        return this.a;
    }

    public int d() {
        return this.b;
    }
}
