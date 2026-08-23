package com.sigmob.sdk.nativead;

import android.content.Context;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.czhj.sdk.logger.SigmobLog;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class m extends View {
    private aa a;
    private boolean b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f615c;
    private a d;
    private int e;
    private long f;
    private int g;
    private int h;
    private boolean i;
    private boolean j;
    private int k;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a(boolean z);

        void f();

        void g();

        void h();

        void i();
    }

    public m(Context context) {
        this(context, null);
    }

    public m(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public m(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = false;
        this.f615c = true;
        this.f = 0L;
        this.g = 0;
        this.h = -1;
        this.i = false;
        this.k = -1;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (a() && e()) {
            ViewGroup viewGroup = (ViewGroup) getParent();
            int a2 = a(viewGroup);
            int height = viewGroup.getHeight() * viewGroup.getWidth();
            boolean z = height > 0 && ((float) a2) >= (((float) this.e) / 100.0f) * ((float) height);
            if (a2 > 0) {
                this.i = true;
                a aVar = this.d;
                if (aVar != null) {
                    aVar.i();
                }
            } else {
                this.i = false;
                this.f = 0L;
                a aVar2 = this.d;
                if (aVar2 != null) {
                    aVar2.h();
                }
            }
            if (a2 <= 0) {
                a aVar3 = this.d;
                if (aVar3 == null || !this.i) {
                    return;
                }
                aVar3.h();
                return;
            }
            if (z && this.i) {
                if (this.f == 0) {
                    this.f = System.currentTimeMillis();
                }
                boolean z2 = this.f > 0 && System.currentTimeMillis() - this.f >= ((long) (this.g * 1000));
                a aVar4 = this.d;
                if (aVar4 != null) {
                    aVar4.g();
                }
                a aVar5 = this.d;
                if (aVar5 != null) {
                    aVar5.a(z2);
                    return;
                }
                return;
            }
            a aVar6 = this.d;
            if (aVar6 != null) {
                aVar6.f();
            }
            a aVar7 = this.d;
            if (aVar7 != null) {
                aVar7.a(false);
            }
        } else {
            a aVar8 = this.d;
            if (aVar8 != null && this.i) {
                aVar8.h();
            }
            this.i = false;
        }
        this.f = 0L;
    }

    private void c() {
        f();
        this.a = null;
    }

    private void d() {
        aa aaVar = this.a;
        if (aaVar == null || !aaVar.b()) {
            return;
        }
        SigmobLog.d("-----------startTimer----------");
        this.a.removeCallbacksAndMessages(null);
        this.a.a();
        this.a.a(false);
    }

    private boolean e() {
        return this.b && this.h == 0 && this.f615c;
    }

    private void f() {
        b();
        aa aaVar = this.a;
        if (aaVar == null || aaVar.b()) {
            return;
        }
        SigmobLog.d("-----------stopTimer----------");
        this.a.removeCallbacksAndMessages(null);
        this.a.a(true);
    }

    public int a(View view) {
        Rect rect = new Rect();
        if (view.isShown() && view.getGlobalVisibleRect(rect)) {
            return rect.height() * rect.width();
        }
        return 0;
    }

    public void a(int i, int i2) {
        this.f615c = true;
        if (this.a != null) {
            c();
        }
        this.f615c = true;
        this.e = i;
        this.g = i2;
        this.a = new aa(Looper.getMainLooper()) { // from class: com.sigmob.sdk.nativead.m.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (87108 != message.what || m.this.d == null) {
                    return;
                }
                m.this.b();
                a();
            }
        };
        d();
    }

    public boolean a() {
        return getVisibility() == 0 && this.k == 0 && getParent() != null;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b = true;
        SigmobLog.d("---------onAttachedToWindow---------");
        d();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b = false;
        SigmobLog.d("---------onDetachedFromWindow----------");
        f();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        SigmobLog.d("---------onFinishTemporaryDetach-------------");
        d();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        SigmobLog.d("---------onStartTemporaryDetach-----------");
        f();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        SigmobLog.d("---------onVisibilityChanged---------" + i);
        this.k = i;
        if (i == 0) {
            d();
        } else {
            f();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        SigmobLog.d("---------onWindowFocusChanged: hasWindowFocus: " + z);
        this.f615c = z;
        if (this.i) {
            b();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.h = i;
        SigmobLog.d("---------onWindowVisibilityChanged: visibility: " + i);
        if (i == 0) {
            d();
        } else {
            f();
        }
    }

    public void setAdVisibilityStatusChangeListener(a aVar) {
        this.d = aVar;
    }
}
