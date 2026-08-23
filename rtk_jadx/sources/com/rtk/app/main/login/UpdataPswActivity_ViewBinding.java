package com.rtk.app.main.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpdataPswActivity_ViewBinding implements Unbinder {
    private UpdataPswActivity b;

    @UiThread
    public UpdataPswActivity_ViewBinding(UpdataPswActivity updataPswActivity, View view) {
        this.b = updataPswActivity;
        updataPswActivity.updataPswTopBack = (TextView) butterknife.c.a.c(view, R.id.updataPsw_top_back, "field 'updataPswTopBack'", TextView.class);
        updataPswActivity.updataPswTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.updataPsw_top_layout, "field 'updataPswTopLayout'", LinearLayout.class);
        updataPswActivity.updataPswLastPsw = (EditText) butterknife.c.a.c(view, R.id.updataPsw_lastPsw, "field 'updataPswLastPsw'", EditText.class);
        updataPswActivity.updataPswNewPsw = (EditText) butterknife.c.a.c(view, R.id.updataPsw_newPsw, "field 'updataPswNewPsw'", EditText.class);
        updataPswActivity.updataPswPswAgain = (EditText) butterknife.c.a.c(view, R.id.updataPsw_pswAgain, "field 'updataPswPswAgain'", EditText.class);
        updataPswActivity.updataPswSubmit = (Button) butterknife.c.a.c(view, R.id.updataPsw_submit, "field 'updataPswSubmit'", Button.class);
    }

    @CallSuper
    public void a() {
        UpdataPswActivity updataPswActivity = this.b;
        if (updataPswActivity != null) {
            this.b = null;
            updataPswActivity.updataPswTopBack = null;
            updataPswActivity.updataPswTopLayout = null;
            updataPswActivity.updataPswLastPsw = null;
            updataPswActivity.updataPswNewPsw = null;
            updataPswActivity.updataPswPswAgain = null;
            updataPswActivity.updataPswSubmit = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
