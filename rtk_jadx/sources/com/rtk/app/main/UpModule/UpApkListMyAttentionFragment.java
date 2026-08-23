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
import com.qq.e.comm.constants.ErrorCode;
import com.rtk.app.R;
import com.rtk.app.adapter.UpApkListMyAttentionAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.UpApkListBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpApkListMyAttentionFragment extends BaseFragment implements h.j {

    @BindView
    AutoListView fragementForListviewListview;

    @BindView
    LinearLayout fragementForListviewParentLayout;
    Unbinder o;
    private UpApkListMyAttentionAdapter r;
    private int p = 1;
    private List<UpApkListBean.DataBean> q = new ArrayList();
    private int s = 0;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.X0(((BaseFragment) UpApkListMyAttentionFragment.this).e, new ApkInfo((UpApkListBean.DataBean) UpApkListMyAttentionFragment.this.q.get(i - 1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B() {
        if (!com.rtk.app.tool.y.x(this.e)) {
            com.rtk.app.tool.f.a(this.e, "请先登录", f.a.f);
            com.rtk.app.tool.t.w0(this.e);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("user/my-moments/up");
        sb.append(com.rtk.app.tool.y.u(this.e));
        sb.append("&page=");
        sb.append(this.p);
        sb.append("&limit=10&uid=");
        sb.append(com.rtk.app.tool.y.K());
        sb.append("&token=");
        sb.append(com.rtk.app.tool.y.H());
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.e, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("url=");
        sb3.append(sb2);
        com.rtk.app.tool.c0.r("UpApkListMyAttentionFragment", sb3.toString());
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F() {
        this.p = 1;
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H(int i, String str) {
        this.fragementForListviewListview.k();
        if (i != 1) {
            return;
        }
        com.rtk.app.tool.c0.u("UpApkListMyAttentionFragment", "我关注的上传列表" + str);
        UpApkListBean upApkListBean = (UpApkListBean) this.f.fromJson(str, UpApkListBean.class);
        if (upApkListBean.getCode() != 0 || upApkListBean.getData() == null) {
            return;
        }
        try {
            ((MainActivity) this.e).z();
        } catch (Exception unused) {
        }
        if (this.p == 1) {
            if (!com.rtk.app.tool.y.x(this.e)) {
                g(ErrorCode.NETWORK_TIMEOUT, "请先登录", 1);
                return;
            }
            this.q.clear();
        }
        q();
        this.q.addAll(upApkListBean.getData());
        this.r.notifyDataSetChanged();
        this.fragementForListviewListview.setResultSize(upApkListBean.getData().size());
        this.p++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(String[] strArr) {
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z(String[] strArr) {
        H();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(final String str, final int i) {
        AutoListView autoListView = this.fragementForListviewListview;
        if (autoListView == null) {
            return;
        }
        autoListView.post(new Runnable() { // from class: com.rtk.app.main.UpModule.w
            @Override // java.lang.Runnable
            public final void run() {
                UpApkListMyAttentionFragment.this.H(i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void D() {
        AutoListView autoListView = this.fragementForListviewListview;
        if (autoListView == null) {
            return;
        }
        autoListView.post(new Runnable() { // from class: com.rtk.app.main.UpModule.t
            @Override // java.lang.Runnable
            public final void run() {
                UpApkListMyAttentionFragment.this.B();
            }
        });
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        AutoListView autoListView = this.fragementForListviewListview;
        if (autoListView == null) {
            return;
        }
        autoListView.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.UpModule.v
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                UpApkListMyAttentionFragment.this.D();
            }
        });
        this.fragementForListviewListview.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.UpModule.s
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                UpApkListMyAttentionFragment.this.F();
            }
        });
        this.fragementForListviewListview.setOnItemClickListener(new a());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("UpApkListMyAttentionFragment", "我的关注" + str);
        com.rtk.app.tool.f.a(this.e, str, f.a.f);
        AutoListView autoListView = this.fragementForListviewListview;
        if (autoListView != null) {
            autoListView.f();
            if (this.p == 1) {
                t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.UpModule.u
                    @Override // com.rtk.app.tool.s
                    public final void a(String[] strArr) {
                        UpApkListMyAttentionFragment.this.x(strArr);
                    }
                });
            }
        }
        if (i == 3002 && this.s > 0) {
            com.rtk.app.tool.t.w0(this.e);
        }
        this.s++;
        t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.UpModule.r
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                UpApkListMyAttentionFragment.this.z(strArr);
            }
        });
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        UpApkListMyAttentionAdapter upApkListMyAttentionAdapter = new UpApkListMyAttentionAdapter(this.e, this.q);
        this.r = upApkListMyAttentionAdapter;
        this.fragementForListviewListview.setAdapter((ListAdapter) upApkListMyAttentionAdapter);
    }

    @Override // com.rtk.app.base.BaseFragment
    public void n() {
        super.n();
        UpApkListMyAttentionAdapter upApkListMyAttentionAdapter = this.r;
        if (upApkListMyAttentionAdapter != null) {
            upApkListMyAttentionAdapter.b();
        }
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
            LinearLayout linearLayout = this.fragementForListviewParentLayout;
            r(linearLayout, linearLayout);
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
