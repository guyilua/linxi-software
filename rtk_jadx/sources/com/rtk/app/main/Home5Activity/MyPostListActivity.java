package com.rtk.app.main.Home5Activity;

import android.R;
import android.content.Intent;
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
import com.rtk.app.adapter.MyPostAuditListAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.CommunityPostBean;
import com.rtk.app.custom.YcRecyclerView;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyPostListActivity extends BaseActivity implements h.j {

    @BindView
    YcRecyclerView myPostListRecyclerView;

    @BindView
    SwipeRefreshLayout myPostListSwipeRefresh;

    @BindView
    TextView myPostListTopBack;

    @BindView
    LinearLayout myPostListTopLayout;
    private int q = 1;
    private List<CommunityPostBean.DataBean> r;
    private MyPostAuditListAdapter s;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements YcRecyclerView.b {
        a() {
        }

        @Override // com.rtk.app.custom.YcRecyclerView.b
        public void a() {
            MyPostListActivity.this.M(1);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements SwipeRefreshLayout.OnRefreshListener {
        b() {
        }

        public void onRefresh() {
            MyPostListActivity.this.q = 1;
            MyPostListActivity.this.M(1);
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
        this.myPostListRecyclerView.setRefreshing(true);
        M(1);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.myPostListTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void M(int... iArr) {
        String sb;
        if (iArr[0] != 1) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/myPosts");
            sb2.append(com.rtk.app.tool.y.u(this.f147c));
            sb2.append("&uid=");
            sb2.append(com.rtk.app.tool.y.K());
            sb2.append("&token=");
            sb2.append(com.rtk.app.tool.y.H());
            sb2.append("&page=");
            sb2.append(this.q);
            sb2.append("&limit=10&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
            sb = sb2.toString();
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(sb));
        com.rtk.app.tool.c0.u("MyPostListActivity", "我发布的帖子" + com.rtk.app.tool.y.d + sb);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        F();
        this.myPostListSwipeRefresh.setRefreshing(false);
        com.rtk.app.tool.c0.u("MyPostListActivity", "帖子列表  " + com.rtk.app.c.a.b(str));
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        this.myPostListRecyclerView.setRefreshing(false);
        CommunityPostBean communityPostBean = (CommunityPostBean) create.fromJson(str, CommunityPostBean.class);
        if (this.q == 1) {
            this.r.clear();
        }
        this.r.addAll(communityPostBean.getData());
        this.q++;
        if (communityPostBean.getData().size() < 10) {
            this.s.j(true);
            this.s.k(false, null);
            this.myPostListRecyclerView.setIsEnd(true);
        } else {
            this.s.j(false);
            this.s.k(false, null);
        }
        this.s.notifyDataSetChanged();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.myPostListSwipeRefresh.setRefreshing(false);
        this.myPostListRecyclerView.setRefreshing(false);
        if (this.q == 1) {
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.Home5Activity.w0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    MyPostListActivity.this.O(strArr);
                }
            });
        } else {
            this.s.j(true);
            this.s.k(true, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.Home5Activity.x0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    MyPostListActivity.this.Q(strArr);
                }
            });
        }
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        this.r = new ArrayList();
        M(1);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.myPostListRecyclerView.setRecyclerViewOnTheDownListener(new a());
        this.myPostListSwipeRefresh.setOnRefreshListener(new b());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.myPostListRecyclerView.setLayoutManager(new LinearLayoutManager(this.f147c));
        this.s = new MyPostAuditListAdapter(this.f147c, this.r);
        this.myPostListRecyclerView.addItemDecoration(new DividerItemDecoration(this.f147c, 1));
        this.myPostListRecyclerView.setAdapter(this.s);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.rtk.app.tool.c0.u("MyPostListActivity", "审核列表requestCode" + i + " resultCode  " + i2);
        if (i2 != 1024) {
            return;
        }
        int i3 = intent.getExtras().getInt("state");
        String string = intent.getExtras().getString("pid");
        for (int i4 = 0; i4 < this.r.size(); i4++) {
            if (this.r.get(i4).getPid().equals(string)) {
                this.r.get(i4).setState(i3);
                this.s.notifyDataSetChanged();
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131299486) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_my_post_list);
        ButterKnife.a(this);
        G(null, this.myPostListTopLayout);
    }
}
