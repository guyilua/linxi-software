package com.rtk.app.main.family;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyListActivity_ViewBinding implements Unbinder {
    private FamilyListActivity b;

    @UiThread
    public FamilyListActivity_ViewBinding(FamilyListActivity familyListActivity, View view) {
        this.b = familyListActivity;
        familyListActivity.autoListView = (AutoListView) butterknife.c.a.c(view, R.id.listview, "field 'autoListView'", AutoListView.class);
        familyListActivity.backLayout = butterknife.c.a.b(view, R.id.back_layout, "field 'backLayout'");
        familyListActivity.createFamily = (TextView) butterknife.c.a.c(view, R.id.apply_join_list, "field 'createFamily'", TextView.class);
    }

    @CallSuper
    public void a() {
        FamilyListActivity familyListActivity = this.b;
        if (familyListActivity != null) {
            this.b = null;
            familyListActivity.autoListView = null;
            familyListActivity.backLayout = null;
            familyListActivity.createFamily = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
