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
public class UpEditProgressHeadHolder_ViewBinding implements Unbinder {
    private UpEditProgressHeadHolder b;

    @UiThread
    public UpEditProgressHeadHolder_ViewBinding(UpEditProgressHeadHolder upEditProgressHeadHolder, View view) {
        this.b = upEditProgressHeadHolder;
        upEditProgressHeadHolder.upHeadHolderIcon = (ImageView) butterknife.c.a.c(view, R.id.up_edit_head_holder_icon, "field 'upHeadHolderIcon'", ImageView.class);
        upEditProgressHeadHolder.upHeadHolderIntro = (TextView) butterknife.c.a.c(view, R.id.up_edit_head_holder_intro, "field 'upHeadHolderIntro'", TextView.class);
        upEditProgressHeadHolder.upHeadHolderGameName = (TextView) butterknife.c.a.c(view, R.id.up_edit_head_holder_gameName, "field 'upHeadHolderGameName'", TextView.class);
        upEditProgressHeadHolder.upHeadHolderProgress = (ProgressBar) butterknife.c.a.c(view, R.id.up_edit_head_holder_progress, "field 'upHeadHolderProgress'", ProgressBar.class);
        upEditProgressHeadHolder.upHeadHolderDelete = (ImageView) butterknife.c.a.c(view, R.id.up_edit_head_holder_delete, "field 'upHeadHolderDelete'", ImageView.class);
        upEditProgressHeadHolder.upHeadHolderProgressPercentage = (TextView) butterknife.c.a.c(view, R.id.up_edit_head_holder_progress_percentage, "field 'upHeadHolderProgressPercentage'", TextView.class);
        upEditProgressHeadHolder.upHeadHolderSpeed = (TextView) butterknife.c.a.c(view, R.id.up_edit_head_holder_speed, "field 'upHeadHolderSpeed'", TextView.class);
        upEditProgressHeadHolder.upHeadHolderApkSize = (TextView) butterknife.c.a.c(view, R.id.up_edit_head_holder_apkSize, "field 'upHeadHolderApkSize'", TextView.class);
        upEditProgressHeadHolder.upHeadHolderStop = (CheckBox) butterknife.c.a.c(view, R.id.up_edit_head_holder_stop, "field 'upHeadHolderStop'", CheckBox.class);
        upEditProgressHeadHolder.upHeadHolderProgressLv = (LinearLayout) butterknife.c.a.c(view, R.id.up_edit_head_holder_progress_lv, "field 'upHeadHolderProgressLv'", LinearLayout.class);
        upEditProgressHeadHolder.upHeadHolderLv = (RelativeLayout) butterknife.c.a.c(view, R.id.up_edit_head_holder_lv, "field 'upHeadHolderLv'", RelativeLayout.class);
    }

    @CallSuper
    public void a() {
        UpEditProgressHeadHolder upEditProgressHeadHolder = this.b;
        if (upEditProgressHeadHolder != null) {
            this.b = null;
            upEditProgressHeadHolder.upHeadHolderIcon = null;
            upEditProgressHeadHolder.upHeadHolderIntro = null;
            upEditProgressHeadHolder.upHeadHolderGameName = null;
            upEditProgressHeadHolder.upHeadHolderProgress = null;
            upEditProgressHeadHolder.upHeadHolderDelete = null;
            upEditProgressHeadHolder.upHeadHolderProgressPercentage = null;
            upEditProgressHeadHolder.upHeadHolderSpeed = null;
            upEditProgressHeadHolder.upHeadHolderApkSize = null;
            upEditProgressHeadHolder.upHeadHolderStop = null;
            upEditProgressHeadHolder.upHeadHolderProgressLv = null;
            upEditProgressHeadHolder.upHeadHolderLv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
