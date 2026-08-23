package com.rtk.app.main.comment;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.zhy.view.flowlayout.FlowLayout;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CommentUpImageHolder_ViewBinding implements Unbinder {
    private CommentUpImageHolder b;

    @UiThread
    public CommentUpImageHolder_ViewBinding(CommentUpImageHolder commentUpImageHolder, View view) {
        this.b = commentUpImageHolder;
        commentUpImageHolder.upApkUpImageAddPhoto = (ImageView) butterknife.c.a.c(view, R.id.up_apk_up_image_add_photo, "field 'upApkUpImageAddPhoto'", ImageView.class);
        commentUpImageHolder.upApkUpImagePhotoLv = (FlowLayout) butterknife.c.a.c(view, R.id.up_apk_up_image_photo_lv, "field 'upApkUpImagePhotoLv'", FlowLayout.class);
    }

    @CallSuper
    public void a() {
        CommentUpImageHolder commentUpImageHolder = this.b;
        if (commentUpImageHolder != null) {
            this.b = null;
            commentUpImageHolder.upApkUpImageAddPhoto = null;
            commentUpImageHolder.upApkUpImagePhotoLv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
