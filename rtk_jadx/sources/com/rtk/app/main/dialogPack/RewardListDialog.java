package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.adapter.a3;
import com.rtk.app.bean.PostUpAndRewardListBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.o.h;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class RewardListDialog extends o implements h.j {
    private ViewHolder k;
    private String l;
    private Context m;
    private int n;
    private String o;
    private a3 p;
    private List<PostUpAndRewardListBean.DataBean> q;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ViewHolder {

        @BindView
        AutoListView fragementForListviewListview;

        @BindView
        TextView rewardListDialogTitle;

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
            viewHolder.rewardListDialogTitle = (TextView) butterknife.c.a.c(view, R.id.reward_list_dialog_title, "field 'rewardListDialogTitle'", TextView.class);
            viewHolder.fragementForListviewListview = (AutoListView) butterknife.c.a.c(view, R.id.reward_list_dialog_listview, "field 'fragementForListviewListview'", AutoListView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.rewardListDialogTitle = null;
                viewHolder.fragementForListviewListview = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements AutoListView.c {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            RewardListDialog.this.n = 1;
            RewardListDialog.this.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements AutoListView.b {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.b
        public void a() {
            RewardListDialog.this.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class c extends com.rtk.app.custom.AutoListView.b {
        c() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.B0(RewardListDialog.this.m, ((PostUpAndRewardListBean.DataBean) RewardListDialog.this.q.get(i - 1)).getUid());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0048, code lost:
    
        if (r5.equals("reward") == false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public RewardListDialog(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            r2 = this;
            r2.<init>(r3)
            r0 = 1
            r2.n = r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2.q = r1
            r2.o = r5
            r2.m = r3
            r2.l = r4
            r4 = 2131493742(0x7f0c036e, float:1.8610973E38)
            r1 = 17
            r2.i(r4, r1)
            com.rtk.app.main.dialogPack.RewardListDialog$ViewHolder r4 = new com.rtk.app.main.dialogPack.RewardListDialog$ViewHolder
            android.view.Window r1 = r2.getWindow()
            android.view.View r1 = r1.getDecorView()
            r4.<init>(r1)
            r2.k = r4
            r5.hashCode()
            int r4 = r5.hashCode()
            r1 = -1
            switch(r4) {
                case -1300627440: goto L4b;
                case -934326481: goto L42;
                case 3739: goto L37;
                default: goto L35;
            }
        L35:
            r0 = -1
            goto L55
        L37:
            java.lang.String r4 = "up"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L40
            goto L35
        L40:
            r0 = 2
            goto L55
        L42:
            java.lang.String r4 = "reward"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L55
            goto L35
        L4b:
            java.lang.String r4 = "upApkReward"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L54
            goto L35
        L54:
            r0 = 0
        L55:
            switch(r0) {
                case 0: goto L6c;
                case 1: goto L6c;
                case 2: goto L59;
                default: goto L58;
            }
        L58:
            goto L7e
        L59:
            com.rtk.app.adapter.PostUpListAdapter r4 = new com.rtk.app.adapter.PostUpListAdapter
            java.util.List<com.rtk.app.bean.PostUpAndRewardListBean$DataBean> r5 = r2.q
            r4.<init>(r3, r5)
            r2.p = r4
            com.rtk.app.main.dialogPack.RewardListDialog$ViewHolder r3 = r2.k
            android.widget.TextView r3 = r3.rewardListDialogTitle
            java.lang.String r4 = "点赞列表"
            r3.setText(r4)
            goto L7e
        L6c:
            com.rtk.app.adapter.PostRewardListAdapter r4 = new com.rtk.app.adapter.PostRewardListAdapter
            java.util.List<com.rtk.app.bean.PostUpAndRewardListBean$DataBean> r5 = r2.q
            r4.<init>(r3, r5)
            r2.p = r4
            com.rtk.app.main.dialogPack.RewardListDialog$ViewHolder r3 = r2.k
            android.widget.TextView r3 = r3.rewardListDialogTitle
            java.lang.String r4 = "打赏列表"
            r3.setText(r4)
        L7e:
            com.rtk.app.main.dialogPack.RewardListDialog$ViewHolder r3 = r2.k
            com.rtk.app.custom.AutoListView.AutoListView r3 = r3.fragementForListviewListview
            com.rtk.app.adapter.a3 r4 = r2.p
            r3.setAdapter(r4)
            r2.t()
            r2.u()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.main.dialogPack.RewardListDialog.<init>(android.content.Context, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        String sb;
        String str = this.o;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1300627440:
                if (str.equals("upApkReward")) {
                    c2 = 0;
                    break;
                }
                break;
            case -934326481:
                if (str.equals("reward")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3739:
                if (str.equals("up")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                StringBuilder sb2 = new StringBuilder();
                sb2.append("members/sourceRewardList");
                sb2.append(com.rtk.app.tool.y.u(this.m));
                sb2.append("&sid=");
                sb2.append(this.l);
                sb2.append("&page=");
                sb2.append(this.n);
                sb2.append("&limit=10&key=");
                sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.m, "sid=" + this.l))));
                sb = sb2.toString();
                break;
            case 1:
                StringBuilder sb3 = new StringBuilder();
                sb3.append("members/rewardList");
                sb3.append(com.rtk.app.tool.y.u(this.m));
                sb3.append("&pid=");
                sb3.append(this.l);
                sb3.append("&page=");
                sb3.append(this.n);
                sb3.append("&limit=10&key=");
                sb3.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.m, "pid=" + this.l))));
                sb = sb3.toString();
                break;
            case 2:
                StringBuilder sb4 = new StringBuilder();
                sb4.append("members/likeList");
                sb4.append(com.rtk.app.tool.y.u(this.m));
                sb4.append("&pid=");
                sb4.append(this.l);
                sb4.append("&page=");
                sb4.append(this.n);
                sb4.append("&limit=10&key=");
                sb4.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.m, "pid=" + this.l))));
                sb = sb4.toString();
                break;
            default:
                sb = "";
                break;
        }
        com.rtk.app.tool.o.h.l(this.m, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a(sb));
        com.rtk.app.tool.c0.u("RewardListDialog", "打赏地址" + com.rtk.app.tool.y.d + sb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(String[] strArr) {
        t();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        this.k.fragementForListviewListview.k();
        com.rtk.app.tool.c0.u("RewardListDialog", "打赏" + str);
        PostUpAndRewardListBean postUpAndRewardListBean = (PostUpAndRewardListBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, PostUpAndRewardListBean.class);
        if (postUpAndRewardListBean.getCode() != 0 || postUpAndRewardListBean.getData() == null) {
            return;
        }
        if (this.n == 1) {
            this.q.clear();
        }
        this.n++;
        this.q.addAll(postUpAndRewardListBean.getData());
        this.p.notifyDataSetChanged();
        this.k.fragementForListviewListview.setResultSize(postUpAndRewardListBean.getData().size());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (this.n == 1) {
            n(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.dialogPack.n
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    RewardListDialog.this.w(strArr);
                }
            });
        }
        this.k.fragementForListviewListview.f();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void u() {
        this.k.fragementForListviewListview.setOnRefreshListener(new a());
        this.k.fragementForListviewListview.setOnLoadListener(new b());
        this.k.fragementForListviewListview.setOnItemClickListener(new c());
    }
}
