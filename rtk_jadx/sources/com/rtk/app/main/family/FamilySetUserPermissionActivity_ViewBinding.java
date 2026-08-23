package com.rtk.app.main.family;

import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilySetUserPermissionActivity_ViewBinding implements Unbinder {
    private FamilySetUserPermissionActivity b;

    @UiThread
    public FamilySetUserPermissionActivity_ViewBinding(FamilySetUserPermissionActivity familySetUserPermissionActivity, View view) {
        this.b = familySetUserPermissionActivity;
        familySetUserPermissionActivity.leaderGridView = (GridView) butterknife.c.a.c(view, R.id.leader_gridView, "field 'leaderGridView'", GridView.class);
        familySetUserPermissionActivity.upGridView = (GridView) butterknife.c.a.c(view, R.id.up_gridView, "field 'upGridView'", GridView.class);
        familySetUserPermissionActivity.bbsGridView = (GridView) butterknife.c.a.c(view, R.id.bbs_gridView, "field 'bbsGridView'", GridView.class);
        familySetUserPermissionActivity.zuZhangLayout = (LinearLayout) butterknife.c.a.c(view, R.id.layout_zu_zhang, "field 'zuZhangLayout'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        FamilySetUserPermissionActivity familySetUserPermissionActivity = this.b;
        if (familySetUserPermissionActivity != null) {
            this.b = null;
            familySetUserPermissionActivity.leaderGridView = null;
            familySetUserPermissionActivity.upGridView = null;
            familySetUserPermissionActivity.bbsGridView = null;
            familySetUserPermissionActivity.zuZhangLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
