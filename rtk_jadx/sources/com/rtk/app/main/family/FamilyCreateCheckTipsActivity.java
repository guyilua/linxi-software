package com.rtk.app.main.family;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.bean.FamilyCreateCheckBean;
import com.rtk.app.bean.FamilyCreateCheckTipsBean;
import com.rtk.app.main.Home5Activity.Home5MyExperienceActivity;
import com.rtk.app.main.Home5Activity.RealNameAuthActivity;
import com.rtk.app.main.coins.ExchangeGoldCoinsActivity;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyCreateCheckTipsActivity extends FamilyBaseActivity {

    @BindView
    LinearLayout content;

    @BindView
    TextView desc;
    FamilyCreateCheckTipsBean.DataBean r;
    ArrayList<FamilyCreateCheckBean> s = new ArrayList<>();

    @BindView
    TextView tips;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.rtk.app.tool.y.x(FamilyCreateCheckTipsActivity.this)) {
                com.rtk.app.tool.t.w0(FamilyCreateCheckTipsActivity.this);
                return;
            }
            int intValue = ((Integer) view.getTag()).intValue();
            Bundle bundle = new Bundle();
            Class cls = RealNameAuthActivity.class;
            if (intValue == 1) {
                cls = Home5MyExperienceActivity.class;
            } else if (intValue == 2) {
                cls = ExchangeGoldCoinsActivity.class;
            } else if (intValue == 3) {
                cls = FamilyListActivity.class;
            } else if (intValue == 4) {
                cls = MyApplyFamilyListActivity.class;
            }
            com.rtk.app.tool.c.b(FamilyCreateCheckTipsActivity.this, cls, bundle);
        }
    }

    private boolean N(FamilyCreateCheckTipsBean.DataBean dataBean) {
        this.s.clear();
        this.s.add(dataBean.getCheckRealNameAuth());
        this.s.add(dataBean.getCheckLevel());
        this.s.add(dataBean.getCheckCoin());
        this.s.add(dataBean.getCheckFamily());
        this.s.add(dataBean.getCheckApplyFamily());
        Iterator<FamilyCreateCheckBean> it = this.s.iterator();
        while (it.hasNext()) {
            FamilyCreateCheckBean next = it.next();
            if (next != null && next.getIs_ok() != 1) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"ResourceAsColor"})
    private void P() {
        this.tips.setText(this.r.getCreateTips());
        this.desc.setText(this.r.getCreateDesc());
        this.content.removeAllViews();
        for (int i = 0; i < this.s.size(); i++) {
            FamilyCreateCheckBean familyCreateCheckBean = this.s.get(i);
            if (familyCreateCheckBean != null) {
                View inflate = LayoutInflater.from(this).inflate(R.layout.family_create_check_tips_item_layout, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.tips);
                TextView textView2 = (TextView) inflate.findViewById(2131297103);
                TextView textView3 = (TextView) inflate.findViewById(R.id.go);
                textView3.setTag(Integer.valueOf(i));
                if (familyCreateCheckBean.getIs_ok() != 1) {
                    textView3.setBackgroundResource(R.drawable.shape_corner_white_solid_white_5dp);
                    textView3.setText("去完成");
                    textView3.setTextColor(getResources().getColor(R.color.theme1));
                    textView3.setOnClickListener(new a());
                } else if (i != 3 && i != 4) {
                    textView3.setBackgroundResource(R.drawable.shape_corner_theme35_5dp);
                    textView3.setTextColor(-16777216);
                    textView3.setText("已完成");
                }
                textView.setText(familyCreateCheckBean.getTips());
                textView2.setText(familyCreateCheckBean.getDesc());
                this.content.addView(inflate);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void O(int... iArr) {
        if (iArr[0] != 1) {
            return;
        }
        HashMap<String, String> l = com.rtk.app.tool.y.l();
        l.put("key", com.rtk.app.tool.t.L(l));
        com.rtk.app.tool.o.h.l(this, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(com.rtk.app.tool.y.w("family/create/check", l)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public synchronized void d(String str, int i) {
        if (i == 1) {
            FamilyCreateCheckTipsBean.DataBean data = ((FamilyCreateCheckTipsBean) w(str, FamilyCreateCheckTipsBean.class)).getData();
            this.r = data;
            if (data == null) {
                return;
            }
            if (N(data)) {
                startActivity(new Intent((Context) this, (Class<?>) FamilyCreateActivity.class));
                finish();
                return;
            }
            P();
        } else if (i == 2) {
            com.rtk.app.tool.f.a(this, "成功取消申请加入家族", f.a.f);
            O(1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this, str, f.a.f);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_family_create_checkout_tips_layout);
        ButterKnife.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        O(1);
    }
}
