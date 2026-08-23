package com.sigmob.sdk.nativead;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.SigmobRequestQueue;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.VolleyError;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.aj;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.BidResponse;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.network.d;
import com.sigmob.sdk.nativead.n;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.natives.WindNativeAdData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a extends Dialog implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, View.OnClickListener, s {
    private Context a;
    private Window b;

    /* renamed from: c, reason: collision with root package name */
    private int f600c;
    private int d;
    private BaseAdUnit e;
    private WindNativeAdData.DislikeInteractionCallback f;
    private List<String> g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private EditText l;
    private n m;
    private ViewGroup n;
    private boolean o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.sigmob.sdk.nativead.a$1, reason: invalid class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ BidResponse a;
        final /* synthetic */ Context b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f601c;

        AnonymousClass1(BidResponse bidResponse, Context context, String str) {
            this.a = bidResponse;
            this.b = context;
            this.f601c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sigmob.sdk.base.network.d dVar = new com.sigmob.sdk.base.network.d(com.sigmob.sdk.base.l.a().o(), this.a, new d.a() { // from class: com.sigmob.sdk.nativead.a.1.1
                @Override // com.sigmob.sdk.base.network.d.a
                public void a(JSONObject jSONObject) {
                    WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.nativead.a.1.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Context context;
                            String str;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            if (a.this.a(anonymousClass1.b, anonymousClass1.f601c)) {
                                context = AnonymousClass1.this.b;
                                str = "反馈上报成功，广告请求ID已复制到剪贴板";
                            } else {
                                context = AnonymousClass1.this.b;
                                str = "反馈上报成功,广告请求ID:" + AnonymousClass1.this.f601c;
                            }
                            aj.a(context, str, 1).show();
                        }
                    });
                }

                public void onErrorResponse(final VolleyError volleyError) {
                    WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.nativead.a.1.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            NetworkResponse networkResponse;
                            VolleyError volleyError2 = volleyError;
                            int i = (volleyError2 == null || (networkResponse = volleyError2.networkResponse) == null) ? 0 : networkResponse.statusCode;
                            aj.a(AnonymousClass1.this.b, "反馈上报失败，错误码: " + i, 1).show();
                        }
                    });
                }
            });
            SigmobRequestQueue sigRequestQueue = Networking.getSigRequestQueue();
            if (sigRequestQueue != null) {
                sigRequestQueue.add(dVar);
            }
        }
    }

    public a(Context context, BaseAdUnit baseAdUnit) {
        super(context, com.sigmob.sdk.base.g.e());
        this.b = null;
        this.g = new ArrayList();
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.e = baseAdUnit;
        int i = applicationContext.getResources().getDisplayMetrics().widthPixels;
        int i2 = this.a.getResources().getDisplayMetrics().heightPixels;
        int dipsToIntPixels = Dips.dipsToIntPixels(40.0f, this.a);
        if (i2 > i) {
            this.d = i - dipsToIntPixels;
            this.f600c = -2;
        } else {
            int i3 = i2 - dipsToIntPixels;
            this.d = i3;
            this.f600c = i3;
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, final String str3, final String str4) {
        ae.a(str, str2, this.e, new ae.a() { // from class: com.sigmob.sdk.nativead.a.4
            @Override // com.sigmob.sdk.base.common.ae.a
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                    pointEntitySigmob.setAdtype(String.valueOf(a.this.e.getAd_type()));
                    pointEntitySigmob.setLoad_id(a.this.e.getLoad_id());
                    pointEntitySigmob.setRequest_id(a.this.e.getRequestId());
                    pointEntitySigmob.setReason(str3);
                    pointEntitySigmob.setContent(str4);
                    pointEntitySigmob.setVid(a.this.e.getVid());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("", str));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void c() {
        this.g.clear();
        this.g.add("违法违规");
        this.g.add("疑似抄袭");
        this.g.add("虚假欺诈");
        this.g.add("低俗色情");
        this.g.add("诱导点击");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Context e = com.sigmob.sdk.b.e();
        BaseAdUnit baseAdUnit = this.e;
        if (baseAdUnit != null) {
            baseAdUnit.dislikeReport();
            if (com.sigmob.sdk.base.l.a().g()) {
                String requestId = this.e.getRequestId();
                BidResponse a = com.sigmob.sdk.base.common.h.a(requestId);
                if (a != null) {
                    ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new AnonymousClass1(a, e, requestId));
                    return;
                }
                return;
            }
        }
        aj.a(e, "感谢反馈", 1).show();
    }

    private void e() {
        Window window = getWindow();
        this.b = window;
        if (window != null) {
            window.setGravity(17);
            int g = com.sigmob.sdk.base.g.g();
            if (g != 0) {
                this.b.setWindowAnimations(g);
            }
            this.b.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = this.b.getAttributes();
            attributes.width = this.d;
            attributes.height = this.f600c;
            this.b.setAttributes(attributes);
        }
    }

    @Override // com.sigmob.sdk.nativead.s
    public void a() {
        BaseAdUnit baseAdUnit = this.e;
        if (baseAdUnit == null || (baseAdUnit.isDislikeReported() && this.e.getAd_type() != 5)) {
            aj.a(getContext(), "已提交反馈", 1).show();
        } else {
            show();
            a(PointCategory.DISLIKE, "click", "", "");
        }
    }

    @Override // com.sigmob.sdk.nativead.s
    public void a(WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback) {
        this.f = dislikeInteractionCallback;
    }

    public void b() {
        TextView textView = this.h;
        if (textView != null) {
            textView.setOnClickListener(null);
            this.h = null;
        }
        TextView textView2 = this.i;
        if (textView2 != null) {
            textView2.setOnClickListener(null);
            this.i = null;
        }
        TextView textView3 = this.j;
        if (textView3 != null) {
            textView3.setOnClickListener(null);
            this.j = null;
        }
        TextView textView4 = this.k;
        if (textView4 != null) {
            textView4.setOnClickListener(null);
            this.k = null;
        }
        if (this.f != null) {
            this.f = null;
        }
        setOnShowListener(null);
        setOnDismissListener(null);
        this.b = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        String obj;
        String str;
        int i = 0;
        String str2 = "";
        if (view.equals(this.i)) {
            String str3 = (String) this.i.getText();
            a(PointCategory.DISLIKE, PointCategory.ADNORMAL_SHOW, "", "");
            str2 = str3;
            i = 1;
        } else {
            if (view.equals(this.j)) {
                obj = (String) this.j.getText();
                i = 2;
                str = PointCategory.CANNOT_CLOSE;
            } else if (view.equals(this.h)) {
                obj = (String) this.h.getText();
                i = 3;
                str = PointCategory.NOINTEREST_CLICK;
            } else if (view.equals(this.k) && (editText = this.l) != null) {
                obj = editText.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    a(PointCategory.DISLIKE, PointCategory.ADVICE, "", Base64.encodeToString(obj.getBytes(), 0));
                    str2 = obj;
                    i = 5;
                }
                str2 = obj;
            }
            a(PointCategory.DISLIKE, str, "", "");
            str2 = obj;
        }
        d();
        WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback = this.f;
        if (dislikeInteractionCallback == null || i == 0) {
            return;
        }
        dislikeInteractionCallback.onSelected(i, str2, true);
        dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResourceUtil.getLayoutId(this.a, "sig_dislike_layout"));
        this.i = (TextView) findViewById(ResourceUtil.getId(this.a, "sig_not_show_tv"));
        this.j = (TextView) findViewById(ResourceUtil.getId(this.a, "sig_not_close_tv"));
        this.h = (TextView) findViewById(ResourceUtil.getId(this.a, "sig_dislike_tv"));
        this.k = (TextView) findViewById(ResourceUtil.getId(this.a, "sig_commit_sl"));
        this.l = (EditText) findViewById(ResourceUtil.getId(this.a, "sig_suggest_et"));
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.l.addTextChangedListener(new TextWatcher() { // from class: com.sigmob.sdk.nativead.a.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!TextUtils.isEmpty(editable.toString()) || a.this.k == null) {
                    return;
                }
                a.this.k.setTextColor(Color.parseColor("#C2C2C2"));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.k != null) {
                    a.this.k.setTextColor(Color.parseColor("#FE7E03"));
                }
            }
        });
        this.n = (ViewGroup) findViewById(ResourceUtil.getId(this.a, "sig_flow_sl"));
        n nVar = new n(this.a);
        this.m = nVar;
        nVar.setList(this.g);
        this.m.setOnItemClickListener(new n.e() { // from class: com.sigmob.sdk.nativead.a.3
            @Override // com.sigmob.sdk.nativead.n.e
            public void a(int i, String str) {
                a.this.d();
                a.this.a(PointCategory.DISLIKE, PointCategory.REPORT, String.valueOf(i), "");
                if (a.this.f != null) {
                    a.this.f.onSelected(4, str, true);
                    a.this.dismiss();
                }
            }
        });
        this.n.addView(this.m, new ViewGroup.LayoutParams(-1, -2));
        setOnShowListener(this);
        setOnDismissListener(this);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        e();
        SigmobLog.i("DisLikeDialog onCreate:" + this.d + ":" + this.f600c);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        SigmobLog.i("DisLikeDialog  onDismiss");
        WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback = this.f;
        if (dislikeInteractionCallback != null) {
            dislikeInteractionCallback.onCancel();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        SigmobLog.i("DisLikeDialog  onShow");
        WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback = this.f;
        if (dislikeInteractionCallback != null) {
            dislikeInteractionCallback.onShow();
        }
        n nVar = this.m;
        if (nVar != null) {
            nVar.b();
        }
    }
}
