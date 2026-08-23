package com.rtk.app.main.UpModule;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.UpApkCheakDetailsNeedBean;
import com.rtk.app.bean.UpGameTypeBean;
import com.rtk.app.bean.UpServiceUpImgBean;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import com.zhy.view.flowlayout.FlowLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpSrcApkInformationForAdministratorActivity extends BaseActivity implements h.j {
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private DialogForProgressTip G;
    private int H;
    private File J;
    private String K;
    private List<String> r;
    private com.rtk.app.main.dialogPack.b0 s;
    private int u;

    @BindView
    Spinner upApkCheackDetailsAddApkTags;

    @BindView
    RadioGroup upApkCheackDetailsAddApkType;

    @BindView
    RadioButton upApkCheackDetailsAddApkTypeGame;

    @BindView
    RadioButton upApkCheackDetailsAddApkTypeSoft;

    @BindView
    ImageView upApkCheackDetailsAddPhoto;

    @BindView
    FlowLayout upApkCheackDetailsAddPhotoLv;

    @BindView
    EditText upApkCheackDetailsAddSrcDescription;

    @BindView
    EditText upApkCheackDetailsAddSrcFeature;

    @BindView
    EditText upApkCheackDetailsGameName;

    @BindView
    RadioGroup upApkCheackDetailsLanguage;

    @BindView
    LinearLayout upApkCheackDetailsListTypeListLv;

    @BindView
    LinearLayout upApkCheckDetailsPageParentLayout;

    @BindView
    TextView upApkCheckDetailsPageTopBack;

    @BindView
    LinearLayout upApkCheckDetailsPageTopLayout;

    @BindView
    TextView upApkCheckDetailsPageTopSubmit;
    private ArrayAdapter<UpGameTypeBean.DataBean> w;
    private UpApkCheakDetailsNeedBean x;
    private RadioGroup.OnCheckedChangeListener y;
    private Bitmap q = null;
    private List<UpServiceUpImgBean.PathBean> t = new ArrayList();
    private List<UpGameTypeBean.DataBean> v = new ArrayList();
    private boolean z = false;
    private Handler F = new a();
    private String I = "";

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
            UpSrcApkInformationForAdministratorActivity.this.U(((UpServiceUpImgBean) message.obj).getPath());
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements RadioGroup.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            UpSrcApkInformationForAdministratorActivity.this.z = true;
            if (radioGroup.getCheckedRadioButtonId() == 2131300580) {
                UpSrcApkInformationForAdministratorActivity.this.u = 0;
            } else {
                UpSrcApkInformationForAdministratorActivity.this.u = 1;
            }
            com.rtk.app.tool.c0.u("UpSrcApkInformationForAdministratorActivity", "当前type值" + UpSrcApkInformationForAdministratorActivity.this.u);
            UpSrcApkInformationForAdministratorActivity.this.V(4);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements AdapterView.OnItemSelectedListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            UpSrcApkInformationForAdministratorActivity upSrcApkInformationForAdministratorActivity = UpSrcApkInformationForAdministratorActivity.this;
            upSrcApkInformationForAdministratorActivity.A = ((UpGameTypeBean.DataBean) upSrcApkInformationForAdministratorActivity.v.get(i)).getId();
            UpSrcApkInformationForAdministratorActivity upSrcApkInformationForAdministratorActivity2 = UpSrcApkInformationForAdministratorActivity.this;
            upSrcApkInformationForAdministratorActivity2.B = ((UpGameTypeBean.DataBean) upSrcApkInformationForAdministratorActivity2.v.get(i)).getTitle();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class d implements RadioGroup.OnCheckedChangeListener {
        d() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            com.rtk.app.tool.c0.u("UpSrcApkInformationForAdministratorActivity", "当前语言选择" + i);
            int i2 = i % 3;
            UpSrcApkInformationForAdministratorActivity.this.H = i2 != 0 ? i2 : 3;
            com.rtk.app.tool.c0.u("UpSrcApkInformationForAdministratorActivity", "languageType" + UpSrcApkInformationForAdministratorActivity.this.H);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class e implements com.rtk.app.tool.s {
        e() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            UpSrcApkInformationForAdministratorActivity.this.V(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(UpServiceUpImgBean.PathBean pathBean) {
        try {
            View inflate = LayoutInflater.from(this.f147c).inflate(R.layout.edit_picture_item_layout, (ViewGroup) null);
            ViewGroup.LayoutParams layoutParams = this.upApkCheackDetailsAddPhoto.getLayoutParams();
            inflate.setLayoutParams(new ViewGroup.MarginLayoutParams(layoutParams.width, layoutParams.height));
            ImageView imageView = (ImageView) inflate.findViewById(R.id.edit_picture_img);
            ((ImageView) inflate.findViewById(R.id.edit_picture_delete)).setOnClickListener(this);
            imageView.setImageBitmap(this.q);
            com.rtk.app.tool.t.c(this.f147c, pathBean.getUrl() + pathBean.getPic(), imageView, new boolean[0]);
            this.upApkCheackDetailsAddPhotoLv.addView(inflate, this.upApkCheackDetailsAddPhotoLv.getChildCount() + (-1));
            if (this.upApkCheackDetailsAddPhotoLv.getChildCount() == 7) {
                this.upApkCheackDetailsAddPhotoLv.removeView(this.upApkCheackDetailsAddPhoto);
            }
        } catch (Exception unused) {
            com.rtk.app.tool.f.a(this.f147c, "图片过大，请重新选择！", f.a.f);
        }
    }

    private void W(UpApkCheakDetailsNeedBean.DataBean dataBean) {
        this.upApkCheackDetailsAddApkType.setOnCheckedChangeListener(null);
        this.u = Integer.parseInt(dataBean.getType());
        V(4);
        if (this.u == 0) {
            this.upApkCheackDetailsAddApkTypeGame.setChecked(true);
        } else {
            this.upApkCheackDetailsAddApkTypeSoft.setChecked(true);
        }
        this.upApkCheackDetailsAddApkType.setOnCheckedChangeListener(this.y);
        this.upApkCheackDetailsGameName.setText(dataBean.getVarName());
        this.upApkCheackDetailsAddSrcFeature.setText(dataBean.getSourceCharacteristic());
        this.upApkCheackDetailsAddSrcDescription.setText(dataBean.getSourceDescription());
        List<String> d2 = com.rtk.app.tool.c0.d(dataBean.getSourcePic(), "\\|");
        for (int i = 0; i < d2.size(); i++) {
            UpServiceUpImgBean.PathBean pathBean = new UpServiceUpImgBean.PathBean();
            pathBean.setPic(d2.get(i));
            pathBean.setThumb(d2.get(i));
            pathBean.setUrl(dataBean.getSourceUrl());
            this.t.add(pathBean);
            U(pathBean);
        }
        this.upApkCheackDetailsLanguage.removeAllViews();
        int sourceLang = dataBean.getSourceLang();
        boolean z = false;
        for (String str : dataBean.getLang().keySet()) {
            String str2 = dataBean.getLang().get(str);
            RadioButton radioButton = new RadioButton(this.f147c);
            radioButton.setLayoutParams(new RadioGroup.LayoutParams(-2, -2));
            radioButton.setText(str2);
            this.upApkCheackDetailsLanguage.addView(radioButton);
            if (str.equals("" + sourceLang)) {
                radioButton.setChecked(true);
                z = true;
            }
        }
        if (!z) {
            RadioGroup radioGroup = this.upApkCheackDetailsLanguage;
            radioGroup.check(radioGroup.getChildAt(0).getId());
        }
        this.upApkCheackDetailsListTypeListLv.removeAllViews();
        for (String str3 : dataBean.getListTypeList().keySet()) {
            String str4 = dataBean.getListTypeList().get(str3);
            CheckBox checkBox = new CheckBox(this.f147c);
            checkBox.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            checkBox.setText(str4);
            checkBox.setChecked(dataBean.getListType().contains(str3));
            com.rtk.app.tool.c0.u("UpSrcApkInformationForAdministratorActivity", "" + str3);
            this.upApkCheackDetailsListTypeListLv.addView(checkBox);
        }
    }

    private void X() {
        this.s.show();
        List<String> list = this.r;
        if (list != null && list.size() > 0) {
            this.J = new File(this.r.get(0));
            V(2);
            this.r.remove(0);
            return;
        }
        this.s.dismiss();
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.upApkCheckDetailsPageTopLayout, null, null, ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void V(int... iArr) {
        int i = iArr[0];
        String str = "";
        if (i != 2) {
            if (i == 3) {
                G(null, this.upApkCheckDetailsPageTopLayout);
                StringBuilder sb = new StringBuilder();
                sb.append("source/upSourceDetail");
                sb.append(com.rtk.app.tool.y.u(this.f147c));
                sb.append("&sid=");
                sb.append(this.K);
                sb.append("&key=");
                sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "sid=" + this.K))));
                str = sb.toString();
            } else if (i == 4) {
                str = "members/sourceType" + com.rtk.app.tool.y.u(this.f147c) + "&type=" + this.u + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, new String[0])));
            } else if (i == 6) {
                UpApkCheakDetailsNeedBean.DataBean data = this.x.getData();
                HashMap hashMap = new HashMap();
                hashMap.put("sid", data.getId());
                hashMap.put("channel", com.rtk.app.tool.y.m(this.f147c, getPackageName()));
                hashMap.put("version", com.rtk.app.tool.y.i(this.f147c));
                hashMap.put(ak.aj, com.rtk.app.tool.y.g());
                hashMap.put("phone_model", com.rtk.app.tool.y.T());
                hashMap.put("uid", com.rtk.app.tool.y.K());
                hashMap.put("token", com.rtk.app.tool.y.H());
                hashMap.put(com.umeng.analytics.pro.d.y, this.u + "");
                hashMap.put("tags", this.A);
                hashMap.put("sourceName", data.getSourceName());
                hashMap.put("varName", this.C);
                hashMap.put("sourceSize", data.getSourceSize());
                hashMap.put("sourceDescription", this.E);
                hashMap.put("md5", data.getMd5());
                hashMap.put("apkmd5", data.getApkmd5());
                hashMap.put("sourcePic", "");
                hashMap.put("sourceLang", this.H + "");
                hashMap.put("listType", this.I + "");
                hashMap.put("versionName", data.getVersionName());
                hashMap.put("versionCode", data.getVersionCode());
                hashMap.put("otherVersion", data.getOtherVersion());
                hashMap.put("packageName", data.getPackageName());
                hashMap.put("sourcePath", data.getSourcePath());
                hashMap.put("sourceCharacteristic", this.D);
                hashMap.put("deviceName", com.rtk.app.tool.y.p(this.f147c));
                hashMap.put("sha256", data.getSha256());
                hashMap.put("sourceLogo", data.getSourceLogo());
                hashMap.put("sha1", data.getSha1());
                hashMap.put(PointCategory.PERMISSION, data.getPermission());
                hashMap.put("targetVersion", data.getTargetVersion());
                hashMap.put("sdkVersion", data.getSdkVersion());
                hashMap.put("family_id", "0");
                hashMap.put("needCoin", "0");
                hashMap.put("key", com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "sourcePath=" + data.getSourcePath(), "varName=" + this.C, "apkmd5=" + data.getApkmd5()))));
                if (!com.rtk.app.tool.c0.q(data.getDataPath(), data.getZipmd5(), data.getDataSize())) {
                    hashMap.put("dataPath", data.getDataPath());
                    hashMap.put("zipmd5", data.getZipmd5());
                    hashMap.put("dataSize", data.getDataSize());
                }
                for (String str2 : hashMap.keySet()) {
                    str = str + "   " + str2 + "  " + ((String) hashMap.get(str2)) + UMCustomLogInfoBuilder.LINE_SEP;
                }
                com.rtk.app.tool.c0.u("UpSrcApkInformationForAdministratorActivity", "上传数据 upApkMap---\n" + str);
                com.rtk.app.tool.o.h.j(this.f147c, this, com.rtk.app.tool.y.e + "up/save/add", iArr[0], hashMap);
                return;
            }
            com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(str));
            com.rtk.app.tool.c0.u("UpSrcApkInformationForAdministratorActivity", "审核页面" + com.rtk.app.tool.y.d + str);
            return;
        }
        com.rtk.app.tool.o.h.v(this.f147c, new com.rtk.app.custom.RichEditText.a.f(com.rtk.app.tool.y.K(), com.rtk.app.tool.y.H(), MainActivity.p.getData().getLevel() + "", this, com.rtk.app.tool.y.i + "html/filelist/uploadBbsImg", iArr[0], this.J, "toUp"), new boolean[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("UpSrcApkInformationForAdministratorActivity", "审核页面" + i + "   " + str);
        if (i == 2) {
            UpServiceUpImgBean upServiceUpImgBean = (UpServiceUpImgBean) this.g.fromJson(str, UpServiceUpImgBean.class);
            this.t.add(upServiceUpImgBean.getPath());
            Message message = new Message();
            message.what = 1;
            message.obj = upServiceUpImgBean;
            this.F.sendMessage(message);
            X();
            return;
        }
        if (i == 3) {
            F();
            UpApkCheakDetailsNeedBean upApkCheakDetailsNeedBean = (UpApkCheakDetailsNeedBean) this.g.fromJson(str, UpApkCheakDetailsNeedBean.class);
            this.x = upApkCheakDetailsNeedBean;
            W(upApkCheakDetailsNeedBean.getData());
            return;
        }
        if (i != 4) {
            if (i != 6) {
                return;
            }
            this.G.dismiss();
            setResult(1011, new Intent());
            finish();
            return;
        }
        com.rtk.app.tool.c0.u("UpSrcApkInformationForAdministratorActivity", "  上传游戏的类型列表   " + str);
        UpGameTypeBean upGameTypeBean = (UpGameTypeBean) this.g.fromJson(str, UpGameTypeBean.class);
        this.v.clear();
        this.v.addAll(upGameTypeBean.getData());
        this.w.notifyDataSetChanged();
        if (this.z) {
            this.upApkCheackDetailsAddApkTags.performClick();
        } else {
            int i2 = 0;
            for (int i3 = 0; i3 < this.v.size(); i3++) {
                if (this.v.get(i3).getId().equals(this.x.getData().getTags())) {
                    i2 = i3;
                }
            }
            this.upApkCheackDetailsAddApkTags.setSelection(i2);
        }
        this.z = false;
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("UpSrcApkInformationForAdministratorActivity", "mark" + i2 + "   " + str);
        com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
        if (i2 == 1) {
            this.upApkCheckDetailsPageTopSubmit.setEnabled(true);
            this.G.dismiss();
        } else if (i2 == 6) {
            com.rtk.app.tool.f.a(this.f147c, "审核状态修改成功，资源详情修改失败", f.a.f);
            this.G.dismiss();
        } else if (i2 == 3) {
            I(str, new e());
        } else {
            if (i2 != 4) {
                return;
            }
            this.z = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        this.K = getIntent().getExtras().getString("sid");
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        b bVar = new b();
        this.y = bVar;
        this.upApkCheackDetailsAddApkType.setOnCheckedChangeListener(bVar);
        this.upApkCheackDetailsAddApkTags.setOnItemSelectedListener(new c());
        this.upApkCheackDetailsLanguage.setOnCheckedChangeListener(new d());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.w = new ArrayAdapter<>((Context) this.f147c, android.R.layout.simple_spinner_dropdown_item, (List) this.v);
        this.s = new com.rtk.app.main.dialogPack.b0(this.f147c);
        this.upApkCheackDetailsAddApkTags.setAdapter((SpinnerAdapter) this.w);
        V(3);
        this.G = new DialogForProgressTip(this.f147c, "提交中，请稍后……");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        try {
            if (i == 112) {
                if (i2 == -1) {
                    this.q = BitmapFactory.decodeStream(getContentResolver().openInputStream(intent.getData()));
                    V(2);
                    return;
                }
                return;
            }
            if (i == 115 && i2 == -1) {
                this.r = new ArrayList();
                List<com.luck.picture.lib.f.b> d2 = com.luck.picture.lib.b.d(intent);
                this.r.clear();
                for (com.luck.picture.lib.f.b bVar : d2) {
                    com.rtk.app.tool.c0.u("UpSrcApkInformationForAdministratorActivity", "选择图片的地址" + bVar.f());
                    this.r.add(bVar.f());
                }
                X();
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit_picture_delete /* 2131297490 */:
                try {
                    int indexOfChild = this.upApkCheackDetailsAddPhotoLv.indexOfChild((View) view.getParent());
                    com.rtk.app.tool.c0.u("UpSrcApkInformationForAdministratorActivity", " 删除的位置  position" + indexOfChild);
                    this.t.remove(indexOfChild);
                    this.upApkCheackDetailsAddPhotoLv.removeViewAt(indexOfChild);
                    FlowLayout parent = this.upApkCheackDetailsAddPhoto.getParent();
                    FlowLayout flowLayout = this.upApkCheackDetailsAddPhotoLv;
                    if (parent != flowLayout) {
                        flowLayout.addView(this.upApkCheackDetailsAddPhoto);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    com.rtk.app.tool.c0.u("UpSrcApkInformationForAdministratorActivity", "删除错误1");
                    return;
                }
            case R.id.up_apk_cheack_details_add_photo /* 2131300581 */:
                if (!com.rtk.app.tool.r.b(this.f147c) || this.t.size() >= 6) {
                    return;
                }
                com.rtk.app.tool.t.E1(this.f147c, 6 - this.t.size(), false);
                return;
            case R.id.up_apk_check_details_page_top_back /* 2131300589 */:
                finish();
                return;
            case R.id.up_apk_check_details_page_top_submit /* 2131300591 */:
                this.C = this.upApkCheackDetailsGameName.getText().toString().trim();
                this.D = this.upApkCheackDetailsAddSrcFeature.getText().toString().trim();
                this.E = this.upApkCheackDetailsAddSrcDescription.getText().toString().trim();
                for (int i = 0; i < this.upApkCheackDetailsListTypeListLv.getChildCount(); i++) {
                    if (((CheckBox) this.upApkCheackDetailsListTypeListLv.getChildAt(i)).isChecked()) {
                        if (com.rtk.app.tool.c0.q(this.I)) {
                            this.I = "" + (i + 1);
                        } else {
                            this.I += "," + (i + 1);
                        }
                    }
                }
                if (com.rtk.app.tool.c0.q(this.C, this.E)) {
                    com.rtk.app.tool.f.a(this.f147c, "必填信息为空", f.a.f);
                    return;
                } else if (this.t.size() < 2) {
                    com.rtk.app.tool.f.a(this.f147c, "请至少上传两张图片", f.a.f);
                    return;
                } else {
                    this.G.show();
                    V(6);
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
        setContentView(R.layout.activity_up_apk_check_details_page);
        ButterKnife.a(this);
    }
}
