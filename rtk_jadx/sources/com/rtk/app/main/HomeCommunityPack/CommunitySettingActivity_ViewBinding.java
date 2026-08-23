package com.rtk.app.main.HomeCommunityPack;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CommunitySettingActivity_ViewBinding implements Unbinder {
    private CommunitySettingActivity b;

    @UiThread
    public CommunitySettingActivity_ViewBinding(CommunitySettingActivity communitySettingActivity, View view) {
        this.b = communitySettingActivity;
        communitySettingActivity.communitySettingBack = (TextView) butterknife.c.a.c(view, R.id.community_setting_back, "field 'communitySettingBack'", TextView.class);
        communitySettingActivity.communitySettingLayout = (LinearLayout) butterknife.c.a.c(view, R.id.community_setting_layout, "field 'communitySettingLayout'", LinearLayout.class);
        communitySettingActivity.communitySettingPostJustTitle = (CheckBox) butterknife.c.a.c(view, R.id.community_setting_post_just_title, "field 'communitySettingPostJustTitle'", CheckBox.class);
        communitySettingActivity.communitySettingRule = (CheckBox) butterknife.c.a.c(view, R.id.community_setting_rule, "field 'communitySettingRule'", CheckBox.class);
        communitySettingActivity.communitySettingPost9Concise = (RadioButton) butterknife.c.a.c(view, R.id.community_setting_post_9_concise, "field 'communitySettingPost9Concise'", RadioButton.class);
        communitySettingActivity.communitySettingPostDetails = (RadioButton) butterknife.c.a.c(view, R.id.community_setting_post_details, "field 'communitySettingPostDetails'", RadioButton.class);
        communitySettingActivity.communitySettingDeleteLineFeed = (CheckBox) butterknife.c.a.c(view, R.id.community_setting_delete_line_feed, "field 'communitySettingDeleteLineFeed'", CheckBox.class);
        communitySettingActivity.communitySettingNightOriginal = (CheckBox) butterknife.c.a.c(view, R.id.community_setting_night_original, "field 'communitySettingNightOriginal'", CheckBox.class);
        communitySettingActivity.communitySettingCloseVideoVolume = (CheckBox) butterknife.c.a.c(view, R.id.community_setting_close_video_volume, "field 'communitySettingCloseVideoVolume'", CheckBox.class);
        communitySettingActivity.communitySettingOpenConcise = (CheckBox) butterknife.c.a.c(view, R.id.community_setting_concise, "field 'communitySettingOpenConcise'", CheckBox.class);
    }

    @CallSuper
    public void a() {
        CommunitySettingActivity communitySettingActivity = this.b;
        if (communitySettingActivity != null) {
            this.b = null;
            communitySettingActivity.communitySettingBack = null;
            communitySettingActivity.communitySettingLayout = null;
            communitySettingActivity.communitySettingPostJustTitle = null;
            communitySettingActivity.communitySettingRule = null;
            communitySettingActivity.communitySettingPost9Concise = null;
            communitySettingActivity.communitySettingPostDetails = null;
            communitySettingActivity.communitySettingDeleteLineFeed = null;
            communitySettingActivity.communitySettingNightOriginal = null;
            communitySettingActivity.communitySettingCloseVideoVolume = null;
            communitySettingActivity.communitySettingOpenConcise = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
