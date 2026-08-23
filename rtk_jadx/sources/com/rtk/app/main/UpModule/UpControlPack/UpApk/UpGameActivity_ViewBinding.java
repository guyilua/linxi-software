package com.rtk.app.main.UpModule.UpControlPack.UpApk;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.CustomMultiLineEditTextView;
import com.rtk.app.custom.MarkedImageView;
import com.rtk.app.custom.NoOOMEditText;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpGameActivity_ViewBinding implements Unbinder {
    private UpGameActivity b;

    @UiThread
    public UpGameActivity_ViewBinding(UpGameActivity upGameActivity, View view) {
        this.b = upGameActivity;
        upGameActivity.upGameBack = (TextView) butterknife.c.a.c(view, R.id.up_game_back, "field 'upGameBack'", TextView.class);
        upGameActivity.upGameExplainBtu = (ImageView) butterknife.c.a.c(view, R.id.up_game_explain_btu, "field 'upGameExplainBtu'", ImageView.class);
        upGameActivity.upGameLayout = (RelativeLayout) butterknife.c.a.c(view, R.id.up_game_layout, "field 'upGameLayout'", RelativeLayout.class);
        upGameActivity.upGameNotice = (TextView) butterknife.c.a.c(view, R.id.up_game_notice, "field 'upGameNotice'", TextView.class);
        upGameActivity.upHeadHolderIntro = (TextView) butterknife.c.a.c(view, R.id.up_head_holder_intro, "field 'upHeadHolderIntro'", TextView.class);
        upGameActivity.upHeadHolderGameName = (TextView) butterknife.c.a.c(view, R.id.up_head_holder_gameName, "field 'upHeadHolderGameName'", TextView.class);
        upGameActivity.upHeadHolderProgress = (ProgressBar) butterknife.c.a.c(view, R.id.up_head_holder_progress, "field 'upHeadHolderProgress'", ProgressBar.class);
        upGameActivity.upHeadHolderDelete = (ImageView) butterknife.c.a.c(view, R.id.up_head_holder_delete, "field 'upHeadHolderDelete'", ImageView.class);
        upGameActivity.upHeadHolderProgressPercentage = (TextView) butterknife.c.a.c(view, R.id.up_head_holder_progress_percentage, "field 'upHeadHolderProgressPercentage'", TextView.class);
        upGameActivity.upHeadHolderSpeed = (TextView) butterknife.c.a.c(view, R.id.up_head_holder_speed, "field 'upHeadHolderSpeed'", TextView.class);
        upGameActivity.upHeadHolderApkSize = (TextView) butterknife.c.a.c(view, R.id.up_head_holder_apkSize, "field 'upHeadHolderApkSize'", TextView.class);
        upGameActivity.upHeadHolderStop = (CheckBox) butterknife.c.a.c(view, R.id.up_head_holder_stop, "field 'upHeadHolderStop'", CheckBox.class);
        upGameActivity.upHeadHolderProgressLv = (LinearLayout) butterknife.c.a.c(view, R.id.up_head_holder_progress_lv, "field 'upHeadHolderProgressLv'", LinearLayout.class);
        upGameActivity.upHeadHolderLv = (RelativeLayout) butterknife.c.a.c(view, R.id.up_head_holder_lv, "field 'upHeadHolderLv'", RelativeLayout.class);
        upGameActivity.upGameAddGameEditName = (NoOOMEditText) butterknife.c.a.c(view, R.id.up_game_add_editName, "field 'upGameAddGameEditName'", NoOOMEditText.class);
        upGameActivity.upGameAddSrcFeature = (CustomMultiLineEditTextView) butterknife.c.a.c(view, R.id.up_game_add_src_feature, "field 'upGameAddSrcFeature'", CustomMultiLineEditTextView.class);
        upGameActivity.upGameAddSrcDescription = (CustomMultiLineEditTextView) butterknife.c.a.c(view, R.id.up_game_add_src_description, "field 'upGameAddSrcDescription'", CustomMultiLineEditTextView.class);
        upGameActivity.upGameProtocolCheckBox = (CheckBox) butterknife.c.a.c(view, R.id.up_game_protocol_checkBox, "field 'upGameProtocolCheckBox'", CheckBox.class);
        upGameActivity.upGameProtocol = (TextView) butterknife.c.a.c(view, R.id.up_game_protocol, "field 'upGameProtocol'", TextView.class);
        upGameActivity.upGamePublishPostCheckBox = (CheckBox) butterknife.c.a.c(view, R.id.up_game_publishPost_checkBox, "field 'upGamePublishPostCheckBox'", CheckBox.class);
        upGameActivity.upGameAddUpLoad = (TextView) butterknife.c.a.c(view, R.id.up_game_add_upLoad, "field 'upGameAddUpLoad'", TextView.class);
        upGameActivity.upGameAtBackground = (TextView) butterknife.c.a.c(view, R.id.up_game_at_background, "field 'upGameAtBackground'", TextView.class);
        upGameActivity.upGameShowStatusLv = (LinearLayout) butterknife.c.a.c(view, R.id.up_game_show_status_lv, "field 'upGameShowStatusLv'", LinearLayout.class);
        upGameActivity.upGameShowStatus = (TextView) butterknife.c.a.c(view, R.id.up_game_show_status, "field 'upGameShowStatus'", TextView.class);
        upGameActivity.upHeadHolderView = butterknife.c.a.b(view, R.id.up_head_holder_view, "field 'upHeadHolderView'");
        upGameActivity.upGameUpImageIncludeView = butterknife.c.a.b(view, R.id.up_game_up_image_include_view, "field 'upGameUpImageIncludeView'");
        upGameActivity.upGameMyUpLoading = (MarkedImageView) butterknife.c.a.c(view, R.id.up_game_my_up_loading, "field 'upGameMyUpLoading'", MarkedImageView.class);
        upGameActivity.upGameSrcTypeView = butterknife.c.a.b(view, R.id.up_game_src_type_view, "field 'upGameSrcTypeView'");
        upGameActivity.setDownloadCoinsLayout = butterknife.c.a.b(view, R.id.set_download_coins_layout, "field 'setDownloadCoinsLayout'");
        upGameActivity.setDownloadCoinsEt = (NoOOMEditText) butterknife.c.a.c(view, R.id.set_download_coins_et, "field 'setDownloadCoinsEt'", NoOOMEditText.class);
    }

    @CallSuper
    public void a() {
        UpGameActivity upGameActivity = this.b;
        if (upGameActivity != null) {
            this.b = null;
            upGameActivity.upGameBack = null;
            upGameActivity.upGameExplainBtu = null;
            upGameActivity.upGameLayout = null;
            upGameActivity.upGameNotice = null;
            upGameActivity.upHeadHolderIntro = null;
            upGameActivity.upHeadHolderGameName = null;
            upGameActivity.upHeadHolderProgress = null;
            upGameActivity.upHeadHolderDelete = null;
            upGameActivity.upHeadHolderProgressPercentage = null;
            upGameActivity.upHeadHolderSpeed = null;
            upGameActivity.upHeadHolderApkSize = null;
            upGameActivity.upHeadHolderStop = null;
            upGameActivity.upHeadHolderProgressLv = null;
            upGameActivity.upHeadHolderLv = null;
            upGameActivity.upGameAddGameEditName = null;
            upGameActivity.upGameAddSrcFeature = null;
            upGameActivity.upGameAddSrcDescription = null;
            upGameActivity.upGameProtocolCheckBox = null;
            upGameActivity.upGameProtocol = null;
            upGameActivity.upGamePublishPostCheckBox = null;
            upGameActivity.upGameAddUpLoad = null;
            upGameActivity.upGameAtBackground = null;
            upGameActivity.upGameShowStatusLv = null;
            upGameActivity.upGameShowStatus = null;
            upGameActivity.upHeadHolderView = null;
            upGameActivity.upGameUpImageIncludeView = null;
            upGameActivity.upGameMyUpLoading = null;
            upGameActivity.upGameSrcTypeView = null;
            upGameActivity.setDownloadCoinsLayout = null;
            upGameActivity.setDownloadCoinsEt = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
