package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForAttention_ViewBinding implements Unbinder {
    private DialogForAttention b;

    @UiThread
    public DialogForAttention_ViewBinding(DialogForAttention dialogForAttention, View view) {
        this.b = dialogForAttention;
        dialogForAttention.dialogForAttentionExit = (TextView) butterknife.c.a.c(view, R.id.dialog_for_attention_exit, "field 'dialogForAttentionExit'", TextView.class);
        dialogForAttention.dialogForAttentionOk = (TextView) butterknife.c.a.c(view, R.id.dialog_for_attention_ok, "field 'dialogForAttentionOk'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogForAttention dialogForAttention = this.b;
        if (dialogForAttention != null) {
            this.b = null;
            dialogForAttention.dialogForAttentionExit = null;
            dialogForAttention.dialogForAttentionOk = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
