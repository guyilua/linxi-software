package com.rtk.app.main.UpModule.UpControlPack;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.YcRecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class YcFileManageActivity_ViewBinding implements Unbinder {
    private YcFileManageActivity b;

    @UiThread
    public YcFileManageActivity_ViewBinding(YcFileManageActivity ycFileManageActivity, View view) {
        this.b = ycFileManageActivity;
        ycFileManageActivity.ycFileManageRecyclerView = (YcRecyclerView) butterknife.c.a.c(view, R.id.yc_file_manage_recyclerView, "field 'ycFileManageRecyclerView'", YcRecyclerView.class);
        ycFileManageActivity.ycFileManageBackBackTV = (TextView) butterknife.c.a.c(view, R.id.yc_file_manage_back_backTV, "field 'ycFileManageBackBackTV'", TextView.class);
        ycFileManageActivity.ycFileManageBackLayout = (LinearLayout) butterknife.c.a.c(view, R.id.yc_file_manage_back_layout, "field 'ycFileManageBackLayout'", LinearLayout.class);
        ycFileManageActivity.ycFileManageFilter = (CheckBox) butterknife.c.a.c(view, R.id.yc_file_manage_filter, "field 'ycFileManageFilter'", CheckBox.class);
        ycFileManageActivity.ycFileManageBackLastPath = (LinearLayout) butterknife.c.a.c(view, R.id.yc_file_manage_back_last_path, "field 'ycFileManageBackLastPath'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        YcFileManageActivity ycFileManageActivity = this.b;
        if (ycFileManageActivity != null) {
            this.b = null;
            ycFileManageActivity.ycFileManageRecyclerView = null;
            ycFileManageActivity.ycFileManageBackBackTV = null;
            ycFileManageActivity.ycFileManageBackLayout = null;
            ycFileManageActivity.ycFileManageFilter = null;
            ycFileManageActivity.ycFileManageBackLastPath = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
