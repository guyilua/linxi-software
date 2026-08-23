package com.rtk.app.main.login;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class EditPictureActivity_ViewBinding implements Unbinder {
    private EditPictureActivity b;

    @UiThread
    public EditPictureActivity_ViewBinding(EditPictureActivity editPictureActivity, View view) {
        this.b = editPictureActivity;
        editPictureActivity.editPictureTopBack = (TextView) butterknife.c.a.c(view, R.id.edit_picture_top_back, "field 'editPictureTopBack'", TextView.class);
        editPictureActivity.editPictureTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.edit_picture_top_layout, "field 'editPictureTopLayout'", LinearLayout.class);
        editPictureActivity.editPictureRecyclerView = (RecyclerView) butterknife.c.a.c(view, R.id.edit_picture_recyclerView, "field 'editPictureRecyclerView'", RecyclerView.class);
        editPictureActivity.editPictureDeleteBtu = (CheckBox) butterknife.c.a.c(view, R.id.edit_picture_deleteBtu, "field 'editPictureDeleteBtu'", CheckBox.class);
        editPictureActivity.editPictureSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.edit_picture_swipeRefresh, "field 'editPictureSwipeRefresh'", SwipeRefreshLayout.class);
    }

    @CallSuper
    public void a() {
        EditPictureActivity editPictureActivity = this.b;
        if (editPictureActivity != null) {
            this.b = null;
            editPictureActivity.editPictureTopBack = null;
            editPictureActivity.editPictureTopLayout = null;
            editPictureActivity.editPictureRecyclerView = null;
            editPictureActivity.editPictureDeleteBtu = null;
            editPictureActivity.editPictureSwipeRefresh = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
