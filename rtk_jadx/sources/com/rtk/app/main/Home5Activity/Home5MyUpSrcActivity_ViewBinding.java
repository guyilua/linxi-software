package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.custom.MarkedImageView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home5MyUpSrcActivity_ViewBinding implements Unbinder {
    private Home5MyUpSrcActivity b;

    @UiThread
    public Home5MyUpSrcActivity_ViewBinding(Home5MyUpSrcActivity home5MyUpSrcActivity, View view) {
        this.b = home5MyUpSrcActivity;
        home5MyUpSrcActivity.home5MyUpSrcTopBack = (TextView) butterknife.c.a.c(view, R.id.home5_my_up_src_top_back, "field 'home5MyUpSrcTopBack'", TextView.class);
        home5MyUpSrcActivity.home5MyUpSrcTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.home5_my_up_src_top_layout, "field 'home5MyUpSrcTopLayout'", LinearLayout.class);
        home5MyUpSrcActivity.home5MyUpSrcListView = (AutoListView) butterknife.c.a.c(view, R.id.home5_my_up_src_listView, "field 'home5MyUpSrcListView'", AutoListView.class);
        home5MyUpSrcActivity.home5MyUpSrcTopResLibrary = (TextView) butterknife.c.a.c(view, R.id.home5_my_up_src_top_resLibrary, "field 'home5MyUpSrcTopResLibrary'", TextView.class);
        home5MyUpSrcActivity.home5MyUpSrcUpBtu = (ImageView) butterknife.c.a.c(view, R.id.home5_my_up_src_upBtu, "field 'home5MyUpSrcUpBtu'", ImageView.class);
        home5MyUpSrcActivity.home5MyUpSrcShowStyle = (RadioGroup) butterknife.c.a.c(view, R.id.home5_my_up_src_show_style, "field 'home5MyUpSrcShowStyle'", RadioGroup.class);
        home5MyUpSrcActivity.home5MyUpSrcShowStyleAll = (RadioButton) butterknife.c.a.c(view, R.id.home5_my_up_src_show_style_all, "field 'home5MyUpSrcShowStyleAll'", RadioButton.class);
        home5MyUpSrcActivity.home5MyUpSrcShowStyleNoDelete = (RadioButton) butterknife.c.a.c(view, R.id.home5_my_up_src_show_style_no_delete, "field 'home5MyUpSrcShowStyleNoDelete'", RadioButton.class);
        home5MyUpSrcActivity.home5MyUpSrcCopyUrl = (TextView) butterknife.c.a.c(view, R.id.home5_my_up_src_copy_url, "field 'home5MyUpSrcCopyUrl'", TextView.class);
        home5MyUpSrcActivity.home5MyUpSrcShareAllUp = (TextView) butterknife.c.a.c(view, R.id.home5_my_up_src_share_all_up, "field 'home5MyUpSrcShareAllUp'", TextView.class);
        home5MyUpSrcActivity.home5MyUpSrcShareLv = (LinearLayout) butterknife.c.a.c(view, R.id.home5_my_up_src_share_lv, "field 'home5MyUpSrcShareLv'", LinearLayout.class);
        home5MyUpSrcActivity.home5MyUpSrcTopMyUpLoading = (MarkedImageView) butterknife.c.a.c(view, R.id.home5_my_up_src_top_my_up_loading, "field 'home5MyUpSrcTopMyUpLoading'", MarkedImageView.class);
    }

    @CallSuper
    public void a() {
        Home5MyUpSrcActivity home5MyUpSrcActivity = this.b;
        if (home5MyUpSrcActivity != null) {
            this.b = null;
            home5MyUpSrcActivity.home5MyUpSrcTopBack = null;
            home5MyUpSrcActivity.home5MyUpSrcTopLayout = null;
            home5MyUpSrcActivity.home5MyUpSrcListView = null;
            home5MyUpSrcActivity.home5MyUpSrcTopResLibrary = null;
            home5MyUpSrcActivity.home5MyUpSrcUpBtu = null;
            home5MyUpSrcActivity.home5MyUpSrcShowStyle = null;
            home5MyUpSrcActivity.home5MyUpSrcShowStyleAll = null;
            home5MyUpSrcActivity.home5MyUpSrcShowStyleNoDelete = null;
            home5MyUpSrcActivity.home5MyUpSrcCopyUrl = null;
            home5MyUpSrcActivity.home5MyUpSrcShareAllUp = null;
            home5MyUpSrcActivity.home5MyUpSrcShareLv = null;
            home5MyUpSrcActivity.home5MyUpSrcTopMyUpLoading = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
