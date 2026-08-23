package com.rtk.app.main.family;

import android.view.View;
import android.widget.CheckBox;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyApplyJoinListActivity_ViewBinding implements Unbinder {
    private FamilyApplyJoinListActivity b;

    @UiThread
    public FamilyApplyJoinListActivity_ViewBinding(FamilyApplyJoinListActivity familyApplyJoinListActivity, View view) {
        this.b = familyApplyJoinListActivity;
        familyApplyJoinListActivity.autoListView = (AutoListView) butterknife.c.a.c(view, R.id.listview, "field 'autoListView'", AutoListView.class);
        familyApplyJoinListActivity.checkBox = (CheckBox) butterknife.c.a.c(view, R.id.checkBox, "field 'checkBox'", CheckBox.class);
    }

    @CallSuper
    public void a() {
        FamilyApplyJoinListActivity familyApplyJoinListActivity = this.b;
        if (familyApplyJoinListActivity != null) {
            this.b = null;
            familyApplyJoinListActivity.autoListView = null;
            familyApplyJoinListActivity.checkBox = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
