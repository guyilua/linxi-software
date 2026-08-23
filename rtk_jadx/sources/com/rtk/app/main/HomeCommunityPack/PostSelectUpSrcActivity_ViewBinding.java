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
public class PostSelectUpSrcActivity_ViewBinding implements Unbinder {
    private PostSelectUpSrcActivity b;

    @UiThread
    public PostSelectUpSrcActivity_ViewBinding(PostSelectUpSrcActivity postSelectUpSrcActivity, View view) {
        this.b = postSelectUpSrcActivity;
        postSelectUpSrcActivity.postSelectUpSrcTopBack = (TextView) butterknife.c.a.c(view, R.id.post_select_up_src_top_back, "field 'postSelectUpSrcTopBack'", TextView.class);
        postSelectUpSrcActivity.postSelectUpSrcTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.post_select_up_src_top_layout, "field 'postSelectUpSrcTopLayout'", LinearLayout.class);
        postSelectUpSrcActivity.postSelectUpSrcListView = (AutoListView) butterknife.c.a.c(view, R.id.post_select_up_src_listView, "field 'postSelectUpSrcListView'", AutoListView.class);
        postSelectUpSrcActivity.postSelectUpSrcSearchEdit = (EditText) butterknife.c.a.c(view, R.id.post_select_up_src_searchEdit, "field 'postSelectUpSrcSearchEdit'", EditText.class);
        postSelectUpSrcActivity.postSelectUpSrcSearchBtu = (TextView) butterknife.c.a.c(view, R.id.post_select_up_src_searchBtu, "field 'postSelectUpSrcSearchBtu'", TextView.class);
        postSelectUpSrcActivity.postSelectUpSrcTips = (TextView) butterknife.c.a.c(view, R.id.post_select_up_src_tips, "field 'postSelectUpSrcTips'", TextView.class);
    }

    @CallSuper
    public void a() {
        PostSelectUpSrcActivity postSelectUpSrcActivity = this.b;
        if (postSelectUpSrcActivity != null) {
            this.b = null;
            postSelectUpSrcActivity.postSelectUpSrcTopBack = null;
            postSelectUpSrcActivity.postSelectUpSrcTopLayout = null;
            postSelectUpSrcActivity.postSelectUpSrcListView = null;
            postSelectUpSrcActivity.postSelectUpSrcSearchEdit = null;
            postSelectUpSrcActivity.postSelectUpSrcSearchBtu = null;
            postSelectUpSrcActivity.postSelectUpSrcTips = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
