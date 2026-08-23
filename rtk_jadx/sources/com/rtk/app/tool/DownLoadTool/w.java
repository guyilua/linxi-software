package com.rtk.app.tool.DownLoadTool;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.rtk.app.R;

/* compiled from: MySubjectUpdataRtk.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class w implements y {
    private int a;
    private ProgressBar b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f294c;

    /* compiled from: MySubjectUpdataRtk.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements Runnable {
        final /* synthetic */ long a;
        final /* synthetic */ String b;

        a(long j, String str) {
            this.a = j;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.this.b.setMax(100);
            w.this.b.setProgress((int) this.a);
            w.this.f294c.setText(this.b);
        }
    }

    /* compiled from: MySubjectUpdataRtk.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w.this.f294c.setText("继续");
        }
    }

    /* compiled from: MySubjectUpdataRtk.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w.this.b.setMax(100);
            w.this.b.setProgress(100);
            w.this.f294c.setText("安装");
        }
    }

    /* compiled from: MySubjectUpdataRtk.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w.this.f294c.setText(R.string.download_wait);
        }
    }

    /* compiled from: MySubjectUpdataRtk.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w.this.f294c.setText("重新下载");
        }
    }

    /* compiled from: MySubjectUpdataRtk.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w.this.f294c.setText("下载");
            w.this.b.setSecondaryProgress(0);
            w.this.b.setProgress(0);
        }
    }

    /* compiled from: MySubjectUpdataRtk.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class g implements Runnable {
        final /* synthetic */ int a;

        g(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.this.b.setMax(100);
            w.this.b.setProgress(this.a);
            w.this.f294c.setText("解压中");
        }
    }

    public w(ProgressBar progressBar, int i, TextView... textViewArr) {
        this.a = i;
        this.b = progressBar;
        this.f294c = textViewArr[0];
        if (textViewArr.length > 1) {
            TextView textView = textViewArr[1];
        }
        x.c().m((w) progressBar.getTag());
        progressBar.setTag(this);
    }

    @Override // com.rtk.app.tool.DownLoadTool.y
    public void a(int i) {
    }

    @Override // com.rtk.app.tool.DownLoadTool.y
    public void b(int i) {
        int intValue = ((Integer) this.f294c.getTag()).intValue();
        this.a = intValue;
        if (intValue != 0 && intValue == i) {
            this.b.post(new c());
        }
    }

    @Override // com.rtk.app.tool.DownLoadTool.y
    public void c(long j, long j2, int i, String str, long j3, long j4) {
        int intValue = ((Integer) this.f294c.getTag()).intValue();
        this.a = intValue;
        if (intValue != 0 && intValue == i) {
            this.b.post(new a(j2, str));
        }
    }

    @Override // com.rtk.app.tool.DownLoadTool.y
    public void d(int i, String str) {
        int intValue = ((Integer) this.f294c.getTag()).intValue();
        this.a = intValue;
        if (intValue != 0 && intValue == i) {
            this.b.post(new e());
        }
    }

    @Override // com.rtk.app.tool.DownLoadTool.y
    public void e(int i) {
        int intValue = ((Integer) this.f294c.getTag()).intValue();
        this.a = intValue;
        if (intValue != 0 && intValue == i) {
            this.b.post(new b());
        }
    }

    @Override // com.rtk.app.tool.DownLoadTool.y
    public void f(int i) {
        int intValue = ((Integer) this.f294c.getTag()).intValue();
        this.a = intValue;
        if (intValue != 0 && intValue == i) {
            this.b.post(new d());
        }
    }

    @Override // com.rtk.app.tool.DownLoadTool.y
    public void g(int i, int i2) {
        int intValue = ((Integer) this.f294c.getTag()).intValue();
        this.a = intValue;
        if (intValue != 0 && intValue == i2) {
            this.b.post(new g(i));
        }
    }

    @Override // com.rtk.app.tool.DownLoadTool.y
    public void h(int i) {
        int intValue = ((Integer) this.f294c.getTag()).intValue();
        this.a = intValue;
        if (intValue != 0 && intValue == i) {
            this.b.post(new f());
        }
    }
}
