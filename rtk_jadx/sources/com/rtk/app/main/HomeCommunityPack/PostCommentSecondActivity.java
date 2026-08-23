package com.rtk.app.main.HomeCommunityPack;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.custom.RichEditText.RichEditText;
import com.rtk.app.main.CommentSpecificationActivity;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import com.tencent.smtt.sdk.TbsListener;
import com.umeng.analytics.pro.ak;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostCommentSecondActivity extends BaseActivity implements h.j {

    @BindView
    LinearLayout commentEmojiLayout;

    @BindView
    ImageView commentEmojie;

    @BindView
    TextView commentSepcificationTV;

    @BindView
    LinearLayout llDotContainer;

    @BindView
    TextView postCommentSecondTitleBack;

    @BindView
    RelativeLayout postCommentSecondTitleRl;

    @BindView
    RichEditText postCommentSecondsContent;

    @BindView
    TextView postCommentSecondsStartContentHint;

    @BindView
    TextView postCommentSecondsSubmit;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u = "";
    private String v;

    @BindView
    ViewPager viwepagerExpression;
    private InputMethodManager w;
    private DialogForProgressTip x;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PostCommentSecondActivity.this.w.showSoftInput(PostCommentSecondActivity.this.postCommentSecondsContent, 0);
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.postCommentSecondTitleRl, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void M(int... iArr) {
        if (iArr[0] != 1) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("channel", com.rtk.app.tool.y.m(this.f147c, getPackageName()));
        hashMap.put("version", com.rtk.app.tool.y.i(this.f147c));
        hashMap.put(ak.aj, com.rtk.app.tool.y.g());
        hashMap.put("phone_model", com.rtk.app.tool.y.T());
        hashMap.put(ak.J, com.rtk.app.tool.y.p(this.f147c));
        hashMap.put("uid", com.rtk.app.tool.y.K() + "");
        hashMap.put("token", com.rtk.app.tool.y.H());
        hashMap.put(ak.y, com.rtk.app.tool.y.D());
        hashMap.put("mid", this.q);
        hashMap.put("pid", this.r);
        hashMap.put("toUser", this.u);
        hashMap.put("root_cmt_id", this.s + "");
        hashMap.put("reply_cmt_id", this.t + "");
        hashMap.put("content", this.v);
        hashMap.put("display_mode", "2");
        hashMap.put("key", com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uid=" + com.rtk.app.tool.y.K() + "", "token=" + com.rtk.app.tool.y.H(), "display_mode=2", "pid=" + this.r))));
        AppCompatActivity appCompatActivity = this.f147c;
        StringBuilder sb = new StringBuilder();
        sb.append(com.rtk.app.tool.y.e);
        sb.append("bbs/posts/comment");
        com.rtk.app.tool.o.h.j(appCompatActivity, this, sb.toString(), 1, hashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("PostCommentSecondActivity", "二级评论返回" + str);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        com.rtk.app.tool.f.a(this.f147c, "回复成功", f.a.f);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("secondContent", this.postCommentSecondsContent.getText().toString().trim());
        bundle.putString("NickName", MainActivity.p.getData().getNickname());
        bundle.putInt("position", getIntent().getExtras().getInt("position"));
        bundle.putInt("truePosition", getIntent().getExtras().getInt("truePosition"));
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (i2 != 1) {
            return;
        }
        this.postCommentSecondsSubmit.setEnabled(true);
        this.x.dismiss();
        com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.q = extras.getString("mid");
        this.r = extras.getString("pid");
        this.s = extras.getString("root_cmt_id");
        this.t = extras.getString("reply_cmt_id");
        this.u = extras.getString("toUser");
        new com.rtk.app.main.comment.f(this.f147c, this.postCommentSecondsContent, this.viwepagerExpression, this.llDotContainer);
        this.x = new DialogForProgressTip(this.f147c, getResources().getString(com.rtk.app.R.string.publish_post_tip));
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        AppCompatEditText appCompatEditText = this.postCommentSecondsContent;
        appCompatEditText.addTextChangedListener(new com.rtk.app.main.comment.g(appCompatEditText, TbsListener.ErrorCode.NEEDDOWNLOAD_1, this.postCommentSecondsStartContentHint, this.postCommentSecondsSubmit));
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.comment_emojie /* 2131296976 */:
                Boolean valueOf = Boolean.valueOf(!Boolean.valueOf(this.commentEmojie.isSelected()).booleanValue());
                if (valueOf.booleanValue()) {
                    this.commentEmojiLayout.setVisibility(0);
                    this.w.hideSoftInputFromWindow(this.postCommentSecondsContent.getWindowToken(), 0);
                } else {
                    this.commentEmojiLayout.setVisibility(8);
                    new Handler().postDelayed(new a(), 50L);
                }
                this.commentEmojie.setSelected(valueOf.booleanValue());
                return;
            case com.rtk.app.R.id.comment_sepcification_TV /* 2131296977 */:
                com.rtk.app.tool.c.b(this.f147c, CommentSpecificationActivity.class, null);
                return;
            case com.rtk.app.R.id.post_comment_second_title_back /* 2131299793 */:
                com.rtk.app.tool.c.a(this.f147c);
                return;
            case com.rtk.app.R.id.post_comment_seconds_submit /* 2131299797 */:
                String c2 = com.rtk.app.tool.u.c(this.postCommentSecondsContent.getLabelString().getBytes());
                this.v = c2;
                String replaceAll = c2.replaceAll("\\[img\\]图片\\[/img\\]", "");
                this.v = replaceAll;
                if (com.rtk.app.tool.c0.q(replaceAll)) {
                    return;
                }
                this.postCommentSecondsSubmit.setEnabled(false);
                this.x.show();
                M(1);
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
        setContentView(com.rtk.app.R.layout.activity_post_comment_second);
        ButterKnife.a(this);
        this.w = (InputMethodManager) this.f147c.getSystemService("input_method");
    }
}
