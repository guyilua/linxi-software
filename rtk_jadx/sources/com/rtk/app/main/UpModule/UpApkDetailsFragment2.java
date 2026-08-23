package com.rtk.app.main.UpModule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.adapter.UpApkDetailsCommentAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.UpApkCommentBean;
import com.rtk.app.custom.YcRecyclerView;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpApkDetailsFragment2 extends BaseFragment implements h.j {
    Unbinder o;
    private ApkInfo q;
    private int r;
    private UpApkCommentBean s;
    private List<UpApkCommentBean.DataBean> t;
    private UpApkDetailsCommentAdapter u;

    @BindView
    TextView upApkDetailsFragment2CommentBtu;

    @BindView
    RadioButton upApkDetailsFragment2Hot;

    @BindView
    RadioButton upApkDetailsFragment2Newest;

    @BindView
    YcRecyclerView upApkDetailsFragment2RecyclerView;

    @BindView
    SwipeRefreshLayout upApkDetailsFragment2Refresh;

    @BindView
    RadioGroup upApkDetailsFragment2Sort;

    @BindView
    LinearLayout upApkDetailsFragment2SortLv;
    private int p = 1;
    private String v = "0";

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D(RadioGroup radioGroup, int i) {
        this.v = this.upApkDetailsFragment2Newest.isChecked() ? "0" : "1";
        this.p = 1;
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(String[] strArr) {
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(String[] strArr) {
        this.upApkDetailsFragment2RecyclerView.setRefreshing(true);
        A();
    }

    public void E(int i, String str) {
        UpApkCommentBean.DataBean.ReplyBean replyBean = new UpApkCommentBean.DataBean.ReplyBean();
        replyBean.setContent(str);
        replyBean.setU_name(MainActivity.p.getData().getNickname());
        if (this.t.get(i).getReply() == null) {
            this.t.get(i).setReply(new ArrayList());
        }
        this.t.get(i).getReply().add(0, replyBean);
        this.u.notifyItemChanged(i);
    }

    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void z() {
        this.p = 1;
        A();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        q();
        this.upApkDetailsFragment2RecyclerView.setRefreshing(false);
        this.upApkDetailsFragment2Refresh.setRefreshing(false);
        if (i != 1) {
            return;
        }
        com.rtk.app.tool.c0.u("UpApkDetailsFragment2", "up资源评论列表" + str);
        this.s = (UpApkCommentBean) this.f.fromJson(str, UpApkCommentBean.class);
        if (this.p == 1) {
            this.t.clear();
        }
        this.t.addAll(this.s.getData());
        if (this.s.getData().size() < 10) {
            this.upApkDetailsFragment2RecyclerView.setIsEnd(true);
            this.u.j(true);
        } else {
            this.upApkDetailsFragment2RecyclerView.setIsEnd(false);
            this.u.j(false);
        }
        this.u.k(false, null);
        this.u.notifyDataSetChanged();
        this.p++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void B() {
        StringBuilder sb = new StringBuilder();
        sb.append("members/sourceCommentList");
        sb.append(com.rtk.app.tool.y.u(this.e));
        sb.append("&sid=");
        sb.append(this.q.getUpGameId());
        sb.append("&limit=10&page=");
        sb.append(this.p);
        sb.append("&model=");
        sb.append(this.v);
        sb.append("&uid=");
        sb.append(com.rtk.app.tool.y.K());
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.e, "sid=" + this.q.getUpGameId()))));
        String sb2 = sb.toString();
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a(sb2));
        com.rtk.app.tool.c0.u("UpApkDetailsFragment2", "  up详情评论地址  " + com.rtk.app.tool.y.d + sb2);
        new Throwable().printStackTrace();
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.upApkDetailsFragment2Refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.rtk.app.main.UpModule.n
            public final void onRefresh() {
                UpApkDetailsFragment2.this.z();
            }
        });
        this.upApkDetailsFragment2CommentBtu.setOnClickListener(this);
        this.upApkDetailsFragment2RecyclerView.setRecyclerViewOnTheDownListener(new YcRecyclerView.b() { // from class: com.rtk.app.main.UpModule.k
            @Override // com.rtk.app.custom.YcRecyclerView.b
            public final void a() {
                UpApkDetailsFragment2.this.B();
            }
        });
        this.upApkDetailsFragment2Sort.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.rtk.app.main.UpModule.m
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                UpApkDetailsFragment2.this.D(radioGroup, i);
            }
        });
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.e, str, f.a.f);
        com.rtk.app.tool.c0.u("UpApkDetailsFragment2", "up资源评论错误" + str);
        if (i2 != 1) {
            return;
        }
        this.upApkDetailsFragment2RecyclerView.setRefreshing(false);
        this.upApkDetailsFragment2Refresh.setRefreshing(false);
        if (this.p == 1) {
            o();
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.UpModule.j
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    UpApkDetailsFragment2.this.v(strArr);
                }
            });
        }
        this.u.j(true);
        this.u.k(true, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.UpModule.l
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                UpApkDetailsFragment2.this.x(strArr);
            }
        });
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.q = (ApkInfo) getArguments().getSerializable("apkInfo");
        this.r = getArguments().getInt("upUid");
        ArrayList arrayList = new ArrayList();
        this.t = arrayList;
        this.u = new UpApkDetailsCommentAdapter(this.e, arrayList, this.q, this.r);
        this.upApkDetailsFragment2RecyclerView.addItemDecoration(new DividerItemDecoration(this.e, 1));
        this.upApkDetailsFragment2RecyclerView.setLayoutManager(new LinearLayoutManager(this.e));
        this.upApkDetailsFragment2RecyclerView.setAdapter(this.u);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131300630) {
            return;
        }
        if (!com.rtk.app.tool.y.x(this.e)) {
            com.rtk.app.tool.t.w0(this.e);
            return;
        }
        com.rtk.app.tool.t.l0(this.e, 0, this.q.getUpGameId(), 0, 0, "0", this.q.getPackageName(), "upApk", this.r + "");
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.up_apk_details_fragment2_layout, viewGroup, false);
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
