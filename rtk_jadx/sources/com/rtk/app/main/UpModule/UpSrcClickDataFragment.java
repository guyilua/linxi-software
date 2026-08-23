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
import com.rtk.app.adapter.UpSrcClickDataAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.UpClickSrcDataBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpSrcClickDataFragment extends BaseFragment implements h.j {

    @BindView
    AutoListView fragmentForListviewListview;

    @BindView
    LinearLayout fragmentForListviewParentLayout;
    Unbinder o;
    private int p;
    private int q;
    private int r = 1;
    List<UpClickSrcDataBean.DataDTO> s = new ArrayList();
    private UpSrcClickDataAdapter t;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(String[] strArr) {
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z() {
        this.r = 1;
        this.fragmentForListviewListview.setLoadEnable(false);
        A();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("UpSrcClickDataFragment", "点击量列表" + str);
        if (i != 1) {
            return;
        }
        this.fragmentForListviewListview.k();
        UpClickSrcDataBean upClickSrcDataBean = (UpClickSrcDataBean) this.f.fromJson(str, UpClickSrcDataBean.class);
        if (this.r == 1) {
            this.s.clear();
        }
        this.r++;
        this.s.addAll(upClickSrcDataBean.getData());
        this.t.notifyDataSetChanged();
        this.fragmentForListviewListview.setResultSize(upClickSrcDataBean.getData().size());
        q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void x() {
        StringBuilder sb = new StringBuilder();
        sb.append("up/pv/detail");
        sb.append(com.rtk.app.tool.y.u(this.e));
        sb.append("&uid=");
        sb.append(com.rtk.app.tool.y.K());
        sb.append("&token=");
        sb.append(com.rtk.app.tool.y.H());
        sb.append("&page=");
        sb.append(this.r);
        sb.append("&limit=20&up_id=");
        sb.append(this.p);
        sb.append("&range=");
        sb.append(this.q);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.e, "up_id=" + this.p, "uid=" + com.rtk.app.tool.y.K(), "range=" + this.q, "token=" + com.rtk.app.tool.y.H()))));
        String sb2 = sb.toString();
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb2));
        StringBuilder sb3 = new StringBuilder();
        sb3.append("点击量接口   ");
        sb3.append(com.rtk.app.tool.y.e);
        sb3.append(sb2);
        com.rtk.app.tool.c0.u("UpSrcClickDataFragment", sb3.toString());
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.fragmentForListviewListview.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.UpModule.b1
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                UpSrcClickDataFragment.this.x();
            }
        });
        this.fragmentForListviewListview.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.UpModule.z0
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                UpSrcClickDataFragment.this.z();
            }
        });
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (i2 != 1) {
            return;
        }
        this.fragmentForListviewListview.f();
        if (this.r == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.UpModule.a1
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    UpSrcClickDataFragment.this.v(strArr);
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
        this.q = arguments.getInt("range");
        UpSrcClickDataAdapter upSrcClickDataAdapter = new UpSrcClickDataAdapter(this.e, this.s);
        this.t = upSrcClickDataAdapter;
        this.fragmentForListviewListview.setAdapter((ListAdapter) upSrcClickDataAdapter);
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
