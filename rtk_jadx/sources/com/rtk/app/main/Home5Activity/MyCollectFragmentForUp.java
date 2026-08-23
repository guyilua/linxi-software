package com.rtk.app.main.Home5Activity;

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
import com.rtk.app.adapter.MyCollectForUpAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.UpApkListBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyCollectFragmentForUp extends BaseFragment implements h.j {

    @BindView
    AutoListView fragementForListviewListview;
    Unbinder o;
    private int p = 1;
    private List<UpApkListBean.DataBean> q;
    private MyCollectForUpAdapter r;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.X0(((BaseFragment) MyCollectFragmentForUp.this).e, new ApkInfo((UpApkListBean.DataBean) MyCollectFragmentForUp.this.q.get(i - 1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(String[] strArr) {
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z() {
        this.p = 1;
        w();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        q();
        this.fragementForListviewListview.k();
        com.rtk.app.tool.c0.u("MyCollectFragmentForUp", "  我的收藏-up资源   " + str);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void B() {
        StringBuilder sb = new StringBuilder();
        sb.append("members/sourceCollectList");
        sb.append(com.rtk.app.tool.y.u(this.e));
        sb.append("&uid=");
        sb.append(com.rtk.app.tool.y.K());
        sb.append("&token=");
        sb.append(com.rtk.app.tool.y.H());
        sb.append("&page=");
        sb.append(this.p);
        sb.append("&limit=10&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.e, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a(sb.toString()));
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.fragementForListviewListview.setOnItemClickListener(new a());
        this.fragementForListviewListview.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.Home5Activity.m0
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                MyCollectFragmentForUp.this.z();
            }
        });
        this.fragementForListviewListview.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.Home5Activity.n0
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                MyCollectFragmentForUp.this.B();
            }
        });
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (this.p == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.Home5Activity.l0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    MyCollectFragmentForUp.this.x(strArr);
                }
            });
        }
        this.fragementForListviewListview.f();
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.q = new ArrayList();
        MyCollectForUpAdapter myCollectForUpAdapter = new MyCollectForUpAdapter(this.e, this.q);
        this.r = myCollectForUpAdapter;
        this.fragementForListviewListview.setAdapter((ListAdapter) myCollectForUpAdapter);
    }

    @Override // com.rtk.app.base.BaseFragment
    public void n() {
        MyCollectForUpAdapter myCollectForUpAdapter = this.r;
        if (myCollectForUpAdapter != null) {
            myCollectForUpAdapter.b();
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
            View view2 = this.a;
            r(view2, view2);
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
