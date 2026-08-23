package com.rtk.app.main.Home5Activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.adapter.SetThemeAdapter;
import com.rtk.app.base.BaseActivity;
import java.util.ArrayList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SetThemeActivity extends BaseActivity {
    private Context q;

    @BindView
    GridView setThemeGridView;

    @BindView
    TextView setThemeTopBack;

    @BindView
    LinearLayout setThemeTopLayout;

    @Override // com.rtk.app.base.BaseActivity
    public void A() {
        com.rtk.app.tool.t.S1(this.q, this.setThemeTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.bg1));
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.theme1));
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.theme2));
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.theme3));
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.theme4));
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.theme5));
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.theme6));
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.theme7));
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.theme8));
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.theme9));
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.theme10));
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.theme11));
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.theme12));
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.theme13));
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.theme14));
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.theme15));
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.theme16));
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.theme17));
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.theme18));
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.theme19));
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.theme20));
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.theme21));
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.theme22));
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.theme23));
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.theme24));
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.theme25));
        arrayList.add(Integer.valueOf(com.rtk.app.R.color.theme26));
        this.setThemeGridView.setAdapter((ListAdapter) new SetThemeAdapter(this.q, arrayList));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131300159) {
            return;
        }
        com.rtk.app.tool.c.a((Activity) this.q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_set_theme);
        ButterKnife.a(this);
        this.q = this;
    }
}
