package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogLoginUserAgreement_ViewBinding implements Unbinder {
    private DialogLoginUserAgreement b;

    @UiThread
    public DialogLoginUserAgreement_ViewBinding(DialogLoginUserAgreement dialogLoginUserAgreement, View view) {
        this.b = dialogLoginUserAgreement;
        dialogLoginUserAgreement.userAgreementTv = (TextView) butterknife.c.a.c(view, R.id.user_agreement_tv, "field 'userAgreementTv'", TextView.class);
        dialogLoginUserAgreement.userAgreementNo = (TextView) butterknife.c.a.c(view, R.id.user_agreement_no, "field 'userAgreementNo'", TextView.class);
        dialogLoginUserAgreement.userAgreementYes = (TextView) butterknife.c.a.c(view, R.id.user_agreement_yes, "field 'userAgreementYes'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogLoginUserAgreement dialogLoginUserAgreement = this.b;
        if (dialogLoginUserAgreement != null) {
            this.b = null;
            dialogLoginUserAgreement.userAgreementTv = null;
            dialogLoginUserAgreement.userAgreementNo = null;
            dialogLoginUserAgreement.userAgreementYes = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
