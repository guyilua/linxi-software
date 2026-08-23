package com.rtk.app.main.HomeCommunityPack;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.YcRecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostSearchForModuleActivity_ViewBinding implements Unbinder {
    private PostSearchForModuleActivity b;

    @UiThread
    public PostSearchForModuleActivity_ViewBinding(PostSearchForModuleActivity postSearchForModuleActivity, View view) {
        this.b = postSearchForModuleActivity;
        postSearchForModuleActivity.postSearchForModuleBack = (TextView) butterknife.c.a.c(view, R.id.post_search_for_module_back, "field 'postSearchForModuleBack'", TextView.class);
        postSearchForModuleActivity.postSearchForModuleSearchEdit = (EditText) butterknife.c.a.c(view, R.id.post_search_for_module_searchEdit, "field 'postSearchForModuleSearchEdit'", EditText.class);
        postSearchForModuleActivity.postSearchForModuleSearchBtu = (ImageView) butterknife.c.a.c(view, R.id.post_search_for_module_searchBtu, "field 'postSearchForModuleSearchBtu'", ImageView.class);
        postSearchForModuleActivity.postSearchForModuleTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.post_search_for_module_top_layout, "field 'postSearchForModuleTopLayout'", LinearLayout.class);
        postSearchForModuleActivity.postSearchForModuleRecyclerView = (YcRecyclerView) butterknife.c.a.c(view, R.id.post_search_for_module_recyclerView, "field 'postSearchForModuleRecyclerView'", YcRecyclerView.class);
        postSearchForModuleActivity.postSearchForModuleSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.post_search_for_module_swipeRefresh, "field 'postSearchForModuleSwipeRefresh'", SwipeRefreshLayout.class);
    }

    @CallSuper
    public void a() {
        PostSearchForModuleActivity postSearchForModuleActivity = this.b;
        if (postSearchForModuleActivity != null) {
            this.b = null;
            postSearchForModuleActivity.postSearchForModuleBack = null;
            postSearchForModuleActivity.postSearchForModuleSearchEdit = null;
            postSearchForModuleActivity.postSearchForModuleSearchBtu = null;
            postSearchForModuleActivity.postSearchForModuleTopLayout = null;
            postSearchForModuleActivity.postSearchForModuleRecyclerView = null;
            postSearchForModuleActivity.postSearchForModuleSwipeRefresh = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
