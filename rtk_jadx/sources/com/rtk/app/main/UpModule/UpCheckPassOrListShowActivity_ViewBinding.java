package com.rtk.app.main.UpModule;

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
public class UpCheckPassOrListShowActivity_ViewBinding implements Unbinder {
    private UpCheckPassOrListShowActivity b;

    @UiThread
    public UpCheckPassOrListShowActivity_ViewBinding(UpCheckPassOrListShowActivity upCheckPassOrListShowActivity, View view) {
        this.b = upCheckPassOrListShowActivity;
        upCheckPassOrListShowActivity.upCheckPassShowSuggestion = (CustomTextView) butterknife.c.a.c(view, R.id.up_check_pass_show_suggestion, "field 'upCheckPassShowSuggestion'", CustomTextView.class);
        upCheckPassOrListShowActivity.upCheckPassShowNowStatus = (CustomTextView) butterknife.c.a.c(view, R.id.up_check_pass_show_NowStatus, "field 'upCheckPassShowNowStatus'", CustomTextView.class);
        upCheckPassOrListShowActivity.upCheckPassShowRadio0 = (RadioButton) butterknife.c.a.c(view, R.id.up_check_pass_show_radio0, "field 'upCheckPassShowRadio0'", RadioButton.class);
        upCheckPassOrListShowActivity.upCheckPassShowRadio1 = (RadioButton) butterknife.c.a.c(view, R.id.up_check_pass_show_radio1, "field 'upCheckPassShowRadio1'", RadioButton.class);
        upCheckPassOrListShowActivity.upCheckPassShowRadio2 = (RadioButton) butterknife.c.a.c(view, R.id.up_check_pass_show_radio2, "field 'upCheckPassShowRadio2'", RadioButton.class);
        upCheckPassOrListShowActivity.upCheckPassShowRadio3 = (RadioButton) butterknife.c.a.c(view, R.id.up_check_pass_show_radio3, "field 'upCheckPassShowRadio3'", RadioButton.class);
        upCheckPassOrListShowActivity.upCheckPassShowRadioGroup = (RadioGroup) butterknife.c.a.c(view, R.id.up_check_pass_show_radioGroup, "field 'upCheckPassShowRadioGroup'", RadioGroup.class);
        upCheckPassOrListShowActivity.upCheckPassShowReasonTipTv = (TextView) butterknife.c.a.c(view, R.id.up_check_pass_show_reason_tipTv, "field 'upCheckPassShowReasonTipTv'", TextView.class);
        upCheckPassOrListShowActivity.upCheckPassShowReason = (EditText) butterknife.c.a.c(view, R.id.up_check_pass_show_reason, "field 'upCheckPassShowReason'", EditText.class);
        upCheckPassOrListShowActivity.upCheckListShowStatus = (CustomTextView) butterknife.c.a.c(view, R.id.up_check_list_show_status, "field 'upCheckListShowStatus'", CustomTextView.class);
        upCheckPassOrListShowActivity.upCheckListShowRadio0 = (RadioButton) butterknife.c.a.c(view, R.id.up_check_list_show_radio0, "field 'upCheckListShowRadio0'", RadioButton.class);
        upCheckPassOrListShowActivity.upCheckListShowRadio1 = (RadioButton) butterknife.c.a.c(view, R.id.up_check_list_show_radio1, "field 'upCheckListShowRadio1'", RadioButton.class);
        upCheckPassOrListShowActivity.upCheckListShowRadioGroup = (RadioGroup) butterknife.c.a.c(view, R.id.up_check_list_show_radioGroup, "field 'upCheckListShowRadioGroup'", RadioGroup.class);
        upCheckPassOrListShowActivity.upCheckListShowReason = (EditText) butterknife.c.a.c(view, R.id.up_check_list_show_reason, "field 'upCheckListShowReason'", EditText.class);
        upCheckPassOrListShowActivity.upCheckListShowEdit = (TextView) butterknife.c.a.c(view, R.id.up_check_list_show_edit, "field 'upCheckListShowEdit'", TextView.class);
        upCheckPassOrListShowActivity.upCheckTopBack = (TextView) butterknife.c.a.c(view, R.id.up_check_top_back, "field 'upCheckTopBack'", TextView.class);
        upCheckPassOrListShowActivity.upCheckTopSubmit = (TextView) butterknife.c.a.c(view, R.id.up_check_top_submit, "field 'upCheckTopSubmit'", TextView.class);
        upCheckPassOrListShowActivity.upCheckTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_check_top_layout, "field 'upCheckTopLayout'", LinearLayout.class);
        upCheckPassOrListShowActivity.upCheckListShowAppIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.up_check_list_show_appIcon, "field 'upCheckListShowAppIcon'", RoundedImageView.class);
        upCheckPassOrListShowActivity.upCheckListShowAppName = (TextView) butterknife.c.a.c(view, R.id.up_check_list_show_appName, "field 'upCheckListShowAppName'", TextView.class);
        upCheckPassOrListShowActivity.upCheckListShowAppSizeAndPlayerNum = (TextView) butterknife.c.a.c(view, R.id.up_check_list_show_appSize_and_playerNum, "field 'upCheckListShowAppSizeAndPlayerNum'", TextView.class);
        upCheckPassOrListShowActivity.upCheckListShowAppVersion = (TextView) butterknife.c.a.c(view, R.id.up_check_list_show_appVersion, "field 'upCheckListShowAppVersion'", TextView.class);
        upCheckPassOrListShowActivity.upCheckListShowHeadLv = (LinearLayout) butterknife.c.a.c(view, R.id.up_check_list_show_headLv, "field 'upCheckListShowHeadLv'", LinearLayout.class);
        upCheckPassOrListShowActivity.upCheckListShowItem1Lv = (LinearLayout) butterknife.c.a.c(view, R.id.up_check_list_show_item1_lv, "field 'upCheckListShowItem1Lv'", LinearLayout.class);
        upCheckPassOrListShowActivity.upCheckListShowItem1SV = (MyHorizontalScrollView) butterknife.c.a.c(view, R.id.up_check_list_show_item1_SV, "field 'upCheckListShowItem1SV'", MyHorizontalScrollView.class);
        upCheckPassOrListShowActivity.upCheckListShowFragment1Characteristic = (TextView) butterknife.c.a.c(view, R.id.up_check_list_show_fragment1_characteristic, "field 'upCheckListShowFragment1Characteristic'", TextView.class);
        upCheckPassOrListShowActivity.upCheckListShowFragment1CharacteristicLV = (LinearLayout) butterknife.c.a.c(view, R.id.up_check_list_show_fragment1_characteristic_LV, "field 'upCheckListShowFragment1CharacteristicLV'", LinearLayout.class);
        upCheckPassOrListShowActivity.upCheckListShowItem1GameIntro = (TextView) butterknife.c.a.c(view, R.id.up_check_list_show_item1_gameIntro, "field 'upCheckListShowItem1GameIntro'", TextView.class);
        upCheckPassOrListShowActivity.upCheckListShowItem1GameIntroLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_check_list_show_item1_gameIntro_layout, "field 'upCheckListShowItem1GameIntroLayout'", LinearLayout.class);
        upCheckPassOrListShowActivity.upCheckListShowItem1Type = (CustomTextView) butterknife.c.a.c(view, R.id.up_check_list_show_item1_type, "field 'upCheckListShowItem1Type'", CustomTextView.class);
        upCheckPassOrListShowActivity.upCheckListShowItem1Language = (CustomTextView) butterknife.c.a.c(view, R.id.up_check_list_show_item1_language, "field 'upCheckListShowItem1Language'", CustomTextView.class);
        upCheckPassOrListShowActivity.upCheckListShowItem1Time = (CustomTextView) butterknife.c.a.c(view, R.id.up_check_list_show_item1_time, "field 'upCheckListShowItem1Time'", CustomTextView.class);
        upCheckPassOrListShowActivity.upCheckListShowItem1Version = (CustomTextView) butterknife.c.a.c(view, R.id.up_check_list_show_item1_version, "field 'upCheckListShowItem1Version'", CustomTextView.class);
        upCheckPassOrListShowActivity.upCheckListShowItem1Author = (CustomTextView) butterknife.c.a.c(view, R.id.up_check_list_show_item1_author, "field 'upCheckListShowItem1Author'", CustomTextView.class);
        upCheckPassOrListShowActivity.upCheckListShowItem1GamePermissionDetails = (TextView) butterknife.c.a.c(view, R.id.up_check_list_show_item1_game_permission_details, "field 'upCheckListShowItem1GamePermissionDetails'", TextView.class);
        upCheckPassOrListShowActivity.upCheckListShowItem1GameInformationLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_check_list_show_item1_game_information_layout, "field 'upCheckListShowItem1GameInformationLayout'", LinearLayout.class);
        upCheckPassOrListShowActivity.upCheckListShowItem1GameRewardLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_check_list_show_item1_game_reward_layout, "field 'upCheckListShowItem1GameRewardLayout'", LinearLayout.class);
        upCheckPassOrListShowActivity.upCheckListShowItem1GameRewardLv = (LinearLayout) butterknife.c.a.c(view, R.id.up_check_list_show_item1_game_reward_lv, "field 'upCheckListShowItem1GameRewardLv'", LinearLayout.class);
        upCheckPassOrListShowActivity.upCheckListShowItem1GameRewardNum = (CustomTextView) butterknife.c.a.c(view, R.id.up_check_list_show_item1_game_reward_num, "field 'upCheckListShowItem1GameRewardNum'", CustomTextView.class);
        upCheckPassOrListShowActivity.upCheckListShowItem1GameRewardLv2 = (LinearLayout) butterknife.c.a.c(view, R.id.up_check_list_show_item1_game_reward_lv2, "field 'upCheckListShowItem1GameRewardLv2'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        UpCheckPassOrListShowActivity upCheckPassOrListShowActivity = this.b;
        if (upCheckPassOrListShowActivity != null) {
            this.b = null;
            upCheckPassOrListShowActivity.upCheckPassShowSuggestion = null;
            upCheckPassOrListShowActivity.upCheckPassShowNowStatus = null;
            upCheckPassOrListShowActivity.upCheckPassShowRadio0 = null;
            upCheckPassOrListShowActivity.upCheckPassShowRadio1 = null;
            upCheckPassOrListShowActivity.upCheckPassShowRadio2 = null;
            upCheckPassOrListShowActivity.upCheckPassShowRadio3 = null;
            upCheckPassOrListShowActivity.upCheckPassShowRadioGroup = null;
            upCheckPassOrListShowActivity.upCheckPassShowReasonTipTv = null;
            upCheckPassOrListShowActivity.upCheckPassShowReason = null;
            upCheckPassOrListShowActivity.upCheckListShowStatus = null;
            upCheckPassOrListShowActivity.upCheckListShowRadio0 = null;
            upCheckPassOrListShowActivity.upCheckListShowRadio1 = null;
            upCheckPassOrListShowActivity.upCheckListShowRadioGroup = null;
            upCheckPassOrListShowActivity.upCheckListShowReason = null;
            upCheckPassOrListShowActivity.upCheckListShowEdit = null;
            upCheckPassOrListShowActivity.upCheckTopBack = null;
            upCheckPassOrListShowActivity.upCheckTopSubmit = null;
            upCheckPassOrListShowActivity.upCheckTopLayout = null;
            upCheckPassOrListShowActivity.upCheckListShowAppIcon = null;
            upCheckPassOrListShowActivity.upCheckListShowAppName = null;
            upCheckPassOrListShowActivity.upCheckListShowAppSizeAndPlayerNum = null;
            upCheckPassOrListShowActivity.upCheckListShowAppVersion = null;
            upCheckPassOrListShowActivity.upCheckListShowHeadLv = null;
            upCheckPassOrListShowActivity.upCheckListShowItem1Lv = null;
            upCheckPassOrListShowActivity.upCheckListShowItem1SV = null;
            upCheckPassOrListShowActivity.upCheckListShowFragment1Characteristic = null;
            upCheckPassOrListShowActivity.upCheckListShowFragment1CharacteristicLV = null;
            upCheckPassOrListShowActivity.upCheckListShowItem1GameIntro = null;
            upCheckPassOrListShowActivity.upCheckListShowItem1GameIntroLayout = null;
            upCheckPassOrListShowActivity.upCheckListShowItem1Type = null;
            upCheckPassOrListShowActivity.upCheckListShowItem1Language = null;
            upCheckPassOrListShowActivity.upCheckListShowItem1Time = null;
            upCheckPassOrListShowActivity.upCheckListShowItem1Version = null;
            upCheckPassOrListShowActivity.upCheckListShowItem1Author = null;
            upCheckPassOrListShowActivity.upCheckListShowItem1GamePermissionDetails = null;
            upCheckPassOrListShowActivity.upCheckListShowItem1GameInformationLayout = null;
            upCheckPassOrListShowActivity.upCheckListShowItem1GameRewardLayout = null;
            upCheckPassOrListShowActivity.upCheckListShowItem1GameRewardLv = null;
            upCheckPassOrListShowActivity.upCheckListShowItem1GameRewardNum = null;
            upCheckPassOrListShowActivity.upCheckListShowItem1GameRewardLv2 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
