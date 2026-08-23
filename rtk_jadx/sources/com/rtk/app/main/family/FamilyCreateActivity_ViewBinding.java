package com.rtk.app.main.family;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.CustomSingleEditTextView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyCreateActivity_ViewBinding implements Unbinder {
    private FamilyCreateActivity b;

    @UiThread
    public FamilyCreateActivity_ViewBinding(FamilyCreateActivity familyCreateActivity, View view) {
        this.b = familyCreateActivity;
        familyCreateActivity.familyNameEditText = (CustomSingleEditTextView) butterknife.c.a.c(view, R.id.custom_single_edit_text, "field 'familyNameEditText'", CustomSingleEditTextView.class);
        familyCreateActivity.goCreateFamily = (TextView) butterknife.c.a.c(view, R.id.go_create_family, "field 'goCreateFamily'", TextView.class);
        familyCreateActivity.desc = (TextView) butterknife.c.a.c(view, 2131297103, "field 'desc'", TextView.class);
        familyCreateActivity.protocolTV = (TextView) butterknife.c.a.c(view, R.id.user_protocol_tv, "field 'protocolTV'", TextView.class);
        familyCreateActivity.checkBox = (CheckBox) butterknife.c.a.c(view, R.id.checkBox, "field 'checkBox'", CheckBox.class);
    }

    @CallSuper
    public void a() {
        FamilyCreateActivity familyCreateActivity = this.b;
        if (familyCreateActivity != null) {
            this.b = null;
            familyCreateActivity.familyNameEditText = null;
            familyCreateActivity.goCreateFamily = null;
            familyCreateActivity.desc = null;
            familyCreateActivity.protocolTV = null;
            familyCreateActivity.checkBox = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
