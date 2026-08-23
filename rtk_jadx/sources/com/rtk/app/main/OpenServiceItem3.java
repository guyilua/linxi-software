package com.rtk.app.main;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.adapter.OpenServiceAdapter;
import com.rtk.app.bean.KaiFuBiaoBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class OpenServiceItem3 extends com.rtk.app.base.g implements h.j {
    private ViewHolder j;
    private Context k;
    private View l;
    private int m;
    private KaiFuBiaoBean n;
    private List<KaiFuBiaoBean.DataBean> o;
    private OpenServiceAdapter p;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        AutoListView openServiceItem3Listview;

        ViewHolder(OpenServiceItem3 openServiceItem3, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.openServiceItem3Listview = (AutoListView) butterknife.c.a.c(view, R.id.open_service_item3_listview, "field 'openServiceItem3Listview'", AutoListView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.openServiceItem3Listview = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.b
        public void a() {
            OpenServiceItem3.this.u();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.c {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            OpenServiceItem3.this.m = 1;
            OpenServiceItem3.this.j.openServiceItem3Listview.setLoadEnable(false);
            OpenServiceItem3.this.u();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c extends com.rtk.app.custom.AutoListView.b {
        final /* synthetic */ Context a;

        c(Context context) {
            this.a = context;
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            int i2 = i - 1;
            com.rtk.app.tool.t.e0(this.a, new ApkInfo(((KaiFuBiaoBean.DataBean) OpenServiceItem3.this.o.get(i2)).getGame_id(), ((KaiFuBiaoBean.DataBean) OpenServiceItem3.this.o.get(i2)).getGame_name(), ((KaiFuBiaoBean.DataBean) OpenServiceItem3.this.o.get(i2)).getPackage_name(), ((KaiFuBiaoBean.DataBean) OpenServiceItem3.this.o.get(i2)).getGame_logo(), ((KaiFuBiaoBean.DataBean) OpenServiceItem3.this.o.get(i2)).getData_package_size(), ((KaiFuBiaoBean.DataBean) OpenServiceItem3.this.o.get(i2)).getSignaturesMD5(), ((KaiFuBiaoBean.DataBean) OpenServiceItem3.this.o.get(i2)).getIs_apk(), ((KaiFuBiaoBean.DataBean) OpenServiceItem3.this.o.get(i2)).getVersion_code(), ((KaiFuBiaoBean.DataBean) OpenServiceItem3.this.o.get(i2)).getDownlist()));
        }
    }

    public OpenServiceItem3(Context context, View view) {
        super(context, view);
        this.m = 1;
        this.l = view;
        this.k = context;
        u();
        n(view, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(String[] strArr) {
        u();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        m();
        this.j.openServiceItem3Listview.k();
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        this.n = (KaiFuBiaoBean) create.fromJson(str, KaiFuBiaoBean.class);
        if (this.m == 1) {
            this.o.clear();
        }
        this.m++;
        this.o.addAll(this.n.getData());
        this.p.notifyDataSetChanged();
        this.j.openServiceItem3Listview.setResultSize(this.n.getData().size());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (this.m == 1) {
            p(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.v
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    OpenServiceItem3.this.w(strArr);
                }
            });
        }
        this.j.openServiceItem3Listview.f();
    }

    @Override // com.rtk.app.base.g
    public void h(Context context, View view) {
        this.j.openServiceItem3Listview.setOnLoadListener(new a());
        this.j.openServiceItem3Listview.setOnRefreshListener(new b());
        this.j.openServiceItem3Listview.setOnItemClickListener(new c(context));
    }

    @Override // com.rtk.app.base.g
    public void i(Context context, View view) {
        this.j = new ViewHolder(this, view);
        this.o = new ArrayList();
        OpenServiceAdapter openServiceAdapter = new OpenServiceAdapter(context, this.o);
        this.p = openServiceAdapter;
        this.j.openServiceItem3Listview.setAdapter((ListAdapter) openServiceAdapter);
    }

    @Override // com.rtk.app.base.g
    public void j() {
        super.j();
        this.p.b();
    }

    public void u() {
        com.rtk.app.tool.o.h.l(this.k, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a("game/kaifulist" + com.rtk.app.tool.y.u(this.k) + "&type=1&list=future&page=" + this.m + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.k, "type=1", "list=future")))));
    }
}
