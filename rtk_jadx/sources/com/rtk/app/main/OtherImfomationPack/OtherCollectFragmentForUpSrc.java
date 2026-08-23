package com.rtk.app.main.OtherImfomationPack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.adapter.UpApkListAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.UpApkListBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class OtherCollectFragmentForUpSrc extends BaseFragment implements h.j {

    @BindView
    AutoListView fragementForListviewListview;
    Unbinder o;
    private int p = 1;
    private List<UpApkListBean.DataBean> q;
    private UpApkListAdapter r;
    private String s;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.X0(((BaseFragment) OtherCollectFragmentForUpSrc.this).e, new ApkInfo((UpApkListBean.DataBean) OtherCollectFragmentForUpSrc.this.q.get(i - 1)));
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.c {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            OtherCollectFragmentForUpSrc.this.p = 1;
            OtherCollectFragmentForUpSrc.this.z();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements AutoListView.b {
        c() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.b
        public void a() {
            OtherCollectFragmentForUpSrc.this.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(String[] strArr) {
        z();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        this.fragementForListviewListview.k();
        c0.u("OtherCollectFragmentForUpSrc", "  我的收藏-up资源   " + str);
        if (i != 1) {
            return;
        }
        UpApkListBean upApkListBean = (UpApkListBean) this.f.fromJson(str, UpApkListBean.class);
        if (this.p == 1) {
            this.q.clear();
        }
        this.p++;
        this.q.addAll(upApkListBean.getData());
        this.r.notifyDataSetChanged();
        this.fragementForListviewListview.setResultSize(upApkListBean.getData().size());
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void z() {
        StringBuilder sb = new StringBuilder();
        sb.append("members/hisSourceCollectList");
        sb.append(y.u(this.e));
        sb.append("&uid=");
        sb.append(this.s);
        sb.append("&page=");
        sb.append(this.p);
        sb.append("&limit=10&key=");
        sb.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.e, "uid=" + this.s))));
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a(sb.toString()));
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.fragementForListviewListview.setOnItemClickListener(new a());
        this.fragementForListviewListview.setOnRefreshListener(new b());
        this.fragementForListviewListview.setOnLoadListener(new c());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.fragementForListviewListview.f();
        if (this.p == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.OtherImfomationPack.g
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    OtherCollectFragmentForUpSrc.this.y(strArr);
                }
            });
        }
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.s = getArguments().getString("uid");
        this.q = new ArrayList();
        UpApkListAdapter upApkListAdapter = new UpApkListAdapter(this.e, this.q);
        this.r = upApkListAdapter;
        this.fragementForListviewListview.setAdapter((ListAdapter) upApkListAdapter);
    }

    @Override // com.rtk.app.base.BaseFragment
    public void n() {
        super.n();
        UpApkListAdapter upApkListAdapter = this.r;
        if (upApkListAdapter != null) {
            upApkListAdapter.b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = LayoutInflater.from(this.e).inflate(R.layout.fragement_for_listview_layout, (ViewGroup) null);
            this.a = inflate;
            this.o = ButterKnife.b(this, inflate);
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
}
