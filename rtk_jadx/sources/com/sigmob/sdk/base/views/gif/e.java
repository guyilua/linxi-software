package com.sigmob.sdk.base.views.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e extends ImageView implements Runnable {
    private static final String a = "GifDecoderView";
    private boolean b;

    /* renamed from: c, reason: collision with root package name */
    private a f472c;
    private b d;
    private Thread e;
    private c f;
    private long g;
    private com.sigmob.sdk.base.views.gif.a h;
    private final Handler i;
    private boolean j;
    private boolean k;
    private Bitmap l;
    private final Runnable m;
    private final Runnable n;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a();
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface b {
        void a();
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface c {
        Bitmap a(Bitmap bitmap);
    }

    public e(Context context) {
        super(context);
        this.f472c = null;
        this.d = null;
        this.f = null;
        this.g = -1L;
        this.i = new Handler(Looper.getMainLooper());
        this.m = new Runnable() { // from class: com.sigmob.sdk.base.views.gif.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.l = null;
                e.this.h = null;
                e.this.e = null;
                e.this.k = false;
            }
        };
        this.n = new Runnable() { // from class: com.sigmob.sdk.base.views.gif.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.l == null || e.this.l.isRecycled()) {
                    return;
                }
                e eVar = e.this;
                eVar.setImageBitmap(eVar.l);
            }
        };
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f472c = null;
        this.d = null;
        this.f = null;
        this.g = -1L;
        this.i = new Handler(Looper.getMainLooper());
        this.m = new Runnable() { // from class: com.sigmob.sdk.base.views.gif.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.l = null;
                e.this.h = null;
                e.this.e = null;
                e.this.k = false;
            }
        };
        this.n = new Runnable() { // from class: com.sigmob.sdk.base.views.gif.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.l == null || e.this.l.isRecycled()) {
                    return;
                }
                e eVar = e.this;
                eVar.setImageBitmap(eVar.l);
            }
        };
    }

    private boolean f() {
        return (this.b || this.j) && this.h != null && this.e == null;
    }

    private void g() {
        if (f()) {
            Thread thread = new Thread(this);
            this.e = thread;
            thread.start();
        }
    }

    public void a() {
        this.b = false;
        this.j = false;
        this.k = true;
        e();
        this.i.post(this.m);
    }

    public void a(int i) {
        if (this.h.d() == i || !this.h.b(i - 1) || this.b) {
            return;
        }
        this.j = true;
        g();
    }

    public boolean b() {
        return this.b;
    }

    public void c() {
        this.h.o();
        a(0);
    }

    public void d() {
        this.b = true;
        g();
    }

    public void e() {
        this.b = false;
        Thread thread = this.e;
        if (thread != null) {
            thread.interrupt();
            this.e = null;
        }
    }

    public int getFrameCount() {
        return this.h.f();
    }

    public long getFramesDisplayDuration() {
        return this.g;
    }

    public int getGifHeight() {
        return this.h.g();
    }

    public int getGifWidth() {
        return this.h.m();
    }

    public b getOnAnimationStop() {
        return this.d;
    }

    public c getOnFrameAvailable() {
        return this.f;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        a aVar = this.f472c;
        if (aVar != null) {
            aVar.a();
        }
        do {
            if (!this.b && !this.j) {
                break;
            }
            boolean a2 = this.h.a();
            try {
                long nanoTime = System.nanoTime();
                Bitmap k = this.h.k();
                this.l = k;
                c cVar = this.f;
                if (cVar != null) {
                    this.l = cVar.a(k);
                }
                j = (System.nanoTime() - nanoTime) / 1000000;
                try {
                    this.i.post(this.n);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused) {
                }
            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused2) {
                j = 0;
            }
            this.j = false;
            if (!this.b || !a2) {
                this.b = false;
                break;
            }
            try {
                int j2 = (int) (this.h.j() - j);
                if (j2 > 0) {
                    long j3 = this.g;
                    if (j3 <= 0) {
                        j3 = j2;
                    }
                    Thread.sleep(j3);
                }
            } catch (InterruptedException unused3) {
            }
        } while (this.b);
        if (this.k) {
            this.i.post(this.m);
        }
        this.e = null;
        b bVar = this.d;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void setBytes(byte[] bArr) {
        com.sigmob.sdk.base.views.gif.a aVar = new com.sigmob.sdk.base.views.gif.a();
        this.h = aVar;
        try {
            aVar.a(bArr);
            if (this.b) {
                g();
            } else {
                a(0);
            }
        } catch (Exception unused) {
            this.h = null;
        }
    }

    public void setFramesDisplayDuration(long j) {
        this.g = j;
    }

    public void setOnAnimationStart(a aVar) {
        this.f472c = aVar;
    }

    public void setOnAnimationStop(b bVar) {
        this.d = bVar;
    }

    public void setOnFrameAvailable(c cVar) {
        this.f = cVar;
    }
}
