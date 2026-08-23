package com.rtk.app.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.zhy.view.flowlayout.TagFlowLayout;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home1ListViewAdapter$ViewHolder_ViewBinding implements Unbinder {
    private Home1ListViewAdapter$ViewHolder b;

    @UiThread
    public Home1ListViewAdapter$ViewHolder_ViewBinding(Home1ListViewAdapter$ViewHolder home1ListViewAdapter$ViewHolder, View view) {
        home1ListViewAdapter$ViewHolder.gameListviewItemIcon = (ImageView) butterknife.c.a.c(view, R.id.game_listview_item_icon, "field 'gameListviewItemIcon'", ImageView.class);
        home1ListViewAdapter$ViewHolder.gameListviewItemProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.game_listview_item_ProgressBar, "field 'gameListviewItemProgressBar'", ProgressBar.class);
        home1ListViewAdapter$ViewHolder.gameListviewItemDownLoad = (TextView) butterknife.c.a.c(view, R.id.game_listview_item_downLoad, "field 'gameListviewItemDownLoad'", TextView.class);
        home1ListViewAdapter$ViewHolder.gameListviewItemGameName = (TextView) butterknife.c.a.c(view, R.id.game_listview_item_GameName, "field 'gameListviewItemGameName'", TextView.class);
        home1ListViewAdapter$ViewHolder.gameListviewItemRang = (ImageView) butterknife.c.a.c(view, R.id.game_listview_item_rang, "field 'gameListviewItemRang'", ImageView.class);
        home1ListViewAdapter$ViewHolder.gameListViewItemVersion = (TextView) butterknife.c.a.c(view, R.id.game_listView_item_version, "field 'gameListViewItemVersion'", TextView.class);
        home1ListViewAdapter$ViewHolder.gameListviewItemTag = (TagFlowLayout) butterknife.c.a.c(view, R.id.game_listview_item_tag, "field 'gameListviewItemTag'", TagFlowLayout.class);
        home1ListViewAdapter$ViewHolder.gameListviewItemType = (TextView) butterknife.c.a.c(view, R.id.game_listview_item_type, "field 'gameListviewItemType'", TextView.class);
        home1ListViewAdapter$ViewHolder.gameListviewItemLanguage = (TextView) butterknife.c.a.c(view, R.id.game_listview_item_language, "field 'gameListviewItemLanguage'", TextView.class);
        home1ListViewAdapter$ViewHolder.gameListviewItemSize = (TextView) butterknife.c.a.c(view, R.id.game_listview_item_size, "field 'gameListviewItemSize'", TextView.class);
    }

    @CallSuper
    public void a() {
        Home1ListViewAdapter$ViewHolder home1ListViewAdapter$ViewHolder = this.b;
        if (home1ListViewAdapter$ViewHolder != null) {
            home1ListViewAdapter$ViewHolder.gameListviewItemIcon = null;
            home1ListViewAdapter$ViewHolder.gameListviewItemProgressBar = null;
            home1ListViewAdapter$ViewHolder.gameListviewItemDownLoad = null;
            home1ListViewAdapter$ViewHolder.gameListviewItemGameName = null;
            home1ListViewAdapter$ViewHolder.gameListviewItemRang = null;
            home1ListViewAdapter$ViewHolder.gameListViewItemVersion = null;
            home1ListViewAdapter$ViewHolder.gameListviewItemTag = null;
            home1ListViewAdapter$ViewHolder.gameListviewItemType = null;
            home1ListViewAdapter$ViewHolder.gameListviewItemLanguage = null;
            home1ListViewAdapter$ViewHolder.gameListviewItemSize = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
