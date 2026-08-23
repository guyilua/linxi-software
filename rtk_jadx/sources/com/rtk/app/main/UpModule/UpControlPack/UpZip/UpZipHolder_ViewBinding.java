package com.rtk.app.main.UpModule.UpControlPack.UpZip;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.c.a;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpZipHolder_ViewBinding implements Unbinder {
    private UpZipHolder b;

    @UiThread
    public UpZipHolder_ViewBinding(UpZipHolder upZipHolder, View view) {
        this.b = upZipHolder;
        upZipHolder.upZipHolderIcon = (ImageView) a.c(view, R.id.up_zip_holder_icon, "field 'upZipHolderIcon'", ImageView.class);
        upZipHolder.upZipHolderIntro = (TextView) a.c(view, R.id.up_zip_holder_intro, "field 'upZipHolderIntro'", TextView.class);
        upZipHolder.upZipHolderGameName = (TextView) a.c(view, R.id.up_zip_holder_gameName, "field 'upZipHolderGameName'", TextView.class);
        upZipHolder.upZipHolderProgress = (ProgressBar) a.c(view, R.id.up_zip_holder_progress, "field 'upZipHolderProgress'", ProgressBar.class);
        upZipHolder.upZipHolderDelete = (ImageView) a.c(view, R.id.up_zip_holder_delete, "field 'upZipHolderDelete'", ImageView.class);
        upZipHolder.upZipHolderProgressPercentage = (TextView) a.c(view, R.id.up_zip_holder_progress_percentage, "field 'upZipHolderProgressPercentage'", TextView.class);
        upZipHolder.upZipHolderSpeed = (TextView) a.c(view, R.id.up_zip_holder_speed, "field 'upZipHolderSpeed'", TextView.class);
        upZipHolder.upZipHolderApkSize = (TextView) a.c(view, R.id.up_zip_holder_apkSize, "field 'upZipHolderApkSize'", TextView.class);
        upZipHolder.upZipHolderStop = (CheckBox) a.c(view, R.id.up_zip_holder_stop, "field 'upZipHolderStop'", CheckBox.class);
        upZipHolder.upZipHolderProgressLv = (LinearLayout) a.c(view, R.id.up_zip_holder_progress_lv, "field 'upZipHolderProgressLv'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        UpZipHolder upZipHolder = this.b;
        if (upZipHolder != null) {
            this.b = null;
            upZipHolder.upZipHolderIcon = null;
            upZipHolder.upZipHolderIntro = null;
            upZipHolder.upZipHolderGameName = null;
            upZipHolder.upZipHolderProgress = null;
            upZipHolder.upZipHolderDelete = null;
            upZipHolder.upZipHolderProgressPercentage = null;
            upZipHolder.upZipHolderSpeed = null;
            upZipHolder.upZipHolderApkSize = null;
            upZipHolder.upZipHolderStop = null;
            upZipHolder.upZipHolderProgressLv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
