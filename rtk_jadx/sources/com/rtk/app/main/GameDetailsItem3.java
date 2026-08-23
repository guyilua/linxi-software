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
import com.rtk.app.adapter.LibaolistViewAdapter;
import com.rtk.app.bean.LiBaoListBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Level;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GameDetailsItem3 extends com.rtk.app.base.g implements View.OnClickListener, h.j {
    private Context j;
    private View k;
    private ViewHolder l;
    private int m;
    private int n;
    private String o;
    public List<LiBaoListBean.DataBean> p;
    private LibaolistViewAdapter q;
    private boolean r;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ViewHolder {

        @BindView
        AutoListView gameDetailsItem3Listview;

        ViewHolder(View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.gameDetailsItem3Listview = (AutoListView) butterknife.c.a.c(view, R.id.game_details_item3_listview, "field 'gameDetailsItem3Listview'", AutoListView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.gameDetailsItem3Listview = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements AutoListView.c {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            GameDetailsItem3.this.m = 1;
            GameDetailsItem3.this.t();
            GameDetailsItem3.this.l.gameDetailsItem3Listview.setLoadEnable(false);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.b {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.b
        public void a() {
            GameDetailsItem3.this.t();
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
            Context context = this.a;
            StringBuilder sb = new StringBuilder();
            int i2 = i - 1;
            sb.append(GameDetailsItem3.this.p.get(i2).getGift_id());
            sb.append("");
            com.rtk.app.tool.t.f0(context, sb.toString(), 2, i2);
        }
    }

    public GameDetailsItem3(Context context, View view, int i) {
        super(context, view);
        this.m = 1;
        this.o = "";
        this.r = true;
        this.k = view;
        this.j = context;
        this.n = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(String[] strArr) {
        t();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        m();
        com.rtk.app.tool.c0.a("GameDetailsItem3", "礼包" + str, 2, new Level[0]);
        this.l.gameDetailsItem3Listview.k();
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        LiBaoListBean liBaoListBean = (LiBaoListBean) create.fromJson(str, LiBaoListBean.class);
        if (this.m == 1) {
            this.p.clear();
        }
        this.m++;
        this.p.addAll(liBaoListBean.getData());
        com.rtk.app.tool.c0.u("GameDetailsItem3", "游戏详情礼包列表长度" + this.p.size());
        this.q.notifyDataSetChanged();
        this.l.gameDetailsItem3Listview.setResultSize(liBaoListBean.getData().size());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.l.gameDetailsItem3Listview.f();
        if (this.m == 1) {
            p(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.o
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    GameDetailsItem3.this.v(strArr);
                }
            });
        }
    }

    @Override // com.rtk.app.base.g
    public void h(Context context, View view) {
        this.l.gameDetailsItem3Listview.setOnRefreshListener(new a());
        this.l.gameDetailsItem3Listview.setOnLoadListener(new b());
        this.l.gameDetailsItem3Listview.setOnItemClickListener(new c(context));
    }

    @Override // com.rtk.app.base.g
    public void i(Context context, View view) {
        this.l = new ViewHolder(view);
        this.p = new ArrayList();
        LibaolistViewAdapter libaolistViewAdapter = new LibaolistViewAdapter(context, this.p);
        this.q = libaolistViewAdapter;
        this.l.gameDetailsItem3Listview.setAdapter((ListAdapter) libaolistViewAdapter);
    }

    @Override // com.rtk.app.base.g
    public void k() {
        this.m = 1;
        t();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void t() {
        if (this.m == 1) {
            View view = this.k;
            n(view, view);
        }
        this.o = "&uid=" + com.rtk.app.tool.y.K();
        Context context = this.j;
        com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(new String[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("game/list_by_game");
        sb.append(com.rtk.app.tool.y.u(this.j));
        sb.append("&game_id=");
        sb.append(this.n);
        sb.append(this.o);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.j, "game_id=" + this.n))));
        com.rtk.app.tool.o.h.l(context, this, 1, h.a(sb.toString()));
    }

    public void w() {
        if (this.r) {
            t();
        }
        this.r = false;
    }
}
