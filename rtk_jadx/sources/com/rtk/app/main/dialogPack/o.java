package com.rtk.app.main.dialogPack;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseDiaolg.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class o extends Dialog implements View.OnClickListener {
    private Window a;
    private Context b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f255c;
    private ViewGroup d;
    private View e;
    private List<Integer> f;
    private ViewGroup g;
    private com.rtk.app.tool.s h;
    private ViewGroup i;
    private boolean j;

    /* compiled from: BaseDiaolg.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                int i = message.what;
                if (i == 0) {
                    o.super.show();
                } else if (i == 1) {
                    o.super.dismiss();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseDiaolg.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (o.this.h != null) {
                o.this.h.a(new String[0]);
            }
            o.this.j();
            o.this.d.addView(o.this.e);
        }
    }

    /* compiled from: BaseDiaolg.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (o.this.h != null) {
                o.this.h.a(new String[0]);
            }
            o.this.j();
            o.this.d.addView(o.this.e);
        }
    }

    public o(Context context) {
        super(context);
        this.f255c = new a();
        this.f = new ArrayList();
        this.j = false;
        this.b = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        ViewGroup viewGroup = this.g;
        if (viewGroup != null) {
            this.d.removeView(viewGroup);
        }
        View view = this.e;
        if (view != null) {
            this.d.removeView(view);
        }
        ViewGroup viewGroup2 = this.i;
        if (viewGroup2 != null) {
            this.d.removeView(viewGroup2);
        }
    }

    private void m(com.rtk.app.tool.s sVar) {
        try {
            if (this.j) {
                return;
            }
            this.h = sVar;
            j();
            this.d.addView(this.g);
            this.g.getChildAt(2).setOnClickListener(new b());
        } catch (Exception unused) {
        }
    }

    private void o(float f, float f2, int i) {
        Window window = getWindow();
        this.a = window;
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = (int) f;
        attributes.y = (int) f2;
        attributes.gravity = i;
        attributes.width = -1;
        attributes.height = -2;
        this.a.setAttributes(attributes);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.f255c.sendEmptyMessage(1);
    }

    public void i(int i, int i2) {
        setContentView(i);
        o(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d, i2);
        setCanceledOnTouchOutside(true);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
    }

    public void k() {
        for (int i = 0; i < this.d.getChildCount(); i++) {
            if (this.f.contains(Integer.valueOf(this.d.getChildAt(i).getId()))) {
                this.f.remove(Integer.valueOf(this.d.getChildAt(i).getId()));
                this.d.getChildAt(i).setVisibility(0);
            }
        }
        j();
        this.j = true;
    }

    public void l(View view, View view2) {
        j();
        this.d = (ViewGroup) view;
        for (int i = 0; i < this.d.getChildCount(); i++) {
            if (this.d.getChildAt(i).getId() != view2.getId() && this.d.getChildAt(i).getVisibility() == 0) {
                this.d.getChildAt(i).setVisibility(8);
                this.f.add(Integer.valueOf(this.d.getChildAt(i).getId()));
            }
        }
        if (this.e == null) {
            this.e = LayoutInflater.from(this.b).inflate(com.rtk.app.R.layout.auto_max_footview_load_layout, (ViewGroup) null);
        }
        this.e.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (this.g == null) {
            this.g = (ViewGroup) LayoutInflater.from(this.b).inflate(com.rtk.app.R.layout.auto_no_interner_layout, (ViewGroup) null);
        }
        this.g.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (this.i == null) {
            this.i = (ViewGroup) LayoutInflater.from(this.b).inflate(com.rtk.app.R.layout.auto_src_dissmiss_layout, (ViewGroup) null);
        }
        this.i.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.d.addView(this.e);
    }

    public void n(String str, com.rtk.app.tool.s sVar) {
        if (str.equals(com.rtk.app.tool.y.E)) {
            m(sVar);
            return;
        }
        try {
            if (this.j) {
                return;
            }
            this.h = sVar;
            j();
            this.d.addView(this.i);
            ((TextView) this.i.getChildAt(1)).setText(com.rtk.app.tool.t.O1(str));
            this.i.getChildAt(2).setOnClickListener(new c());
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Dialog
    public void show() {
        this.f255c.sendEmptyMessage(0);
    }
}
