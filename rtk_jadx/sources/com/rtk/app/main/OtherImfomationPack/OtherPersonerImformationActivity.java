package com.rtk.app.main.OtherImfomationPack;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.FamilyListBean;
import com.rtk.app.bean.ListHisUserBean;
import com.rtk.app.bean.OtherImformationBean;
import com.rtk.app.bean.ResponseDataBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.custom.MyHorizontalScrollView;
import com.rtk.app.custom.RecyclerImageView;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.OtherImfomationPack.DialogForProhibitUser;
import com.rtk.app.main.dialogPack.DialogEditTipEnsure;
import com.rtk.app.main.dialogPack.DialogForAttention;
import com.rtk.app.main.dialogPack.DialogForAuditCheckReason;
import com.rtk.app.main.dialogPack.DialogForEditOtherPersonal;
import com.rtk.app.main.dialogPack.DialogForEnSure;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.main.dialogPack.DialogOtherInfoMore;
import com.rtk.app.main.family.FamilyListActivity;
import com.rtk.app.msgBean.EventMessage;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.j;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class OtherPersonerImformationActivity extends BaseActivity implements h.j, DialogForEditOtherPersonal.c, com.rtk.app.tool.j {
    private DialogForProgressTip D;
    private com.rtk.app.tool.b0.a E;
    private String G;

    @BindView
    TextView otherPersonalInfoRtkUid;

    @BindView
    TextView otherPersonalInformationAttentionNum;

    @BindView
    TextView otherPersonalInformationComment;

    @BindView
    TextView otherPersonalInformationContributeNum;

    @BindView
    ImageView otherPersonalInformationEditNickName;

    @BindView
    TextView otherPersonalInformationExpert;

    @BindView
    TextView otherPersonalInformationFansNum;

    @BindView
    TextView otherPersonalInformationGoldNum;

    @BindView
    TextView otherPersonalInformationGrade;

    @BindView
    TextView otherPersonalInformationHisCollect;

    @BindView
    TextView otherPersonalInformationHisFamily;

    @BindView
    TextView otherPersonalInformationHisPost;

    @BindView
    TextView otherPersonalInformationHisReport;

    @BindView
    CustomTextView otherPersonalInformationHisUpSrc;

    @BindView
    RoundedImageView otherPersonalInformationIcon;

    @BindView
    TagFlowLayout otherPersonalInformationMedal;

    @BindView
    TextView otherPersonalInformationMedalTitle;

    @BindView
    TextView otherPersonalInformationMore;

    @BindView
    TextView otherPersonalInformationNickName;

    @BindView
    LinearLayout otherPersonalInformationPictureLv;

    @BindView
    MyHorizontalScrollView otherPersonalInformationPictureSV;

    @BindView
    TextView otherPersonalInformationPictureTitle;

    @BindView
    TextView otherPersonalInformationRemark;

    @BindView
    TextView otherPersonalInformationSexAge;

    @BindView
    TextView otherPersonalInformationShareUrl;

    @BindView
    TextView otherPersonalInformationSignature;

    @BindView
    TextView otherPersonalInformationTopBack;

    @BindView
    ImageView otherPersonalInformationTopEditSomeThing;

    @BindView
    RelativeLayout otherPersonalInformationTopLayout;

    @BindView
    CustomTextView otherPersonalInformationUserForbitReason;

    @BindView
    CustomTextView otherPersonalInformationUserForbitTime;

    @BindView
    TextView otherPersonalInformationUserStatus;
    private Bundle q;
    private String r;
    private OtherImformationBean s;
    private List<OtherImformationBean.DataBean.PhotoWallBean> t;
    private List<String> u;
    private DialogForProgressTip w;
    private DialogForEditOtherPersonal y;
    private int z;
    private int v = 1;
    private DialogForEnSure x = null;
    private String A = "";
    private String B = "";
    private String C = "";
    private List<String> F = new ArrayList();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[j.a.values().length];
            a = iArr;
            try {
                iArr[j.a.YES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[j.a.NO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements com.rtk.app.tool.s {
        b() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            OtherPersonerImformationActivity.this.R(2);
            OtherPersonerImformationActivity.this.D.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class c implements com.rtk.app.base.h {
        c() {
        }

        @Override // com.rtk.app.base.h
        public void a(String... strArr) {
        }

        @Override // com.rtk.app.base.h
        public void b(String... strArr) {
            if (strArr.length < 1) {
                c0.s("OtherPersonerImformationActivity", "未返回内容");
                com.rtk.app.tool.f.a(OtherPersonerImformationActivity.this.f147c, "请输入备注", 5000);
            } else {
                if (c0.q(strArr[0])) {
                    OtherPersonerImformationActivity.this.G = "";
                } else {
                    OtherPersonerImformationActivity.this.G = strArr[0];
                }
                OtherPersonerImformationActivity.this.R(10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class d implements View.OnClickListener {
        final /* synthetic */ int a;

        d(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OtherPersonerImformationActivity otherPersonerImformationActivity = OtherPersonerImformationActivity.this;
            com.rtk.app.tool.t.C0(otherPersonerImformationActivity.f147c, otherPersonerImformationActivity.u, this.a);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class e implements com.rtk.app.tool.s {
        e() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            OtherPersonerImformationActivity.this.R(1);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class f implements com.rtk.app.tool.s {
        f() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            OtherPersonerImformationActivity.this.R(3);
            OtherPersonerImformationActivity.this.w.show();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class g implements com.rtk.app.tool.s {
        g() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            OtherPersonerImformationActivity.this.w.show();
            OtherPersonerImformationActivity.this.R(8);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class h implements com.rtk.app.tool.s {
        h() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            OtherPersonerImformationActivity.this.w.show();
            OtherPersonerImformationActivity.this.R(9);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class i implements DialogForProhibitUser.a {
        i() {
        }

        @Override // com.rtk.app.main.OtherImfomationPack.DialogForProhibitUser.a
        public void a(int i, String str) {
            OtherPersonerImformationActivity.this.z = i;
            OtherPersonerImformationActivity.this.A = str;
            OtherPersonerImformationActivity.this.R(4);
            OtherPersonerImformationActivity.this.w.show();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class j implements com.rtk.app.tool.s {
        j() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            OtherPersonerImformationActivity.this.z = 0;
            OtherPersonerImformationActivity.this.A = "";
            OtherPersonerImformationActivity.this.R(4);
        }
    }

    private void S(OtherImformationBean otherImformationBean) {
        com.rtk.app.tool.g.h hVar = new com.rtk.app.tool.g.h();
        hVar.j(otherImformationBean.getData().getUid());
        hVar.h(otherImformationBean.getData());
        if (this.E != null) {
            com.rtk.app.tool.b0.b.b().c(this.E);
        }
        this.E = new com.rtk.app.tool.b0.a(otherImformationBean.getData().getUid(), otherImformationBean.getData().getFollowed(), this.otherPersonalInformationExpert, hVar);
        if (!otherImformationBean.getData().getFollowed().equals("1") && !otherImformationBean.getData().getFollowed().equals("2")) {
            this.otherPersonalInformationEditNickName.setVisibility(8);
        } else {
            this.otherPersonalInformationEditNickName.setVisibility(0);
        }
        com.rtk.app.tool.b0.b.b().a(this.E);
        com.rtk.app.tool.t.c(this.f147c, otherImformationBean.getData().getFace(), this.otherPersonalInformationIcon, new boolean[0]);
        this.otherPersonalInformationNickName.setText(otherImformationBean.getData().getNickname());
        if (!c0.q(otherImformationBean.getData().getNotename())) {
            this.otherPersonalInformationRemark.setVisibility(0);
            this.otherPersonalInformationRemark.setText("备注：" + otherImformationBean.getData().getNotename());
        } else {
            this.otherPersonalInformationRemark.setVisibility(8);
        }
        this.otherPersonalInformationSignature.setVisibility(c0.q(otherImformationBean.getData().getSignature()) ? 8 : 0);
        this.otherPersonalInformationSignature.setText(otherImformationBean.getData().getSignature());
        this.otherPersonalInformationContributeNum.setText(otherImformationBean.getData().getContribute());
        this.otherPersonalInformationGoldNum.setText(otherImformationBean.getData().getCoin());
        this.otherPersonalInformationAttentionNum.setText(otherImformationBean.getData().getFollows());
        this.otherPersonalInformationFansNum.setText(otherImformationBean.getData().getFans());
        this.otherPersonalInfoRtkUid.setText("软天空号:" + otherImformationBean.getData().getRtkUid());
        this.v = otherImformationBean.getData().getStatus();
        if (otherImformationBean.getData().getStatus() == 1) {
            this.otherPersonalInformationUserStatus.setTextColor(getResources().getColor(R.color.theme3));
            this.otherPersonalInformationUserStatus.setText("正常");
            this.otherPersonalInformationUserForbitTime.setVisibility(8);
            this.otherPersonalInformationUserForbitReason.setVisibility(8);
        } else {
            this.otherPersonalInformationUserStatus.setTextColor(getResources().getColor(R.color.theme20));
            this.otherPersonalInformationUserStatus.setText("已封号");
            if (c.d.a.d.d() && (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getUserAdmin() == 1 || MainActivity.p.getData().getAdmin().getUserAdmin() == 2)) {
                this.otherPersonalInformationUserForbitTime.setVisibility(0);
                this.otherPersonalInformationUserForbitReason.setVisibility(0);
                int parseInt = Integer.parseInt(otherImformationBean.getData().getClose_days());
                int parseInt2 = Integer.parseInt(otherImformationBean.getData().getClose_time());
                this.otherPersonalInformationUserForbitTime.setText(c0.f(parseInt2) + "至" + c0.f((parseInt * 24 * 60 * 60) + parseInt2));
                this.otherPersonalInformationUserForbitReason.setText(otherImformationBean.getData().getClose_reason());
            }
        }
        this.otherPersonalInformationHisPost.setText(otherImformationBean.getData().getPostsNum());
        int parseInt3 = Integer.parseInt(otherImformationBean.getData().getReplyNum()) + otherImformationBean.getData().getReplyMeNum();
        this.otherPersonalInformationHisReport.setText(parseInt3 + "");
        try {
            int parseInt4 = Integer.parseInt(otherImformationBean.getData().getPostCollectNum()) + otherImformationBean.getData().getGameNum() + Integer.parseInt(otherImformationBean.getData().getUpCollectNum());
            this.otherPersonalInformationHisCollect.setText(parseInt4 + "");
        } catch (Exception unused) {
        }
        this.otherPersonalInformationComment.setText(otherImformationBean.getData().getCommentNum());
        this.otherPersonalInformationHisUpSrc.setText(otherImformationBean.getData().getUpNum());
        this.otherPersonalInformationSexAge.setSelected(otherImformationBean.getData().getSex().endsWith("1"));
        this.otherPersonalInformationSexAge.setText(otherImformationBean.getData().getAge() + "");
        com.rtk.app.tool.t.T1(this.otherPersonalInformationGrade, "", otherImformationBean.getData().getUser_title(), 5, 5);
        this.F.clear();
        for (int i2 = 0; i2 < otherImformationBean.getData().getMedalList().getEventMedal().size(); i2++) {
            this.F.add(otherImformationBean.getData().getMedalList().getEventMedal().get(i2).getPic());
        }
        for (int i3 = 0; i3 < otherImformationBean.getData().getMedalList().getAchievement().size(); i3++) {
            this.F.add(otherImformationBean.getData().getMedalList().getAchievement().get(i3).getPic());
        }
        if (this.F.size() > 0) {
            this.otherPersonalInformationMedal.setAdapter(new PersonalMedalAdapter(this.f147c, this.F, otherImformationBean.getData().getMedalList().getEventMedal(), otherImformationBean.getData().getMedalList().getAchievement(), otherImformationBean.getData().getUid()));
            this.otherPersonalInformationMedalTitle.setVisibility(0);
        } else {
            this.otherPersonalInformationMedalTitle.setVisibility(8);
            this.otherPersonalInformationMedal.setVisibility(8);
        }
        if (otherImformationBean.getData().getPhotoWall().size() > 0) {
            this.t.clear();
            this.otherPersonalInformationPictureLv.removeAllViews();
            this.t.addAll(otherImformationBean.getData().getPhotoWall());
            d0();
            c0.u("OtherPersonerImformationActivity", "用户信息Image" + this.t.size());
        } else {
            this.otherPersonalInformationPictureTitle.setVisibility(8);
            this.otherPersonalInformationPictureSV.setVisibility(8);
        }
        this.otherPersonalInformationSexAge.setOnClickListener(this);
        this.otherPersonalInformationGrade.setOnClickListener(this);
        this.otherPersonalInformationContributeNum.setOnClickListener(this);
        this.otherPersonalInformationGoldNum.setOnClickListener(this);
        this.otherPersonalInformationAttentionNum.setOnClickListener(this);
        this.otherPersonalInformationFansNum.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U(String[] strArr) {
        this.B = strArr[0];
        DialogForEnSure dialogForEnSure = new DialogForEnSure(this.f147c, "确定删除TA全部的帖子吗？", new com.rtk.app.tool.s() { // from class: com.rtk.app.main.OtherImfomationPack.i
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr2) {
                OtherPersonerImformationActivity.this.Y(strArr2);
            }
        });
        this.x = dialogForEnSure;
        dialogForEnSure.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W(String[] strArr) {
        this.C = strArr[0];
        DialogForEnSure dialogForEnSure = new DialogForEnSure(this.f147c, "确定删除TA全部的帖子评论吗？", new com.rtk.app.tool.s() { // from class: com.rtk.app.main.OtherImfomationPack.k
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr2) {
                OtherPersonerImformationActivity.this.a0(strArr2);
            }
        });
        this.x = dialogForEnSure;
        dialogForEnSure.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y(String[] strArr) {
        this.w.show();
        R(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a0(String[] strArr) {
        this.w.show();
        R(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c0(String[] strArr) {
        e0();
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.otherPersonalInformationTopLayout, null, null, ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void R(int... iArr) {
        String str;
        String str2;
        String str3 = "";
        switch (iArr[0]) {
            case 1:
                str = "   ";
                str2 = "  其他用户界面接口  mark=";
                StringBuilder sb = new StringBuilder();
                sb.append("members/baseInfo");
                sb.append(y.u(this.f147c));
                sb.append("&uid=");
                sb.append(this.r);
                sb.append("&fans=");
                sb.append(y.K());
                sb.append("&key=");
                sb.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.f147c, "uid=" + this.r))));
                str3 = sb.toString();
                this.w.dismiss();
                DialogForEnSure dialogForEnSure = this.x;
                if (dialogForEnSure != null) {
                    dialogForEnSure.dismiss();
                    break;
                }
                break;
            case 2:
                str = "   ";
                str2 = "  其他用户界面接口  mark=";
                StringBuilder sb2 = new StringBuilder();
                sb2.append("members/follows");
                sb2.append(y.u(this.f147c));
                sb2.append("&uid=");
                sb2.append(y.K());
                sb2.append("&token=");
                sb2.append(y.H());
                sb2.append("&fans=");
                sb2.append(this.r);
                sb2.append("&key=");
                sb2.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.f147c, "fans=" + this.r, "uid=" + y.K(), "token=" + y.H()))));
                str3 = sb2.toString();
                break;
            case 3:
                StringBuilder sb3 = new StringBuilder();
                sb3.append("user/reset-face/index");
                sb3.append(y.u(this.f147c));
                sb3.append("&uid=");
                sb3.append(y.K());
                sb3.append("&token=");
                sb3.append(y.H());
                sb3.append("&touser=");
                sb3.append(this.r);
                sb3.append("&key=");
                sb3.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.f147c, "touser=" + this.r, "uid=" + y.K(), "token=" + y.H()))));
                String sb4 = sb3.toString();
                com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(y.e).a(sb4));
                StringBuilder sb5 = new StringBuilder();
                sb5.append("  其他用户界面接口  mark=");
                sb5.append(iArr[0]);
                sb5.append("   ");
                sb5.append(y.e);
                sb5.append(sb4);
                c0.u("OtherPersonerImformationActivity", sb5.toString());
                return;
            case 4:
                int i2 = (this.v + 1) % 2;
                StringBuilder sb6 = new StringBuilder();
                sb6.append("user/lock/index");
                sb6.append(y.u(this.f147c));
                sb6.append("&uid=");
                sb6.append(y.K());
                sb6.append("&token=");
                sb6.append(y.H());
                sb6.append("&touser=");
                sb6.append(this.r);
                sb6.append("&close_days=");
                sb6.append(this.z);
                sb6.append("&status=");
                sb6.append(i2);
                sb6.append("&close_reason=");
                sb6.append(this.A);
                sb6.append("&key=");
                sb6.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.f147c, "touser=" + this.r, "uid=" + y.K(), "token=" + y.H(), "close_days=" + this.z, "status=" + i2))));
                String sb7 = sb6.toString();
                com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(y.e).a(sb7));
                StringBuilder sb8 = new StringBuilder();
                sb8.append("  其他用户界面接口  mark=");
                sb8.append(iArr[0]);
                sb8.append("   ");
                sb8.append(y.e);
                sb8.append(sb7);
                c0.u("OtherPersonerImformationActivity", sb8.toString());
                return;
            case 5:
                for (int i3 = 0; i3 < this.s.getData().getPhotoWall().size(); i3++) {
                    str3 = i3 == this.s.getData().getPhotoWall().size() - 1 ? str3 + this.s.getData().getPhotoWall().get(i3).getId() : str3 + this.s.getData().getPhotoWall().get(i3).getId() + ",";
                }
                StringBuilder sb9 = new StringBuilder();
                sb9.append("user/photo/delete");
                sb9.append(y.u(this.f147c));
                sb9.append("&uid=");
                sb9.append(y.K());
                sb9.append("&token=");
                sb9.append(y.H());
                sb9.append("&touser=");
                sb9.append(this.r);
                sb9.append("&ids=");
                sb9.append(str3);
                sb9.append("&key=");
                sb9.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.f147c, "touser=" + this.r, "ids=" + str3, "uid=" + y.K(), "token=" + y.H()))));
                String sb10 = sb9.toString();
                com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(y.e).a(sb10));
                StringBuilder sb11 = new StringBuilder();
                sb11.append("  其他用户界面接口  mark=");
                sb11.append(iArr[0]);
                sb11.append("   ");
                sb11.append(y.e);
                sb11.append(sb10);
                c0.u("OtherPersonerImformationActivity", sb11.toString());
                return;
            case 6:
                StringBuilder sb12 = new StringBuilder();
                sb12.append("bbs/posts/delete-by-user");
                sb12.append(y.u(this.f147c));
                sb12.append("&uid=");
                sb12.append(y.K());
                sb12.append("&token=");
                sb12.append(y.H());
                sb12.append("&touser=");
                sb12.append(this.r);
                sb12.append("&msg=");
                sb12.append(this.B);
                sb12.append("&key=");
                sb12.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.f147c, "touser=" + this.r, "msg=" + this.B, "uid=" + y.K(), "token=" + y.H()))));
                com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(y.e).a(sb12.toString()));
                return;
            case 7:
                StringBuilder sb13 = new StringBuilder();
                sb13.append("bbs/reply/delete-by-user");
                sb13.append(y.u(this.f147c));
                sb13.append("&uid=");
                sb13.append(y.K());
                sb13.append("&token=");
                sb13.append(y.H());
                sb13.append("&touser=");
                sb13.append(this.r);
                sb13.append("&msg=");
                sb13.append(this.C);
                sb13.append("&key=");
                sb13.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.f147c, "touser=" + this.r, "msg=" + this.C, "uid=" + y.K(), "token=" + y.H()))));
                String sb14 = sb13.toString();
                com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(y.e).a(sb14));
                StringBuilder sb15 = new StringBuilder();
                sb15.append("  其他用户界面接口  mark=");
                sb15.append(iArr[0]);
                sb15.append("   ");
                sb15.append(y.d);
                sb15.append(sb14);
                c0.u("OtherPersonerImformationActivity", sb15.toString());
                return;
            case 8:
                StringBuilder sb16 = new StringBuilder();
                sb16.append("up/comment/delete-by-user");
                sb16.append(y.u(this.f147c));
                sb16.append("&uid=");
                sb16.append(y.K());
                sb16.append("&token=");
                sb16.append(y.H());
                sb16.append("&touser=");
                sb16.append(this.r);
                sb16.append("&table=game&key=");
                sb16.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.f147c, "touser=" + this.r, "table=game", "uid=" + y.K(), "token=" + y.H()))));
                com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(y.e).a(sb16.toString()));
                return;
            case 9:
                StringBuilder sb17 = new StringBuilder();
                sb17.append("up/comment/delete-by-user");
                sb17.append(y.u(this.f147c));
                sb17.append("&uid=");
                sb17.append(y.K());
                sb17.append("&token=");
                sb17.append(y.H());
                sb17.append("&touser=");
                sb17.append(this.r);
                sb17.append("&table=up&key=");
                sb17.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.f147c, "touser=" + this.r, "table=up", "uid=" + y.K(), "token=" + y.H()))));
                com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(y.e).a(sb17.toString()));
                return;
            case 10:
                c0.u("OtherPersonerImformationActivity", "修改昵称 mark= 10" + iArr[0] + " " + y.e + "");
                HashMap hashMap = new HashMap();
                hashMap.put("channel", y.m(this.f147c, getPackageName()));
                hashMap.put("version", y.i(this.f147c));
                hashMap.put(ak.aj, y.g());
                hashMap.put("phone_model", y.T());
                hashMap.put("uid", y.K());
                hashMap.put("token", y.H());
                hashMap.put("toUid", this.r);
                hashMap.put("toName", this.G);
                hashMap.put("key", com.rtk.app.tool.t.c0(c0.e(y.v(this.f147c, "uid=" + y.K(), "token=" + y.H(), "toUid=" + this.r, "toName=" + this.G))));
                AppCompatActivity appCompatActivity = this.f147c;
                StringBuilder sb18 = new StringBuilder();
                sb18.append(y.e);
                sb18.append("user/nickname/notes");
                com.rtk.app.tool.o.h.j(appCompatActivity, this, sb18.toString(), iArr[0], hashMap);
                return;
            case 11:
                HashMap<String, String> k = y.k();
                k.put(y.z("uid"), y.K());
                k.put(y.z("token"), y.H());
                k.put(y.z("page"), "1");
                k.put("tuid", this.r);
                k.put("key", com.rtk.app.tool.t.L(k));
                com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(y.e).a(y.w("family/ta-family", k)));
                return;
            default:
                str = "   ";
                str2 = "  其他用户界面接口  mark=";
                break;
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(str3));
        c0.u("OtherPersonerImformationActivity", str2 + iArr[0] + str + y.d + str3);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i2) {
        F();
        ResponseDataBean responseDataBean = (ResponseDataBean) this.g.fromJson(str, ResponseDataBean.class);
        switch (i2) {
            case 1:
                c0.u("OtherPersonerImformationActivity", "其他用户个人信息  " + str);
                OtherImformationBean otherImformationBean = (OtherImformationBean) this.g.fromJson(str, OtherImformationBean.class);
                this.s = otherImformationBean;
                S(otherImformationBean);
                com.rtk.app.main.Home5Activity.ClickHistory.f.d(this.f147c, new ListHisUserBean.HisUserBean(this.s));
                return;
            case 2:
                this.D.dismiss();
                c0.u("OtherPersonerImformationActivity", "关注TA  " + str);
                String followed = this.s.getData().getFollowed();
                followed.hashCode();
                if (!followed.equals("1") && !followed.equals("2")) {
                    com.rtk.app.tool.f.a(this.f147c, "关注成功", f.a.f);
                    com.rtk.app.tool.t.H1(this.otherPersonalInformationExpert, "1");
                    this.s.getData().setFollowed("1");
                    com.rtk.app.tool.b0.b.b().e(Integer.parseInt(this.r), 1);
                    this.otherPersonalInformationEditNickName.setVisibility(0);
                    return;
                }
                com.rtk.app.tool.f.a(this.f147c, "取消关注成功", f.a.f);
                com.rtk.app.tool.t.H1(this.otherPersonalInformationExpert, "0");
                this.s.getData().setFollowed("0");
                this.otherPersonalInformationRemark.setVisibility(8);
                com.rtk.app.tool.b0.b.b().e(Integer.parseInt(this.r), 0);
                this.otherPersonalInformationEditNickName.setVisibility(8);
                return;
            case 3:
                c0.u("OtherPersonerImformationActivity", "重置他的头像" + str);
                com.rtk.app.tool.f.a(this.f147c, responseDataBean.getMsg(), f.a.f);
                R(1);
                return;
            case 4:
                c0.u("OtherPersonerImformationActivity", "锁定用户 " + str);
                com.rtk.app.tool.f.a(this.f147c, responseDataBean.getMsg(), f.a.f);
                R(1);
                return;
            case 5:
                c0.u("OtherPersonerImformationActivity", "删除图片 " + str);
                com.rtk.app.tool.f.a(this.f147c, responseDataBean.getMsg(), f.a.f);
                R(1);
                return;
            case 6:
                c0.u("OtherPersonerImformationActivity", "删除他所有的帖子 " + str);
                com.rtk.app.tool.f.a(this.f147c, responseDataBean.getMsg(), f.a.f);
                R(1);
                return;
            case 7:
                c0.u("OtherPersonerImformationActivity", "删除他所有的回帖 " + str);
                com.rtk.app.tool.f.a(this.f147c, responseDataBean.getMsg(), f.a.f);
                R(1);
                return;
            case 8:
                c0.u("OtherPersonerImformationActivity", "删除他所有的游戏评论 " + str);
                com.rtk.app.tool.f.a(this.f147c, responseDataBean.getMsg(), f.a.f);
                R(1);
                return;
            case 9:
                c0.u("OtherPersonerImformationActivity", "删除他所有的up资源评论 " + str);
                com.rtk.app.tool.f.a(this.f147c, responseDataBean.getMsg(), f.a.f);
                R(1);
                return;
            case 10:
                c0.u("OtherPersonerImformationActivity", "修改用户昵称 " + str);
                com.rtk.app.tool.f.a(this.f147c, "备注修改成功" + responseDataBean.getMsg(), f.a.f);
                this.otherPersonalInformationRemark.setVisibility(0);
                this.otherPersonalInformationRemark.setText("备注：" + responseDataBean.getData());
                org.greenrobot.eventbus.c.c().k(new EventMessage(this.r, (String) responseDataBean.getData()));
                return;
            case 11:
                FamilyListBean familyListBean = (FamilyListBean) this.g.fromJson(str, FamilyListBean.class);
                this.otherPersonalInformationHisFamily.setText(familyListBean.getData().size() + "");
                return;
            default:
                return;
        }
    }

    public void d0() {
        this.u = new ArrayList();
        for (int i2 = 0; i2 < this.t.size(); i2++) {
            this.u.add(this.t.get(i2).getPic());
        }
        ViewGroup.LayoutParams layoutParams = this.otherPersonalInformationPictureSV.getLayoutParams();
        for (int i3 = 0; i3 < this.t.size(); i3++) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int i4 = layoutParams.height;
            layoutParams2.height = i4;
            layoutParams2.width = (int) (i4 / 1.4d);
            AppCompatImageView recyclerImageView = new RecyclerImageView(this.f147c);
            recyclerImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            layoutParams2.leftMargin = 5;
            layoutParams2.rightMargin = 5;
            recyclerImageView.setLayoutParams(layoutParams2);
            com.rtk.app.tool.t.c(this.f147c, this.t.get(i3).getThumPic(), recyclerImageView, new boolean[0]);
            recyclerImageView.setOnClickListener(new d(i3));
            this.otherPersonalInformationPictureLv.addView(recyclerImageView);
        }
    }

    public void e0() {
        DialogEditTipEnsure dialogEditTipEnsure = new DialogEditTipEnsure(this.f147c, "修改备注", new c());
        dialogEditTipEnsure.q("请输入备注");
        if (!c0.q(this.s.getData().getNotename())) {
            dialogEditTipEnsure.r(this.s.getData().getNotename());
        }
        dialogEditTipEnsure.s(1);
        dialogEditTipEnsure.t(10, "备注信息不可超过10个字符");
        dialogEditTipEnsure.show();
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        if (this.E != null) {
            com.rtk.app.tool.b0.b.b().c(this.E);
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i2, String str, int i3) {
        DialogForEnSure dialogForEnSure = this.x;
        if (dialogForEnSure != null) {
            dialogForEnSure.dismiss();
        }
        DialogForProgressTip dialogForProgressTip = this.w;
        if (dialogForProgressTip != null) {
            dialogForProgressTip.dismiss();
        }
        if (i3 == 1) {
            I(str, new e());
        } else if (i3 == 2) {
            this.D.dismiss();
        }
        com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        DialogForProgressTip dialogForProgressTip = new DialogForProgressTip(this.f147c, "请稍后");
        this.D = dialogForProgressTip;
        int i2 = 0;
        dialogForProgressTip.setCancelable(false);
        Bundle extras = getIntent().getExtras();
        this.q = extras;
        this.r = extras.getString("fans");
        R(11);
        this.t = new ArrayList();
        this.y = new DialogForEditOtherPersonal(this.f147c, this);
        if (c.d.a.d.d() && (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getUserAdmin() == 1 || MainActivity.p.getData().getAdmin().getUserAdmin() == 2)) {
            this.otherPersonalInformationTopEditSomeThing.setVisibility(0);
            this.otherPersonalInformationUserStatus.setVisibility(0);
        } else {
            this.otherPersonalInformationTopEditSomeThing.setVisibility(8);
            this.otherPersonalInformationUserStatus.setVisibility(8);
        }
        ImageView imageView = this.otherPersonalInformationTopEditSomeThing;
        if (!c.d.a.d.d() || (MainActivity.p.getData().getAdmin().getAdmin() != 1 && MainActivity.p.getData().getAdmin().getUserAdmin() != 1 && MainActivity.p.getData().getAdmin().getUserAdmin() != 2)) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.otherPersonalInformationHisFamily.setOnClickListener(this);
        this.otherPersonalInformationHisPost.setOnClickListener(this);
        this.otherPersonalInformationHisReport.setOnClickListener(this);
        this.otherPersonalInformationHisUpSrc.setOnClickListener(this);
        this.otherPersonalInformationHisCollect.setOnClickListener(this);
        this.otherPersonalInformationComment.setOnClickListener(this);
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.w = new DialogForProgressTip(this.f147c, "处理中，请稍后");
    }

    @Override // com.rtk.app.main.dialogPack.DialogForEditOtherPersonal.c
    public void k(String str) {
        Bundle bundle = new Bundle();
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1864185814:
                if (str.equals("删除他的回帖")) {
                    c2 = 0;
                    break;
                }
                break;
            case -847379389:
                if (str.equals("删除他所有的帖子")) {
                    c2 = 1;
                    break;
                }
                break;
            case -86056546:
                if (str.equals("编辑用户相册")) {
                    c2 = 2;
                    break;
                }
                break;
            case -85874465:
                if (str.equals("编辑用户资料")) {
                    c2 = 3;
                    break;
                }
                break;
            case 918374167:
                if (str.equals("封号/解封")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1144027420:
                if (str.equals("重置头像")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1607658566:
                if (str.equals("删除他所有的Up资源评论")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1838034838:
                if (str.equals("删除他所有的游戏评论")) {
                    c2 = 7;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                new DialogForAuditCheckReason(this.f147c, R.array.audit_reason_bbs_comment, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.OtherImfomationPack.l
                    @Override // com.rtk.app.tool.s
                    public final void a(String[] strArr) {
                        OtherPersonerImformationActivity.this.W(strArr);
                    }
                }).show();
                return;
            case 1:
                new DialogForAuditCheckReason(this.f147c, R.array.audit_reason_bbs_comment, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.OtherImfomationPack.m
                    @Override // com.rtk.app.tool.s
                    public final void a(String[] strArr) {
                        OtherPersonerImformationActivity.this.U(strArr);
                    }
                }).show();
                return;
            case 2:
                bundle.putString("id", this.r);
                bundle.putSerializable("otherImformationBean", this.s);
                Intent intent = new Intent((Context) this.f147c, (Class<?>) EditOtherPictureActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                return;
            case 3:
                bundle.putString("id", this.r);
                bundle.putSerializable("otherImformationBean", this.s);
                Intent intent2 = new Intent((Context) this.f147c, (Class<?>) EditOtherPersonActivity.class);
                intent2.putExtras(bundle);
                startActivity(intent2);
                return;
            case 4:
                if (this.s.getData().getStatus() == 1) {
                    new DialogForProhibitUser(this.f147c, new i()).show();
                    return;
                } else {
                    if (this.s.getData().getStatus() == 0) {
                        new DialogForEnSure(this.f147c, "确定解封吗?", new j()).show();
                        return;
                    }
                    return;
                }
            case 5:
                DialogForEnSure dialogForEnSure = new DialogForEnSure(this.f147c, "确定重置他的头像吗？", new f());
                this.x = dialogForEnSure;
                dialogForEnSure.show();
                return;
            case 6:
                DialogForEnSure dialogForEnSure2 = new DialogForEnSure(this.f147c, "确定删除TA全部的up资源评论吗？", new h());
                this.x = dialogForEnSure2;
                dialogForEnSure2.show();
                return;
            case 7:
                DialogForEnSure dialogForEnSure3 = new DialogForEnSure(this.f147c, "确定删除TA全部的游戏评论吗？", new g());
                this.x = dialogForEnSure3;
                dialogForEnSure3.show();
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.tool.j
    public void m(j.a aVar) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        int i2 = a.a[aVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            this.s.getData().setIsBlackList(0);
            bundle.putBoolean("isBlacklist", false);
            intent.putExtras(bundle);
            setResult(1030, intent);
            return;
        }
        this.s.getData().setIsBlackList(1);
        bundle.putBoolean("isBlacklist", true);
        intent.putExtras(bundle);
        setResult(1030, intent);
        this.s.getData().setFollowed("0");
        this.otherPersonalInformationEditNickName.setVisibility(8);
        com.rtk.app.tool.t.H1(this.otherPersonalInformationExpert, "0");
        com.rtk.app.tool.b0.b.b().e(Integer.parseInt(this.r), 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.s == null) {
            c0.s("OtherPersonerImformationActivity", "未获取到用户信息。");
            return;
        }
        Bundle bundle = new Bundle();
        switch (view.getId()) {
            case R.id.other_personal_info_rtk_uid /* 2131299655 */:
                com.rtk.app.tool.t.I1(this.f147c, this.s.getData().getRtkUid());
                return;
            case R.id.other_personal_information_Expert /* 2131299656 */:
                if (y.x(this.f147c)) {
                    if (!this.s.getData().getFollowed().endsWith("1") && !this.s.getData().getFollowed().endsWith("2")) {
                        R(2);
                        this.D.show();
                        return;
                    } else {
                        new DialogForAttention(MyApplication.b(), new b()).show();
                        return;
                    }
                }
                com.rtk.app.tool.f.a(this.f147c, "请先登录", 200);
                com.rtk.app.tool.t.w0(this.f147c);
                return;
            case R.id.other_personal_information_attentionNum /* 2131299657 */:
                com.rtk.app.tool.t.j0(this.f147c, this.r);
                return;
            case R.id.other_personal_information_comment /* 2131299658 */:
                bundle.putString("uid", this.r);
                bundle.putString("otherNickName", this.s.getData().getNickname());
                com.rtk.app.tool.c.b(this.f147c, OtherCommentActivity.class, bundle);
                return;
            case R.id.other_personal_information_contribute_num /* 2131299659 */:
            case R.id.other_personal_information_gold_num /* 2131299662 */:
            case R.id.other_personal_information_grade /* 2131299663 */:
            case R.id.other_personal_information_medal /* 2131299670 */:
            case R.id.other_personal_information_medal_title /* 2131299671 */:
            case R.id.other_personal_information_nickName /* 2131299673 */:
            case R.id.other_personal_information_nickName_lv /* 2131299674 */:
            case R.id.other_personal_information_picture_SV /* 2131299675 */:
            case R.id.other_personal_information_picture_lv /* 2131299676 */:
            case R.id.other_personal_information_picture_title /* 2131299677 */:
            case R.id.other_personal_information_remark /* 2131299678 */:
            case R.id.other_personal_information_sex_age /* 2131299679 */:
            case R.id.other_personal_information_signature /* 2131299681 */:
            default:
                return;
            case R.id.other_personal_information_edit_nickName /* 2131299660 */:
                e0();
                return;
            case R.id.other_personal_information_fansNum /* 2131299661 */:
                com.rtk.app.tool.t.s0(this.f147c, this.r);
                return;
            case R.id.other_personal_information_hisUpSrc /* 2131299664 */:
                bundle.putString("uid", this.r);
                bundle.putString("otherNickName", this.s.getData().getNickname());
                bundle.putString("upNum", this.s.getData().getUpNum());
                com.rtk.app.tool.c.b(this.f147c, OtherUpSrcActivity.class, bundle);
                return;
            case R.id.other_personal_information_his_collect /* 2131299665 */:
                bundle.putString("uid", this.r);
                bundle.putString("gameNum", this.s.getData().getGameNum() + "");
                bundle.putString("postcollectNum", this.s.getData().getPostCollectNum());
                bundle.putString("otherNickName", this.s.getData().getNickname());
                bundle.putString("upCollectNum", this.s.getData().getUpCollectNum());
                com.rtk.app.tool.c.b(this.f147c, OtherCollectActivity.class, bundle);
                return;
            case R.id.other_personal_information_his_family /* 2131299666 */:
                Intent intent = new Intent((Context) this, (Class<?>) FamilyListActivity.class);
                intent.putExtra("tuid", this.r);
                startActivity(intent);
                return;
            case R.id.other_personal_information_his_post /* 2131299667 */:
                bundle.putString("uid", this.r);
                com.rtk.app.tool.c.b(this.f147c, OtherPostActivity.class, bundle);
                return;
            case R.id.other_personal_information_his_report /* 2131299668 */:
                bundle.putString("replyMeNum", this.s.getData().getReplyMeNum() + "");
                bundle.putString("replyNum", this.s.getData().getReplyNum() + "");
                bundle.putString("uid", this.r);
                bundle.putString("otherNickName", this.s.getData().getNickname());
                com.rtk.app.tool.c.b(this.f147c, OtherPostReplyActivity.class, bundle);
                return;
            case R.id.other_personal_information_icon /* 2131299669 */:
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.s.getData().getHd_face());
                com.rtk.app.tool.t.C0(this.f147c, arrayList, 0);
                return;
            case R.id.other_personal_information_more /* 2131299672 */:
                if (!y.x(this.f147c)) {
                    com.rtk.app.tool.t.w0(this.f147c);
                    com.rtk.app.tool.f.a(this.f147c, "请先登录", f.a.f);
                    return;
                } else {
                    String followed = this.s.getData().getFollowed();
                    new DialogOtherInfoMore(this.f147c, this.r, this.s.getData().getNickname(), this.s.getData().getIsBlackList(), "1".equals(followed) || "2".equals(followed), this, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.OtherImfomationPack.j
                        @Override // com.rtk.app.tool.s
                        public final void a(String[] strArr) {
                            OtherPersonerImformationActivity.this.c0(strArr);
                        }
                    }).show();
                    return;
                }
            case R.id.other_personal_information_share_url /* 2131299680 */:
                com.rtk.app.tool.t.I1(this.f147c, "http://a.ruansky.com/user/" + (c0.n(this.r) + 1111110) + "/");
                return;
            case R.id.other_personal_information_top_back /* 2131299682 */:
                finish();
                return;
            case R.id.other_personal_information_top_edit_someThing /* 2131299683 */:
                this.y.show();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_other_personer_imformation);
        ButterKnife.a(this);
        G(null, this.otherPersonalInformationTopLayout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        R(1);
    }
}
