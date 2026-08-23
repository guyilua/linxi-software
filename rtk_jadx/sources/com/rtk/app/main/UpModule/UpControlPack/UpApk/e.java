package com.rtk.app.main.UpModule.UpControlPack.UpApk;

import android.os.Handler;
import android.os.Message;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.n;

/* compiled from: MyUpSubject.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e {
    private ProgressBar a;
    private CheckBox b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f214c;
    private TextView d;
    private TextView e;
    public int f;
    private long g;
    private double h;
    private DialogForProgressTip i;
    private Handler j = new a();

    /* compiled from: MyUpSubject.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1 && e.this.h > 1024.0d) {
                e.this.h -= e.this.h / 20.0d;
                e.this.d.setText(c0.k(e.this.h) + "/s");
                e.this.j.sendEmptyMessageDelayed(1, 500L);
                c0.r("UP_TAG MyUpSubject", "upid:" + e.this.f + " 更新" + c0.k(e.this.h) + "/s");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyUpSubject.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements Runnable {
        final /* synthetic */ long a;
        final /* synthetic */ long b;

        b(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            e eVar = e.this;
            eVar.l(eVar.f);
            if (e.this.g != 0 && currentTimeMillis != e.this.g) {
                e.this.h = n.a / ((currentTimeMillis - r2.g) / 1000.0d);
                e.this.d.setText(c0.k(e.this.h) + "/s");
                e.this.j.sendEmptyMessageDelayed(1, 500L);
            }
            e.this.e.setText(((this.a * 100) / this.b) + "%");
            e.this.g = currentTimeMillis;
            e.this.a.setMax((int) this.b);
            e.this.a.setProgress((int) this.a);
            e.this.b.setChecked(true);
            e.this.f214c.setVisibility(4);
            e.this.b.setVisibility(0);
            e.this.i.p(e.this.f);
            if (this.b == this.a) {
                c0.u("UP_TAG MyUpSubject", "total==current");
                e.this.d.setText("");
                e.this.b.setVisibility(8);
                e.this.f214c.setVisibility(0);
                e eVar2 = e.this;
                eVar2.l(eVar2.f);
            }
        }
    }

    public e(int i, ProgressBar progressBar, CheckBox checkBox, ImageView imageView, TextView textView, TextView textView2, DialogForProgressTip dialogForProgressTip) {
        this.f = i;
        this.a = progressBar;
        this.b = checkBox;
        this.f214c = imageView;
        this.d = textView;
        this.e = textView2;
        this.i = dialogForProgressTip;
        e eVar = (e) textView2.getTag();
        if (eVar != null) {
            c0.u("UP_TAG MyUpSubject", "他不是空的");
            eVar.l(i);
            f.b().h(eVar);
        }
        textView2.setTag(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n() {
        l(this.f);
        this.d.setText("网络异常");
        this.b.setChecked(true);
        this.f214c.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p() {
        this.i.p(this.f);
        l(this.f);
        this.d.setText("已暂停");
        this.b.setChecked(false);
        this.f214c.setVisibility(0);
    }

    public void l(int i) {
        if (i == this.f) {
            this.j.removeMessages(1);
        }
    }

    public void q(int i) {
        int intValue = ((Integer) this.a.getTag()).intValue();
        this.f = intValue;
        if (intValue == i) {
            c0.u("UP_TAG MyUpSubject", "observerStart upApkId:" + this.f);
            this.a.post(new Runnable() { // from class: com.rtk.app.main.UpModule.UpControlPack.UpApk.a
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.n();
                }
            });
        }
    }

    public void r(int i) {
        if (this.f == i) {
            c0.u("UP_TAG MyUpSubject", "observerStop upApkId:" + this.f);
            this.a.post(new Runnable() { // from class: com.rtk.app.main.UpModule.UpControlPack.UpApk.b
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.p();
                }
            });
        }
    }

    public void s(long j, long j2, int i) {
        if (this.f == i) {
            c0.u("UP_TAG MyUpSubject", "observerUpData upApkId:" + this.f);
            this.a.post(new b(j2, j));
        }
    }
}
