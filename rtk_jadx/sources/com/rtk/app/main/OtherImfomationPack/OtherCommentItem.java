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
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.adapter.MyComment1ListViewAdapter;
import com.rtk.app.bean.MyCommentItemBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.y;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Level;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class OtherCommentItem extends com.rtk.app.base.g implements h.j {
    private Context j;
    private View k;
    private int l;
    private MyCommentItemBean m;
    private ViewHolder n;
    private List<MyCommentItemBean.DataBean> o;
    private MyComment1ListViewAdapter p;
    private String q;
    private String r;
    private int s;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        AutoListView myCommentView1;

        ViewHolder(OtherCommentItem otherCommentItem, View view) {
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
            OtherCommentItem.this.u();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.c {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            OtherCommentItem.this.l = 1;
            OtherCommentItem.this.u();
            OtherCommentItem.this.n.myCommentView1.setLoadEnable(false);
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
            com.rtk.app.tool.t.d0(this.a, ((MyCommentItemBean.DataBean) OtherCommentItem.this.o.get(i2)).getGame_id(), ((MyCommentItemBean.DataBean) OtherCommentItem.this.o.get(i2)).getCmtid(), ((MyCommentItemBean.DataBean) OtherCommentItem.this.o.get(i2)).getInstall_comment() + "", ((MyCommentItemBean.DataBean) OtherCommentItem.this.o.get(i2)).getPackage_name());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
    
        if (r5.equals("my") == false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public OtherCommentItem(android.content.Context r2, android.view.View r3, java.lang.String r4, java.lang.String r5) {
        /*
            r1 = this;
            r1.<init>(r2, r3)
            r0 = 1
            r1.l = r0
            r1.j = r2
            r1.k = r3
            r1.q = r4
            r1.r = r5
            r1.n(r3, r3)
            r1.u()
            r5.hashCode()
            int r2 = r5.hashCode()
            r3 = -1
            switch(r2) {
                case -432736451: goto L35;
                case 3500: goto L2c;
                case 1526182078: goto L21;
                default: goto L1f;
            }
        L1f:
            r0 = -1
            goto L3f
        L21:
            java.lang.String r2 = "myreply"
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L2a
            goto L1f
        L2a:
            r0 = 2
            goto L3f
        L2c:
            java.lang.String r2 = "my"
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L3f
            goto L1f
        L35:
            java.lang.String r2 = "replytome"
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L3e
            goto L1f
        L3e:
            r0 = 0
        L3f:
            switch(r0) {
                case 0: goto L51;
                case 1: goto L4a;
                case 2: goto L43;
                default: goto L42;
            }
        L42:
            goto L57
        L43:
            com.rtk.app.adapter.MyComment1ListViewAdapter r2 = r1.p
            r3 = 5
            r2.h(r3)
            goto L57
        L4a:
            com.rtk.app.adapter.MyComment1ListViewAdapter r2 = r1.p
            r3 = 4
            r2.h(r3)
            goto L57
        L51:
            com.rtk.app.adapter.MyComment1ListViewAdapter r2 = r1.p
            r3 = 6
            r2.h(r3)
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.main.OtherImfomationPack.OtherCommentItem.<init>(android.content.Context, android.view.View, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(String[] strArr) {
        u();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        m();
        this.n.myCommentView1.k();
        c0.a("OtherCommentItem", "我的评论" + str, 3, new Level[0]);
        MyCommentItemBean myCommentItemBean = (MyCommentItemBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, MyCommentItemBean.class);
        this.m = myCommentItemBean;
        if (myCommentItemBean.getData() != null) {
            if (this.l == 1) {
                this.o.clear();
            }
            this.l++;
            this.o.addAll(this.m.getData());
            this.p.notifyDataSetChanged();
            this.n.myCommentView1.setResultSize(this.m.getData().size());
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (this.l == 1) {
            p(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.OtherImfomationPack.h
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    OtherCommentItem.this.w(strArr);
                }
            });
        }
        this.n.myCommentView1.f();
    }

    @Override // com.rtk.app.base.g
    public void h(Context context, View view) {
        this.n.myCommentView1.setOnLoadListener(new a());
        this.n.myCommentView1.setOnRefreshListener(new b());
        this.n.myCommentView1.setOnItemClickListener(new c(context));
    }

    @Override // com.rtk.app.base.g
    public void i(Context context, View view) {
        this.n = new ViewHolder(this, view);
        this.o = new ArrayList();
        MyComment1ListViewAdapter myComment1ListViewAdapter = new MyComment1ListViewAdapter(context, this.o, this.s);
        this.p = myComment1ListViewAdapter;
        this.n.myCommentView1.setAdapter((ListAdapter) myComment1ListViewAdapter);
    }

    public void u() {
        Context context = this.j;
        com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(new String[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("member/commentList");
        sb.append(y.u(this.j));
        sb.append("&model=");
        sb.append(this.r);
        sb.append("&uid=");
        sb.append(this.q);
        sb.append("&page=");
        sb.append(this.l);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.j, "uid=" + this.q))));
        com.rtk.app.tool.o.h.l(context, this, 1, h.a(sb.toString()));
    }
}
