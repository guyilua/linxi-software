package com.rtk.app.main.UpModule;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.custom.MyHorizontalScrollView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpApkDetailsFragment1_ViewBinding implements Unbinder {
    private UpApkDetailsFragment1 b;

    @UiThread
    public UpApkDetailsFragment1_ViewBinding(UpApkDetailsFragment1 upApkDetailsFragment1, View view) {
        this.b = upApkDetailsFragment1;
        upApkDetailsFragment1.upApkDetailsItem1Lv = (LinearLayout) butterknife.c.a.c(view, R.id.up_apk_details_item1_lv, "field 'upApkDetailsItem1Lv'", LinearLayout.class);
        upApkDetailsFragment1.upApkDetailsInformationAdsView = (LinearLayout) butterknife.c.a.c(view, R.id.up_apk_details_fragment1_information_ads, "field 'upApkDetailsInformationAdsView'", LinearLayout.class);
        upApkDetailsFragment1.upApkDetailsItem1SV = (MyHorizontalScrollView) butterknife.c.a.c(view, R.id.up_apk_details_item1_SV, "field 'upApkDetailsItem1SV'", MyHorizontalScrollView.class);
        upApkDetailsFragment1.upApkDetailsItem1GameIntro = (TextView) butterknife.c.a.c(view, R.id.up_apk_details_item1_gameIntro, "field 'upApkDetailsItem1GameIntro'", TextView.class);
        upApkDetailsFragment1.upApkDetailsItem1GameIntroOpen = (TextView) butterknife.c.a.c(view, R.id.up_apk_details_item1_gameIntro_open, "field 'upApkDetailsItem1GameIntroOpen'", TextView.class);
        upApkDetailsFragment1.upApkDetailsItem1GameIntroLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_apk_details_item1_gameIntro_layout, "field 'upApkDetailsItem1GameIntroLayout'", LinearLayout.class);
        upApkDetailsFragment1.upApkDetailsItem1Type = (TextView) butterknife.c.a.c(view, R.id.up_apk_details_item1_type, "field 'upApkDetailsItem1Type'", TextView.class);
        upApkDetailsFragment1.upApkDetailsItem1Language = (TextView) butterknife.c.a.c(view, R.id.up_apk_details_item1_language, "field 'upApkDetailsItem1Language'", TextView.class);
        upApkDetailsFragment1.upApkDetailsItem1Time = (TextView) butterknife.c.a.c(view, R.id.up_apk_details_item1_time, "field 'upApkDetailsItem1Time'", TextView.class);
        upApkDetailsFragment1.upApkDetailsItem1Version = (TextView) butterknife.c.a.c(view, R.id.up_apk_details_item1_version, "field 'upApkDetailsItem1Version'", TextView.class);
        upApkDetailsFragment1.upApkDetailsItem1Author = (TextView) butterknife.c.a.c(view, R.id.up_apk_details_item1_author, "field 'upApkDetailsItem1Author'", TextView.class);
        upApkDetailsFragment1.upApkDetailsItem1GameInformationLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_apk_details_item1_game_information_layout, "field 'upApkDetailsItem1GameInformationLayout'", LinearLayout.class);
        upApkDetailsFragment1.upApkDetailsFragment1Characteristic = (TextView) butterknife.c.a.c(view, R.id.up_apk_details_fragment1_characteristic, "field 'upApkDetailsFragment1Characteristic'", TextView.class);
        upApkDetailsFragment1.upApkDetailsFragment1CharacteristicOpen = (TextView) butterknife.c.a.c(view, R.id.up_apk_details_fragment1_characteristic_open, "field 'upApkDetailsFragment1CharacteristicOpen'", TextView.class);
        upApkDetailsFragment1.upApkDetailsItem1GamePermissionDetails = (TextView) butterknife.c.a.c(view, R.id.up_apk_details_item1_game_permission_details, "field 'upApkDetailsItem1GamePermissionDetails'", TextView.class);
        upApkDetailsFragment1.upApkDetailsFragment1CharacteristicLV = (LinearLayout) butterknife.c.a.c(view, R.id.up_apk_details_fragment1_characteristic_LV, "field 'upApkDetailsFragment1CharacteristicLV'", LinearLayout.class);
        upApkDetailsFragment1.upApkDetailsItem1GameRewardLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_apk_details_item1_game_reward_layout, "field 'upApkDetailsItem1GameRewardLayout'", LinearLayout.class);
        upApkDetailsFragment1.upApkDetailsItem1GameRewardLv = (LinearLayout) butterknife.c.a.c(view, R.id.up_apk_details_item1_game_reward_lv, "field 'upApkDetailsItem1GameRewardLv'", LinearLayout.class);
        upApkDetailsFragment1.upApkDetailsItem1GameRewardNum = (CustomTextView) butterknife.c.a.c(view, R.id.up_apk_details_item1_game_reward_num, "field 'upApkDetailsItem1GameRewardNum'", CustomTextView.class);
        upApkDetailsFragment1.upApkDetailsItem1GameRewardLv2 = (LinearLayout) butterknife.c.a.c(view, R.id.up_apk_details_item1_game_reward_lv2, "field 'upApkDetailsItem1GameRewardLv2'", LinearLayout.class);
        upApkDetailsFragment1.upApkDetailsItem1DownCoinsLv = (LinearLayout) butterknife.c.a.c(view, R.id.up_apk_details_item1_down_coins_lv, "field 'upApkDetailsItem1DownCoinsLv'", LinearLayout.class);
        upApkDetailsFragment1.upApkDetailsItem1DownCoinsTv = (TextView) butterknife.c.a.c(view, R.id.up_apk_details_item1_down_coins, "field 'upApkDetailsItem1DownCoinsTv'", TextView.class);
        upApkDetailsFragment1.upApkDetailsItem1GameFamilyName = (TextView) butterknife.c.a.c(view, R.id.up_apk_details_item1_game_family_name, "field 'upApkDetailsItem1GameFamilyName'", TextView.class);
    }

    @CallSuper
    public void a() {
        UpApkDetailsFragment1 upApkDetailsFragment1 = this.b;
        if (upApkDetailsFragment1 != null) {
            this.b = null;
            upApkDetailsFragment1.upApkDetailsItem1Lv = null;
            upApkDetailsFragment1.upApkDetailsInformationAdsView = null;
            upApkDetailsFragment1.upApkDetailsItem1SV = null;
            upApkDetailsFragment1.upApkDetailsItem1GameIntro = null;
            upApkDetailsFragment1.upApkDetailsItem1GameIntroOpen = null;
            upApkDetailsFragment1.upApkDetailsItem1GameIntroLayout = null;
            upApkDetailsFragment1.upApkDetailsItem1Type = null;
            upApkDetailsFragment1.upApkDetailsItem1Language = null;
            upApkDetailsFragment1.upApkDetailsItem1Time = null;
            upApkDetailsFragment1.upApkDetailsItem1Version = null;
            upApkDetailsFragment1.upApkDetailsItem1Author = null;
            upApkDetailsFragment1.upApkDetailsItem1GameInformationLayout = null;
            upApkDetailsFragment1.upApkDetailsFragment1Characteristic = null;
            upApkDetailsFragment1.upApkDetailsFragment1CharacteristicOpen = null;
            upApkDetailsFragment1.upApkDetailsItem1GamePermissionDetails = null;
            upApkDetailsFragment1.upApkDetailsFragment1CharacteristicLV = null;
            upApkDetailsFragment1.upApkDetailsItem1GameRewardLayout = null;
            upApkDetailsFragment1.upApkDetailsItem1GameRewardLv = null;
            upApkDetailsFragment1.upApkDetailsItem1GameRewardNum = null;
            upApkDetailsFragment1.upApkDetailsItem1GameRewardLv2 = null;
            upApkDetailsFragment1.upApkDetailsItem1DownCoinsLv = null;
            upApkDetailsFragment1.upApkDetailsItem1DownCoinsTv = null;
            upApkDetailsFragment1.upApkDetailsItem1GameFamilyName = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
