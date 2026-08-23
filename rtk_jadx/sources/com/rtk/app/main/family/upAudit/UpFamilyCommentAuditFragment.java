package com.rtk.app.main.family.upAudit;

import android.os.Bundle;
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
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.UpApkCommentAuditBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.base.mta.PointType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpFamilyCommentAuditFragment extends BaseFragment implements h.j {

    @BindView
    protected AutoListView fragmentForListviewListview;

    @BindView
    protected LinearLayout fragmentForListviewParentLayout;
    protected Unbinder o;
    protected int p;
    protected UpFamilyCommentAuditAdapter s;
    private String u;
    protected int q = 1;
    protected List<UpApkCommentAuditBean.DataDTO> r = new ArrayList();
    protected int t = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(String[] strArr) {
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y() {
        this.q = 1;
        x();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        c0.u("UpFamilyCommentAuditFragment", "up评论审核列表..." + str);
        this.fragmentForListviewListview.k();
        q();
        if (i != 1) {
            return;
        }
        UpApkCommentAuditBean upApkCommentAuditBean = (UpApkCommentAuditBean) this.f.fromJson(str, UpApkCommentAuditBean.class);
        if (this.q == 1) {
            this.r.clear();
        }
        this.q++;
        this.r.addAll(upApkCommentAuditBean.getData());
        this.s.notifyDataSetChanged();
        this.fragmentForListviewListview.setResultSize(upApkCommentAuditBean.getData().size());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    public void A() {
        if (y.I(this.e) == 0) {
            c0.s("UpFamilyCommentAuditFragment", "未登录");
            return;
        }
        HashMap<String, String> l = y.l();
        l.put("family_id", this.u);
        l.put("state3", this.p + "");
        l.put(y.z("page"), this.q + "");
        l.put(y.z("limit"), PointType.SIGMOB_APP);
        l.put("key", t.L(l));
        String w = y.w("family/up/check-comment/list", l);
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(y.e).a(w));
        c0.u("UpFamilyCommentAuditFragment", "页面" + y.e + w);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.fragmentForListviewListview.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.family.upAudit.r
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                UpFamilyCommentAuditFragment.this.y();
            }
        });
        this.fragmentForListviewListview.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.family.upAudit.p
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                UpFamilyCommentAuditFragment.this.A();
            }
        });
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        c0.u("UpFamilyCommentAuditFragment", "错误" + str);
        this.fragmentForListviewListview.f();
        if (this.q == 1) {
            t(str, new s() { // from class: com.rtk.app.main.family.upAudit.q
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    UpFamilyCommentAuditFragment.this.w(strArr);
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
        this.u = arguments.getString("family_id");
        this.t = arguments.getInt("hasCommentPermission");
        UpFamilyCommentAuditAdapter upFamilyCommentAuditAdapter = new UpFamilyCommentAuditAdapter(this.e, this.r, this.t, this.u);
        this.s = upFamilyCommentAuditAdapter;
        this.fragmentForListviewListview.setAdapter((ListAdapter) upFamilyCommentAuditAdapter);
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
            LinearLayout linearLayout = this.fragmentForListviewParentLayout;
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
        this.fragmentForListviewListview.smoothScrollToPosition(0);
        LinearLayout linearLayout = this.fragmentForListviewParentLayout;
        r(linearLayout, linearLayout);
        this.q = 1;
        x();
    }
}
