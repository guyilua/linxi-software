package com.qumeng.advlib.ui.front;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import androidx.appcompat.app.AppCompatActivity;
import com.qumeng.advlib.common.b;
import com.qumeng.advlib.core.IADBrowser;
import f.a.a.a.a;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ADBrowser extends AppCompatActivity {
    private IADBrowser adBrowserImp;

    /* JADX WARN: Multi-variable type inference failed */
    private void loadInstance() {
        IADBrowser iADBrowser = (IADBrowser) b.c().a(IADBrowser.class, new Object[0]);
        this.adBrowserImp = iADBrowser;
        if (iADBrowser == null) {
            Log.i("ADBrowser", "Well, our remote class didn't load yet, invoke _bootstrap() ...");
            a.a(getApplicationContext());
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        IADBrowser iADBrowser = this.adBrowserImp;
        if (iADBrowser != null) {
            iADBrowser.onActivityResultRef(i, i2, intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        try {
            super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
            loadInstance();
            IADBrowser iADBrowser = this.adBrowserImp;
            if (iADBrowser != null) {
                iADBrowser.doWhenReflect(this, bundle);
            }
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IADBrowser iADBrowser = this.adBrowserImp;
        if (iADBrowser == null || !Boolean.valueOf(iADBrowser.onKeyEvent(i, keyEvent)).booleanValue()) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        IADBrowser iADBrowser = this.adBrowserImp;
        if (iADBrowser != null) {
            iADBrowser.whenPermDialogReturns(i, strArr, iArr);
        }
    }
}
