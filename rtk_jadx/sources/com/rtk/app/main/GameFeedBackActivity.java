package com.rtk.app.main;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.FeedListBean;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import com.tencent.smtt.sdk.TbsListener;
import com.umeng.analytics.pro.ak;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GameFeedBackActivity extends BaseActivity implements h.j {

    @BindView
    ImageView feedBackToGameGameIcon;

    @BindView
    TextView feedBackToGameGameName;

    @BindView
    RadioGroup feedBackToGameRadioGroup;

    @BindView
    TextView gameFeedBackBackTV;

    @BindView
    EditText gameFeedBackComment;

    @BindView
    EditText gameFeedBackContact;

    @BindView
    TextView gameFeedBackContentSize;

    @BindView
    LinearLayout gameFeedBackLayout;

    @BindView
    TextView gameFeedBackSubmit;
    private Activity q;
    private int r;
    private String s;
    private String t;
    private FeedListBean u;
    private String v;
    private String w;
    private String x;
    private String y;
    private int z = TbsListener.ErrorCode.ERROR_CODE_LOAD_BASE;
    private TextWatcher A = new a();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements TextWatcher {
        private int a;
        private int b;

        a() {
        }

        private long a(CharSequence charSequence) {
            double d = 0.0d;
            for (int i = 0; i < charSequence.length(); i++) {
                char charAt = charSequence.charAt(i);
                d += (charAt <= 0 || charAt >= 127) ? 1.0d : 0.5d;
            }
            return Math.round(d);
        }

        private long b() {
            return a(GameFeedBackActivity.this.gameFeedBackComment.getText().toString());
        }

        private void c() {
            GameFeedBackActivity.this.gameFeedBackContentSize.setText(String.valueOf(b()) + "/" + GameFeedBackActivity.this.z);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            this.a = GameFeedBackActivity.this.gameFeedBackComment.getSelectionStart();
            this.b = GameFeedBackActivity.this.gameFeedBackComment.getSelectionEnd();
            GameFeedBackActivity gameFeedBackActivity = GameFeedBackActivity.this;
            gameFeedBackActivity.gameFeedBackComment.removeTextChangedListener(gameFeedBackActivity.A);
            while (a(editable.toString()) > GameFeedBackActivity.this.z) {
                editable.delete(this.a - 1, this.b);
                this.a--;
                this.b--;
            }
            GameFeedBackActivity gameFeedBackActivity2 = GameFeedBackActivity.this;
            gameFeedBackActivity2.gameFeedBackComment.addTextChangedListener(gameFeedBackActivity2.A);
            c();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.q, this.gameFeedBackLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void N(int... iArr) {
        com.rtk.app.tool.c0.u("GameFeedBackActivity", "请求反馈");
        int i = iArr[0];
        String str = "";
        if (i != 1) {
            if (i == 2) {
                int I = com.rtk.app.tool.y.I(this.q);
                StringBuilder sb = new StringBuilder();
                sb.append("game/gamefeedback");
                sb.append(com.rtk.app.tool.y.u(this.q));
                sb.append("&type_id=");
                sb.append(this.v);
                sb.append("&game_id=");
                sb.append(this.r);
                sb.append("&info=");
                sb.append(this.w);
                sb.append("&contact=");
                sb.append(this.x);
                sb.append("&device_id=");
                sb.append(com.rtk.app.tool.y.o(this.q));
                sb.append("&device_name=");
                sb.append(com.rtk.app.tool.y.p(this.q));
                sb.append("&uid=");
                sb.append(I);
                sb.append("&key=");
                sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.q, "device_id=" + com.rtk.app.tool.y.o(this.q), "device_name=" + com.rtk.app.tool.y.p(this.q), "type_id=" + this.v, "game_id=" + this.r, "uid=" + I))));
                str = sb.toString();
            } else if (i == 3) {
                HashMap hashMap = new HashMap();
                hashMap.put("channel", com.rtk.app.tool.y.m(this.q, getPackageName()));
                hashMap.put("version", com.rtk.app.tool.y.i(this.q));
                hashMap.put(ak.aj, com.rtk.app.tool.y.g());
                hashMap.put("phone_model", com.rtk.app.tool.y.T());
                hashMap.put("sid", this.r + "");
                hashMap.put("uid", com.rtk.app.tool.y.K() + "");
                hashMap.put("token", com.rtk.app.tool.y.H());
                hashMap.put("type_id", this.v);
                hashMap.put("info", this.w);
                hashMap.put("contact", this.x);
                hashMap.put("device_id", com.rtk.app.tool.y.o(this.f147c));
                hashMap.put(ak.J, com.rtk.app.tool.y.p(this.f147c));
                hashMap.put("key", com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.q, "sid=" + this.r, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
                AppCompatActivity appCompatActivity = this.f147c;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(com.rtk.app.tool.y.d);
                sb2.append("members/sourceFeedback");
                com.rtk.app.tool.o.h.j(appCompatActivity, this, sb2.toString(), iArr[0], hashMap);
            }
        } else if (!this.y.equals("upApk")) {
            str = "game/feedbacklist" + com.rtk.app.tool.y.u(this.q) + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.q, new String[0])));
        } else {
            str = "members/sourceFeedbackList" + com.rtk.app.tool.y.u(this.q) + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.q, new String[0])));
        }
        com.rtk.app.tool.c0.u("GameFeedBackActivity", " 反馈页地址  " + com.rtk.app.tool.y.d + str);
        if (com.rtk.app.tool.c0.q(str)) {
            return;
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(str));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return;
                }
                com.rtk.app.tool.f.a(this.q, "反馈成功", f.a.f);
                com.rtk.app.tool.c.a(this.q);
                return;
            }
            com.rtk.app.tool.f.a(this.q, "反馈成功", f.a.f);
            com.rtk.app.tool.c.a(this.q);
            return;
        }
        com.rtk.app.tool.c0.u("GameFeedBackActivity", "反馈列表--》" + str);
        FeedListBean feedListBean = (FeedListBean) create.fromJson(str, FeedListBean.class);
        this.u = feedListBean;
        if (feedListBean.getCode() != 0) {
            return;
        }
        this.feedBackToGameRadioGroup.removeAllViews();
        for (int i2 = 0; i2 < this.u.getData().size(); i2++) {
            RadioButton radioButton = (RadioButton) LayoutInflater.from(this.q).inflate(com.rtk.app.R.layout.radioview_layout, (ViewGroup) null);
            radioButton.setLayoutParams(new RadioGroup.LayoutParams(-1, -2));
            radioButton.setText(this.u.getData().get(i2).getDesc());
            this.feedBackToGameRadioGroup.addView(radioButton);
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("GameFeedBackActivity", "反馈页面" + str);
        com.rtk.app.tool.f.a(this.f147c, "反馈失败" + str, f.a.f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.r = extras.getInt("gameId");
        this.s = extras.getString("gameName");
        this.t = extras.getString("logo");
        this.y = extras.getString(com.umeng.analytics.pro.d.y, "game");
        N(1);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.gameFeedBackComment.addTextChangedListener(this.A);
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.feedBackToGameGameName.setText(this.s);
        com.rtk.app.tool.t.d(this.q, this.t, this.feedBackToGameGameIcon);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131297739) {
            com.rtk.app.tool.c.a(this);
            return;
        }
        if (id != 2131297744) {
            return;
        }
        this.x = this.gameFeedBackContact.getText().toString().trim();
        String trim = this.gameFeedBackComment.getText().toString().trim();
        this.w = trim;
        if (com.rtk.app.tool.c0.q(trim)) {
            com.rtk.app.tool.f.a(this.q, "请填写完整内容", f.a.f);
            return;
        }
        int checkedRadioButtonId = this.feedBackToGameRadioGroup.getCheckedRadioButtonId() % this.u.getData().size();
        if (checkedRadioButtonId == 0) {
            checkedRadioButtonId = this.u.getData().size();
        }
        if (checkedRadioButtonId >= 0) {
            this.v = this.u.getData().get(checkedRadioButtonId - 1).getId() + "";
            if (!this.y.equals("upApk")) {
                this.x = com.rtk.app.tool.c0.b(this.x);
                this.w = com.rtk.app.tool.c0.b(this.w);
                N(2);
                return;
            }
            N(3);
            return;
        }
        com.rtk.app.tool.f.a(this.q, "请选择错误类型", f.a.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_game_feed_back);
        ButterKnife.a(this);
        this.q = this;
    }
}
