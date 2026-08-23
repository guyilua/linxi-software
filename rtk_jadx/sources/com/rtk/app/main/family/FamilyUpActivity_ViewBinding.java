package com.rtk.app.main.family;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.custom.NoOOMEditText;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyUpActivity_ViewBinding implements Unbinder {
    private FamilyUpActivity b;

    @UiThread
    public FamilyUpActivity_ViewBinding(FamilyUpActivity familyUpActivity, View view) {
        this.b = familyUpActivity;
        familyUpActivity.autoListView = (AutoListView) butterknife.c.a.c(view, R.id.listview, "field 'autoListView'", AutoListView.class);
        familyUpActivity.noOOMEditText = (NoOOMEditText) butterknife.c.a.c(view, R.id.add_attention_edv, "field 'noOOMEditText'", NoOOMEditText.class);
        familyUpActivity.searchHeadLayout = butterknife.c.a.b(view, R.id.search_head_layout, "field 'searchHeadLayout'");
        familyUpActivity.backLayout = butterknife.c.a.b(view, R.id.back_layout, "field 'backLayout'");
        familyUpActivity.auditLv = (LinearLayout) butterknife.c.a.c(view, R.id.community_list_audit_lv, "field 'auditLv'", LinearLayout.class);
        familyUpActivity.upLayout = butterknife.c.a.b(view, R.id.up_layout, "field 'upLayout'");
        familyUpActivity.upCommentLayout = butterknife.c.a.b(view, R.id.up_comment_layout, "field 'upCommentLayout'");
        familyUpActivity.upMessageNum = (TextView) butterknife.c.a.c(view, R.id.up_message_num, "field 'upMessageNum'", TextView.class);
        familyUpActivity.upCommentMessageNum = (TextView) butterknife.c.a.c(view, R.id.up_comment_message_num, "field 'upCommentMessageNum'", TextView.class);
    }

    @CallSuper
    public void a() {
        FamilyUpActivity familyUpActivity = this.b;
        if (familyUpActivity != null) {
            this.b = null;
            familyUpActivity.autoListView = null;
            familyUpActivity.noOOMEditText = null;
            familyUpActivity.searchHeadLayout = null;
            familyUpActivity.backLayout = null;
            familyUpActivity.auditLv = null;
            familyUpActivity.upLayout = null;
            familyUpActivity.upCommentLayout = null;
            familyUpActivity.upMessageNum = null;
            familyUpActivity.upCommentMessageNum = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
