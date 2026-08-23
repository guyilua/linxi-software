package com.rtk.app.main.family;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.custom.NoOOMEditText;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyMemberActivity_ViewBinding implements Unbinder {
    private FamilyMemberActivity b;

    @UiThread
    public FamilyMemberActivity_ViewBinding(FamilyMemberActivity familyMemberActivity, View view) {
        this.b = familyMemberActivity;
        familyMemberActivity.autoListView = (AutoListView) butterknife.c.a.c(view, R.id.listview, "field 'autoListView'", AutoListView.class);
        familyMemberActivity.manager = butterknife.c.a.b(view, R.id.manager, "field 'manager'");
        familyMemberActivity.noOOMEditText = (NoOOMEditText) butterknife.c.a.c(view, R.id.add_attention_edv, "field 'noOOMEditText'", NoOOMEditText.class);
        familyMemberActivity.backLayout = butterknife.c.a.b(view, R.id.back_layout, "field 'backLayout'");
    }

    @CallSuper
    public void a() {
        FamilyMemberActivity familyMemberActivity = this.b;
        if (familyMemberActivity != null) {
            this.b = null;
            familyMemberActivity.autoListView = null;
            familyMemberActivity.manager = null;
            familyMemberActivity.noOOMEditText = null;
            familyMemberActivity.backLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
