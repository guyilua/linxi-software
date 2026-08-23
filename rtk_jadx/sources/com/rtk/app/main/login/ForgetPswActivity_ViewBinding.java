package com.rtk.app.main.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ForgetPswActivity_ViewBinding implements Unbinder {
    private ForgetPswActivity b;

    @UiThread
    public ForgetPswActivity_ViewBinding(ForgetPswActivity forgetPswActivity, View view) {
        this.b = forgetPswActivity;
        forgetPswActivity.forgetPswTopLayout = (RelativeLayout) butterknife.c.a.c(view, R.id.forget_psw_top_layout, "field 'forgetPswTopLayout'", RelativeLayout.class);
        forgetPswActivity.forgetPswPhone = (EditText) butterknife.c.a.c(view, R.id.forget_psw_phone, "field 'forgetPswPhone'", EditText.class);
        forgetPswActivity.forgetPswToken = (EditText) butterknife.c.a.c(view, R.id.forget_psw_token, "field 'forgetPswToken'", EditText.class);
        forgetPswActivity.forgetPswGettokenBtu = (Button) butterknife.c.a.c(view, R.id.forget_psw_gettokenBtu, "field 'forgetPswGettokenBtu'", Button.class);
        forgetPswActivity.forgetPswInputPsw = (EditText) butterknife.c.a.c(view, R.id.forget_psw_inputPsw, "field 'forgetPswInputPsw'", EditText.class);
        forgetPswActivity.forgetPswInputPswAgain = (EditText) butterknife.c.a.c(view, R.id.forget_psw_inputPswAgain, "field 'forgetPswInputPswAgain'", EditText.class);
        forgetPswActivity.forgetPswSubmit = (TextView) butterknife.c.a.c(view, R.id.forget_psw_submit, "field 'forgetPswSubmit'", TextView.class);
    }

    @CallSuper
    public void a() {
        ForgetPswActivity forgetPswActivity = this.b;
        if (forgetPswActivity != null) {
            this.b = null;
            forgetPswActivity.forgetPswTopLayout = null;
            forgetPswActivity.forgetPswPhone = null;
            forgetPswActivity.forgetPswToken = null;
            forgetPswActivity.forgetPswGettokenBtu = null;
            forgetPswActivity.forgetPswInputPsw = null;
            forgetPswActivity.forgetPswInputPswAgain = null;
            forgetPswActivity.forgetPswSubmit = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
