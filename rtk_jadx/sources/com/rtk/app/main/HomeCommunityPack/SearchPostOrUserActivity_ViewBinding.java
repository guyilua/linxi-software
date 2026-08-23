package com.rtk.app.main.HomeCommunityPack;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;
import com.rtk.app.custom.BaseViewPager;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SearchPostOrUserActivity_ViewBinding implements Unbinder {
    private SearchPostOrUserActivity b;

    @UiThread
    public SearchPostOrUserActivity_ViewBinding(SearchPostOrUserActivity searchPostOrUserActivity, View view) {
        this.b = searchPostOrUserActivity;
        searchPostOrUserActivity.searchPostOrUserBack = (TextView) butterknife.c.a.c(view, R.id.search_post_or_user_back, "field 'searchPostOrUserBack'", TextView.class);
        searchPostOrUserActivity.searchPostOrUserSearchEdit = (EditText) butterknife.c.a.c(view, R.id.search_post_or_user_searchEdit, "field 'searchPostOrUserSearchEdit'", EditText.class);
        searchPostOrUserActivity.searchPostOrUserSearchBtu = (ImageView) butterknife.c.a.c(view, R.id.search_post_or_user_searchBtu, "field 'searchPostOrUserSearchBtu'", ImageView.class);
        searchPostOrUserActivity.searchPostOrUserTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.search_post_or_user_top_layout, "field 'searchPostOrUserTopLayout'", LinearLayout.class);
        searchPostOrUserActivity.searchPostOrUserTabLayout = (TabLayout) butterknife.c.a.c(view, R.id.search_post_or_user_tabLayout, "field 'searchPostOrUserTabLayout'", TabLayout.class);
        searchPostOrUserActivity.searchPostOrUserViewPager = (BaseViewPager) butterknife.c.a.c(view, R.id.search_post_or_user_viewPager, "field 'searchPostOrUserViewPager'", BaseViewPager.class);
    }

    @CallSuper
    public void a() {
        SearchPostOrUserActivity searchPostOrUserActivity = this.b;
        if (searchPostOrUserActivity != null) {
            this.b = null;
            searchPostOrUserActivity.searchPostOrUserBack = null;
            searchPostOrUserActivity.searchPostOrUserSearchEdit = null;
            searchPostOrUserActivity.searchPostOrUserSearchBtu = null;
            searchPostOrUserActivity.searchPostOrUserTopLayout = null;
            searchPostOrUserActivity.searchPostOrUserTabLayout = null;
            searchPostOrUserActivity.searchPostOrUserViewPager = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
