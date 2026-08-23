package com.rtk.app.main.UpModule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.adapter.MyUpCommentAuditAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.UpApkCommentAuditBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyUpCommentAuditFragment extends BaseFragment implements h.j {

    @BindView
    AutoListView fragmentForListviewListview;

    @BindView
    LinearLayout fragmentForListviewParentLayout;
    Unbinder o;
    private int p;
    private int q = 1;
    private List<UpApkCommentAuditBean.DataDTO> r = new ArrayList();
    private MyUpCommentAuditAdapter s;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            UpApkCommentAuditBean.DataDTO dataDTO = (UpApkCommentAuditBean.DataDTO) MyUpCommentAuditFragment.this.r.get(i - 1);
            int parseInt = Integer.parseInt(dataDTO.getRoot_reply_id());
            if (parseInt != 0) {
                com.rtk.app.tool.t.W0(((BaseFragment) MyUpCommentAuditFragment.this).e, Integer.parseInt(dataDTO.getSid()), parseInt, "游戏Id");
            } else {
                com.rtk.app.tool.t.W0(((BaseFragment) MyUpCommentAuditFragment.this).e, Integer.parseInt(dataDTO.getSid()), Integer.parseInt(dataDTO.getId()), "游戏Id");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(String[] strArr) {
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A() {
        this.q = 1;
        B();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("MyUpCommentAuditFragment", "up评论审核列表..." + str);
        q();
        this.fragmentForListviewListview.k();
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
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void C() {
        if (com.rtk.app.tool.y.I(this.e) == 0) {
            com.rtk.app.tool.c0.s("MyUpCommentAuditFragment", "未登录");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("up/examine-comment/my-list");
        sb.append(com.rtk.app.tool.y.u(this.e));
        sb.append("&uid=");
        sb.append(com.rtk.app.tool.y.K());
        sb.append("&token=");
        sb.append(com.rtk.app.tool.y.H());
        sb.append("&state=");
        sb.append(this.p);
        sb.append("&page=");
        sb.append(this.q);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.e, "state=" + this.p, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
        String sb2 = sb.toString();
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb2));
        StringBuilder sb3 = new StringBuilder();
        sb3.append("我审核过的评论列表：");
        sb3.append(com.rtk.app.tool.y.e);
        sb3.append(sb2);
        com.rtk.app.tool.c0.u("MyUpCommentAuditFragment", sb3.toString());
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.fragmentForListviewListview.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.UpModule.a
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                MyUpCommentAuditFragment.this.A();
            }
        });
        this.fragmentForListviewListview.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.UpModule.c
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                MyUpCommentAuditFragment.this.C();
            }
        });
        this.fragmentForListviewListview.setOnItemClickListener(new a());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("MyUpCommentAuditFragment", "错误" + str);
        this.fragmentForListviewListview.f();
        if (this.q == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.UpModule.b
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    MyUpCommentAuditFragment.this.y(strArr);
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
        arguments.getInt("hasCommentPermission");
        MyUpCommentAuditAdapter myUpCommentAuditAdapter = new MyUpCommentAuditAdapter(this.e, this.r);
        this.s = myUpCommentAuditAdapter;
        this.fragmentForListviewListview.setAdapter((ListAdapter) myUpCommentAuditAdapter);
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
}
