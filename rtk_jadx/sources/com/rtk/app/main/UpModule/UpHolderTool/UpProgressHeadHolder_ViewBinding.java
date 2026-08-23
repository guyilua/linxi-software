package com.rtk.app.main.UpModule.UpHolderTool;

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

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpProgressHeadHolder_ViewBinding implements Unbinder {
    private UpProgressHeadHolder b;

    @UiThread
    public UpProgressHeadHolder_ViewBinding(UpProgressHeadHolder upProgressHeadHolder, View view) {
        this.b = upProgressHeadHolder;
        upProgressHeadHolder.upHeadHolderIcon = (ImageView) butterknife.c.a.c(view, R.id.up_head_holder_icon, "field 'upHeadHolderIcon'", ImageView.class);
        upProgressHeadHolder.upHeadHolderIntro = (TextView) butterknife.c.a.c(view, R.id.up_head_holder_intro, "field 'upHeadHolderIntro'", TextView.class);
        upProgressHeadHolder.upHeadHolderGameName = (TextView) butterknife.c.a.c(view, R.id.up_head_holder_gameName, "field 'upHeadHolderGameName'", TextView.class);
        upProgressHeadHolder.upHeadHolderProgress = (ProgressBar) butterknife.c.a.c(view, R.id.up_head_holder_progress, "field 'upHeadHolderProgress'", ProgressBar.class);
        upProgressHeadHolder.upHeadHolderDelete = (ImageView) butterknife.c.a.c(view, R.id.up_head_holder_delete, "field 'upHeadHolderDelete'", ImageView.class);
        upProgressHeadHolder.upHeadHolderProgressPercentage = (TextView) butterknife.c.a.c(view, R.id.up_head_holder_progress_percentage, "field 'upHeadHolderProgressPercentage'", TextView.class);
        upProgressHeadHolder.upHeadHolderSpeed = (TextView) butterknife.c.a.c(view, R.id.up_head_holder_speed, "field 'upHeadHolderSpeed'", TextView.class);
        upProgressHeadHolder.upHeadHolderApkSize = (TextView) butterknife.c.a.c(view, R.id.up_head_holder_apkSize, "field 'upHeadHolderApkSize'", TextView.class);
        upProgressHeadHolder.upHeadHolderStop = (CheckBox) butterknife.c.a.c(view, R.id.up_head_holder_stop, "field 'upHeadHolderStop'", CheckBox.class);
        upProgressHeadHolder.upHeadHolderProgressLv = (LinearLayout) butterknife.c.a.c(view, R.id.up_head_holder_progress_lv, "field 'upHeadHolderProgressLv'", LinearLayout.class);
        upProgressHeadHolder.upHeadHolderLv = (RelativeLayout) butterknife.c.a.c(view, R.id.up_head_holder_lv, "field 'upHeadHolderLv'", RelativeLayout.class);
    }

    @CallSuper
    public void a() {
        UpProgressHeadHolder upProgressHeadHolder = this.b;
        if (upProgressHeadHolder != null) {
            this.b = null;
            upProgressHeadHolder.upHeadHolderIcon = null;
            upProgressHeadHolder.upHeadHolderIntro = null;
            upProgressHeadHolder.upHeadHolderGameName = null;
            upProgressHeadHolder.upHeadHolderProgress = null;
            upProgressHeadHolder.upHeadHolderDelete = null;
            upProgressHeadHolder.upHeadHolderProgressPercentage = null;
            upProgressHeadHolder.upHeadHolderSpeed = null;
            upProgressHeadHolder.upHeadHolderApkSize = null;
            upProgressHeadHolder.upHeadHolderStop = null;
            upProgressHeadHolder.upHeadHolderProgressLv = null;
            upProgressHeadHolder.upHeadHolderLv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
