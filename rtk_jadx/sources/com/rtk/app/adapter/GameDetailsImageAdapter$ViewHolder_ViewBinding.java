package com.rtk.app.adapter;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GameDetailsImageAdapter$ViewHolder_ViewBinding implements Unbinder {
    private GameDetailsImageAdapter$ViewHolder b;

    @UiThread
    public GameDetailsImageAdapter$ViewHolder_ViewBinding(GameDetailsImageAdapter$ViewHolder gameDetailsImageAdapter$ViewHolder, View view) {
        gameDetailsImageAdapter$ViewHolder.gameDetailsImageItemImg = (ImageView) butterknife.c.a.c(view, R.id.game_details_image_item_img, "field 'gameDetailsImageItemImg'", ImageView.class);
    }

    @CallSuper
    public void a() {
        GameDetailsImageAdapter$ViewHolder gameDetailsImageAdapter$ViewHolder = this.b;
        if (gameDetailsImageAdapter$ViewHolder != null) {
            gameDetailsImageAdapter$ViewHolder.gameDetailsImageItemImg = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
