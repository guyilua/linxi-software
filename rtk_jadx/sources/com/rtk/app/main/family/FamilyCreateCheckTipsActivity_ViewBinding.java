package com.rtk.app.main.family;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyCreateCheckTipsActivity_ViewBinding implements Unbinder {
    private FamilyCreateCheckTipsActivity b;

    @UiThread
    public FamilyCreateCheckTipsActivity_ViewBinding(FamilyCreateCheckTipsActivity familyCreateCheckTipsActivity, View view) {
        this.b = familyCreateCheckTipsActivity;
        familyCreateCheckTipsActivity.tips = (TextView) butterknife.c.a.c(view, R.id.family_create_checkout_tips, "field 'tips'", TextView.class);
        familyCreateCheckTipsActivity.desc = (TextView) butterknife.c.a.c(view, R.id.family_create_checkout_desc, "field 'desc'", TextView.class);
        familyCreateCheckTipsActivity.content = (LinearLayout) butterknife.c.a.c(view, R.id.family_create_checkout_content, "field 'content'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        FamilyCreateCheckTipsActivity familyCreateCheckTipsActivity = this.b;
        if (familyCreateCheckTipsActivity != null) {
            this.b = null;
            familyCreateCheckTipsActivity.tips = null;
            familyCreateCheckTipsActivity.desc = null;
            familyCreateCheckTipsActivity.content = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
