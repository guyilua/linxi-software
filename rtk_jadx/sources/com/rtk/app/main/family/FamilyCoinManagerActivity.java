package com.rtk.app.main.family;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.bean.FamilyInfoBean;
import com.rtk.app.custom.CustomSingleEditTextView;
import com.rtk.app.main.dialogPack.JoinFamilyDialog;
import com.sigmob.sdk.downloader.f;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyCoinManagerActivity extends FamilyBaseActivity {

    @BindView
    TextView coinNum;
    int r;
    private String s;
    JoinFamilyDialog t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements JoinFamilyDialog.a {
        final /* synthetic */ CustomSingleEditTextView a;
        final /* synthetic */ boolean b;

        a(CustomSingleEditTextView customSingleEditTextView, boolean z) {
            this.a = customSingleEditTextView;
            this.b = z;
        }

        /* JADX WARN: Type inference failed for: r4v5, types: [android.content.Context, com.rtk.app.main.family.FamilyCoinManagerActivity] */
        @Override // com.rtk.app.main.dialogPack.JoinFamilyDialog.a
        public void a(String str) {
            String trim = this.a.getContent().trim();
            if (TextUtils.isEmpty(trim)) {
                com.rtk.app.tool.f.a(FamilyCoinManagerActivity.this, "请输入金币数量", f.a.f);
                return;
            }
            FamilyCoinManagerActivity.this.r = Integer.parseInt(trim);
            ?? r4 = FamilyCoinManagerActivity.this;
            int i = r4.r;
            if (i == 0) {
                com.rtk.app.tool.f.a(r4, "金币数量不能为0", f.a.f);
            } else {
                if (i > 10000) {
                    com.rtk.app.tool.f.a(r4, "金币数量不能大于10000", f.a.f);
                    return;
                }
                int[] iArr = new int[1];
                iArr[0] = this.b ? 2 : 3;
                r4.N(iArr);
            }
        }

        @Override // com.rtk.app.main.dialogPack.JoinFamilyDialog.a
        public void b(String str) {
            FamilyCoinManagerActivity.this.t.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ CharSequence O(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if ("".equals(charSequence.toString()) || charSequence.toString().matches("[0-9]*")) {
            return null;
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.view.ViewGroup, com.rtk.app.custom.CustomSingleEditTextView] */
    private void P(boolean z) {
        JoinFamilyDialog joinFamilyDialog = this.t;
        if (joinFamilyDialog == null) {
            this.t = new JoinFamilyDialog(this);
        } else if (joinFamilyDialog.isShowing()) {
            return;
        }
        ?? a2 = this.t.a();
        a2.setBackground(ContextCompat.getDrawable(this, R.color.theme35));
        a2.getEditText().setInputType(2);
        a2.setContent("");
        a2.setHint("请输入金币数量");
        a2.setMaxWordCount(5, new InputFilter() { // from class: com.rtk.app.main.family.i
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return FamilyCoinManagerActivity.O(charSequence, i, i2, spanned, i3, i4);
            }
        });
        this.t.j(z ? "转入金币" : "转出金币");
        this.t.g(z ? "把我的金币转入到家族金币" : "把家族金币转入到我的金币");
        this.t.h(getString(R.string.ok));
        this.t.e(new a(a2, z));
        this.t.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void N(int... iArr) {
        HashMap<String, String> l = com.rtk.app.tool.y.l();
        l.put("family_id", this.s);
        int i = iArr[0];
        if (i == 1) {
            l.put("key", com.rtk.app.tool.t.L(l));
            com.rtk.app.tool.o.h.l(this, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(com.rtk.app.tool.y.w("family/home-page", l)));
            return;
        }
        if (i == 2) {
            l.put("coin", this.r + "");
            l.put("key", com.rtk.app.tool.t.L(l));
            com.rtk.app.tool.o.h.j(this, this, com.rtk.app.tool.y.e + "family/coin/in", 2, l);
            return;
        }
        if (i != 3) {
            return;
        }
        l.put("coin", this.r + "");
        l.put("key", com.rtk.app.tool.t.L(l));
        com.rtk.app.tool.o.h.j(this, this, com.rtk.app.tool.y.e + "family/coin/out", 3, l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public synchronized void d(String str, int i) {
        com.rtk.app.tool.c0.r("FamilyCoinManagerActivity", "success,str:" + str);
        if (i == 1) {
            FamilyInfoBean familyInfoBean = (FamilyInfoBean) this.g.fromJson(str, FamilyInfoBean.class);
            if (familyInfoBean == null) {
                return;
            }
            FamilyInfoBean.DataBean data = familyInfoBean.getData();
            if (data == null) {
            } else {
                this.coinNum.setText(data.getFamily_coin());
            }
        } else if (i == 2) {
            JoinFamilyDialog joinFamilyDialog = this.t;
            if (joinFamilyDialog != null && joinFamilyDialog.isShowing()) {
                this.t.dismiss();
            }
            com.rtk.app.tool.f.a(this, "转入成功", f.a.f);
            N(1);
        } else if (i == 3) {
            JoinFamilyDialog joinFamilyDialog2 = this.t;
            if (joinFamilyDialog2 != null && joinFamilyDialog2.isShowing()) {
                this.t.dismiss();
            }
            com.rtk.app.tool.f.a(this, "转出成功", f.a.f);
            N(1);
        }
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
        if (id == 2131296921) {
            Intent intent = new Intent((Context) this, (Class<?>) FamilyCoinDetailActivity.class);
            intent.putExtra("family_id", this.s);
            startActivity(intent);
        } else if (id == 2131297798) {
            P(false);
        } else {
            if (id != 2131297802) {
                return;
            }
            P(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_family_coin_manager_layout);
        ButterKnife.a(this);
        String stringExtra = getIntent().getStringExtra("family_id");
        this.s = stringExtra;
        if (stringExtra == null) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        N(1);
    }
}
