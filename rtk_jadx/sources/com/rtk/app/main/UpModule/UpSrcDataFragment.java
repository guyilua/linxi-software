package com.rtk.app.main.UpModule;

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
import com.rtk.app.adapter.UpSrcDataAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.UpSrcDataBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpSrcDataFragment extends BaseFragment implements h.j {

    @BindView
    AutoListView fragementForListviewListview;

    @BindView
    LinearLayout fragementForListviewParentLayout;
    Unbinder o;
    private int p;
    private int q;
    private int r = 1;
    List<UpSrcDataBean.DataBean> s = new ArrayList();
    private UpSrcDataAdapter t;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(String[] strArr) {
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z() {
        this.r = 1;
        this.fragementForListviewListview.setLoadEnable(false);
        x();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("UpSrcDataFragment", "下载量列表" + str);
        if (i != 1) {
            return;
        }
        this.fragementForListviewListview.k();
        UpSrcDataBean upSrcDataBean = (UpSrcDataBean) this.f.fromJson(str, UpSrcDataBean.class);
        if (this.r == 1) {
            this.s.clear();
        }
        this.r++;
        this.s.addAll(upSrcDataBean.getData());
        this.t.notifyDataSetChanged();
        this.fragementForListviewListview.setResultSize(upSrcDataBean.getData().size());
        q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void x() {
        StringBuilder sb = new StringBuilder();
        sb.append("members/downRankingBySid");
        sb.append(com.rtk.app.tool.y.u(this.e));
        sb.append("&uid=");
        sb.append(com.rtk.app.tool.y.K());
        sb.append("&token=");
        sb.append(com.rtk.app.tool.y.H());
        sb.append("&page=");
        sb.append(this.r);
        sb.append("&limit=20&sid=");
        sb.append(this.p);
        sb.append("&last=");
        sb.append(this.q);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.e, "sid=" + this.p, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
        String sb2 = sb.toString();
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a(sb2));
        StringBuilder sb3 = new StringBuilder();
        sb3.append("请求接口   ");
        sb3.append(com.rtk.app.tool.y.d);
        sb3.append(sb2);
        com.rtk.app.tool.c0.u("UpSrcDataFragment", sb3.toString());
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.fragementForListviewListview.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.UpModule.c1
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                UpSrcDataFragment.this.x();
            }
        });
        this.fragementForListviewListview.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.UpModule.e1
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                UpSrcDataFragment.this.z();
            }
        });
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (i2 != 1) {
            return;
        }
        this.fragementForListviewListview.f();
        if (this.r == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.UpModule.d1
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    UpSrcDataFragment.this.v(strArr);
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
        this.p = arguments.getInt("sid");
        this.q = arguments.getInt("position");
        UpSrcDataAdapter upSrcDataAdapter = new UpSrcDataAdapter(this.e, this.s);
        this.t = upSrcDataAdapter;
        this.fragementForListviewListview.setAdapter((ListAdapter) upSrcDataAdapter);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.fragement_for_listview_layout, viewGroup, false);
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
