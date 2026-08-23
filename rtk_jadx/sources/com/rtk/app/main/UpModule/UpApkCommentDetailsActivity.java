package com.rtk.app.main.UpModule;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.adapter.UpApkCommentDetailsAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.DuOrUpBean;
import com.rtk.app.bean.UpApkCommentDetailsBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.dialogPack.DialogForGameCommentDeleteReason;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import com.zhy.view.flowlayout.FlowLayout;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpApkCommentDetailsActivity extends BaseActivity implements h.j {
    private String A;
    private DialogForProgressTip C;

    @BindView
    AutoListView commentdetailsupApkCommentListView;
    private int q;
    private int r;
    private com.rtk.app.main.comment.express.c s;
    private View t;

    @BindView
    TextView upApkCommentDetailsBack;

    @BindView
    RelativeLayout upApkCommentDetailsTitleRl;
    private UpApkCommentDetailsBean w;
    private HeadHolder x;
    private List<UpApkCommentDetailsBean.DataBean.ReplyBean> y;
    private UpApkCommentDetailsAdapter z;
    private int u = 1;
    private String v = "time";
    private String B = "";

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class HeadHolder {

        @BindView
        TextView upCommentDetailsHeadviewCommentBtu;

        @BindView
        TextView upCommentDetailsHeadviewContent;

        @BindView
        TextView upCommentDetailsHeadviewDelete;

        @BindView
        CheckBox upCommentDetailsHeadviewDuTv;

        @BindView
        FlowLayout upCommentDetailsHeadviewFlowLayout;

        @BindView
        RoundedImageView upCommentDetailsHeadviewImg;

        @BindView
        LinearLayout upCommentDetailsHeadviewImgLv;

        @BindView
        ImageView upCommentDetailsHeadviewLvGameImg;

        @BindView
        TextView upCommentDetailsHeadviewLvGameName;

        @BindView
        LinearLayout upCommentDetailsHeadviewLvLayout;

        @BindView
        TextView upCommentDetailsHeadviewName;

        @BindView
        TextView upCommentDetailsHeadviewPhone;

        @BindView
        ImageView upCommentDetailsHeadviewStart;

        @BindView
        TextView upCommentDetailsHeadviewTime;

        @BindView
        TextView upCommentDetailsHeadviewUuTv;

        @BindView
        TextView upCommentDetailsIsUpMain;

        HeadHolder(View view) {
            ButterKnife.b(this, view);
            this.upCommentDetailsHeadviewUuTv.setVisibility(8);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class HeadHolder_ViewBinding implements Unbinder {
        private HeadHolder b;

        @UiThread
        public HeadHolder_ViewBinding(HeadHolder headHolder, View view) {
            this.b = headHolder;
            headHolder.upCommentDetailsHeadviewImgLv = (LinearLayout) butterknife.c.a.c(view, R.id.up_comment_details_headview_img_lv, "field 'upCommentDetailsHeadviewImgLv'", LinearLayout.class);
            headHolder.upCommentDetailsHeadviewImg = (RoundedImageView) butterknife.c.a.c(view, R.id.up_comment_details_headview_img, "field 'upCommentDetailsHeadviewImg'", RoundedImageView.class);
            headHolder.upCommentDetailsHeadviewName = (TextView) butterknife.c.a.c(view, R.id.up_comment_details_headview_name, "field 'upCommentDetailsHeadviewName'", TextView.class);
            headHolder.upCommentDetailsHeadviewFlowLayout = (FlowLayout) butterknife.c.a.c(view, R.id.up_comment_details_headview_flowLayout, "field 'upCommentDetailsHeadviewFlowLayout'", FlowLayout.class);
            headHolder.upCommentDetailsIsUpMain = (TextView) butterknife.c.a.c(view, R.id.up_comment_details_isUpMain, "field 'upCommentDetailsIsUpMain'", TextView.class);
            headHolder.upCommentDetailsHeadviewStart = (ImageView) butterknife.c.a.c(view, R.id.up_comment_details_headview_start, "field 'upCommentDetailsHeadviewStart'", ImageView.class);
            headHolder.upCommentDetailsHeadviewContent = (TextView) butterknife.c.a.c(view, R.id.up_comment_details_headview_content, "field 'upCommentDetailsHeadviewContent'", TextView.class);
            headHolder.upCommentDetailsHeadviewPhone = (TextView) butterknife.c.a.c(view, R.id.up_comment_details_headview_phone, "field 'upCommentDetailsHeadviewPhone'", TextView.class);
            headHolder.upCommentDetailsHeadviewDelete = (TextView) butterknife.c.a.c(view, R.id.up_comment_details_headview_delete, "field 'upCommentDetailsHeadviewDelete'", TextView.class);
            headHolder.upCommentDetailsHeadviewDuTv = (CheckBox) butterknife.c.a.c(view, R.id.up_comment_details_headview_du_tv, "field 'upCommentDetailsHeadviewDuTv'", CheckBox.class);
            headHolder.upCommentDetailsHeadviewUuTv = (TextView) butterknife.c.a.c(view, R.id.up_comment_details_headview_uu_tv, "field 'upCommentDetailsHeadviewUuTv'", TextView.class);
            headHolder.upCommentDetailsHeadviewCommentBtu = (TextView) butterknife.c.a.c(view, R.id.up_comment_details_headview_commentBtu, "field 'upCommentDetailsHeadviewCommentBtu'", TextView.class);
            headHolder.upCommentDetailsHeadviewTime = (TextView) butterknife.c.a.c(view, R.id.up_comment_details_headview_time, "field 'upCommentDetailsHeadviewTime'", TextView.class);
            headHolder.upCommentDetailsHeadviewLvGameImg = (ImageView) butterknife.c.a.c(view, R.id.up_comment_details_headview_lv_game_img, "field 'upCommentDetailsHeadviewLvGameImg'", ImageView.class);
            headHolder.upCommentDetailsHeadviewLvGameName = (TextView) butterknife.c.a.c(view, R.id.up_comment_details_headview_lv_game_name, "field 'upCommentDetailsHeadviewLvGameName'", TextView.class);
            headHolder.upCommentDetailsHeadviewLvLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_comment_details_headview_lv_layout, "field 'upCommentDetailsHeadviewLvLayout'", LinearLayout.class);
        }

        @CallSuper
        public void a() {
            HeadHolder headHolder = this.b;
            if (headHolder != null) {
                this.b = null;
                headHolder.upCommentDetailsHeadviewImgLv = null;
                headHolder.upCommentDetailsHeadviewImg = null;
                headHolder.upCommentDetailsHeadviewName = null;
                headHolder.upCommentDetailsHeadviewFlowLayout = null;
                headHolder.upCommentDetailsIsUpMain = null;
                headHolder.upCommentDetailsHeadviewStart = null;
                headHolder.upCommentDetailsHeadviewContent = null;
                headHolder.upCommentDetailsHeadviewPhone = null;
                headHolder.upCommentDetailsHeadviewDelete = null;
                headHolder.upCommentDetailsHeadviewDuTv = null;
                headHolder.upCommentDetailsHeadviewUuTv = null;
                headHolder.upCommentDetailsHeadviewCommentBtu = null;
                headHolder.upCommentDetailsHeadviewTime = null;
                headHolder.upCommentDetailsHeadviewLvGameImg = null;
                headHolder.upCommentDetailsHeadviewLvGameName = null;
                headHolder.upCommentDetailsHeadviewLvLayout = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements com.rtk.app.tool.s {
        a() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            UpApkCommentDetailsActivity.this.B = strArr[0];
            UpApkCommentDetailsActivity.this.P(4);
            UpApkCommentDetailsActivity.this.C = new DialogForProgressTip(UpApkCommentDetailsActivity.this.f147c, "删除中，请稍后...");
            UpApkCommentDetailsActivity.this.C.show();
        }
    }

    private void O(FlowLayout flowLayout, final List<String> list) {
        flowLayout.removeAllViews();
        if (list == null || list.size() < 0) {
            return;
        }
        for (final int i = 0; i < list.size(); i++) {
            View inflate = LayoutInflater.from(this.f147c).inflate(R.layout.just_image_view_layout, (ViewGroup) flowLayout, false);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.just_imageView);
            flowLayout.addView(inflate);
            com.rtk.app.tool.t.c(this.f147c, list.get(i), imageView, new boolean[0]);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.main.UpModule.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UpApkCommentDetailsActivity.this.S(list, i, view);
                }
            });
        }
    }

    private void Q(UpApkCommentDetailsBean upApkCommentDetailsBean) {
        UpApkCommentDetailsBean.DataBean data = upApkCommentDetailsBean.getData();
        this.x.upCommentDetailsHeadviewContent.setText(this.s.a(data.getContent()));
        com.rtk.app.tool.t.d(this.f147c, data.getU_face(), this.x.upCommentDetailsHeadviewImg);
        O(this.x.upCommentDetailsHeadviewFlowLayout, data.getPic());
        this.x.upCommentDetailsHeadviewImgLv.setOnClickListener(this);
        this.x.upCommentDetailsHeadviewName.setText(data.getU_name());
        this.x.upCommentDetailsHeadviewTime.setText(data.getTime());
        this.x.upCommentDetailsHeadviewDuTv.setText(data.getDu() + "");
        this.x.upCommentDetailsHeadviewUuTv.setText(data.getUu() + "");
        this.x.upCommentDetailsHeadviewPhone.setText(data.getClient());
        this.x.upCommentDetailsHeadviewDuTv.setChecked(data.getIsdu() == 1);
        com.rtk.app.tool.t.c(this.f147c, data.getSourceInfo().getSourceLogo(), this.x.upCommentDetailsHeadviewLvGameImg, new boolean[0]);
        this.x.upCommentDetailsHeadviewLvGameName.setText(data.getSourceInfo().getSourceName());
        this.x.upCommentDetailsHeadviewLvLayout.setOnClickListener(this);
        this.x.upCommentDetailsHeadviewDuTv.setOnClickListener(this);
        this.x.upCommentDetailsHeadviewUuTv.setOnClickListener(this);
        this.x.upCommentDetailsHeadviewCommentBtu.setOnClickListener(this);
        com.rtk.app.tool.t.Q1(data.getStar(), this.x.upCommentDetailsHeadviewStart);
        this.x.upCommentDetailsIsUpMain.setVisibility(upApkCommentDetailsBean.getData().getSourceInfo().getUid() != data.getUid() ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S(List list, int i, View view) {
        com.rtk.app.tool.t.C0(this.f147c, list, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U(String[] strArr) {
        P(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W() {
        P(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y() {
        this.u = 1;
        P(1);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.upApkCommentDetailsTitleRl, null, null, ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0));
    }

    public void P(int... iArr) {
        String sb;
        int i = iArr[0];
        if (i == 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/sourceCommentByPid");
            sb2.append(com.rtk.app.tool.y.u(this.f147c));
            sb2.append("&sid=");
            sb2.append(this.q);
            sb2.append("&reply_id=");
            sb2.append(this.r);
            sb2.append("&page=");
            sb2.append(this.u);
            sb2.append("&limit=10&uid=");
            sb2.append(com.rtk.app.tool.y.K());
            sb2.append("&sort=");
            sb2.append(this.v);
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "sid=" + this.q, "reply_id=" + this.r))));
            sb = sb2.toString();
        } else if (i == 2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("members/sourceCommentLikes");
            sb3.append(com.rtk.app.tool.y.u(this.f147c));
            sb3.append("&uid=");
            sb3.append(com.rtk.app.tool.y.K());
            sb3.append("&token=");
            sb3.append(com.rtk.app.tool.y.H());
            sb3.append("&cmtid=");
            sb3.append(this.r);
            sb3.append("&op=du&key=");
            sb3.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "cmtid=" + this.r, "op=du", "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
            sb = sb3.toString();
        } else if (i == 3) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("members/sourceCommentLikes");
            sb4.append(com.rtk.app.tool.y.u(this.f147c));
            sb4.append("&uid=");
            sb4.append(com.rtk.app.tool.y.K());
            sb4.append("&token=");
            sb4.append(com.rtk.app.tool.y.H());
            sb4.append("&cmtid=");
            sb4.append(this.r);
            sb4.append("&op=uu&key=");
            sb4.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "cmtid=" + this.r, "op=uu", "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
            sb = sb4.toString();
        } else {
            if (i == 4) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("up/comment/delete");
                sb5.append(com.rtk.app.tool.y.u(this.f147c));
                sb5.append("&uid=");
                sb5.append(com.rtk.app.tool.y.K());
                sb5.append("&token=");
                sb5.append(com.rtk.app.tool.y.H());
                sb5.append("&cid=");
                sb5.append(this.r);
                sb5.append("&table=up&msg=");
                sb5.append(this.B);
                sb5.append("&key=");
                sb5.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "cid=" + this.r, "table=up", "msg=" + this.B, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
                com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb5.toString()));
                return;
            }
            sb = "";
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(sb));
        com.rtk.app.tool.c0.u("UpApkCommentDetailsActivity", "评论详情页面   " + com.rtk.app.tool.y.d + sb);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        F();
        this.commentdetailsupApkCommentListView.k();
        if (i == 1) {
            com.rtk.app.tool.c0.u("UpApkCommentDetailsActivity", "  评论详情   " + str);
            UpApkCommentDetailsBean upApkCommentDetailsBean = (UpApkCommentDetailsBean) this.g.fromJson(str, UpApkCommentDetailsBean.class);
            this.w = upApkCommentDetailsBean;
            if (this.u == 1) {
                Q(upApkCommentDetailsBean);
                this.y.clear();
            }
            this.u++;
            this.y.addAll(this.w.getData().getReply());
            this.commentdetailsupApkCommentListView.setResultSize(this.w.getData().getReply().size());
            int uid = this.w.getData().getSourceInfo().getUid();
            if (Integer.parseInt(com.rtk.app.tool.y.K()) != 0 && MainActivity.p.getData().getUid() == uid) {
                this.x.upCommentDetailsHeadviewDelete.setVisibility(0);
            }
            this.z.i(uid);
            this.z.notifyDataSetChanged();
            return;
        }
        if (i == 2) {
            com.rtk.app.tool.c0.u("UpApkCommentDetailsActivity", "顶  " + str);
            DuOrUpBean duOrUpBean = (DuOrUpBean) this.g.fromJson(str, DuOrUpBean.class);
            this.x.upCommentDetailsHeadviewDuTv.setText(duOrUpBean.getData().getDu() + "");
            this.x.upCommentDetailsHeadviewUuTv.setText(duOrUpBean.getData().getUu() + "");
            return;
        }
        if (i != 3) {
            if (i != 4) {
                return;
            }
            DialogForProgressTip dialogForProgressTip = this.C;
            if (dialogForProgressTip != null) {
                dialogForProgressTip.dismiss();
            }
            finish();
            com.rtk.app.tool.f.a(this.f147c, "删除成功", f.a.f);
            return;
        }
        com.rtk.app.tool.c0.u("UpApkCommentDetailsActivity", "踩  " + str);
        DuOrUpBean duOrUpBean2 = (DuOrUpBean) this.g.fromJson(str, DuOrUpBean.class);
        this.x.upCommentDetailsHeadviewDuTv.setText(duOrUpBean2.getData().getDu() + "");
        this.x.upCommentDetailsHeadviewUuTv.setText(duOrUpBean2.getData().getUu() + "");
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        DialogForProgressTip dialogForProgressTip;
        if (i2 == 1) {
            if (this.u == 1) {
                I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.UpModule.d
                    @Override // com.rtk.app.tool.s
                    public final void a(String[] strArr) {
                        UpApkCommentDetailsActivity.this.U(strArr);
                    }
                });
            }
            this.commentdetailsupApkCommentListView.f();
        } else if (i2 == 4 && (dialogForProgressTip = this.C) != null) {
            dialogForProgressTip.dismiss();
        }
        com.rtk.app.tool.c0.u("UpApkCommentDetailsActivity", "  评论详情失败   " + str);
        com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        this.s = com.rtk.app.main.comment.express.c.g();
        Bundle extras = getIntent().getExtras();
        this.q = extras.getInt("upGameId");
        this.r = extras.getInt("root_reply_id");
        this.A = extras.getString("packageName");
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.commentdetailsupApkCommentListView.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.UpModule.g
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                UpApkCommentDetailsActivity.this.W();
            }
        });
        this.commentdetailsupApkCommentListView.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.UpModule.e
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                UpApkCommentDetailsActivity.this.Y();
            }
        });
        this.x.upCommentDetailsHeadviewDelete.setOnClickListener(this);
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        View inflate = LayoutInflater.from(this.f147c).inflate(R.layout.up_comment_details_headview_layout, (ViewGroup) null);
        this.t = inflate;
        this.x = new HeadHolder(inflate);
        this.commentdetailsupApkCommentListView.addHeaderView(this.t);
        this.y = new ArrayList();
        this.x.upCommentDetailsHeadviewDelete.setVisibility((c.d.a.d.d() && (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getCommentadmin() == 1)) ? 0 : 8);
        UpApkCommentDetailsAdapter upApkCommentDetailsAdapter = new UpApkCommentDetailsAdapter(this.f147c, this.y, this.q, this.A);
        this.z = upApkCommentDetailsAdapter;
        this.commentdetailsupApkCommentListView.setAdapter((ListAdapter) upApkCommentDetailsAdapter);
        P(1);
        G(null, this.upApkCommentDetailsTitleRl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.rtk.app.tool.c0.u("UpApkCommentDetailsActivity", "resultCode  " + i2 + "  requestCode " + i);
        if (i == 1022 && i2 != -1 && i2 == 1) {
            this.u = 1;
            P(1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.up_apk_comment_details_back /* 2131300592 */:
                finish();
                return;
            case R.id.up_comment_details_headview_commentBtu /* 2131300827 */:
                if (!com.rtk.app.tool.y.x(this.f147c)) {
                    com.rtk.app.tool.t.w0(this.f147c);
                    return;
                }
                AppCompatActivity appCompatActivity = this.f147c;
                int i = this.q;
                int i2 = this.r;
                com.rtk.app.tool.t.l0(appCompatActivity, 0, i, i2, i2, "0", this.A, "upApk", this.w.getData().getUid() + "");
                return;
            case R.id.up_comment_details_headview_delete /* 2131300829 */:
                new DialogForGameCommentDeleteReason(this.f147c, new a()).show();
                return;
            case R.id.up_comment_details_headview_du_tv /* 2131300830 */:
                if (!com.rtk.app.tool.y.x(this.f147c)) {
                    com.rtk.app.tool.t.w0(this.f147c);
                    return;
                } else {
                    if (this.w != null) {
                        P(2);
                        return;
                    }
                    return;
                }
            case R.id.up_comment_details_headview_img_lv /* 2131300833 */:
                com.rtk.app.tool.t.B0(this.f147c, this.w.getData().getUid() + "");
                return;
            case R.id.up_comment_details_headview_lv_layout /* 2131300836 */:
                com.rtk.app.tool.t.X0(this.f147c, new ApkInfo(this.w.getData().getSourceInfo()));
                return;
            case R.id.up_comment_details_headview_uu_tv /* 2131300841 */:
                if (!com.rtk.app.tool.y.x(this.f147c)) {
                    com.rtk.app.tool.t.w0(this.f147c);
                    return;
                } else {
                    if (this.w != null) {
                        P(3);
                        return;
                    }
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_up_apk_comment_details);
        ButterKnife.a(this);
    }
}
