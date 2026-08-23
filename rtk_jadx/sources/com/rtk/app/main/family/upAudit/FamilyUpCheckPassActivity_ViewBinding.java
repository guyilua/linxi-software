package com.rtk.app.main.family.upAudit;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.custom.MyHorizontalScrollView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyUpCheckPassActivity_ViewBinding implements Unbinder {
    private FamilyUpCheckPassActivity b;

    @UiThread
    public FamilyUpCheckPassActivity_ViewBinding(FamilyUpCheckPassActivity familyUpCheckPassActivity, View view) {
        this.b = familyUpCheckPassActivity;
        familyUpCheckPassActivity.upCheckAgainPassShowNowStatus = (CustomTextView) butterknife.c.a.c(view, R.id.up_family_pass_show_NowStatus, "field 'upCheckAgainPassShowNowStatus'", CustomTextView.class);
        familyUpCheckPassActivity.upCheckAgainPassShowRadio0 = (RadioButton) butterknife.c.a.c(view, R.id.up_family_pass_show_radio0, "field 'upCheckAgainPassShowRadio0'", RadioButton.class);
        familyUpCheckPassActivity.upCheckAgainPassShowRadio1 = (RadioButton) butterknife.c.a.c(view, R.id.up_family_pass_show_radio1, "field 'upCheckAgainPassShowRadio1'", RadioButton.class);
        familyUpCheckPassActivity.upCheckAgainPassShowRadio2 = (RadioButton) butterknife.c.a.c(view, R.id.up_family_pass_show_radio2, "field 'upCheckAgainPassShowRadio2'", RadioButton.class);
        familyUpCheckPassActivity.upCheckAgainPassShowRadio3 = (RadioButton) butterknife.c.a.c(view, R.id.up_family_pass_show_radio3, "field 'upCheckAgainPassShowRadio3'", RadioButton.class);
        familyUpCheckPassActivity.upCheckAgainPassShowRadioGroup = (RadioGroup) butterknife.c.a.c(view, R.id.up_family_pass_show_radioGroup, "field 'upCheckAgainPassShowRadioGroup'", RadioGroup.class);
        familyUpCheckPassActivity.upCheckAgainPassShowReasonTipTv = (TextView) butterknife.c.a.c(view, R.id.up_family_pass_show_reason_tipTv, "field 'upCheckAgainPassShowReasonTipTv'", TextView.class);
        familyUpCheckPassActivity.upCheckAgainPassShowReason = (EditText) butterknife.c.a.c(view, R.id.up_family_pass_show_reason, "field 'upCheckAgainPassShowReason'", EditText.class);
        familyUpCheckPassActivity.upCheckAgainTopBack = (TextView) butterknife.c.a.c(view, R.id.up_family_top_back, "field 'upCheckAgainTopBack'", TextView.class);
        familyUpCheckPassActivity.upCheckAgainTopSubmit = (TextView) butterknife.c.a.c(view, R.id.up_family_top_submit, "field 'upCheckAgainTopSubmit'", TextView.class);
        familyUpCheckPassActivity.upCheckAgainTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_family_top_layout, "field 'upCheckAgainTopLayout'", LinearLayout.class);
        familyUpCheckPassActivity.upCheckAgainListShowAppIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.up_family_list_show_appIcon, "field 'upCheckAgainListShowAppIcon'", RoundedImageView.class);
        familyUpCheckPassActivity.upCheckAgainListShowAppName = (TextView) butterknife.c.a.c(view, R.id.up_family_list_show_appName, "field 'upCheckAgainListShowAppName'", TextView.class);
        familyUpCheckPassActivity.upCheckAgainListShowAppSizeAndPlayerNum = (TextView) butterknife.c.a.c(view, R.id.up_family_list_show_appSize_and_playerNum, "field 'upCheckAgainListShowAppSizeAndPlayerNum'", TextView.class);
        familyUpCheckPassActivity.upCheckAgainListShowAppVersion = (TextView) butterknife.c.a.c(view, R.id.up_family_list_show_appVersion, "field 'upCheckAgainListShowAppVersion'", TextView.class);
        familyUpCheckPassActivity.upCheckAgainListShowHeadLv = (LinearLayout) butterknife.c.a.c(view, R.id.up_family_list_show_headLv, "field 'upCheckAgainListShowHeadLv'", LinearLayout.class);
        familyUpCheckPassActivity.upCheckAgainListShowItem1Lv = (LinearLayout) butterknife.c.a.c(view, R.id.up_family_list_show_item1_lv, "field 'upCheckAgainListShowItem1Lv'", LinearLayout.class);
        familyUpCheckPassActivity.upCheckAgainListShowItem1SV = (MyHorizontalScrollView) butterknife.c.a.c(view, R.id.up_family_list_show_item1_SV, "field 'upCheckAgainListShowItem1SV'", MyHorizontalScrollView.class);
        familyUpCheckPassActivity.upCheckAgainListShowFragment1Characteristic = (TextView) butterknife.c.a.c(view, R.id.up_family_list_show_fragment1_characteristic, "field 'upCheckAgainListShowFragment1Characteristic'", TextView.class);
        familyUpCheckPassActivity.upCheckAgainListShowFragment1CharacteristicLV = (LinearLayout) butterknife.c.a.c(view, R.id.up_family_list_show_fragment1_characteristic_LV, "field 'upCheckAgainListShowFragment1CharacteristicLV'", LinearLayout.class);
        familyUpCheckPassActivity.upCheckListShowItem1GameIntro = (TextView) butterknife.c.a.c(view, R.id.up_family_list_show_item1_gameIntro, "field 'upCheckListShowItem1GameIntro'", TextView.class);
        familyUpCheckPassActivity.upCheckListShowItem1GameIntroLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_family_list_show_item1_gameIntro_layout, "field 'upCheckListShowItem1GameIntroLayout'", LinearLayout.class);
        familyUpCheckPassActivity.upCheckAgainListShowItem1Type = (CustomTextView) butterknife.c.a.c(view, R.id.up_family_list_show_item1_type, "field 'upCheckAgainListShowItem1Type'", CustomTextView.class);
        familyUpCheckPassActivity.upCheckAgainListShowItem1Language = (CustomTextView) butterknife.c.a.c(view, R.id.up_family_list_show_item1_language, "field 'upCheckAgainListShowItem1Language'", CustomTextView.class);
        familyUpCheckPassActivity.upCheckAgainListShowItem1Time = (CustomTextView) butterknife.c.a.c(view, R.id.up_family_list_show_item1_time, "field 'upCheckAgainListShowItem1Time'", CustomTextView.class);
        familyUpCheckPassActivity.upCheckAgainListShowItem1Version = (CustomTextView) butterknife.c.a.c(view, R.id.up_family_list_show_item1_version, "field 'upCheckAgainListShowItem1Version'", CustomTextView.class);
        familyUpCheckPassActivity.upCheckAgainListShowItem1Author = (CustomTextView) butterknife.c.a.c(view, R.id.up_family_list_show_item1_author, "field 'upCheckAgainListShowItem1Author'", CustomTextView.class);
        familyUpCheckPassActivity.upCheckAgainListShowItem1GamePermissionDetails = (TextView) butterknife.c.a.c(view, R.id.up_family_list_show_item1_game_permission_details, "field 'upCheckAgainListShowItem1GamePermissionDetails'", TextView.class);
        familyUpCheckPassActivity.upCheckAgainListShowItem1GameInformationLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_family_list_show_item1_game_information_layout, "field 'upCheckAgainListShowItem1GameInformationLayout'", LinearLayout.class);
        familyUpCheckPassActivity.upCheckAgainListShowItem1GameRewardLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_family_list_show_item1_game_reward_layout, "field 'upCheckAgainListShowItem1GameRewardLayout'", LinearLayout.class);
        familyUpCheckPassActivity.upCheckAgainListShowItem1GameRewardLv = (LinearLayout) butterknife.c.a.c(view, R.id.up_family_list_show_item1_game_reward_lv, "field 'upCheckAgainListShowItem1GameRewardLv'", LinearLayout.class);
        familyUpCheckPassActivity.upCheckAgainListShowItem1GameRewardNum = (CustomTextView) butterknife.c.a.c(view, R.id.up_family_list_show_item1_game_reward_num, "field 'upCheckAgainListShowItem1GameRewardNum'", CustomTextView.class);
        familyUpCheckPassActivity.upCheckAgainListShowItem1GameRewardLv2 = (LinearLayout) butterknife.c.a.c(view, R.id.up_family_list_show_item1_game_reward_lv2, "field 'upCheckAgainListShowItem1GameRewardLv2'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        FamilyUpCheckPassActivity familyUpCheckPassActivity = this.b;
        if (familyUpCheckPassActivity != null) {
            this.b = null;
            familyUpCheckPassActivity.upCheckAgainPassShowNowStatus = null;
            familyUpCheckPassActivity.upCheckAgainPassShowRadio0 = null;
            familyUpCheckPassActivity.upCheckAgainPassShowRadio1 = null;
            familyUpCheckPassActivity.upCheckAgainPassShowRadio2 = null;
            familyUpCheckPassActivity.upCheckAgainPassShowRadio3 = null;
            familyUpCheckPassActivity.upCheckAgainPassShowRadioGroup = null;
            familyUpCheckPassActivity.upCheckAgainPassShowReasonTipTv = null;
            familyUpCheckPassActivity.upCheckAgainPassShowReason = null;
            familyUpCheckPassActivity.upCheckAgainTopBack = null;
            familyUpCheckPassActivity.upCheckAgainTopSubmit = null;
            familyUpCheckPassActivity.upCheckAgainTopLayout = null;
            familyUpCheckPassActivity.upCheckAgainListShowAppIcon = null;
            familyUpCheckPassActivity.upCheckAgainListShowAppName = null;
            familyUpCheckPassActivity.upCheckAgainListShowAppSizeAndPlayerNum = null;
            familyUpCheckPassActivity.upCheckAgainListShowAppVersion = null;
            familyUpCheckPassActivity.upCheckAgainListShowHeadLv = null;
            familyUpCheckPassActivity.upCheckAgainListShowItem1Lv = null;
            familyUpCheckPassActivity.upCheckAgainListShowItem1SV = null;
            familyUpCheckPassActivity.upCheckAgainListShowFragment1Characteristic = null;
            familyUpCheckPassActivity.upCheckAgainListShowFragment1CharacteristicLV = null;
            familyUpCheckPassActivity.upCheckListShowItem1GameIntro = null;
            familyUpCheckPassActivity.upCheckListShowItem1GameIntroLayout = null;
            familyUpCheckPassActivity.upCheckAgainListShowItem1Type = null;
            familyUpCheckPassActivity.upCheckAgainListShowItem1Language = null;
            familyUpCheckPassActivity.upCheckAgainListShowItem1Time = null;
            familyUpCheckPassActivity.upCheckAgainListShowItem1Version = null;
            familyUpCheckPassActivity.upCheckAgainListShowItem1Author = null;
            familyUpCheckPassActivity.upCheckAgainListShowItem1GamePermissionDetails = null;
            familyUpCheckPassActivity.upCheckAgainListShowItem1GameInformationLayout = null;
            familyUpCheckPassActivity.upCheckAgainListShowItem1GameRewardLayout = null;
            familyUpCheckPassActivity.upCheckAgainListShowItem1GameRewardLv = null;
            familyUpCheckPassActivity.upCheckAgainListShowItem1GameRewardNum = null;
            familyUpCheckPassActivity.upCheckAgainListShowItem1GameRewardLv2 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
