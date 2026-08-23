package com.rtk.app.main.family;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.custom.NoOOMEditText;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyUserPermissionSelectActivity_ViewBinding implements Unbinder {
    private FamilyUserPermissionSelectActivity b;

    @UiThread
    public FamilyUserPermissionSelectActivity_ViewBinding(FamilyUserPermissionSelectActivity familyUserPermissionSelectActivity, View view) {
        this.b = familyUserPermissionSelectActivity;
        familyUserPermissionSelectActivity.autoListView = (AutoListView) butterknife.c.a.c(view, R.id.listview, "field 'autoListView'", AutoListView.class);
        familyUserPermissionSelectActivity.remove = (TextView) butterknife.c.a.c(view, R.id.remove, "field 'remove'", TextView.class);
        familyUserPermissionSelectActivity.backTV = (TextView) butterknife.c.a.c(view, R.id.backTV, "field 'backTV'", TextView.class);
        familyUserPermissionSelectActivity.noOOMEditText = (NoOOMEditText) butterknife.c.a.c(view, R.id.add_attention_edv, "field 'noOOMEditText'", NoOOMEditText.class);
        familyUserPermissionSelectActivity.backLayout = butterknife.c.a.b(view, R.id.back_layout, "field 'backLayout'");
    }

    @CallSuper
    public void a() {
        FamilyUserPermissionSelectActivity familyUserPermissionSelectActivity = this.b;
        if (familyUserPermissionSelectActivity != null) {
            this.b = null;
            familyUserPermissionSelectActivity.autoListView = null;
            familyUserPermissionSelectActivity.remove = null;
            familyUserPermissionSelectActivity.backTV = null;
            familyUserPermissionSelectActivity.noOOMEditText = null;
            familyUserPermissionSelectActivity.backLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
