package com.rtk.app.main.family;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.NoOOMEditText;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyCreateModuleActivity_ViewBinding implements Unbinder {
    private FamilyCreateModuleActivity b;

    @UiThread
    public FamilyCreateModuleActivity_ViewBinding(FamilyCreateModuleActivity familyCreateModuleActivity, View view) {
        this.b = familyCreateModuleActivity;
        familyCreateModuleActivity.title = (TextView) butterknife.c.a.c(view, R.id.backTV, "field 'title'", TextView.class);
        familyCreateModuleActivity.nameEditText = (NoOOMEditText) butterknife.c.a.c(view, R.id.module_name_et, "field 'nameEditText'", NoOOMEditText.class);
        familyCreateModuleActivity.goCreate = (TextView) butterknife.c.a.c(view, R.id.go_create, "field 'goCreate'", TextView.class);
        familyCreateModuleActivity.save = (TextView) butterknife.c.a.c(view, R.id.save, "field 'save'", TextView.class);
    }

    @CallSuper
    public void a() {
        FamilyCreateModuleActivity familyCreateModuleActivity = this.b;
        if (familyCreateModuleActivity != null) {
            this.b = null;
            familyCreateModuleActivity.title = null;
            familyCreateModuleActivity.nameEditText = null;
            familyCreateModuleActivity.goCreate = null;
            familyCreateModuleActivity.save = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
