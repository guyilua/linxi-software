package com.qumeng.advlib.ui.front;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import androidx.appcompat.app.AppCompatActivity;
import com.qumeng.advlib.common.b;
import com.qumeng.advlib.core.IInciteAd;
import f.a.a.a.a;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class InciteADActivity extends AppCompatActivity {
    private static final int b = 64222;
    private IInciteAd a;

    /* JADX WARN: Multi-variable type inference failed */
    private void a() {
        if (b.c().b(IInciteAd.class) == null) {
            Log.i("ADBrowser", "Well, our remote class didn't load yet, invoke _bootstrap() ...");
            a.a(getApplicationContext());
        }
        this.a = (IInciteAd) b.c().a(IInciteAd.class, new Object[0]);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        IInciteAd iInciteAd = this.a;
        if (iInciteAd != null) {
            iInciteAd.onActivityResultRef(i, i2, intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        try {
            a();
            IInciteAd iInciteAd = this.a;
            if (iInciteAd != null) {
                iInciteAd.doWhenReflect(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDestroy() {
        super.onDestroy();
        IInciteAd iInciteAd = this.a;
        if (iInciteAd != null) {
            iInciteAd.onDestroyRef(this);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IInciteAd iInciteAd = this.a;
        if (iInciteAd == null || !Boolean.valueOf(iInciteAd.onKeyEvent(i, keyEvent)).booleanValue()) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onPause() {
        super/*androidx.fragment.app.FragmentActivity*/.onPause();
        IInciteAd iInciteAd = this.a;
        if (iInciteAd != null) {
            iInciteAd.onPauseRef(this);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        IInciteAd iInciteAd = this.a;
        if (iInciteAd != null) {
            iInciteAd.whenPermDialogReturns(i, strArr, iArr);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        IInciteAd iInciteAd = this.a;
        if (iInciteAd != null) {
            iInciteAd.onResumeRef(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onStart() {
        super.onStart();
        IInciteAd iInciteAd = this.a;
        if (iInciteAd != null) {
            iInciteAd.onStartRef(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onStop() {
        super.onStop();
        IInciteAd iInciteAd = this.a;
        if (iInciteAd != null) {
            iInciteAd.onStopRef(this);
        }
    }
}
