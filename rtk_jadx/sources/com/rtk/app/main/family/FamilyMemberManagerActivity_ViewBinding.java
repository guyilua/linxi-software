package com.rtk.app.main.family;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.custom.NoOOMEditText;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyMemberManagerActivity_ViewBinding implements Unbinder {
    private FamilyMemberManagerActivity b;

    @UiThread
    public FamilyMemberManagerActivity_ViewBinding(FamilyMemberManagerActivity familyMemberManagerActivity, View view) {
        this.b = familyMemberManagerActivity;
        familyMemberManagerActivity.autoListView = (AutoListView) butterknife.c.a.c(view, R.id.listview, "field 'autoListView'", AutoListView.class);
        familyMemberManagerActivity.noOOMEditText = (NoOOMEditText) butterknife.c.a.c(view, R.id.add_attention_edv, "field 'noOOMEditText'", NoOOMEditText.class);
        familyMemberManagerActivity.remove = butterknife.c.a.b(view, R.id.remove, "field 'remove'");
        familyMemberManagerActivity.backLayout = butterknife.c.a.b(view, R.id.back_layout, "field 'backLayout'");
    }

    @CallSuper
    public void a() {
        FamilyMemberManagerActivity familyMemberManagerActivity = this.b;
        if (familyMemberManagerActivity != null) {
            this.b = null;
            familyMemberManagerActivity.autoListView = null;
            familyMemberManagerActivity.noOOMEditText = null;
            familyMemberManagerActivity.remove = null;
            familyMemberManagerActivity.backLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
