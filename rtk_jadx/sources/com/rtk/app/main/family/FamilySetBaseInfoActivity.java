package com.rtk.app.main.family;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.bean.FamilyInfoBean;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.main.dialogPack.DialogPhoto;
import com.sigmob.sdk.downloader.f;
import com.tencent.smtt.sdk.TbsListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilySetBaseInfoActivity extends FamilyBaseActivity {

    @BindView
    View backLayout;

    @BindView
    ImageView familyCover;

    @BindView
    View familyCoverLayout;

    @BindView
    RoundedImageView familyLogo;

    @BindView
    View familyLogoLayout;

    @BindView
    TextView familyName;

    @BindView
    View familyNameLayout;
    FamilyInfoBean s;

    @BindView
    TextView setIntro;

    @BindView
    View setIntroLayout;

    @BindView
    TextView setJoinNeedMoney;

    @BindView
    View setJoinNeedMoneyLayout;

    @BindView
    TextView setNotice;

    @BindView
    View setNoticeLayout;

    @BindView
    TextView setOpenState;

    @BindView
    View setOpenStateLayout;
    DialogForProgressTip t;
    private String u;
    Bitmap r = null;
    boolean v = false;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements com.rtk.app.tool.s {
        a() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            FamilySetBaseInfoActivity.this.N(1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void O(FamilyInfoBean.DataBean dataBean) {
        com.rtk.app.tool.t.c(this, dataBean.getFamily_logo(), this.familyLogo, new boolean[0]);
        com.rtk.app.tool.t.c(this, dataBean.getFamily_cover(), this.familyCover, new boolean[0]);
        this.familyName.setText(dataBean.getFamily_name());
        this.setJoinNeedMoney.setText(dataBean.getJoin_coin() + "");
        this.setNotice.setText(dataBean.getFamily_notice());
        this.setIntro.setText(dataBean.getFamily_introduce());
        int open_type = dataBean.getOpen_type();
        this.setOpenState.setText(open_type != 2 ? open_type != 3 ? "开放申请加入" : "正确回答问题" : "不允许加入");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void N(int... iArr) {
        int i = iArr[0];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            String m = com.rtk.app.tool.t.m(this.r);
            HashMap<String, String> l = com.rtk.app.tool.y.l();
            l.put(this.v ? "image_base64" : com.rtk.app.tool.y.z("image_base64"), m);
            l.put("family_id", this.u);
            l.put("key", com.rtk.app.tool.t.L(l));
            StringBuilder sb = new StringBuilder();
            sb.append(com.rtk.app.tool.y.e);
            sb.append(this.v ? "family/info/logo" : "family/info/cover");
            com.rtk.app.tool.o.h.w(this, this, sb.toString(), 2, l);
            return;
        }
        String str = "&uid=" + com.rtk.app.tool.y.K();
        String str2 = "&token=" + com.rtk.app.tool.y.H();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("family/home-page");
        sb2.append(com.rtk.app.tool.y.u(this));
        sb2.append(str);
        sb2.append(str2);
        sb2.append("&family_id=");
        sb2.append(this.u);
        sb2.append("&key=");
        sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this, "family_id=" + this.u, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
        String sb3 = sb2.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("url=");
        sb4.append(sb3);
        com.rtk.app.tool.c0.r("FamilySetBaseInfoActivity", sb4.toString());
        com.rtk.app.tool.o.h.l(this, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        F();
        com.rtk.app.tool.c0.r("FamilySetBaseInfoActivity", "success--mark:" + i + ",str:" + str);
        if (i == 1) {
            FamilyInfoBean familyInfoBean = (FamilyInfoBean) w(str, FamilyInfoBean.class);
            this.s = familyInfoBean;
            O(familyInfoBean.getData());
        } else {
            if (i != 2) {
                return;
            }
            com.rtk.app.tool.f.a(this, "上传成功", f.a.f);
            this.t.dismiss();
            N(1);
        }
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.r("FamilySetBaseInfoActivity", "code=" + i + "str=" + str + ",mark=" + i2);
        if (i2 == 1) {
            I(str, new a());
        } else {
            if (i2 != 2) {
                return;
            }
            this.t.dismiss();
            com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
        }
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initData() {
        this.t = new DialogForProgressTip(this.f147c, "");
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        int i3;
        int i4;
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        try {
            if (i == 111) {
                this.r = BitmapFactory.decodeStream(getContentResolver().openInputStream(this.e));
                if (this.v) {
                    com.rtk.app.tool.m.c(this.f147c, this.e, this.f, 1, 1, TbsListener.ErrorCode.INFO_CODE_MINIQB, TbsListener.ErrorCode.INFO_CODE_MINIQB, 114);
                } else {
                    com.rtk.app.tool.m.c(this.f147c, this.e, this.f, 2, 1, 1000, TbsListener.ErrorCode.INFO_CODE_MINIQB, 114);
                }
            } else if (i == 114) {
                Bitmap decodeStream = BitmapFactory.decodeStream(getContentResolver().openInputStream(this.f));
                this.r = decodeStream;
                if (decodeStream != null) {
                    this.t.q(this.v ? "头像上传中，请稍后~" : "封面上传中，请稍后～");
                    this.t.show();
                    N(2);
                }
            } else {
                if (i != 115) {
                    return;
                }
                List d = com.luck.picture.lib.b.d(intent);
                if (d.isEmpty()) {
                    return;
                }
                Uri b = com.rtk.app.tool.m.b(this, new File(((com.luck.picture.lib.f.b) d.get(0)).f()));
                Uri a2 = com.rtk.app.tool.m.a(this.f147c);
                this.f = a2;
                if (this.v) {
                    i3 = 1;
                    i4 = TbsListener.ErrorCode.INFO_CODE_MINIQB;
                } else {
                    i3 = 2;
                    i4 = 1000;
                }
                com.rtk.app.tool.m.c(this, b, a2, i3, 1, i4, TbsListener.ErrorCode.INFO_CODE_MINIQB, 114);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.rtk.app.tool.y.x(this)) {
            com.rtk.app.tool.t.w0(this);
            return;
        }
        switch (view.getId()) {
            case R.id.family_cover_layout /* 2131297527 */:
                this.v = false;
                DialogPhoto dialogPhoto = new DialogPhoto(this.f147c);
                this.d = dialogPhoto;
                dialogPhoto.d();
                this.d.c(true);
                this.d.show();
                return;
            case R.id.family_logo_layout /* 2131297542 */:
                this.v = true;
                DialogPhoto dialogPhoto2 = new DialogPhoto(this.f147c);
                this.d = dialogPhoto2;
                dialogPhoto2.d();
                this.d.c(true);
                this.d.show();
                return;
            case R.id.family_name_layout /* 2131297548 */:
                if (this.s != null) {
                    Intent intent = new Intent((Context) this, (Class<?>) UpdateFamilyNameActivity.class);
                    intent.putExtra("family_Info", this.s);
                    startActivity(intent);
                    return;
                }
                return;
            case R.id.set_intro_layout /* 2131300147 */:
                if (this.s != null) {
                    Intent intent2 = new Intent((Context) this, (Class<?>) UpdateFamilyIntroActivity.class);
                    intent2.putExtra("family_Info", this.s);
                    startActivity(intent2);
                    return;
                }
                return;
            case R.id.set_join_need_money_layout /* 2131300149 */:
                if (this.s != null) {
                    Intent intent3 = new Intent((Context) this, (Class<?>) UpdateFamilyJoinCoinActivity.class);
                    intent3.putExtra("family_Info", this.s);
                    startActivity(intent3);
                    return;
                }
                return;
            case R.id.set_notice_layout /* 2131300152 */:
                if (this.s != null) {
                    Intent intent4 = new Intent((Context) this, (Class<?>) UpdateFamilyNoticeActivity.class);
                    intent4.putExtra("family_Info", this.s);
                    startActivity(intent4);
                    return;
                }
                return;
            case R.id.set_open_state_layout /* 2131300154 */:
                if (this.s != null) {
                    Intent intent5 = new Intent((Context) this, (Class<?>) FamilySelectOpenTypeActivity.class);
                    intent5.putExtra("family_Info", this.s);
                    startActivity(intent5);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_family_set_base_info);
        ButterKnife.a(this);
        this.u = getIntent().getStringExtra("family_id");
        G(null, this.backLayout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        N(1);
    }
}
