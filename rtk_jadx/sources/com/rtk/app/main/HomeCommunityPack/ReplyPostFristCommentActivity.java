package com.rtk.app.main.HomeCommunityPack;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.CommunityPostBean;
import com.rtk.app.bean.MyAttentionBean;
import com.rtk.app.custom.RichEditText.BaseRitchEdit;
import com.rtk.app.custom.RichEditText.RichEditText;
import com.rtk.app.custom.RichEditText.UpSrcBean;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ReplyPostFristCommentActivity extends BaseActivity implements h.j {
    private String q;
    private Bitmap r;

    @BindView
    TextView replyPostFirstCommentBack;

    @BindView
    TextView replyPostFirstCommentEditNum;

    @BindView
    ImageView replyPostFirstCommentGame;

    @BindView
    RoundedImageView replyPostFirstCommentIcon;

    @BindView
    TextView replyPostFirstCommentNickName;

    @BindView
    ImageView replyPostFirstCommentPhoto;

    @BindView
    TextView replyPostFirstCommentPostTitle;

    @BindView
    RichEditText replyPostFirstCommentRichEditText;

    @BindView
    CheckedTextView replyPostFirstCommentSetBold;

    @BindView
    CheckedTextView replyPostFirstCommentSetItalic;

    @BindView
    Spinner replyPostFirstCommentSetTextColor;

    @BindView
    Spinner replyPostFirstCommentSetTextSize;

    @BindView
    CheckedTextView replyPostFirstCommentSetUnderLine;

    @BindView
    TextView replyPostFirstCommentSubmit;

    @BindView
    LinearLayout replyPostFirstCommentTopLayout;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private DialogForProgressTip z;
    String[] s = {"#FF212121", "#FF878787", "#FFF64C4C", "#FF007AFF"};
    private String y = "";
    private int A = f.a.f;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i == 0) {
                ReplyPostFristCommentActivity.this.replyPostFirstCommentRichEditText.setFontSize(18);
            } else if (i == 1) {
                ReplyPostFristCommentActivity.this.replyPostFirstCommentRichEditText.setFontSize(16);
            } else {
                if (i != 2) {
                    return;
                }
                ReplyPostFristCommentActivity.this.replyPostFirstCommentRichEditText.setFontSize(14);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            ReplyPostFristCommentActivity replyPostFristCommentActivity = ReplyPostFristCommentActivity.this;
            replyPostFristCommentActivity.replyPostFirstCommentRichEditText.setFontColor(Color.parseColor(replyPostFristCommentActivity.s[i]));
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements BaseRitchEdit.a {
        c() {
        }

        @Override // com.rtk.app.custom.RichEditText.BaseRitchEdit.a
        public void a(com.rtk.app.custom.RichEditText.d dVar) {
            if (dVar.a) {
                ReplyPostFristCommentActivity.this.replyPostFirstCommentSetBold.setChecked(true);
            } else {
                ReplyPostFristCommentActivity.this.replyPostFirstCommentSetBold.setChecked(false);
            }
            if (dVar.b) {
                ReplyPostFristCommentActivity.this.replyPostFirstCommentSetItalic.setChecked(true);
            } else {
                ReplyPostFristCommentActivity.this.replyPostFirstCommentSetItalic.setChecked(false);
            }
            int i = 0;
            while (true) {
                String[] strArr = ReplyPostFristCommentActivity.this.s;
                if (i >= strArr.length) {
                    break;
                }
                if (dVar.f == Color.parseColor(strArr[i])) {
                    ReplyPostFristCommentActivity.this.replyPostFirstCommentSetTextColor.setSelection(i);
                    break;
                }
                i++;
            }
            int i2 = dVar.e;
            if (i2 == 14) {
                ReplyPostFristCommentActivity.this.replyPostFirstCommentSetTextSize.setSelection(2);
            } else if (i2 == 16) {
                ReplyPostFristCommentActivity.this.replyPostFirstCommentSetTextSize.setSelection(1);
            } else if (i2 == 18) {
                ReplyPostFristCommentActivity.this.replyPostFirstCommentSetTextSize.setSelection(0);
            }
            ReplyPostFristCommentActivity.this.replyPostFirstCommentSetUnderLine.setChecked(dVar.f170c);
        }

        @Override // com.rtk.app.custom.RichEditText.BaseRitchEdit.a
        public void b(int i, int i2) {
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.replyPostFirstCommentTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
        if (iArr[0] != 1) {
            return;
        }
        com.rtk.app.tool.c0.u("ReplyPostFristCommentActivity", "toUser" + this.y);
        String c2 = com.rtk.app.tool.u.c(this.q.getBytes());
        HashMap<String, String> l = com.rtk.app.tool.y.l();
        l.put(ak.J, com.rtk.app.tool.y.p(this.f147c));
        l.put(ak.y, com.rtk.app.tool.y.D());
        l.put("mid", this.t);
        l.put("pid", this.u);
        l.put("root_cmt_id", "0");
        l.put("reply_cmt_id", "0");
        l.put("toUser", this.y);
        l.put("display_mode", "2");
        l.put("content", c2);
        String str = com.rtk.app.tool.y.e + "bbs/posts/comment";
        l.put("key", com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uid=" + com.rtk.app.tool.y.K() + "", "token=" + com.rtk.app.tool.y.H(), "display_mode=2", "pid=" + this.u))));
        com.rtk.app.tool.o.h.j(this.f147c, this, str, 1, l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("ReplyPostFristCommentActivity", "评论" + str);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        com.rtk.app.tool.f.a(this.f147c, "回复成功", f.a.f);
        setResult(-1);
        finish();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (i2 == 1) {
            this.z.dismiss();
            this.replyPostFirstCommentSubmit.setEnabled(true);
            this.replyPostFirstCommentSubmit.setClickable(true);
        }
        com.rtk.app.tool.c0.u("ReplyPostFristCommentActivity", "请求失败" + str);
        com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.t = extras.getString("mid");
        this.u = extras.getString("pid");
        this.y = extras.getString("toUser");
        this.v = extras.getString("title");
        this.x = extras.getString("logo");
        this.w = extras.getString("nickName");
        extras.getString("family_id");
        com.rtk.app.tool.t.c(this.f147c, this.x, this.replyPostFirstCommentIcon, new boolean[0]);
        this.replyPostFirstCommentNickName.setText(this.w);
        this.replyPostFirstCommentPostTitle.setText(this.v);
        this.replyPostFirstCommentRichEditText.setControlView(this.replyPostFirstCommentSetBold, this.replyPostFirstCommentSetItalic, this.replyPostFirstCommentSetUnderLine);
        this.z = new DialogForProgressTip(this.f147c, getResources().getString(com.rtk.app.R.string.publish_post_tip));
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.replyPostFirstCommentSetTextSize.setOnItemSelectedListener(new a());
        this.replyPostFirstCommentSetTextColor.setOnItemSelectedListener(new b());
        this.replyPostFirstCommentRichEditText.setOnSelectChangeListener(new c());
        AppCompatEditText appCompatEditText = this.replyPostFirstCommentRichEditText;
        appCompatEditText.addTextChangedListener(new com.rtk.app.main.comment.g(appCompatEditText, this.A, this.replyPostFirstCommentEditNum, this.replyPostFirstCommentSubmit));
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        com.rtk.app.tool.t.B1(this.replyPostFirstCommentRichEditText, this.f147c);
        this.replyPostFirstCommentSetTextSize.setAdapter((SpinnerAdapter) new ArrayAdapter((Context) this.f147c, R.layout.simple_spinner_dropdown_item, (Object[]) new String[]{"大", "中", "小"}));
        this.replyPostFirstCommentSetTextSize.setSelection(1);
        this.replyPostFirstCommentSetTextColor.setAdapter((SpinnerAdapter) new ArrayAdapter((Context) this.f147c, R.layout.simple_spinner_dropdown_item, (Object[]) this.s));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.rtk.app.tool.c0.u("ReplyPostFristCommentActivity", PointCategory.REQUEST + i + "   resultCode " + i2);
        try {
            if (i == 111) {
                if (i2 == -1) {
                    Bitmap decodeStream = BitmapFactory.decodeStream(getContentResolver().openInputStream(this.e));
                    this.r = decodeStream;
                    this.replyPostFirstCommentRichEditText.setBitmap(decodeStream);
                    return;
                }
                return;
            }
            if (i == 112) {
                if (i2 == -1) {
                    Bitmap decodeStream2 = BitmapFactory.decodeStream(getContentResolver().openInputStream(intent.getData()));
                    this.r = decodeStream2;
                    this.replyPostFirstCommentRichEditText.setBitmap(decodeStream2);
                    return;
                }
                return;
            }
            if (i == 114) {
                Bitmap decodeStream3 = BitmapFactory.decodeStream(getContentResolver().openInputStream(this.f));
                this.r = decodeStream3;
                if (decodeStream3 != null) {
                    this.replyPostFirstCommentRichEditText.setBitmap(decodeStream3);
                    return;
                }
                return;
            }
            if (i == 115) {
                if (i2 == -1) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = com.luck.picture.lib.b.d(intent).iterator();
                    while (it.hasNext()) {
                        arrayList.add(((com.luck.picture.lib.f.b) it.next()).f());
                    }
                    this.replyPostFirstCommentRichEditText.setMoreBitMap(arrayList);
                    return;
                }
                return;
            }
            if (i == 1001) {
                ApkInfo apkInfo = (ApkInfo) intent.getExtras().getSerializable("game");
                this.replyPostFirstCommentRichEditText.setGame(new com.rtk.app.custom.RichEditText.f(apkInfo.getGameId() + "", apkInfo.getAppName()));
                return;
            }
            if (i == 1002) {
                ApkInfo apkInfo2 = (ApkInfo) intent.getExtras().getSerializable("upSrc");
                this.replyPostFirstCommentRichEditText.setUpSrc(new UpSrcBean(apkInfo2.getUpGameId() + "", apkInfo2.getAppName()));
                return;
            }
            if (i == 1004) {
                this.replyPostFirstCommentRichEditText.setPost((CommunityPostBean.DataBean) intent.getExtras().getSerializable("post"));
            } else {
                if (i != 1005) {
                    return;
                }
                this.replyPostFirstCommentRichEditText.setUser((MyAttentionBean.DataBean) intent.getExtras().getSerializable("user"));
            }
        } catch (Exception e) {
            com.rtk.app.tool.c0.u("ReplyPostFristCommentActivity", "异常" + e);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.reply_post_first_comment_back /* 2131300006 */:
                finish();
                return;
            case com.rtk.app.R.id.reply_post_first_comment_game /* 2131300007 */:
                Intent intent = new Intent((Context) this.f147c, (Class<?>) PostSelectGameActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("from", 1000);
                intent.putExtras(bundle);
                startActivityForResult(intent, 1001);
                return;
            case com.rtk.app.R.id.reply_post_first_comment_icon /* 2131300008 */:
            case com.rtk.app.R.id.reply_post_first_comment_nickName /* 2131300012 */:
            case com.rtk.app.R.id.reply_post_first_comment_post_title /* 2131300014 */:
            case com.rtk.app.R.id.reply_post_first_comment_richEditText /* 2131300015 */:
            case com.rtk.app.R.id.reply_post_first_comment_set_textColor /* 2131300018 */:
            case com.rtk.app.R.id.reply_post_first_comment_set_textSize /* 2131300019 */:
            default:
                return;
            case com.rtk.app.R.id.reply_post_first_comment_insert_post /* 2131300009 */:
                Intent intent2 = new Intent((Context) this.f147c, (Class<?>) PostSelectPostActivity.class);
                Bundle bundle2 = new Bundle();
                bundle2.putInt("from", 1000);
                intent2.putExtras(bundle2);
                startActivityForResult(intent2, 1004);
                return;
            case com.rtk.app.R.id.reply_post_first_comment_insert_up_src /* 2131300010 */:
                Intent intent3 = new Intent((Context) this.f147c, (Class<?>) PostSelectUpSrcActivity.class);
                Bundle bundle3 = new Bundle();
                bundle3.putInt("from", 1000);
                intent3.putExtras(bundle3);
                startActivityForResult(intent3, 1002);
                return;
            case com.rtk.app.R.id.reply_post_first_comment_insert_user /* 2131300011 */:
                Intent intent4 = new Intent((Context) this.f147c, (Class<?>) PostSelectUserActivity.class);
                Bundle bundle4 = new Bundle();
                bundle4.putInt("from", 1000);
                intent4.putExtras(bundle4);
                startActivityForResult(intent4, 1005);
                return;
            case com.rtk.app.R.id.reply_post_first_comment_photo /* 2131300013 */:
                if (com.rtk.app.tool.r.b(this.f147c)) {
                    com.rtk.app.tool.t.E1(this.f147c, 9, false);
                    return;
                }
                return;
            case com.rtk.app.R.id.reply_post_first_comment_set_bold /* 2131300016 */:
                boolean z = !this.replyPostFirstCommentSetBold.isChecked();
                this.replyPostFirstCommentSetBold.setChecked(z);
                this.replyPostFirstCommentRichEditText.setBold(z);
                return;
            case com.rtk.app.R.id.reply_post_first_comment_set_italic /* 2131300017 */:
                boolean z2 = !this.replyPostFirstCommentSetItalic.isChecked();
                this.replyPostFirstCommentSetItalic.setChecked(z2);
                this.replyPostFirstCommentRichEditText.setItalic(z2);
                return;
            case com.rtk.app.R.id.reply_post_first_comment_set_underLine /* 2131300020 */:
                boolean z3 = !this.replyPostFirstCommentSetUnderLine.isChecked();
                this.replyPostFirstCommentSetUnderLine.setChecked(z3);
                this.replyPostFirstCommentRichEditText.setUnderline(z3);
                return;
            case com.rtk.app.R.id.reply_post_first_comment_submit /* 2131300021 */:
                this.replyPostFirstCommentSubmit.setEnabled(false);
                this.replyPostFirstCommentSubmit.setClickable(false);
                String labelString = this.replyPostFirstCommentRichEditText.getLabelString();
                this.q = labelString;
                String replaceAll = labelString.replaceAll("\\[img\\]图片\\[/img\\]", "");
                this.q = replaceAll;
                if (!com.rtk.app.tool.c0.q(replaceAll)) {
                    this.z.show();
                    L(1);
                } else {
                    this.replyPostFirstCommentSubmit.setEnabled(true);
                    this.replyPostFirstCommentSubmit.setClickable(true);
                    com.rtk.app.tool.f.a(this.f147c, "标题或内容不可为空", 200);
                }
                com.rtk.app.tool.c0.u("ReplyPostFristCommentActivity", "   发表帖子的内容  " + this.replyPostFirstCommentRichEditText.getLabelString());
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_reply_post_frist_comment);
        ButterKnife.a(this);
    }

    @Override // com.rtk.app.base.BaseActivity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }
}
