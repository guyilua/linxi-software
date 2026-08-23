package com.rtk.app.main.HomeCommunityPack;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostSelectGameActivity_ViewBinding implements Unbinder {
    private PostSelectGameActivity b;

    @UiThread
    public PostSelectGameActivity_ViewBinding(PostSelectGameActivity postSelectGameActivity, View view) {
        this.b = postSelectGameActivity;
        postSelectGameActivity.postSelectGameBack = (TextView) butterknife.c.a.c(view, R.id.post_select_game_back, "field 'postSelectGameBack'", TextView.class);
        postSelectGameActivity.postSelectGameTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.post_select_game_top_layout, "field 'postSelectGameTopLayout'", LinearLayout.class);
        postSelectGameActivity.postSelectGameSearchEdit = (EditText) butterknife.c.a.c(view, R.id.post_select_game_searchEdit, "field 'postSelectGameSearchEdit'", EditText.class);
        postSelectGameActivity.postSelectGameSearchBtu = (TextView) butterknife.c.a.c(view, R.id.post_select_game_searchBtu, "field 'postSelectGameSearchBtu'", TextView.class);
        postSelectGameActivity.postSelectGameListView = (AutoListView) butterknife.c.a.c(view, R.id.post_select_game_listView, "field 'postSelectGameListView'", AutoListView.class);
        postSelectGameActivity.postSelectGameTips = (TextView) butterknife.c.a.c(view, R.id.post_select_game_tips, "field 'postSelectGameTips'", TextView.class);
    }

    @CallSuper
    public void a() {
        PostSelectGameActivity postSelectGameActivity = this.b;
        if (postSelectGameActivity != null) {
            this.b = null;
            postSelectGameActivity.postSelectGameBack = null;
            postSelectGameActivity.postSelectGameTopLayout = null;
            postSelectGameActivity.postSelectGameSearchEdit = null;
            postSelectGameActivity.postSelectGameSearchBtu = null;
            postSelectGameActivity.postSelectGameListView = null;
            postSelectGameActivity.postSelectGameTips = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
