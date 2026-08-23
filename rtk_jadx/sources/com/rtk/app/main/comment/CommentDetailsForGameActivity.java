package com.rtk.app.main.comment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.adapter.GameCommentDetailsAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.CommentDetailsBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.dialogPack.DialogForGameCommentDeleteReason;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import com.zhy.view.flowlayout.FlowLayout;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CommentDetailsForGameActivity extends BaseActivity implements h.j {
    private CommentDetailsBean.DataBean B;
    private String D;
    private String E;
    private CommentDetailsBean F;
    private DialogForProgressTip H;

    @BindView
    RelativeLayout activityCommentDetailsTitleRl;

    @BindView
    AutoListView commentdetailsActivityCommentListView;
    private int r;
    private int s;
    private Context t;
    private View u;
    private HeadHolder v;
    private List<CommentDetailsBean.DataBean.ReplyBean> w;
    private GameCommentDetailsAdapter x;
    private com.rtk.app.main.comment.express.c y;
    private int z;
    private int q = 1;
    private String A = "add";
    private List<Integer> C = new ArrayList();
    private String G = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class HeadHolder {

        @BindView
        TextView commentDetailsHeadviewCommentBtu;

        @BindView
        TextView commentDetailsHeadviewContent;

        @BindView
        TextView commentDetailsHeadviewDelete;

        @BindView
        TextView commentDetailsHeadviewDuTv;

        @BindView
        FlowLayout commentDetailsHeadviewForGameFlowLayout;

        @BindView
        ImageView commentDetailsHeadviewForGameLvGameImg;

        @BindView
        TextView commentDetailsHeadviewForGameLvGameName;

        @BindView
        LinearLayout commentDetailsHeadviewForGameLvLayout;

        @BindView
        ImageView commentDetailsHeadviewImg;

        @BindView
        TextView commentDetailsHeadviewName;

        @BindView
        TextView commentDetailsHeadviewPhone;

        @BindView
        ImageView commentDetailsHeadviewStart;

        @BindView
        TextView commentDetailsHeadviewTime;

        @BindView
        TextView commentDetailsHeadviewUuTv;

        HeadHolder(CommentDetailsForGameActivity commentDetailsForGameActivity, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class HeadHolder_ViewBinding implements Unbinder {
        private HeadHolder b;

        @UiThread
        public HeadHolder_ViewBinding(HeadHolder headHolder, View view) {
            this.b = headHolder;
            headHolder.commentDetailsHeadviewImg = (ImageView) butterknife.c.a.c(view, R.id.comment_details_headview_for_game_img, "field 'commentDetailsHeadviewImg'", ImageView.class);
            headHolder.commentDetailsHeadviewName = (TextView) butterknife.c.a.c(view, R.id.comment_details_headview_for_game_name, "field 'commentDetailsHeadviewName'", TextView.class);
            headHolder.commentDetailsHeadviewStart = (ImageView) butterknife.c.a.c(view, R.id.comment_details_headview_for_game_start, "field 'commentDetailsHeadviewStart'", ImageView.class);
            headHolder.commentDetailsHeadviewContent = (TextView) butterknife.c.a.c(view, R.id.comment_details_headview_for_game_content, "field 'commentDetailsHeadviewContent'", TextView.class);
            headHolder.commentDetailsHeadviewTime = (TextView) butterknife.c.a.c(view, R.id.comment_details_headview_for_game_time, "field 'commentDetailsHeadviewTime'", TextView.class);
            headHolder.commentDetailsHeadviewDuTv = (TextView) butterknife.c.a.c(view, R.id.comment_details_headview_for_game_du_tv, "field 'commentDetailsHeadviewDuTv'", TextView.class);
            headHolder.commentDetailsHeadviewUuTv = (TextView) butterknife.c.a.c(view, R.id.comment_details_headview_for_game_uu_tv, "field 'commentDetailsHeadviewUuTv'", TextView.class);
            headHolder.commentDetailsHeadviewCommentBtu = (TextView) butterknife.c.a.c(view, R.id.comment_details_headview_for_game_commentBtu, "field 'commentDetailsHeadviewCommentBtu'", TextView.class);
            headHolder.commentDetailsHeadviewPhone = (TextView) butterknife.c.a.c(view, R.id.comment_details_headview_for_game_phone, "field 'commentDetailsHeadviewPhone'", TextView.class);
            headHolder.commentDetailsHeadviewDelete = (TextView) butterknife.c.a.c(view, R.id.comment_details_headview_for_game_delete, "field 'commentDetailsHeadviewDelete'", TextView.class);
            headHolder.commentDetailsHeadviewForGameLvGameImg = (ImageView) butterknife.c.a.c(view, R.id.comment_details_headview_for_game_lv_game_img, "field 'commentDetailsHeadviewForGameLvGameImg'", ImageView.class);
            headHolder.commentDetailsHeadviewForGameLvGameName = (TextView) butterknife.c.a.c(view, R.id.comment_details_headview_for_game_lv_game_name, "field 'commentDetailsHeadviewForGameLvGameName'", TextView.class);
            headHolder.commentDetailsHeadviewForGameFlowLayout = (FlowLayout) butterknife.c.a.c(view, R.id.comment_details_headview_for_game_flowLayout, "field 'commentDetailsHeadviewForGameFlowLayout'", FlowLayout.class);
            headHolder.commentDetailsHeadviewForGameLvLayout = (LinearLayout) butterknife.c.a.c(view, R.id.comment_details_headview_for_game_lv_layout, "field 'commentDetailsHeadviewForGameLvLayout'", LinearLayout.class);
        }

        @CallSuper
        public void a() {
            HeadHolder headHolder = this.b;
            if (headHolder != null) {
                this.b = null;
                headHolder.commentDetailsHeadviewImg = null;
                headHolder.commentDetailsHeadviewName = null;
                headHolder.commentDetailsHeadviewStart = null;
                headHolder.commentDetailsHeadviewContent = null;
                headHolder.commentDetailsHeadviewTime = null;
                headHolder.commentDetailsHeadviewDuTv = null;
                headHolder.commentDetailsHeadviewUuTv = null;
                headHolder.commentDetailsHeadviewCommentBtu = null;
                headHolder.commentDetailsHeadviewPhone = null;
                headHolder.commentDetailsHeadviewDelete = null;
                headHolder.commentDetailsHeadviewForGameLvGameImg = null;
                headHolder.commentDetailsHeadviewForGameLvGameName = null;
                headHolder.commentDetailsHeadviewForGameFlowLayout = null;
                headHolder.commentDetailsHeadviewForGameLvLayout = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    private void L(FlowLayout flowLayout, final List<String> list) {
        flowLayout.removeAllViews();
        if (list == null || list.size() < 0) {
            return;
        }
        for (final int i = 0; i < list.size(); i++) {
            View inflate = LayoutInflater.from(this.f147c).inflate(R.layout.just_image_view_layout, (ViewGroup) flowLayout, false);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.just_imageView);
            flowLayout.addView(inflate);
            t.c(this.f147c, list.get(i), imageView, new boolean[0]);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.main.comment.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentDetailsForGameActivity.this.P(list, i, view);
                }
            });
        }
    }

    private void N(CommentDetailsBean commentDetailsBean) {
        CommentDetailsBean.DataBean dataBean = commentDetailsBean.getData().get(0);
        this.B = dataBean;
        this.v.commentDetailsHeadviewContent.setText(this.y.a(dataBean.getContent()));
        t.d(this.t, this.B.getU_face(), this.v.commentDetailsHeadviewImg);
        this.v.commentDetailsHeadviewName.setText(this.B.getU_name());
        this.v.commentDetailsHeadviewTime.setText(c0.f(this.B.getTime()));
        this.v.commentDetailsHeadviewDuTv.setText(this.B.getDu() + "");
        this.v.commentDetailsHeadviewUuTv.setText(this.B.getUu() + "");
        this.v.commentDetailsHeadviewPhone.setText(this.B.getPhone_model());
        t.c(this.t, this.B.getGameInfo().getGame_logo(), this.v.commentDetailsHeadviewForGameLvGameImg, new boolean[0]);
        this.v.commentDetailsHeadviewForGameLvGameName.setText(this.B.getGameInfo().getGame_name());
        this.v.commentDetailsHeadviewForGameLvLayout.setOnClickListener(this);
        this.v.commentDetailsHeadviewDelete.setOnClickListener(this);
        this.v.commentDetailsHeadviewDuTv.setOnClickListener(this);
        this.v.commentDetailsHeadviewUuTv.setOnClickListener(this);
        this.v.commentDetailsHeadviewCommentBtu.setOnClickListener(this);
        this.z = this.B.getCmtid();
        int star = this.B.getStar();
        if (star == 1) {
            this.v.commentDetailsHeadviewStart.setBackgroundResource(R.mipmap.star_1);
        } else if (star == 2) {
            this.v.commentDetailsHeadviewStart.setBackgroundResource(R.mipmap.star_4);
        } else if (star == 3) {
            this.v.commentDetailsHeadviewStart.setBackgroundResource(R.mipmap.star_6);
        } else if (star == 4) {
            this.v.commentDetailsHeadviewStart.setBackgroundResource(R.mipmap.star_8);
        } else if (star != 5) {
            this.v.commentDetailsHeadviewStart.setBackgroundResource(R.mipmap.star_10);
        } else {
            this.v.commentDetailsHeadviewStart.setBackgroundResource(R.mipmap.star_10);
        }
        L(this.v.commentDetailsHeadviewForGameFlowLayout, this.B.getPic());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(List list, int i, View view) {
        t.C0(this.f147c, list, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R(String[] strArr) {
        M(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T() {
        this.q = 1;
        M(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V() {
        M(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X(String[] strArr) {
        this.G = strArr[0];
        M(4);
        DialogForProgressTip dialogForProgressTip = new DialogForProgressTip(this.t, "删除中，请稍后...");
        this.H = dialogForProgressTip;
        dialogForProgressTip.show();
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        t.S1(this.t, this.activityCommentDetailsTitleRl, null, null, ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0));
    }

    public void M(int... iArr) {
        String sb;
        int i = iArr[0];
        if (i == 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("game/game_all_comment_list");
            sb2.append(y.u(this.t));
            sb2.append("&game_id=");
            sb2.append(this.r);
            sb2.append("&reply_id=");
            sb2.append(this.s);
            sb2.append("&page=");
            sb2.append(this.q);
            sb2.append("&key=");
            sb2.append(t.c0(c0.e(y.v(this.t, "game_id=" + this.r, "reply_id=" + this.s))));
            sb = sb2.toString();
        } else if (i == 2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("game/gameCommentOp");
            sb3.append(y.u(this.t));
            sb3.append("&cmtid=");
            sb3.append(this.z);
            sb3.append("&op=du&type=");
            sb3.append(this.A);
            sb3.append("&key=");
            sb3.append(t.c0(c0.e(y.v(this.t, "cmtid=" + this.z, "op=du", "type=" + this.A))));
            sb = sb3.toString();
        } else if (i == 3) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("game/gameCommentOp");
            sb4.append(y.u(this.t));
            sb4.append("&cmtid=");
            sb4.append(this.z);
            sb4.append("&op=uu&type=");
            sb4.append(this.A);
            sb4.append("&key=");
            sb4.append(t.c0(c0.e(y.v(this.t, "cmtid=" + this.z, "op=uu", "type=" + this.A))));
            sb = sb4.toString();
        } else {
            if (i == 4) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("up/comment/delete");
                sb5.append(y.u(this.t));
                sb5.append("&uid=");
                sb5.append(y.K());
                sb5.append("&token=");
                sb5.append(y.H());
                sb5.append("&cid=");
                sb5.append(this.z);
                sb5.append("&table=game&msg=");
                sb5.append(this.G);
                sb5.append("&key=");
                sb5.append(t.c0(c0.e(y.v(this.t, "cid=" + this.z, "table=game", "msg=" + this.G, "uid=" + y.K(), "token=" + y.H()))));
                h.l(this.t, this, iArr[0], h.h(y.e).a(sb5.toString()));
                return;
            }
            sb = "";
        }
        h.l(this.t, this, iArr[0], h.h(new String[0]).a(sb));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        F();
        this.commentdetailsActivityCommentListView.k();
        c0.u("CommentDetailsForGameActivity", "评论详情列表" + str);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        this.g = create;
        if (i != 1) {
            if (i != 4) {
                return;
            }
            DialogForProgressTip dialogForProgressTip = this.H;
            if (dialogForProgressTip != null) {
                dialogForProgressTip.dismiss();
            }
            finish();
            com.rtk.app.tool.f.a(this.t, "删除成功", f.a.f);
            return;
        }
        CommentDetailsBean commentDetailsBean = (CommentDetailsBean) create.fromJson(str, CommentDetailsBean.class);
        this.F = commentDetailsBean;
        if (commentDetailsBean.getCode() == 0 && this.F.getData() != null && this.F.getData().size() > 0) {
            if (this.q == 1) {
                N(this.F);
                this.w.clear();
            }
            this.q++;
            List<CommentDetailsBean.DataBean.ReplyBean> reply = this.F.getData().get(0).getReply();
            this.w.addAll(reply);
            this.x.notifyDataSetChanged();
            this.commentdetailsActivityCommentListView.setResultSize(reply.size());
            return;
        }
        com.rtk.app.tool.f.a(this.t, "该评论不存在", f.a.f);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        DialogForProgressTip dialogForProgressTip;
        com.rtk.app.tool.f.a(this.t, str, f.a.f);
        if (i2 == 1) {
            if (this.q == 1) {
                I(str, new s() { // from class: com.rtk.app.main.comment.a
                    @Override // com.rtk.app.tool.s
                    public final void a(String[] strArr) {
                        CommentDetailsForGameActivity.this.R(strArr);
                    }
                });
            }
            this.commentdetailsActivityCommentListView.f();
        } else if (i2 == 4 && (dialogForProgressTip = this.H) != null) {
            dialogForProgressTip.dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        this.y = com.rtk.app.main.comment.express.c.g();
        Bundle extras = getIntent().getExtras();
        this.r = extras.getInt("game_id");
        this.s = extras.getInt("reply_id");
        this.D = extras.getString("install_comment");
        this.E = extras.getString("packageName");
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.v.commentDetailsHeadviewImg.setOnClickListener(this);
        this.commentdetailsActivityCommentListView.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.comment.e
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                CommentDetailsForGameActivity.this.T();
            }
        });
        this.commentdetailsActivityCommentListView.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.comment.c
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                CommentDetailsForGameActivity.this.V();
            }
        });
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        View inflate = LayoutInflater.from(this.t).inflate(R.layout.comment_details_headview_for_game_layout, (ViewGroup) null);
        this.u = inflate;
        this.v = new HeadHolder(this, inflate);
        this.commentdetailsActivityCommentListView.addHeaderView(this.u);
        this.w = new ArrayList();
        GameCommentDetailsAdapter gameCommentDetailsAdapter = new GameCommentDetailsAdapter(this.t, this.w, this.r, this.D, this.E);
        this.x = gameCommentDetailsAdapter;
        this.commentdetailsActivityCommentListView.setAdapter((ListAdapter) gameCommentDetailsAdapter);
        G(null, this.activityCommentDetailsTitleRl);
        this.v.commentDetailsHeadviewDelete.setVisibility((c.d.a.d.d() && (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getCommentadmin() == 1)) ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 316) {
            return;
        }
        this.q = 1;
        M(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            switch (view.getId()) {
                case R.id.activity_comment_details_back /* 2131296382 */:
                    com.rtk.app.tool.c.a((Activity) this.t);
                    return;
                case R.id.comment_details_headview_for_game_commentBtu /* 2131296961 */:
                    t.l0(this.t, 0, this.r, this.z, this.s, this.D, this.E, new String[0]);
                    return;
                case R.id.comment_details_headview_for_game_delete /* 2131296963 */:
                    new DialogForGameCommentDeleteReason(this.t, new s() { // from class: com.rtk.app.main.comment.b
                        @Override // com.rtk.app.tool.s
                        public final void a(String[] strArr) {
                            CommentDetailsForGameActivity.this.X(strArr);
                        }
                    }).show();
                    return;
                case R.id.comment_details_headview_for_game_du_tv /* 2131296964 */:
                    List<Integer> J = t.J(this.t, this.r);
                    this.C = J;
                    if (J.contains(Integer.valueOf(this.B.getCmtid()))) {
                        com.rtk.app.tool.f.a(this.t, "不可重复操作", f.a.f);
                        return;
                    }
                    t.a(this.t, this.r, this.B.getCmtid());
                    this.v.commentDetailsHeadviewDuTv.setText((this.B.getDu() + 1) + "");
                    M(2);
                    return;
                case R.id.comment_details_headview_for_game_img /* 2131296966 */:
                    t.B0(this.t, this.F.getData().get(0).getUid() + "");
                    return;
                case R.id.comment_details_headview_for_game_lv_layout /* 2131296969 */:
                    t.e0(this.t, new ApkInfo(this.B.getGameInfo().getGame_id(), this.B.getGameInfo().getGame_name(), this.B.getGameInfo().getPackage_name(), this.B.getGameInfo().getGame_logo(), this.B.getGameInfo().getPackage_size(), this.B.getGameInfo().getSignaturesMD5(), this.B.getGameInfo().getIs_apk(), this.B.getGameInfo().getVersion_code(), this.B.getGameInfo().getDownlist()));
                    return;
                case R.id.comment_details_headview_for_game_uu_tv /* 2131296974 */:
                    List<Integer> J2 = t.J(this.t, this.r);
                    this.C = J2;
                    if (J2.contains(Integer.valueOf(this.B.getCmtid()))) {
                        com.rtk.app.tool.f.a(this.t, "不可重复操作", f.a.f);
                        return;
                    }
                    t.a(this.t, this.r, this.B.getCmtid());
                    this.v.commentDetailsHeadviewUuTv.setText((this.B.getUu() + 1) + "");
                    M(3);
                    return;
                default:
                    return;
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_comment_details);
        ButterKnife.a(this);
        this.t = this;
        this.C = t.J(this, this.r);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        this.q = 1;
        M(1);
    }
}
