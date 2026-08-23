package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogUpUserAgreement_ViewBinding implements Unbinder {
    private DialogUpUserAgreement b;

    @UiThread
    public DialogUpUserAgreement_ViewBinding(DialogUpUserAgreement dialogUpUserAgreement, View view) {
        this.b = dialogUpUserAgreement;
        dialogUpUserAgreement.userAgreementTv = (TextView) butterknife.c.a.c(view, R.id.user_agreement_tv, "field 'userAgreementTv'", TextView.class);
        dialogUpUserAgreement.userAgreementNo = (TextView) butterknife.c.a.c(view, R.id.user_agreement_no, "field 'userAgreementNo'", TextView.class);
        dialogUpUserAgreement.userAgreementYes = (TextView) butterknife.c.a.c(view, R.id.user_agreement_yes, "field 'userAgreementYes'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogUpUserAgreement dialogUpUserAgreement = this.b;
        if (dialogUpUserAgreement != null) {
            this.b = null;
            dialogUpUserAgreement.userAgreementTv = null;
            dialogUpUserAgreement.userAgreementNo = null;
            dialogUpUserAgreement.userAgreementYes = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
