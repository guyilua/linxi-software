package com.sigmob.sdk.videoplayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.czhj.sdk.logger.SigmobLog;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a extends RelativeLayout implements i {
    private static final int u = 6000;
    j a;
    Class b;

    /* renamed from: c, reason: collision with root package name */
    m f676c;
    public h d;
    public e e;
    private ViewGroup f;
    private int g;
    private Timer h;
    private C0065a i;
    private boolean j;
    private boolean k;
    private Handler l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private float q;
    private l r;
    private int s;
    private String t;
    private boolean v;

    /* renamed from: com.sigmob.sdk.videoplayer.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class C0065a extends TimerTask {
        public C0065a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a aVar = a.this;
            e eVar = aVar.e;
            if (eVar == e.STATE_PLAYING || eVar == e.STATE_PAUSE) {
                aVar.post(new Runnable() { // from class: com.sigmob.sdk.videoplayer.a.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        long currentPositionWhenPlaying = a.this.getCurrentPositionWhenPlaying();
                        long duration = a.this.getDuration();
                        if (a.this.r != null) {
                            a.this.r.a(currentPositionWhenPlaying, duration);
                        }
                    }
                });
            }
        }
    }

    public a(Context context) {
        super(context);
        this.e = e.STATE_IDLE;
        this.l = new Handler(Looper.getMainLooper()) { // from class: com.sigmob.sdk.videoplayer.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 6000 || a.this.j || a.this.k) {
                    return;
                }
                a.this.j = true;
                a.this.setState(e.STATE_BUFFERING_START);
            }
        };
        FrameLayout frameLayout = new FrameLayout(context);
        this.f = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        addView(this.f, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void s() {
        try {
            j jVar = this.a;
            if (jVar != null) {
                jVar.f();
            }
            Class cls = this.b;
            this.a = cls == null ? new k(this) : (j) cls.getConstructor(a.class).newInstance(this);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a() {
        SigmobLog.d("startVideo [" + hashCode() + "] ");
        try {
            s();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Window c2 = d.c(getContext());
        if (c2 != null) {
            c2.setFlags(16777216, 16777216);
            c2.addFlags(128);
        }
        m();
        b();
    }

    public void a(int i) {
        e eVar = this.e;
        if (eVar != e.STATE_PAUSE && eVar != e.STATE_PREPARED && eVar != e.STATE_AUTO_COMPLETE && eVar != e.STATE_PLAYING) {
            this.g = i;
            return;
        }
        j jVar = this.a;
        if (jVar != null) {
            jVar.a(i);
        }
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void a(int i, int i2) {
        this.s = i;
        this.t = "" + i2;
        setState(e.STATE_ERROR);
    }

    public void a(h hVar, int i) {
        this.d = hVar;
        c();
    }

    public void b() {
        SigmobLog.d("onStatePreparing  [" + hashCode() + "] ");
        setState(e.STATE_PREPARING);
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void b(int i, int i2) {
        e eVar;
        SigmobLog.d("onInfo() called with: what = [" + i + "], extra = [" + i2 + "]");
        if (i == 3) {
            if (!this.k) {
                this.k = true;
                this.l.removeMessages(6000);
            }
            if (!this.j) {
                return;
            } else {
                this.j = false;
            }
        } else if (i == 701) {
            eVar = e.STATE_BUFFERING_START;
            setState(eVar);
        } else if (i != 702) {
            return;
        }
        eVar = e.STATE_BUFFERING_END;
        setState(eVar);
    }

    public void c() {
        SigmobLog.d("onStateNormal stat" + this.e + " [" + hashCode() + "] ");
        setState(e.STATE_NORMAL);
        j jVar = this.a;
        if (jVar != null) {
            jVar.f();
        }
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void c(int i, int i2) {
        this.o = i2;
        this.p = i;
        SigmobLog.d("onVideoSizeChanged  [" + hashCode() + "] ");
        m mVar = this.f676c;
        if (mVar != null) {
            float f = this.q;
            if (f != com.sigmob.sdk.base.blurkit.c.d) {
                mVar.setRotation(f);
            }
            this.f676c.a(i, i2);
        }
    }

    public void d() {
        j jVar;
        this.n = false;
        e eVar = this.e;
        if (eVar == e.STATE_NORMAL || (jVar = this.a) == null) {
            a();
            return;
        }
        if (eVar == e.STATE_PAUSE || eVar == e.STATE_BUFFERING_END || eVar == e.STATE_AUTO_COMPLETE || eVar == e.STATE_PREPARED) {
            jVar.a();
            e();
        }
    }

    public void e() {
        SigmobLog.d("onStatePlaying  [" + hashCode() + "] ");
        if (this.e == e.STATE_PREPARED) {
            int i = this.g;
            if (i != 0) {
                this.a.a(i);
                this.g = 0;
            }
            if (!this.k) {
                this.l.sendEmptyMessageDelayed(6000, 3000L);
            }
        }
        setState(e.STATE_PLAYING);
        f();
    }

    public void f() {
        SigmobLog.d("startProgressTimer:  [" + hashCode() + "] ");
        l();
        this.h = new Timer();
        C0065a c0065a = new C0065a();
        this.i = c0065a;
        this.h.schedule(c0065a, 0L, 300L);
    }

    public boolean g() {
        return this.v;
    }

    public long getCurrentPositionWhenPlaying() {
        e eVar = this.e;
        if (eVar != e.STATE_PLAYING && eVar != e.STATE_PAUSE) {
            return 0L;
        }
        try {
            return this.a.g();
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public long getDuration() {
        try {
            j jVar = this.a;
            if (jVar != null) {
                return jVar.j();
            }
            return 0L;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public int getErrorCode() {
        return this.s;
    }

    public String getErrorMessage() {
        return this.t;
    }

    public int getVideoHeight() {
        return this.o;
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public h getVideoPlayerDataSource() {
        return this.d;
    }

    public int getVideoWidth() {
        return this.p;
    }

    public void h() {
        SigmobLog.d("reset  [" + hashCode() + "] ");
        l();
        c();
        this.f.removeAllViews();
        Window c2 = d.c(getContext());
        if (c2 != null) {
            c2.clearFlags(128);
        }
        j jVar = this.a;
        if (jVar != null) {
            jVar.f();
        }
    }

    public void i() {
        setState(e.STATE_STOP);
        h();
    }

    public void j() {
        e eVar = this.e;
        if (eVar == e.STATE_NORMAL || eVar == e.STATE_PREPARING || eVar == e.STATE_ERROR) {
            h();
        } else {
            if (eVar == e.STATE_PAUSE || this.a == null) {
                return;
            }
            k();
            this.a.d();
        }
    }

    public void k() {
        SigmobLog.i("onStatePause  [" + hashCode() + "] ");
        setState(e.STATE_PAUSE);
        f();
    }

    public void l() {
        Timer timer = this.h;
        if (timer != null) {
            timer.cancel();
        }
        C0065a c0065a = this.i;
        if (c0065a != null) {
            c0065a.cancel();
        }
    }

    public void m() {
        SigmobLog.d("addTextureView [" + hashCode() + "] ");
        m mVar = this.f676c;
        if (mVar != null) {
            this.f.removeView(mVar);
        }
        m mVar2 = new m(getContext().getApplicationContext());
        this.f676c = mVar2;
        mVar2.setSurfaceTextureListener(this.a);
        this.f.addView(this.f676c, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public void n() {
        this.n = true;
        a();
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void o() {
        SigmobLog.d("onPrepared  [" + hashCode() + "] ");
        setState(e.STATE_PREPARED);
        setMute(this.m);
        if (this.n) {
            return;
        }
        SigmobLog.d("mediaInterface start");
        e();
        this.a.a();
        this.n = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SigmobLog.d("onAttachedToWindow");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void p() {
        setState(e.STATE_AUTO_COMPLETE);
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void q() {
    }

    public void r() {
        this.r = null;
        h();
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void setBufferProgress(int i) {
    }

    public void setLooping(boolean z) {
        try {
            j jVar = this.a;
            if (jVar != null) {
                jVar.a(z);
                this.v = z;
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public void setMute(boolean z) {
        j jVar;
        float f;
        this.m = z;
        if (z) {
            jVar = this.a;
            if (jVar == null) {
                return;
            } else {
                f = com.sigmob.sdk.base.blurkit.c.d;
            }
        } else {
            jVar = this.a;
            if (jVar == null) {
                return;
            } else {
                f = 1.0f;
            }
        }
        jVar.a(f);
    }

    public void setState(e eVar) {
        this.e = eVar;
        l lVar = this.r;
        if (lVar != null) {
            lVar.a(eVar);
        }
    }

    @Override // com.sigmob.sdk.videoplayer.i
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        m mVar = this.f676c;
        if (mVar != null) {
            mVar.setSurfaceTexture(surfaceTexture);
        }
    }

    public void setTextureViewContainer(ViewGroup viewGroup) {
        this.f = viewGroup;
    }

    public void setUp(String str) {
        a(new h(str, (String) null), 0);
    }

    public void setVideoPlayerStatusListener(l lVar) {
        this.r = lVar;
    }
}
