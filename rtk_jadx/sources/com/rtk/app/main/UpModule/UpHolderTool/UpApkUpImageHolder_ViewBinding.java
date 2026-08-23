package com.rtk.app.main.UpModule.UpHolderTool;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.zhy.view.flowlayout.FlowLayout;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpApkUpImageHolder_ViewBinding implements Unbinder {
    private UpApkUpImageHolder b;

    @UiThread
    public UpApkUpImageHolder_ViewBinding(UpApkUpImageHolder upApkUpImageHolder, View view) {
        this.b = upApkUpImageHolder;
        upApkUpImageHolder.upApkUpImageAddPhoto = (ImageView) butterknife.c.a.c(view, R.id.up_apk_up_image_add_photo, "field 'upApkUpImageAddPhoto'", ImageView.class);
        upApkUpImageHolder.upApkUpImagePhotoLv = (FlowLayout) butterknife.c.a.c(view, R.id.up_apk_up_image_photo_lv, "field 'upApkUpImagePhotoLv'", FlowLayout.class);
    }

    @CallSuper
    public void a() {
        UpApkUpImageHolder upApkUpImageHolder = this.b;
        if (upApkUpImageHolder != null) {
            this.b = null;
            upApkUpImageHolder.upApkUpImageAddPhoto = null;
            upApkUpImageHolder.upApkUpImagePhotoLv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
