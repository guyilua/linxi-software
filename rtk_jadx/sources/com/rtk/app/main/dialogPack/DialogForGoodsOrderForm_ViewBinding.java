package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForGoodsOrderForm_ViewBinding implements Unbinder {
    private DialogForGoodsOrderForm b;

    @UiThread
    public DialogForGoodsOrderForm_ViewBinding(DialogForGoodsOrderForm dialogForGoodsOrderForm, View view) {
        this.b = dialogForGoodsOrderForm;
        dialogForGoodsOrderForm.dialogForGoodsOrderFormListView = (ListView) butterknife.c.a.c(view, R.id.dialog_for_goods_order_form_listView, "field 'dialogForGoodsOrderFormListView'", ListView.class);
        dialogForGoodsOrderForm.dialogForGoodsOrderFormEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_for_goods_order_form_ensure, "field 'dialogForGoodsOrderFormEnsure'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogForGoodsOrderForm dialogForGoodsOrderForm = this.b;
        if (dialogForGoodsOrderForm != null) {
            this.b = null;
            dialogForGoodsOrderForm.dialogForGoodsOrderFormListView = null;
            dialogForGoodsOrderForm.dialogForGoodsOrderFormEnsure = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
