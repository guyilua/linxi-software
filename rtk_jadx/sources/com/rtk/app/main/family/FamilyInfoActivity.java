package com.rtk.app.main.family;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qq.e.comm.constants.ErrorCode;
import com.rtk.app.R;
import com.rtk.app.bean.FamilyInfoBean;
import com.rtk.app.bean.LeaderBean;
import com.rtk.app.bean.ResponseDataBean;
import com.rtk.app.main.OtherImfomationPack.OtherPersonerImformationActivity;
import com.rtk.app.main.dialogPack.JoinFamilyDialog;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyInfoActivity extends FamilyBaseActivity implements h.j {

    @BindView
    View backLayout;

    @BindView
    ImageView familyCover;

    @BindView
    TextView familyCreateTime;

    @BindView
    View familyGradientView;

    @BindView
    TextView familyIntroduce;

    @BindView
    TextView familyJoinCoins;

    @BindView
    RoundedImageView familyLogo;

    @BindView
    TextView familyMember;

    @BindView
    TextView familyName;

    @BindView
    TextView familyNu;

    @BindView
    TextView familyOpenType;

    @BindView
    RoundedImageView fuZuZhangImg1;

    @BindView
    RoundedImageView fuZuZhangImg2;

    @BindView
    TextView fuZuZhangTV1;

    @BindView
    TextView fuZuZhangTV2;

    @BindView
    TextView joinFamily;

    @BindView
    LinearLayout leaders;
    private String r;
    private FamilyInfoBean.DataBean s;
    private String t;
    private Gson u;

    @BindView
    RoundedImageView zuZhangImg;

    @BindView
    TextView zuZhangTV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements JoinFamilyDialog.a {
        final /* synthetic */ JoinFamilyDialog a;

        a(JoinFamilyDialog joinFamilyDialog) {
            this.a = joinFamilyDialog;
        }

        @Override // com.rtk.app.main.dialogPack.JoinFamilyDialog.a
        public void a(String str) {
            FamilyInfoActivity.this.t = str;
            FamilyInfoActivity.this.P(2);
            this.a.dismiss();
        }

        @Override // com.rtk.app.main.dialogPack.JoinFamilyDialog.a
        public void b(String str) {
            this.a.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b extends com.rtk.app.tool.o.j {
        b() {
        }

        @Override // com.rtk.app.tool.o.j
        public void a(ResponseDataBean responseDataBean, int i) {
            super.a(responseDataBean, i);
            if (responseDataBean.getCode() == 331001) {
                FamilyInfoActivity.this.T(responseDataBean);
            } else {
                com.rtk.app.tool.f.a(FamilyInfoActivity.this, responseDataBean.getMsg(), f.a.f);
            }
        }

        @Override // com.rtk.app.tool.o.j, com.rtk.app.tool.o.h.j
        public void d(String str, int i) {
            super.d(str, i);
            com.rtk.app.tool.f.a(FamilyInfoActivity.this, "已提交申请", ErrorCode.NETWORK_UNKNOWN);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class c implements View.OnClickListener {
        final /* synthetic */ LeaderBean a;

        c(LeaderBean leaderBean) {
            this.a = leaderBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.rtk.app.tool.t.B0(FamilyInfoActivity.this, this.a.getId() + "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class d implements View.OnClickListener {
        final /* synthetic */ List a;

        d(List list) {
            this.a = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.a.isEmpty()) {
                com.rtk.app.tool.f.a(FamilyInfoActivity.this, "本家族此岗位暂时缺乏", ErrorCode.NETWORK_UNKNOWN);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("fans", ((LeaderBean) this.a.get(0)).getId() + "");
            Intent intent = new Intent((Context) FamilyInfoActivity.this, (Class<?>) OtherPersonerImformationActivity.class);
            intent.putExtras(bundle);
            FamilyInfoActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class e implements View.OnClickListener {
        final /* synthetic */ List a;

        e(List list) {
            this.a = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.a.size() < 2) {
                com.rtk.app.tool.f.a(FamilyInfoActivity.this, "本家族此岗位暂时缺乏", ErrorCode.NETWORK_UNKNOWN);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("fans", ((LeaderBean) this.a.get(1)).getId() + "");
            Intent intent = new Intent((Context) FamilyInfoActivity.this, (Class<?>) OtherPersonerImformationActivity.class);
            intent.putExtras(bundle);
            FamilyInfoActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            FamilyInfoActivity.this.startActivity(new Intent((Context) FamilyInfoActivity.this, (Class<?>) MyApplyFamilyListActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R(String[] strArr) {
        P(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [android.view.ViewGroup, com.rtk.app.custom.CustomSingleEditTextView] */
    private void S() {
        String str;
        String str2;
        String str3;
        JoinFamilyDialog joinFamilyDialog = new JoinFamilyDialog(this);
        String str4 = null;
        if (this.s.getOpen_type() == 3) {
            str3 = "问题：" + this.s.getQuestion();
            str = "加入家族需要正确回答问题";
            str2 = "请输入问题答案";
        } else {
            str = "加入家族";
            str2 = "请输入申请家族原因";
            str3 = null;
        }
        joinFamilyDialog.f(str2);
        joinFamilyDialog.j(str);
        joinFamilyDialog.g(str3);
        if (this.s.getJoin_coin() > 0) {
            str4 = "提示：加入此家族需要收费" + this.s.getJoin_coin() + "金币！";
        }
        joinFamilyDialog.i(str4);
        ?? a2 = joinFamilyDialog.a();
        a2.setBackground(ContextCompat.getDrawable(this, R.color.theme35));
        a2.setMaxWordCount(15);
        joinFamilyDialog.e(new a(joinFamilyDialog));
        joinFamilyDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void T(ResponseDataBean responseDataBean) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("温馨提示");
        builder.setMessage(responseDataBean.getMsg());
        builder.setPositiveButton("确定", new f());
        builder.setNegativeButton("取消", (DialogInterface.OnClickListener) null);
        builder.create().show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void U() {
        FamilyInfoBean.DataBean dataBean = this.s;
        if (dataBean == null) {
            return;
        }
        int open_type = dataBean.getOpen_type();
        this.familyOpenType.setText(open_type != 2 ? open_type != 3 ? "开放申请加入" : "正确回答问题" : "不允许加入");
        if (this.s.isJoin()) {
            this.joinFamily.setText(R.string.entry_family);
        } else {
            this.joinFamily.setText(R.string.apply_join);
        }
        com.rtk.app.tool.t.c(this, this.s.getFamily_cover(), this.familyCover, new boolean[0]);
        com.rtk.app.tool.t.c(this, this.s.getFamily_logo(), this.familyLogo, new boolean[0]);
        this.familyName.setText(this.s.getFamily_name());
        this.familyIntroduce.setText(this.s.getFamily_introduce());
        this.familyNu.setText(this.s.getFamily_sn());
        this.familyCreateTime.setText(this.s.getAdd_date());
        this.familyMember.setText(this.s.getMember_num());
        this.familyJoinCoins.setText(this.s.getJoin_coin() + "金币");
        LeaderBean leader = this.s.getFamily_admin().getLeader();
        this.zuZhangTV.setText(leader.getNickname());
        com.rtk.app.tool.t.c(this, leader.getFace(), this.zuZhangImg, new boolean[0]);
        this.zuZhangImg.setOnClickListener(new c(leader));
        List<LeaderBean> second_leader = this.s.getFamily_admin().getSecond_leader();
        int size = second_leader.size();
        if (size != 1) {
            if (size == 2) {
                LeaderBean leaderBean = second_leader.get(1);
                this.fuZuZhangTV2.setText(leaderBean.getNickname());
                this.fuZuZhangTV2.setTextColor(-16777216);
                com.rtk.app.tool.t.c(this, leaderBean.getFace(), this.fuZuZhangImg2, new boolean[0]);
            }
            this.fuZuZhangImg1.setOnClickListener(new d(second_leader));
            this.fuZuZhangImg2.setOnClickListener(new e(second_leader));
        }
        LeaderBean leaderBean2 = second_leader.get(0);
        this.fuZuZhangTV1.setText(leaderBean2.getNickname());
        this.fuZuZhangTV1.setTextColor(-16777216);
        com.rtk.app.tool.t.c(this, leaderBean2.getFace(), this.fuZuZhangImg1, new boolean[0]);
        this.fuZuZhangImg1.setOnClickListener(new d(second_leader));
        this.fuZuZhangImg2.setOnClickListener(new e(second_leader));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void P(int... iArr) {
        int i = iArr[0];
        if (i == 1) {
            String str = "&uid=" + com.rtk.app.tool.y.K();
            String str2 = "&token=" + com.rtk.app.tool.y.H();
            StringBuilder sb = new StringBuilder();
            sb.append("family/basic-information");
            sb.append(com.rtk.app.tool.y.u(this));
            sb.append(str);
            sb.append(str2);
            sb.append("&family_id=");
            sb.append(this.r);
            sb.append("&key=");
            sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this, "family_id=" + this.r))));
            String sb2 = sb.toString();
            Log.d("FamilyInfoActivity", "url=" + sb2);
            com.rtk.app.tool.o.h.l(this, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb2));
            return;
        }
        if (i != 2) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("channel", com.rtk.app.tool.y.m(this, getPackageName()));
        hashMap.put("version", com.rtk.app.tool.y.i(this));
        hashMap.put(ak.aj, com.rtk.app.tool.y.g());
        hashMap.put("phone_model", com.rtk.app.tool.y.T());
        hashMap.put("msg", this.t);
        hashMap.put("uid", com.rtk.app.tool.y.K());
        hashMap.put("token", com.rtk.app.tool.y.H());
        hashMap.put("family_id", this.s.getFamily_id());
        hashMap.put("key", com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "msg=" + this.t, "family_id=" + this.s.getFamily_id()))));
        b bVar = new b();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(com.rtk.app.tool.y.e);
        sb3.append("family/join/apply");
        com.rtk.app.tool.o.h.j(this, bVar, sb3.toString(), 2, hashMap);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        F();
        com.rtk.app.tool.c0.r("FamilyInfoActivity", "success:mark=" + i + ",str=" + com.rtk.app.c.a.b(str));
        if (i != 1) {
            return;
        }
        this.s = ((FamilyInfoBean) this.u.fromJson(str, FamilyInfoBean.class)).getData();
        com.rtk.app.tool.c0.r("FamilyInfoActivity", "dataBean=" + this.s);
        U();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.r("FamilyInfoActivity", "error,str=" + str);
        com.rtk.app.tool.f.a(this, str, ErrorCode.NETWORK_UNKNOWN);
        if (i2 != 1) {
            return;
        }
        I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.family.l
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                FamilyInfoActivity.this.R(strArr);
            }
        });
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#33000000"), Color.parseColor("#4D000000")});
        gradientDrawable.setShape(0);
        this.familyGradientView.setBackground(gradientDrawable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != 2131296692) {
            if (id == 2131298263 && this.s != null) {
                if (!com.rtk.app.tool.y.x(this)) {
                    com.rtk.app.tool.t.w0(this);
                    return;
                } else {
                    if (this.s.isJoin()) {
                        Intent intent = new Intent((Context) this, (Class<?>) MyFamilyActivity.class);
                        intent.putExtra("family_id", this.s.getFamily_id());
                        startActivity(intent);
                        return;
                    }
                    S();
                    return;
                }
            }
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_family_info);
        ButterKnife.a(this);
        ((LinearLayout.LayoutParams) this.joinFamily.getLayoutParams()).bottomMargin = v() + com.rtk.app.tool.h.a(20.0f, this);
        String stringExtra = getIntent().getStringExtra("family_id");
        this.r = stringExtra;
        if (stringExtra == null) {
            finish();
        }
        this.u = new GsonBuilder().enableComplexMapKeySerialization().create();
        G(null, this.backLayout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        P(1);
    }

    @Override // com.rtk.app.custom.SwipeBackActivity
    public boolean q() {
        return true;
    }
}
