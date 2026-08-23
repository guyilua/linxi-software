package com.rtk.app.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home1Item1GameGridViewAdapter$GameGridViewHolder_ViewBinding implements Unbinder {
    private Home1Item1GameGridViewAdapter$GameGridViewHolder b;

    @UiThread
    public Home1Item1GameGridViewAdapter$GameGridViewHolder_ViewBinding(Home1Item1GameGridViewAdapter$GameGridViewHolder home1Item1GameGridViewAdapter$GameGridViewHolder, View view) {
        this.b = home1Item1GameGridViewAdapter$GameGridViewHolder;
        home1Item1GameGridViewAdapter$GameGridViewHolder.home1Item1GameGridviewItemIcon = (ImageView) butterknife.c.a.c(view, R.id.home1_item1_game_gridview_item_icon, "field 'home1Item1GameGridviewItemIcon'", ImageView.class);
        home1Item1GameGridViewAdapter$GameGridViewHolder.home1Item1GameGridviewItemName = (TextView) butterknife.c.a.c(view, R.id.home1_item1_game_gridview_item_name, "field 'home1Item1GameGridviewItemName'", TextView.class);
        home1Item1GameGridViewAdapter$GameGridViewHolder.home1Item1GameGridviewItemProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.home1_item1_game_gridview_item_ProgressBar, "field 'home1Item1GameGridviewItemProgressBar'", ProgressBar.class);
        home1Item1GameGridViewAdapter$GameGridViewHolder.home1Item1GameGridviewItemDownLoad = (TextView) butterknife.c.a.c(view, R.id.home1_item1_game_gridview_item_downLoad, "field 'home1Item1GameGridviewItemDownLoad'", TextView.class);
        home1Item1GameGridViewAdapter$GameGridViewHolder.home1Item1GameGridviewItemDownLoadLv = (RelativeLayout) butterknife.c.a.c(view, R.id.home1_item1_game_gridview_item_downLoad_lv, "field 'home1Item1GameGridviewItemDownLoadLv'", RelativeLayout.class);
    }

    @CallSuper
    public void a() {
        Home1Item1GameGridViewAdapter$GameGridViewHolder home1Item1GameGridViewAdapter$GameGridViewHolder = this.b;
        if (home1Item1GameGridViewAdapter$GameGridViewHolder != null) {
            this.b = null;
            home1Item1GameGridViewAdapter$GameGridViewHolder.home1Item1GameGridviewItemIcon = null;
            home1Item1GameGridViewAdapter$GameGridViewHolder.home1Item1GameGridviewItemName = null;
            home1Item1GameGridViewAdapter$GameGridViewHolder.home1Item1GameGridviewItemProgressBar = null;
            home1Item1GameGridViewAdapter$GameGridViewHolder.home1Item1GameGridviewItemDownLoad = null;
            home1Item1GameGridViewAdapter$GameGridViewHolder.home1Item1GameGridviewItemDownLoadLv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
