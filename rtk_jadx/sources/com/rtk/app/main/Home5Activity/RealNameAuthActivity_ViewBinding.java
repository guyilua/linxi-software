package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.CustomSingleEditTextView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class RealNameAuthActivity_ViewBinding implements Unbinder {
    private RealNameAuthActivity b;

    @UiThread
    public RealNameAuthActivity_ViewBinding(RealNameAuthActivity realNameAuthActivity, View view) {
        this.b = realNameAuthActivity;
        realNameAuthActivity.backLayout = butterknife.c.a.b(view, R.id.back_layout, "field 'backLayout'");
        realNameAuthActivity.nameEditTextView = (CustomSingleEditTextView) butterknife.c.a.c(view, 2131299532, "field 'nameEditTextView'", CustomSingleEditTextView.class);
        realNameAuthActivity.identityEditTextView = (CustomSingleEditTextView) butterknife.c.a.c(view, R.id.identity_layout, "field 'identityEditTextView'", CustomSingleEditTextView.class);
        realNameAuthActivity.submit = butterknife.c.a.b(view, R.id.submit, "field 'submit'");
        realNameAuthActivity.backTv = butterknife.c.a.b(view, R.id.backTV, "field 'backTv'");
        realNameAuthActivity.checkBox = (CheckBox) butterknife.c.a.c(view, R.id.checkBox, "field 'checkBox'", CheckBox.class);
        realNameAuthActivity.checkBoxLayout = butterknife.c.a.b(view, R.id.checkbox_layout, "field 'checkBoxLayout'");
        realNameAuthActivity.tips = (TextView) butterknife.c.a.c(view, R.id.tips, "field 'tips'", TextView.class);
    }

    @CallSuper
    public void a() {
        RealNameAuthActivity realNameAuthActivity = this.b;
        if (realNameAuthActivity != null) {
            this.b = null;
            realNameAuthActivity.backLayout = null;
            realNameAuthActivity.nameEditTextView = null;
            realNameAuthActivity.identityEditTextView = null;
            realNameAuthActivity.submit = null;
            realNameAuthActivity.backTv = null;
            realNameAuthActivity.checkBox = null;
            realNameAuthActivity.checkBoxLayout = null;
            realNameAuthActivity.tips = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
