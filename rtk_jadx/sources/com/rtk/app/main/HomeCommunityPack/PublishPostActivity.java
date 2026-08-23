package com.rtk.app.main.HomeCommunityPack;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.CommunityPostBean;
import com.rtk.app.bean.LoginBean;
import com.rtk.app.bean.MyAttentionBean;
import com.rtk.app.bean.PostDetailsBean;
import com.rtk.app.bean.TagsBean;
import com.rtk.app.custom.RichEditText.BaseRitchEdit;
import com.rtk.app.custom.RichEditText.PostModificationBean;
import com.rtk.app.custom.RichEditText.RichEditText;
import com.rtk.app.custom.RichEditText.UpSrcBean;
import com.rtk.app.main.Home5Activity.MyPostListActivity;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.dialogPack.DialogForPostTag;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.main.dialogPack.DialogJustEnsure;
import com.rtk.app.main.dialogPack.DialogPermision;
import com.rtk.app.main.dialogPack.DialogTipsForCallBack;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PublishPostActivity extends BaseActivity implements h.j {
    private String A;
    private List<TagsBean> C;
    private String D;
    private String E;

    @BindView
    TextView publishPostBack;

    @BindView
    ImageView publishPostInsertGame;

    @BindView
    ImageView publishPostInsertPhoto;

    @BindView
    ImageView publishPostInsertPost;

    @BindView
    ImageView publishPostInsertUpSrc;

    @BindView
    ImageView publishPostInsertUser;

    @BindView
    LinearLayout publishPostLayout;

    @BindView
    TextView publishPostRichEditNum;

    @BindView
    RichEditText publishPostRichEditText;

    @BindView
    ScrollView publishPostScrollView;

    @BindView
    TextView publishPostSelectorTag;

    @BindView
    CheckedTextView publishPostSetBold;

    @BindView
    CheckedTextView publishPostSetItalic;

    @BindView
    Spinner publishPostSetTextColor;

    @BindView
    Spinner publishPostSetTextSize;

    @BindView
    CheckedTextView publishPostSetUnderLine;

    @BindView
    ImageView publishPostSetVideo;

    @BindView
    TextView publishPostSubmit;

    @BindView
    EditText publishPostTitle;
    private String q;
    private DialogForPostTag s;
    private DialogForProgressTip t;
    private DialogForProgressTip w;
    private DialogJustEnsure x;
    PostDetailsBean.DataBean y;
    private String z;
    String[] r = {"#FF212121", "#FF878787", "#FFF64C4C", "#FF007AFF"};
    private int u = 5000;

    @SuppressLint({"HandlerLeak"})
    private Handler v = new a();
    private String B = "";

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i != 1) {
                if (i == 2 && PublishPostActivity.this.w != null) {
                    PublishPostActivity.this.w.show();
                    return;
                }
                return;
            }
            if (PublishPostActivity.this.publishPostRichEditText.getCurrentVideoNum() >= PublishPostActivity.this.publishPostRichEditText.getMaxVideoNum()) {
                PublishPostActivity.this.w = new DialogForProgressTip(PublishPostActivity.this.f147c, "处理中请稍后");
                int i2 = 0;
                PublishPostActivity.this.v.sendEmptyMessageDelayed(2, 200L);
                for (String labelString = PublishPostActivity.this.publishPostRichEditText.getLabelString(); labelString.contains("[/video]"); labelString = labelString.replaceFirst("[/video]", "")) {
                    i2++;
                }
                PublishPostActivity.this.publishPostRichEditText.setCurrentVideoNum(i2);
                if (PublishPostActivity.this.publishPostRichEditText.getCurrentVideoNum() < PublishPostActivity.this.publishPostRichEditText.getMaxVideoNum()) {
                    com.rtk.app.tool.t.F1(PublishPostActivity.this.f147c, 1);
                } else {
                    com.rtk.app.tool.f.a(PublishPostActivity.this.f147c, "您最多上传" + PublishPostActivity.this.publishPostRichEditText.getMaxVideoNum() + "个视频", f.a.f);
                }
                PublishPostActivity.this.w.dismiss();
                PublishPostActivity.this.w = null;
                return;
            }
            com.rtk.app.tool.t.F1(PublishPostActivity.this.f147c, 1);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements com.rtk.app.tool.s {
        b() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            if (strArr.length <= 0 || !strArr[0].equals("true")) {
                return;
            }
            PublishPostActivity publishPostActivity = PublishPostActivity.this;
            publishPostActivity.D = com.rtk.app.tool.v.d(publishPostActivity.f147c, com.rtk.app.tool.v.d);
            PublishPostActivity publishPostActivity2 = PublishPostActivity.this;
            publishPostActivity2.publishPostRichEditText.setTagStr(publishPostActivity2.E);
            PublishPostActivity publishPostActivity3 = PublishPostActivity.this;
            publishPostActivity3.publishPostTitle.setText(publishPostActivity3.D);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements AdapterView.OnItemSelectedListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i == 0) {
                PublishPostActivity.this.publishPostRichEditText.setFontSize(18);
            } else if (i == 1) {
                PublishPostActivity.this.publishPostRichEditText.setFontSize(16);
            } else {
                if (i != 2) {
                    return;
                }
                PublishPostActivity.this.publishPostRichEditText.setFontSize(14);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class d implements AdapterView.OnItemSelectedListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            PublishPostActivity publishPostActivity = PublishPostActivity.this;
            publishPostActivity.publishPostRichEditText.setFontColor(Color.parseColor(publishPostActivity.r[i]));
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class e implements BaseRitchEdit.a {
        e() {
        }

        @Override // com.rtk.app.custom.RichEditText.BaseRitchEdit.a
        public void a(com.rtk.app.custom.RichEditText.d dVar) {
            if (dVar.a) {
                PublishPostActivity.this.publishPostSetBold.setChecked(true);
            } else {
                PublishPostActivity.this.publishPostSetBold.setChecked(false);
            }
            if (dVar.b) {
                PublishPostActivity.this.publishPostSetItalic.setChecked(true);
            } else {
                PublishPostActivity.this.publishPostSetItalic.setChecked(false);
            }
            int i = 0;
            while (true) {
                String[] strArr = PublishPostActivity.this.r;
                if (i >= strArr.length) {
                    break;
                }
                if (dVar.f == Color.parseColor(strArr[i])) {
                    PublishPostActivity.this.publishPostSetTextColor.setSelection(i);
                    break;
                }
                i++;
            }
            int i2 = dVar.e;
            if (i2 == 14) {
                PublishPostActivity.this.publishPostSetTextSize.setSelection(2);
            } else if (i2 == 16) {
                PublishPostActivity.this.publishPostSetTextSize.setSelection(1);
            } else if (i2 == 18) {
                PublishPostActivity.this.publishPostSetTextSize.setSelection(0);
            }
            PublishPostActivity.this.publishPostSetUnderLine.setChecked(dVar.f170c);
        }

        @Override // com.rtk.app.custom.RichEditText.BaseRitchEdit.a
        public void b(int i, int i2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class f implements com.rtk.app.tool.s {
        f() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            PublishPostActivity.this.q = strArr[0];
            PublishPostActivity.this.publishPostSelectorTag.setText(strArr[1]);
            PublishPostActivity.this.s.dismiss();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class g implements com.rtk.app.tool.s {
        g() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            PublishPostActivity.this.x.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class h implements com.rtk.app.tool.s {
        h() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            if (strArr.length <= 0 || !strArr[0].equals("true")) {
                PublishPostActivity.super.finish();
                return;
            }
            PublishPostActivity publishPostActivity = PublishPostActivity.this;
            com.rtk.app.tool.v.h(publishPostActivity.f147c, com.rtk.app.tool.v.f333c, publishPostActivity.E);
            PublishPostActivity publishPostActivity2 = PublishPostActivity.this;
            com.rtk.app.tool.v.h(publishPostActivity2.f147c, com.rtk.app.tool.v.d, publishPostActivity2.D);
            PublishPostActivity.super.finish();
        }
    }

    private void Y() {
        List<TagsBean> list = this.C;
        if ((list == null || list.isEmpty()) && !TextUtils.isEmpty(this.z)) {
            this.q = "0";
            this.publishPostSelectorTag.setVisibility(8);
        }
        this.s = new DialogForPostTag(this.f147c, new f(), this.C);
        X();
        this.publishPostRichEditText.setTagStr(this.E);
        this.publishPostTitle.setText(this.D);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.publishPostLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void W(int... iArr) {
        int i = iArr[0];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            HashMap<String, String> k = com.rtk.app.tool.y.k();
            k.put("pid", this.B);
            k.put("di", com.rtk.app.tool.y.r(this.f147c));
            String z = com.rtk.app.tool.y.z("token");
            String z2 = com.rtk.app.tool.y.z("uid");
            k.put(z, com.rtk.app.tool.y.H());
            k.put(z2, com.rtk.app.tool.y.K());
            k.put("key", com.rtk.app.tool.t.L(k));
            com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(com.rtk.app.tool.y.w("bbs/detail", k)));
            return;
        }
        HashMap<String, String> l = com.rtk.app.tool.y.l();
        l.put("mid", this.A);
        l.put("$*$tags", this.q);
        l.put("$*$device_name", com.rtk.app.tool.y.p(this.f147c));
        l.put("$*$content", this.E);
        l.put("$*$os_version", com.rtk.app.tool.y.D());
        l.put("$*$pid", this.B);
        l.put("display_mode", "2");
        String str = com.rtk.app.tool.y.e + "bbs/posts-save";
        if (!TextUtils.isEmpty(this.z)) {
            l.put(com.rtk.app.tool.y.z("family_id"), this.z);
        }
        l.put("title", this.D);
        l.put("key", com.rtk.app.tool.t.L(l));
        l.put("diN", com.rtk.app.tool.y.r(MyApplication.b()));
        com.rtk.app.tool.o.h.j(this.f147c, this, str, iArr[0], l);
    }

    public void X() {
        LoginBean loginBean;
        LoginBean loginBean2 = MainActivity.p;
        if (loginBean2 != null && loginBean2.getData() != null && MainActivity.p.getData().getAuthority() != null && MainActivity.p.getData().getAuthority().getUploadVideo() <= MainActivity.p.getData().getLevel()) {
            this.publishPostSetVideo.setVisibility(0);
            return;
        }
        if (this.A.equals("14") && (loginBean = MainActivity.p) != null && loginBean.getData() != null && MainActivity.p.getData().getAuthority() != null && MainActivity.p.getData().getAuthority().getVideoZoneUpload() <= MainActivity.p.getData().getLevel()) {
            this.publishPostSetVideo.setVisibility(0);
        } else {
            this.publishPostSetVideo.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i == 1) {
            com.rtk.app.tool.c0.u("PublishPostActivity", "发表帖子   " + str);
            com.rtk.app.tool.f.a(this.f147c, "发布成功！", f.a.f);
            this.publishPostRichEditText.setText("");
            this.publishPostTitle.setText("");
            setResult(1);
            setResult(1000);
            com.rtk.app.tool.v.h(this.f147c, com.rtk.app.tool.v.f333c, "");
            com.rtk.app.tool.v.h(this.f147c, com.rtk.app.tool.v.d, "");
            com.rtk.app.tool.c.b(this.f147c, MyPostListActivity.class, null);
            finish();
            return;
        }
        if (i != 2) {
            return;
        }
        com.rtk.app.tool.c0.u("PublishPostActivity", "帖子详情   " + com.rtk.app.c.a.b(str));
        PostDetailsBean postDetailsBean = (PostDetailsBean) w(str, PostDetailsBean.class);
        if (postDetailsBean == null) {
            return;
        }
        PostDetailsBean.DataBean data = postDetailsBean.getData();
        this.y = data;
        this.A = data.getMid();
        PostDetailsBean.DataBean dataBean = this.y;
        if (dataBean == null) {
            return;
        }
        this.C = dataBean.getTags();
        this.D = this.y.getTitle();
        this.E = this.y.getOldContent();
        Y();
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        this.publishPostRichEditText.clearFocus();
        this.publishPostTitle.clearFocus();
        this.E = this.publishPostRichEditText.getLabelString();
        this.D = this.publishPostTitle.getText().toString().trim();
        if (!com.rtk.app.tool.c0.q(this.E)) {
            new DialogTipsForCallBack(this.f147c, "是否保存草稿", new h()).show();
        } else {
            super.finish();
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.t.dismiss();
        this.publishPostSubmit.setEnabled(true);
        this.publishPostSubmit.setClickable(true);
        com.rtk.app.tool.c0.u("PublishPostActivity", "发表帖子失败   " + str);
        com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        PostModificationBean postModificationBean;
        Bundle extras = getIntent().getExtras();
        if (extras == null || (postModificationBean = (PostModificationBean) extras.getSerializable("modificationBean")) == null) {
            return;
        }
        this.z = postModificationBean.getFamilyId();
        this.B = postModificationBean.getId();
        this.A = postModificationBean.getmId();
        this.C = postModificationBean.getTags();
        this.publishPostRichEditText.setControlView(this.publishPostSetBold, this.publishPostSetItalic, this.publishPostSetUnderLine);
        if (com.rtk.app.tool.c0.q(this.B)) {
            Y();
            String d2 = com.rtk.app.tool.v.d(this.f147c, com.rtk.app.tool.v.f333c);
            this.E = d2;
            if (!com.rtk.app.tool.c0.q(d2)) {
                new DialogTipsForCallBack(this.f147c, "是否加载草稿", new b()).show();
            }
        } else {
            W(2);
        }
        this.t = new DialogForProgressTip(this.f147c, "发布中，请稍后...");
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.publishPostSetTextSize.setOnItemSelectedListener(new c());
        this.publishPostSetTextColor.setOnItemSelectedListener(new d());
        this.publishPostRichEditText.setOnSelectChangeListener(new e());
        AppCompatEditText appCompatEditText = this.publishPostRichEditText;
        appCompatEditText.addTextChangedListener(new com.rtk.app.main.comment.g(appCompatEditText, this.u, this.publishPostRichEditNum, this.publishPostSubmit));
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.publishPostTitle.setText(com.rtk.app.tool.c0.q(this.D) ? "" : this.D);
        this.publishPostSetTextSize.setAdapter((SpinnerAdapter) new ArrayAdapter((Context) this.f147c, R.layout.simple_spinner_dropdown_item, (Object[]) new String[]{"大", "中", "小"}));
        this.publishPostSetTextSize.setSelection(1);
        this.publishPostSetTextColor.setAdapter((SpinnerAdapter) new ArrayAdapter((Context) this.f147c, R.layout.simple_spinner_dropdown_item, (Object[]) this.r));
        com.rtk.app.tool.t.B1(this.publishPostTitle, this.f147c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.rtk.app.tool.c0.u("PublishPostActivity", PointCategory.REQUEST + i + "   resultCode " + i2);
        try {
            if (i == 115) {
                if (i2 == -1) {
                    ArrayList arrayList = new ArrayList();
                    for (com.luck.picture.lib.f.b bVar : com.luck.picture.lib.b.d(intent)) {
                        com.rtk.app.tool.c0.u("PublishPostActivity", "选择图片的地址" + bVar.f());
                        arrayList.add(bVar.f());
                    }
                    this.publishPostRichEditText.setMoreBitMap(arrayList);
                    return;
                }
                return;
            }
            if (i == 116) {
                if (i2 == -1) {
                    ArrayList arrayList2 = new ArrayList();
                    for (com.luck.picture.lib.f.b bVar2 : com.luck.picture.lib.b.d(intent)) {
                        com.rtk.app.tool.c0.u("PublishPostActivity", "选择视频的地址" + bVar2.f());
                        MediaPlayer mediaPlayer = new MediaPlayer();
                        mediaPlayer.setDataSource(bVar2.f());
                        mediaPlayer.prepare();
                        int duration = mediaPlayer.getDuration();
                        LoginBean loginBean = MainActivity.p;
                        if (loginBean != null && loginBean.getData() != null && MainActivity.p.getData().getAuthority() != null) {
                            com.rtk.app.tool.y.C = MainActivity.p.getData().getAuthority().getVideoDuration();
                        }
                        if (duration > com.rtk.app.tool.y.C * 60 * 1000) {
                            DialogJustEnsure dialogJustEnsure = new DialogJustEnsure(this.f147c, "视频选择不得大于" + com.rtk.app.tool.y.C + "分钟!请重新选择。", new g());
                            this.x = dialogJustEnsure;
                            dialogJustEnsure.show();
                            return;
                        }
                        arrayList2.add(bVar2.f());
                        Intent intent2 = new Intent((Context) this.f147c, (Class<?>) UpProgressVideoIntroActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("from", 1000);
                        bundle.putString("videoPath", bVar2.f());
                        intent2.putExtras(bundle);
                        startActivityForResult(intent2, 1027);
                    }
                    return;
                }
                return;
            }
            if (i == 1001) {
                if (i2 == 1001) {
                    ApkInfo apkInfo = (ApkInfo) intent.getExtras().getSerializable("game");
                    this.publishPostRichEditText.setGame(new com.rtk.app.custom.RichEditText.f(apkInfo.getGameId() + "", apkInfo.getAppName()));
                    return;
                }
                return;
            }
            if (i == 1002) {
                if (i2 == 1002) {
                    ApkInfo apkInfo2 = (ApkInfo) intent.getExtras().getSerializable("upSrc");
                    this.publishPostRichEditText.setUpSrc(new UpSrcBean(apkInfo2.getUpGameId() + "", apkInfo2.getAppName()));
                    return;
                }
                return;
            }
            if (i == 1004) {
                if (i2 == 1004) {
                    this.publishPostRichEditText.setPost((CommunityPostBean.DataBean) intent.getExtras().getSerializable("post"));
                    return;
                }
                return;
            }
            if (i == 1005) {
                if (i2 == 1005) {
                    this.publishPostRichEditText.setUser((MyAttentionBean.DataBean) intent.getExtras().getSerializable("user"));
                    return;
                }
                return;
            }
            if (i == 1027 && i2 == 1027) {
                Bundle extras = intent.getExtras();
                String string = extras.getString("previewUrl");
                String string2 = extras.getString("videoUrl");
                int i3 = extras.getInt("videoId");
                com.rtk.app.tool.c0.u("PublishPostActivity", "视频截图地址" + string);
                this.publishPostRichEditText.setVideo(i3, string, string2);
            }
        } catch (IndexOutOfBoundsException e2) {
            com.rtk.app.tool.c0.u("PublishPostActivity", "异常" + e2);
            com.rtk.app.tool.f.a(this.f147c, "插入异常，换个位置再试一次", f.a.f);
            this.publishPostRichEditText.setSelection(0);
        } catch (Exception e3) {
            com.rtk.app.tool.c0.u("PublishPostActivity", "异常" + e3);
            com.rtk.app.tool.f.a(this.f147c, "异常" + e3.toString(), f.a.f);
            this.publishPostRichEditText.setSelection(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.publish_post_back /* 2131299941 */:
                finish();
                return;
            case com.rtk.app.R.id.publish_post_insert_game /* 2131299942 */:
                Intent intent = new Intent((Context) this.f147c, (Class<?>) PostSelectGameActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("from", 1000);
                intent.putExtras(bundle);
                startActivityForResult(intent, 1001);
                return;
            case com.rtk.app.R.id.publish_post_insert_photo /* 2131299943 */:
                if (com.rtk.app.tool.r.b(this.f147c)) {
                    com.rtk.app.tool.t.E1(this.f147c, 9, false);
                    return;
                }
                return;
            case com.rtk.app.R.id.publish_post_insert_post /* 2131299944 */:
                Intent intent2 = new Intent((Context) this.f147c, (Class<?>) PostSelectPostActivity.class);
                Bundle bundle2 = new Bundle();
                bundle2.putInt("from", 1000);
                intent2.putExtras(bundle2);
                startActivityForResult(intent2, 1004);
                return;
            case com.rtk.app.R.id.publish_post_insert_up_src /* 2131299945 */:
                Intent intent3 = new Intent((Context) this.f147c, (Class<?>) PostSelectUpSrcActivity.class);
                Bundle bundle3 = new Bundle();
                bundle3.putInt("from", 1000);
                intent3.putExtras(bundle3);
                startActivityForResult(intent3, 1002);
                return;
            case com.rtk.app.R.id.publish_post_insert_user /* 2131299946 */:
                Intent intent4 = new Intent((Context) this.f147c, (Class<?>) PostSelectUserActivity.class);
                Bundle bundle4 = new Bundle();
                bundle4.putInt("from", 1000);
                intent4.putExtras(bundle4);
                startActivityForResult(intent4, 1005);
                return;
            case com.rtk.app.R.id.publish_post_layout /* 2131299947 */:
            case com.rtk.app.R.id.publish_post_richEditNum /* 2131299948 */:
            case com.rtk.app.R.id.publish_post_richEditText /* 2131299949 */:
            case com.rtk.app.R.id.publish_post_scrollView /* 2131299951 */:
            case com.rtk.app.R.id.publish_post_set_textColor /* 2131299955 */:
            case com.rtk.app.R.id.publish_post_set_textSize /* 2131299956 */:
            default:
                return;
            case com.rtk.app.R.id.publish_post_save_txt /* 2131299950 */:
                this.E = this.publishPostRichEditText.getLabelString();
                this.D = this.publishPostTitle.getText().toString().trim();
                com.rtk.app.tool.v.h(this.f147c, com.rtk.app.tool.v.f333c, this.E);
                com.rtk.app.tool.v.h(this.f147c, com.rtk.app.tool.v.d, this.D);
                com.rtk.app.tool.f.a(this.f147c, "已保存到草稿~", f.a.f);
                return;
            case com.rtk.app.R.id.publish_post_selector_tag /* 2131299952 */:
                this.s.show();
                return;
            case com.rtk.app.R.id.publish_post_set_bold /* 2131299953 */:
                boolean z = !this.publishPostSetBold.isChecked();
                this.publishPostSetBold.setChecked(z);
                this.publishPostRichEditText.setBold(z);
                return;
            case com.rtk.app.R.id.publish_post_set_italic /* 2131299954 */:
                boolean z2 = !this.publishPostSetItalic.isChecked();
                this.publishPostSetItalic.setChecked(z2);
                this.publishPostRichEditText.setItalic(z2);
                return;
            case com.rtk.app.R.id.publish_post_set_underLine /* 2131299957 */:
                boolean z3 = !this.publishPostSetUnderLine.isChecked();
                this.publishPostSetUnderLine.setChecked(z3);
                this.publishPostRichEditText.setUnderline(z3);
                return;
            case com.rtk.app.R.id.publish_post_set_video /* 2131299958 */:
                if (com.rtk.app.tool.r.b(this.f147c)) {
                    this.v.sendEmptyMessage(1);
                    return;
                }
                return;
            case com.rtk.app.R.id.publish_post_submit /* 2131299959 */:
                this.publishPostSubmit.setEnabled(false);
                this.publishPostSubmit.setClickable(false);
                this.E = this.publishPostRichEditText.getLabelString();
                com.rtk.app.tool.c0.u("PublishPostActivity", "替换之前" + this.E);
                String replaceAll = this.E.replaceAll("\\[img\\]图片\\[/img\\]", "");
                this.E = replaceAll;
                com.rtk.app.tool.v.h(this.f147c, "SharedPreferencesUtilsTest", replaceAll);
                this.D = this.publishPostTitle.getText().toString().trim();
                if (com.rtk.app.tool.c0.q(this.q)) {
                    com.rtk.app.tool.f.a(this.f147c, "请选择标签", f.a.f);
                    this.s.show();
                    this.publishPostSubmit.setEnabled(true);
                    this.publishPostSubmit.setClickable(true);
                } else if (!com.rtk.app.tool.c0.q(this.D, this.E) && this.D.length() <= 32 && this.D.length() >= 2) {
                    this.t.show();
                    W(1);
                } else {
                    this.publishPostSubmit.setEnabled(true);
                    this.publishPostSubmit.setClickable(true);
                    com.rtk.app.tool.f.a(this.f147c, "标题或内容不可为空,且标题长度为2-32个字", 200);
                }
                com.rtk.app.tool.c0.u("PublishPostActivity", "   发表帖子的内容  " + this.E);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_publish_post);
        ButterKnife.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 10001) {
            return;
        }
        for (int i2 : iArr) {
            if (i2 != 0) {
                DialogPermision dialogPermision = new DialogPermision(MyApplication.b(), com.rtk.app.tool.t.U(this));
                dialogPermision.d();
                dialogPermision.show();
                return;
            }
        }
    }
}
