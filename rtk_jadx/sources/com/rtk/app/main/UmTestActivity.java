package com.rtk.app.main;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.rtk.app.R;
import com.rtk.app.base.BaseActivity;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.MobclickAgent;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UmTestActivity extends BaseActivity {
    private Context q;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UmTestActivity.this.O();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MobclickAgent.reportError(UmTestActivity.this.q, "UmengException");
            try {
                UmTestActivity.this.O();
            } catch (Throwable th) {
                MobclickAgent.reportError(UmTestActivity.this.q, th);
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements View.OnClickListener {
        c(UmTestActivity umTestActivity) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("new api [user exception is eeeeeeeeee]");
            UMCrash.generateCustomLog(stringBuffer.toString(), "UmengException");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                UmTestActivity.this.O();
            } catch (Throwable th) {
                UMCrash.generateCustomLog(th, "UmengException");
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MobclickAgent.reportError(UmTestActivity.this.q, "UmengException");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                UmTestActivity.this.O();
            } catch (Throwable th) {
                MobclickAgent.reportError(UmTestActivity.this.q, th);
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UmTestActivity.this.P(0);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class h implements View.OnClickListener {
        h(UmTestActivity umTestActivity) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            while (true) {
                try {
                    Thread.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public UmTestActivity() {
        new ArrayList(f.a.f548c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        String str = null;
        str.equals("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(int i) {
        stringFromJNI();
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_um_test);
        this.q = this;
        findViewById(R.id.button_java_null_potion).setOnClickListener(new a());
        findViewById(R.id.button_user_1).setOnClickListener(new b());
        findViewById(R.id.button_user_1).setOnClickListener(new c(this));
        findViewById(R.id.button_user_2).setOnClickListener(new d());
        findViewById(R.id.button_user_3).setOnClickListener(new e());
        findViewById(R.id.button_user_4).setOnClickListener(new f());
        findViewById(R.id.button_native_crash).setOnClickListener(new g());
        findViewById(R.id.button_anr).setOnClickListener(new h(this));
    }

    public native String stringFromJNI();
}
