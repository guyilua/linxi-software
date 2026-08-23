package com.rtk.app.main.family;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.rtk.app.R;
import com.rtk.app.bean.FamilyCreateCheckTipsBean;
import com.sigmob.sdk.downloader.f;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class NoFamilyActivity extends FamilyBaseActivity {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public synchronized void d(String str, int i) {
        Intent intent;
        if (j1.a(((FamilyCreateCheckTipsBean) w(str, FamilyCreateCheckTipsBean.class)).getData())) {
            intent = new Intent((Context) this, (Class<?>) FamilyCreateActivity.class);
        } else {
            intent = new Intent((Context) this, (Class<?>) FamilyCreateCheckTipsActivity.class);
        }
        startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this, str, f.a.f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != 2131297800) {
            if (id != 2131298263) {
                return;
            }
            Intent intent = new Intent((Context) this, (Class<?>) HotFamilyActivity.class);
            intent.putExtra("is_search_family", true);
            startActivity(intent);
            return;
        }
        if (!com.rtk.app.tool.y.x(this)) {
            com.rtk.app.tool.t.w0(this);
            return;
        }
        HashMap<String, String> l = com.rtk.app.tool.y.l();
        l.put("key", com.rtk.app.tool.t.L(l));
        com.rtk.app.tool.o.h.l(this, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(com.rtk.app.tool.y.w("family/create/check", l)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_no_family_layout);
    }
}
