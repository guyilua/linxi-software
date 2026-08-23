package com.rtk.app.main;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import cn.bluemobi.dylan.photoview.library.PhotoView;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PhotoActivity_ViewBinding implements Unbinder {
    private PhotoActivity b;

    @UiThread
    public PhotoActivity_ViewBinding(PhotoActivity photoActivity, View view) {
        this.b = photoActivity;
        photoActivity.photoPhotoView = (PhotoView) butterknife.c.a.c(view, R.id.photo_photoView, "field 'photoPhotoView'", PhotoView.class);
    }

    @CallSuper
    public void a() {
        PhotoActivity photoActivity = this.b;
        if (photoActivity != null) {
            this.b = null;
            photoActivity.photoPhotoView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
