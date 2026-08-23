package com.rtk.app.main.family;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.rtk.app.R;
import com.rtk.app.bean.FamilyInfoBean;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpdateFamilyJoinCoinActivity extends FamilyBaseActivity {
    private EditText r;
    private int s;
    FamilyInfoBean t;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(String[] strArr) {
        N(1);
    }

    public void N(int... iArr) {
        HashMap hashMap = new HashMap();
        AppCompatActivity appCompatActivity = this.f147c;
        hashMap.put("channel", com.rtk.app.tool.y.m(appCompatActivity, appCompatActivity.getPackageName()));
        hashMap.put("version", com.rtk.app.tool.y.i(this.f147c));
        hashMap.put(ak.aj, com.rtk.app.tool.y.g());
        hashMap.put("phone_model", com.rtk.app.tool.y.T());
        hashMap.put("join_coin", this.s + "");
        hashMap.put("uid", com.rtk.app.tool.y.K() + "");
        hashMap.put("token", com.rtk.app.tool.y.H());
        hashMap.put("family_id", this.t.getData().getFamily_id());
        hashMap.put("key", com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "join_coin=" + this.s, "family_id=" + this.t.getData().getFamily_id()))));
        AppCompatActivity appCompatActivity2 = this.f147c;
        StringBuilder sb = new StringBuilder();
        sb.append(com.rtk.app.tool.y.e);
        sb.append("family/info/join-coin");
        com.rtk.app.tool.o.h.j(appCompatActivity2, this, sb.toString(), 1, hashMap);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("UpdateNickNameActivity", "修改家族加入金币成功:" + str);
        com.rtk.app.tool.f.a(this.f147c, "修改家族加入金币成功", f.a.f);
        finish();
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.s("UpdateNickNameActivity", "修改加入家族金币失败:" + str);
        com.rtk.app.tool.f.a(this.f147c, "修改加入家族金币失败:" + str, f.a.f);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
        super.initView();
        this.r = (EditText) findViewById(R.id.update_nickname_nickname_edt);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.update_nickname_save /* 2131301109 */:
                int parseInt = Integer.parseInt(this.r.getText().toString().trim().replaceAll(" ", ""));
                this.s = parseInt;
                if (parseInt >= 0 && parseInt <= 1000) {
                    new com.rtk.app.main.dialogPack.x(this.f147c, "确定修改加入家族金币", "您的家族加入金币将设置为:“" + this.s + "”。确定后一周内不可更改。", new com.rtk.app.tool.s() { // from class: com.rtk.app.main.family.e1
                        @Override // com.rtk.app.tool.s
                        public final void a(String[] strArr) {
                            UpdateFamilyJoinCoinActivity.this.P(strArr);
                        }
                    }).show();
                    return;
                }
                com.rtk.app.tool.f.a(this.f147c, "金币设置范围0-1000", f.a.f);
                return;
            case R.id.update_nickname_top_back /* 2131301110 */:
                finish();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_update_family_join_coin_layout);
        this.t = (FamilyInfoBean) getIntent().getSerializableExtra("family_Info");
    }
}
