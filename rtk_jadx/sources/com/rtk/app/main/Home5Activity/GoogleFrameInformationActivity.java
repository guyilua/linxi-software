package com.rtk.app.main.Home5Activity;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.base.BaseActivity;
import com.sigmob.sdk.downloader.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GoogleFrameInformationActivity extends BaseActivity {

    @BindView
    TextView googleFrameInformationApi;

    @BindView
    TextView googleFrameInformationBack;

    @BindView
    TextView googleFrameInformationBrand;

    @BindView
    TextView googleFrameInformationGoogleAllState;

    @BindView
    TextView googleFrameInformationGoogleManage;

    @BindView
    LinearLayout googleFrameInformationGoogleManageLv;

    @BindView
    TextView googleFrameInformationGooglePlayMarket;

    @BindView
    TextView googleFrameInformationGooglePlayServe;

    @BindView
    TextView googleFrameInformationGoogleServeState;

    @BindView
    TextView googleFrameInformationOpenGoogleList;

    @BindView
    TextView googleFrameInformationRootState;

    @BindView
    LinearLayout googleFrameInformationTopLv;

    @BindView
    TextView googleFrameInformationUninstallGoogle;

    @BindView
    TextView googleFrameInformationUseHelp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a extends ClickableSpan {
        a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            com.rtk.app.tool.f.a(GoogleFrameInformationActivity.this.f147c, "我被点击了", f.a.f);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(GoogleFrameInformationActivity.this.getResources().getColor(R.color.theme20));
            textPaint.setUnderlineText(true);
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.googleFrameInformationTopLv, null, null, ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0));
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        if ((com.rtk.app.tool.t.q1(this.f147c, "com.google.android.gsf") || com.rtk.app.tool.t.q1(this.f147c, "com.google.android.gms") || com.rtk.app.tool.t.q1(this.f147c, "com.android.vending")) && com.rtk.app.tool.t.q1(this.f147c, "com.google.android.gsf") && com.rtk.app.tool.t.q1(this.f147c, "com.google.android.gms") && com.rtk.app.tool.t.q1(this.f147c, "com.android.vending")) {
            if (com.rtk.app.tool.t.q1(this.f147c, "com.google.android.gsf") && com.rtk.app.tool.t.q1(this.f147c, "com.google.android.gms") && com.rtk.app.tool.t.q1(this.f147c, "com.android.vending") && (com.rtk.app.tool.y.h() >= 25 || com.rtk.app.tool.t.q1(this.f147c, "com.google.android.gsf.login"))) {
                this.googleFrameInformationGoogleAllState.setText("您的谷歌框架已完全安装");
                this.googleFrameInformationGoogleAllState.setTextColor(getResources().getColor(R.color.theme3));
                this.googleFrameInformationUninstallGoogle.setVisibility(0);
                this.googleFrameInformationOpenGoogleList.setVisibility(8);
            } else if (com.rtk.app.tool.t.q1(this.f147c, "com.google.android.gsf") && com.rtk.app.tool.t.q1(this.f147c, "com.google.android.gms") && com.rtk.app.tool.t.q1(this.f147c, "com.android.vending")) {
                this.googleFrameInformationGoogleAllState.setText("您的谷歌框架未完全安装");
                this.googleFrameInformationGoogleAllState.setTextColor(getResources().getColor(R.color.theme20));
                this.googleFrameInformationUninstallGoogle.setVisibility(8);
                this.googleFrameInformationOpenGoogleList.setVisibility(0);
            } else {
                this.googleFrameInformationGoogleAllState.setText("您的谷歌框架未安装");
                this.googleFrameInformationGoogleAllState.setTextColor(getResources().getColor(R.color.theme20));
                this.googleFrameInformationUninstallGoogle.setVisibility(8);
                this.googleFrameInformationOpenGoogleList.setVisibility(0);
            }
        } else {
            this.googleFrameInformationGoogleAllState.setText("您的谷歌框架未完全安装");
            this.googleFrameInformationGoogleAllState.setTextColor(getResources().getColor(R.color.theme20));
            this.googleFrameInformationUninstallGoogle.setVisibility(8);
            this.googleFrameInformationOpenGoogleList.setVisibility(0);
        }
        this.googleFrameInformationGoogleServeState.setText(com.rtk.app.tool.t.r1(this.f147c, "com.google.android.gsf").get("state"));
        this.googleFrameInformationGoogleServeState.setSelected(!com.rtk.app.tool.t.r1(this.f147c, "com.google.android.gsf").get(com.umeng.analytics.pro.d.y).equals("0"));
        this.googleFrameInformationGoogleManage.setText(com.rtk.app.tool.t.r1(this.f147c, "com.google.android.gsf.login").get("state"));
        this.googleFrameInformationGoogleManage.setSelected(!com.rtk.app.tool.t.r1(this.f147c, "com.google.android.gsf.login").get(com.umeng.analytics.pro.d.y).equals("0"));
        this.googleFrameInformationGooglePlayServe.setText(com.rtk.app.tool.t.r1(this.f147c, "com.google.android.gms").get("state"));
        this.googleFrameInformationGooglePlayServe.setSelected(!com.rtk.app.tool.t.r1(this.f147c, "com.google.android.gms").get(com.umeng.analytics.pro.d.y).equals("0"));
        this.googleFrameInformationGooglePlayMarket.setText(com.rtk.app.tool.t.r1(this.f147c, "com.android.vending").get("state"));
        this.googleFrameInformationGooglePlayMarket.setSelected(!com.rtk.app.tool.t.r1(this.f147c, "com.android.vending").get(com.umeng.analytics.pro.d.y).equals("0"));
        this.googleFrameInformationGoogleManageLv.setVisibility(com.rtk.app.tool.y.h() < 25 ? 0 : 8);
        this.googleFrameInformationBrand.setText(com.rtk.app.tool.y.p(this.f147c));
        this.googleFrameInformationApi.setText(com.rtk.app.tool.y.D());
        this.googleFrameInformationRootState.setText(com.rtk.app.tool.y.N() ? "已root" : "未root");
        SpannableString spannableString = new SpannableString("Tip:若谷歌框架无法使用，请使用安装器卸载后重新安装~");
        spannableString.setSpan(new a(), 17, 20, 33);
        this.googleFrameInformationUninstallGoogle.setHighlightColor(0);
        this.googleFrameInformationUninstallGoogle.setText(spannableString);
        this.googleFrameInformationUninstallGoogle.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131297837) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_google_frame_information);
        ButterKnife.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        initView();
    }
}
