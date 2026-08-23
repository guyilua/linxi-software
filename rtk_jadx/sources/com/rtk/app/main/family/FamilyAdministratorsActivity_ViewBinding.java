package com.rtk.app.main.family;

import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyAdministratorsActivity_ViewBinding implements Unbinder {
    private FamilyAdministratorsActivity b;

    @UiThread
    public FamilyAdministratorsActivity_ViewBinding(FamilyAdministratorsActivity familyAdministratorsActivity, View view) {
        this.b = familyAdministratorsActivity;
        familyAdministratorsActivity.manager = (TextView) butterknife.c.a.c(view, R.id.manager, "field 'manager'", TextView.class);
        familyAdministratorsActivity.leaderGridView = (GridView) butterknife.c.a.c(view, R.id.leader_gridView, "field 'leaderGridView'", GridView.class);
        familyAdministratorsActivity.upGridView = (GridView) butterknife.c.a.c(view, R.id.up_gridView, "field 'upGridView'", GridView.class);
        familyAdministratorsActivity.bbsGridView = (GridView) butterknife.c.a.c(view, R.id.bbs_gridView, "field 'bbsGridView'", GridView.class);
        familyAdministratorsActivity.headLeaderImg = (RoundedImageView) butterknife.c.a.c(view, R.id.header_leader_img, "field 'headLeaderImg'", RoundedImageView.class);
        familyAdministratorsActivity.headerLeaderName = (TextView) butterknife.c.a.c(view, R.id.header_leader_name, "field 'headerLeaderName'", TextView.class);
        familyAdministratorsActivity.leaderDefaultLayout = butterknife.c.a.b(view, R.id.leader_default_layout, "field 'leaderDefaultLayout'");
        familyAdministratorsActivity.upDefaultLayout = butterknife.c.a.b(view, R.id.up_default_layout, "field 'upDefaultLayout'");
        familyAdministratorsActivity.bbsDefaultLayout = butterknife.c.a.b(view, R.id.bbs_default_layout, "field 'bbsDefaultLayout'");
    }

    @CallSuper
    public void a() {
        FamilyAdministratorsActivity familyAdministratorsActivity = this.b;
        if (familyAdministratorsActivity != null) {
            this.b = null;
            familyAdministratorsActivity.manager = null;
            familyAdministratorsActivity.leaderGridView = null;
            familyAdministratorsActivity.upGridView = null;
            familyAdministratorsActivity.bbsGridView = null;
            familyAdministratorsActivity.headLeaderImg = null;
            familyAdministratorsActivity.headerLeaderName = null;
            familyAdministratorsActivity.leaderDefaultLayout = null;
            familyAdministratorsActivity.upDefaultLayout = null;
            familyAdministratorsActivity.bbsDefaultLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
