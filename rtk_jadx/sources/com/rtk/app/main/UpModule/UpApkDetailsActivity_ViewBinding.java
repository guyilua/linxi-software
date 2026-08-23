package com.rtk.app.main.UpModule;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.custom.MarkedImageView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpApkDetailsActivity_ViewBinding implements Unbinder {
    private UpApkDetailsActivity b;

    @UiThread
    public UpApkDetailsActivity_ViewBinding(UpApkDetailsActivity upApkDetailsActivity, View view) {
        this.b = upApkDetailsActivity;
        upApkDetailsActivity.upApkDetailsTopBack = (TextView) butterknife.c.a.c(view, R.id.up_apk_details_top_back, "field 'upApkDetailsTopBack'", TextView.class);
        upApkDetailsActivity.upApkDetailsTopFeedback = (ImageView) butterknife.c.a.c(view, R.id.up_apk_details_top_feedback, "field 'upApkDetailsTopFeedback'", ImageView.class);
        upApkDetailsActivity.upApkDetailsTopHome = (ImageView) butterknife.c.a.c(view, R.id.up_apk_details_top_home, "field 'upApkDetailsTopHome'", ImageView.class);
        upApkDetailsActivity.upApkDetailsTopDownload = (MarkedImageView) butterknife.c.a.c(view, R.id.up_apk_details_top_download, "field 'upApkDetailsTopDownload'", MarkedImageView.class);
        upApkDetailsActivity.upApkDetailsTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_apk_details_top_layout, "field 'upApkDetailsTopLayout'", LinearLayout.class);
        upApkDetailsActivity.upApkDetailsAppIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.up_apk_details_appIcon, "field 'upApkDetailsAppIcon'", RoundedImageView.class);
        upApkDetailsActivity.upApkDetailsAppName = (TextView) butterknife.c.a.c(view, R.id.up_apk_details_appName, "field 'upApkDetailsAppName'", TextView.class);
        upApkDetailsActivity.upApkDetailsAppSizeAndPlayerNum = (TextView) butterknife.c.a.c(view, R.id.up_apk_details_appSize_and_playerNum, "field 'upApkDetailsAppSizeAndPlayerNum'", TextView.class);
        upApkDetailsActivity.upApkDetailsAppVersion = (TextView) butterknife.c.a.c(view, R.id.up_apk_details_appVersion, "field 'upApkDetailsAppVersion'", TextView.class);
        upApkDetailsActivity.upApkDetailsHeadLv = (LinearLayout) butterknife.c.a.c(view, R.id.up_apk_details_headLv, "field 'upApkDetailsHeadLv'", LinearLayout.class);
        upApkDetailsActivity.upApkDetailsUserIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.up_apk_details_userIcon, "field 'upApkDetailsUserIcon'", RoundedImageView.class);
        upApkDetailsActivity.upApkDetailsUserName = (TextView) butterknife.c.a.c(view, R.id.up_apk_details_userName, "field 'upApkDetailsUserName'", TextView.class);
        upApkDetailsActivity.upApkDetailsRemark = (TextView) butterknife.c.a.c(view, R.id.up_apk_details_remark, "field 'upApkDetailsRemark'", TextView.class);
        upApkDetailsActivity.upApkDetailsUserLv = (LinearLayout) butterknife.c.a.c(view, R.id.up_apk_details_userLv, "field 'upApkDetailsUserLv'", LinearLayout.class);
        upApkDetailsActivity.upApkDetailsTab = (TabLayout) butterknife.c.a.c(view, R.id.up_apk_details_tab, "field 'upApkDetailsTab'", TabLayout.class);
        upApkDetailsActivity.upApkDetailsViewPager = (ViewPager) butterknife.c.a.c(view, R.id.up_apk_details_viewPager, "field 'upApkDetailsViewPager'", ViewPager.class);
        upApkDetailsActivity.upApkDetailsAppCollect = (CheckBox) butterknife.c.a.c(view, R.id.up_apk_details_app_collect, "field 'upApkDetailsAppCollect'", CheckBox.class);
        upApkDetailsActivity.upApkDetailsAppOpenBtu = (TextView) butterknife.c.a.c(view, R.id.up_apk_details_appOpenBtu, "field 'upApkDetailsAppOpenBtu'", TextView.class);
        upApkDetailsActivity.upApkDetailsAppDownLoadProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.up_apk_details_appDownLoadProgressBar, "field 'upApkDetailsAppDownLoadProgressBar'", ProgressBar.class);
        upApkDetailsActivity.upApkDetailsAppDownLoadBtu = (TextView) butterknife.c.a.c(view, R.id.up_apk_details_appDownLoadBtu, "field 'upApkDetailsAppDownLoadBtu'", TextView.class);
        upApkDetailsActivity.upApkDetailsAppReward = (TextView) butterknife.c.a.c(view, R.id.up_apk_details_app_reward, "field 'upApkDetailsAppReward'", TextView.class);
        upApkDetailsActivity.upApkDetailsBar = (AppBarLayout) butterknife.c.a.c(view, R.id.up_apk_details_bar, "field 'upApkDetailsBar'", AppBarLayout.class);
        upApkDetailsActivity.upApkDetailGoToCheckPage = (TextView) butterknife.c.a.c(view, R.id.up_apk_detail_goToCheckPage, "field 'upApkDetailGoToCheckPage'", TextView.class);
        upApkDetailsActivity.upApkDetailGoToCheckAgainPage = (TextView) butterknife.c.a.c(view, R.id.up_apk_detail_goToCheckAgainPage, "field 'upApkDetailGoToCheckAgainPage'", TextView.class);
        upApkDetailsActivity.upApkDetailsCheckStatusTV = (CustomTextView) butterknife.c.a.c(view, R.id.up_apk_details_checkStatusTV, "field 'upApkDetailsCheckStatusTV'", CustomTextView.class);
        upApkDetailsActivity.upApkFamilyCheckStatusTV = (CustomTextView) butterknife.c.a.c(view, R.id.up_apk_family_audit_check_state, "field 'upApkFamilyCheckStatusTV'", CustomTextView.class);
        upApkDetailsActivity.upApkListShow = (CustomTextView) butterknife.c.a.c(view, R.id.up_apk_list_show, "field 'upApkListShow'", CustomTextView.class);
        upApkDetailsActivity.upApkAuditCheckState = (CustomTextView) butterknife.c.a.c(view, R.id.up_apk_audit_check_state, "field 'upApkAuditCheckState'", CustomTextView.class);
        upApkDetailsActivity.upApkAuditListShow = (CustomTextView) butterknife.c.a.c(view, R.id.up_apk_audit_list_show, "field 'upApkAuditListShow'", CustomTextView.class);
        upApkDetailsActivity.upApkDetailsShare = (TextView) butterknife.c.a.c(view, R.id.up_apk_details_share, "field 'upApkDetailsShare'", TextView.class);
        upApkDetailsActivity.upApkDetailsCopyUrl = (TextView) butterknife.c.a.c(view, R.id.up_apk_details_copy_Url, "field 'upApkDetailsCopyUrl'", TextView.class);
        upApkDetailsActivity.upApkDetailsSuggest = (CustomTextView) butterknife.c.a.c(view, R.id.up_apk_details_suggest, "field 'upApkDetailsSuggest'", CustomTextView.class);
        upApkDetailsActivity.upApkDetailsCheckStatusLv = (LinearLayout) butterknife.c.a.c(view, R.id.up_apk_details_checkStatus_lv, "field 'upApkDetailsCheckStatusLv'", LinearLayout.class);
        upApkDetailsActivity.upApkDetailsAttention = (TextView) butterknife.c.a.c(view, R.id.up_apk_details_attention, "field 'upApkDetailsAttention'", TextView.class);
        upApkDetailsActivity.upApkDetailFamilyAudit = (TextView) butterknife.c.a.c(view, R.id.up_apk_detail_family_audit, "field 'upApkDetailFamilyAudit'", TextView.class);
        upApkDetailsActivity.upApkDetailIsFamily = (TextView) butterknife.c.a.c(view, R.id.up_apk_details_is_family, "field 'upApkDetailIsFamily'", TextView.class);
    }

    @CallSuper
    public void a() {
        UpApkDetailsActivity upApkDetailsActivity = this.b;
        if (upApkDetailsActivity != null) {
            this.b = null;
            upApkDetailsActivity.upApkDetailsTopBack = null;
            upApkDetailsActivity.upApkDetailsTopFeedback = null;
            upApkDetailsActivity.upApkDetailsTopHome = null;
            upApkDetailsActivity.upApkDetailsTopDownload = null;
            upApkDetailsActivity.upApkDetailsTopLayout = null;
            upApkDetailsActivity.upApkDetailsAppIcon = null;
            upApkDetailsActivity.upApkDetailsAppName = null;
            upApkDetailsActivity.upApkDetailsAppSizeAndPlayerNum = null;
            upApkDetailsActivity.upApkDetailsAppVersion = null;
            upApkDetailsActivity.upApkDetailsHeadLv = null;
            upApkDetailsActivity.upApkDetailsUserIcon = null;
            upApkDetailsActivity.upApkDetailsUserName = null;
            upApkDetailsActivity.upApkDetailsRemark = null;
            upApkDetailsActivity.upApkDetailsUserLv = null;
            upApkDetailsActivity.upApkDetailsTab = null;
            upApkDetailsActivity.upApkDetailsViewPager = null;
            upApkDetailsActivity.upApkDetailsAppCollect = null;
            upApkDetailsActivity.upApkDetailsAppOpenBtu = null;
            upApkDetailsActivity.upApkDetailsAppDownLoadProgressBar = null;
            upApkDetailsActivity.upApkDetailsAppDownLoadBtu = null;
            upApkDetailsActivity.upApkDetailsAppReward = null;
            upApkDetailsActivity.upApkDetailsBar = null;
            upApkDetailsActivity.upApkDetailGoToCheckPage = null;
            upApkDetailsActivity.upApkDetailGoToCheckAgainPage = null;
            upApkDetailsActivity.upApkDetailsCheckStatusTV = null;
            upApkDetailsActivity.upApkFamilyCheckStatusTV = null;
            upApkDetailsActivity.upApkListShow = null;
            upApkDetailsActivity.upApkAuditCheckState = null;
            upApkDetailsActivity.upApkAuditListShow = null;
            upApkDetailsActivity.upApkDetailsShare = null;
            upApkDetailsActivity.upApkDetailsCopyUrl = null;
            upApkDetailsActivity.upApkDetailsSuggest = null;
            upApkDetailsActivity.upApkDetailsCheckStatusLv = null;
            upApkDetailsActivity.upApkDetailsAttention = null;
            upApkDetailsActivity.upApkDetailFamilyAudit = null;
            upApkDetailsActivity.upApkDetailIsFamily = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
