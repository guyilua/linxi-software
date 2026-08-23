package com.rtk.app.main.MainActivityPack;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.custom.MarkedImageView;
import com.zhy.view.flowlayout.FlowLayout;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeManageFragment_ViewBinding implements Unbinder {
    private HomeManageFragment b;

    @UiThread
    public HomeManageFragment_ViewBinding(HomeManageFragment homeManageFragment, View view) {
        this.b = homeManageFragment;
        homeManageFragment.home5ShareSelf = (TextView) butterknife.c.a.c(view, R.id.home5_share_self, "field 'home5ShareSelf'", TextView.class);
        homeManageFragment.home5Setting = (ImageView) butterknife.c.a.c(view, R.id.home5_setting, "field 'home5Setting'", ImageView.class);
        homeManageFragment.home5DayNight = (ImageView) butterknife.c.a.c(view, R.id.home5_day_night, "field 'home5DayNight'", ImageView.class);
        homeManageFragment.home5HeadImg = (RoundedImageView) butterknife.c.a.c(view, R.id.home5_head_img, "field 'home5HeadImg'", RoundedImageView.class);
        homeManageFragment.home5HeadTv = (TextView) butterknife.c.a.c(view, R.id.home5_head_tv, "field 'home5HeadTv'", TextView.class);
        homeManageFragment.home5HeadAuditState = (TextView) butterknife.c.a.c(view, R.id.home5_head_audit_state, "field 'home5HeadAuditState'", TextView.class);
        homeManageFragment.home5RtkUid = (TextView) butterknife.c.a.c(view, R.id.home5_rtk_uid, "field 'home5RtkUid'", TextView.class);
        homeManageFragment.home5UserAge = (TextView) butterknife.c.a.c(view, R.id.home5_user_age, "field 'home5UserAge'", TextView.class);
        homeManageFragment.home5UserGrade = (TextView) butterknife.c.a.c(view, R.id.home5_user_grade, "field 'home5UserGrade'", TextView.class);
        homeManageFragment.home5UserContributeNum = (TextView) butterknife.c.a.c(view, R.id.home5_user_contribute_num, "field 'home5UserContributeNum'", TextView.class);
        homeManageFragment.home5UserGoldNum = (TextView) butterknife.c.a.c(view, R.id.home5_user_gold_num, "field 'home5UserGoldNum'", TextView.class);
        homeManageFragment.home5PostList = (LinearLayout) butterknife.c.a.c(view, R.id.home5_post_list, "field 'home5PostList'", LinearLayout.class);
        homeManageFragment.home5PostReplyList = (LinearLayout) butterknife.c.a.c(view, R.id.home5_post_reply_list, "field 'home5PostReplyList'", LinearLayout.class);
        homeManageFragment.home5AttentionList = (LinearLayout) butterknife.c.a.c(view, R.id.home5_attention_list, "field 'home5AttentionList'", LinearLayout.class);
        homeManageFragment.home5FansList = (LinearLayout) butterknife.c.a.c(view, R.id.home5_fans_list, "field 'home5FansList'", LinearLayout.class);
        homeManageFragment.homeManageFragmentMedal = (FlowLayout) butterknife.c.a.c(view, R.id.home_manage_fragment_medal, "field 'homeManageFragmentMedal'", FlowLayout.class);
        homeManageFragment.home5HeadLayout = (RelativeLayout) butterknife.c.a.c(view, R.id.home5_head_layout, "field 'home5HeadLayout'", RelativeLayout.class);
        homeManageFragment.home5UpgradeIcon = (ImageView) butterknife.c.a.c(view, R.id.home5_upgrade_icon, "field 'home5UpgradeIcon'", ImageView.class);
        homeManageFragment.home5UpgradeIconNum = (TextView) butterknife.c.a.c(view, R.id.home5_upgrade_iconNum, "field 'home5UpgradeIconNum'", TextView.class);
        homeManageFragment.home5UpgradeGame = (LinearLayout) butterknife.c.a.c(view, R.id.home5_upgradeGame, "field 'home5UpgradeGame'", LinearLayout.class);
        homeManageFragment.home5ForUserTitle = (TextView) butterknife.c.a.c(view, R.id.home5_for_user_title, "field 'home5ForUserTitle'", TextView.class);
        homeManageFragment.home5DownloadManager = butterknife.c.a.b(view, R.id.home5_downloadManager, "field 'home5DownloadManager'");
        homeManageFragment.home5UninstallBtu = butterknife.c.a.b(view, R.id.home5_uninstall_btu, "field 'home5UninstallBtu'");
        homeManageFragment.home5InstallApk = butterknife.c.a.b(view, R.id.home5_InstallApk, "field 'home5InstallApk'");
        homeManageFragment.home5MyUpSrc = (LinearLayout) butterknife.c.a.c(view, R.id.home5_my_up_src, "field 'home5MyUpSrc'", LinearLayout.class);
        homeManageFragment.home5MyUpSrcImage = (MarkedImageView) butterknife.c.a.c(view, R.id.home5_my_up_src_image, "field 'home5MyUpSrcImage'", MarkedImageView.class);
        homeManageFragment.home5MyCollect = butterknife.c.a.b(view, R.id.home5_my_collect, "field 'home5MyCollect'");
        homeManageFragment.home5_browser_history = butterknife.c.a.b(view, R.id.home5_browser_history, "field 'home5_browser_history'");
        homeManageFragment.home5MyComment = butterknife.c.a.b(view, R.id.home5_my_comment, "field 'home5MyComment'");
        homeManageFragment.home5SetTheme = (TextView) butterknife.c.a.c(view, R.id.home5_setTheme, "field 'home5SetTheme'", TextView.class);
        homeManageFragment.home5ApplicationSetting = (TextView) butterknife.c.a.c(view, R.id.home5_application_setting, "field 'home5ApplicationSetting'", TextView.class);
        homeManageFragment.home5ShoppingMall = (TextView) butterknife.c.a.c(view, R.id.home5_shopping_mall, "field 'home5ShoppingMall'", TextView.class);
        homeManageFragment.home5ProtocolOfUsage = (TextView) butterknife.c.a.c(view, R.id.home5_protocol_of_usage, "field 'home5ProtocolOfUsage'", TextView.class);
        homeManageFragment.home5AboutAndHelp = (TextView) butterknife.c.a.c(view, R.id.home5_about_and_help, "field 'home5AboutAndHelp'", TextView.class);
        homeManageFragment.home5FeedBack = (TextView) butterknife.c.a.c(view, R.id.home5_feed_back, "field 'home5FeedBack'", TextView.class);
        homeManageFragment.home5FeedShaer = (TextView) butterknife.c.a.c(view, R.id.home5_feed_shaer, "field 'home5FeedShaer'", TextView.class);
        homeManageFragment.home5GoogleFrame = (TextView) butterknife.c.a.c(view, R.id.home5_google_frame, "field 'home5GoogleFrame'", TextView.class);
        homeManageFragment.home5HTML5Game = (TextView) butterknife.c.a.c(view, R.id.home5_HTML5_game, "field 'home5HTML5Game'", TextView.class);
        homeManageFragment.home5UpPlate = (TextView) butterknife.c.a.c(view, R.id.home5_up_plate, "field 'home5UpPlate'", TextView.class);
        homeManageFragment.home5MassageNum = (TextView) butterknife.c.a.c(view, R.id.home5_massage_num, "field 'home5MassageNum'", TextView.class);
        homeManageFragment.home5SwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.home5_swipeRefresh, "field 'home5SwipeRefresh'", SwipeRefreshLayout.class);
        homeManageFragment.home5MessageSamll = (ImageView) butterknife.c.a.c(view, R.id.home5_message_samll, "field 'home5MessageSamll'", ImageView.class);
        homeManageFragment.home5AccountSecurity = (TextView) butterknife.c.a.c(view, R.id.home5_account_security, "field 'home5AccountSecurity'", TextView.class);
        homeManageFragment.home5MedalWall = (LinearLayout) butterknife.c.a.c(view, R.id.home5_medal_wall, "field 'home5MedalWall'", LinearLayout.class);
        homeManageFragment.home5MedalWallTv = butterknife.c.a.b(view, R.id.home5_medal_wall_tv, "field 'home5MedalWallTv'");
        homeManageFragment.home5_r_money = butterknife.c.a.b(view, R.id.home5_my_r_money, "field 'home5_r_money'");
        homeManageFragment.home5_my_family = butterknife.c.a.b(view, R.id.home5_my_family, "field 'home5_my_family'");
        homeManageFragment.home5PersonalInfoAudit = (TextView) butterknife.c.a.c(view, R.id.home5_personal_info_audit, "field 'home5PersonalInfoAudit'", TextView.class);
        homeManageFragment.home5ClickHistory = (TextView) butterknife.c.a.c(view, R.id.home5_click_history, "field 'home5ClickHistory'", TextView.class);
    }

    @CallSuper
    public void a() {
        HomeManageFragment homeManageFragment = this.b;
        if (homeManageFragment != null) {
            this.b = null;
            homeManageFragment.home5ShareSelf = null;
            homeManageFragment.home5Setting = null;
            homeManageFragment.home5DayNight = null;
            homeManageFragment.home5HeadImg = null;
            homeManageFragment.home5HeadTv = null;
            homeManageFragment.home5HeadAuditState = null;
            homeManageFragment.home5RtkUid = null;
            homeManageFragment.home5UserAge = null;
            homeManageFragment.home5UserGrade = null;
            homeManageFragment.home5UserContributeNum = null;
            homeManageFragment.home5UserGoldNum = null;
            homeManageFragment.home5PostList = null;
            homeManageFragment.home5PostReplyList = null;
            homeManageFragment.home5AttentionList = null;
            homeManageFragment.home5FansList = null;
            homeManageFragment.homeManageFragmentMedal = null;
            homeManageFragment.home5HeadLayout = null;
            homeManageFragment.home5UpgradeIcon = null;
            homeManageFragment.home5UpgradeIconNum = null;
            homeManageFragment.home5UpgradeGame = null;
            homeManageFragment.home5ForUserTitle = null;
            homeManageFragment.home5DownloadManager = null;
            homeManageFragment.home5UninstallBtu = null;
            homeManageFragment.home5InstallApk = null;
            homeManageFragment.home5MyUpSrc = null;
            homeManageFragment.home5MyUpSrcImage = null;
            homeManageFragment.home5MyCollect = null;
            homeManageFragment.home5_browser_history = null;
            homeManageFragment.home5MyComment = null;
            homeManageFragment.home5SetTheme = null;
            homeManageFragment.home5ApplicationSetting = null;
            homeManageFragment.home5ShoppingMall = null;
            homeManageFragment.home5ProtocolOfUsage = null;
            homeManageFragment.home5AboutAndHelp = null;
            homeManageFragment.home5FeedBack = null;
            homeManageFragment.home5FeedShaer = null;
            homeManageFragment.home5GoogleFrame = null;
            homeManageFragment.home5HTML5Game = null;
            homeManageFragment.home5UpPlate = null;
            homeManageFragment.home5MassageNum = null;
            homeManageFragment.home5SwipeRefresh = null;
            homeManageFragment.home5MessageSamll = null;
            homeManageFragment.home5AccountSecurity = null;
            homeManageFragment.home5MedalWall = null;
            homeManageFragment.home5MedalWallTv = null;
            homeManageFragment.home5_r_money = null;
            homeManageFragment.home5_my_family = null;
            homeManageFragment.home5PersonalInfoAudit = null;
            homeManageFragment.home5ClickHistory = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
