package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.e.c;
import com.ss.android.downloadlib.g.h;
import com.umeng.analytics.pro.ak;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class JumpKllkActivity extends TTDelegateActivity {
    @Override // com.ss.android.downloadlib.activity.TTDelegateActivity
    protected void a() {
        Intent intent = getIntent();
        if (getIntent() == null) {
            c.a().a("handleIntent is null");
            com.ss.android.socialbase.appdownloader.c.a((Activity) this);
            return;
        }
        String stringExtra = intent.getStringExtra(ak.ax);
        long longExtra = intent.getLongExtra("id", 0L);
        if (TextUtils.isEmpty(stringExtra) || longExtra == 0) {
            c.a().a("getPackage or id is null");
            com.ss.android.socialbase.appdownloader.c.a((Activity) this);
        }
        boolean booleanExtra = intent.getBooleanExtra("dl", false);
        String stringExtra2 = intent.getStringExtra("bk");
        if (booleanExtra & (!TextUtils.isEmpty(stringExtra2))) {
            h.a((Context) this, stringExtra, longExtra, stringExtra2, true);
            com.ss.android.socialbase.appdownloader.c.a((Activity) this);
            return;
        }
        int optInt = k.j().optInt("ab", 0);
        h.a(this, stringExtra, longExtra, optInt == 1);
        if (optInt != 1) {
            com.ss.android.socialbase.appdownloader.c.a((Activity) this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        com.ss.android.socialbase.appdownloader.c.a((Activity) this);
    }
}
