package com.rtk.app.main.OtherImfomationPack;

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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.adapter.CommunityFragmentPostListAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.CommunityPostBean;
import com.rtk.app.custom.YcRecyclerView;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.y;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Level;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class OtherPostActivity extends BaseActivity implements h.j {

    @BindView
    YcRecyclerView otherPostListRecyclerView;

    @BindView
    SwipeRefreshLayout otherPostListSwipeRefresh;

    @BindView
    TextView otherPostListTopBack;

    @BindView
    LinearLayout otherPostListTopLayout;
    private int q = 1;
    private List<CommunityPostBean.DataBean> r;
    private CommunityFragmentPostListAdapter s;
    private String t;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements YcRecyclerView.b {
        a() {
        }

        @Override // com.rtk.app.custom.YcRecyclerView.b
        public void a() {
            OtherPostActivity.this.M(1);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements SwipeRefreshLayout.OnRefreshListener {
        b() {
        }

        public void onRefresh() {
            OtherPostActivity.this.q = 1;
            OtherPostActivity.this.M(1);
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
        this.otherPostListRecyclerView.setRefreshing(true);
        M(1);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.otherPostListTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void M(int... iArr) {
        String sb;
        if (iArr[0] != 1) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/hisPosts");
            sb2.append(y.u(this.f147c));
            sb2.append("&uid=");
            sb2.append(this.t);
            sb2.append("&page=");
            sb2.append(this.q);
            sb2.append("&limit=10&key=");
            sb2.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.f147c, "uid=" + this.t))));
            sb = sb2.toString();
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(sb));
        c0.u("OtherPostActivity", "我发布的帖子" + y.d + sb);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        this.otherPostListSwipeRefresh.setRefreshing(false);
        c0.a("OtherPostActivity", "社区列表  " + str, 1, new Level[0]);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        this.otherPostListRecyclerView.setRefreshing(false);
        CommunityPostBean communityPostBean = (CommunityPostBean) create.fromJson(str, CommunityPostBean.class);
        if (this.q == 1) {
            this.r.clear();
        }
        this.r.addAll(communityPostBean.getData());
        this.q++;
        if (communityPostBean.getData().size() < 10) {
            this.s.j(true);
            this.s.k(false, null);
            this.otherPostListRecyclerView.setIsEnd(true);
        } else {
            this.s.j(false);
            this.s.k(false, null);
        }
        this.s.notifyDataSetChanged();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.otherPostListSwipeRefresh.setRefreshing(false);
        this.otherPostListRecyclerView.setRefreshing(false);
        this.s.j(true);
        if (this.q == 1) {
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.OtherImfomationPack.n
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    OtherPostActivity.this.O(strArr);
                }
            });
        }
        this.s.k(true, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.OtherImfomationPack.o
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                OtherPostActivity.this.Q(strArr);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        this.t = getIntent().getExtras().getString("uid");
        this.r = new ArrayList();
        M(1);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.otherPostListRecyclerView.setRecyclerViewOnTheDownListener(new a());
        this.otherPostListSwipeRefresh.setOnRefreshListener(new b());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.otherPostListRecyclerView.setLayoutManager(new LinearLayoutManager(this.f147c));
        this.s = new CommunityFragmentPostListAdapter(this.r, this.f147c);
        this.otherPostListRecyclerView.addItemDecoration(new DividerItemDecoration(this.f147c, 1));
        this.otherPostListRecyclerView.setAdapter(this.s);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131299690) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_other_post);
        ButterKnife.a(this);
    }
}
