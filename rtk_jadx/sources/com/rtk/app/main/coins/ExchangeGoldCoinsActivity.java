package com.rtk.app.main.coins;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.bean.ExchangeGoldCoinsBean;
import com.rtk.app.bean.OptionsBean;
import com.rtk.app.custom.NoOOMEditText;
import com.rtk.app.main.Home5Activity.Home5MyGoldActivity;
import com.rtk.app.main.family.FamilyBaseActivity;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.f;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ExchangeGoldCoinsActivity extends FamilyBaseActivity {

    @BindView
    View backLayout;

    @BindView
    TextView coins;

    @BindView
    View customMoneyLayout;

    @BindView
    NoOOMEditText etCustom;

    @BindView
    View exchangeRecord;

    @BindView
    GridView gridView;

    @BindView
    TextView manager;

    @BindView
    View pwdLayout;
    ArrayList<OptionsBean> r = new ArrayList<>();

    @BindView
    TextView rCoins;

    @BindView
    TextView ratio;

    @BindView
    TextView recharge;
    com.rtk.app.main.coins.b s;
    private int t;

    @BindView
    TextView tips;
    private boolean u;
    ExchangeGoldCoinsBean.DataBean v;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.main.comment.express.b.d(ExchangeGoldCoinsActivity.this.etCustom);
            for (int i2 = 0; i2 < ExchangeGoldCoinsActivity.this.r.size(); i2++) {
                OptionsBean optionsBean = ExchangeGoldCoinsActivity.this.r.get(i2);
                if (i2 == i) {
                    optionsBean.setChecked(true);
                    ExchangeGoldCoinsActivity.this.t = optionsBean.getRcoin();
                } else {
                    optionsBean.setChecked(false);
                }
            }
            ExchangeGoldCoinsActivity.this.s.notifyDataSetChanged();
            ExchangeGoldCoinsActivity.this.u = false;
            ExchangeGoldCoinsActivity.this.customMoneyLayout.setSelected(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ExchangeGoldCoinsActivity.this.P(2);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements s {
        final /* synthetic */ int a;

        c(int i) {
            this.a = i;
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            ExchangeGoldCoinsActivity.this.P(this.a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Q() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("温馨提示");
        builder.setMessage("确认使用" + this.t + "R币兑换金币吗？");
        builder.setPositiveButton("确定", new b());
        builder.setNegativeButton("取消", (DialogInterface.OnClickListener) null);
        builder.show();
    }

    private void R() {
        this.customMoneyLayout.setVisibility(this.v.getExchange().isCustom() ? 0 : 8);
        this.r.clear();
        List<OptionsBean> options = this.v.getExchange().getOptions();
        if (!options.isEmpty()) {
            options.get(0).setChecked(true);
            this.t = options.get(0).getRcoin();
        }
        this.r.addAll(options);
        this.s.notifyDataSetChanged();
        this.tips.setText(this.v.getTips());
        this.ratio.setText(this.v.getExchange().getRatio());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void P(int... iArr) {
        HashMap<String, String> l = y.l();
        int i = iArr[0];
        if (i == 1) {
            l.put("key", t.L(l));
            h.l(this, this, 1, h.h(y.e).a(y.w("pay/page/exchange-coin", l)));
            return;
        }
        if (i != 2) {
            return;
        }
        l.put("rcoin", this.t + "");
        l.put("key", t.L(l));
        h.j(this, this, y.e + "pay/coin/exchange", 2, l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public synchronized void d(String str, int i) {
        c0.r("ExchangeGoldCoinsActivity", "success,str=" + str);
        int i2 = 0;
        if (i == 1) {
            F();
            ExchangeGoldCoinsBean.DataBean data = ((ExchangeGoldCoinsBean) w(str, ExchangeGoldCoinsBean.class)).getData();
            if (data == null) {
                return;
            }
            this.rCoins.setText(data.getUser().getRcoin());
            this.coins.setText(data.getUser().getCoin());
            ExchangeGoldCoinsBean.DataBean dataBean = this.v;
            if (dataBean != null) {
                View view = this.customMoneyLayout;
                if (!dataBean.getExchange().isCustom()) {
                    i2 = 8;
                }
                view.setVisibility(i2);
                return;
            }
            this.v = data;
            R();
        } else if (i == 2) {
            f.a(this, "兑换成功", f.a.f);
            P(1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (i2 == 1) {
            I(str, new c(i2));
            return;
        }
        com.rtk.app.tool.f.a(this, str, f.a.f);
        c0.r("ExchangeGoldCoinsActivity", "error,code:" + i + ",str=" + str + ",mark=" + i2);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initData() {
        super.initData();
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initListener() {
        this.gridView.setOnItemClickListener(new a());
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
        super.initView();
        com.rtk.app.main.coins.b bVar = new com.rtk.app.main.coins.b(this, this.r);
        this.s = bVar;
        this.gridView.setAdapter((ListAdapter) bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.v == null) {
            return;
        }
        switch (view.getId()) {
            case R.id.custom_money_layout /* 2131297088 */:
            case R.id.et_custom /* 2131297512 */:
                Iterator<OptionsBean> it = this.r.iterator();
                while (it.hasNext()) {
                    it.next().setChecked(false);
                }
                this.u = true;
                this.etCustom.setFocusable(true);
                this.etCustom.requestFocus();
                this.etCustom.requestFocusFromTouch();
                this.customMoneyLayout.setSelected(true);
                this.s.notifyDataSetChanged();
                com.rtk.app.main.comment.express.b.e(this.etCustom);
                return;
            case R.id.go_recharge /* 2131297802 */:
                if (this.u) {
                    String obj = this.etCustom.getText().toString();
                    if (TextUtils.isEmpty(obj)) {
                        com.rtk.app.tool.f.a(this, "请输入兑换金额。", f.a.f);
                        return;
                    }
                    this.t = Integer.valueOf(obj).intValue();
                }
                if (this.t == 0) {
                    com.rtk.app.tool.f.a(this, "兑换金额不能为0。", f.a.f);
                    return;
                } else {
                    Q();
                    return;
                }
            case R.id.manager /* 2131299023 */:
                com.rtk.app.tool.c.b(this, Home5MyGoldActivity.class, null);
                return;
            case R.id.recharge /* 2131299984 */:
                if (y.x(this)) {
                    com.rtk.app.tool.c.b(this, RechargeRCoinsActivity.class, null);
                    return;
                } else {
                    t.w0(this);
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_coins_exchange_gold_coins);
        ButterKnife.a(this);
        G(null, this.backLayout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        P(1);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected List<View> x() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this.pwdLayout);
        return arrayList;
    }
}
