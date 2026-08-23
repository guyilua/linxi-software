package com.rtk.app.main.login;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class LoginActivity_ViewBinding implements Unbinder {
    private LoginActivity b;

    @UiThread
    public LoginActivity_ViewBinding(LoginActivity loginActivity, View view) {
        this.b = loginActivity;
        loginActivity.loginClosed = (ImageView) butterknife.c.a.c(view, R.id.login_closed, "field 'loginClosed'", ImageView.class);
        loginActivity.loginUsername = (EditText) butterknife.c.a.c(view, R.id.login_username, "field 'loginUsername'", EditText.class);
        loginActivity.loginUsernameClear = (ImageView) butterknife.c.a.c(view, R.id.login_username_clear, "field 'loginUsernameClear'", ImageView.class);
        loginActivity.loginPwd = (EditText) butterknife.c.a.c(view, R.id.login_pwd, "field 'loginPwd'", EditText.class);
        loginActivity.loginPwdEye = (ImageView) butterknife.c.a.c(view, R.id.login_pwd_eye, "field 'loginPwdEye'", ImageView.class);
        loginActivity.loginRemember = (ImageView) butterknife.c.a.c(view, R.id.login_remember, "field 'loginRemember'", ImageView.class);
        loginActivity.loginLoginBtu = (TextView) butterknife.c.a.c(view, R.id.login_loginBtu, "field 'loginLoginBtu'", TextView.class);
        loginActivity.loginForget = (TextView) butterknife.c.a.c(view, R.id.login_forget, "field 'loginForget'", TextView.class);
        loginActivity.loginRegister = (TextView) butterknife.c.a.c(view, R.id.login_register, "field 'loginRegister'", TextView.class);
        loginActivity.loginProtocol = (CheckBox) butterknife.c.a.c(view, R.id.login_protocol, "field 'loginProtocol'", CheckBox.class);
        loginActivity.loginProtocolTv = (TextView) butterknife.c.a.c(view, R.id.login_user_protocol_tv, "field 'loginProtocolTv'", TextView.class);
        loginActivity.loginForQq = (ImageView) butterknife.c.a.c(view, R.id.login_for_qq, "field 'loginForQq'", ImageView.class);
        loginActivity.loginForWeChat = (ImageView) butterknife.c.a.c(view, R.id.login_for_weChat, "field 'loginForWeChat'", ImageView.class);
    }

    @CallSuper
    public void a() {
        LoginActivity loginActivity = this.b;
        if (loginActivity != null) {
            this.b = null;
            loginActivity.loginClosed = null;
            loginActivity.loginUsername = null;
            loginActivity.loginUsernameClear = null;
            loginActivity.loginPwd = null;
            loginActivity.loginPwdEye = null;
            loginActivity.loginRemember = null;
            loginActivity.loginLoginBtu = null;
            loginActivity.loginForget = null;
            loginActivity.loginRegister = null;
            loginActivity.loginProtocol = null;
            loginActivity.loginProtocolTv = null;
            loginActivity.loginForQq = null;
            loginActivity.loginForWeChat = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
