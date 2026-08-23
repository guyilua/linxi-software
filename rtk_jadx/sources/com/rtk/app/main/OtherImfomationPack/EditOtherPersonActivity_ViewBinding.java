package com.rtk.app.main.OtherImfomationPack;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.NoOOMEditText;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class EditOtherPersonActivity_ViewBinding implements Unbinder {
    private EditOtherPersonActivity b;

    @UiThread
    public EditOtherPersonActivity_ViewBinding(EditOtherPersonActivity editOtherPersonActivity, View view) {
        this.b = editOtherPersonActivity;
        editOtherPersonActivity.editOtherPersonalBack = (TextView) butterknife.c.a.c(view, R.id.edit_other_personal_back, "field 'editOtherPersonalBack'", TextView.class);
        editOtherPersonActivity.editOtherPersonalEnsure = (TextView) butterknife.c.a.c(view, R.id.edit_other_personal_ensure, "field 'editOtherPersonalEnsure'", TextView.class);
        editOtherPersonActivity.editOtherPersonalTopLayout = (RelativeLayout) butterknife.c.a.c(view, R.id.edit_other_personal_top_layout, "field 'editOtherPersonalTopLayout'", RelativeLayout.class);
        editOtherPersonActivity.editOtherPersonalInformationName = (NoOOMEditText) butterknife.c.a.c(view, R.id.edit_other_personal_information_name, "field 'editOtherPersonalInformationName'", NoOOMEditText.class);
        editOtherPersonActivity.editOtherPersonalInformationNameLayout = (LinearLayout) butterknife.c.a.c(view, R.id.edit_other_personal_information_name_layout, "field 'editOtherPersonalInformationNameLayout'", LinearLayout.class);
        editOtherPersonActivity.editOtherPersonalInformationSex = (RadioGroup) butterknife.c.a.c(view, R.id.edit_other_personal_information_sex, "field 'editOtherPersonalInformationSex'", RadioGroup.class);
        editOtherPersonActivity.editOtherPersonalInformationSexLayout = (LinearLayout) butterknife.c.a.c(view, R.id.edit_other_personal_information_sex_layout, "field 'editOtherPersonalInformationSexLayout'", LinearLayout.class);
        editOtherPersonActivity.editOtherPersonalInformationQQ = (NoOOMEditText) butterknife.c.a.c(view, R.id.edit_other_personal_information_QQ, "field 'editOtherPersonalInformationQQ'", NoOOMEditText.class);
        editOtherPersonActivity.editOtherPersonalInformationQQLayout = (LinearLayout) butterknife.c.a.c(view, R.id.edit_other_personal_information_QQ_layout, "field 'editOtherPersonalInformationQQLayout'", LinearLayout.class);
        editOtherPersonActivity.editOtherPersonalInformationEmail = (NoOOMEditText) butterknife.c.a.c(view, R.id.edit_other_personal_information_email, "field 'editOtherPersonalInformationEmail'", NoOOMEditText.class);
        editOtherPersonActivity.editOtherPersonalInformationEmailLayout = (LinearLayout) butterknife.c.a.c(view, R.id.edit_other_personal_information_email_layout, "field 'editOtherPersonalInformationEmailLayout'", LinearLayout.class);
        editOtherPersonActivity.editOtherPersonalInformationBirthday = (TextView) butterknife.c.a.c(view, R.id.edit_other_personal_information_birthday, "field 'editOtherPersonalInformationBirthday'", TextView.class);
        editOtherPersonActivity.editOtherPersonalInformationBirthdayLayout = (LinearLayout) butterknife.c.a.c(view, R.id.edit_other_personal_information_birthday_layout, "field 'editOtherPersonalInformationBirthdayLayout'", LinearLayout.class);
        editOtherPersonActivity.editOtherPersonalInformationIntro = (NoOOMEditText) butterknife.c.a.c(view, R.id.edit_other_personal_information_intro, "field 'editOtherPersonalInformationIntro'", NoOOMEditText.class);
        editOtherPersonActivity.editOtherPersonalInformationIntroLayout = (LinearLayout) butterknife.c.a.c(view, R.id.edit_other_personal_information_intro_layout, "field 'editOtherPersonalInformationIntroLayout'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        EditOtherPersonActivity editOtherPersonActivity = this.b;
        if (editOtherPersonActivity != null) {
            this.b = null;
            editOtherPersonActivity.editOtherPersonalBack = null;
            editOtherPersonActivity.editOtherPersonalEnsure = null;
            editOtherPersonActivity.editOtherPersonalTopLayout = null;
            editOtherPersonActivity.editOtherPersonalInformationName = null;
            editOtherPersonActivity.editOtherPersonalInformationNameLayout = null;
            editOtherPersonActivity.editOtherPersonalInformationSex = null;
            editOtherPersonActivity.editOtherPersonalInformationSexLayout = null;
            editOtherPersonActivity.editOtherPersonalInformationQQ = null;
            editOtherPersonActivity.editOtherPersonalInformationQQLayout = null;
            editOtherPersonActivity.editOtherPersonalInformationEmail = null;
            editOtherPersonActivity.editOtherPersonalInformationEmailLayout = null;
            editOtherPersonActivity.editOtherPersonalInformationBirthday = null;
            editOtherPersonActivity.editOtherPersonalInformationBirthdayLayout = null;
            editOtherPersonActivity.editOtherPersonalInformationIntro = null;
            editOtherPersonActivity.editOtherPersonalInformationIntroLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
