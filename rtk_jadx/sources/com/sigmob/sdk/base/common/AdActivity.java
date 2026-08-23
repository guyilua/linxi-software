package com.sigmob.sdk.base.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.videoAd.BaseAdActivity;
import java.lang.reflect.Field;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AdActivity extends BaseAdActivity implements k {
    private j k;
    private String l;

    private j a(BaseAdUnit baseAdUnit, Bundle bundle) {
        String stringExtra = getIntent().getStringExtra("ad_view_class_name");
        stringExtra.hashCode();
        char c2 = 65535;
        switch (stringExtra.hashCode()) {
            case -1961669118:
                if (stringExtra.equals(BaseAdActivity.e)) {
                    c2 = 0;
                    break;
                }
                break;
            case -1552818374:
                if (stringExtra.equals(BaseAdActivity.a)) {
                    c2 = 1;
                    break;
                }
                break;
            case -959624923:
                if (stringExtra.equals(BaseAdActivity.f)) {
                    c2 = 2;
                    break;
                }
                break;
            case -934326481:
                if (stringExtra.equals("reward")) {
                    c2 = 3;
                    break;
                }
                break;
            case 84003691:
                if (stringExtra.equals(BaseAdActivity.j)) {
                    c2 = 4;
                    break;
                }
                break;
            case 104156535:
                if (stringExtra.equals(BaseAdActivity.f649c)) {
                    c2 = 5;
                    break;
                }
                break;
            case 662743940:
                if (stringExtra.equals(BaseAdActivity.d)) {
                    c2 = 6;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return new com.sigmob.sdk.nativead.w(this, baseAdUnit, getIntent().getExtras(), bundle, this.l, this);
            case 1:
                return new w(this, baseAdUnit, getIntent().getExtras(), bundle, this.l, this);
            case 2:
                return new com.sigmob.sdk.nativead.t(this, baseAdUnit, getIntent().getExtras(), bundle, this.l, this);
            case 3:
                return new com.sigmob.sdk.videoAd.n(this, baseAdUnit, getIntent().getExtras(), bundle, this.l, this);
            case 4:
                return new com.sigmob.sdk.newInterstitial.h(this, baseAdUnit, getIntent().getExtras(), bundle, this.l, this);
            case 5:
                return new com.sigmob.sdk.mraid.n(this, baseAdUnit, getIntent().getExtras(), bundle, this.l, this);
            case 6:
                return new com.sigmob.sdk.mraid2.p(this, baseAdUnit, getIntent().getExtras(), bundle, this.l, this);
            default:
                return null;
        }
    }

    private static String a(Intent intent) {
        return intent.getStringExtra("broadcastIdentifier");
    }

    private static void a(Context context) {
        InputMethodManager inputMethodManager;
        if (context == null) {
            return;
        }
        try {
            inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            inputMethodManager = null;
        }
        if (inputMethodManager == null) {
            return;
        }
        for (Field field : inputMethodManager.getClass().getDeclaredFields()) {
            try {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                Object obj = field.get(inputMethodManager);
                if (obj != null && (obj instanceof View)) {
                    field.set(inputMethodManager, null);
                }
            } catch (Throwable th2) {
                SigmobLog.e(th2.getMessage());
            }
        }
    }

    @Override // com.sigmob.sdk.base.common.k
    public void a() {
        finish();
        overridePendingTransition(0, 0);
    }

    @Override // com.sigmob.sdk.base.common.k
    public void a(int i) {
        setRequestedOrientation(i);
    }

    @Override // com.sigmob.sdk.base.common.k
    public void a(Class<? extends Activity> cls, int i, Bundle bundle) {
        if (cls == null) {
            return;
        }
        try {
            startActivityForResult(u.a(this, cls, bundle), i);
        } catch (Throwable unused) {
            SigmobLog.d("Activity " + cls.getName() + " not found. Did you declare it in your AndroidManifest.xml?");
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        j jVar = this.k;
        if (jVar != null) {
            jVar.a(i, i2, intent);
        }
    }

    @Override // android.app.Activity, com.sigmob.sdk.base.common.k
    public void onBackPressed() {
        j jVar = this.k;
        if (jVar == null || !jVar.j()) {
            return;
        }
        super.onBackPressed();
        this.k.i();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j jVar = this.k;
        if (jVar != null) {
            jVar.a(configuration);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        com.sigmob.sdk.videoplayer.d.e((Activity) this);
        super.onCreate(bundle);
        SigmobLog.i("TaskId :" + getTaskId());
        this.l = a(getIntent());
        String stringExtra = getIntent().getStringExtra("adUnit_requestId_key");
        try {
            if (ClientMetadata.getInstance() != null && !TextUtils.isEmpty(stringExtra)) {
                BaseAdUnit c2 = h.c(stringExtra);
                if (!this.l.equals("dislike_broadcastIdentifier") && c2 == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("error", "playAdUnit is null");
                    BaseBroadcastReceiver.a(this, this.l, hashMap, IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL);
                    finish();
                    return;
                }
                j a = a(c2, bundle);
                this.k = a;
                if (a != null) {
                    a.e();
                    return;
                }
                return;
            }
            SigmobLog.e("uuid is empty");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("error", "uuid is empty");
            BaseBroadcastReceiver.a(this, this.l, hashMap2, IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL);
            finish();
        } catch (Throwable th) {
            SigmobLog.e("AdActivity onCreate Throwable:" + th.getMessage(), th);
            HashMap hashMap3 = new HashMap();
            hashMap3.put("error", th.getMessage());
            BaseBroadcastReceiver.a(this, this.l, hashMap3, IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        SigmobLog.d("RewardVideoAdPlayerActivity onDestroy() called");
        j jVar = this.k;
        if (jVar != null) {
            jVar.h();
        }
        this.k = null;
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        try {
            super.onPause();
            j jVar = this.k;
            if (jVar != null) {
                jVar.f();
            }
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("error", th.getMessage());
            BaseBroadcastReceiver.a(this, this.l, hashMap, IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        try {
            super.onResume();
            j jVar = this.k;
            if (jVar != null) {
                jVar.g();
            }
        } catch (Throwable th) {
            HashMap hashMap = new HashMap();
            hashMap.put("error", th.getMessage());
            BaseBroadcastReceiver.a(this, this.l, hashMap, IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        j jVar = this.k;
        if (jVar != null) {
            jVar.a(bundle);
        }
    }

    @Override // com.sigmob.sdk.base.common.k
    public void onSetContentView(View view) {
        setContentView(view);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        try {
            j jVar = this.k;
            if (jVar != null) {
                jVar.o();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        try {
            if (Build.VERSION.SDK_INT == 26 && com.sigmob.sdk.videoplayer.d.g((Activity) this)) {
                return;
            }
            super.setRequestedOrientation(i);
        } catch (Exception e) {
            SigmobLog.e("setRequestedOrientation: " + e.getMessage());
        }
    }
}
