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
import com.rtk.app.adapter.MyUpApkCommentAdapter;
import com.rtk.app.bean.MyUpApkCommentBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyUpApkCommentItem extends com.rtk.app.base.g implements h.j {
    private Context j;
    private View k;
    private int l;
    private ViewHolder m;
    private List<MyUpApkCommentBean.DataBean> n;
    private String o;
    private MyUpApkCommentAdapter p;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        AutoListView myCommentView1;

        ViewHolder(MyUpApkCommentItem myUpApkCommentItem, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.myCommentView1 = (AutoListView) butterknife.c.a.c(view, R.id.my_comment_view1, "field 'myCommentView1'", AutoListView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.myCommentView1 = null;
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
            MyUpApkCommentItem.this.u();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.c {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            MyUpApkCommentItem.this.l = 1;
            MyUpApkCommentItem.this.u();
            MyUpApkCommentItem.this.m.myCommentView1.setLoadEnable(false);
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
            com.rtk.app.tool.t.W0(this.a, ((MyUpApkCommentBean.DataBean) MyUpApkCommentItem.this.n.get(i2)).getUsid(), ((MyUpApkCommentBean.DataBean) MyUpApkCommentItem.this.n.get(i2)).getRoot_reply_id() != 0 ? ((MyUpApkCommentBean.DataBean) MyUpApkCommentItem.this.n.get(i2)).getRoot_reply_id() : ((MyUpApkCommentBean.DataBean) MyUpApkCommentItem.this.n.get(i2)).getCmtid(), ((MyUpApkCommentBean.DataBean) MyUpApkCommentItem.this.n.get(i2)).getSourceName());
        }
    }

    public MyUpApkCommentItem(Context context, View view, String str) {
        super(context, view);
        this.l = 1;
        this.j = context;
        this.k = view;
        this.o = str;
        MyUpApkCommentAdapter myUpApkCommentAdapter = new MyUpApkCommentAdapter(context, this.n, str);
        this.p = myUpApkCommentAdapter;
        this.m.myCommentView1.setAdapter((ListAdapter) myUpApkCommentAdapter);
        n(view, view);
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(String[] strArr) {
        u();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        m();
        this.m.myCommentView1.k();
        com.rtk.app.tool.c0.a("MyUpApkCommentItem", this.o + "  up资源评论    " + str, 4, new Level[0]);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        MyUpApkCommentBean myUpApkCommentBean = (MyUpApkCommentBean) create.fromJson(str, MyUpApkCommentBean.class);
        if (myUpApkCommentBean.getCode() != 0 || myUpApkCommentBean.getData() == null) {
            return;
        }
        if (this.l == 1) {
            this.n.clear();
        }
        this.l++;
        this.n.addAll(myUpApkCommentBean.getData());
        this.p.notifyDataSetChanged();
        this.m.myCommentView1.setResultSize(myUpApkCommentBean.getData().size());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("MyUpApkCommentItem", this.o + "  up资源评论失败    " + str);
        if (this.l == 1) {
            p(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.Home5Activity.e1
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    MyUpApkCommentItem.this.w(strArr);
                }
            });
        }
        this.m.myCommentView1.k();
        this.m.myCommentView1.f();
    }

    @Override // com.rtk.app.base.g
    public void h(Context context, View view) {
        this.m.myCommentView1.setOnLoadListener(new a());
        this.m.myCommentView1.setOnRefreshListener(new b());
        this.m.myCommentView1.setOnItemClickListener(new c(context));
    }

    @Override // com.rtk.app.base.g
    public void i(Context context, View view) {
        this.m = new ViewHolder(this, view);
        this.n = new ArrayList();
    }

    public void u() {
        Context context = this.j;
        com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(new String[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("members/sourceCommentInfo");
        sb.append(com.rtk.app.tool.y.u(this.j));
        sb.append("&token=");
        sb.append(com.rtk.app.tool.y.G(this.j));
        sb.append("&model=");
        sb.append(this.o);
        sb.append("&uid=");
        sb.append(com.rtk.app.tool.y.K());
        sb.append("&limit=10&page=");
        sb.append(this.l);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.j, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
        com.rtk.app.tool.o.h.l(context, this, 1, h.a(sb.toString()));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("  我的上传资源评论  ");
        sb2.append(com.rtk.app.tool.y.d);
        sb2.append("members/sourceCommentInfo");
        sb2.append(com.rtk.app.tool.y.u(this.j));
        sb2.append("&token=");
        sb2.append(com.rtk.app.tool.y.G(this.j));
        sb2.append("&model=");
        sb2.append(this.o);
        sb2.append("&uid=");
        sb2.append(com.rtk.app.tool.y.K());
        sb2.append("&limit=10&page=");
        sb2.append(this.l);
        sb2.append("&key=");
        sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.j, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
        com.rtk.app.tool.c0.u("MyUpApkCommentItem", sb2.toString());
    }
}
