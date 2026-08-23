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
import com.rtk.app.adapter.GameListViewAdapter;
import com.rtk.app.bean.DataBean;
import com.rtk.app.bean.GameListBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TagListItem3 extends com.rtk.app.base.g implements h.j {
    private Context j;
    private Map<String, String> k;
    private int l;
    private GameListBean m;
    private ViewHolder n;
    private List<DataBean> o;
    private GameListViewAdapter p;
    private boolean q;
    private String r;
    private String s;
    private String t;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        AutoListView tagListItem3Listview;

        ViewHolder(TagListItem3 tagListItem3, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.tagListItem3Listview = (AutoListView) butterknife.c.a.c(view, R.id.tag_list_item3_listview, "field 'tagListItem3Listview'", AutoListView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.tagListItem3Listview = null;
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
            TagListItem3.this.u();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.c {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            com.rtk.app.tool.c0.u("TagListItem3", "setOnRefreshListener");
            TagListItem3.this.l = 1;
            TagListItem3.this.u();
            TagListItem3.this.n.tagListItem3Listview.setLoadEnable(false);
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
            com.rtk.app.tool.t.e0(this.a, new ApkInfo((DataBean) TagListItem3.this.o.get(i - 1)));
        }
    }

    public TagListItem3(Context context, View view, Map<String, String> map, String str) {
        super(context, view);
        this.l = 1;
        this.q = false;
        this.s = "";
        this.t = "";
        this.k = map;
        this.j = context;
        this.r = str;
        n(view, view);
        if (this.q) {
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(String[] strArr) {
        u();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("TagListItem3", "TagListItem3" + str);
        m();
        this.n.tagListItem3Listview.k();
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        this.m = (GameListBean) create.fromJson(str, GameListBean.class);
        if (this.l == 1) {
            this.o.clear();
        }
        this.l++;
        this.o.addAll(this.m.getData());
        this.p.notifyDataSetChanged();
        this.n.tagListItem3Listview.setResultSize(this.m.getData().size());
        com.rtk.app.tool.c0.u("TagListItem3", "精品尺寸" + this.o.size());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (this.l == 1) {
            p(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.j0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    TagListItem3.this.w(strArr);
                }
            });
        }
        this.n.tagListItem3Listview.f();
    }

    @Override // com.rtk.app.base.g
    public void h(Context context, View view) {
        this.n.tagListItem3Listview.setOnLoadListener(new a());
        this.n.tagListItem3Listview.setOnRefreshListener(new b());
        this.n.tagListItem3Listview.setOnItemClickListener(new c(context));
    }

    @Override // com.rtk.app.base.g
    public void i(Context context, View view) {
        this.n = new ViewHolder(this, view);
        this.o = new ArrayList();
        GameListViewAdapter gameListViewAdapter = new GameListViewAdapter(context, this.o);
        this.p = gameListViewAdapter;
        this.n.tagListItem3Listview.setAdapter((ListAdapter) gameListViewAdapter);
    }

    @Override // com.rtk.app.base.g
    public void j() {
        super.j();
        GameListViewAdapter gameListViewAdapter = this.p;
        if (gameListViewAdapter != null) {
            gameListViewAdapter.b();
        }
    }

    @Override // com.rtk.app.base.g
    public void q() {
        super.q();
        if (this.q) {
            return;
        }
        u();
        this.q = true;
    }

    public void u() {
        String str = "";
        for (String str2 : this.k.keySet()) {
            if (!str2.equals("games_type") && !str2.equals("games_language")) {
                str = str + "&" + str2 + "=" + this.k.get(str2);
            }
        }
        String str3 = this.k.get("games_type");
        if (com.rtk.app.tool.c0.q(str3)) {
            str3 = com.rtk.app.tool.y.t(this.j) + "";
        }
        String str4 = str + "&games_type=" + str3;
        String str5 = this.k.get("games_language");
        String str6 = com.rtk.app.tool.c0.q(str5) ? "" : str5;
        if (!com.rtk.app.tool.c0.q(this.t)) {
            str6 = this.t;
        }
        String str7 = str4 + "&games_language=" + str6;
        if (com.rtk.app.tool.c0.q(this.r)) {
            this.r = "game/gamelist";
        }
        Context context = this.j;
        com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(new String[0]);
        StringBuilder sb = new StringBuilder();
        sb.append(this.r);
        sb.append(com.rtk.app.tool.y.u(this.j));
        sb.append("&model=boutique&page=");
        sb.append(this.l);
        sb.append(str7);
        sb.append("&games_size=");
        sb.append(this.s);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.j, "games_type=" + str3))));
        com.rtk.app.tool.o.h.l(context, this, 1, h.a(sb.toString()));
    }

    public void x(String str, String str2) {
        this.s = str;
        this.t = str2;
        this.l = 1;
        u();
        this.n.tagListItem3Listview.setSelectionFromTop(0, 0);
    }
}
