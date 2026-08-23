package com.rtk.app.main.UpModule.UpControlPack.UpZip;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.c.a;
import com.rtk.app.R;
import com.rtk.app.custom.CustomMultiLineEditTextView;
import com.rtk.app.custom.MarkedImageView;
import com.rtk.app.custom.NoOOMEditText;
import com.zhy.view.flowlayout.FlowLayout;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpZipActivity_ViewBinding implements Unbinder {
    private UpZipActivity b;

    @UiThread
    public UpZipActivity_ViewBinding(UpZipActivity upZipActivity, View view) {
        this.b = upZipActivity;
        upZipActivity.upZipBack = (TextView) a.c(view, R.id.up_zip_back, "field 'upZipBack'", TextView.class);
        upZipActivity.upZipMyUpLoading = (MarkedImageView) a.c(view, R.id.up_zip_my_up_loading, "field 'upZipMyUpLoading'", MarkedImageView.class);
        upZipActivity.upZipExplainBtu = (ImageView) a.c(view, R.id.up_zip_explain_btu, "field 'upZipExplainBtu'", ImageView.class);
        upZipActivity.upZipLayout = (RelativeLayout) a.c(view, R.id.up_zip_layout, "field 'upZipLayout'", RelativeLayout.class);
        upZipActivity.upZipNotice = (TextView) a.c(view, R.id.up_zip_notice, "field 'upZipNotice'", TextView.class);
        upZipActivity.upZipAddEditName = (NoOOMEditText) a.c(view, R.id.up_zip_add_editName, "field 'upZipAddEditName'", NoOOMEditText.class);
        upZipActivity.upZipAddSrcFeature = (CustomMultiLineEditTextView) a.c(view, R.id.up_zip_add_src_feature, "field 'upZipAddSrcFeature'", CustomMultiLineEditTextView.class);
        upZipActivity.upZipAddSrcDescription = (CustomMultiLineEditTextView) a.c(view, R.id.up_zip_add_src_description, "field 'upZipAddSrcDescription'", CustomMultiLineEditTextView.class);
        upZipActivity.upApkUpImageAddPhoto = (ImageView) a.c(view, R.id.up_apk_up_image_add_photo, "field 'upApkUpImageAddPhoto'", ImageView.class);
        upZipActivity.upApkUpImagePhotoLv = (FlowLayout) a.c(view, R.id.up_apk_up_image_photo_lv, "field 'upApkUpImagePhotoLv'", FlowLayout.class);
        upZipActivity.upZipShowStatus = (TextView) a.c(view, R.id.up_zip_show_status, "field 'upZipShowStatus'", TextView.class);
        upZipActivity.upZipShowStatusLv = (LinearLayout) a.c(view, R.id.up_zip_show_status_lv, "field 'upZipShowStatusLv'", LinearLayout.class);
        upZipActivity.upZipProtocolCheckBox = (CheckBox) a.c(view, R.id.up_zip_protocol_checkBox, "field 'upZipProtocolCheckBox'", CheckBox.class);
        upZipActivity.upZipProtocol = (TextView) a.c(view, R.id.up_zip_protocol, "field 'upZipProtocol'", TextView.class);
        upZipActivity.upZipPublishPostCheckBox = (CheckBox) a.c(view, R.id.up_zip_publishPost_checkBox, "field 'upZipPublishPostCheckBox'", CheckBox.class);
        upZipActivity.upZipAddUpLoad = (TextView) a.c(view, R.id.up_zip_add_upLoad, "field 'upZipAddUpLoad'", TextView.class);
        upZipActivity.upZipAtBackground = (TextView) a.c(view, R.id.up_zip_at_background, "field 'upZipAtBackground'", TextView.class);
        upZipActivity.upZipHolderView = a.b(view, R.id.up_zip_holder_view, "field 'upZipHolderView'");
        upZipActivity.upZipUpImageIncludeView = a.b(view, R.id.up_zip_up_image_include_view, "field 'upZipUpImageIncludeView'");
        upZipActivity.upZipSrcTypeView = a.b(view, R.id.up_zip_src_type_view, "field 'upZipSrcTypeView'");
    }

    @CallSuper
    public void a() {
        UpZipActivity upZipActivity = this.b;
        if (upZipActivity != null) {
            this.b = null;
            upZipActivity.upZipBack = null;
            upZipActivity.upZipMyUpLoading = null;
            upZipActivity.upZipExplainBtu = null;
            upZipActivity.upZipLayout = null;
            upZipActivity.upZipNotice = null;
            upZipActivity.upZipAddEditName = null;
            upZipActivity.upZipAddSrcFeature = null;
            upZipActivity.upZipAddSrcDescription = null;
            upZipActivity.upApkUpImageAddPhoto = null;
            upZipActivity.upApkUpImagePhotoLv = null;
            upZipActivity.upZipShowStatus = null;
            upZipActivity.upZipShowStatusLv = null;
            upZipActivity.upZipProtocolCheckBox = null;
            upZipActivity.upZipProtocol = null;
            upZipActivity.upZipPublishPostCheckBox = null;
            upZipActivity.upZipAddUpLoad = null;
            upZipActivity.upZipAtBackground = null;
            upZipActivity.upZipHolderView = null;
            upZipActivity.upZipUpImageIncludeView = null;
            upZipActivity.upZipSrcTypeView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
