package com.rtk.app.main.HomeCommunityPack;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.adapter.PostCommentAuditAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.PostCommentAuditBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.base.mta.PointType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostCommentAuditFragment extends BaseFragment implements h.j {

    @BindView
    AutoListView fragementForListviewListview;

    @BindView
    LinearLayout fragementForListviewParentLayout;
    Unbinder o;
    private int p;
    private String r;
    private PostCommentAuditAdapter t;
    private int u;
    private String v;
    private boolean w;
    private int q = 1;
    private List<PostCommentAuditBean.DataBean> s = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(String[] strArr) {
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y() {
        this.q = 1;
        z();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("PostCommentAuditFragment", "帖子评论审核列表..." + str);
        this.fragementForListviewListview.k();
        q();
        if (i != 1) {
            return;
        }
        PostCommentAuditBean postCommentAuditBean = (PostCommentAuditBean) this.f.fromJson(str, PostCommentAuditBean.class);
        if (this.q == 1) {
            this.s.clear();
        }
        this.q++;
        this.s.addAll(postCommentAuditBean.getData());
        this.t.notifyDataSetChanged();
        this.fragementForListviewListview.setResultSize(postCommentAuditBean.getData().size());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void A() {
        String w;
        if (TextUtils.isEmpty(this.v)) {
            HashMap<String, String> k = com.rtk.app.tool.y.k();
            k.put("key", com.rtk.app.tool.t.L(k));
            k.put("uid", com.rtk.app.tool.y.K());
            k.put("token", com.rtk.app.tool.y.H());
            k.put("mid", this.r);
            k.put("state", this.p + "");
            k.put("page", this.q + "");
            k.put("limit", PointType.SIGMOB_APP);
            if (this.w) {
                com.rtk.app.tool.c0.u("PostCommentAuditFragment", "isAuditInfoForFamily true");
                k.put(com.umeng.analytics.pro.d.y, "1");
            }
            w = com.rtk.app.tool.y.w("bbs/examine-comment/list", k);
        } else {
            HashMap<String, String> l = com.rtk.app.tool.y.l();
            l.put("family_id", this.v);
            l.put("state3", this.p + "");
            l.put(com.rtk.app.tool.y.z("page"), this.q + "");
            l.put(com.rtk.app.tool.y.z("limit"), PointType.SIGMOB_APP);
            l.put("key", com.rtk.app.tool.t.L(l));
            w = com.rtk.app.tool.y.w("family/bbs/check-comment/list", l);
        }
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(w));
        com.rtk.app.tool.c0.u("PostCommentAuditFragment", "页面" + com.rtk.app.tool.y.e + w);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.fragementForListviewListview.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.HomeCommunityPack.i
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                PostCommentAuditFragment.this.y();
            }
        });
        this.fragementForListviewListview.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.HomeCommunityPack.h
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                PostCommentAuditFragment.this.A();
            }
        });
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("PostCommentAuditFragment", "错误" + str);
        this.fragementForListviewListview.f();
        if (this.q == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.HomeCommunityPack.j
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    PostCommentAuditFragment.this.w(strArr);
                }
            });
        }
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        Bundle arguments = getArguments();
        this.p = arguments.getInt("state");
        this.r = arguments.getString("mid", "0");
        this.u = arguments.getInt("moudleAdmin", 0);
        this.v = arguments.getString("family_id");
        this.w = arguments.getBoolean("isAuditInfoForFamily", false);
        PostCommentAuditAdapter postCommentAuditAdapter = new PostCommentAuditAdapter(this.e, this.s, this.u, this.v);
        this.t = postCommentAuditAdapter;
        this.fragementForListviewListview.setAdapter((ListAdapter) postCommentAuditAdapter);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.fragement_for_listview_layout, (ViewGroup) null);
            this.a = inflate;
            this.o = ButterKnife.b(this, inflate);
            LinearLayout linearLayout = this.fragementForListviewParentLayout;
            r(linearLayout, linearLayout);
            b();
        } else {
            this.o = ButterKnife.b(this, view);
        }
        return this.a;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.o.a();
    }

    public void u() {
        this.fragementForListviewListview.smoothScrollToPosition(0);
        LinearLayout linearLayout = this.fragementForListviewParentLayout;
        r(linearLayout, linearLayout);
        this.q = 1;
        z();
    }
}
