package com.rtk.app.main.HomeCommunityPack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.RichEditText.RichEditText;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class EditPostActivity_ViewBinding implements Unbinder {
    private EditPostActivity b;

    @UiThread
    public EditPostActivity_ViewBinding(EditPostActivity editPostActivity, View view) {
        this.b = editPostActivity;
        editPostActivity.editPostEditText = (RichEditText) butterknife.c.a.c(view, R.id.edit_post_editText, "field 'editPostEditText'", RichEditText.class);
    }

    @CallSuper
    public void a() {
        EditPostActivity editPostActivity = this.b;
        if (editPostActivity != null) {
            this.b = null;
            editPostActivity.editPostEditText = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
