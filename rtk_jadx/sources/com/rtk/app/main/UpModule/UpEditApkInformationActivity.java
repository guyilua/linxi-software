package com.rtk.app.main.UpModule;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.UpApkCheakDetailsNeedBean;
import com.rtk.app.bean.UpApkDetailsBean;
import com.rtk.app.bean.UpGameTypeBean;
import com.rtk.app.bean.UpServiceUpImgBean;
import com.rtk.app.bean.UserUpSetCoinCheckBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.UpModule.UpHolderTool.UpEditProgressHeadHolder;
import com.rtk.app.main.dialogPack.DialogForEnSure;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.main.dialogPack.DialogForPublishUpSrcShowShatus;
import com.rtk.app.main.dialogPack.DialogTipsForCallBack;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import com.zhy.view.flowlayout.FlowLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpEditApkInformationActivity extends BaseActivity implements h.j {
    private int B;
    private String C;
    private String D;
    private int E;
    private List<String> G;
    private File H;
    private int J;
    private int K;
    private int L;
    private UpApkCheakDetailsNeedBean N;
    private RadioGroup.OnCheckedChangeListener O;
    private Intent P;
    private Bundle Q;
    private DialogForEnSure R;
    private UpEditProgressHeadHolder S;
    private DialogForPublishUpSrcShowShatus q;
    private String r;
    private String s;
    private String t;

    @BindView
    View upEditApkHolderView;

    @BindView
    LinearLayout upEditApkInfoShowStatusLv;

    @BindView
    Spinner upEditApkInformationAddApkTags;

    @BindView
    RadioGroup upEditApkInformationAddApkType;

    @BindView
    RadioButton upEditApkInformationAddApkTypeGame;

    @BindView
    RadioButton upEditApkInformationAddApkTypeSoft;

    @BindView
    ImageView upEditApkInformationAddPhoto;

    @BindView
    FlowLayout upEditApkInformationAddPhotoLv;

    @BindView
    EditText upEditApkInformationAddSrcDescription;

    @BindView
    EditText upEditApkInformationAddSrcFeature;

    @BindView
    EditText upEditApkInformationGameName;

    @BindView
    RadioGroup upEditApkInformationLanguage;

    @BindView
    TextView upEditApkInformationShowStatus;

    @BindView
    CustomTextView upEditApkInformationSuggestion;

    @BindView
    TextView upEditApkInformationTopBack;

    @BindView
    LinearLayout upEditApkInformationTopLayout;

    @BindView
    TextView upEditApkInformationTopSubmit;

    @BindView
    EditText upEditSetDownloadCoinsEt;

    @BindView
    RelativeLayout upEditSetDownloadCoinsLv;
    private DialogForProgressTip v;
    private UpApkDetailsBean.DataBean w;
    private com.rtk.app.main.dialogPack.b0 x;
    private ArrayAdapter<UpGameTypeBean.DataBean> z;
    private List<UpServiceUpImgBean.PathBean> u = new ArrayList();
    private List<UpGameTypeBean.DataBean> y = new ArrayList();
    private boolean A = false;
    private Bitmap F = null;
    private int I = 0;
    private Handler M = new a();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            UpEditApkInformationActivity.this.P(((UpServiceUpImgBean) message.obj).getPath());
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements UpEditProgressHeadHolder.c {
        b() {
        }

        @Override // com.rtk.app.main.UpModule.UpHolderTool.UpEditProgressHeadHolder.c
        public void a() {
        }

        @Override // com.rtk.app.main.UpModule.UpHolderTool.UpEditProgressHeadHolder.c
        public void b(String str) {
            EditText editText = UpEditApkInformationActivity.this.upEditApkInformationGameName;
            if (editText == null) {
                return;
            }
            editText.setText(str);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements AdapterView.OnItemSelectedListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            UpEditApkInformationActivity upEditApkInformationActivity = UpEditApkInformationActivity.this;
            upEditApkInformationActivity.C = ((UpGameTypeBean.DataBean) upEditApkInformationActivity.y.get(i)).getId();
            UpEditApkInformationActivity upEditApkInformationActivity2 = UpEditApkInformationActivity.this;
            upEditApkInformationActivity2.D = ((UpGameTypeBean.DataBean) upEditApkInformationActivity2.y.get(i)).getTitle();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(UpServiceUpImgBean.PathBean pathBean) {
        try {
            View inflate = LayoutInflater.from(this.f147c).inflate(R.layout.edit_picture_item_layout, (ViewGroup) null);
            ViewGroup.LayoutParams layoutParams = this.upEditApkInformationAddPhoto.getLayoutParams();
            inflate.setLayoutParams(new ViewGroup.MarginLayoutParams(layoutParams.width, layoutParams.height));
            ImageView imageView = (ImageView) inflate.findViewById(R.id.edit_picture_img);
            ((ImageView) inflate.findViewById(R.id.edit_picture_delete)).setOnClickListener(this);
            imageView.setImageBitmap(this.F);
            com.rtk.app.tool.t.c(this.f147c, pathBean.getUrl() + pathBean.getPic(), imageView, new boolean[0]);
            this.upEditApkInformationAddPhotoLv.addView(inflate, this.upEditApkInformationAddPhotoLv.getChildCount() + (-1));
            if (this.upEditApkInformationAddPhotoLv.getChildCount() == 7) {
                this.upEditApkInformationAddPhotoLv.removeView(this.upEditApkInformationAddPhoto);
            }
        } catch (Exception unused) {
            com.rtk.app.tool.f.a(this.f147c, "图片过大，请重新选择！", f.a.f);
        }
    }

    private void S() {
        this.N.getData();
        String family_id = this.N.getData().getFamily_id();
        HashMap<String, String> l = com.rtk.app.tool.y.l();
        if (TextUtils.isEmpty(family_id)) {
            family_id = "0";
        }
        l.put("family_id", family_id);
        l.put("key", com.rtk.app.tool.t.L(l));
        com.rtk.app.tool.o.h.l(this.f147c, this, 5, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(com.rtk.app.tool.y.w("user/up/set-coin-check", l)));
    }

    private void T(UpApkCheakDetailsNeedBean.DataBean dataBean) {
        this.upEditApkInformationAddApkType.setOnCheckedChangeListener(null);
        this.B = Integer.parseInt(dataBean.getType());
        R(4);
        S();
        if (this.B == 0) {
            this.upEditApkInformationAddApkTypeGame.setChecked(true);
        } else {
            this.upEditApkInformationAddApkTypeSoft.setChecked(true);
        }
        this.upEditApkInformationAddApkType.setOnCheckedChangeListener(this.O);
        this.upEditApkInformationGameName.setText(dataBean.getVarName());
        this.upEditApkInformationAddSrcFeature.setText(dataBean.getSourceCharacteristic());
        this.upEditApkInformationAddSrcDescription.setText(dataBean.getSourceDescription());
        List<String> d = com.rtk.app.tool.c0.d(dataBean.getSourcePic(), "\\|");
        for (int i = 0; i < d.size(); i++) {
            UpServiceUpImgBean.PathBean pathBean = new UpServiceUpImgBean.PathBean();
            pathBean.setPic(d.get(i));
            pathBean.setThumb(d.get(i));
            pathBean.setUrl(dataBean.getSourceUrl());
            this.u.add(pathBean);
            P(pathBean);
        }
        this.upEditApkInformationLanguage.removeAllViews();
        int sourceLang = dataBean.getSourceLang();
        boolean z = false;
        for (String str : dataBean.getLang().keySet()) {
            String str2 = dataBean.getLang().get(str);
            RadioButton radioButton = new RadioButton(this.f147c);
            radioButton.setLayoutParams(new RadioGroup.LayoutParams(-2, -2));
            radioButton.setText(str2);
            this.upEditApkInformationLanguage.addView(radioButton);
            if (str.equals("" + sourceLang)) {
                radioButton.setChecked(true);
                z = true;
            }
        }
        if (!z) {
            RadioGroup radioGroup = this.upEditApkInformationLanguage;
            radioGroup.check(radioGroup.getChildAt(0).getId());
        }
        int viewPermissions = dataBean.getViewPermissions();
        this.I = viewPermissions;
        this.upEditApkInformationShowStatus.setText(com.rtk.app.tool.t.W(viewPermissions));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V(String[] strArr) {
        if (strArr.length != 0 && strArr[0].equals("true")) {
            this.S.q();
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X(String[] strArr) {
        R(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z(RadioGroup radioGroup, int i) {
        this.A = true;
        if (radioGroup.getCheckedRadioButtonId() == 2131300854) {
            this.B = 0;
        } else {
            this.B = 1;
        }
        com.rtk.app.tool.c0.u("UpEditApkInformationActivity", "当前type值" + this.B);
        R(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b0(RadioGroup radioGroup, int i) {
        int i2 = i % 3;
        this.E = i2 != 0 ? i2 : 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d0(String[] strArr) {
        this.v.show();
        R(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f0(String[] strArr) {
        this.I = Integer.parseInt(strArr[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void g0() {
        String str = "";
        String str2 = "";
        String str3 = str2;
        for (int i = 0; i < this.u.size(); i++) {
            if (i != 0) {
                str3 = str3 + "|";
                str2 = str2 + "|";
            }
            str2 = str2 + this.u.get(i).getPic();
            str3 = str3 + this.u.get(i).getThumb();
        }
        Map<String, String> k = com.rtk.app.main.UpModule.UpControlPack.b.k(com.rtk.app.tool.g.f.e(this.f147c).i(this.S.g));
        UpApkCheakDetailsNeedBean.DataBean data = this.N.getData();
        k.put("sid", data.getId());
        k.put("channel", com.rtk.app.tool.y.m(this.f147c, getPackageName()));
        k.put("version", com.rtk.app.tool.y.i(this.f147c));
        k.put(ak.aj, com.rtk.app.tool.y.g());
        k.put("phone_model", com.rtk.app.tool.y.T());
        k.put("uid", com.rtk.app.tool.y.K());
        k.put("token", com.rtk.app.tool.y.H());
        k.put(com.umeng.analytics.pro.d.y, this.B + "");
        k.put("tags", this.C);
        if (TextUtils.isEmpty(k.get("sourceName"))) {
            k.put("sourceName", data.getSourceName());
        }
        k.put("varName", this.r);
        k.put("sourceDescription", this.t);
        k.put("sourcePic", str2);
        k.put("sourceLang", this.E + "");
        k.put("sourceCharacteristic", this.s);
        k.put("viewPermissions", this.I + "");
        k.put("family_id", TextUtils.isEmpty(data.getFamily_id()) ? "0" : data.getFamily_id());
        String obj = this.upEditSetDownloadCoinsEt.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            obj = data.getNeedCoin();
        }
        k.put("needCoin", obj);
        k.put("key", com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "sid=" + data.getId()))));
        for (String str4 : k.keySet()) {
            str = str + "   " + str4 + "  " + k.get(str4) + UMCustomLogInfoBuilder.LINE_SEP;
        }
        com.rtk.app.tool.c0.r("UpEditApkInformationActivity", "上传数据 upApkMap---\n" + str);
        com.rtk.app.tool.o.h.j(this.f147c, this, com.rtk.app.tool.y.e + "up/save/edit", 6, k);
    }

    private void h0() {
        this.x.show();
        List<String> list = this.G;
        if (list != null && list.size() > 0) {
            this.H = new File(this.G.get(0));
            R(2);
            this.G.remove(0);
            return;
        }
        this.x.dismiss();
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.upEditApkInformationTopLayout, null, null, ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0));
    }

    public void Q() {
        if (!this.S.m()) {
            this.S.q();
            finish();
        } else {
            new DialogTipsForCallBack(this.f147c, "文件正在上传中，确定退出吗。", new com.rtk.app.tool.s() { // from class: com.rtk.app.main.UpModule.w0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    UpEditApkInformationActivity.this.V(strArr);
                }
            }).show();
        }
    }

    public void R(int... iArr) {
        int i = iArr[0];
        String str = "";
        if (i == 2) {
            com.rtk.app.tool.o.h.v(this.f147c, new com.rtk.app.custom.RichEditText.a.f(com.rtk.app.tool.y.K(), com.rtk.app.tool.y.H(), MainActivity.p.getData().getLevel() + "", this, com.rtk.app.tool.y.i + "html/filelist/uploadBbsImg", iArr[0], this.H, "toUp"), new boolean[0]);
            return;
        }
        if (i != 3) {
            if (i == 4) {
                str = "members/sourceType" + com.rtk.app.tool.y.u(this.f147c) + "&type=" + this.B + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, new String[0])));
            } else if (i == 6) {
                g0();
                return;
            }
            com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(str));
            com.rtk.app.tool.c0.u("UpEditApkInformationActivity", "审核页面" + com.rtk.app.tool.y.d + str);
            return;
        }
        G(null, this.upEditApkInformationTopLayout);
        StringBuilder sb = new StringBuilder();
        sb.append("up/detail/edit");
        sb.append(com.rtk.app.tool.y.u(this.f147c));
        sb.append("&sid=");
        sb.append(this.w.getId());
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "sid=" + this.w.getId()))));
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb.toString()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("UpEditApkInformationActivity", i + "  返回数据  " + str);
        if (i == 2) {
            UpServiceUpImgBean upServiceUpImgBean = (UpServiceUpImgBean) this.g.fromJson(str, UpServiceUpImgBean.class);
            this.u.add(upServiceUpImgBean.getPath());
            Message message = new Message();
            message.what = 1;
            message.obj = upServiceUpImgBean;
            this.M.sendMessage(message);
            h0();
            return;
        }
        if (i == 3) {
            F();
            UpApkCheakDetailsNeedBean upApkCheakDetailsNeedBean = (UpApkCheakDetailsNeedBean) this.g.fromJson(str, UpApkCheakDetailsNeedBean.class);
            this.N = upApkCheakDetailsNeedBean;
            T(upApkCheakDetailsNeedBean.getData());
            return;
        }
        if (i == 4) {
            com.rtk.app.tool.c0.u("UpEditApkInformationActivity", "  上传游戏的类型列表   " + str);
            UpGameTypeBean upGameTypeBean = (UpGameTypeBean) this.g.fromJson(str, UpGameTypeBean.class);
            this.y.clear();
            this.y.addAll(upGameTypeBean.getData());
            this.z.notifyDataSetChanged();
            if (this.A) {
                if (!this.y.isEmpty()) {
                    this.upEditApkInformationAddApkTags.setSelection(0);
                    this.C = this.y.get(0).getId();
                }
                this.upEditApkInformationAddApkTags.performClick();
            } else {
                int i2 = 0;
                for (int i3 = 0; i3 < this.y.size(); i3++) {
                    if (this.y.get(i3).getId().equals(this.N.getData().getTags())) {
                        i2 = i3;
                    }
                }
                this.upEditApkInformationAddApkTags.setSelection(i2);
            }
            this.A = false;
            return;
        }
        if (i != 5) {
            if (i != 6) {
                return;
            }
            this.v.dismiss();
            this.P = new Intent();
            Bundle bundle = new Bundle();
            this.Q = bundle;
            bundle.putBoolean("isUpdate", true);
            this.P.putExtras(this.Q);
            setResult(1015, this.P);
            finish();
            return;
        }
        if (!"0".equals(this.N.getData().getFamily_id())) {
            this.upEditApkInfoShowStatusLv.setVisibility(8);
        } else {
            this.upEditApkInfoShowStatusLv.setVisibility(0);
        }
        String needCoin = this.N.getData().getNeedCoin();
        if (TextUtils.isEmpty(needCoin)) {
            needCoin = "0";
        }
        int parseInt = Integer.parseInt(needCoin);
        com.rtk.app.tool.c0.r("UpEditApkInformationActivity", com.rtk.app.c.a.b(str));
        UserUpSetCoinCheckBean userUpSetCoinCheckBean = (UserUpSetCoinCheckBean) this.g.fromJson(str, UserUpSetCoinCheckBean.class);
        this.J = userUpSetCoinCheckBean.getData().getMaxCoin();
        int minCoin = userUpSetCoinCheckBean.getData().getMinCoin();
        this.K = minCoin;
        int i4 = this.J;
        if (i4 < 0 || minCoin < 0) {
            this.upEditSetDownloadCoinsLv.setVisibility(8);
            return;
        }
        if (minCoin <= i4) {
            if (parseInt == i4 && parseInt == 0) {
                this.upEditSetDownloadCoinsLv.setVisibility(8);
                return;
            }
            this.upEditSetDownloadCoinsLv.setVisibility(0);
            this.upEditSetDownloadCoinsEt.setHint("已设置" + this.N.getData().getNeedCoin() + "（可设置" + ((this.J == 0 && this.K == 0) ? "0" : this.K + "-" + this.J) + "金币）");
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("UpEditApkInformationActivity", "mark" + i2 + "   " + str);
        com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
        if (i2 != 1) {
            if (i2 != 3) {
                if (i2 == 4) {
                    this.A = false;
                    return;
                } else if (i2 != 5) {
                    if (i2 != 6) {
                        return;
                    }
                    com.rtk.app.tool.f.a(this.f147c, "审核状态修改成功，资源详情修改失败", f.a.f);
                    this.v.dismiss();
                    return;
                }
            }
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.UpModule.x0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    UpEditApkInformationActivity.this.X(strArr);
                }
            });
            return;
        }
        this.upEditApkInformationTopSubmit.setEnabled(true);
        this.v.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        this.w = (UpApkDetailsBean.DataBean) getIntent().getExtras().getSerializable("upApkDetailsBean");
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() { // from class: com.rtk.app.main.UpModule.t0
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                UpEditApkInformationActivity.this.Z(radioGroup, i);
            }
        };
        this.O = onCheckedChangeListener;
        this.upEditApkInformationAddApkType.setOnCheckedChangeListener(onCheckedChangeListener);
        this.upEditApkInformationAddApkTags.setOnItemSelectedListener(new c());
        this.upEditApkInformationLanguage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.rtk.app.main.UpModule.u0
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                UpEditApkInformationActivity.this.b0(radioGroup, i);
            }
        });
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.x = new com.rtk.app.main.dialogPack.b0(this.f147c);
        ArrayAdapter<UpGameTypeBean.DataBean> arrayAdapter = new ArrayAdapter<>((Context) this.f147c, android.R.layout.simple_spinner_dropdown_item, this.y);
        this.z = arrayAdapter;
        this.upEditApkInformationAddApkTags.setAdapter((SpinnerAdapter) arrayAdapter);
        R(3);
        this.v = new DialogForProgressTip(this.f147c, "提交中，请稍后……");
        this.S = new UpEditProgressHeadHolder(this.f147c, this.upEditApkHolderView, this.w, new b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        UpEditProgressHeadHolder upEditProgressHeadHolder;
        super.onActivityResult(i, i2, intent);
        try {
            if (i == 112) {
                if (i2 == -1) {
                    this.F = BitmapFactory.decodeStream(getContentResolver().openInputStream(intent.getData()));
                    R(2);
                    return;
                }
                return;
            }
            if (i != 115) {
                if (i == 1012 && i2 == 1014 && (upEditProgressHeadHolder = this.S) != null) {
                    upEditProgressHeadHolder.r(intent);
                    return;
                }
                return;
            }
            if (i2 == -1) {
                this.G = new ArrayList();
                List<com.luck.picture.lib.f.b> d = com.luck.picture.lib.b.d(intent);
                this.G.clear();
                for (com.luck.picture.lib.f.b bVar : d) {
                    com.rtk.app.tool.c0.u("UpEditApkInformationActivity", "选择图片的地址" + bVar.f());
                    this.G.add(bVar.f());
                }
                h0();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override // com.rtk.app.custom.SwipeBackActivity
    public void onBackPressed() {
        Q();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit_picture_delete /* 2131297490 */:
                try {
                    int indexOfChild = this.upEditApkInformationAddPhotoLv.indexOfChild((View) view.getParent());
                    com.rtk.app.tool.c0.u("UpEditApkInformationActivity", " 删除的位置  position" + indexOfChild);
                    this.u.remove(indexOfChild);
                    this.upEditApkInformationAddPhotoLv.removeViewAt(indexOfChild);
                    FlowLayout parent = this.upEditApkInformationAddPhoto.getParent();
                    FlowLayout flowLayout = this.upEditApkInformationAddPhotoLv;
                    if (parent != flowLayout) {
                        flowLayout.addView(this.upEditApkInformationAddPhoto);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    com.rtk.app.tool.c0.u("UpEditApkInformationActivity", "删除错误1");
                    return;
                }
            case R.id.up_edit_apk_information_add_photo /* 2131300855 */:
                if (!com.rtk.app.tool.r.b(this.f147c) || this.u.size() >= 6) {
                    return;
                }
                com.rtk.app.tool.t.E1(this.f147c, 6 - this.u.size(), false);
                return;
            case R.id.up_edit_apk_information_show_status_lv /* 2131300862 */:
                if (this.q == null) {
                    this.q = new DialogForPublishUpSrcShowShatus(this.f147c, this.I, this.upEditApkInformationShowStatus, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.UpModule.y0
                        @Override // com.rtk.app.tool.s
                        public final void a(String[] strArr) {
                            UpEditApkInformationActivity.this.f0(strArr);
                        }
                    });
                }
                this.q.show();
                return;
            case R.id.up_edit_apk_information_top_back /* 2131300864 */:
                Q();
                return;
            case R.id.up_edit_apk_information_top_submit /* 2131300866 */:
                this.r = this.upEditApkInformationGameName.getText().toString().trim();
                this.s = this.upEditApkInformationAddSrcFeature.getText().toString().trim();
                String trim = this.upEditApkInformationAddSrcDescription.getText().toString().trim();
                this.t = trim;
                if (com.rtk.app.tool.c0.q(this.r, trim)) {
                    com.rtk.app.tool.f.a(this.f147c, "必填信息为空", f.a.f);
                    return;
                }
                if (this.u.size() < 2) {
                    com.rtk.app.tool.f.a(this.f147c, "请至少上传两张图片", f.a.f);
                    return;
                }
                if (this.S.m() && this.S.k("") == null) {
                    com.rtk.app.tool.f.a(this.f147c, "请等待当前文件上传完成.", f.a.f);
                    return;
                }
                if (this.upEditSetDownloadCoinsLv.getVisibility() == 0) {
                    String obj = this.upEditSetDownloadCoinsEt.getText().toString();
                    if (TextUtils.isEmpty(obj)) {
                        String needCoin = this.N.getData().getNeedCoin();
                        if (TextUtils.isEmpty(needCoin)) {
                            this.L = 0;
                        } else {
                            this.L = Integer.parseInt(needCoin);
                        }
                    } else {
                        this.L = Integer.parseInt(obj);
                    }
                    int i = this.L;
                    if (i > this.J) {
                        com.rtk.app.tool.f.a(this.f147c, "金币设置数量不可超过" + this.J, f.a.f);
                        return;
                    }
                    if (i < this.K) {
                        com.rtk.app.tool.f.a(this.f147c, "金币设置数量不可小于" + this.K, f.a.f);
                        return;
                    }
                }
                if (this.R == null) {
                    this.R = new DialogForEnSure(this.f147c, "编辑UP后需要重新审核，确认提交编辑吗？", new com.rtk.app.tool.s() { // from class: com.rtk.app.main.UpModule.v0
                        @Override // com.rtk.app.tool.s
                        public final void a(String[] strArr) {
                            UpEditApkInformationActivity.this.d0(strArr);
                        }
                    });
                }
                this.R.show();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_up_edit_apk_information);
        ButterKnife.a(this);
    }
}
