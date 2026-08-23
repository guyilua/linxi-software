package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForEditOtherPersonal_ViewBinding implements Unbinder {
    private DialogForEditOtherPersonal b;

    @UiThread
    public DialogForEditOtherPersonal_ViewBinding(DialogForEditOtherPersonal dialogForEditOtherPersonal, View view) {
        this.b = dialogForEditOtherPersonal;
        dialogForEditOtherPersonal.dialogForEditOtherPersonalListView = (ListView) butterknife.c.a.c(view, R.id.dialog_for_edit_other_personal_listView, "field 'dialogForEditOtherPersonalListView'", ListView.class);
        dialogForEditOtherPersonal.dialogForEditOtherPersonalCancel = (TextView) butterknife.c.a.c(view, R.id.dialog_for_edit_other_personal_cancel, "field 'dialogForEditOtherPersonalCancel'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogForEditOtherPersonal dialogForEditOtherPersonal = this.b;
        if (dialogForEditOtherPersonal != null) {
            this.b = null;
            dialogForEditOtherPersonal.dialogForEditOtherPersonalListView = null;
            dialogForEditOtherPersonal.dialogForEditOtherPersonalCancel = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
