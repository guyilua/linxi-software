package com.rtk.app.main.coins;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alipay.sdk.app.PayTask;
import com.rtk.app.R;
import com.rtk.app.bean.ExchangeGoldCoinsBean;
import com.rtk.app.bean.OptionsBean;
import com.rtk.app.bean.PaymentMethodsBean;
import com.rtk.app.bean.QrcodePayBean;
import com.rtk.app.bean.RealNameAuthBean;
import com.rtk.app.bean.RechargeRCoinsBean;
import com.rtk.app.bean.WXPayOrderBean;
import com.rtk.app.bean.WechatH5PayBean;
import com.rtk.app.custom.NoOOMEditText;
import com.rtk.app.main.Home5Activity.RealNameAuthActivity;
import com.rtk.app.main.family.FamilyBaseActivity;
import com.rtk.app.main.family.FamilyProtocolActivity;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.w;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.umeng.analytics.pro.ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class RechargeRCoinsActivity extends FamilyBaseActivity {
    com.rtk.app.main.coins.a A;
    private double B;
    private boolean D;
    private String E;
    private String F;

    @BindView
    TextView account;

    @BindView
    View backLayout;

    @BindView
    View btnWechat;

    @BindView
    View btnWechatH5;

    @BindView
    View btnWechatQrcode;

    @BindView
    View btnZfb;

    @BindView
    View btnZfbH5;

    @BindView
    View btnZfbQrcode;

    @BindView
    View customMoneyLayout;

    @BindView
    TextView desc;

    @BindView
    NoOOMEditText etCustom;

    @BindView
    View exchangeGoldCoins;

    @BindView
    View goRecharge;

    @BindView
    GridView gridView;
    private IWXAPI r;

    @BindView
    TextView rCoins;

    @BindView
    TextView ratio;
    RechargeRCoinsBean.DataBean s;

    @BindView
    View selectPayLayout;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;
    ArrayList<OptionsBean> C = new ArrayList<>();
    private final Handler G = new e();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            com.rtk.app.tool.c.b(RechargeRCoinsActivity.this, RealNameAuthActivity.class, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements DialogInterface.OnClickListener {
        final /* synthetic */ boolean a;

        b(boolean z) {
            this.a = z;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            RechargeRCoinsActivity rechargeRCoinsActivity = RechargeRCoinsActivity.this;
            int[] iArr = new int[1];
            iArr[0] = this.a ? 5 : 6;
            rechargeRCoinsActivity.R(iArr);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements AdapterView.OnItemClickListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.main.comment.express.b.d(RechargeRCoinsActivity.this.etCustom);
            for (int i2 = 0; i2 < RechargeRCoinsActivity.this.C.size(); i2++) {
                OptionsBean optionsBean = RechargeRCoinsActivity.this.C.get(i2);
                if (i2 == i) {
                    optionsBean.setChecked(true);
                    RechargeRCoinsActivity.this.B = optionsBean.getRmb();
                } else {
                    optionsBean.setChecked(false);
                }
            }
            RechargeRCoinsActivity.this.A.notifyDataSetChanged();
            RechargeRCoinsActivity.this.z = false;
            RechargeRCoinsActivity.this.customMoneyLayout.setSelected(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class d implements Runnable {
        final /* synthetic */ String a;

        d(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Map payV2 = new PayTask(RechargeRCoinsActivity.this).payV2(new JSONObject(this.a).optJSONObject("data").optString("orderStr"), true);
                Message message = new Message();
                message.what = 1000;
                message.obj = payV2;
                RechargeRCoinsActivity.this.G.sendMessage(message);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class e extends Handler {
        e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1000) {
                return;
            }
            com.rtk.app.main.coins.e eVar = new com.rtk.app.main.coins.e((Map) message.obj);
            String a = "".equals(eVar.a()) ? "支付失败" : eVar.a();
            if (eVar.b().equals("9000")) {
                Toast.makeText((Context) RechargeRCoinsActivity.this, (CharSequence) "支付成功！", 0).show();
            } else {
                Toast.makeText((Context) RechargeRCoinsActivity.this, (CharSequence) a, 0).show();
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class f implements s {
        final /* synthetic */ int a;

        f(int i) {
            this.a = i;
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            RechargeRCoinsActivity.this.R(this.a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Q(boolean z) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("温馨提示");
        builder.setMessage(z ? "扫码支付适合微信在其他手机登录，生成二维码扫描支付。您确认需要生成支付二维码吗？" : "扫码支付适合支付宝在其他手机登录，生成二维码扫描支付。您确认需要生成支付二维码吗？");
        builder.setNegativeButton("取消", (DialogInterface.OnClickListener) null);
        builder.setPositiveButton("确定", new b(z));
        builder.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void S() {
        if (this.z) {
            String obj = this.etCustom.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                com.rtk.app.tool.f.a(this, "请输入充值金额。", f.a.f);
                return;
            }
            this.B = Double.valueOf(obj).doubleValue();
        }
        if (this.B == 0.0d) {
            com.rtk.app.tool.f.a(this, "充值金额不能为0。", f.a.f);
            return;
        }
        if (this.t) {
            R(1);
            return;
        }
        if (this.u) {
            R(2);
            return;
        }
        if (this.v) {
            Q(true);
            return;
        }
        if (this.w) {
            Q(false);
        } else if (this.x) {
            R(7);
        } else if (this.y) {
            R(8);
        }
    }

    private void U() {
        if (this.C.isEmpty()) {
            List<OptionsBean> options = this.s.getPrice().getOptions();
            if (!options.isEmpty() && !this.z) {
                options.get(0).setChecked(true);
                this.B = options.get(0).getRmb();
            }
            this.C.addAll(options);
            this.A.notifyDataSetChanged();
        }
    }

    private void V() {
        if (this.t || this.u || this.v || this.w || this.y || this.x) {
            return;
        }
        List<PaymentMethodsBean> paymentMethodsNew = this.s.getPaymentMethodsNew();
        if (paymentMethodsNew.isEmpty()) {
            this.selectPayLayout.setVisibility(8);
            return;
        }
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        for (int i = 0; i < paymentMethodsNew.size(); i++) {
            PaymentMethodsBean paymentMethodsBean = paymentMethodsNew.get(i);
            if ("wechatpay".equals(paymentMethodsBean.getId())) {
                z = paymentMethodsBean.isEnabled();
            } else if ("alipay".equals(paymentMethodsBean.getId())) {
                z2 = paymentMethodsBean.isEnabled();
            } else if ("wechatpayQrcode".equals(paymentMethodsBean.getId())) {
                z3 = paymentMethodsBean.isEnabled();
            } else if ("alipayQrcode".equals(paymentMethodsBean.getId())) {
                z4 = paymentMethodsBean.isEnabled();
            } else if ("wechatpayH5".equals(paymentMethodsBean.getId())) {
                z5 = paymentMethodsBean.isEnabled();
                this.E = paymentMethodsBean.getUrl();
            } else if ("alipayH5".equals(paymentMethodsBean.getId())) {
                z6 = paymentMethodsBean.isEnabled();
                this.F = paymentMethodsBean.getUrl();
            }
        }
        if (!z && !z2 && !z3 && !z4 && !z5 && !z6) {
            this.selectPayLayout.setVisibility(8);
            return;
        }
        this.btnWechat.setVisibility(z ? 0 : 8);
        this.btnZfb.setVisibility(z2 ? 0 : 8);
        this.btnWechatQrcode.setVisibility(z3 ? 0 : 8);
        this.btnZfbQrcode.setVisibility(z4 ? 0 : 8);
        this.btnWechatH5.setVisibility(z5 ? 0 : 8);
        this.btnZfbH5.setVisibility(z6 ? 0 : 8);
        if (z) {
            this.t = true;
            this.u = false;
            this.w = false;
            this.v = false;
            this.x = false;
            this.y = false;
            T(this.btnWechat, true);
            T(this.btnZfb, false);
            T(this.btnWechatQrcode, false);
            T(this.btnZfbQrcode, false);
            T(this.btnWechatH5, false);
            T(this.btnZfbH5, false);
            return;
        }
        if (z2) {
            this.t = false;
            this.u = true;
            this.w = false;
            this.v = false;
            this.x = false;
            this.y = false;
            T(this.btnWechat, false);
            T(this.btnZfb, true);
            T(this.btnWechatQrcode, false);
            T(this.btnZfbQrcode, false);
            T(this.btnWechatH5, false);
            T(this.btnZfbH5, false);
            return;
        }
        if (z3) {
            this.t = false;
            this.u = false;
            this.w = false;
            this.v = true;
            this.x = false;
            this.y = false;
            T(this.btnWechat, false);
            T(this.btnZfb, false);
            T(this.btnWechatQrcode, true);
            T(this.btnZfbQrcode, false);
            T(this.btnWechatH5, false);
            T(this.btnZfbH5, false);
            return;
        }
        if (z4) {
            this.t = false;
            this.u = false;
            this.w = true;
            this.v = false;
            this.x = false;
            this.y = false;
            T(this.btnWechat, false);
            T(this.btnZfb, false);
            T(this.btnWechatQrcode, false);
            T(this.btnZfbQrcode, true);
            T(this.btnWechatH5, false);
            T(this.btnZfbH5, false);
            return;
        }
        if (this.x) {
            this.t = false;
            this.u = false;
            this.w = false;
            this.v = false;
            this.x = true;
            this.y = false;
            T(this.btnWechat, false);
            T(this.btnZfb, false);
            T(this.btnWechatQrcode, false);
            T(this.btnZfbQrcode, false);
            T(this.btnWechatH5, true);
            T(this.btnZfbH5, false);
            return;
        }
        if (this.y) {
            this.t = false;
            this.u = false;
            this.w = false;
            this.v = false;
            this.x = false;
            this.y = true;
            T(this.btnWechat, false);
            T(this.btnZfb, false);
            T(this.btnWechatQrcode, false);
            T(this.btnZfbQrcode, false);
            T(this.btnWechatH5, false);
            T(this.btnZfbH5, true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void X(String str) {
        WXPayOrderBean.DataBean data = ((WXPayOrderBean) w(str, WXPayOrderBean.class)).getData();
        String appId = data.getAppId();
        if (this.r == null) {
            this.r = WXAPIFactory.createWXAPI(this, appId, true);
        }
        if (!this.r.isWXAppInstalled()) {
            Toast.makeText((Context) this, (CharSequence) "请安装微信后在进行授权登录", 0).show();
            return;
        }
        this.r.registerApp(appId);
        PayReq payReq = new PayReq();
        payReq.appId = data.getAppId();
        payReq.partnerId = data.getPartnerId();
        payReq.prepayId = data.getPrepayId();
        payReq.nonceStr = data.getNonceStr();
        payReq.timeStamp = data.getTimeStamp();
        payReq.packageValue = data.getPackageX();
        payReq.sign = data.getPaySign();
        Log.d("RechargeRCoinsActivity", "req=" + payReq);
        if (this.r.sendReq(payReq)) {
            return;
        }
        Toast.makeText((Context) this, (CharSequence) "签名失败!", 0).show();
        finish();
    }

    private void Y(String str) {
        new Thread(new d(str)).start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void R(int... iArr) {
        HashMap<String, String> l = y.l();
        switch (iArr[0]) {
            case 1:
                l.put("amount", this.B + "");
                l.put(ak.y, y.D());
                l.put(ak.J, y.p(this.f147c));
                l.put("device_id", y.o(this.f147c));
                l.put("key", t.L(l));
                h.j(this, this, y.e + "pay/wechat/order", 1, l);
                return;
            case 2:
                l.put("amount", this.B + "");
                l.put(ak.y, y.D());
                l.put(ak.J, y.p(this.f147c));
                l.put("device_id", y.o(this.f147c));
                l.put("key", t.L(l));
                h.j(this, this, y.e + "pay/alipay/order", 2, l);
                return;
            case 3:
                l.put(y.z("sign"), w.b(this, getPackageName()));
                l.put("key", t.L(l));
                h.l(this, this, 3, h.h(y.e).a(y.w("pay/page/rcoin", l)));
                return;
            case 4:
                l.put("key", t.L(l));
                h.j(this, this, y.e + "user/real-name-auth/query", 4, l);
                return;
            case 5:
                l.put("amount", this.B + "");
                l.put(ak.y, y.D());
                l.put(ak.J, y.p(this.f147c));
                l.put("device_id", y.o(this.f147c));
                l.put("key", t.L(l));
                h.j(this, this, y.e + "pay/wechat/order-qrcode", 5, l);
                return;
            case 6:
                l.put("amount", this.B + "");
                l.put(ak.y, y.D());
                l.put(ak.J, y.p(this.f147c));
                l.put("device_id", y.o(this.f147c));
                l.put("key", t.L(l));
                h.j(this, this, y.e + "pay/alipay/order-qrcode", 6, l);
                return;
            case 7:
                Intent intent = new Intent((Context) this, (Class<?>) RealPayH5Activity.class);
                intent.putExtra("amount", this.B + "");
                intent.putExtra("url", this.E);
                intent.putExtra(com.umeng.analytics.pro.d.y, iArr[0]);
                startActivity(intent);
                return;
            case 8:
                Intent intent2 = new Intent((Context) this, (Class<?>) RealPayH5Activity.class);
                intent2.putExtra("amount", this.B + "");
                intent2.putExtra("url", this.F);
                intent2.putExtra(com.umeng.analytics.pro.d.y, iArr[0]);
                startActivity(intent2);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void T(View view, boolean z) {
        view.setSelected(z);
        ((TextView) ((ViewGroup) view).getChildAt(1)).setTextColor(ContextCompat.getColor(this, z ? R.color.common_green_title : R.color.color_text_2));
    }

    public void W() {
        ExchangeGoldCoinsBean.DataBean.UserBean user = this.s.getUser();
        this.rCoins.setText("我的R币：" + user.getRcoin());
        this.account.setText("昵称：" + user.getNickname());
        V();
        this.customMoneyLayout.setVisibility(this.s.getPrice().isCustom() ? 0 : 8);
        this.desc.setText(this.s.getRcoinInfo().getDescriptions());
        this.ratio.setText("充值比例：" + this.s.getRcoinInfo().getRatio());
        U();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public synchronized void d(String str, int i) {
        c0.r("RechargeRCoinsActivity", "success,str=" + com.rtk.app.c.a.b(str));
        switch (i) {
            case 1:
                X(str);
                break;
            case 2:
                Y(str);
                break;
            case 3:
                F();
                RechargeRCoinsBean rechargeRCoinsBean = (RechargeRCoinsBean) w(str, RechargeRCoinsBean.class);
                if (rechargeRCoinsBean != null) {
                    RechargeRCoinsBean.DataBean data = rechargeRCoinsBean.getData();
                    this.s = data;
                    if (data != null) {
                        W();
                        break;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            case 4:
                RealNameAuthBean realNameAuthBean = (RealNameAuthBean) w(str, RealNameAuthBean.class);
                this.D = realNameAuthBean.getData() != null && realNameAuthBean.getData().isAuthenticated();
                break;
            case 5:
            case 6:
                QrcodePayBean qrcodePayBean = (QrcodePayBean) w(str, QrcodePayBean.class);
                if (qrcodePayBean != null && !TextUtils.isEmpty(qrcodePayBean.getData().getQrcode())) {
                    Intent intent = new Intent((Context) this, (Class<?>) QrCodePayActivity.class);
                    intent.putExtra("url", qrcodePayBean.getData().getQrcode());
                    intent.putExtra("money", this.B + "");
                    intent.putExtra(com.umeng.analytics.pro.d.y, getString(i == 5 ? R.string.wx_scanner_pay : R.string.alipay_scanner_pay));
                    startActivity(intent);
                    break;
                }
                return;
            case 7:
                WechatH5PayBean wechatH5PayBean = (WechatH5PayBean) w(str, WechatH5PayBean.class);
                if (wechatH5PayBean != null) {
                    if (wechatH5PayBean.getData() != null) {
                        String h5Url = wechatH5PayBean.getData().getH5Url();
                        if (!TextUtils.isEmpty(h5Url)) {
                            Bundle bundle = new Bundle();
                            bundle.putString("url", h5Url);
                            Log.d("rqy", "wechatUrl=" + this.E);
                            bundle.putString("Referer", this.E);
                            Log.d("rqy", "h5Url=" + h5Url);
                            bundle.putString("title", i == 7 ? "微信 H5 支付" : "支付宝 H5 支付");
                            com.rtk.app.tool.c.b(this, FamilyProtocolActivity.class, bundle);
                            break;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        c0.r("RechargeRCoinsActivity", "error,code:" + i + ",str=" + str + ",mark=" + i2);
        if (i2 == 3) {
            I(str, new f(i2));
        } else {
            com.rtk.app.tool.f.a(this, str, f.a.f);
        }
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initListener() {
        this.gridView.setOnItemClickListener(new c());
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
        super.initView();
        com.rtk.app.main.coins.a aVar = new com.rtk.app.main.coins.a(this, this.C);
        this.A = aVar;
        this.gridView.setAdapter((ListAdapter) aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.s == null) {
            return;
        }
        int id = view.getId();
        if (id != 2131297088) {
            if (id != 2131297802) {
                switch (id) {
                    case R.id.btn_wechat /* 2131296829 */:
                        this.t = true;
                        this.u = false;
                        this.v = false;
                        this.w = false;
                        this.x = false;
                        this.y = false;
                        T(this.btnWechat, true);
                        T(this.btnZfb, false);
                        T(this.btnWechatQrcode, false);
                        T(this.btnZfbQrcode, false);
                        T(this.btnWechatH5, false);
                        T(this.btnZfbH5, false);
                        return;
                    case R.id.btn_wechat_h5 /* 2131296830 */:
                        this.t = false;
                        this.u = false;
                        this.v = false;
                        this.w = false;
                        this.x = true;
                        this.y = false;
                        T(this.btnWechat, false);
                        T(this.btnZfb, false);
                        T(this.btnWechatQrcode, false);
                        T(this.btnZfbQrcode, false);
                        T(this.btnWechatH5, true);
                        T(this.btnZfbH5, false);
                        return;
                    case R.id.btn_wechat_qrcode /* 2131296831 */:
                        this.t = false;
                        this.u = false;
                        this.v = true;
                        this.w = false;
                        this.x = false;
                        this.y = false;
                        T(this.btnWechat, false);
                        T(this.btnZfb, false);
                        T(this.btnWechatQrcode, true);
                        T(this.btnZfbQrcode, false);
                        T(this.btnWechatH5, false);
                        T(this.btnZfbH5, false);
                        return;
                    case R.id.btn_zfb /* 2131296832 */:
                        this.t = false;
                        this.u = true;
                        this.v = false;
                        this.w = false;
                        this.x = false;
                        this.y = false;
                        T(this.btnWechat, false);
                        T(this.btnZfb, true);
                        T(this.btnWechatQrcode, false);
                        T(this.btnZfbQrcode, false);
                        T(this.btnWechatH5, false);
                        T(this.btnZfbH5, false);
                        return;
                    case R.id.btn_zfb_h5 /* 2131296833 */:
                        this.t = false;
                        this.u = false;
                        this.v = false;
                        this.w = false;
                        this.x = false;
                        this.y = true;
                        T(this.btnWechat, false);
                        T(this.btnZfb, false);
                        T(this.btnWechatQrcode, false);
                        T(this.btnZfbQrcode, false);
                        T(this.btnWechatH5, false);
                        T(this.btnZfbH5, true);
                        return;
                    case R.id.btn_zfb_qrcode /* 2131296834 */:
                        this.t = false;
                        this.u = false;
                        this.v = false;
                        this.w = true;
                        this.x = false;
                        this.y = false;
                        T(this.btnWechat, false);
                        T(this.btnZfb, false);
                        T(this.btnWechatQrcode, false);
                        T(this.btnZfbQrcode, true);
                        T(this.btnWechatH5, false);
                        T(this.btnZfbH5, false);
                        return;
                    default:
                        switch (id) {
                            case R.id.et_custom /* 2131297512 */:
                                break;
                            case R.id.exchange_gold_coins /* 2131297513 */:
                                if (y.x(this)) {
                                    startActivity(new Intent((Context) this, (Class<?>) ExchangeGoldCoinsActivity.class));
                                    return;
                                } else {
                                    t.w0(this);
                                    return;
                                }
                            default:
                                return;
                        }
                }
            } else {
                if (!this.D) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("温馨提示");
                    builder.setMessage("根据相关法律法规，需要实名认证后才可充值。点击确定进入实名认证界面。");
                    builder.setNegativeButton("取消", (DialogInterface.OnClickListener) null);
                    builder.setPositiveButton("确定", new a());
                    builder.show();
                    return;
                }
                S();
                return;
            }
        }
        Iterator<OptionsBean> it = this.C.iterator();
        while (it.hasNext()) {
            it.next().setChecked(false);
        }
        this.z = true;
        this.etCustom.setFocusable(true);
        this.etCustom.requestFocus();
        this.etCustom.requestFocusFromTouch();
        this.customMoneyLayout.setSelected(true);
        this.A.notifyDataSetChanged();
        com.rtk.app.main.comment.express.b.e(this.etCustom);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_coins_recharge_r_coins);
        ButterKnife.a(this);
        G(null, this.backLayout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        R(4);
        R(3);
    }
}
