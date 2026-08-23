package com.rtk.app.main.family;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.bean.FamilyInfoBean;
import com.rtk.app.bean.TagsBean;
import com.rtk.app.custom.CustomTextView;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilySetModuleActivity extends FamilyBaseActivity {

    @BindView
    View create_module;

    @BindView
    LinearLayout moduleLayout;
    private FamilyInfoBean.DataBean r;
    List<TagsBean> s;
    private String t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements View.OnClickListener {
        final /* synthetic */ TagsBean a;

        a(TagsBean tagsBean) {
            this.a = tagsBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent((Context) FamilySetModuleActivity.this, (Class<?>) FamilyCreateModuleActivity.class);
            intent.putExtra("sub_module", this.a);
            intent.putExtra("family_id", FamilySetModuleActivity.this.r.getFamily_id());
            FamilySetModuleActivity.this.startActivity(intent);
        }
    }

    private void Q() {
        FamilyInfoBean.DataBean dataBean = this.r;
        if (dataBean == null || dataBean.getModule() == null) {
            return;
        }
        List<TagsBean> sublist = this.r.getModule().getSublist();
        this.s = sublist;
        if (sublist == null) {
            return;
        }
        this.moduleLayout.removeAllViews();
        for (TagsBean tagsBean : this.s) {
            AppCompatTextView O = O(tagsBean);
            this.moduleLayout.addView(O);
            O.setOnClickListener(new a(tagsBean));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.appcompat.widget.AppCompatTextView, com.rtk.app.custom.CustomTextView, android.widget.TextView] */
    public CustomTextView O(TagsBean tagsBean) {
        ?? customTextView = new CustomTextView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = com.rtk.app.tool.h.a(8.0f, this);
        customTextView.setLayoutParams(layoutParams);
        customTextView.setPadding(com.rtk.app.tool.h.a(20.0f, this), com.rtk.app.tool.h.a(15.0f, this), com.rtk.app.tool.h.a(20.0f, this), com.rtk.app.tool.h.a(15.0f, this));
        customTextView.setTextSize(17.0f);
        customTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(this, R.mipmap.icon_angle), (Drawable) null);
        customTextView.setCompoundDrawablePadding(5);
        customTextView.setTextColor(getResources().getColor(2131099690));
        customTextView.setLeftText(tagsBean.getName());
        customTextView.setTag(Integer.valueOf(tagsBean.getId()));
        customTextView.setBackgroundColor(-1);
        return customTextView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void P(int... iArr) {
        if (iArr[0] != 1) {
            return;
        }
        HashMap<String, String> l = com.rtk.app.tool.y.l();
        l.put("family_id", this.t);
        l.put("key", com.rtk.app.tool.t.L(l));
        com.rtk.app.tool.o.h.l(this, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(com.rtk.app.tool.y.w("family/home-page", l)));
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.r("FamilySetModuleActivity", "success,str:" + str);
        if (i != 1) {
            return;
        }
        this.r = ((FamilyInfoBean) w(str, FamilyInfoBean.class)).getData();
        Q();
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initListener() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != 2131297084) {
            if (id != 2131297862) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("url", "user/agreement/family/module-help");
            bundle.putString("title", "家族设置版块帮助");
            com.rtk.app.tool.c.b(this, FamilyProtocolActivity.class, bundle);
            return;
        }
        FamilyInfoBean.DataBean dataBean = this.r;
        if (dataBean == null || dataBean.getModule() == null) {
            return;
        }
        Intent intent = new Intent((Context) this, (Class<?>) FamilyCreateModuleActivity.class);
        intent.putExtra("family_id", this.r.getFamily_id());
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_family_set_module);
        ButterKnife.a(this);
        this.t = getIntent().getStringExtra("family_id");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        P(1);
    }
}
