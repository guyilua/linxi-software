package com.rtk.app.main.login;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.rtk.app.R;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.custom.CustomMultiLineEditTextView;
import com.rtk.app.main.dialogPack.x;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpdateSignatureActivity extends BaseActivity implements h.j {
    private LinearLayout q;
    private String r;
    private CustomMultiLineEditTextView s;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N(String[] strArr) {
        L(1);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        t.S1(this.f147c, this.q, null, null, null, null);
    }

    public void L(int... iArr) {
        HashMap hashMap = new HashMap();
        AppCompatActivity appCompatActivity = this.f147c;
        hashMap.put("channel", y.m(appCompatActivity, appCompatActivity.getPackageName()));
        hashMap.put("version", y.i(this.f147c));
        hashMap.put(ak.aj, y.g());
        hashMap.put("phone_model", y.T());
        hashMap.put("signature", this.r);
        hashMap.put("uid", y.K() + "");
        hashMap.put("token", y.H());
        hashMap.put("key", t.c0(c0.e(y.v(this.f147c, "uid=" + y.K(), "token=" + y.H(), "signature=" + this.r))));
        AppCompatActivity appCompatActivity2 = this.f147c;
        StringBuilder sb = new StringBuilder();
        sb.append(y.e);
        sb.append("user/info/signature");
        com.rtk.app.tool.o.h.j(appCompatActivity2, this, sb.toString(), 1, hashMap);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        c0.u("UpdateSignatureActivity", "修改签名成功:" + str);
        com.rtk.app.tool.f.a(this.f147c, "修改签名成功", f.a.f);
        finish();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        c0.s("UpdateSignatureActivity", "修改签名失败:" + str);
        com.rtk.app.tool.f.a(this.f147c, "修改签名失败:" + str, f.a.f);
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initView() {
        this.q = (LinearLayout) findViewById(R.id.signature_top_layout);
        this.s = (CustomMultiLineEditTextView) findViewById(R.id.custom_multi_line_edit_text);
        this.s.getEditText().setText(getIntent().getExtras().getString("signature"));
        this.s.setMaxWordCount(150);
        this.s.setHint("请输入签名");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signature_save /* 2131300282 */:
                String trim = this.s.getContent().toString().trim();
                this.r = trim;
                String replaceAll = trim.replaceAll(" ", "");
                this.r = replaceAll;
                if (c0.q(replaceAll)) {
                    com.rtk.app.tool.f.a(this.f147c, "请输入签名", f.a.f);
                    return;
                }
                if (this.r.length() > 150) {
                    com.rtk.app.tool.f.a(this.f147c, "签名最多150字", f.a.f);
                    return;
                }
                new x(this.f147c, "确定个人签名", "您的签名将设置为:“" + this.r + "”。确定后一周内不可修改，修改个性签名请勿违反相关法律法规。", new s() { // from class: com.rtk.app.main.login.l
                    @Override // com.rtk.app.tool.s
                    public final void a(String[] strArr) {
                        UpdateSignatureActivity.this.N(strArr);
                    }
                }).show();
                return;
            case R.id.signature_top_back /* 2131300283 */:
                finish();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_update_singnature_layout);
    }
}
