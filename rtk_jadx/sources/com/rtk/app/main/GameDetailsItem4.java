package com.rtk.app.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.bean.NewsBean;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GameDetailsItem4 extends com.rtk.app.base.g implements h.j, View.OnClickListener {
    private Context j;
    private View k;
    private ViewHolder l;
    private int m;
    private int n;
    private boolean o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class NewsHolder {

        @BindView
        LinearLayout newsListObjectItemLayout;

        @BindView
        TextView newsListObjectItemLayoutAddTime;

        @BindView
        TextView newsListObjectItemLayoutContent;

        @BindView
        TextView newsListObjectItemLayoutTitle;

        @BindView
        TextView newsListObjectItemLayoutType;

        NewsHolder(View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class NewsHolder_ViewBinding implements Unbinder {
        private NewsHolder b;

        @UiThread
        public NewsHolder_ViewBinding(NewsHolder newsHolder, View view) {
            this.b = newsHolder;
            newsHolder.newsListObjectItemLayoutTitle = (TextView) butterknife.c.a.c(view, R.id.news_list_object_item_layout_title, "field 'newsListObjectItemLayoutTitle'", TextView.class);
            newsHolder.newsListObjectItemLayoutContent = (TextView) butterknife.c.a.c(view, R.id.news_list_object_item_layout_content, "field 'newsListObjectItemLayoutContent'", TextView.class);
            newsHolder.newsListObjectItemLayoutAddTime = (TextView) butterknife.c.a.c(view, R.id.news_list_object_item_layout_add_time, "field 'newsListObjectItemLayoutAddTime'", TextView.class);
            newsHolder.newsListObjectItemLayoutType = (TextView) butterknife.c.a.c(view, R.id.news_list_object_item_layout_type, "field 'newsListObjectItemLayoutType'", TextView.class);
            newsHolder.newsListObjectItemLayout = (LinearLayout) butterknife.c.a.c(view, R.id.news_list_object_item_layout, "field 'newsListObjectItemLayout'", LinearLayout.class);
        }

        @CallSuper
        public void a() {
            NewsHolder newsHolder = this.b;
            if (newsHolder != null) {
                this.b = null;
                newsHolder.newsListObjectItemLayoutTitle = null;
                newsHolder.newsListObjectItemLayoutContent = null;
                newsHolder.newsListObjectItemLayoutAddTime = null;
                newsHolder.newsListObjectItemLayoutType = null;
                newsHolder.newsListObjectItemLayout = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ViewHolder {

        @BindView
        LinearLayout gameDetailsItem4New1Lv;

        @BindView
        LinearLayout gameDetailsItem4New1Top;

        @BindView
        LinearLayout gameDetailsItem4New2Lv;

        @BindView
        LinearLayout gameDetailsItem4New2Top;

        @BindView
        LinearLayout gameDetailsItem4New3Lv;

        @BindView
        LinearLayout gameDetailsItem4New3Top;

        @BindView
        LinearLayout gameDetailsItem4New4Lv;

        @BindView
        LinearLayout gameDetailsItem4New4Top;

        @BindView
        LinearLayout gameDetailsItem4New5Lv;

        @BindView
        LinearLayout gameDetailsItem4New5Top;

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
            viewHolder.gameDetailsItem4New1Top = (LinearLayout) butterknife.c.a.c(view, R.id.game_details_item4_new1_top, "field 'gameDetailsItem4New1Top'", LinearLayout.class);
            viewHolder.gameDetailsItem4New1Lv = (LinearLayout) butterknife.c.a.c(view, R.id.game_details_item4_new1_lv, "field 'gameDetailsItem4New1Lv'", LinearLayout.class);
            viewHolder.gameDetailsItem4New2Top = (LinearLayout) butterknife.c.a.c(view, R.id.game_details_item4_new2_top, "field 'gameDetailsItem4New2Top'", LinearLayout.class);
            viewHolder.gameDetailsItem4New2Lv = (LinearLayout) butterknife.c.a.c(view, R.id.game_details_item4_new2_lv, "field 'gameDetailsItem4New2Lv'", LinearLayout.class);
            viewHolder.gameDetailsItem4New3Top = (LinearLayout) butterknife.c.a.c(view, R.id.game_details_item4_new3_top, "field 'gameDetailsItem4New3Top'", LinearLayout.class);
            viewHolder.gameDetailsItem4New3Lv = (LinearLayout) butterknife.c.a.c(view, R.id.game_details_item4_new3_lv, "field 'gameDetailsItem4New3Lv'", LinearLayout.class);
            viewHolder.gameDetailsItem4New4Top = (LinearLayout) butterknife.c.a.c(view, R.id.game_details_item4_new4_top, "field 'gameDetailsItem4New4Top'", LinearLayout.class);
            viewHolder.gameDetailsItem4New4Lv = (LinearLayout) butterknife.c.a.c(view, R.id.game_details_item4_new4_lv, "field 'gameDetailsItem4New4Lv'", LinearLayout.class);
            viewHolder.gameDetailsItem4New5Top = (LinearLayout) butterknife.c.a.c(view, R.id.game_details_item4_new5_top, "field 'gameDetailsItem4New5Top'", LinearLayout.class);
            viewHolder.gameDetailsItem4New5Lv = (LinearLayout) butterknife.c.a.c(view, R.id.game_details_item4_new5_lv, "field 'gameDetailsItem4New5Lv'", LinearLayout.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.gameDetailsItem4New1Top = null;
                viewHolder.gameDetailsItem4New1Lv = null;
                viewHolder.gameDetailsItem4New2Top = null;
                viewHolder.gameDetailsItem4New2Lv = null;
                viewHolder.gameDetailsItem4New3Top = null;
                viewHolder.gameDetailsItem4New3Lv = null;
                viewHolder.gameDetailsItem4New4Top = null;
                viewHolder.gameDetailsItem4New4Lv = null;
                viewHolder.gameDetailsItem4New5Top = null;
                viewHolder.gameDetailsItem4New5Lv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewsBean.DataBean dataBean = (NewsBean.DataBean) view.getTag();
            com.rtk.app.tool.t.z0(GameDetailsItem4.this.j, Integer.parseInt(dataBean.getId()), dataBean.getNew_title());
        }
    }

    public GameDetailsItem4(Context context, View view, int i) {
        super(context, view);
        this.m = 1;
        this.o = true;
        this.k = view;
        this.j = context;
        this.n = i;
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("GameDetailsItem4", "游戏资讯+----" + i + "" + str);
        NewsBean newsBean = (NewsBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, NewsBean.class);
        if (i == 1) {
            ViewHolder viewHolder = this.l;
            u(newsBean, viewHolder.gameDetailsItem4New1Lv, viewHolder.gameDetailsItem4New1Top);
            return;
        }
        if (i == 2) {
            ViewHolder viewHolder2 = this.l;
            u(newsBean, viewHolder2.gameDetailsItem4New2Lv, viewHolder2.gameDetailsItem4New2Top);
            return;
        }
        if (i == 3) {
            ViewHolder viewHolder3 = this.l;
            u(newsBean, viewHolder3.gameDetailsItem4New3Lv, viewHolder3.gameDetailsItem4New3Top);
        } else if (i == 4) {
            ViewHolder viewHolder4 = this.l;
            u(newsBean, viewHolder4.gameDetailsItem4New4Lv, viewHolder4.gameDetailsItem4New4Top);
        } else {
            if (i != 5) {
                return;
            }
            ViewHolder viewHolder5 = this.l;
            u(newsBean, viewHolder5.gameDetailsItem4New5Lv, viewHolder5.gameDetailsItem4New5Top);
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    @Override // com.rtk.app.base.g
    public void h(Context context, View view) {
        this.l.gameDetailsItem4New1Top.setOnClickListener(this);
        this.l.gameDetailsItem4New2Top.setOnClickListener(this);
        this.l.gameDetailsItem4New3Top.setOnClickListener(this);
        this.l.gameDetailsItem4New4Top.setOnClickListener(this);
        this.l.gameDetailsItem4New5Top.setOnClickListener(this);
    }

    @Override // com.rtk.app.base.g
    public void i(Context context, View view) {
        this.l = new ViewHolder(view);
        new ArrayList();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.game_details_item4_new1_top /* 2131297720 */:
                com.rtk.app.tool.t.A0(this.j, this.n, 1);
                return;
            case R.id.game_details_item4_new2_lv /* 2131297721 */:
            case R.id.game_details_item4_new3_lv /* 2131297723 */:
            case R.id.game_details_item4_new4_lv /* 2131297725 */:
            case R.id.game_details_item4_new5_lv /* 2131297727 */:
            default:
                return;
            case R.id.game_details_item4_new2_top /* 2131297722 */:
                com.rtk.app.tool.t.A0(this.j, this.n, 2);
                return;
            case R.id.game_details_item4_new3_top /* 2131297724 */:
                com.rtk.app.tool.t.A0(this.j, this.n, 3);
                return;
            case R.id.game_details_item4_new4_top /* 2131297726 */:
                com.rtk.app.tool.t.A0(this.j, this.n, 4);
                return;
            case R.id.game_details_item4_new5_top /* 2131297728 */:
                com.rtk.app.tool.t.A0(this.j, this.n, 5);
                return;
        }
    }

    public void s() {
        com.rtk.app.tool.c0.u("GameDetailsItem4", "资讯游戏ID" + this.n);
        if (this.n != 0) {
            com.rtk.app.tool.o.h.l(this.j, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a("news/newsList" + com.rtk.app.tool.y.u(this.j) + "&game_id=" + this.n + "&type=1&page=" + this.m + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.j, new String[0])))));
            com.rtk.app.tool.o.h.l(this.j, this, 2, com.rtk.app.tool.o.h.h(new String[0]).a("news/newsList" + com.rtk.app.tool.y.u(this.j) + "&game_id=" + this.n + "&type=2&page=" + this.m + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.j, new String[0])))));
            com.rtk.app.tool.o.h.l(this.j, this, 3, com.rtk.app.tool.o.h.h(new String[0]).a("news/newsList" + com.rtk.app.tool.y.u(this.j) + "&game_id=" + this.n + "&type=3&page=" + this.m + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.j, new String[0])))));
            com.rtk.app.tool.o.h.l(this.j, this, 4, com.rtk.app.tool.o.h.h(new String[0]).a("news/newsList" + com.rtk.app.tool.y.u(this.j) + "&game_id=" + this.n + "&type=4&page=" + this.m + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.j, new String[0])))));
            com.rtk.app.tool.o.h.l(this.j, this, 5, com.rtk.app.tool.o.h.h(new String[0]).a("news/newsList" + com.rtk.app.tool.y.u(this.j) + "&game_id=" + this.n + "&type=5&page=" + this.m + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.j, new String[0])))));
        }
    }

    public void t() {
        if (this.o) {
            s();
        }
        this.o = false;
    }

    public void u(NewsBean newsBean, LinearLayout linearLayout, LinearLayout linearLayout2) {
        for (int i = 0; i < newsBean.getData().size() && i < 2; i++) {
            View inflate = LayoutInflater.from(this.j).inflate(R.layout.news_item_layout, (ViewGroup) null);
            NewsHolder newsHolder = new NewsHolder(inflate);
            newsHolder.newsListObjectItemLayoutTitle.setText(newsBean.getData().get(i).getNew_title());
            newsHolder.newsListObjectItemLayoutAddTime.setText(com.rtk.app.tool.c0.g(newsBean.getData().get(i).getAddtime()));
            newsHolder.newsListObjectItemLayoutContent.setText(newsBean.getData().get(i).getDescription());
            newsHolder.newsListObjectItemLayoutType.setText(com.rtk.app.tool.t.N(newsBean.getData().get(i).getCate_id()));
            inflate.setTag(newsBean.getData().get(i));
            inflate.setOnClickListener(new a());
            linearLayout.addView(inflate);
            linearLayout2.setVisibility(0);
        }
    }
}
