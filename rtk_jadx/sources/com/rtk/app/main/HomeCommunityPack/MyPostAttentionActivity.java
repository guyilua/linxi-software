package com.rtk.app.main.HomeCommunityPack;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.adapter.CommunityFragmentPostListAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.CommunityPostBean;
import com.rtk.app.custom.YcRecyclerView;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyPostAttentionActivity extends BaseActivity implements h.j {

    @BindView
    TextView myPostAttentionBack;

    @BindView
    LinearLayout myPostAttentionLayout;

    @BindView
    YcRecyclerView myPostAttentionRecyclerView;

    @BindView
    SwipeRefreshLayout myPostAttentionSwipeLayout;
    private CommunityFragmentPostListAdapter q;
    private List<CommunityPostBean.DataBean> r;
    private int s = 1;
    private CommunityPostBean t;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements SwipeRefreshLayout.OnRefreshListener {
        a() {
        }

        public void onRefresh() {
            MyPostAttentionActivity.this.s = 1;
            MyPostAttentionActivity.this.M(1);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements YcRecyclerView.b {
        b() {
        }

        @Override // com.rtk.app.custom.YcRecyclerView.b
        public void a() {
            MyPostAttentionActivity.this.M(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O(String[] strArr) {
        M(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q(String[] strArr) {
        this.myPostAttentionRecyclerView.setRefreshing(true);
        M(1);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.myPostAttentionLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void M(int... iArr) {
        String sb;
        if (iArr[0] != 1) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("user/my-moments/bbs");
            sb2.append(com.rtk.app.tool.y.u(this.f147c));
            sb2.append("&page=");
            sb2.append(this.s);
            sb2.append("&limit=10&uid=");
            sb2.append(com.rtk.app.tool.y.K());
            sb2.append("&token=");
            sb2.append(com.rtk.app.tool.y.H());
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
            sb = sb2.toString();
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb));
        com.rtk.app.tool.c0.u("MyPostAttentionActivity", "我的关注所发的列表    " + com.rtk.app.tool.y.d + sb);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        F();
        if (i != 1) {
            return;
        }
        com.rtk.app.tool.c0.u("MyPostAttentionActivity", "我的帖子关注列表  " + str);
        this.myPostAttentionSwipeLayout.setRefreshing(false);
        this.myPostAttentionRecyclerView.setRefreshing(false);
        this.t = (CommunityPostBean) this.g.fromJson(str, CommunityPostBean.class);
        if (this.s == 1) {
            this.r.clear();
        }
        this.r.addAll(this.t.getData());
        this.s++;
        if (this.t.getData().size() < 10) {
            this.q.j(true);
            this.q.k(false, null);
            this.myPostAttentionRecyclerView.setIsEnd(true);
        } else {
            this.q.j(false);
            this.q.k(false, null);
        }
        this.q.notifyDataSetChanged();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("MyPostAttentionActivity", "我的帖子关注  请求错误" + str);
        this.myPostAttentionSwipeLayout.setRefreshing(false);
        this.myPostAttentionRecyclerView.setRefreshing(false);
        if (i2 != 1) {
            return;
        }
        if (this.s == 1) {
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.HomeCommunityPack.c
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    MyPostAttentionActivity.this.O(strArr);
                }
            });
        } else {
            this.q.j(true);
            this.q.k(true, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.HomeCommunityPack.b
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    MyPostAttentionActivity.this.Q(strArr);
                }
            });
        }
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        this.r = new ArrayList();
        this.myPostAttentionRecyclerView.setLayoutManager(new LinearLayoutManager(this.f147c));
        this.myPostAttentionRecyclerView.addItemDecoration(new DividerItemDecoration(this.f147c, 1));
        CommunityFragmentPostListAdapter communityFragmentPostListAdapter = new CommunityFragmentPostListAdapter(this.r, this.f147c);
        this.q = communityFragmentPostListAdapter;
        this.myPostAttentionRecyclerView.setAdapter(communityFragmentPostListAdapter);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.myPostAttentionSwipeLayout.setOnRefreshListener(new a());
        this.myPostAttentionRecyclerView.setRecyclerViewOnTheDownListener(new b());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        M(1);
        G(null, this.myPostAttentionLayout);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131299475) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_my_post_attention);
        ButterKnife.a(this);
    }
}
