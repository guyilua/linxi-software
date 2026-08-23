package com.rtk.app.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {
    protected View a;
    protected Context e;
    protected Gson f;
    private ViewGroup g;
    private ViewGroup h;
    private ViewGroup l;
    private ViewGroup m;
    private s n;
    protected boolean b = true;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f149c = false;
    protected boolean d = false;
    private List<Integer> i = new ArrayList();
    private boolean j = false;
    private boolean k = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(View view) {
        p();
        this.g.addView(this.h);
        this.k = true;
        this.n.a(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(View view) {
        p();
        this.g.addView(this.h);
        this.n.a(new String[0]);
    }

    private void p() {
        ViewGroup viewGroup = this.l;
        if (viewGroup != null) {
            this.g.removeView(viewGroup);
        }
        ViewGroup viewGroup2 = this.h;
        if (viewGroup2 != null) {
            this.g.removeView(viewGroup2);
        }
        ViewGroup viewGroup3 = this.m;
        if (viewGroup3 != null) {
            this.g.removeView(viewGroup3);
        }
    }

    private void s(s sVar) {
        this.k = false;
        if (this.j) {
            c0.u("BaseFragment", "isLoad true");
            return;
        }
        if (sVar == null) {
            c0.s("BaseFragment", "loadDataCallBack is null");
            return;
        }
        if (this.g == null) {
            c0.s("BaseFragment", "groundFloorView is null");
            return;
        }
        this.n = sVar;
        p();
        this.g.addView(this.l);
        this.l.getChildAt(2).setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.base.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseFragment.this.k(view);
            }
        });
    }

    public void b() {
        if (!this.d) {
            i();
            f();
            this.d = true;
        }
        if (this.f149c && this.b) {
            D();
            h();
            this.b = false;
        }
    }

    public void c() {
        i();
        f();
        D();
        h();
    }

    /* renamed from: e */
    protected abstract void D();

    protected abstract void f();

    protected abstract void h();

    protected abstract void i();

    public void n() {
    }

    public void o() {
        this.j = false;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.e = getContext();
        this.f = new GsonBuilder().enableComplexMapKeySerialization().create();
    }

    public void onResume() {
        super.onResume();
        try {
            h();
        } catch (NullPointerException unused) {
        }
    }

    public void q() {
        if (this.g == null) {
            c0.s("BaseFragment", "groundFloorView");
            return;
        }
        p();
        if (this.g != null) {
            for (int i = 0; i < this.g.getChildCount(); i++) {
                if (this.i.contains(Integer.valueOf(this.g.getChildAt(i).getId()))) {
                    this.i.remove(Integer.valueOf(this.g.getChildAt(i).getId()));
                    this.g.getChildAt(i).setVisibility(0);
                }
            }
        }
        this.j = true;
        this.k = false;
        c0.u("BaseFragment", "setLoadDone()");
    }

    public void r(View view, View view2) {
        p();
        if (view != null) {
            this.g = (ViewGroup) view;
            for (int i = 0; i < this.g.getChildCount(); i++) {
                if (this.g.getChildAt(i).getId() != view2.getId() && this.g.getChildAt(i).getVisibility() == 0) {
                    this.g.getChildAt(i).setVisibility(8);
                    this.i.add(Integer.valueOf(this.g.getChildAt(i).getId()));
                }
            }
        }
        if (this.h == null) {
            this.h = (ViewGroup) LayoutInflater.from(this.e).inflate(R.layout.auto_max_footview_load_layout, (ViewGroup) null);
        }
        this.h.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (this.l == null) {
            this.l = (ViewGroup) LayoutInflater.from(this.e).inflate(R.layout.auto_no_interner_layout, (ViewGroup) null);
        }
        this.l.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (this.m == null) {
            this.m = (ViewGroup) LayoutInflater.from(this.e).inflate(R.layout.auto_src_dissmiss_layout, (ViewGroup) null);
        }
        this.m.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.g.addView(this.h);
        this.k = true;
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.f149c = z;
        if (z && this.d) {
            b();
        }
        if (this.n == null) {
            c0.s("BaseFragment", "loadDataCallBack is null");
            return;
        }
        if (!z || this.i.size() <= 0 || this.j || this.k) {
            return;
        }
        this.k = true;
        p();
        this.g.addView(this.h);
        this.n.a(new String[0]);
    }

    public void t(String str, s sVar) {
        c0.u("BaseFragment", "setSrcDissmiss isLoad:" + this.j);
        if (str.equals(y.E)) {
            s(sVar);
            c0.u("BaseFragment", "setSrcDissmiss isLoad:1" + this.j);
            return;
        }
        if (this.j) {
            c0.u("BaseFragment", "isLoad true");
            return;
        }
        if (sVar == null) {
            c0.s("BaseFragment", "loadDataCallBack is null");
            return;
        }
        if (this.g == null) {
            c0.s("BaseFragment", "groundFloorView is null");
            return;
        }
        c0.u("BaseFragment", "setSrcDissmiss isLoad:2" + this.j);
        this.n = sVar;
        p();
        this.g.addView(this.m);
        ((TextView) this.m.getChildAt(1)).setText(t.O1(str));
        this.m.getChildAt(2).setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.base.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseFragment.this.m(view);
            }
        });
    }
}
