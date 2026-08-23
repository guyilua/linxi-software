package com.rtk.app.main.Home5Activity;

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
import com.rtk.app.adapter.LibaolistViewAdapter;
import com.rtk.app.bean.LiBaoListBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Level;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MYLiBaoListItem2 extends com.rtk.app.base.g implements h.j {
    private ViewHolder j;
    public LibaolistViewAdapter k;
    private Context l;
    private View m;
    private int n;
    public List<LiBaoListBean.DataBean> o;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        AutoListView libaoListViewPagerItem2ListView;

        ViewHolder(MYLiBaoListItem2 mYLiBaoListItem2, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.libaoListViewPagerItem2ListView = (AutoListView) butterknife.c.a.c(view, R.id.libao_list_viewPager_item2_listView, "field 'libaoListViewPagerItem2ListView'", AutoListView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.libaoListViewPagerItem2ListView = null;
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
            MYLiBaoListItem2.this.t();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.c {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            MYLiBaoListItem2.this.n = 1;
            MYLiBaoListItem2.this.t();
            MYLiBaoListItem2.this.j.libaoListViewPagerItem2ListView.setLoadEnable(false);
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
            if (MYLiBaoListItem2.this.o.size() == 0) {
                return;
            }
            Context context = this.a;
            StringBuilder sb = new StringBuilder();
            int i2 = i - 1;
            sb.append(MYLiBaoListItem2.this.o.get(i2).getGift_id());
            sb.append("");
            com.rtk.app.tool.t.f0(context, sb.toString(), 12, i2);
        }
    }

    public MYLiBaoListItem2(Context context, View view) {
        super(context, view);
        this.n = 1;
        this.l = context;
        this.m = view;
        t();
        n(view, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(String[] strArr) {
        t();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.a("MYLiBaoListItem2", "礼包" + str, 2, new Level[0]);
        m();
        this.j.libaoListViewPagerItem2ListView.k();
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        LiBaoListBean liBaoListBean = (LiBaoListBean) create.fromJson(str, LiBaoListBean.class);
        if (this.n == 1) {
            this.o.clear();
        }
        this.n++;
        this.o.addAll(liBaoListBean.getData());
        this.k.notifyDataSetChanged();
        this.j.libaoListViewPagerItem2ListView.setResultSize(liBaoListBean.getData().size());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.j.libaoListViewPagerItem2ListView.f();
        if (this.n == 1) {
            p(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.Home5Activity.z
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    MYLiBaoListItem2.this.v(strArr);
                }
            });
        }
        com.rtk.app.tool.c0.u("MYLiBaoListItem2", "礼包错误" + str);
    }

    @Override // com.rtk.app.base.g
    public void h(Context context, View view) {
        this.j.libaoListViewPagerItem2ListView.setOnLoadListener(new a());
        this.j.libaoListViewPagerItem2ListView.setOnRefreshListener(new b());
        this.j.libaoListViewPagerItem2ListView.setOnItemClickListener(new c(context));
    }

    @Override // com.rtk.app.base.g
    public void i(Context context, View view) {
        this.j = new ViewHolder(this, view);
        this.o = new ArrayList();
        LibaolistViewAdapter libaolistViewAdapter = new LibaolistViewAdapter(context, this.o);
        this.k = libaolistViewAdapter;
        this.j.libaoListViewPagerItem2ListView.setAdapter((ListAdapter) libaolistViewAdapter);
    }

    public void t() {
        Context context = this.l;
        com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(new String[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("game/list_by_user");
        sb.append(com.rtk.app.tool.y.u(this.l));
        sb.append("&uid=");
        sb.append(com.rtk.app.tool.y.K());
        sb.append("&page=");
        sb.append(this.n);
        sb.append("&model=2&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.l, "uid=" + com.rtk.app.tool.y.K()))));
        com.rtk.app.tool.o.h.l(context, this, 1, h.a(sb.toString()));
    }
}
