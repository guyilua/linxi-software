package com.rtk.app.main.family;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.bean.TagsBean;
import com.rtk.app.custom.NoOOMEditText;
import com.sigmob.sdk.downloader.f;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyCreateModuleActivity extends FamilyBaseActivity {

    @BindView
    TextView goCreate;

    @BindView
    NoOOMEditText nameEditText;
    private String r;

    @BindView
    TextView save;

    @BindView
    TextView title;
    private boolean s = false;
    private TagsBean t = null;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        super.d(str, i);
        com.rtk.app.tool.f.a(this, this.s ? "版块编辑成功" : "版块创建成功", 1);
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this, str, 1);
        super.g(i, str, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        int id = view.getId();
        if (id == 2131297799 || id == 2131300067) {
            String trim = this.nameEditText.getText().toString().trim();
            if (!TextUtils.isEmpty(trim) && trim.length() >= 2) {
                HashMap<String, String> l = com.rtk.app.tool.y.l();
                l.put("name", trim);
                l.put("family_id", this.r);
                if (this.s) {
                    l.put("tag_id", this.t.getId() + "");
                    str = "family/bbs/module/edit";
                } else {
                    str = "family/bbs/module/add";
                }
                l.put("key", com.rtk.app.tool.t.L(l));
                com.rtk.app.tool.o.h.j(this, this, com.rtk.app.tool.y.e + str, 0, l);
                return;
            }
            com.rtk.app.tool.f.a(this, "版块名不能少于2个字", f.a.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_create_family_module);
        ButterKnife.a(this);
        this.r = getIntent().getStringExtra("family_id");
        TagsBean tagsBean = (TagsBean) getIntent().getSerializableExtra("sub_module");
        this.t = tagsBean;
        boolean z = tagsBean != null;
        this.s = z;
        if (z) {
            this.title.setText(R.string.edit_module_name);
            this.save.setVisibility(0);
            this.goCreate.setVisibility(8);
            this.nameEditText.setText(this.t.getName());
        }
    }
}
