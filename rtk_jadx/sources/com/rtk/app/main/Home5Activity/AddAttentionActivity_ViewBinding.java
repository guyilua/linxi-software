package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AddAttentionActivity_ViewBinding implements Unbinder {
    private AddAttentionActivity b;

    @UiThread
    public AddAttentionActivity_ViewBinding(AddAttentionActivity addAttentionActivity, View view) {
        this.b = addAttentionActivity;
        addAttentionActivity.addAttentionTopBack = (TextView) butterknife.c.a.c(view, R.id.add_attention_topBack, "field 'addAttentionTopBack'", TextView.class);
        addAttentionActivity.addAttentionTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.add_attention_topLayout, "field 'addAttentionTopLayout'", LinearLayout.class);
        addAttentionActivity.addAttentionListview = (AutoListView) butterknife.c.a.c(view, R.id.add_attention_listview, "field 'addAttentionListview'", AutoListView.class);
        addAttentionActivity.addAttentionEdv = (EditText) butterknife.c.a.c(view, R.id.add_attention_edv, "field 'addAttentionEdv'", EditText.class);
        addAttentionActivity.addAttentionEnsure = (TextView) butterknife.c.a.c(view, R.id.add_attention_ensure, "field 'addAttentionEnsure'", TextView.class);
        addAttentionActivity.addAttentionForMyAttention = (TextView) butterknife.c.a.c(view, R.id.add_attention_for_myAttention, "field 'addAttentionForMyAttention'", TextView.class);
    }

    @CallSuper
    public void a() {
        AddAttentionActivity addAttentionActivity = this.b;
        if (addAttentionActivity != null) {
            this.b = null;
            addAttentionActivity.addAttentionTopBack = null;
            addAttentionActivity.addAttentionTopLayout = null;
            addAttentionActivity.addAttentionListview = null;
            addAttentionActivity.addAttentionEdv = null;
            addAttentionActivity.addAttentionEnsure = null;
            addAttentionActivity.addAttentionForMyAttention = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
