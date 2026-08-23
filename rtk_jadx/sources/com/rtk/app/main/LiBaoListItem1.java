package com.rtk.app.main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
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
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Level;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class LiBaoListItem1 extends com.rtk.app.base.g implements h.j, View.OnClickListener {
    private ViewHolder j;
    public LibaolistViewAdapter k;
    private Context l;
    private View m;
    private int n;
    public List<LiBaoListBean.DataBean> o;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        AutoListView libaoListViewPagerItem1ListView;

        @BindView
        TextView libaoListViewpagerItem1Btu;

        @BindView
        EditText libaoListViewpagerItem1ET;

        ViewHolder(LiBaoListItem1 liBaoListItem1, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.libaoListViewpagerItem1ET = (EditText) butterknife.c.a.c(view, R.id.libao_list_viewpager_item1_ET, "field 'libaoListViewpagerItem1ET'", EditText.class);
            viewHolder.libaoListViewpagerItem1Btu = (TextView) butterknife.c.a.c(view, R.id.libao_list_viewpager_item1_btu, "field 'libaoListViewpagerItem1Btu'", TextView.class);
            viewHolder.libaoListViewPagerItem1ListView = (AutoListView) butterknife.c.a.c(view, R.id.libao_list_viewPager_item1_listView, "field 'libaoListViewPagerItem1ListView'", AutoListView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.libaoListViewpagerItem1ET = null;
                viewHolder.libaoListViewpagerItem1Btu = null;
                viewHolder.libaoListViewPagerItem1ListView = null;
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
            LiBaoListItem1.this.t();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.c {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            LiBaoListItem1.this.n = 1;
            LiBaoListItem1.this.t();
            LiBaoListItem1.this.j.libaoListViewPagerItem1ListView.setLoadEnable(false);
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
            if (LiBaoListItem1.this.o.size() == 0) {
                return;
            }
            Context context = this.a;
            StringBuilder sb = new StringBuilder();
            int i2 = i - 1;
            sb.append(LiBaoListItem1.this.o.get(i2).getGift_id());
            sb.append("");
            com.rtk.app.tool.t.f0(context, sb.toString(), 11, i2);
        }
    }

    public LiBaoListItem1(Context context, View view) {
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
        m();
        com.rtk.app.tool.c0.a("LiBaoListItem1", "礼包" + str, 2, new Level[0]);
        this.j.libaoListViewPagerItem1ListView.k();
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
        this.j.libaoListViewPagerItem1ListView.setResultSize(liBaoListBean.getData().size());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (this.n == 1) {
            p(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.p
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    LiBaoListItem1.this.v(strArr);
                }
            });
        }
        com.rtk.app.tool.c0.u("LiBaoListItem1", "礼包错误" + str);
        this.j.libaoListViewPagerItem1ListView.f();
    }

    @Override // com.rtk.app.base.g
    public void h(Context context, View view) {
        this.j.libaoListViewPagerItem1ListView.setOnLoadListener(new a());
        this.j.libaoListViewPagerItem1ListView.setOnRefreshListener(new b());
        this.j.libaoListViewPagerItem1ListView.setOnItemClickListener(new c(context));
        this.j.libaoListViewpagerItem1Btu.setOnClickListener(this);
    }

    @Override // com.rtk.app.base.g
    public void i(Context context, View view) {
        this.j = new ViewHolder(this, view);
        this.o = new ArrayList();
        LibaolistViewAdapter libaolistViewAdapter = new LibaolistViewAdapter(context, this.o);
        this.k = libaolistViewAdapter;
        this.j.libaoListViewPagerItem1ListView.setAdapter((ListAdapter) libaolistViewAdapter);
    }

    @Override // com.rtk.app.base.g
    public void k() {
        this.n = 1;
        t();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131298956) {
            return;
        }
        String trim = this.j.libaoListViewpagerItem1ET.getText().toString().trim();
        if (com.rtk.app.tool.c0.q(trim)) {
            com.rtk.app.tool.f.a(this.l, "请输入游戏名！", f.a.f);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("searchContent", trim);
        com.rtk.app.tool.c.b((Activity) this.l, LiBaoSearchActivity.class, bundle);
    }

    public void t() {
        com.rtk.app.tool.o.h.l(this.l, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a("game/libaolist" + com.rtk.app.tool.y.u(this.l) + "&uid=" + com.rtk.app.tool.y.K() + "&model=now&page=" + this.n + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.l, new String[0])))));
    }
}
