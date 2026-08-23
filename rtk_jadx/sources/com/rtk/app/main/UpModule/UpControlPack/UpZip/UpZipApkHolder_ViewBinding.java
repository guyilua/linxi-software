package com.rtk.app.main.UpModule.UpControlPack.UpZip;

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
import butterknife.c.a;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpZipApkHolder_ViewBinding implements Unbinder {
    private UpZipApkHolder b;

    @UiThread
    public UpZipApkHolder_ViewBinding(UpZipApkHolder upZipApkHolder, View view) {
        this.b = upZipApkHolder;
        upZipApkHolder.upZipApkHolderIcon = (ImageView) a.c(view, R.id.up_zip_apk_holder_icon, "field 'upZipApkHolderIcon'", ImageView.class);
        upZipApkHolder.upZipApkHolderIntro = (TextView) a.c(view, R.id.up_zip_apk_holder_intro, "field 'upZipApkHolderIntro'", TextView.class);
        upZipApkHolder.upZipApkHolderGameName = (TextView) a.c(view, R.id.up_zip_apk_holder_gameName, "field 'upZipApkHolderGameName'", TextView.class);
        upZipApkHolder.upZipApkHolderProgress = (ProgressBar) a.c(view, R.id.up_zip_apk_holder_progress, "field 'upZipApkHolderProgress'", ProgressBar.class);
        upZipApkHolder.upZipApkHolderDelete = (ImageView) a.c(view, R.id.up_zip_apk_holder_delete, "field 'upZipApkHolderDelete'", ImageView.class);
        upZipApkHolder.upZipApkHolderProgressPercentage = (TextView) a.c(view, R.id.up_zip_apk_holder_progress_percentage, "field 'upZipApkHolderProgressPercentage'", TextView.class);
        upZipApkHolder.upZipApkHolderSpeed = (TextView) a.c(view, R.id.up_zip_apk_holder_speed, "field 'upZipApkHolderSpeed'", TextView.class);
        upZipApkHolder.upZipApkHolderApkSize = (TextView) a.c(view, R.id.up_zip_apk_holder_apkSize, "field 'upZipApkHolderApkSize'", TextView.class);
        upZipApkHolder.upZipApkHolderStop = (CheckBox) a.c(view, R.id.up_zip_apk_holder_stop, "field 'upZipApkHolderStop'", CheckBox.class);
        upZipApkHolder.upZipApkHolderProgressLv = (LinearLayout) a.c(view, R.id.up_zip_apk_holder_progress_lv, "field 'upZipApkHolderProgressLv'", LinearLayout.class);
        upZipApkHolder.upZipApkHolderLv = (RelativeLayout) a.c(view, R.id.up_zip_apk_holder_lv, "field 'upZipApkHolderLv'", RelativeLayout.class);
        upZipApkHolder.upZipHolderView = a.b(view, R.id.up_zip_holder_view, "field 'upZipHolderView'");
    }

    @CallSuper
    public void a() {
        UpZipApkHolder upZipApkHolder = this.b;
        if (upZipApkHolder != null) {
            this.b = null;
            upZipApkHolder.upZipApkHolderIcon = null;
            upZipApkHolder.upZipApkHolderIntro = null;
            upZipApkHolder.upZipApkHolderGameName = null;
            upZipApkHolder.upZipApkHolderProgress = null;
            upZipApkHolder.upZipApkHolderDelete = null;
            upZipApkHolder.upZipApkHolderProgressPercentage = null;
            upZipApkHolder.upZipApkHolderSpeed = null;
            upZipApkHolder.upZipApkHolderApkSize = null;
            upZipApkHolder.upZipApkHolderStop = null;
            upZipApkHolder.upZipApkHolderProgressLv = null;
            upZipApkHolder.upZipApkHolderLv = null;
            upZipApkHolder.upZipHolderView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
