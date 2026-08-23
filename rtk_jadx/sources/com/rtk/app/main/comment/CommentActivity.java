package com.rtk.app.main.comment;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.ResponseDataBean;
import com.rtk.app.main.CommentSpecificationActivity;
import com.rtk.app.main.GameDetailsItem2;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.dialogPack.DialogForCommentOverAudit;
import com.rtk.app.main.dialogPack.b0;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.t;
import com.rtk.app.tool.u;
import com.rtk.app.tool.v;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import com.tencent.smtt.sdk.TbsListener;
import com.umeng.analytics.pro.ak;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CommentActivity extends BaseActivity implements h.j {
    private CommentUpImageHolder A;

    @BindView
    TextView activityCommentTitleBack;

    @BindView
    RelativeLayout activityCommentTitleRl;

    @BindView
    EditText activityCommentsContent;

    @BindView
    TextView activityCommentsStartContentHint;

    @BindView
    TextView activityCommentsStartHint;

    @BindView
    ImageView activityCommentsStartImg1;

    @BindView
    ImageView activityCommentsStartImg2;

    @BindView
    ImageView activityCommentsStartImg3;

    @BindView
    ImageView activityCommentsStartImg4;

    @BindView
    ImageView activityCommentsStartImg5;

    @BindView
    LinearLayout activityCommentsStartLy;

    @BindView
    TextView activityCommentsSubmit;

    @BindView
    LinearLayout commentEmojiLayout;

    @BindView
    ImageView commentEmojie;

    @BindView
    TextView commentSepcificationTV;

    @BindView
    View commentUpImageIncludeView;

    @BindView
    LinearLayout llDotContainer;
    private Context q;
    private int r = 5;
    private InputMethodManager s;
    private int t;
    private int u;
    private int v;

    @BindView
    ViewPager viwepagerExpression;
    private String w;
    private String x;
    private int y;
    private b0 z;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CommentActivity.this.s.showSoftInput(CommentActivity.this.activityCommentsContent, 0);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommentActivity.this.r = ((Integer) view.getTag()).intValue() + 1;
            CommentActivity.this.P();
        }
    }

    public CommentActivity() {
        new ArrayList();
        new ArrayList();
        new TreeMap();
        new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        for (int i = 0; i < this.activityCommentsStartLy.getChildCount(); i++) {
            if (i <= this.r - 1) {
                this.activityCommentsStartLy.getChildAt(i).setSelected(false);
            } else {
                this.activityCommentsStartLy.getChildAt(i).setSelected(true);
            }
        }
        int i2 = this.r - 1;
        if (i2 == 0) {
            this.activityCommentsStartHint.setText("一星差评，真不能忍");
            return;
        }
        if (i2 == 1) {
            this.activityCommentsStartHint.setText("二星中评，差强人意");
            return;
        }
        if (i2 == 2) {
            this.activityCommentsStartHint.setText("三星中评，再接再厉");
        } else if (i2 != 3) {
            if (i2 != 4) {
                return;
            }
            this.activityCommentsStartHint.setText("五星好评，极力推荐");
        } else {
            this.activityCommentsStartHint.setText("四星好评，心满意足");
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        t.S1(this.q, this.activityCommentTitleRl, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void O(int... iArr) {
        if (iArr[0] != 1) {
            return;
        }
        HashMap hashMap = new HashMap();
        String c2 = u.c(this.activityCommentsContent.getText().toString().trim().getBytes());
        String p = y.p(this.q);
        c0.u("CommentActivity", "device_name " + p);
        hashMap.put("channel", y.m(this.q, getPackageName()));
        hashMap.put("version", y.i(this.q));
        hashMap.put(ak.aj, y.g());
        hashMap.put("phone_model", y.T());
        StringBuilder sb = new StringBuilder();
        sb.append(y.K());
        String str = "";
        sb.append("");
        hashMap.put("uid", sb.toString());
        hashMap.put("content", c2);
        hashMap.put("star", this.r + "");
        hashMap.put("root_cmt_id", this.u + "");
        hashMap.put("reply_cmt_id", this.t + "");
        hashMap.put(ak.J, p);
        hashMap.put(ak.y, y.D());
        hashMap.put("token", y.H());
        hashMap.put("pic", this.A.t());
        if (this.w.equals("upApk")) {
            hashMap.put("sid", this.v + "");
            hashMap.put("toUser", this.x + "");
            hashMap.put("key", t.c0(c0.e(y.v(this.q, "sid=" + this.v, "uid=" + y.K(), "toUser=" + this.x, "content=" + c2, "token=" + y.H()))));
            Context context = this.q;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(y.d);
            sb2.append("members/sourceComment");
            h.j(context, this, sb2.toString(), 1, hashMap);
        } else {
            hashMap.put("game_id", this.v + "");
            hashMap.put("key", t.c0(c0.e(y.v(this.q, "game_id=" + this.v, "content=" + c2, "uid=" + y.K()))));
            Context context2 = this.q;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(y.d);
            sb3.append("game/gameCommentSubmit");
            h.j(context2, this, sb3.toString(), 1, hashMap);
        }
        for (String str2 : hashMap.keySet()) {
            str = str + "   " + str2 + "  " + ((String) hashMap.get(str2)) + UMCustomLogInfoBuilder.LINE_SEP;
        }
        c0.u("CommentActivity", "上传数据 map---\n" + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i != 1) {
            if (i != 2) {
                return;
            }
            c0.u("CommentActivity", "评论图片上传  " + str);
            this.z.dismiss();
            return;
        }
        c0.u("CommentActivity", "评论成功" + str);
        ResponseDataBean responseDataBean = (ResponseDataBean) this.g.fromJson(str, ResponseDataBean.class);
        if (responseDataBean.getCode() == 0) {
            if (this.t == 0 && this.u == 0) {
                GameDetailsItem2.w = true;
            }
            com.rtk.app.tool.f.a(this.q, "评论成功！", f.a.f);
            if (this.t == 0 && this.u == 0) {
                setResult(-1);
            } else {
                c0.u("CommentActivity", "二级评论");
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("replyComment", this.activityCommentsContent.getText().toString().trim());
                bundle.putInt("itemPosition", this.y);
                intent.putExtras(bundle);
                setResult(1, intent);
            }
            finish();
            return;
        }
        com.rtk.app.tool.f.a(this.q, responseDataBean.getMsg(), f.a.f);
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            c0.u("CommentActivity", "上传图片失败  " + str);
            this.z.dismiss();
            return;
        }
        c0.u("CommentActivity", " 评论   " + str);
        if (str.equals("评论成功,审核后即可显示")) {
            DialogForCommentOverAudit dialogForCommentOverAudit = new DialogForCommentOverAudit(this.f147c);
            if (!v.a(this.q, v.h)) {
                dialogForCommentOverAudit.show();
            } else {
                finish();
            }
        }
        com.rtk.app.tool.f.a(this.q, str, f.a.f);
        this.activityCommentsSubmit.setEnabled(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        this.t = getIntent().getExtras().getInt("reply_cmt_id");
        this.y = getIntent().getExtras().getInt("itemPosition");
        this.u = getIntent().getExtras().getInt("root_cmt_id");
        this.v = getIntent().getExtras().getInt("game_id");
        this.w = getIntent().getExtras().getString("commentType");
        this.x = getIntent().getExtras().getString("toUser", null);
        new ArrayList();
        new ArrayList();
        this.A = new CommentUpImageHolder(this.f147c, this.commentUpImageIncludeView, this.w.equals("upApk") ? "upcomment" : "gamecomment");
        new f(this.f147c, this.activityCommentsContent, this.viwepagerExpression, this.llDotContainer);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        for (int i = 0; i < this.activityCommentsStartLy.getChildCount(); i++) {
            this.activityCommentsStartLy.getChildAt(i).setTag(Integer.valueOf(i));
            this.activityCommentsStartLy.getChildAt(i).setOnClickListener(new b());
        }
        EditText editText = this.activityCommentsContent;
        editText.addTextChangedListener(new g(editText, TbsListener.ErrorCode.NEEDDOWNLOAD_1, this.activityCommentsStartContentHint, this.activityCommentsSubmit));
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.z = new b0(this.f147c);
        if (y.j() && MainActivity.p.getData().getLevel() >= MainActivity.p.getData().getAuthority().getImageLevel()) {
            this.commentUpImageIncludeView.setVisibility(this.u == 0 ? 0 : 8);
        } else {
            this.commentUpImageIncludeView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 115 && i2 == -1) {
            ArrayList arrayList = new ArrayList();
            List<com.luck.picture.lib.f.b> d = com.luck.picture.lib.b.d(intent);
            arrayList.clear();
            for (com.luck.picture.lib.f.b bVar : d) {
                c0.u("CommentActivity", "选择图片的地址" + bVar.f());
                arrayList.add(bVar.f());
            }
            this.A.v(arrayList);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.activity_comment_title_back /* 2131296384 */:
                com.rtk.app.tool.c.a((Activity) this.q);
                return;
            case com.rtk.app.R.id.activity_comments_submit /* 2131296395 */:
                if (this.activityCommentsContent.getText().toString().trim().length() >= 2) {
                    this.activityCommentsSubmit.setEnabled(false);
                    O(1);
                    return;
                } else {
                    com.rtk.app.tool.f.a(this.f147c, "评论内容不得少于两个字！", f.a.f);
                    return;
                }
            case com.rtk.app.R.id.comment_emojie /* 2131296976 */:
                Boolean valueOf = Boolean.valueOf(!Boolean.valueOf(this.commentEmojie.isSelected()).booleanValue());
                if (valueOf.booleanValue()) {
                    this.commentEmojiLayout.setVisibility(0);
                    this.s.hideSoftInputFromWindow(this.activityCommentsContent.getWindowToken(), 0);
                } else {
                    this.commentEmojiLayout.setVisibility(8);
                    new Handler().postDelayed(new a(), 50L);
                }
                this.commentEmojie.setSelected(valueOf.booleanValue());
                return;
            case com.rtk.app.R.id.comment_sepcification_TV /* 2131296977 */:
                com.rtk.app.tool.c.b((Activity) this.q, CommentSpecificationActivity.class, null);
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
        setContentView(com.rtk.app.R.layout.activity_comment);
        ButterKnife.a(this);
        this.q = this;
        this.s = (InputMethodManager) this.f147c.getSystemService("input_method");
        com.rtk.app.main.comment.express.c.g();
    }
}
