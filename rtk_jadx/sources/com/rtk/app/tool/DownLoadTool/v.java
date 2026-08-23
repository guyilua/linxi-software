package com.rtk.app.tool.DownLoadTool;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.rtk.app.R;
import com.rtk.app.tool.c0;

/* compiled from: MySubJectForDownLoadActivity.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class v implements y {
    private int a;
    private ProgressBar b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f292c;
    private TextView d;
    private ImageView e;
    private TextView f;

    /* compiled from: MySubJectForDownLoadActivity.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.e.setSelected(true);
            v.this.e.setVisibility(0);
            v.this.f292c.setVisibility(4);
            v.this.d.setText("已暂停");
            v.this.b.setVisibility(0);
            v.this.f.setVisibility(0);
        }
    }

    /* compiled from: MySubJectForDownLoadActivity.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.b.setMax(100);
            v.this.b.setProgress(100);
            v.this.e.setVisibility(4);
            v.this.f292c.setVisibility(0);
            v.this.d.setText("下载完成，可安装");
            v.this.f292c.setText("安装");
            v.this.b.setVisibility(8);
        }
    }

    /* compiled from: MySubJectForDownLoadActivity.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.e.setVisibility(0);
            v.this.f292c.setVisibility(4);
            v.this.d.setText(R.string.download_wait);
            v.this.b.setVisibility(0);
            v.this.f.setVisibility(0);
        }
    }

    /* compiled from: MySubJectForDownLoadActivity.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class d implements Runnable {
        final /* synthetic */ String a;

        d(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.e.setVisibility(0);
            v.this.e.setSelected(true);
            v.this.f292c.setVisibility(4);
            v.this.d.setText("" + this.a);
            v.this.b.setVisibility(0);
            v.this.f.setVisibility(0);
        }
    }

    /* compiled from: MySubJectForDownLoadActivity.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.b.setSecondaryProgress(100);
            c0.u("MySubJectForDownLoadActivity", "设置为打开");
            v.this.e.setVisibility(4);
            v.this.f292c.setVisibility(4);
            v.this.b.setVisibility(0);
            v.this.f.setVisibility(0);
        }
    }

    /* compiled from: MySubJectForDownLoadActivity.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.b.setSecondaryProgress(0);
            v.this.b.setProgress(0);
        }
    }

    /* compiled from: MySubJectForDownLoadActivity.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class g implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ int b;

        g(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a == ((Integer) v.this.f292c.getTag()).intValue()) {
                v.this.b.setMax(100);
                v.this.b.setProgress(this.b);
                v.this.e.setVisibility(4);
                v.this.f292c.setVisibility(0);
                v.this.f292c.setText("解压中");
                v.this.d.setText("解压中");
                v.this.e.setSelected(false);
                v.this.b.setVisibility(0);
                v.this.f.setVisibility(0);
            }
        }
    }

    public v(ProgressBar progressBar, int i, TextView textView, ImageView imageView, TextView textView2, TextView textView3) {
        this.a = i;
        this.b = progressBar;
        this.f292c = textView;
        this.e = imageView;
        this.d = textView2;
        this.f = textView3;
        v vVar = (v) progressBar.getTag();
        if (vVar != null) {
            x.c().m(vVar);
        }
        progressBar.setTag(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(int i, long j, String str, long j2, long j3) {
        if (i == ((Integer) this.f292c.getTag()).intValue()) {
            this.b.setMax(100);
            this.b.setProgress((int) j);
            this.e.setVisibility(0);
            this.f292c.setVisibility(4);
            this.e.setSelected(false);
            this.d.setText(str);
            if (j2 != j3) {
                this.f.setText(c0.k(j3) + "/" + c0.k(j2));
            } else {
                this.f.setText(c0.k(j3));
            }
            this.b.setVisibility(0);
            this.f.setVisibility(0);
        }
    }

    @Override // com.rtk.app.tool.DownLoadTool.y
    public void a(int i) {
        int intValue = ((Integer) this.f292c.getTag()).intValue();
        this.a = intValue;
        if (intValue != 0 && intValue == i) {
            this.b.post(new e());
        }
    }

    @Override // com.rtk.app.tool.DownLoadTool.y
    public void b(int i) {
        int intValue = ((Integer) this.f292c.getTag()).intValue();
        this.a = intValue;
        if (intValue != 0 && intValue == i) {
            this.b.post(new b());
        }
    }

    @Override // com.rtk.app.tool.DownLoadTool.y
    public void c(long j, final long j2, final int i, final String str, final long j3, final long j4) {
        int intValue = ((Integer) this.f292c.getTag()).intValue();
        this.a = intValue;
        if (intValue != 0 && intValue == i) {
            this.b.post(new Runnable() { // from class: com.rtk.app.tool.DownLoadTool.m
                @Override // java.lang.Runnable
                public final void run() {
                    v.this.o(i, j2, str, j3, j4);
                }
            });
        }
    }

    @Override // com.rtk.app.tool.DownLoadTool.y
    public void d(int i, String str) {
        int intValue = ((Integer) this.f292c.getTag()).intValue();
        this.a = intValue;
        if (intValue != 0 && intValue == i) {
            this.b.post(new d(str));
        }
    }

    @Override // com.rtk.app.tool.DownLoadTool.y
    public void e(int i) {
        int intValue = ((Integer) this.f292c.getTag()).intValue();
        this.a = intValue;
        if (intValue != 0 && intValue == i) {
            this.b.post(new a());
        }
    }

    @Override // com.rtk.app.tool.DownLoadTool.y
    public void f(int i) {
        int intValue = ((Integer) this.f292c.getTag()).intValue();
        this.a = intValue;
        if (intValue != 0 && intValue == i) {
            this.b.post(new c());
        }
    }

    @Override // com.rtk.app.tool.DownLoadTool.y
    public void g(int i, int i2) {
        int intValue = ((Integer) this.f292c.getTag()).intValue();
        this.a = intValue;
        if (intValue != 0 && intValue == i2) {
            this.b.post(new g(i2, i));
        }
    }

    @Override // com.rtk.app.tool.DownLoadTool.y
    public void h(int i) {
        int intValue = ((Integer) this.f292c.getTag()).intValue();
        this.a = intValue;
        if (intValue != 0 && intValue == i) {
            this.b.post(new f());
        }
    }
}
