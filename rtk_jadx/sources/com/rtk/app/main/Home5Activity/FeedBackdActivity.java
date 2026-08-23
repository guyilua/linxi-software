package com.rtk.app.main.Home5Activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.GsonBuilder;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.ResponseDataBean;
import com.rtk.app.tool.o.h;
import com.tencent.smtt.sdk.TbsListener;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FeedBackdActivity extends BaseActivity implements h.j {

    @BindView
    RelativeLayout feedBackBlank;

    @BindView
    EditText feedBackComment;

    @BindView
    EditText feedBackContact;

    @BindView
    TextView feedBackContentSize;

    @BindView
    TextView feedBackSubmit;

    @BindView
    TextView feedBackTopBack;

    @BindView
    LinearLayout feedBackTopLayout;
    private Context q;
    private int r = TbsListener.ErrorCode.ERROR_CODE_LOAD_BASE;
    private TextWatcher s = new a();

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
            return a(FeedBackdActivity.this.feedBackComment.getText().toString());
        }

        private void c() {
            FeedBackdActivity.this.feedBackContentSize.setText(String.valueOf(b()) + "/" + FeedBackdActivity.this.r);
            if (b() > 0) {
                FeedBackdActivity.this.feedBackSubmit.setEnabled(true);
            } else {
                FeedBackdActivity.this.feedBackSubmit.setEnabled(false);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            this.a = FeedBackdActivity.this.feedBackComment.getSelectionStart();
            this.b = FeedBackdActivity.this.feedBackComment.getSelectionEnd();
            FeedBackdActivity feedBackdActivity = FeedBackdActivity.this;
            feedBackdActivity.feedBackComment.removeTextChangedListener(feedBackdActivity.s);
            while (a(editable.toString()) > FeedBackdActivity.this.r) {
                editable.delete(this.a - 1, this.b);
                this.a--;
                this.b--;
            }
            FeedBackdActivity feedBackdActivity2 = FeedBackdActivity.this;
            feedBackdActivity2.feedBackComment.addTextChangedListener(feedBackdActivity2.s);
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
        com.rtk.app.tool.t.S1(this.q, this.feedBackTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void N(int... iArr) {
        String b = com.rtk.app.tool.c0.b(this.feedBackComment.getText().toString().trim());
        String b2 = com.rtk.app.tool.c0.b(this.feedBackContact.getText().toString().trim());
        if (com.rtk.app.tool.c0.q(b, b2)) {
            if (com.rtk.app.tool.c0.q(b)) {
                com.rtk.app.tool.f.a(this.q, "请填反馈内容", TbsListener.ErrorCode.INFO_CODE_MINIQB);
                return;
            } else if (com.rtk.app.tool.c0.q(b2)) {
                com.rtk.app.tool.f.a(this.q, "请填写联系方式", TbsListener.ErrorCode.INFO_CODE_MINIQB);
                return;
            }
        }
        this.feedBackSubmit.setEnabled(false);
        Context context = this.q;
        com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(new String[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("system/suggest");
        sb.append(com.rtk.app.tool.y.u(this.q));
        sb.append("&device_id=");
        sb.append(com.rtk.app.tool.y.o(this.q));
        sb.append("&device_name=");
        sb.append(com.rtk.app.tool.y.p(this.q));
        sb.append("&info=");
        sb.append(b);
        sb.append("&phone=");
        sb.append(b2);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.q, "device_id=" + com.rtk.app.tool.y.o(this.q), "device_name=" + com.rtk.app.tool.y.p(this.q), "info=" + b, "phone=" + b2))));
        com.rtk.app.tool.o.h.l(context, this, 1, h.a(sb.toString()));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("FeedBackdActivity", "反馈信息" + str);
        if (((ResponseDataBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, ResponseDataBean.class)).getCode() == 0) {
            com.rtk.app.tool.f.a(this.q, "反馈成功", 200);
            com.rtk.app.tool.c.a((Activity) this.q);
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.feedBackComment.addTextChangedListener(this.s);
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131297569) {
            N(new int[0]);
        } else {
            if (id != 2131297573) {
                return;
            }
            com.rtk.app.tool.c.a((Activity) this.q);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_feed_backd);
        ButterKnife.a(this);
        this.q = this;
    }
}
