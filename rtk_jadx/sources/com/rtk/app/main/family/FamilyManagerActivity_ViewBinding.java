package com.rtk.app.main.family;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.CustomTextView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyManagerActivity_ViewBinding implements Unbinder {
    private FamilyManagerActivity b;

    @UiThread
    public FamilyManagerActivity_ViewBinding(FamilyManagerActivity familyManagerActivity, View view) {
        this.b = familyManagerActivity;
        familyManagerActivity.set_base_info = (CustomTextView) butterknife.c.a.c(view, R.id.set_base_info, "field 'set_base_info'", CustomTextView.class);
        familyManagerActivity.set_module = (CustomTextView) butterknife.c.a.c(view, R.id.set_module, "field 'set_module'", CustomTextView.class);
        familyManagerActivity.set_user_permission = (CustomTextView) butterknife.c.a.c(view, R.id.set_user_permission, "field 'set_user_permission'", CustomTextView.class);
        familyManagerActivity.family_member_manager = (CustomTextView) butterknife.c.a.c(view, R.id.family_member_manager, "field 'family_member_manager'", CustomTextView.class);
        familyManagerActivity.white_list_manager = (CustomTextView) butterknife.c.a.c(view, R.id.family_white_list_manager, "field 'white_list_manager'", CustomTextView.class);
        familyManagerActivity.parentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.parent_layout, "field 'parentLayout'", LinearLayout.class);
        familyManagerActivity.familyCoinManager = (TextView) butterknife.c.a.c(view, R.id.family_coin_manager, "field 'familyCoinManager'", TextView.class);
        familyManagerActivity.backLayout = butterknife.c.a.b(view, R.id.back_layout, "field 'backLayout'");
        familyManagerActivity.up_audit = butterknife.c.a.b(view, R.id.family_up_audit_layout, "field 'up_audit'");
        familyManagerActivity.post_audit = butterknife.c.a.b(view, R.id.family_post_audit_layout, "field 'post_audit'");
        familyManagerActivity.up_comment_audit = butterknife.c.a.b(view, R.id.family_up_comment_audit_layout, "field 'up_comment_audit'");
        familyManagerActivity.post_comment_audit = butterknife.c.a.b(view, R.id.family_post_comment_audit_layout, "field 'post_comment_audit'");
        familyManagerActivity.joinFamilyMessageNum = (TextView) butterknife.c.a.c(view, R.id.join_family_message_num, "field 'joinFamilyMessageNum'", TextView.class);
        familyManagerActivity.postCommentAuditMessageNum = (TextView) butterknife.c.a.c(view, R.id.post_comment_audit_message_num, "field 'postCommentAuditMessageNum'", TextView.class);
        familyManagerActivity.postAuditMessageNum = (TextView) butterknife.c.a.c(view, R.id.post_audit_message_num, "field 'postAuditMessageNum'", TextView.class);
        familyManagerActivity.upCommentAuditMessageNum = (TextView) butterknife.c.a.c(view, R.id.up_comment_audit_message_num, "field 'upCommentAuditMessageNum'", TextView.class);
        familyManagerActivity.upAuditMessageNum = (TextView) butterknife.c.a.c(view, R.id.up_audit_message_num, "field 'upAuditMessageNum'", TextView.class);
    }

    @CallSuper
    public void a() {
        FamilyManagerActivity familyManagerActivity = this.b;
        if (familyManagerActivity != null) {
            this.b = null;
            familyManagerActivity.set_base_info = null;
            familyManagerActivity.set_module = null;
            familyManagerActivity.set_user_permission = null;
            familyManagerActivity.family_member_manager = null;
            familyManagerActivity.white_list_manager = null;
            familyManagerActivity.parentLayout = null;
            familyManagerActivity.familyCoinManager = null;
            familyManagerActivity.backLayout = null;
            familyManagerActivity.up_audit = null;
            familyManagerActivity.post_audit = null;
            familyManagerActivity.up_comment_audit = null;
            familyManagerActivity.post_comment_audit = null;
            familyManagerActivity.joinFamilyMessageNum = null;
            familyManagerActivity.postCommentAuditMessageNum = null;
            familyManagerActivity.postAuditMessageNum = null;
            familyManagerActivity.upCommentAuditMessageNum = null;
            familyManagerActivity.upAuditMessageNum = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
