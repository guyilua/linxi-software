package com.rtk.app.main.login;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class RegisterActivity_ViewBinding implements Unbinder {
    private RegisterActivity b;

    @UiThread
    public RegisterActivity_ViewBinding(RegisterActivity registerActivity, View view) {
        this.b = registerActivity;
        registerActivity.registerTopBack = (TextView) butterknife.c.a.c(view, R.id.register_top_back, "field 'registerTopBack'", TextView.class);
        registerActivity.registerTopLayout = (RelativeLayout) butterknife.c.a.c(view, R.id.register_top_layout, "field 'registerTopLayout'", RelativeLayout.class);
        registerActivity.registerPhone = (EditText) butterknife.c.a.c(view, R.id.register_phone, "field 'registerPhone'", EditText.class);
        registerActivity.registerToken = (EditText) butterknife.c.a.c(view, R.id.register_token, "field 'registerToken'", EditText.class);
        registerActivity.registerGettokenBtu = (Button) butterknife.c.a.c(view, R.id.register_gettokenBtu, "field 'registerGettokenBtu'", Button.class);
        registerActivity.registerInputPsw = (EditText) butterknife.c.a.c(view, R.id.register_inputPsw, "field 'registerInputPsw'", EditText.class);
        registerActivity.registerInputPswAgain = (EditText) butterknife.c.a.c(view, R.id.register_inputPswAgain, "field 'registerInputPswAgain'", EditText.class);
        registerActivity.registerSubmit = (TextView) butterknife.c.a.c(view, R.id.register_submit, "field 'registerSubmit'", TextView.class);
        registerActivity.registerProtocol = (CheckBox) butterknife.c.a.c(view, R.id.register_protocol, "field 'registerProtocol'", CheckBox.class);
        registerActivity.registerUserProtocolTv = (TextView) butterknife.c.a.c(view, R.id.register_user_protocol_tv, "field 'registerUserProtocolTv'", TextView.class);
        registerActivity.register_privacy_policy_tv = (TextView) butterknife.c.a.c(view, R.id.register_privacy_policy_tv, "field 'register_privacy_policy_tv'", TextView.class);
    }

    @CallSuper
    public void a() {
        RegisterActivity registerActivity = this.b;
        if (registerActivity != null) {
            this.b = null;
            registerActivity.registerTopBack = null;
            registerActivity.registerTopLayout = null;
            registerActivity.registerPhone = null;
            registerActivity.registerToken = null;
            registerActivity.registerGettokenBtu = null;
            registerActivity.registerInputPsw = null;
            registerActivity.registerInputPswAgain = null;
            registerActivity.registerSubmit = null;
            registerActivity.registerProtocol = null;
            registerActivity.registerUserProtocolTv = null;
            registerActivity.register_privacy_policy_tv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
