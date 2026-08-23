package com.rtk.app.main.family;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilySetModuleActivity_ViewBinding implements Unbinder {
    private FamilySetModuleActivity b;

    @UiThread
    public FamilySetModuleActivity_ViewBinding(FamilySetModuleActivity familySetModuleActivity, View view) {
        this.b = familySetModuleActivity;
        familySetModuleActivity.moduleLayout = (LinearLayout) butterknife.c.a.c(view, R.id.module_layout, "field 'moduleLayout'", LinearLayout.class);
        familySetModuleActivity.create_module = butterknife.c.a.b(view, R.id.create_module, "field 'create_module'");
    }

    @CallSuper
    public void a() {
        FamilySetModuleActivity familySetModuleActivity = this.b;
        if (familySetModuleActivity != null) {
            this.b = null;
            familySetModuleActivity.moduleLayout = null;
            familySetModuleActivity.create_module = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
