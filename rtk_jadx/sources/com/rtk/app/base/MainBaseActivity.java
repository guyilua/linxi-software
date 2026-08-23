package com.rtk.app.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.rtk.app.R;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.dialogPack.DialogForInstallPermission;
import com.rtk.app.main.dialogPack.DialogMainPagePermision;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.umeng.analytics.MobclickAgent;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class MainBaseActivity extends AppCompatActivity implements View.OnClickListener, f {
    public Activity a;

    private void q() {
        initData();
        initView();
        initListener();
        t.V1(this.a);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(i, i2, intent);
        c0.u("MainBaseActivity", "MainBaseActivity   onActivityResult  被执行" + i + "      " + i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(@Nullable Bundle bundle) {
        if (y.F()) {
            setTheme(R.style.MainAppTheme_day);
        } else {
            setTheme(R.style.MainAppTheme_night);
        }
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        this.a = this;
    }

    protected void onPause() {
        super/*androidx.fragment.app.FragmentActivity*/.onPause();
        MobclickAgent.onPause(this.a);
    }

    protected void onPostCreate(@Nullable Bundle bundle) {
        super.onPostCreate(bundle);
        s();
        if (r()) {
            q();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super/*androidx.fragment.app.FragmentActivity*/.onRequestPermissionsResult(i, strArr, iArr);
        c0.u("MainBaseActivity", "存储权限requestCode" + i + "     " + iArr.length);
        if (i != 10000) {
            return;
        }
        for (int i2 : iArr) {
            if (i2 != 0) {
                new DialogMainPagePermision(MyApplication.b(), t.T(this)).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - 600 <= DialogForInstallPermission.l) {
            new DialogForInstallPermission(this.a).show();
        }
        MyApplication.f(this.a);
        s();
        MobclickAgent.onResume(this.a);
        if (com.rtk.app.tool.g.e.c().i() && !com.rtk.app.tool.g.e.c().g(this)) {
            com.rtk.app.tool.g.d.c(this.a).e(com.rtk.app.c.d.b(), currentTimeMillis, (currentTimeMillis - com.rtk.app.tool.g.e.c().b()) + com.rtk.app.tool.g.e.c().d());
            com.rtk.app.tool.g.e.c().a(this);
        }
    }

    protected void onStart() {
        super.onStart();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onWindowFocusChanged(boolean z) {
        super/*android.app.Activity*/.onWindowFocusChanged(z);
        if (z) {
            t.G(this.a);
        }
    }

    protected boolean r() {
        return true;
    }

    protected abstract void s();
}
