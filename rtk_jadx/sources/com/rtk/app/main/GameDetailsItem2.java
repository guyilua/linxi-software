package com.rtk.app.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.adapter.GameDetailsCommentAdapter;
import com.rtk.app.bean.GameCommentBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GameDetailsItem2 extends com.rtk.app.base.g implements View.OnClickListener, h.j {
    public static boolean w = false;
    private Context j;
    private View k;
    private ViewHolder l;
    private int m;
    private int n;
    private List<GameCommentBean.DataBean> o;
    private GameDetailsCommentAdapter p;
    private String q;
    private View r;
    private HeadHolder s;
    private String t;
    private String u;
    private boolean v;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class HeadHolder {

        @BindView
        TextView gameDetailsItem2Hot;

        @BindView
        TextView gameDetailsItem2Time;

        HeadHolder(View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class HeadHolder_ViewBinding implements Unbinder {
        private HeadHolder b;

        @UiThread
        public HeadHolder_ViewBinding(HeadHolder headHolder, View view) {
            this.b = headHolder;
            headHolder.gameDetailsItem2Time = (TextView) butterknife.c.a.c(view, R.id.game_details_item2_time, "field 'gameDetailsItem2Time'", TextView.class);
            headHolder.gameDetailsItem2Hot = (TextView) butterknife.c.a.c(view, R.id.game_details_item2_hot, "field 'gameDetailsItem2Hot'", TextView.class);
        }

        @CallSuper
        public void a() {
            HeadHolder headHolder = this.b;
            if (headHolder != null) {
                this.b = null;
                headHolder.gameDetailsItem2Time = null;
                headHolder.gameDetailsItem2Hot = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ViewHolder {

        @BindView
        TextView gameDetailsItem2CommentBtu;

        @BindView
        AutoListView gameDetailsItem2Listview;

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
            viewHolder.gameDetailsItem2Listview = (AutoListView) butterknife.c.a.c(view, R.id.game_details_item2_listview, "field 'gameDetailsItem2Listview'", AutoListView.class);
            viewHolder.gameDetailsItem2CommentBtu = (TextView) butterknife.c.a.c(view, R.id.game_details_item2_commentBtu, "field 'gameDetailsItem2CommentBtu'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.gameDetailsItem2Listview = null;
                viewHolder.gameDetailsItem2CommentBtu = null;
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
            GameDetailsItem2.this.z();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.b {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.b
        public void a() {
            GameDetailsItem2.this.v();
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
            com.rtk.app.tool.t.d0(this.a, GameDetailsItem2.this.n, ((GameCommentBean.DataBean) GameDetailsItem2.this.o.get(i - 2)).getCmtid(), GameDetailsItem2.this.t, GameDetailsItem2.this.u);
        }
    }

    public GameDetailsItem2(Context context, View view, int i, String str, String str2) {
        super(context, view);
        this.m = 1;
        this.q = "time";
        this.v = true;
        this.k = view;
        this.j = context;
        this.n = i;
        this.t = str;
        this.u = str2;
        this.p.n(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(String[] strArr) {
        v();
    }

    public void A() {
        if (this.v) {
            v();
        }
        this.v = false;
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        m();
        this.l.gameDetailsItem2Listview.k();
        com.rtk.app.tool.c0.u("GameDetailsItem2", "游戏评论   " + str);
        GameCommentBean gameCommentBean = (GameCommentBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, GameCommentBean.class);
        if (gameCommentBean.getCode() == 0) {
            if (this.m == 1) {
                this.o.clear();
            }
            this.o.addAll(gameCommentBean.getData());
            this.p.notifyDataSetChanged();
            this.l.gameDetailsItem2Listview.setResultSize(gameCommentBean.getData().size());
            this.m++;
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.l.gameDetailsItem2Listview.f();
        com.rtk.app.tool.c0.u("GameDetailsItem2", "评论返回" + str);
        if (this.m == 1) {
            p(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.n
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    GameDetailsItem2.this.x(strArr);
                }
            });
        }
    }

    @Override // com.rtk.app.base.g
    public void h(Context context, View view) {
        this.s.gameDetailsItem2Hot.setOnClickListener(this);
        this.s.gameDetailsItem2Time.setOnClickListener(this);
        this.l.gameDetailsItem2CommentBtu.setOnClickListener(this);
        this.l.gameDetailsItem2Listview.setOnRefreshListener(new a());
        this.l.gameDetailsItem2Listview.setOnLoadListener(new b());
        AnimationUtils.loadAnimation(context, R.anim.hid_anim_for_btu);
        AnimationUtils.loadAnimation(context, R.anim.show_anim_for_btu);
        this.l.gameDetailsItem2Listview.setOnItemClickListener(new c(context));
    }

    @Override // com.rtk.app.base.g
    public void i(Context context, View view) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.game_details_item2_head_layout, (ViewGroup) null);
        this.r = inflate;
        this.s = new HeadHolder(inflate);
        this.l = new ViewHolder(view);
        this.o = new ArrayList();
        this.p = new GameDetailsCommentAdapter(context, this.o, this.t, this.u);
        this.l.gameDetailsItem2Listview.addHeaderView(this.r);
        this.l.gameDetailsItem2Listview.setAdapter((ListAdapter) this.p);
    }

    @Override // com.rtk.app.base.g
    public void k() {
        if (w) {
            this.l.gameDetailsItem2Listview.setSelectionFromTop(0, 0);
            this.m = 1;
            v();
            w = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.game_details_item2_commentBtu /* 2131297714 */:
                com.rtk.app.tool.t.l0(this.j, 0, this.n, 0, 0, this.t, this.u, new String[0]);
                return;
            case R.id.game_details_item2_hot /* 2131297715 */:
                this.q = "hot";
                this.s.gameDetailsItem2Time.setEnabled(true);
                this.s.gameDetailsItem2Hot.setEnabled(false);
                this.m = 1;
                v();
                this.l.gameDetailsItem2Listview.setSelection(0);
                return;
            case R.id.game_details_item2_listview /* 2131297716 */:
            default:
                return;
            case R.id.game_details_item2_time /* 2131297717 */:
                this.q = "time";
                this.s.gameDetailsItem2Hot.setEnabled(true);
                this.s.gameDetailsItem2Time.setEnabled(false);
                this.m = 1;
                v();
                this.l.gameDetailsItem2Listview.setSelection(0);
                return;
        }
    }

    public void v() {
        if (this.m == 1) {
            View view = this.k;
            n(view, view);
        }
        Context context = this.j;
        com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(new String[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("game/gameCommentList");
        sb.append(com.rtk.app.tool.y.u(this.j));
        sb.append("&game_id=");
        sb.append(this.n);
        sb.append("&sort=");
        sb.append(this.q);
        sb.append("&page=");
        sb.append(this.m);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.j, "game_id=" + this.n))));
        com.rtk.app.tool.o.h.l(context, this, 1, h.a(sb.toString()));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("评论地址");
        sb2.append(com.rtk.app.tool.y.d);
        sb2.append("game/gameCommentList");
        sb2.append(com.rtk.app.tool.y.u(this.j));
        sb2.append("&game_id=");
        sb2.append(this.n);
        sb2.append("&sort=");
        sb2.append(this.q);
        sb2.append("&page=");
        sb2.append(this.m);
        sb2.append("&key=");
        sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.j, "game_id=" + this.n))));
        com.rtk.app.tool.c0.u("GameDetailsItem2", sb2.toString());
    }

    public void y(int i, String str) {
        com.rtk.app.tool.c0.u("GameDetailsItem2", "回复更新内容" + str);
        GameCommentBean.DataBean.ReplyBean replyBean = new GameCommentBean.DataBean.ReplyBean();
        replyBean.setContent(str);
        replyBean.setU_name(MainActivity.p.getData().getNickname());
        if (this.o.get(i).getReply() == null) {
            this.o.get(i).setReply(new ArrayList());
        }
        this.o.get(i).getReply().add(0, replyBean);
        this.p.notifyDataSetChanged();
    }

    public void z() {
        this.m = 1;
        v();
        this.l.gameDetailsItem2Listview.setLoadEnable(false);
    }
}
