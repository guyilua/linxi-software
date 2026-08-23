package com.rtk.app.main.OtherImfomationPack;

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
import com.rtk.app.adapter.OtherUpApkCommentAdapter;
import com.rtk.app.bean.MyUpApkCommentBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.y;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Level;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class OtherUpApkCommentItem extends com.rtk.app.base.g implements h.j {
    private Context j;
    private View k;
    private int l;
    private ViewHolder m;
    private List<MyUpApkCommentBean.DataBean> n;
    private String o;
    private OtherUpApkCommentAdapter p;
    private String q;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        AutoListView myCommentView1;

        ViewHolder(OtherUpApkCommentItem otherUpApkCommentItem, View view) {
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
            OtherUpApkCommentItem.this.u();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.c {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            OtherUpApkCommentItem.this.l = 1;
            OtherUpApkCommentItem.this.u();
            OtherUpApkCommentItem.this.m.myCommentView1.setLoadEnable(false);
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
            com.rtk.app.tool.t.W0(this.a, ((MyUpApkCommentBean.DataBean) OtherUpApkCommentItem.this.n.get(i2)).getUsid(), ((MyUpApkCommentBean.DataBean) OtherUpApkCommentItem.this.n.get(i2)).getRoot_reply_id() != 0 ? ((MyUpApkCommentBean.DataBean) OtherUpApkCommentItem.this.n.get(i2)).getRoot_reply_id() : ((MyUpApkCommentBean.DataBean) OtherUpApkCommentItem.this.n.get(i2)).getCmtid(), ((MyUpApkCommentBean.DataBean) OtherUpApkCommentItem.this.n.get(i2)).getSourceName());
        }
    }

    public OtherUpApkCommentItem(Context context, View view, String str, String str2) {
        super(context, view);
        this.l = 1;
        this.j = context;
        this.k = view;
        this.o = str;
        this.q = str2;
        OtherUpApkCommentAdapter otherUpApkCommentAdapter = new OtherUpApkCommentAdapter(context, this.n, str);
        this.p = otherUpApkCommentAdapter;
        this.m.myCommentView1.setAdapter((ListAdapter) otherUpApkCommentAdapter);
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
        c0.a("OtherUpApkCommentItem", this.o + "  up资源评论    " + str, 4, new Level[0]);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        MyUpApkCommentBean myUpApkCommentBean = (MyUpApkCommentBean) create.fromJson(str, MyUpApkCommentBean.class);
        this.n.addAll(myUpApkCommentBean.getData());
        this.p.notifyDataSetChanged();
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
        c0.u("OtherUpApkCommentItem", this.o + "  up资源评论失败    " + str);
        if (this.l == 1) {
            p(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.OtherImfomationPack.t
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    OtherUpApkCommentItem.this.w(strArr);
                }
            });
        }
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
        sb.append("members/hisSourceCommentInfo");
        sb.append(y.u(this.j));
        sb.append("&model=");
        sb.append(this.o);
        sb.append("&uid=");
        sb.append(this.q);
        sb.append("&limit=10&page=");
        sb.append(this.l);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.j, "uid=" + this.q))));
        com.rtk.app.tool.o.h.l(context, this, 1, h.a(sb.toString()));
    }
}
