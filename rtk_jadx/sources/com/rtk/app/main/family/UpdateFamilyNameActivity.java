package com.rtk.app.main.family;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.rtk.app.R;
import com.rtk.app.bean.FamilyInfoBean;
import com.rtk.app.custom.CustomSingleEditTextView;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpdateFamilyNameActivity extends FamilyBaseActivity {
    private CustomSingleEditTextView r;
    private String s;
    FamilyInfoBean t;
    private int u = 10;

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
        hashMap.put("name", this.s);
        hashMap.put("uid", com.rtk.app.tool.y.K() + "");
        hashMap.put("token", com.rtk.app.tool.y.H());
        hashMap.put("family_id", this.t.getData().getFamily_id());
        hashMap.put("key", com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "name=" + this.s, "family_id=" + this.t.getData().getFamily_id()))));
        AppCompatActivity appCompatActivity2 = this.f147c;
        StringBuilder sb = new StringBuilder();
        sb.append(com.rtk.app.tool.y.e);
        sb.append("family/info/name");
        com.rtk.app.tool.o.h.j(appCompatActivity2, this, sb.toString(), 1, hashMap);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("UpdateFamilyNameActivity", "修改成功:" + str);
        com.rtk.app.tool.f.a(this.f147c, "修改成功", f.a.f);
        finish();
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.s("UpdateFamilyNameActivity", "修改失败:" + str);
        com.rtk.app.tool.f.a(this.f147c, "修改失败:" + str, f.a.f);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
        CustomSingleEditTextView customSingleEditTextView = (CustomSingleEditTextView) findViewById(R.id.custom_single_edit_text);
        this.r = customSingleEditTextView;
        customSingleEditTextView.setHint("请输入家族名称");
        this.r.setMaxWordCount(this.u);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131301109) {
            return;
        }
        String content = this.r.getContent();
        this.s = content;
        String replaceAll = content.replaceAll(" ", "");
        this.s = replaceAll;
        if (!com.rtk.app.tool.c0.q(replaceAll) && this.s.length() >= 2 && this.s.length() <= this.u) {
            new com.rtk.app.main.dialogPack.x(this.f147c, "确定修改家族名称", "您的家族名称将设置为:“" + this.s + "”。确定后一周内不可更改。", new com.rtk.app.tool.s() { // from class: com.rtk.app.main.family.f1
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    UpdateFamilyNameActivity.this.P(strArr);
                }
            }).show();
            return;
        }
        com.rtk.app.tool.f.a(this.f147c, "家族名称长度在1-10个字符", f.a.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_update_family_name_layout);
        this.t = (FamilyInfoBean) getIntent().getSerializableExtra("family_Info");
    }
}
