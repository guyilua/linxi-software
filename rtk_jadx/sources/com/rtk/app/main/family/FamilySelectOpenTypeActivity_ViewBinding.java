package com.rtk.app.main.family;

import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.NoOOMEditText;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilySelectOpenTypeActivity_ViewBinding implements Unbinder {
    private FamilySelectOpenTypeActivity b;

    @UiThread
    public FamilySelectOpenTypeActivity_ViewBinding(FamilySelectOpenTypeActivity familySelectOpenTypeActivity, View view) {
        this.b = familySelectOpenTypeActivity;
        familySelectOpenTypeActivity.save = (TextView) butterknife.c.a.c(view, R.id.save, "field 'save'", TextView.class);
        familySelectOpenTypeActivity.allowed = (RadioButton) butterknife.c.a.c(view, R.id.allowed, "field 'allowed'", RadioButton.class);
        familySelectOpenTypeActivity.notAllowed = (RadioButton) butterknife.c.a.c(view, R.id.not_allowed, "field 'notAllowed'", RadioButton.class);
        familySelectOpenTypeActivity.answerQuestion = (RadioButton) butterknife.c.a.c(view, R.id.answer_question, "field 'answerQuestion'", RadioButton.class);
        familySelectOpenTypeActivity.questionEditText = (NoOOMEditText) butterknife.c.a.c(view, R.id.question_edit, "field 'questionEditText'", NoOOMEditText.class);
        familySelectOpenTypeActivity.answerEditText = (NoOOMEditText) butterknife.c.a.c(view, R.id.answer_edit, "field 'answerEditText'", NoOOMEditText.class);
        familySelectOpenTypeActivity.questionAnswerLayout = butterknife.c.a.b(view, R.id.question_answer_layout, "field 'questionAnswerLayout'");
    }

    @CallSuper
    public void a() {
        FamilySelectOpenTypeActivity familySelectOpenTypeActivity = this.b;
        if (familySelectOpenTypeActivity != null) {
            this.b = null;
            familySelectOpenTypeActivity.save = null;
            familySelectOpenTypeActivity.allowed = null;
            familySelectOpenTypeActivity.notAllowed = null;
            familySelectOpenTypeActivity.answerQuestion = null;
            familySelectOpenTypeActivity.questionEditText = null;
            familySelectOpenTypeActivity.answerEditText = null;
            familySelectOpenTypeActivity.questionAnswerLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
