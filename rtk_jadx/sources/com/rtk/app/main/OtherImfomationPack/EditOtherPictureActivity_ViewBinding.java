package com.rtk.app.main.OtherImfomationPack;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class EditOtherPictureActivity_ViewBinding implements Unbinder {
    private EditOtherPictureActivity b;

    @UiThread
    public EditOtherPictureActivity_ViewBinding(EditOtherPictureActivity editOtherPictureActivity, View view) {
        this.b = editOtherPictureActivity;
        editOtherPictureActivity.editOtherPictureTopBack = (TextView) butterknife.c.a.c(view, R.id.edit_other_picture_top_back, "field 'editOtherPictureTopBack'", TextView.class);
        editOtherPictureActivity.editOtherPictureTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.edit_other_picture_top_layout, "field 'editOtherPictureTopLayout'", LinearLayout.class);
        editOtherPictureActivity.editOtherPictureRecyclerView = (RecyclerView) butterknife.c.a.c(view, R.id.edit_other_picture_recyclerView, "field 'editOtherPictureRecyclerView'", RecyclerView.class);
        editOtherPictureActivity.editOtherPictureSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.edit_other_picture_swipeRefresh, "field 'editOtherPictureSwipeRefresh'", SwipeRefreshLayout.class);
        editOtherPictureActivity.editOtherPictureDeleteAll = (TextView) butterknife.c.a.c(view, R.id.edit_other_picture_delete_all, "field 'editOtherPictureDeleteAll'", TextView.class);
    }

    @CallSuper
    public void a() {
        EditOtherPictureActivity editOtherPictureActivity = this.b;
        if (editOtherPictureActivity != null) {
            this.b = null;
            editOtherPictureActivity.editOtherPictureTopBack = null;
            editOtherPictureActivity.editOtherPictureTopLayout = null;
            editOtherPictureActivity.editOtherPictureRecyclerView = null;
            editOtherPictureActivity.editOtherPictureSwipeRefresh = null;
            editOtherPictureActivity.editOtherPictureDeleteAll = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
