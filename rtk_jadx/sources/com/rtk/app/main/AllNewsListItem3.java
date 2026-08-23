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
public class AllNewsListItem3 extends com.rtk.app.base.g implements View.OnClickListener, h.j {
    private int j;
    private Context k;
    private View l;
    private List<NewsBean.DataBean> m;
    private NewsAdapter n;
    private ViewHolder o;
    private int p;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        AutoListView allNewsItem3Listview;

        ViewHolder(AllNewsListItem3 allNewsListItem3, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.allNewsItem3Listview = (AutoListView) butterknife.c.a.c(view, R.id.all_news_item3_listview, "field 'allNewsItem3Listview'", AutoListView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.allNewsItem3Listview = null;
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
            AllNewsListItem3.this.p = 1;
            AllNewsListItem3.this.u();
            AllNewsListItem3.this.o.allNewsItem3Listview.setLoadEnable(false);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.b {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.b
        public void a() {
            AllNewsListItem3.this.u();
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
            com.rtk.app.tool.t.z0(this.a, Integer.parseInt(((NewsBean.DataBean) AllNewsListItem3.this.m.get(i2)).getId()), ((NewsBean.DataBean) AllNewsListItem3.this.m.get(i2)).getNew_title());
        }
    }

    public AllNewsListItem3(Context context, View view, int i) {
        super(context, view);
        this.p = 1;
        this.j = i;
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
        this.o.allNewsItem3Listview.k();
        com.rtk.app.tool.c0.a("AllNewsListItem3", "游戏资讯+----" + i + "" + str, 2, new Level[0]);
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
        this.o.allNewsItem3Listview.setResultSize(newsBean.getData().size());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (this.p == 1) {
            p(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.c
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    AllNewsListItem3.this.w(strArr);
                }
            });
        }
        this.o.allNewsItem3Listview.f();
    }

    @Override // com.rtk.app.base.g
    public void h(Context context, View view) {
        this.o.allNewsItem3Listview.setOnRefreshListener(new a());
        this.o.allNewsItem3Listview.setOnLoadListener(new b());
        this.o.allNewsItem3Listview.setOnItemClickListener(new c(context));
    }

    @Override // com.rtk.app.base.g
    public void i(Context context, View view) {
        this.m = new ArrayList();
        this.n = new NewsAdapter(context, this.m);
        ViewHolder viewHolder = new ViewHolder(this, view);
        this.o = viewHolder;
        viewHolder.allNewsItem3Listview.setAdapter((ListAdapter) this.n);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void u() {
        com.rtk.app.tool.o.h.l(this.k, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a("news/newsList" + com.rtk.app.tool.y.u(this.k) + "&game_id=" + this.j + "&type=2&page=" + this.p + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.k, new String[0])))));
    }
}
