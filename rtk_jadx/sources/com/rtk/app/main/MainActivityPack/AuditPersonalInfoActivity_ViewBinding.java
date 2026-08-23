package com.rtk.app.main.MainActivityPack;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AuditPersonalInfoActivity_ViewBinding implements Unbinder {
    private AuditPersonalInfoActivity b;

    @UiThread
    public AuditPersonalInfoActivity_ViewBinding(AuditPersonalInfoActivity auditPersonalInfoActivity, View view) {
        this.b = auditPersonalInfoActivity;
        auditPersonalInfoActivity.auditPersonalInfoTopBack = (TextView) butterknife.c.a.c(view, R.id.audit_personal_info_top_back, "field 'auditPersonalInfoTopBack'", TextView.class);
        auditPersonalInfoActivity.auditPersonalInfoMyAuditComment = (TextView) butterknife.c.a.c(view, R.id.audit_personal_info_my_audit_comment, "field 'auditPersonalInfoMyAuditComment'", TextView.class);
        auditPersonalInfoActivity.auditPersonalInfoUpAudit = (TextView) butterknife.c.a.c(view, R.id.audit_personal_info_up_audit, "field 'auditPersonalInfoUpAudit'", TextView.class);
        auditPersonalInfoActivity.auditPersonalInfoUpAuditComment = (TextView) butterknife.c.a.c(view, R.id.audit_personal_info_up_audit_comment, "field 'auditPersonalInfoUpAuditComment'", TextView.class);
        auditPersonalInfoActivity.auditPersonalInfoPostAudit = (TextView) butterknife.c.a.c(view, R.id.audit_personal_info_post_audit, "field 'auditPersonalInfoPostAudit'", TextView.class);
        auditPersonalInfoActivity.auditPersonalInfoTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.audit_personal_info_top_layout, "field 'auditPersonalInfoTopLayout'", LinearLayout.class);
        auditPersonalInfoActivity.auditPersonalInfoNickname = (TextView) butterknife.c.a.c(view, R.id.audit_personal_info_nickname, "field 'auditPersonalInfoNickname'", TextView.class);
        auditPersonalInfoActivity.auditPersonalInfoIcon = (TextView) butterknife.c.a.c(view, R.id.audit_personal_info_icon, "field 'auditPersonalInfoIcon'", TextView.class);
        auditPersonalInfoActivity.auditPersonalInfoSignature = (TextView) butterknife.c.a.c(view, R.id.audit_personal_info_signature, "field 'auditPersonalInfoSignature'", TextView.class);
        auditPersonalInfoActivity.auditPersonalInfoPhotoAlbum = (TextView) butterknife.c.a.c(view, R.id.audit_personal_info_photo_album, "field 'auditPersonalInfoPhotoAlbum'", TextView.class);
        auditPersonalInfoActivity.auditPersonalInfoReAudit = (TextView) butterknife.c.a.c(view, R.id.audit_personal_info_re_audit, "field 'auditPersonalInfoReAudit'", TextView.class);
        auditPersonalInfoActivity.auditPersonalInfoAuditPostReply = (TextView) butterknife.c.a.c(view, R.id.audit_personal_info_audit_post_reply, "field 'auditPersonalInfoAuditPostReply'", TextView.class);
        auditPersonalInfoActivity.auditPersonalInfoFamilyUp = (TextView) butterknife.c.a.c(view, R.id.audit_personal_info_family_up, "field 'auditPersonalInfoFamilyUp'", TextView.class);
        auditPersonalInfoActivity.auditPersonalInfoFamilyUpComment = (TextView) butterknife.c.a.c(view, R.id.audit_personal_info_family_up_comment, "field 'auditPersonalInfoFamilyUpComment'", TextView.class);
        auditPersonalInfoActivity.auditPersonalInfoFamilyPost = (TextView) butterknife.c.a.c(view, R.id.audit_personal_info_family_post, "field 'auditPersonalInfoFamilyPost'", TextView.class);
        auditPersonalInfoActivity.auditPersonalInfoFamilyPostComment = (TextView) butterknife.c.a.c(view, R.id.audit_personal_info_family_post_comment, "field 'auditPersonalInfoFamilyPostComment'", TextView.class);
    }

    @CallSuper
    public void a() {
        AuditPersonalInfoActivity auditPersonalInfoActivity = this.b;
        if (auditPersonalInfoActivity != null) {
            this.b = null;
            auditPersonalInfoActivity.auditPersonalInfoTopBack = null;
            auditPersonalInfoActivity.auditPersonalInfoMyAuditComment = null;
            auditPersonalInfoActivity.auditPersonalInfoUpAudit = null;
            auditPersonalInfoActivity.auditPersonalInfoUpAuditComment = null;
            auditPersonalInfoActivity.auditPersonalInfoPostAudit = null;
            auditPersonalInfoActivity.auditPersonalInfoTopLayout = null;
            auditPersonalInfoActivity.auditPersonalInfoNickname = null;
            auditPersonalInfoActivity.auditPersonalInfoIcon = null;
            auditPersonalInfoActivity.auditPersonalInfoSignature = null;
            auditPersonalInfoActivity.auditPersonalInfoPhotoAlbum = null;
            auditPersonalInfoActivity.auditPersonalInfoReAudit = null;
            auditPersonalInfoActivity.auditPersonalInfoAuditPostReply = null;
            auditPersonalInfoActivity.auditPersonalInfoFamilyUp = null;
            auditPersonalInfoActivity.auditPersonalInfoFamilyUpComment = null;
            auditPersonalInfoActivity.auditPersonalInfoFamilyPost = null;
            auditPersonalInfoActivity.auditPersonalInfoFamilyPostComment = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
