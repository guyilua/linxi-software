package com.rtk.app.tool.DownLoadTool;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.rtk.app.R;
import com.rtk.app.tool.c0;

/* compiled from: MySubJect.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class u implements y {
    private int a;
    private ProgressBar b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f290c;
    private TextView d;

    /* compiled from: MySubJect.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ long b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f291c;

        a(int i, long j, String str) {
            this.a = i;
            this.b = j;
            this.f291c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a == ((Integer) u.this.f290c.getTag()).intValue()) {
                u.this.b.setMax(100);
                u.this.b.setProgress((int) this.b);
                u.this.f290c.setText(this.f291c);
            }
        }
    }

    /* compiled from: MySubJect.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (u.this.d == null) {
                u.this.f290c.setText("打开");
                u.this.b.setSecondaryProgress(100);
                c0.u("MySubJect", "设置为打开");
            } else {
                u.this.d.setVisibility(0);
                u.this.f290c.setText("重新下载");
                u.this.b.setSecondaryProgress(0);
                u.this.b.setProgress(0);
            }
        }
    }

    public u(ProgressBar progressBar, int i, TextView... textViewArr) {
        this.a = i;
        this.b = progressBar;
        this.f290c = textViewArr[0];
        if (textViewArr.length > 1) {
            this.d = textViewArr[1];
        }
        u uVar = (u) progressBar.getTag();
        if (uVar != null) {
            x.c().m(uVar);
        }
        progressBar.setTag(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(int i, int i2) {
        if (i == ((Integer) this.f290c.getTag()).intValue()) {
            this.b.setMax(100);
            this.b.setProgress(i2);
            this.f290c.setText("解压中");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o() {
        this.f290c.setText("重新下载");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q() {
        this.f290c.setText("下载");
        this.b.setSecondaryProgress(0);
        this.b.setProgress(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s() {
        this.f290c.setText(R.string.download_wait);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u() {
        this.f290c.setText("继续");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w() {
        this.b.setMax(100);
        this.b.setProgress(100);
        this.f290c.setText("安装");
    }

    @Override // com.rtk.app.tool.DownLoadTool.y
    public void a(int i) {
        int intValue = ((Integer) this.f290c.getTag()).intValue();
        this.a = intValue;
        if (intValue != 0 && intValue == i) {
            this.b.post(new b());
        }
    }

    @Override // com.rtk.app.tool.DownLoadTool.y
    public void b(int i) {
        int intValue = ((Integer) this.f290c.getTag()).intValue();
        this.a = intValue;
        if (intValue != 0 && intValue == i) {
            this.b.post(new Runnable() { // from class: com.rtk.app.tool.DownLoadTool.j
                @Override // java.lang.Runnable
                public final void run() {
                    u.this.w();
                }
            });
        }
    }

    @Override // com.rtk.app.tool.DownLoadTool.y
    public void c(long j, long j2, int i, String str, long j3, long j4) {
        int intValue = ((Integer) this.f290c.getTag()).intValue();
        this.a = intValue;
        if (intValue != 0 && intValue == i) {
            this.b.post(new a(i, j2, str));
        }
    }

    @Override // com.rtk.app.tool.DownLoadTool.y
    public void d(int i, String str) {
        int intValue = ((Integer) this.f290c.getTag()).intValue();
        this.a = intValue;
        if (intValue != 0 && intValue == i) {
            this.b.post(new Runnable() { // from class: com.rtk.app.tool.DownLoadTool.k
                @Override // java.lang.Runnable
                public final void run() {
                    u.this.o();
                }
            });
        }
    }

    @Override // com.rtk.app.tool.DownLoadTool.y
    public void e(int i) {
        int intValue = ((Integer) this.f290c.getTag()).intValue();
        this.a = intValue;
        if (intValue != 0 && intValue == i) {
            this.b.post(new Runnable() { // from class: com.rtk.app.tool.DownLoadTool.g
                @Override // java.lang.Runnable
                public final void run() {
                    u.this.u();
                }
            });
        }
    }

    @Override // com.rtk.app.tool.DownLoadTool.y
    public void f(int i) {
        int intValue = ((Integer) this.f290c.getTag()).intValue();
        this.a = intValue;
        if (intValue != 0 && intValue == i) {
            this.b.post(new Runnable() { // from class: com.rtk.app.tool.DownLoadTool.l
                @Override // java.lang.Runnable
                public final void run() {
                    u.this.s();
                }
            });
        }
    }

    @Override // com.rtk.app.tool.DownLoadTool.y
    public void g(final int i, final int i2) {
        int intValue = ((Integer) this.f290c.getTag()).intValue();
        this.a = intValue;
        if (intValue != 0 && intValue == i2) {
            this.b.post(new Runnable() { // from class: com.rtk.app.tool.DownLoadTool.i
                @Override // java.lang.Runnable
                public final void run() {
                    u.this.m(i2, i);
                }
            });
        }
    }

    @Override // com.rtk.app.tool.DownLoadTool.y
    public void h(int i) {
        int intValue = ((Integer) this.f290c.getTag()).intValue();
        this.a = intValue;
        if (intValue != 0 && intValue == i) {
            this.b.post(new Runnable() { // from class: com.rtk.app.tool.DownLoadTool.h
                @Override // java.lang.Runnable
                public final void run() {
                    u.this.q();
                }
            });
        }
    }
}
