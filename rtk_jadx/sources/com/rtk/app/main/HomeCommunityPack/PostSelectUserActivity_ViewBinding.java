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
public class PostSelectUserActivity_ViewBinding implements Unbinder {
    private PostSelectUserActivity b;

    @UiThread
    public PostSelectUserActivity_ViewBinding(PostSelectUserActivity postSelectUserActivity, View view) {
        this.b = postSelectUserActivity;
        postSelectUserActivity.postSelectUserTopBack = (TextView) butterknife.c.a.c(view, R.id.post_select_user_top_back, "field 'postSelectUserTopBack'", TextView.class);
        postSelectUserActivity.postSelectUserTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.post_select_user_top_layout, "field 'postSelectUserTopLayout'", LinearLayout.class);
        postSelectUserActivity.postSelectUserTips = (TextView) butterknife.c.a.c(view, R.id.post_select_user_tips, "field 'postSelectUserTips'", TextView.class);
        postSelectUserActivity.postSelectUserListView = (AutoListView) butterknife.c.a.c(view, R.id.post_select_user_listView, "field 'postSelectUserListView'", AutoListView.class);
        postSelectUserActivity.postSelectUserSearchEdit = (EditText) butterknife.c.a.c(view, R.id.post_select_user_searchEdit, "field 'postSelectUserSearchEdit'", EditText.class);
        postSelectUserActivity.postSelectUserSearchBtu = (TextView) butterknife.c.a.c(view, R.id.post_select_user_searchBtu, "field 'postSelectUserSearchBtu'", TextView.class);
    }

    @CallSuper
    public void a() {
        PostSelectUserActivity postSelectUserActivity = this.b;
        if (postSelectUserActivity != null) {
            this.b = null;
            postSelectUserActivity.postSelectUserTopBack = null;
            postSelectUserActivity.postSelectUserTopLayout = null;
            postSelectUserActivity.postSelectUserTips = null;
            postSelectUserActivity.postSelectUserListView = null;
            postSelectUserActivity.postSelectUserSearchEdit = null;
            postSelectUserActivity.postSelectUserSearchBtu = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
