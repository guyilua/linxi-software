package com.rtk.app.main.HomeCommunityPack;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.adapter.RecyclerViewEmptyAdapter;
import com.rtk.app.base.BaseForFullAPI26Activity;
import com.rtk.app.bean.PostDetailsBean;
import com.rtk.app.bean.PostDetailsCommentBean;
import com.rtk.app.bean.ReplyBean;
import com.rtk.app.bean.UpSuguestBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.custom.FocusNoLayoutManager;
import com.rtk.app.custom.RichEditText.PostModificationBean;
import com.rtk.app.custom.YcRecyclerView;
import com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsRecyclerViewAdapter;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.dialogPack.DialogForAuditPost;
import com.rtk.app.main.dialogPack.DialogForBBsCheckReason;
import com.rtk.app.main.dialogPack.DialogForEditEnSure;
import com.rtk.app.main.dialogPack.DialogForEnSure;
import com.rtk.app.main.dialogPack.DialogPostMore;
import com.rtk.app.main.dialogPack.DialogPostPageTurning;
import com.rtk.app.main.dialogPack.DialogPostReward;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.base.mta.PointType;
import com.sigmob.sdk.downloader.f;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostDetailsActivity extends BaseForFullAPI26Activity implements h.j, PostDetailsRecyclerViewAdapter.a, com.rtk.app.tool.s {
    private PostModificationBean A;
    private int B;
    private String C;
    private UpSuguestBean E;
    private String F;
    private boolean G;
    private DialogForAuditPost H;
    private String l;
    private PostDetailsBean m;
    private PostDetailsRecyclerViewAdapter n;
    private PostDetailsBean.DataBean p;

    @BindView
    TextView postDetailsBack;

    @BindView
    CheckBox postDetailsCollect;

    @BindView
    ImageView postDetailsComment;

    @BindView
    RelativeLayout postDetailsFootLv;

    @BindView
    LinearLayout postDetailsLayout;

    @BindView
    ImageView postDetailsPageLast;

    @BindView
    ImageView postDetailsPageNext;

    @BindView
    TextView postDetailsPageNum;

    @BindView
    YcRecyclerView postDetailsRecyclerView;

    @BindView
    ImageView postDetailsReward;

    @BindView
    SwipeRefreshLayout postDetailsSwipeRefresh;

    @BindView
    TextView postDetailsTopAuditBtu;

    @BindView
    CustomTextView postDetailsTopAuditState;

    @BindView
    CustomTextView postDetailsTopAuditState3;

    @BindView
    TextView postDetailsTopFamilyAuditBtu;

    @BindView
    ImageView postDetailsTopMore;

    @BindView
    CheckBox postDetailsUp;

    @BindView
    LinearLayout postDetailsVideoLv;
    private String r;
    private DialogPostPageTurning v;
    private PostDetailsCommentBean x;
    private LinearLayoutManager z;
    private int o = 1;
    private int q = 0;
    private int s = 1;
    private List<PostDetailsCommentBean.DataBean.ReplyListBean> t = new ArrayList();
    private List<PostDetailsCommentBean.DataBean.ReplyListBean> u = new ArrayList();
    private int w = 0;
    private boolean y = false;
    private String D = "";

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements com.rtk.app.tool.s {
        a() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            PostDetailsActivity.this.D = "";
            PostDetailsActivity.this.J(10);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements com.rtk.app.tool.s {

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        class a implements com.rtk.app.tool.s {
            a() {
            }

            @Override // com.rtk.app.tool.s
            public void a(String... strArr) {
                PostDetailsActivity.this.D = strArr[0];
                PostDetailsActivity.this.J(10);
            }
        }

        b() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            new DialogForEditEnSure(PostDetailsActivity.this.f148c, strArr[0], new a()).show();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements com.rtk.app.tool.s {
        c() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            PostDetailsActivity.this.J(20);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class d implements com.rtk.app.tool.s {
        d() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            PostDetailsActivity.this.J(30);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class e implements com.rtk.app.tool.s {
        e() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            PostDetailsActivity.this.J(40);
        }
    }

    private DialogForAuditPost H(boolean z) {
        int state;
        int i;
        if (this.m.getData().getFamily() != null && z) {
            i = this.m.getData().getFamily().getFamily_id();
            state = this.m.getData().getState3();
        } else {
            state = this.m.getData().getState();
            i = 0;
        }
        DialogForAuditPost dialogForAuditPost = new DialogForAuditPost(this.f148c, state, this.r, this.l, i, this.E, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.HomeCommunityPack.n
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                PostDetailsActivity.this.R(strArr);
            }
        });
        this.H = dialogForAuditPost;
        dialogForAuditPost.w(z);
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(int i) {
        String str;
        if (i == 10) {
            StringBuilder sb = new StringBuilder();
            sb.append("bbs/posts/delete");
            sb.append(com.rtk.app.tool.y.u(this.f148c));
            sb.append("&uid=");
            sb.append(com.rtk.app.tool.y.K());
            sb.append("&token=");
            sb.append(com.rtk.app.tool.y.H());
            sb.append("&mid=");
            sb.append(this.r);
            sb.append("&pid=");
            sb.append(this.l);
            sb.append("&msg=");
            sb.append(this.D);
            sb.append("&key=");
            sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f148c, "pid=" + this.l, "mid=" + this.r, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(" 删除  ");
            sb3.append(com.rtk.app.tool.y.d);
            sb3.append(sb2);
            com.rtk.app.tool.c0.u("PostDetailsActivity", sb3.toString());
            com.rtk.app.tool.o.h.l(this.f148c, this, i, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb2));
            return;
        }
        if (i == 20) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("bbs/posts/set-top");
            sb4.append(com.rtk.app.tool.y.u(this.f148c));
            sb4.append("&uid=");
            sb4.append(com.rtk.app.tool.y.K());
            sb4.append("&token=");
            sb4.append(com.rtk.app.tool.y.H());
            sb4.append("&mid=");
            sb4.append(this.r);
            sb4.append("&pid=");
            sb4.append(this.l);
            sb4.append("&key=");
            sb4.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f148c, "pid=" + this.l, "mid=" + this.r, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
            com.rtk.app.tool.o.h.l(this.f148c, this, i, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb4.toString()));
            return;
        }
        if (i == 30) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("bbs/posts/set-boutique");
            sb5.append(com.rtk.app.tool.y.u(this.f148c));
            sb5.append("&uid=");
            sb5.append(com.rtk.app.tool.y.K());
            sb5.append("&token=");
            sb5.append(com.rtk.app.tool.y.H());
            sb5.append("&mid=");
            sb5.append(this.r);
            sb5.append("&pid=");
            sb5.append(this.l);
            sb5.append("&key=");
            sb5.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f148c, "pid=" + this.l, "mid=" + this.r, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
            com.rtk.app.tool.o.h.l(this.f148c, this, i, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb5.toString()));
            return;
        }
        if (i != 40) {
            if (i != 50) {
                str = "";
            } else {
                str = "members/modulesList" + com.rtk.app.tool.y.u(this.f148c) + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f148c, new String[0])));
            }
            if (com.rtk.app.tool.c0.q(str)) {
                return;
            }
            com.rtk.app.tool.o.h.l(this.f148c, this, i, com.rtk.app.tool.o.h.h(new String[0]).a(str));
            return;
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("bbs/posts/close-comment");
        sb6.append(com.rtk.app.tool.y.u(this.f148c));
        sb6.append("&uid=");
        sb6.append(com.rtk.app.tool.y.K());
        sb6.append("&token=");
        sb6.append(com.rtk.app.tool.y.H());
        sb6.append("&mid=");
        sb6.append(this.r);
        sb6.append("&pid=");
        sb6.append(this.l);
        sb6.append("&key=");
        sb6.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f148c, "pid=" + this.l, "mid=" + this.r, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
        com.rtk.app.tool.o.h.l(this.f148c, this, i, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb6.toString()));
    }

    private void K() {
        this.postDetailsComment.setSelected(this.m.getData().getNocomment().equals("0"));
        if (c.d.a.d.d() && (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getAdmin() == 2 || MainActivity.p.getData().getAdmin().getBbsAdmin() == 1 || MainActivity.p.getData().getAdmin().getBbsAdmin() == 2 || this.m.getData().getModuleAdmin() == 1 || this.m.getData().getModuleAdmin() == 2)) {
            this.postDetailsTopAuditState.setVisibility(0);
        } else {
            this.postDetailsTopAuditState.setVisibility(8);
        }
        if (c.d.a.d.d() && (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getBbsAdmin() == 1 || this.m.getData().getModuleAdmin() == 1)) {
            this.postDetailsTopAuditBtu.setVisibility(L() ? 8 : 0);
            this.postDetailsTopFamilyAuditBtu.setVisibility(8);
            I(5);
        } else if (c.d.a.d.d() && ((MainActivity.p.getData().getAdmin().getAdmin() == 2 || MainActivity.p.getData().getAdmin().getBbsAdmin() == 2 || this.m.getData().getModuleAdmin() == 2) && this.m.getData().getState() == 1)) {
            I(5);
            this.postDetailsTopAuditBtu.setVisibility(L() ? 8 : 0);
            this.postDetailsTopFamilyAuditBtu.setVisibility(8);
        } else {
            this.postDetailsTopAuditBtu.setVisibility(8);
        }
        this.postDetailsTopFamilyAuditBtu.setVisibility(c.d.a.d.a(this.F) ? 0 : 8);
        this.postDetailsTopAuditState3.setVisibility(c.d.a.d.a(this.F) ? 0 : 8);
    }

    private boolean L() {
        return MainActivity.p.getData().getUid() == Integer.parseInt(this.m.getData().getUid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N(String[] strArr) {
        I(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(int i, String[] strArr) {
        this.postDetailsRecyclerView.setRefreshing(true);
        I(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R(String[] strArr) {
        try {
            com.rtk.app.tool.c0.u("PostDetailsActivity", "下拉监听" + this.n.l());
            if (this.n.l()) {
                this.s = this.u.get(0).getPage() - 1;
                List<PostDetailsCommentBean.DataBean.ReplyListBean> list = this.u;
                int page = list.get(list.size() - 1).getPage();
                if (this.s == this.o - 1) {
                    int size = this.t.size() + 2;
                    this.n.o(false);
                    this.t.addAll(this.u);
                    this.u.clear();
                    this.n.n(this.t);
                    this.n.notifyDataSetChanged();
                    this.z.scrollToPositionWithOffset(size, 0);
                    this.postDetailsSwipeRefresh.setRefreshing(false);
                    this.o = page + 1;
                } else {
                    I(0);
                }
            } else {
                this.o = 1;
                I(1);
                this.w = 0;
            }
        } catch (Exception e2) {
            com.rtk.app.tool.c0.u("PostDetailsActivity", "下拉监听异常" + e2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T() {
        PostDetailsRecyclerViewAdapter postDetailsRecyclerViewAdapter = this.n;
        if (postDetailsRecyclerViewAdapter == null) {
            return;
        }
        if (postDetailsRecyclerViewAdapter.l()) {
            if (this.u.size() > 0) {
                List<PostDetailsCommentBean.DataBean.ReplyListBean> list = this.u;
                this.s = list.get(list.size() - 1).getPage() + 1;
            }
            I(0);
            return;
        }
        I(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V() {
        try {
            com.rtk.app.tool.c0.u("PostDetailsActivity", "下拉监听" + this.n.l());
            if (this.n.l()) {
                this.s = this.u.get(0).getPage() - 1;
                List<PostDetailsCommentBean.DataBean.ReplyListBean> list = this.u;
                int page = list.get(list.size() - 1).getPage();
                if (this.s == this.o - 1) {
                    int size = this.t.size() + 2;
                    this.n.o(false);
                    this.t.addAll(this.u);
                    this.u.clear();
                    this.n.n(this.t);
                    this.n.notifyDataSetChanged();
                    this.z.scrollToPositionWithOffset(size, 0);
                    this.postDetailsSwipeRefresh.setRefreshing(false);
                    this.o = page + 1;
                } else {
                    I(0);
                }
            } else {
                this.o = 1;
                I(1);
                this.w = 0;
            }
        } catch (Exception e2) {
            com.rtk.app.tool.c0.u("PostDetailsActivity", "下拉监听异常" + e2.toString());
        }
    }

    private void Y(PostDetailsBean.DataBean dataBean) {
        c.d.a.d.e(this.f148c, this.postDetailsTopAuditState, dataBean.getState(), dataBean.getMsg());
        c.d.a.d.e(this.f148c, this.postDetailsTopAuditState3, dataBean.getState3(), dataBean.getMsg3());
    }

    public void I(int... iArr) {
        com.rtk.app.tool.o.i h;
        int i = iArr[0];
        if ((i == 2 || i == 3) && !com.rtk.app.tool.y.x(this.f148c)) {
            com.rtk.app.tool.t.w0(this.f148c);
        }
        com.rtk.app.tool.o.i h2 = com.rtk.app.tool.o.h.h(new String[0]);
        int i2 = iArr[0];
        String str = "";
        if (i2 == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("bbs/comment-list");
            sb.append(com.rtk.app.tool.y.u(this.f148c));
            sb.append("&pid=");
            sb.append(this.l);
            sb.append("&page=");
            sb.append(this.s);
            sb.append("&limit=10&order=");
            sb.append(this.q);
            sb.append("&owner=");
            sb.append(this.w);
            sb.append("&uid=");
            sb.append(com.rtk.app.tool.y.K());
            sb.append("&token=");
            sb.append(com.rtk.app.tool.y.H());
            sb.append("&key=");
            sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f148c, "pid=" + this.l, "order=" + this.q))));
            str = sb.toString();
            h = com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e);
        } else if (i2 == 1) {
            HashMap<String, String> k = com.rtk.app.tool.y.k();
            k.put("pid", this.l);
            k.put("di", com.rtk.app.tool.y.r(this.f148c));
            String z = com.rtk.app.tool.y.z("token");
            String z2 = com.rtk.app.tool.y.z("uid");
            k.put(z, com.rtk.app.tool.y.H());
            k.put(z2, com.rtk.app.tool.y.K());
            k.put("key", com.rtk.app.tool.t.L(k));
            str = com.rtk.app.tool.y.w("bbs/detail", k);
            h = com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e);
        } else if (i2 == 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/postsLike");
            sb2.append(com.rtk.app.tool.y.u(this.f148c));
            sb2.append("&uid=");
            sb2.append(com.rtk.app.tool.y.K());
            sb2.append("&token=");
            sb2.append(com.rtk.app.tool.y.H());
            sb2.append("&mid=");
            sb2.append(this.m.getData().getMid());
            sb2.append("&pid=");
            sb2.append(this.l);
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f148c, "pid=" + this.l, "mid=" + this.m.getData().getMid(), "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
            str = sb2.toString();
            if (this.G) {
                h = com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e);
            }
            h = h2;
        } else if (i2 == 3) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("members/focusPosts");
            sb3.append(com.rtk.app.tool.y.u(this.f148c));
            sb3.append("&uid=");
            sb3.append(com.rtk.app.tool.y.K());
            sb3.append("&token=");
            sb3.append(com.rtk.app.tool.y.H());
            sb3.append("&mid=");
            sb3.append(this.m.getData().getMid());
            sb3.append("&pid=");
            sb3.append(this.l);
            sb3.append("&key=");
            sb3.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f148c, "pid=" + this.l, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
            str = sb3.toString();
            if (this.G) {
                h = com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e);
            }
            h = h2;
        } else if (i2 != 4) {
            if (i2 == 5) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("bbs/posts/suggest");
                sb4.append(com.rtk.app.tool.y.u(this.f148c));
                sb4.append("&uid=");
                sb4.append(com.rtk.app.tool.y.K());
                sb4.append("&token=");
                sb4.append(com.rtk.app.tool.y.H());
                sb4.append("&pid=");
                sb4.append(this.l);
                sb4.append("&key=");
                sb4.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f148c, "pid=" + this.l, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
                str = sb4.toString();
                h = com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e);
            }
            h = h2;
        } else {
            HashMap<String, String> k2 = com.rtk.app.tool.y.k();
            String z3 = com.rtk.app.tool.y.z("uid");
            String z4 = com.rtk.app.tool.y.z("token");
            k2.put(z3, com.rtk.app.tool.y.K());
            k2.put(z4, com.rtk.app.tool.y.H());
            k2.put(com.rtk.app.tool.y.z("owner"), this.w + "");
            k2.put("order", this.q + "");
            k2.put("pid", this.l);
            k2.put(com.rtk.app.tool.y.z("page"), this.o + "");
            k2.put(com.rtk.app.tool.y.z("limit"), PointType.SIGMOB_APP);
            k2.put("key", com.rtk.app.tool.t.L(k2));
            str = com.rtk.app.tool.y.w("bbs/comment-list", k2);
            h = com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e);
        }
        com.rtk.app.tool.c0.u("PostDetailsActivity", "帖子详情   " + com.rtk.app.tool.y.e + str);
        com.rtk.app.tool.o.h.l(this.f148c, this, iArr[0], h.a(str));
    }

    public void W(boolean z) {
        this.postDetailsPageLast.setEnabled(z);
        this.postDetailsPageNext.setEnabled(z);
        this.postDetailsPageNum.setEnabled(z);
    }

    public void X(int i) {
        DialogPostPageTurning dialogPostPageTurning = this.v;
        if (dialogPostPageTurning != null) {
            dialogPostPageTurning.dismiss();
        }
        com.rtk.app.tool.c0.u("PostDetailsActivity", "跳转页" + i);
        this.s = i;
        if (this.o <= i) {
            this.n.o(true);
            if (this.u.size() > 0) {
                int page = this.u.get(0).getPage();
                List<PostDetailsCommentBean.DataBean.ReplyListBean> list = this.u;
                int page2 = list.get(list.size() - 1).getPage();
                if (page <= i && i <= page2) {
                    com.rtk.app.tool.c0.u("PostDetailsActivity", "超限翻页");
                    W(true);
                    this.z.scrollToPositionWithOffset((i - this.u.get(0).getPage()) * 10, 0);
                    return;
                } else {
                    this.y = true;
                    I(0);
                    return;
                }
            }
            this.y = true;
            I(0);
            return;
        }
        com.rtk.app.tool.c0.u("PostDetailsActivity", "正常跳转的已加载page" + this.o + "   需要跳转的pageNum" + i);
        if (this.o - 1 <= i) {
            com.rtk.app.tool.c0.u("PostDetailsActivity", "pageTuring 1");
            if (this.u.size() > 0) {
                int page3 = this.u.get(0).getPage();
                List<PostDetailsCommentBean.DataBean.ReplyListBean> list2 = this.u;
                int page4 = list2.get(list2.size() - 1).getPage();
                com.rtk.app.tool.c0.u("PostDetailsActivity", "pageTuring 2  " + page3);
                if (page3 == this.o) {
                    this.t.addAll(this.u);
                    this.o = page4 + 1;
                    com.rtk.app.tool.c0.u("PostDetailsActivity", "pageTuring 3");
                    this.n.o(false);
                    this.n.n(this.t);
                    this.n.notifyDataSetChanged();
                    W(true);
                    return;
                }
                com.rtk.app.tool.c0.u("PostDetailsActivity", "pageTuring 4");
                this.u.clear();
                this.n.o(false);
                this.n.n(this.t);
                this.n.notifyDataSetChanged();
                W(true);
                this.z.scrollToPositionWithOffset(((i - 1) * 10) + 3, 0);
                return;
            }
            com.rtk.app.tool.c0.u("PostDetailsActivity", "pageTuring 5");
            this.y = true;
            I(4);
            return;
        }
        com.rtk.app.tool.c0.u("PostDetailsActivity", "跳转   " + i);
        this.n.o(false);
        this.n.n(this.t);
        this.n.notifyDataSetChanged();
        W(true);
        this.z.scrollToPositionWithOffset(((i - 1) * 10) + 3, 0);
    }

    public void Z(int i) {
        int parseInt;
        try {
            this.s = i;
            if (i == 0) {
                i = 1;
            }
            if (this.w == 1) {
                parseInt = this.p.getOwnerNum();
            } else {
                parseInt = Integer.parseInt(this.p.getCommentNum());
            }
            int i2 = (parseInt / 10) + (parseInt % 10 > 0 ? 1 : 0);
            if (i > i2) {
                return;
            }
            this.postDetailsPageNum.setText(i + "/" + i2);
            this.postDetailsPageLast.setEnabled(true);
            this.postDetailsPageNext.setEnabled(true);
            if (i == 1) {
                this.postDetailsPageLast.setEnabled(false);
            } else if (i == i2) {
                this.postDetailsPageNext.setEnabled(false);
            }
        } catch (NullPointerException e2) {
            com.rtk.app.tool.c0.u("PostDetailsActivity", "异常setPageNum" + e2.toString());
        }
    }

    @Override // com.rtk.app.tool.s
    public void a(String... strArr) {
        if (strArr.length <= 0) {
            return;
        }
        String str = strArr[0];
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 646183:
                if (str.equals("举报")) {
                    c2 = 0;
                    break;
                }
                break;
            case 671077:
                if (str.equals("分享")) {
                    c2 = 1;
                    break;
                }
                break;
            case 658768457:
                if (str.equals("关闭回复")) {
                    c2 = 2;
                    break;
                }
                break;
            case 661597848:
                if (str.equals("加精帖子")) {
                    c2 = 3;
                    break;
                }
                break;
            case 664094526:
                if (str.equals("删除帖子")) {
                    c2 = 4;
                    break;
                }
                break;
            case 667008528:
                if (str.equals("取消加精")) {
                    c2 = 5;
                    break;
                }
                break;
            case 667371194:
                if (str.equals("取消置顶")) {
                    c2 = 6;
                    break;
                }
                break;
            case 745939806:
                if (str.equals("开启回复")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1005310069:
                if (str.equals("编辑帖子")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 1010119874:
                if (str.equals("置顶帖子")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 1124585545:
                if (str.equals("转移帖子")) {
                    c2 = '\n';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                if (!com.rtk.app.tool.y.x(this.f148c)) {
                    com.rtk.app.tool.t.w0(this.f148c);
                    com.rtk.app.tool.f.a(this.f148c, "请先登录", f.a.f);
                    return;
                } else {
                    com.rtk.app.tool.t.R0(this.f148c, this.r, this.l, "");
                    return;
                }
            case 1:
                com.rtk.app.tool.t.Z1(this.f148c);
                return;
            case 2:
            case 7:
                new DialogForEnSure(this.f148c, "确认" + strArr[0] + "吗？", new e()).show();
                return;
            case 3:
            case 5:
                new DialogForEnSure(this.f148c, "确认" + strArr[0] + "吗？", new d()).show();
                return;
            case 4:
                if (com.rtk.app.tool.y.K().equals(this.m.getData().getUid())) {
                    new DialogForEnSure(this.f148c, "确认删除吗？", new a()).show();
                    return;
                } else {
                    new DialogForBBsCheckReason(this.f148c, new b()).show();
                    return;
                }
            case 6:
            case '\t':
                new DialogForEnSure(this.f148c, "确认" + strArr[0] + "吗？", new c()).show();
                return;
            case '\b':
                Intent intent = new Intent((Context) this.f148c, (Class<?>) PublishPostActivity.class);
                this.A = new PostModificationBean(this.p.getId());
                Bundle bundle = new Bundle();
                bundle.putSerializable("modificationBean", this.A);
                intent.putExtras(bundle);
                startActivityForResult(intent, 1021);
                return;
            case '\n':
                new com.rtk.app.main.dialogPack.t(this.f148c, this.r, this.l).show();
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x04b0  */
    @Override // com.rtk.app.tool.o.h.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(java.lang.String r12, int r13) {
        /*
            Method dump skipped, instructions count: 1252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.main.HomeCommunityPack.PostDetailsActivity.d(java.lang.String, int):void");
    }

    @Override // com.rtk.app.base.BaseForFullAPI26Activity
    public void finish() {
        super.finish();
        PostDetailsRecyclerViewAdapter postDetailsRecyclerViewAdapter = this.n;
        if (postDetailsRecyclerViewAdapter != null) {
            postDetailsRecyclerViewAdapter.i();
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, final int i2) {
        new Throwable().printStackTrace();
        E(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.HomeCommunityPack.o
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                PostDetailsActivity.this.N(strArr);
            }
        });
        if (i2 != 0) {
            if (i2 == 3) {
                com.rtk.app.tool.f.a(this.f148c, "收藏失败", 200);
                return;
            }
            if (i2 != 4) {
                if (i2 != 5) {
                    com.rtk.app.tool.c0.u("PostDetailsActivity", "错误来源" + i2);
                    this.postDetailsSwipeRefresh.setRefreshing(false);
                    com.rtk.app.tool.f.a(this.f148c, str, f.a.f);
                    W(true);
                    return;
                }
                com.rtk.app.tool.c0.u("PostDetailsActivity", "审核建议请求失败" + str);
                return;
            }
        }
        this.n.j(true);
        this.postDetailsSwipeRefresh.setRefreshing(false);
        this.n.k(true, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.HomeCommunityPack.r
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                PostDetailsActivity.this.P(i2, strArr);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.l = extras.getString("pid");
        this.F = extras.getString("family_id");
        this.G = !TextUtils.isEmpty(r0);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.postDetailsRecyclerView.setRecyclerViewOnTheDownListener(new YcRecyclerView.b() { // from class: com.rtk.app.main.HomeCommunityPack.p
            @Override // com.rtk.app.custom.YcRecyclerView.b
            public final void a() {
                PostDetailsActivity.this.T();
            }
        });
        this.postDetailsSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.rtk.app.main.HomeCommunityPack.q
            public final void onRefresh() {
                PostDetailsActivity.this.V();
            }
        });
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        I(1);
        FocusNoLayoutManager focusNoLayoutManager = new FocusNoLayoutManager(this.f148c);
        this.z = focusNoLayoutManager;
        this.postDetailsRecyclerView.setLayoutManager(focusNoLayoutManager);
        this.postDetailsRecyclerView.setAdapter(new RecyclerViewEmptyAdapter(this.f148c));
        this.postDetailsVideoLv.setVisibility(0);
    }

    @Override // com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsRecyclerViewAdapter.a
    public void j(int i) {
        Iterator<PostDetailsCommentBean.DataBean.ReplyListBean> it = this.t.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            PostDetailsCommentBean.DataBean.ReplyListBean next = it.next();
            if (next.getCmtid() == i) {
                this.t.remove(next);
                break;
            }
        }
        this.n.notifyDataSetChanged();
    }

    @Override // com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsRecyclerViewAdapter.a
    public void n(int i) {
        if (this.q == i) {
            return;
        }
        this.q = i;
        this.o = 1;
        I(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseForFullAPI26Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.rtk.app.tool.c0.u("PostDetailsActivity", "帖子详情返回 requestCode " + i + "  resultCode " + i2);
        if (i == 1006) {
            if (i2 != -1) {
                return;
            }
            this.o = 1;
            this.q = 0;
            this.w = 0;
            I(1);
            return;
        }
        if (i != 1007) {
            if (i != 1020) {
                if (i == 1021 && i2 == 1) {
                    this.o = 1;
                    I(1);
                    return;
                }
                return;
            }
            if (i2 != 1) {
                return;
            }
            Bundle extras = intent.getExtras();
            int i3 = extras.getInt("up");
            int i4 = extras.getInt("cmid");
            int i5 = extras.getInt(com.umeng.analytics.pro.d.W);
            if (!this.n.l()) {
                Iterator<PostDetailsCommentBean.DataBean.ReplyListBean> it = this.t.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostDetailsCommentBean.DataBean.ReplyListBean next = it.next();
                    if (next.getCmtid() == i4) {
                        next.setDu(i5);
                        next.setIsdu(i3);
                        break;
                    }
                }
            } else {
                for (PostDetailsCommentBean.DataBean.ReplyListBean replyListBean : this.u) {
                    if (replyListBean.getCmtid() == i4) {
                        replyListBean.setIsdu(i3);
                        replyListBean.setDu(i5);
                    }
                }
            }
            this.n.notifyDataSetChanged();
            return;
        }
        if (i2 != -1) {
            return;
        }
        String string = intent.getExtras().getString("secondContent");
        String string2 = intent.getExtras().getString("NickName");
        int i6 = intent.getExtras().getInt("position");
        int i7 = intent.getExtras().getInt("truePosition");
        ReplyBean replyBean = new ReplyBean();
        replyBean.setU_name(string2);
        replyBean.setContent(string);
        com.rtk.app.tool.c0.u("PostDetailsActivity", "truePosition" + i7 + "  position" + i6);
        try {
            com.rtk.app.tool.c0.u("PostDetailsActivity", "尺寸" + this.t.size() + "    " + this.u.size());
            if (this.n.l()) {
                StringBuilder sb = new StringBuilder();
                sb.append("更新之前  ");
                List<PostDetailsCommentBean.DataBean.ReplyListBean> list = this.t;
                sb.append(list.get(list.size() - 1).getReplyNum());
                com.rtk.app.tool.c0.u("PostDetailsActivity", sb.toString());
                this.u.get(i7).getReply().add(0, replyBean);
            } else {
                com.rtk.app.tool.c0.u("PostDetailsActivity", "notOnlyComment");
                this.t.get(i7).getReply().add(0, replyBean);
            }
            this.n.notifyItemChanged(i6);
        } catch (Exception e2) {
            com.rtk.app.tool.c0.u("PostDetailsActivity", "异常" + e2.toString());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.m != null || view.getId() == 2131299800) {
            switch (view.getId()) {
                case R.id.post_details_back /* 2131299800 */:
                    finish();
                    return;
                case R.id.post_details_collect /* 2131299801 */:
                    if (com.rtk.app.tool.y.x(this.f148c)) {
                        I(3);
                        return;
                    }
                    com.rtk.app.tool.f.a(this.f148c, "请先登录", f.a.f);
                    com.rtk.app.tool.t.w0(this.f148c);
                    this.postDetailsCollect.setChecked(false);
                    return;
                case R.id.post_details_comment /* 2131299802 */:
                    if (!com.rtk.app.tool.y.x(this.f148c)) {
                        com.rtk.app.tool.f.a(this.f148c, "请先登录", f.a.f);
                        com.rtk.app.tool.t.w0(this.f148c);
                        return;
                    } else if (this.m.getData().getNocomment().equals("1")) {
                        com.rtk.app.tool.f.a(this.f148c, "本帖已关闭回复", f.a.f);
                        return;
                    } else if (this.G) {
                        com.rtk.app.tool.t.Q0(this.f148c, this.r, this.l, this.m.getData(), this.F);
                        return;
                    } else {
                        com.rtk.app.tool.t.P0(this.f148c, this.r, this.l, this.m.getData());
                        return;
                    }
                case R.id.post_details_pageNum /* 2131299805 */:
                    DialogPostPageTurning dialogPostPageTurning = new DialogPostPageTurning(this.f148c, Integer.parseInt(this.p.getCommentNum()));
                    this.v = dialogPostPageTurning;
                    dialogPostPageTurning.show();
                    return;
                case R.id.post_details_page_last /* 2131299806 */:
                    W(false);
                    com.rtk.app.tool.c0.u("PostDetailsActivity", "当前页面" + this.s);
                    int i = this.s - 1;
                    this.s = i;
                    X(i);
                    return;
                case R.id.post_details_page_next /* 2131299807 */:
                    W(false);
                    this.s++;
                    com.rtk.app.tool.c0.u("PostDetailsActivity", "当前页面" + this.s);
                    X(this.s);
                    return;
                case R.id.post_details_reward /* 2131299842 */:
                    if (com.rtk.app.tool.y.x(this.f148c)) {
                        AppCompatActivity appCompatActivity = this.f148c;
                        String uid = this.m.getData().getUid();
                        String str = this.l;
                        new DialogPostReward(appCompatActivity, uid, "rewardPosts", str, str).show();
                        return;
                    }
                    com.rtk.app.tool.f.a(this.f148c, "请先登录", f.a.f);
                    com.rtk.app.tool.t.w0(this.f148c);
                    return;
                case R.id.post_details_top_audit_btu /* 2131299846 */:
                    H(false).show();
                    return;
                case R.id.post_details_top_family_audit_btu /* 2131299849 */:
                    H(true).show();
                    return;
                case R.id.post_details_top_more /* 2131299850 */:
                    if (this.p != null) {
                        AppCompatActivity appCompatActivity2 = this.f148c;
                        PostDetailsBean.DataBean dataBean = this.p;
                        new DialogPostMore(appCompatActivity2, dataBean, this, dataBean.getFamily()).show();
                        return;
                    }
                    return;
                case R.id.post_details_up /* 2131299851 */:
                    if (com.rtk.app.tool.y.x(this.f148c)) {
                        I(2);
                        return;
                    }
                    com.rtk.app.tool.f.a(this.f148c, "请先登录", f.a.f);
                    com.rtk.app.tool.t.w0(this.f148c);
                    this.postDetailsUp.setChecked(false);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseForFullAPI26Activity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_post_details);
        ButterKnife.a(this);
        C(null, this.postDetailsLayout);
    }

    protected void onStop() {
        super.onStop();
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }

    @Override // com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsRecyclerViewAdapter.a
    public void p(boolean z) {
        String str;
        this.o = 1;
        this.w = z ? 1 : 0;
        PostDetailsBean.DataBean data = this.m.getData();
        if (z) {
            str = this.B + "";
        } else {
            str = this.C;
        }
        data.setCommentNum(str);
        I(4);
    }

    @Override // com.rtk.app.base.BaseForFullAPI26Activity
    protected void x() {
        com.rtk.app.tool.t.S1(this.f148c, this.postDetailsLayout, null, null, ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0));
    }
}
