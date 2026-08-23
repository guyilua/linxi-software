package com.qq.e.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.qq.e.comm.managers.a;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ADActivity extends Activity {
    public static final String NOTCH_CONTAINER_TAG = "NOTCH_CONTAINER";
    protected ACTD a;
    private FrameLayout b;

    private void a() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        super.setContentView(linearLayout);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setTag(NOTCH_CONTAINER_TAG);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(frameLayout);
        this.b = new FrameLayout(this);
        this.b.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.addView(this.b);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ACTD actd = this.a;
        if (actd != null) {
            actd.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        ACTD actd = this.a;
        if (actd != null) {
            actd.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ACTD actd = this.a;
        if (actd != null) {
            actd.onConfigurationChanged(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        String str = null;
        try {
            POFactory pOFactory = a.b().c().getPOFactory();
            if (pOFactory != null) {
                Intent intent = getIntent();
                intent.setExtrasClassLoader(pOFactory.getClass().getClassLoader());
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    str = extras.getString(ACTD.DELEGATE_NAME_KEY);
                    String string = extras.getString(ACTD.APPID_KEY);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(string) && a.b().d()) {
                        ACTD activityDelegate = pOFactory.getActivityDelegate(str, this);
                        this.a = activityDelegate;
                        if (activityDelegate == null) {
                            GDTLogger.e("创建 ADActivity Delegate " + str + " 失败");
                        }
                    }
                }
            }
        } catch (Throwable th) {
            GDTLogger.e("创建ADActivity Delegate" + str + "发生异常", th);
        }
        ACTD actd = this.a;
        if (actd != null) {
            actd.onBeforeCreate(bundle);
        } else {
            try {
                finish();
            } catch (Throwable th2) {
                GDTLogger.e("ADActivity onCreate 发生异常", th2);
            }
        }
        try {
            super.onCreate(bundle);
        } catch (Throwable th3) {
            com.qq.e.comm.managers.plugin.a.a(th3, "ADActivity onCreate 发生异常");
            GDTLogger.e("ADActivity onCreate 发生异常", th3);
        }
        ACTD actd2 = this.a;
        if (actd2 != null) {
            actd2.onAfterCreate(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ACTD actd = this.a;
        if (actd != null) {
            actd.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        ACTD actd = this.a;
        if (actd != null) {
            actd.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        ACTD actd = this.a;
        if (actd != null) {
            actd.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        ACTD actd = this.a;
        if (actd != null) {
            actd.onStop();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        a();
        LayoutInflater.from(this).inflate(i, (ViewGroup) this.b, true);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        a();
        this.b.addView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a();
        this.b.addView(view, layoutParams);
    }
}
