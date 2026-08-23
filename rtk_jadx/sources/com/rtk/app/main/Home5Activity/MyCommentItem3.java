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
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.adapter.MyComment1ListViewAdapter;
import com.rtk.app.bean.MyCommentItemBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Level;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyCommentItem3 extends com.rtk.app.base.g implements h.j {
    private Context j;
    private int k;
    private MyCommentItemBean l;
    private ViewHolder m;
    private List<MyCommentItemBean.DataBean> n;
    private MyComment1ListViewAdapter o;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        AutoListView myCommentView3;

        ViewHolder(MyCommentItem3 myCommentItem3, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.myCommentView3 = (AutoListView) butterknife.c.a.c(view, R.id.my_comment_view3, "field 'myCommentView3'", AutoListView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.myCommentView3 = null;
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
            MyCommentItem3.this.u();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.c {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            MyCommentItem3.this.k = 1;
            MyCommentItem3.this.u();
            MyCommentItem3.this.m.myCommentView3.setLoadEnable(false);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements AdapterView.OnItemClickListener {
        final /* synthetic */ Context a;

        c(Context context) {
            this.a = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int i2 = i - 1;
            com.rtk.app.tool.t.d0(this.a, ((MyCommentItemBean.DataBean) MyCommentItem3.this.n.get(i2)).getGame_id(), ((MyCommentItemBean.DataBean) MyCommentItem3.this.n.get(i2)).getRoot_reply_id(), ((MyCommentItemBean.DataBean) MyCommentItem3.this.n.get(i2)).getInstall_comment() + "", ((MyCommentItemBean.DataBean) MyCommentItem3.this.n.get(i2)).getPackage_name());
        }
    }

    public MyCommentItem3(Context context, View view) {
        super(context, view);
        this.k = 1;
        this.j = context;
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
        this.m.myCommentView3.k();
        com.rtk.app.tool.c0.a("MyCommentItem3", "回复我的" + str, 3, new Level[0]);
        MyCommentItemBean myCommentItemBean = (MyCommentItemBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, MyCommentItemBean.class);
        this.l = myCommentItemBean;
        if (myCommentItemBean.getData() != null) {
            if (this.k == 1) {
                this.n.clear();
            }
            this.k++;
            this.n.addAll(this.l.getData());
            this.o.notifyDataSetChanged();
            this.m.myCommentView3.setResultSize(this.l.getData().size());
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (this.k == 1) {
            p(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.Home5Activity.q0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    MyCommentItem3.this.w(strArr);
                }
            });
        }
        this.m.myCommentView3.f();
    }

    @Override // com.rtk.app.base.g
    public void h(Context context, View view) {
        this.m.myCommentView3.setOnLoadListener(new a());
        this.m.myCommentView3.setOnRefreshListener(new b());
        this.m.myCommentView3.setOnItemClickListener(new c(context));
    }

    @Override // com.rtk.app.base.g
    public void i(Context context, View view) {
        this.m = new ViewHolder(this, view);
        this.n = new ArrayList();
        MyComment1ListViewAdapter myComment1ListViewAdapter = new MyComment1ListViewAdapter(context, this.n, 3);
        this.o = myComment1ListViewAdapter;
        this.m.myCommentView3.setAdapter((ListAdapter) myComment1ListViewAdapter);
    }

    public void u() {
        Context context = this.j;
        com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(new String[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("member/commentList");
        sb.append(com.rtk.app.tool.y.u(this.j));
        sb.append("&token=");
        sb.append(com.rtk.app.tool.y.H());
        sb.append("&model=replytome&uid=");
        sb.append(com.rtk.app.tool.y.K());
        sb.append("&page=");
        sb.append(this.k);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.j, "uid=" + com.rtk.app.tool.y.K()))));
        com.rtk.app.tool.o.h.l(context, this, 1, h.a(sb.toString()));
    }
}
