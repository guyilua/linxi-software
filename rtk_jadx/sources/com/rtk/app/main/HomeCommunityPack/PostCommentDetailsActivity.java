package com.rtk.app.main.HomeCommunityPack;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.adapter.RecyclerViewEmptyAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.PostCommentDetailsBean;
import com.rtk.app.custom.YcRecyclerView;
import com.rtk.app.main.HomeCommunityPack.PostAdapter.PostCommentDetailsAdapter;
import com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsRecyclerViewAdapter;
import com.rtk.app.main.dialogPack.DialogPostCommentMore;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.Iterator;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostCommentDetailsActivity extends BaseActivity implements h.j, PostDetailsRecyclerViewAdapter.a {

    @BindView
    YcRecyclerView postCommentDetailsRecyclerView;

    @BindView
    SwipeRefreshLayout postCommentDetailsSwipeRefresh;

    @BindView
    TextView postCommentDetailsTopBack;

    @BindView
    LinearLayout postCommentDetailsTopLayout;

    @BindView
    ImageView postCommentDetailsTopMore;
    private PostCommentDetailsAdapter q;
    private String r;
    private int s = 1;
    private String t = "time";
    private String u;
    private PostCommentDetailsBean v;
    private PostCommentDetailsBean w;
    private String x;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements YcRecyclerView.b {
        a() {
        }

        @Override // com.rtk.app.custom.YcRecyclerView.b
        public void a() {
            PostCommentDetailsActivity.this.L(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N(String[] strArr) {
        L(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(String[] strArr) {
        this.postCommentDetailsRecyclerView.setRefreshing(true);
        L(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R() {
        this.s = 1;
        L(1);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.postCommentDetailsTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
        String sb;
        if (iArr[0] != 1) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/postsCommentByPid");
            sb2.append(com.rtk.app.tool.y.u(this.f147c));
            sb2.append("&uid=");
            sb2.append(com.rtk.app.tool.y.K());
            sb2.append("&mid=");
            sb2.append(this.x);
            sb2.append("&token=");
            sb2.append(com.rtk.app.tool.y.H());
            sb2.append("&pid=");
            sb2.append(this.r);
            sb2.append("&reply_id=");
            sb2.append(this.u);
            sb2.append("&page=");
            sb2.append(this.s);
            sb2.append("&limit=10&sort=");
            sb2.append(this.t);
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "reply_id=" + this.u, "pid=" + this.r, "mid=" + this.x, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
            sb = sb2.toString();
        }
        com.rtk.app.tool.c0.u("PostCommentDetailsActivity", "评论详情地址" + com.rtk.app.tool.y.d + sb);
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(sb));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("PostCommentDetailsActivity", "帖子评论详情  " + str);
        F();
        this.postCommentDetailsSwipeRefresh.setRefreshing(false);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i == 1) {
            PostCommentDetailsBean postCommentDetailsBean = (PostCommentDetailsBean) create.fromJson(str, PostCommentDetailsBean.class);
            this.v = postCommentDetailsBean;
            if (this.q != null && this.s != 1) {
                this.w.getData().getComment().addAll(this.v.getData().getComment());
                this.q.notifyDataSetChanged();
            } else {
                this.w = postCommentDetailsBean;
                PostCommentDetailsAdapter postCommentDetailsAdapter = new PostCommentDetailsAdapter(this.f147c, postCommentDetailsBean, this.r, this.x, this, postCommentDetailsBean.getData().getIsModerator(), this.w.getData().getNocomment());
                this.q = postCommentDetailsAdapter;
                this.postCommentDetailsRecyclerView.setAdapter(postCommentDetailsAdapter);
            }
            if (this.v.getData().getComment().size() < 10) {
                this.q.j(true);
                this.q.k(false, null);
                this.postCommentDetailsRecyclerView.setIsEnd(true);
            } else {
                this.q.j(false);
                this.q.k(false, null);
                this.postCommentDetailsRecyclerView.setIsEnd(false);
            }
            this.s++;
        }
        com.rtk.app.tool.c0.u("PostCommentDetailsActivity", "帖子回复详情" + str);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("PostCommentDetailsActivity", "帖子评论详情页:" + str + " page:" + this.s);
        if (this.s == 1) {
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.HomeCommunityPack.l
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    PostCommentDetailsActivity.this.N(strArr);
                }
            });
        }
        PostCommentDetailsAdapter postCommentDetailsAdapter = this.q;
        if (postCommentDetailsAdapter == null) {
            return;
        }
        postCommentDetailsAdapter.j(true);
        this.q.k(true, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.HomeCommunityPack.k
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                PostCommentDetailsActivity.this.P(strArr);
            }
        });
        this.postCommentDetailsSwipeRefresh.setRefreshing(false);
        com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.r = extras.getString("pid");
        this.x = extras.getString("mid");
        this.u = extras.getString("reply_id");
        com.rtk.app.tool.c0.u("PostCommentDetailsActivity", "评论地址" + this.u);
        this.postCommentDetailsRecyclerView.setLayoutManager(new LinearLayoutManager(this.f147c));
        this.postCommentDetailsRecyclerView.setAdapter(new RecyclerViewEmptyAdapter(this.f147c));
        L(1);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.postCommentDetailsRecyclerView.setRecyclerViewOnTheDownListener(new a());
        this.postCommentDetailsSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.rtk.app.main.HomeCommunityPack.m
            public final void onRefresh() {
                PostCommentDetailsActivity.this.R();
            }
        });
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    @Override // com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsRecyclerViewAdapter.a
    public void j(int i) {
        Iterator<PostCommentDetailsBean.DataBean.CommentBean> it = this.w.getData().getComment().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            PostCommentDetailsBean.DataBean.CommentBean next = it.next();
            if (next.getCmtid() == i) {
                this.w.getData().getComment().remove(next);
                break;
            }
        }
        this.q.notifyDataSetChanged();
    }

    @Override // com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsRecyclerViewAdapter.a
    public void n(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1007 && i2 == -1) {
            this.s = 1;
            L(1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131299767) {
            if (!this.w.getData().getNocomment().endsWith("0")) {
                com.rtk.app.tool.f.a(this.f147c, "暂时无法评论", f.a.f);
                return;
            }
            com.rtk.app.tool.t.M0(this.f147c, this.x, this.r, this.w.getData().getCmtid() + "", this.w.getData().getCmtid() + "", this.w.getData().getUid() + "", 0, 0);
            return;
        }
        if (id == 2131299788) {
            finish();
            return;
        }
        if (id != 2131299790) {
            return;
        }
        new DialogPostCommentMore(this.f147c, this.r, this.x, this.w.getData().getIs_owner(), this.w.getData().getIsModerator(), this.w.getData().getCmtid(), null, this.w.getData().getCmtid() + "", this.w.getData().getCmtid() + "", this.w.getData().getUid() + "", true, this.w.getData().getNocomment()).show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_post_comment_details);
        ButterKnife.a(this);
        G(null, this.postCommentDetailsTopLayout);
    }

    @Override // com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsRecyclerViewAdapter.a
    public void p(boolean z) {
    }
}
