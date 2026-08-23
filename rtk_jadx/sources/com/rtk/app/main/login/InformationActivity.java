package com.rtk.app.main.login;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.Home5ImfromationBean;
import com.rtk.app.bean.LoginBean;
import com.rtk.app.bean.UserIconBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.custom.MyHorizontalScrollView;
import com.rtk.app.custom.RecyclerImageView;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.dialogPack.DialogForEnSure;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.main.dialogPack.DialogPermision;
import com.rtk.app.main.dialogPack.DialogPhoto;
import com.rtk.app.main.dialogPack.d0;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.m;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.u;
import com.rtk.app.tool.v;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import com.tencent.smtt.sdk.TbsListener;
import com.umeng.analytics.pro.ak;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class InformationActivity extends BaseActivity implements h.j, PlatformActionListener {
    private DialogForProgressTip F;

    @BindView
    TextView informationBirthday;

    @BindView
    LinearLayout informationBirthdayLayout;

    @BindView
    TextView informationBoundQQ;

    @BindView
    ImageView informationBoundQQFace;

    @BindView
    LinearLayout informationBoundQQLv;

    @BindView
    ImageView informationBoundWFace;

    @BindView
    TextView informationBoundWechat;

    @BindView
    LinearLayout informationBoundWechatLv;

    @BindView
    LinearLayout informationEmptyPictureLv;

    @BindView
    RoundedImageView informationIcon;

    @BindView
    RelativeLayout informationIconLayout;

    @BindView
    TextView informationIconLayoutAuditState;

    @BindView
    TextView informationIntro;

    @BindView
    LinearLayout informationIntroLayout;

    @BindView
    TextView informationLoginOut;

    @BindView
    TextView informationName;

    @BindView
    LinearLayout informationNameLayout;

    @BindView
    LinearLayout informationPhotoAlbumLv;

    @BindView
    CustomTextView informationPhotoAlbumNum;

    @BindView
    LinearLayout informationPictureLv;

    @BindView
    MyHorizontalScrollView informationPictureSV;

    @BindView
    TextView informationRtkUid;

    @BindView
    LinearLayout informationRtkUidLayout;

    @BindView
    TextView informationSex;

    @BindView
    LinearLayout informationSexLayout;

    @BindView
    SwipeRefreshLayout informationSwipeRefresh;

    @BindView
    TextView informationTopBack;

    @BindView
    LinearLayout informationTopLayout;

    @BindView
    TextView informationUpdataPsw;
    private Context q;
    private Home5ImfromationBean r;
    private View s;
    private TextView t;
    private List<String> u;
    private Platform v;
    private String w;
    private int x;
    private DialogForEnSure z;
    private String y = "";
    private String A = "";
    private String B = "";
    private String C = "";
    private String D = "";
    private String E = "";
    Bitmap G = null;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements s {
        a() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            InformationActivity.this.A = "&alread=1";
            InformationActivity.this.M(3);
            InformationActivity.this.A = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O(String[] strArr) {
        M(1);
        M(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q() {
        M(1);
        M(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S(String[] strArr) {
        if (strArr.length == 0) {
            return;
        }
        this.informationSex.setText(strArr[0].equals("1") ? "男" : "女");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U(String[] strArr) {
        if (strArr.length == 0) {
            return;
        }
        c0.u("InformationActivity", "是数字");
        this.informationBirthday.setText(c0.g(Long.parseLong(strArr[0])));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W(String[] strArr) {
        this.y = "&unbind=1";
        this.x = 1;
        this.w = this.r.getData().getQqLogin().getOpenid();
        M(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y(String[] strArr) {
        this.z.show();
        this.y = "&unbind=1";
        this.x = 2;
        this.w = this.r.getData().getWxLogin().getUnionid();
        M(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a0(int i, View view) {
        t.C0(this.f147c, this.u, i);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        t.S1(this.q, this.informationTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0), this.informationIconLayout);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void M(int... iArr) {
        int i;
        HashMap hashMap = new HashMap();
        int i2 = iArr[0];
        String str = "";
        if (i2 != 1) {
            if (i2 == 2) {
                StringBuilder sb = new StringBuilder();
                sb.append("members/userBaseInfo");
                sb.append(y.u(this.q));
                sb.append("&uid=");
                sb.append(MainActivity.p.getData().getUid());
                sb.append("&token=");
                sb.append(y.H());
                sb.append("&key=");
                sb.append(t.c0(c0.e(y.v(this.q, "uid=" + MainActivity.p.getData().getUid(), "token=" + y.H()))));
                str = sb.toString();
            } else {
                if (i2 == 3) {
                    hashMap.put("channel", y.m(this.q, getPackageName()));
                    hashMap.put("version", y.i(this.q));
                    hashMap.put(ak.aj, y.g());
                    hashMap.put("phone_model", y.T());
                    hashMap.put("uid", y.K());
                    hashMap.put("token", y.H());
                    hashMap.put("number", this.w);
                    hashMap.put("tag", this.x + "");
                    if (!c0.q(this.y)) {
                        hashMap.put("unbind", "1");
                    }
                    if (!c0.q(this.A)) {
                        hashMap.put("alread", "1");
                    }
                    if (this.x == 1) {
                        hashMap.put("q_nickname", this.B);
                        hashMap.put("q_face", this.C);
                    } else {
                        hashMap.put("w_nickname", this.D);
                        hashMap.put("w_face", this.E);
                    }
                    hashMap.put("key", t.c0(c0.e(y.v(this.q, "tag=" + this.x, "uid=" + MainActivity.p.getData().getUid(), "token=" + y.H()))));
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("绑定QQ/微信传送的数据  ");
                    sb2.append(hashMap.toString());
                    c0.u("InformationActivity", sb2.toString());
                    AppCompatActivity appCompatActivity = this.f147c;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(y.d);
                    sb3.append("members/bindWebchat");
                    com.rtk.app.tool.o.h.j(appCompatActivity, this, sb3.toString(), iArr[0], hashMap);
                    return;
                }
                if (i2 == 4) {
                    String m = t.m(this.G);
                    hashMap.put("uid", MainActivity.p.getData().getUid() + "");
                    hashMap.put("token", y.G(this.q));
                    hashMap.put("image_base64", m);
                    hashMap.put("channel", y.m(this.q, getPackageName()));
                    hashMap.put("version", y.i(this.q));
                    hashMap.put(ak.aj, y.g());
                    hashMap.put("phone_model", y.T());
                    hashMap.put("key", t.c0(c0.e(y.v(this.q, "uid=" + MainActivity.p.getData().getUid(), "token=" + y.G(this.q), "image_base64=" + m))));
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(y.e);
                    sb4.append("user/face");
                    com.rtk.app.tool.o.h.w(this, this, sb4.toString(), iArr[0], hashMap);
                    return;
                }
            }
            i = 0;
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("member/userInfo");
            sb5.append(y.u(this.q));
            sb5.append("&uid=");
            sb5.append(MainActivity.p.getData().getUid());
            sb5.append("&token=");
            sb5.append(y.H());
            sb5.append("&key=");
            i = 0;
            sb5.append(t.c0(c0.e(y.v(this.q, "uid=" + MainActivity.p.getData().getUid()))));
            str = sb5.toString();
        }
        c0.u("InformationActivity", "个人中心接口" + iArr[i] + " " + y.d + str);
        String[] strArr = new String[1];
        strArr[i] = str;
        if (c0.q(strArr)) {
            return;
        }
        com.rtk.app.tool.o.h.l(this.q, this, iArr[i], com.rtk.app.tool.o.h.h(new String[i]).a(str));
    }

    public void b0() {
        this.informationPictureLv.removeAllViews();
        this.u = new ArrayList();
        for (int i = 0; i < this.r.getData().getPhotoWall().size(); i++) {
            this.u.add(this.r.getData().getPhotoWall().get(i).getPic());
        }
        ViewGroup.LayoutParams layoutParams = this.informationPictureSV.getLayoutParams();
        for (final int i2 = 0; i2 < this.r.getData().getPhotoWall().size(); i2++) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int i3 = layoutParams.height;
            layoutParams2.height = i3;
            layoutParams2.width = (int) (i3 / 1.4d);
            View inflate = LayoutInflater.from(this.q).inflate(com.rtk.app.R.layout.audit_picture_layout, (ViewGroup) null);
            AppCompatImageView appCompatImageView = (RecyclerImageView) inflate.findViewById(com.rtk.app.R.id.audit_picture_img);
            TextView textView = (TextView) inflate.findViewById(com.rtk.app.R.id.audit_picture_state);
            if (this.r.getData().getPhotoWall().get(i2).getCheck_status().equals("1")) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            inflate.setLayoutParams(layoutParams2);
            t.c(this.f147c, this.r.getData().getPhotoWall().get(i2).getThumPic(), appCompatImageView, new boolean[0]);
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.main.login.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InformationActivity.this.a0(i2, view);
                }
            });
            this.informationPictureLv.addView(inflate);
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        LoginBean loginBean;
        F();
        this.informationSwipeRefresh.setRefreshing(false);
        if (i == 1) {
            c0.u("InformationActivity", "个人信息success mark1" + str);
            LoginBean loginBean2 = (LoginBean) this.g.fromJson(str, LoginBean.class);
            loginBean2.getData().setToken(MainActivity.p.getData().getToken());
            loginBean2.getData().setUpAdmin(MainActivity.p.getData().getUpAdmin());
            loginBean2.getData().setAdmin(MainActivity.p.getData().getAdmin());
            MainActivity.p = loginBean2;
            c0.u("InformationActivity", "当前login内容" + this.g.toJson(MainActivity.p));
            v.h(this.q, "userInformation", this.g.toJson(MainActivity.p));
            initView();
            return;
        }
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    return;
                }
                UserIconBean userIconBean = (UserIconBean) this.g.fromJson(str, UserIconBean.class);
                MainActivity.p.getData().setFace(userIconBean.getData().getFace_url());
                t.c(this.q, userIconBean.getData().getFace_url(), this.informationIcon, new boolean[0]);
                v.h(this.q, "userInformation", this.g.toJson(MainActivity.p));
                com.rtk.app.tool.f.a(this.q, "头像上传成功~", f.a.f);
                this.F.dismiss();
                return;
            }
            this.F.dismiss();
            c0.u("InformationActivity", "绑定成功" + str);
            if (!c0.q(this.y)) {
                com.rtk.app.tool.f.a(this.f147c, "已解绑", f.a.f);
                this.z.dismiss();
            } else {
                com.rtk.app.tool.f.a(this.f147c, "已绑定", f.a.f);
            }
            onResume();
            this.y = "";
            return;
        }
        c0.u("InformationActivity", "个人信息success mark2" + str);
        this.r = (Home5ImfromationBean) this.g.fromJson(str, Home5ImfromationBean.class);
        this.informationPhotoAlbumNum.setText(this.r.getData().getPhotoWall().size() + "");
        this.informationBoundQQLv.setClickable(true);
        v.h(this.f147c, v.f, str);
        if (this.r.getData() != null && (loginBean = MainActivity.p) != null && loginBean.getData() != null) {
            MainActivity.p.getData().setHome5BeanToLoginBean(this.r);
        }
        if (c0.q(this.r.getData().getQqLogin().getOpenid())) {
            this.informationBoundQQFace.setImageBitmap(null);
            this.informationBoundQQ.setText("未绑定");
        } else {
            t.c(this.f147c, this.r.getData().getQqLogin().getQ_face(), this.informationBoundQQFace, new boolean[0]);
            this.informationBoundQQ.setText(this.r.getData().getQqLogin().getQ_nickname());
        }
        if (c0.q(this.r.getData().getWxLogin().getUnionid())) {
            this.informationBoundWFace.setImageBitmap(null);
            this.informationBoundWechat.setText("未绑定");
        } else {
            t.c(this.f147c, this.r.getData().getWxLogin().getW_face(), this.informationBoundWFace, new boolean[0]);
            this.informationBoundWechat.setText(this.r.getData().getWxLogin().getW_nickname());
        }
        this.informationRtkUid.setText(this.r.getData().getRtkUid());
        this.informationBoundWechatLv.setClickable(true);
        if (this.r.getData().getPhotoWall().size() > 0) {
            this.informationEmptyPictureLv.setVisibility(8);
            this.informationPictureSV.setVisibility(0);
            b0();
        } else {
            this.informationEmptyPictureLv.removeAllViews();
            this.informationEmptyPictureLv.addView(this.s);
            this.informationEmptyPictureLv.setVisibility(0);
            this.informationPictureSV.setVisibility(8);
        }
        MainActivity.p.getData().setHome5BeanToLoginBean(this.r);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        I(str, new s() { // from class: com.rtk.app.main.login.e
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                InformationActivity.this.O(strArr);
            }
        });
        this.informationSwipeRefresh.setRefreshing(false);
        if (i2 == 1) {
            finish();
            return;
        }
        if (i2 == 3) {
            this.F.dismiss();
            com.rtk.app.tool.f.a(this.q, str, f.a.f);
            if (i == 9107) {
                new DialogForEnSure(this.f147c, str, new a()).show();
                return;
            }
            return;
        }
        if (i2 != 4) {
            com.rtk.app.tool.f.a(this.f147c, "" + str, f.a.f);
            return;
        }
        this.F.dismiss();
        com.rtk.app.tool.f.a(this.f147c, "" + str, f.a.f);
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        this.F = new DialogForProgressTip(this.f147c, "");
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.informationSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.rtk.app.main.login.h
            public final void onRefresh() {
                InformationActivity.this.Q();
            }
        });
        this.informationPictureSV.setSwipeRefreshLayout(this.informationSwipeRefresh);
        this.t.setOnClickListener(this);
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        if (MainActivity.p.getData() == null) {
            t.w0(this.f147c);
            return;
        }
        if (!c0.q(MainActivity.p.getData().getFace_new())) {
            t.c(this.q, MainActivity.p.getData().getFace_new(), this.informationIcon, new boolean[0]);
            this.informationIconLayoutAuditState.setVisibility(0);
        } else {
            t.c(this.q, MainActivity.p.getData().getFace(), this.informationIcon, new boolean[0]);
            this.informationIconLayoutAuditState.setVisibility(8);
        }
        if (!c0.q(MainActivity.p.getData().getNickname_new())) {
            this.informationName.setText(MainActivity.p.getData().getNickname_new() + "(审核中)");
        } else {
            this.informationName.setText(MainActivity.p.getData().getNickname());
        }
        if (!c0.q(MainActivity.p.getData().getSignature_new())) {
            this.informationIntro.setText(MainActivity.p.getData().getSignature_new() + "(审核中)");
        } else if (!c0.q(MainActivity.p.getData().getSignature())) {
            this.informationIntro.setText(MainActivity.p.getData().getSignature());
        }
        View inflate = LayoutInflater.from(this.q).inflate(com.rtk.app.R.layout.imformation_picture_empty_layout, (ViewGroup) null);
        this.s = inflate;
        this.t = (TextView) inflate.findViewById(com.rtk.app.R.id.imformation_picture_empty_up);
        if (MainActivity.p.getData().getSex() == 1) {
            this.informationSex.setText("男");
        } else {
            this.informationSex.setText("女");
        }
        if (c0.q(MainActivity.p.getData().getBirthday() + "")) {
            return;
        }
        this.informationBirthday.setText(c0.g(MainActivity.p.getData().getBirthday()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        try {
            if (i == 111) {
                this.G = BitmapFactory.decodeStream(getContentResolver().openInputStream(this.e));
                m.c((Activity) this.q, this.e, this.f, 1, 1, TbsListener.ErrorCode.INFO_CODE_MINIQB, TbsListener.ErrorCode.INFO_CODE_MINIQB, 114);
            } else if (i == 114) {
                Bitmap decodeStream = BitmapFactory.decodeStream(getContentResolver().openInputStream(this.f));
                this.G = decodeStream;
                if (decodeStream != null) {
                    this.F.q("头像上传中，请稍后~");
                    this.F.show();
                    M(4);
                }
            } else {
                if (i != 115) {
                    return;
                }
                List d = com.luck.picture.lib.b.d(intent);
                if (d.isEmpty()) {
                    return;
                }
                Uri b = m.b(this.q, new File(((com.luck.picture.lib.f.b) d.get(0)).f()));
                Uri a2 = m.a(this.f147c);
                this.f = a2;
                m.c((Activity) this.q, b, a2, 1, 1, TbsListener.ErrorCode.INFO_CODE_MINIQB, TbsListener.ErrorCode.INFO_CODE_MINIQB, 114);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void onCancel(Platform platform, int i) {
        com.rtk.app.tool.f.a(this.f147c, "授权取消", f.a.f);
        this.F.dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            Bundle bundle = new Bundle();
            switch (view.getId()) {
                case com.rtk.app.R.id.imformation_picture_empty_up /* 2131298191 */:
                case com.rtk.app.R.id.information_photo_album_lv /* 2131298219 */:
                    com.rtk.app.tool.c.b(this.f147c, EditPictureActivity.class, null);
                    break;
                case com.rtk.app.R.id.information_birthday_layout /* 2131298203 */:
                    new com.rtk.app.main.dialogPack.c0(this.q, new s() { // from class: com.rtk.app.main.login.f
                        @Override // com.rtk.app.tool.s
                        public final void a(String[] strArr) {
                            InformationActivity.this.U(strArr);
                        }
                    }).show();
                    break;
                case com.rtk.app.R.id.information_bound_QQ_lv /* 2131298206 */:
                    if (c0.q(this.r.getData().getQqLogin().getOpenid())) {
                        this.F.q("绑定中，请稍后...");
                        this.F.show();
                        Platform platform = ShareSDK.getPlatform(QQ.NAME);
                        this.v = platform;
                        platform.removeAccount(true);
                        this.v.SSOSetting(false);
                        this.v.setPlatformActionListener(this);
                        this.v.showUser((String) null);
                        break;
                    } else {
                        DialogForEnSure dialogForEnSure = new DialogForEnSure(this.f147c, "确定解除绑定吗？", new s() { // from class: com.rtk.app.main.login.c
                            @Override // com.rtk.app.tool.s
                            public final void a(String[] strArr) {
                                InformationActivity.this.W(strArr);
                            }
                        });
                        this.z = dialogForEnSure;
                        dialogForEnSure.show();
                        break;
                    }
                case com.rtk.app.R.id.information_bound_wechat_lv /* 2131298209 */:
                    if (c0.q(this.r.getData().getWxLogin().getUnionid())) {
                        this.F.q("绑定中，请稍后...");
                        this.F.show();
                        Platform platform2 = ShareSDK.getPlatform(Wechat.NAME);
                        this.v = platform2;
                        platform2.removeAccount(true);
                        this.v.SSOSetting(false);
                        this.v.setPlatformActionListener(this);
                        this.v.showUser((String) null);
                        break;
                    } else {
                        DialogForEnSure dialogForEnSure2 = new DialogForEnSure(this.f147c, "确定解除绑定吗？", new s() { // from class: com.rtk.app.main.login.d
                            @Override // com.rtk.app.tool.s
                            public final void a(String[] strArr) {
                                InformationActivity.this.Y(strArr);
                            }
                        });
                        this.z = dialogForEnSure2;
                        dialogForEnSure2.show();
                        break;
                    }
                case com.rtk.app.R.id.information_icon /* 2131298211 */:
                    DialogPhoto dialogPhoto = new DialogPhoto(this.f147c);
                    this.d = dialogPhoto;
                    dialogPhoto.d();
                    this.d.c(true);
                    this.d.show();
                    break;
                case com.rtk.app.R.id.information_intro_layout /* 2131298215 */:
                    bundle.putString("signature", MainActivity.p.getData().getSignature());
                    com.rtk.app.tool.c.b((Activity) this.q, UpdateSignatureActivity.class, bundle);
                    break;
                case com.rtk.app.R.id.information_loginOut /* 2131298216 */:
                    y.e(this.q);
                    MainActivity.p = null;
                    com.rtk.app.tool.c.a((Activity) this.q);
                    break;
                case com.rtk.app.R.id.information_name_layout /* 2131298218 */:
                    com.rtk.app.tool.c.b(this.f147c, UpdateNickNameActivity.class, null);
                    break;
                case com.rtk.app.R.id.information_rtk_uid_layout /* 2131298224 */:
                    com.rtk.app.tool.c.b(this.f147c, UpdateRtkUidActivity.class, null);
                    break;
                case com.rtk.app.R.id.information_sex_layout /* 2131298226 */:
                    new d0(this.q, new s() { // from class: com.rtk.app.main.login.b
                        @Override // com.rtk.app.tool.s
                        public final void a(String[] strArr) {
                            InformationActivity.this.S(strArr);
                        }
                    }).show();
                    break;
                case com.rtk.app.R.id.information_top_back /* 2131298228 */:
                    com.rtk.app.tool.c.a((Activity) this.q);
                    break;
                case com.rtk.app.R.id.information_updataPsw /* 2131298230 */:
                    com.rtk.app.tool.c.b((Activity) this.q, UpdataPswActivity.class, null);
                    break;
            }
        } catch (Exception e) {
            c0.u("InformationActivity", "  点击事件    " + e);
        }
    }

    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        this.F.q("绑定中，请稍后...");
        this.F.show();
        this.w = platform.getDb().getUserId();
        if (platform.getName().equals("QQ")) {
            this.x = 1;
            this.B = u.c(platform.getDb().getUserName().trim().getBytes());
            this.C = u.c(platform.getDb().getUserIcon().trim().getBytes());
        } else if (platform.getName().equals("Wechat")) {
            this.x = 2;
            this.D = u.c(platform.getDb().getUserName().trim().getBytes());
            this.E = u.c(platform.getDb().getUserIcon().trim().getBytes());
        }
        M(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_information);
        ButterKnife.a(this);
        com.rtk.app.main.comment.express.c.g();
        this.q = this;
        G(null, this.informationTopLayout);
    }

    public void onError(Platform platform, int i, Throwable th) {
        this.F.dismiss();
        com.rtk.app.tool.f.a(this.f147c, "授权失败" + th.getMessage(), f.a.f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 10000) {
            for (int i2 : iArr) {
                if (i2 != 0) {
                    return;
                }
            }
            t.E1(this, 1, false);
            return;
        }
        if (i != 10001) {
            return;
        }
        for (int i3 : iArr) {
            if (i3 != 0) {
                new DialogPermision(MyApplication.b(), t.E(this)).show();
                return;
            }
        }
        J();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        LoginBean loginBean = MainActivity.p;
        if (loginBean == null || loginBean.getData() == null) {
            com.rtk.app.tool.f.a(this.q, "未登录", f.a.f);
            t.w0(this.q);
            finish();
        }
        M(1);
        M(2);
    }
}
