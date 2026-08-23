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
public class BoundPhoneActivity_ViewBinding implements Unbinder {
    private BoundPhoneActivity b;

    @UiThread
    public BoundPhoneActivity_ViewBinding(BoundPhoneActivity boundPhoneActivity, View view) {
        this.b = boundPhoneActivity;
        boundPhoneActivity.boundPhoneTopBack = (TextView) butterknife.c.a.c(view, R.id.bound_phone_top_back, "field 'boundPhoneTopBack'", TextView.class);
        boundPhoneActivity.boundPhoneTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.bound_phone_top_layout, "field 'boundPhoneTopLayout'", LinearLayout.class);
        boundPhoneActivity.boundPhonePhone = (EditText) butterknife.c.a.c(view, R.id.bound_phone_phone, "field 'boundPhonePhone'", EditText.class);
        boundPhoneActivity.boundPhoneToken = (EditText) butterknife.c.a.c(view, R.id.bound_phone_token, "field 'boundPhoneToken'", EditText.class);
        boundPhoneActivity.boundPhoneGettokenBtu = (Button) butterknife.c.a.c(view, R.id.bound_phone_gettokenBtu, "field 'boundPhoneGettokenBtu'", Button.class);
        boundPhoneActivity.boundPhoneSubmit = (TextView) butterknife.c.a.c(view, R.id.bound_phone_submit, "field 'boundPhoneSubmit'", TextView.class);
    }

    @CallSuper
    public void a() {
        BoundPhoneActivity boundPhoneActivity = this.b;
        if (boundPhoneActivity != null) {
            this.b = null;
            boundPhoneActivity.boundPhoneTopBack = null;
            boundPhoneActivity.boundPhoneTopLayout = null;
            boundPhoneActivity.boundPhonePhone = null;
            boundPhoneActivity.boundPhoneToken = null;
            boundPhoneActivity.boundPhoneGettokenBtu = null;
            boundPhoneActivity.boundPhoneSubmit = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
