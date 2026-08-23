package com.rtk.app.main.UpModule;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.CustomTextView;
import com.zhy.view.flowlayout.FlowLayout;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpEditApkInformationActivity_ViewBinding implements Unbinder {
    private UpEditApkInformationActivity b;

    @UiThread
    public UpEditApkInformationActivity_ViewBinding(UpEditApkInformationActivity upEditApkInformationActivity, View view) {
        this.b = upEditApkInformationActivity;
        upEditApkInformationActivity.upEditApkInformationTopBack = (TextView) butterknife.c.a.c(view, R.id.up_edit_apk_information_top_back, "field 'upEditApkInformationTopBack'", TextView.class);
        upEditApkInformationActivity.upEditApkInformationTopSubmit = (TextView) butterknife.c.a.c(view, R.id.up_edit_apk_information_top_submit, "field 'upEditApkInformationTopSubmit'", TextView.class);
        upEditApkInformationActivity.upEditApkInformationTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_edit_apk_information_top_layout, "field 'upEditApkInformationTopLayout'", LinearLayout.class);
        upEditApkInformationActivity.upEditApkInformationSuggestion = (CustomTextView) butterknife.c.a.c(view, R.id.up_edit_apk_information_suggestion, "field 'upEditApkInformationSuggestion'", CustomTextView.class);
        upEditApkInformationActivity.upEditApkHolderView = butterknife.c.a.b(view, R.id.up_edit_apk_holder_view, "field 'upEditApkHolderView'");
        upEditApkInformationActivity.upEditApkInformationGameName = (EditText) butterknife.c.a.c(view, R.id.up_edit_apk_information_gameName, "field 'upEditApkInformationGameName'", EditText.class);
        upEditApkInformationActivity.upEditApkInformationAddApkTypeGame = (RadioButton) butterknife.c.a.c(view, R.id.up_edit_apk_information_add_apkType_game, "field 'upEditApkInformationAddApkTypeGame'", RadioButton.class);
        upEditApkInformationActivity.upEditApkInformationAddApkTypeSoft = (RadioButton) butterknife.c.a.c(view, R.id.up_edit_apk_information_add_apkTypeSoft, "field 'upEditApkInformationAddApkTypeSoft'", RadioButton.class);
        upEditApkInformationActivity.upEditApkInformationAddApkType = (RadioGroup) butterknife.c.a.c(view, R.id.up_edit_apk_information_add_apkType, "field 'upEditApkInformationAddApkType'", RadioGroup.class);
        upEditApkInformationActivity.upEditApkInformationAddApkTags = (Spinner) butterknife.c.a.c(view, R.id.up_edit_apk_information_add_apkTags, "field 'upEditApkInformationAddApkTags'", Spinner.class);
        upEditApkInformationActivity.upEditApkInformationLanguage = (RadioGroup) butterknife.c.a.c(view, R.id.up_edit_apk_information_language, "field 'upEditApkInformationLanguage'", RadioGroup.class);
        upEditApkInformationActivity.upEditApkInformationAddSrcFeature = (EditText) butterknife.c.a.c(view, R.id.up_edit_apk_information_add_src_feature, "field 'upEditApkInformationAddSrcFeature'", EditText.class);
        upEditApkInformationActivity.upEditApkInformationAddSrcDescription = (EditText) butterknife.c.a.c(view, R.id.up_edit_apk_information_add_src_description, "field 'upEditApkInformationAddSrcDescription'", EditText.class);
        upEditApkInformationActivity.upEditApkInformationAddPhoto = (ImageView) butterknife.c.a.c(view, R.id.up_edit_apk_information_add_photo, "field 'upEditApkInformationAddPhoto'", ImageView.class);
        upEditApkInformationActivity.upEditApkInformationAddPhotoLv = (FlowLayout) butterknife.c.a.c(view, R.id.up_edit_apk_information_add_photo_lv, "field 'upEditApkInformationAddPhotoLv'", FlowLayout.class);
        upEditApkInformationActivity.upEditApkInformationShowStatus = (TextView) butterknife.c.a.c(view, R.id.up_edit_apk_information_show_status, "field 'upEditApkInformationShowStatus'", TextView.class);
        upEditApkInformationActivity.upEditSetDownloadCoinsLv = (RelativeLayout) butterknife.c.a.c(view, R.id.up_edit_set_download_coins_layout, "field 'upEditSetDownloadCoinsLv'", RelativeLayout.class);
        upEditApkInformationActivity.upEditApkInfoShowStatusLv = (LinearLayout) butterknife.c.a.c(view, R.id.up_edit_apk_information_show_status_lv, "field 'upEditApkInfoShowStatusLv'", LinearLayout.class);
        upEditApkInformationActivity.upEditSetDownloadCoinsEt = (EditText) butterknife.c.a.c(view, R.id.up_edit_set_download_coins_et, "field 'upEditSetDownloadCoinsEt'", EditText.class);
    }

    @CallSuper
    public void a() {
        UpEditApkInformationActivity upEditApkInformationActivity = this.b;
        if (upEditApkInformationActivity != null) {
            this.b = null;
            upEditApkInformationActivity.upEditApkInformationTopBack = null;
            upEditApkInformationActivity.upEditApkInformationTopSubmit = null;
            upEditApkInformationActivity.upEditApkInformationTopLayout = null;
            upEditApkInformationActivity.upEditApkInformationSuggestion = null;
            upEditApkInformationActivity.upEditApkHolderView = null;
            upEditApkInformationActivity.upEditApkInformationGameName = null;
            upEditApkInformationActivity.upEditApkInformationAddApkTypeGame = null;
            upEditApkInformationActivity.upEditApkInformationAddApkTypeSoft = null;
            upEditApkInformationActivity.upEditApkInformationAddApkType = null;
            upEditApkInformationActivity.upEditApkInformationAddApkTags = null;
            upEditApkInformationActivity.upEditApkInformationLanguage = null;
            upEditApkInformationActivity.upEditApkInformationAddSrcFeature = null;
            upEditApkInformationActivity.upEditApkInformationAddSrcDescription = null;
            upEditApkInformationActivity.upEditApkInformationAddPhoto = null;
            upEditApkInformationActivity.upEditApkInformationAddPhotoLv = null;
            upEditApkInformationActivity.upEditApkInformationShowStatus = null;
            upEditApkInformationActivity.upEditSetDownloadCoinsLv = null;
            upEditApkInformationActivity.upEditApkInfoShowStatusLv = null;
            upEditApkInformationActivity.upEditSetDownloadCoinsEt = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
