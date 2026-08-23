package com.rtk.app.main.family;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyApplyFamilyListActivity_ViewBinding implements Unbinder {
    private MyApplyFamilyListActivity b;

    @UiThread
    public MyApplyFamilyListActivity_ViewBinding(MyApplyFamilyListActivity myApplyFamilyListActivity, View view) {
        this.b = myApplyFamilyListActivity;
        myApplyFamilyListActivity.autoListView = (AutoListView) butterknife.c.a.c(view, R.id.listview, "field 'autoListView'", AutoListView.class);
        myApplyFamilyListActivity.backLayout = butterknife.c.a.b(view, R.id.back_layout, "field 'backLayout'");
    }

    @CallSuper
    public void a() {
        MyApplyFamilyListActivity myApplyFamilyListActivity = this.b;
        if (myApplyFamilyListActivity != null) {
            this.b = null;
            myApplyFamilyListActivity.autoListView = null;
            myApplyFamilyListActivity.backLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
