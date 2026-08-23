package com.rtk.app.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GameGridViewAdapter$ViewHolder_ViewBinding implements Unbinder {
    private GameGridViewAdapter$ViewHolder b;

    @UiThread
    public GameGridViewAdapter$ViewHolder_ViewBinding(GameGridViewAdapter$ViewHolder gameGridViewAdapter$ViewHolder, View view) {
        gameGridViewAdapter$ViewHolder.gameGridviewItemImg = (ImageView) butterknife.c.a.c(view, R.id.game_gridview_item_img, "field 'gameGridviewItemImg'", ImageView.class);
        gameGridViewAdapter$ViewHolder.gameGridviewItemName = (TextView) butterknife.c.a.c(view, R.id.game_gridview_item_name, "field 'gameGridviewItemName'", TextView.class);
    }

    @CallSuper
    public void a() {
        GameGridViewAdapter$ViewHolder gameGridViewAdapter$ViewHolder = this.b;
        if (gameGridViewAdapter$ViewHolder != null) {
            gameGridViewAdapter$ViewHolder.gameGridviewItemImg = null;
            gameGridViewAdapter$ViewHolder.gameGridviewItemName = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
