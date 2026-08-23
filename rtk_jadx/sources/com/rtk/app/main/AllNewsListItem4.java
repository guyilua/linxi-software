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
import com.rtk.app.adapter.NewsAdapter;
import com.rtk.app.bean.NewsBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AllNewsListItem4 extends com.rtk.app.base.g implements View.OnClickListener, h.j {
    private int j;
    private Context k;
    private View l;
    private List<NewsBean.DataBean> m;
    private NewsAdapter n;
    private ViewHolder o;
    private int p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder {

        @BindView
        AutoListView allNewsItem4Listview;

        ViewHolder(AllNewsListItem4 allNewsListItem4, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.allNewsItem4Listview = (AutoListView) butterknife.c.a.c(view, R.id.all_news_item4_listview, "field 'allNewsItem4Listview'", AutoListView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.allNewsItem4Listview = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            int i2 = i - 1;
            com.rtk.app.tool.t.z0(this.a, Integer.parseInt(((NewsBean.DataBean) AllNewsListItem4.this.m.get(i2)).getId()), ((NewsBean.DataBean) AllNewsListItem4.this.m.get(i2)).getNew_title());
        }
    }

    public AllNewsListItem4(Context context, View view, int i) {
        super(context, view);
        this.p = 1;
        this.j = i;
        this.l = view;
        this.k = context;
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u(String[] strArr) {
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w() {
        this.p = 1;
        x();
        this.o.allNewsItem4Listview.setLoadEnable(false);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        this.o.allNewsItem4Listview.k();
        com.rtk.app.tool.c0.a("AllNewsListItem4", "游戏资讯+----" + i + "" + str, 2, new Level[0]);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        NewsBean newsBean = (NewsBean) create.fromJson(str, NewsBean.class);
        if (newsBean.getCode() != 0) {
            return;
        }
        if (this.p == 1) {
            this.m.clear();
        }
        this.m.addAll(newsBean.getData());
        this.n.notifyDataSetChanged();
        this.o.allNewsItem4Listview.setResultSize(newsBean.getData().size());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (this.p == 1) {
            p(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.f
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    AllNewsListItem4.this.u(strArr);
                }
            });
        }
        this.o.allNewsItem4Listview.f();
    }

    @Override // com.rtk.app.base.g
    public void h(Context context, View view) {
        this.o.allNewsItem4Listview.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.e
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                AllNewsListItem4.this.w();
            }
        });
        this.o.allNewsItem4Listview.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.d
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                AllNewsListItem4.this.y();
            }
        });
        this.o.allNewsItem4Listview.setOnItemClickListener(new a(context));
    }

    @Override // com.rtk.app.base.g
    public void i(Context context, View view) {
        this.m = new ArrayList();
        this.n = new NewsAdapter(context, this.m);
        ViewHolder viewHolder = new ViewHolder(this, view);
        this.o = viewHolder;
        viewHolder.allNewsItem4Listview.setAdapter((ListAdapter) this.n);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void y() {
        com.rtk.app.tool.o.h.l(this.k, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a("news/newsList" + com.rtk.app.tool.y.u(this.k) + "&game_id=" + this.j + "&type=3&page=" + this.p + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.k, new String[0])))));
    }
}
