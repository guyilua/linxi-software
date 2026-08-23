package com.rtk.app.main.MainActivityPack.HomePageItem1Pack;

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
public class GameListHolder_ViewBinding implements Unbinder {
    private GameListHolder b;

    @UiThread
    public GameListHolder_ViewBinding(GameListHolder gameListHolder, View view) {
        this.b = gameListHolder;
        gameListHolder.gameListviewItemIcon = (ImageView) butterknife.c.a.c(view, R.id.game_listview_item_icon, "field 'gameListviewItemIcon'", ImageView.class);
        gameListHolder.gameListviewItemProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.game_listview_item_ProgressBar, "field 'gameListviewItemProgressBar'", ProgressBar.class);
        gameListHolder.gameListviewItemDownLoad = (TextView) butterknife.c.a.c(view, R.id.game_listview_item_downLoad, "field 'gameListviewItemDownLoad'", TextView.class);
        gameListHolder.gameListviewItemGameName = (TextView) butterknife.c.a.c(view, R.id.game_listview_item_GameName, "field 'gameListviewItemGameName'", TextView.class);
        gameListHolder.gameListviewItemRang = (ImageView) butterknife.c.a.c(view, R.id.game_listview_item_rang, "field 'gameListviewItemRang'", ImageView.class);
        gameListHolder.gameListViewItemVersion = (TextView) butterknife.c.a.c(view, R.id.game_listView_item_version, "field 'gameListViewItemVersion'", TextView.class);
        gameListHolder.gameListviewItemTag = (TagFlowLayout) butterknife.c.a.c(view, R.id.game_listview_item_tag, "field 'gameListviewItemTag'", TagFlowLayout.class);
        gameListHolder.gameListviewItemType = (TextView) butterknife.c.a.c(view, R.id.game_listview_item_type, "field 'gameListviewItemType'", TextView.class);
        gameListHolder.gameListviewItemLanguage = (TextView) butterknife.c.a.c(view, R.id.game_listview_item_language, "field 'gameListviewItemLanguage'", TextView.class);
        gameListHolder.gameListviewItemSize = (TextView) butterknife.c.a.c(view, R.id.game_listview_item_size, "field 'gameListviewItemSize'", TextView.class);
    }

    @CallSuper
    public void a() {
        GameListHolder gameListHolder = this.b;
        if (gameListHolder != null) {
            this.b = null;
            gameListHolder.gameListviewItemIcon = null;
            gameListHolder.gameListviewItemProgressBar = null;
            gameListHolder.gameListviewItemDownLoad = null;
            gameListHolder.gameListviewItemGameName = null;
            gameListHolder.gameListviewItemRang = null;
            gameListHolder.gameListViewItemVersion = null;
            gameListHolder.gameListviewItemTag = null;
            gameListHolder.gameListviewItemType = null;
            gameListHolder.gameListviewItemLanguage = null;
            gameListHolder.gameListviewItemSize = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
