package com.rtk.app.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.rtk.app.R;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseItem.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class g {
    protected Context a;
    protected View b;

    /* renamed from: c, reason: collision with root package name */
    private ViewGroup f151c;
    private View d;
    private ViewGroup f;
    private s g;
    private ViewGroup h;
    private List<Integer> e = new ArrayList();
    private boolean i = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseItem.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.g != null) {
                g.this.g.a(new String[0]);
            }
            g.this.l();
            g.this.f151c.addView(g.this.d);
        }
    }

    /* compiled from: BaseItem.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.l();
            g.this.f151c.addView(g.this.d);
            if (g.this.g != null) {
                g.this.g.a(new String[0]);
            }
        }
    }

    public g(Context context, View view) {
        this.a = context;
        this.b = view;
        f();
        i(context, view);
        h(context, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        ViewGroup viewGroup = this.f;
        if (viewGroup != null) {
            this.f151c.removeView(viewGroup);
        }
        View view = this.d;
        if (view != null) {
            this.f151c.removeView(view);
        }
        ViewGroup viewGroup2 = this.h;
        if (viewGroup2 != null) {
            this.f151c.removeView(viewGroup2);
        }
    }

    private void o(s sVar) {
        try {
            if (this.i) {
                return;
            }
            this.g = sVar;
            l();
            this.f151c.addView(this.f);
            this.f.getChildAt(2).setOnClickListener(new a());
        } catch (Exception unused) {
        }
    }

    public void f() {
    }

    public abstract void h(Context context, View view);

    public abstract void i(Context context, View view);

    public void j() {
    }

    public void k() {
    }

    public void m() {
        for (int i = 0; i < this.f151c.getChildCount(); i++) {
            if (this.e.contains(Integer.valueOf(this.f151c.getChildAt(i).getId()))) {
                this.e.remove(Integer.valueOf(this.f151c.getChildAt(i).getId()));
                this.f151c.getChildAt(i).setVisibility(0);
            }
        }
        l();
        this.i = true;
    }

    public void n(View view, View view2) {
        l();
        this.f151c = (ViewGroup) view;
        for (int i = 0; i < this.f151c.getChildCount(); i++) {
            if (this.f151c.getChildAt(i).getId() != view2.getId() && this.f151c.getChildAt(i).getVisibility() == 0) {
                this.f151c.getChildAt(i).setVisibility(8);
                this.e.add(Integer.valueOf(this.f151c.getChildAt(i).getId()));
            }
        }
        if (this.d == null) {
            this.d = LayoutInflater.from(this.a).inflate(R.layout.auto_max_footview_load_layout, (ViewGroup) null);
        }
        this.d.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (this.f == null) {
            this.f = (ViewGroup) LayoutInflater.from(this.a).inflate(R.layout.auto_no_interner_layout, (ViewGroup) null);
        }
        this.f.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (this.h == null) {
            this.h = (ViewGroup) LayoutInflater.from(this.a).inflate(R.layout.auto_src_dissmiss_layout, (ViewGroup) null);
        }
        this.h.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f151c.addView(this.d);
    }

    public void p(String str, s sVar) {
        if (str.equals(y.E)) {
            o(sVar);
            return;
        }
        try {
            if (this.i) {
                return;
            }
            this.g = sVar;
            l();
            this.f151c.addView(this.h);
            ((TextView) this.h.getChildAt(1)).setText(t.O1(str));
            this.h.getChildAt(2).setOnClickListener(new b());
        } catch (Exception unused) {
        }
    }

    public void q() {
    }
}
