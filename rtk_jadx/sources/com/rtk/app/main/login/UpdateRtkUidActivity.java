package com.rtk.app.main.login;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.rtk.app.R;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.custom.CustomSingleEditTextView;
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
public class UpdateRtkUidActivity extends BaseActivity implements h.j {
    private LinearLayout q;
    private CustomSingleEditTextView r;
    private String s;

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
        hashMap.put("rtk_id", this.s);
        hashMap.put("uid", y.K() + "");
        hashMap.put("token", y.H());
        hashMap.put("key", t.c0(c0.e(y.v(this.f147c, "uid=" + y.K(), "token=" + y.H(), "rtk_id=" + this.s))));
        AppCompatActivity appCompatActivity2 = this.f147c;
        StringBuilder sb = new StringBuilder();
        sb.append(y.e);
        sb.append("user/rtkid");
        com.rtk.app.tool.o.h.j(appCompatActivity2, this, sb.toString(), 1, hashMap);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        c0.u("UpdateRtkUidActivity", "修改软天空号成功:" + str);
        com.rtk.app.tool.f.a(this.f147c, "修改软天空号成功", f.a.f);
        finish();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        c0.s("UpdateRtkUidActivity", "修改软天空号失败:" + str);
        com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.q = (LinearLayout) findViewById(R.id.update_rtk_uid_top_layout);
        CustomSingleEditTextView customSingleEditTextView = (CustomSingleEditTextView) findViewById(R.id.custom_single_edit_text);
        this.r = customSingleEditTextView;
        customSingleEditTextView.setHint("请输入软天空号");
        this.r.setMaxWordCount(16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.update_rtk_uid_save /* 2131301112 */:
                String trim = this.r.getContent().toString().trim();
                this.s = trim;
                if (trim.matches("[a-zA-Z0-9_]+") && this.s.length() >= 6 && this.s.length() <= 16) {
                    if (!String.valueOf(this.s.charAt(0)).matches("[a-zA-Z]")) {
                        com.rtk.app.tool.f.a(this.f147c, "软天空号必须以字母开头", f.a.f);
                        return;
                    }
                    new x(this.f147c, "确定修改软天空号", "您的软天空号将设置为:“" + this.s + "”。确定后一年内不可修改。", new s() { // from class: com.rtk.app.main.login.k
                        @Override // com.rtk.app.tool.s
                        public final void a(String[] strArr) {
                            UpdateRtkUidActivity.this.N(strArr);
                        }
                    }).show();
                    return;
                }
                com.rtk.app.tool.f.a(this.f147c, "仅允许输入6-16位的字母、数字、下划线", f.a.f);
                return;
            case R.id.update_rtk_uid_top_back /* 2131301113 */:
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
        setContentView(R.layout.activity_update_rtk_uid);
    }
}
